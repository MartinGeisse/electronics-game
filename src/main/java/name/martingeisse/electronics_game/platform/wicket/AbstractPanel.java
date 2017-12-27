package name.martingeisse.electronics_game.platform.wicket;

import name.martingeisse.electronics_game.game.player.Player;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 *
 */
public class AbstractPanel extends Panel {

	public AbstractPanel(String id) {
		super(id);
	}

	public AbstractPanel(String id, IModel<?> model) {
		super(id, model);
	}

	public final Player getPlayer() {
		return MyWicketSession.get().getPlayer();
	}

}
