package name.martingeisse.electronics_game.postgres_entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QDesignPartRow is a Querydsl query type for DesignPartRow
 */
@Generated("name.martingeisse.electronics_game.tools.codegen.MyMetaDataSerializer")
@SuppressWarnings("all")
public class QDesignPartRow extends com.querydsl.sql.RelationalPathBase<DesignPartRow> {

    private static final long serialVersionUID = 342283428;

    public static final QDesignPartRow DesignPart = new QDesignPartRow("DesignPart");

    public final SimplePath<name.martingeisse.electronics_game.tools.codegen.PostgresJsonb> configuration = createSimple("configuration", name.martingeisse.electronics_game.tools.codegen.PostgresJsonb.class);

    public final NumberPath<Long> designId = createNumber("designId", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath partType = createString("partType");

    public final NumberPath<Integer> x = createNumber("x", Integer.class);

    public final NumberPath<Integer> y = createNumber("y", Integer.class);

    public final com.querydsl.sql.PrimaryKey<DesignPartRow> designPartPkey = createPrimaryKey(id);

    public final com.querydsl.sql.ForeignKey<DesignRow> designPartDesignIdFkey = createForeignKey(designId, "id");

    public QDesignPartRow(String variable) {
        super(DesignPartRow.class, forVariable(variable), "electronics_game", "DesignPart");
        addMetadata();
    }

    public QDesignPartRow(String variable, String schema, String table) {
        super(DesignPartRow.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QDesignPartRow(Path<? extends DesignPartRow> path) {
        super(path.getType(), path.getMetadata(), "electronics_game", "DesignPart");
        addMetadata();
    }

    public QDesignPartRow(PathMetadata metadata) {
        super(DesignPartRow.class, metadata, "electronics_game", "DesignPart");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(configuration, ColumnMetadata.named("configuration").withIndex(6).ofType(Types.OTHER).withSize(2147483647).notNull());
        addMetadata(designId, ColumnMetadata.named("designId").withIndex(2).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(partType, ColumnMetadata.named("partType").withIndex(3).ofType(Types.VARCHAR).withSize(2147483647).notNull());
        addMetadata(x, ColumnMetadata.named("x").withIndex(4).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(y, ColumnMetadata.named("y").withIndex(5).ofType(Types.INTEGER).withSize(10).notNull());
    }

}

