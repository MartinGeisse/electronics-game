/**
 * Copyright (c) 2016 Martin Geisse
 * <p>
 * This file is distributed under the terms of the MIT license.
 */
package name.martingeisse.electronics_game.platform.application;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.multibindings.Multibinder;
import name.martingeisse.electronics_game.game.event.GameEventListener;
import name.martingeisse.electronics_game.platform.application.configuration.ConfigurationParticipant;
import name.martingeisse.electronics_game.platform.postgres.PostgresService;

/**
 *
 */
public abstract class AbstractApplicationModule extends AbstractModule {

	@Override
	protected void configure() {

		// configuration participants
		defineExtensionPoint(ConfigurationParticipant.class);
		extend(ConfigurationParticipant.class, PostgresService.class);

		// game listeners
		defineExtensionPoint(GameEventListener.class);

	}

	/**
	 * Defines an extension point.
	 *
	 * @param extensionPointInterface the interface that extensions for the defined
	 *                                extension point must implement
	 */
	public <T> void defineExtensionPoint(Class<T> extensionPointInterface) {
		Multibinder.newSetBinder(binder(), extensionPointInterface);
	}

	/**
	 * Adds an extension for an extension point.
	 * <p>
	 * The extension must be an instantiable class that implements the extension point
	 * interface.
	 * <p>
	 * Creating a concrete implementation is done by Guice, so it will have its dependencies
	 * injected. Decorate the extension class with {@link Inject} and scope annotations
	 * as usual for Guice.
	 * <p>
	 * There is no requirement that the extension point gets defined *before* all its
	 * extensions, only that it gets defined at some point.
	 *
	 * @param extensionPointInterface the extension point interface
	 * @param extensionClass          the concrete implementation class for this extension
	 */
	public <T> void extend(Class<T> extensionPointInterface, Class<? extends T> extensionClass) {
		Multibinder.newSetBinder(binder(), extensionPointInterface).addBinding().to(extensionClass);
	}

}
