/*
 * This file was generated from the database schema.
 */
package name.martingeisse.electronics_game.postgres_entities;

import com.querydsl.sql.dml.SQLInsertClause;
import name.martingeisse.electronics_game.platform.postgres.PostgresConnection;
import java.io.Serializable;

/**
 * This class represents rows from table 'Player'.
 */
public class PlayerRow implements Serializable {

    /**
     * Constructor.
     */
    public PlayerRow() {
    }

    /**
     * the emailAddress
     */
    private String emailAddress;

    /**
     * the id
     */
    private Long id;

    /**
     * the loginToken
     */
    private String loginToken;

    /**
     * the name
     */
    private String name;

    /**
     * Getter method for the emailAddress.
     * 
     * @return the emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Setter method for the emailAddress.
     * 
     * @param emailAddress the emailAddress to set
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

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
     * Getter method for the loginToken.
     * 
     * @return the loginToken
     */
    public String getLoginToken() {
        return loginToken;
    }

    /**
     * Setter method for the loginToken.
     * 
     * @param loginToken the loginToken to set
     */
    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken;
    }

    /**
     * Getter method for the name.
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for the name.
     * 
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Loads the instance with the specified ID.
     * 
     * @param connection the database connection
     * @param id the ID of the instance to load
     * @return the loaded instance
     */
    public static PlayerRow loadById(PostgresConnection connection, Long id) {
        QPlayerRow q = QPlayerRow.Player;
        return connection.query().select(q).from(q).where(q.id.eq(id)).fetchFirst();
    }

    /**
     * Inserts this instance into the database. This object must not have an ID yet.
     */
    public void insert(PostgresConnection connection) {
        if (id != null) {
        	throw new IllegalStateException("this object already has an id: " + id);
        }
        QPlayerRow q = QPlayerRow.Player;
        SQLInsertClause insert = connection.insert(q);
        insert.set(q.emailAddress, emailAddress);
        insert.set(q.loginToken, loginToken);
        insert.set(q.name, name);
        id = insert.executeWithKey(Long.class);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "{PlayerRow. emailAddress = " + emailAddress + ", id = " + id + ", loginToken = " + loginToken + ", name = " + name + "}";
    }

}

