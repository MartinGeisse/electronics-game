package name.martingeisse.electronics_game.game.space;

import name.martingeisse.electronics_game.game.EntityProvider;
import name.martingeisse.electronics_game.game.item.Inventory;
import name.martingeisse.electronics_game.game.item.ObjectWithInventory;

/**
 *
 */
public final class SpaceStation extends StaticSpaceObject implements ObjectWithInventory {

	private EntityProvider entityProvider;
	private long inventoryId;

	public SpaceStation(EntityProvider entityProvider) {
		this.entityProvider = entityProvider;
	}

	/**
	 * Setter method.
	 *
	 * @param inventoryId the inventoryId
	 */
	void internalSetInventoryId(long inventoryId) {
		this.inventoryId = inventoryId;
	}

	/**
	 * Getter method.
	 *
	 * @return the inventoryId
	 */
	@Override
	public long getInventoryId() {
		if (inventoryId < 1) {
			throw new IllegalStateException("inventoryId not initialized");
		}
		return inventoryId;
	}

	/**
	 * Getter method.
	 *
	 * @return the inventory
	 */
	@Override
	public Inventory getInventory() {
		return entityProvider.getInventory(getInventoryId());
	}

	@Override
	public long getRadius() {
		return 200;
	}

}
