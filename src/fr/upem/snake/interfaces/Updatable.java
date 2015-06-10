/**
 * 
 */
package fr.upem.snake.interfaces;

/**
 * @author MIGNON Frederic - TCHAKMAKDJIAN Kevin
 *
 */
/**
 * An interface used for every object that should be updated.
 *
 */
public interface Updatable {
	/**
	 * A method that should be called in a loop to update an object which implements this interface.
	 * to make an object alive.
	 */
	public void update();
}
