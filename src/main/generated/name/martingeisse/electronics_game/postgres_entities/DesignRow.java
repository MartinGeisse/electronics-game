/*
 * This file was generated from the database schema.
 */
package name.martingeisse.electronics_game.postgres_entities;

import com.querydsl.sql.dml.SQLInsertClause;
import name.martingeisse.electronics_game.platform.postgres.PostgresConnection;
import java.io.Serializable;

/**
 * This class represents rows from table 'Design'.
 */
public class DesignRow implements Serializable {

    /**
     * Constructor.
     */
    public DesignRow() {
    }

    /**
     * the id
     */
    private Long id;

    /**
     * Getter method for the id.
     * 
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter method for the id.
     * 
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Loads the instance with the specified ID.
     * 
     * @param connection the database connection
     * @param id the ID of the instance to load
     * @return the loaded instance
     */
    public static DesignRow loadById(PostgresConnection connection, Long id) {
        QDesignRow q = QDesignRow.Design;
        return connection.query().select(q).from(q).where(q.id.eq(id)).fetchFirst();
    }

    /**
     * Inserts this instance into the database. This object must not have an ID yet.
     */
    public void insert(PostgresConnection connection) {
        if (id != null) {
        	throw new IllegalStateException("this object already has an id: " + id);
        }
        QDesignRow q = QDesignRow.Design;
        SQLInsertClause insert = connection.insert(q);
        id = insert.executeWithKey(Long.class);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "{DesignRow. id = " + id + "}";
    }

}

