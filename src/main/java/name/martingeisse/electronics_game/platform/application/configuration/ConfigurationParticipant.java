package name.martingeisse.electronics_game.platform.application.configuration;

import name.martingeisse.electronics_game.platform.util.parameter.ParameterException;

/**
 * An object that receives configuration.
 */
public interface ConfigurationParticipant {

	/**
	 * Configures this participant.
	 */
	public void configure(ApplicationConfiguration configuration) throws ParameterException;

}
