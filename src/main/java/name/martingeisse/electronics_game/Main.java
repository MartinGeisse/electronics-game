/**
 * Copyright (c) 2016 Martin Geisse
 * <p>
 * This file is distributed under the terms of the MIT license.
 */
package name.martingeisse.electronics_game;

import name.martingeisse.electronics_game.platform.application.Launcher;

/**
 *
 */
public final class Main {

	// prevent instantiation
	private Main() {
	}

	/**
	 * The main method.
	 *
	 * @param args command-line arguments (ignored)
	 */
	public static void main(String[] args) throws Exception {
		Launcher.launch();
	}

}
