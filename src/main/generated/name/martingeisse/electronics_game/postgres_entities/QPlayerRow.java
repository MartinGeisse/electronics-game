package name.martingeisse.electronics_game.postgres_entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QPlayerRow is a Querydsl query type for PlayerRow
 */
@Generated("name.martingeisse.electronics_game.tools.codegen.MyMetaDataSerializer")
@SuppressWarnings("all")
public class QPlayerRow extends com.querydsl.sql.RelationalPathBase<PlayerRow> {

    private static final long serialVersionUID = -1073483756;

    public static final QPlayerRow Player = new QPlayerRow("Player");

    public final StringPath emailAddress = createString("emailAddress");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath loginToken = createString("loginToken");

    public final StringPath name = createString("name");

    public final com.querydsl.sql.PrimaryKey<PlayerRow> playerPkey = createPrimaryKey(id);

    public final com.querydsl.sql.ForeignKey<GameFeedbackRow> _gameFeedbackPlayerIdFkey = createInvForeignKey(id, "playerId");

    public QPlayerRow(String variable) {
        super(PlayerRow.class, forVariable(variable), "electronics_game", "Player");
        addMetadata();
    }

    public QPlayerRow(String variable, String schema, String table) {
        super(PlayerRow.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QPlayerRow(Path<? extends PlayerRow> path) {
        super(path.getType(), path.getMetadata(), "electronics_game", "Player");
        addMetadata();
    }

    public QPlayerRow(PathMetadata metadata) {
        super(PlayerRow.class, metadata, "electronics_game", "Player");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(emailAddress, ColumnMetadata.named("emailAddress").withIndex(4).ofType(Types.VARCHAR).withSize(500));
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(loginToken, ColumnMetadata.named("loginToken").withIndex(3).ofType(Types.VARCHAR).withSize(500));
        addMetadata(name, ColumnMetadata.named("name").withIndex(2).ofType(Types.VARCHAR).withSize(500).notNull());
    }

}

