/*
 * This file was generated from the database schema.
 */
package name.martingeisse.electronics_game.postgres_entities;

import com.querydsl.sql.dml.SQLInsertClause;
import name.martingeisse.electronics_game.platform.postgres.PostgresConnection;
import java.io.Serializable;

/**
 * This class represents rows from table 'DesignPart'.
 */
public class DesignPartRow implements Serializable {

    /**
     * Constructor.
     */
    public DesignPartRow() {
    }

    /**
     * the configuration
     */
    private name.martingeisse.electronics_game.tools.codegen.PostgresJsonb configuration;

    /**
     * the designId
     */
    private Long designId;

    /**
     * the id
     */
    private Long id;

    /**
     * the partType
     */
    private String partType;

    /**
     * the x
     */
    private Integer x;

    /**
     * the y
     */
    private Integer y;

    /**
     * Getter method for the configuration.
     * 
     * @return the configuration
     */
    public name.martingeisse.electronics_game.tools.codegen.PostgresJsonb getConfiguration() {
        return configuration;
    }

    /**
     * Setter method for the configuration.
     * 
     * @param configuration the configuration to set
     */
    public void setConfiguration(name.martingeisse.electronics_game.tools.codegen.PostgresJsonb configuration) {
        this.configuration = configuration;
    }

    /**
     * Getter method for the designId.
     * 
     * @return the designId
     */
    public Long getDesignId() {
        return designId;
    }

    /**
     * Setter method for the designId.
     * 
     * @param designId the designId to set
     */
    public void setDesignId(Long designId) {
        this.designId = designId;
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
     * Getter method for the partType.
     * 
     * @return the partType
     */
    public String getPartType() {
        return partType;
    }

    /**
     * Setter method for the partType.
     * 
     * @param partType the partType to set
     */
    public void setPartType(String partType) {
        this.partType = partType;
    }

    /**
     * Getter method for the x.
     * 
     * @return the x
     */
    public Integer getX() {
        return x;
    }

    /**
     * Setter method for the x.
     * 
     * @param x the x to set
     */
    public void setX(Integer x) {
        this.x = x;
    }

    /**
     * Getter method for the y.
     * 
     * @return the y
     */
    public Integer getY() {
        return y;
    }

    /**
     * Setter method for the y.
     * 
     * @param y the y to set
     */
    public void setY(Integer y) {
        this.y = y;
    }

    /**
     * Loads the instance with the specified ID.
     * 
     * @param connection the database connection
     * @param id the ID of the instance to load
     * @return the loaded instance
     */
    public static DesignPartRow loadById(PostgresConnection connection, Long id) {
        QDesignPartRow q = QDesignPartRow.DesignPart;
        return connection.query().select(q).from(q).where(q.id.eq(id)).fetchFirst();
    }

    /**
     * Inserts this instance into the database. This object must not have an ID yet.
     */
    public void insert(PostgresConnection connection) {
        if (id != null) {
        	throw new IllegalStateException("this object already has an id: " + id);
        }
        QDesignPartRow q = QDesignPartRow.DesignPart;
        SQLInsertClause insert = connection.insert(q);
        insert.set(q.configuration, configuration);
        insert.set(q.designId, designId);
        insert.set(q.partType, partType);
        insert.set(q.x, x);
        insert.set(q.y, y);
        id = insert.executeWithKey(Long.class);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "{DesignPartRow. configuration = " + configuration + ", designId = " + designId + ", id = " + id + ", partType = " + partType + ", x = " + x + ", y = " + y + "}";
    }

}

