package name.martingeisse.electronics_game.game.event;

/**
 * TODO should have two subclasses:
 * <p>
 * DatabaseEvent is fired for changes in the database, containing the row,
 * new data, maybe old data or delta. Does not contain information what
 * happens on a higher level or WHY the database was changed that way.
 * <p>
 * DomainEvent is fired when something happens beyond changes in data. Contains
 * domain-level information what happens and why. Does not indicate new data,
 * since DatabaseEvent already does that.
 * <p>
 * This way there is no redundancy in the event classes.
 * <p>
 * However, this will only work if all database changes are captured including all
 * data, which requires database support.
 */
public abstract class GameEvent {
}
