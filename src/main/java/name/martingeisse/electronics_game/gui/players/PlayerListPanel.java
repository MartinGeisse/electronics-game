package name.martingeisse.electronics_game.gui.players;

import name.martingeisse.electronics_game.game.player.Player;
import name.martingeisse.electronics_game.game.player.PlayerRepository;
import name.martingeisse.electronics_game.platform.wicket.AbstractPanel;
import name.martingeisse.electronics_game.platform.wicket.MyWicketApplication;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.PropertyModel;

import java.util.List;

/**
 * Shows the list of players.
 */
public class PlayerListPanel extends AbstractPanel {

	public PlayerListPanel(String id) {
		super(id);
		LoadableDetachableModel<List<Player>> playerListModel = new LoadableDetachableModel<List<Player>>() {
			@Override
			protected List<Player> load() {
				return MyWicketApplication.get().getDependency(PlayerRepository.class).getAllPlayers();
			}
		};
		add(new ListView<Player>("players", playerListModel) {
			@Override
			protected void populateItem(ListItem<Player> item) {
				item.add(new Label("name", new PropertyModel<>(item.getModel(), "name")));
			}
		});
	}

}
