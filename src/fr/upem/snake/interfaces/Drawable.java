/**
 * 
 */
package fr.upem.snake.interfaces;

import fr.umlv.zen5.ApplicationContext;

/**
 * @author MIGNON Frederic - TCHAKMAKDJIAN Kevin
 *
 */
/**
 * An interface used for every object that should be drown.
 *
 */
public interface Drawable {
	/**
	 * 
	 * @param context the context which runs the main loop.
	 */
	public void draw(ApplicationContext context);
}
