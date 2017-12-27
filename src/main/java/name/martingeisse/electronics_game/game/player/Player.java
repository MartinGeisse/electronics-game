package name.martingeisse.electronics_game.game.player;

import com.fasterxml.jackson.annotation.JsonValue;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Path;
import name.martingeisse.electronics_game.game.EntityProvider;
import name.martingeisse.electronics_game.game.NameAlreadyUsedException;
import name.martingeisse.electronics_game.game.jackson.JacksonService;
import name.martingeisse.electronics_game.platform.postgres.PostgresContextService;
import name.martingeisse.electronics_game.postgres_entities.PlayerRow;
import name.martingeisse.electronics_game.postgres_entities.QPlayerRow;

/**
 *
 */
public final class Player {

	private final PlayerRepository playerRepository;
	private final PostgresContextService postgresContextService;
	private final EntityProvider entityProvider;
	private final JacksonService jacksonService;
	private final long id;

	public Player(PlayerRepository playerRepository, PostgresContextService postgresContextService, EntityProvider entityProvider, JacksonService jacksonService, PlayerRow playerRow) {
		this.playerRepository = playerRepository;
		this.postgresContextService = postgresContextService;
		this.entityProvider = entityProvider;
		this.jacksonService = jacksonService;
		this.id = playerRow.getId();
	}

	@JsonValue
	public long getId() {
		return id;
	}

	private <T> T getField(Path<T> path) {
		QPlayerRow qp = QPlayerRow.Player;
		return postgresContextService.select(path).from(qp).where(qp.id.eq(id)).fetchFirst();
	}

	private <T> void setField(Path<T> path, T newValue) {
		QPlayerRow qp = QPlayerRow.Player;
		postgresContextService.update(qp).set(path, newValue).where(qp.id.eq(id)).execute();
	}

	private <T> void setField(Path<T> path, Expression<T> newValue) {
		QPlayerRow qp = QPlayerRow.Player;
		postgresContextService.update(qp).set(path, newValue).where(qp.id.eq(id)).execute();
	}

	public String getName() {
		return getField(QPlayerRow.Player.name);
	}

	/**
	 * Setter method.
	 *
	 * @param name the name
	 */
	public void renameTo(String name) throws NameAlreadyUsedException {
		if (name == null) {
			throw new IllegalArgumentException("name cannot be null");
		}
		if (!playerRepository.isRenamePossible(getId(), name)) {
			throw new NameAlreadyUsedException();
		}
		setField(QPlayerRow.Player.name, name);
	}

	public String getLoginToken() {
		return getField(QPlayerRow.Player.loginToken);
	}

	public void setLoginToken(String loginToken) {
		setField(QPlayerRow.Player.loginToken, loginToken);
	}

	public String getEmailAddress() {
		return getField(QPlayerRow.Player.emailAddress);
	}

	public void setEmailAddress(String emailAddress) {
		setField(QPlayerRow.Player.emailAddress, emailAddress);
	}

}
