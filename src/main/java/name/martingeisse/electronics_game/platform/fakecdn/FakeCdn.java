/**
 * Copyright (c) 2010 Martin Geisse
 * <p>
 * This file is distributed under the terms of the MIT license.
 */

package name.martingeisse.electronics_game.platform.fakecdn;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Implements a fake CDN for testing.
 */
public final class FakeCdn {

	/**
	 * the cache
	 */
	private final ConcurrentHashMap<String, FakeCdnRecord> cache = new ConcurrentHashMap<String, FakeCdnRecord>();

	/**
	 * Constructor.
	 */
	public FakeCdn() {
	}

	/**
	 * Requests an entity from the CDN. If the entity is not yet stored,
	 * it is fetched. The response is stored, whether it is a successful
	 * or failed response; only redirect-responses are resolved by another
	 * request. If fetching the entity fails so hard that no response is
	 * even available (e.g. server not reached), a fake 404 response is
	 * built.
	 *
	 * @param key the storage key
	 * @return the record for the entity
	 */
	public FakeCdnRecord request(String key) {
		FakeCdnRecord record = cache.get(key);
		if (record == null) {
			try {
				record = fetch(key);
			} catch (IOException e) {
				record = new FakeCdnRecord(404, key, "text/plain; charset=UTF-8", "could not connect to server".getBytes(StandardCharsets.UTF_8));
			}
			cache.put(key, record);
		}
		return record;
	}

	/**
	 *
	 */
	private FakeCdnRecord fetch(String key) throws IOException {
		HttpResponse response = fetchResponse("http://localhost" + key);
		byte[] data;
		try (InputStream responseStream = response.getEntity().getContent()) {
			data = IOUtils.toByteArray(responseStream);
		}
		return new FakeCdnRecord(response.getStatusLine().getStatusCode(), key, response.getFirstHeader("Content-Type").getValue(), data);
	}

	/**
	 *
	 */
	private HttpResponse fetchResponse(String url) throws IOException {

		// TODO inject HttpClient

		HttpClientConnectionManager connectionManager = new BasicHttpClientConnectionManager();
		HttpClient client = HttpClients.custom().setConnectionManager(connectionManager).setDefaultCookieStore(new NullCookieStore()).build();
		for (int i = 0; i < 10; i++) {
			HttpUriRequest request = new HttpGet(url);
			HttpResponse response = client.execute(request);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode < 300 || statusCode >= 400) {
				return response;
			}
			url = response.getFirstHeader("Location").getValue();
			if (url == null) {
				throw new IOException("redirect without location header");
			}
		}
		throw new IOException("too many redirects");
	}

}
