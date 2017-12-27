package name.martingeisse.electronics_game.postgres_entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QDesignRow is a Querydsl query type for DesignRow
 */
@Generated("name.martingeisse.electronics_game.tools.codegen.MyMetaDataSerializer")
@SuppressWarnings("all")
public class QDesignRow extends com.querydsl.sql.RelationalPathBase<DesignRow> {

    private static final long serialVersionUID = -1834778601;

    public static final QDesignRow Design = new QDesignRow("Design");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.querydsl.sql.PrimaryKey<DesignRow> designPkey = createPrimaryKey(id);

    public final com.querydsl.sql.ForeignKey<DesignPartRow> _designPartDesignIdFkey = createInvForeignKey(id, "designId");

    public QDesignRow(String variable) {
        super(DesignRow.class, forVariable(variable), "electronics_game", "Design");
        addMetadata();
    }

    public QDesignRow(String variable, String schema, String table) {
        super(DesignRow.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QDesignRow(Path<? extends DesignRow> path) {
        super(path.getType(), path.getMetadata(), "electronics_game", "Design");
        addMetadata();
    }

    public QDesignRow(PathMetadata metadata) {
        super(DesignRow.class, metadata, "electronics_game", "Design");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
    }

}

