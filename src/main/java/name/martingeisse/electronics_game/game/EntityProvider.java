package name.martingeisse.electronics_game.game;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import name.martingeisse.electronics_game.game.event.GameEventEmitter;
import name.martingeisse.electronics_game.game.jackson.JacksonService;
import name.martingeisse.electronics_game.game.player.Player;
import name.martingeisse.electronics_game.game.player.PlayerRepository;
import name.martingeisse.electronics_game.platform.postgres.PostgresContextService;

/**
 * Allows to get arbitrary game entities by ID, injecting their dependencies.
 * <p>
 * This class was introduced as an improvement over the previous repository-based system. In that previous system,
 * a separate repository was used for each entity type. This runs contrary to the idea that non-root entities can be
 * obtained via relationships, starting from other entities. The practical consequence was that all entities had
 * numerous repositories as dependencies.
 */
@Singleton
public class EntityProvider {

	private final Provider<PostgresContextService> postgresContextServiceProvider;
	private final Provider<JacksonService> jacksonServiceProvider;
	private final Provider<GameEventEmitter> gameEventEmitterProvider;
	private final Provider<PlayerRepository> playerRepositoryProvider;

	@Inject
	public EntityProvider(Provider<PostgresContextService> postgresContextServiceProvider, Provider<JacksonService> jacksonServiceProvider, Provider<GameEventEmitter> gameEventEmitterProvider, Provider<PlayerRepository> playerRepositoryProvider) {
		this.postgresContextServiceProvider = postgresContextServiceProvider;
		this.jacksonServiceProvider = jacksonServiceProvider;
		this.gameEventEmitterProvider = gameEventEmitterProvider;
		this.playerRepositoryProvider = playerRepositoryProvider;
	}

	public Player getPlayer(long id) {
		return playerRepositoryProvider.get().getPlayerById(id);
	}

}
