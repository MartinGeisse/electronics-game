package name.martingeisse.electronics_game.game.player;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import name.martingeisse.electronics_game.game.EntityProvider;
import name.martingeisse.electronics_game.platform.postgres.PostgresContextService;
import name.martingeisse.electronics_game.postgres_entities.PlayerRow;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 */
@Singleton
public class PlayerFactory {

	private final PostgresContextService postgresContextService;
	private final EntityProvider entityProvider;

	@Inject
	public PlayerFactory(PostgresContextService postgresContextService, EntityProvider entityProvider) {
		this.postgresContextService = postgresContextService;
		this.entityProvider = entityProvider;
	}

	/**
	 * Creates a new player.
	 *
	 * @return the ID of the newly created player
	 */
	public Player createPlayer() {
		PlayerRow data = new PlayerRow();
		data.setName("noname");
		data.setLoginToken(RandomStringUtils.randomAlphanumeric(50));
		data.insert(postgresContextService.getConnection());
		return entityProvider.getPlayer(data.getId());
	}

}
