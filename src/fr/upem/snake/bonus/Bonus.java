/**
 * 
 */
package fr.upem.snake.bonus;

import java.awt.Color;
import java.awt.geom.Ellipse2D;

import fr.umlv.zen5.ApplicationContext;
import fr.upem.snake.components.Snake;
import fr.upem.snake.interfaces.Drawable;

/**
 * @author MIGNON Frederic - TCHAKMAKDJIAN Kevin
 *
 */

/**
 * A bonus to be used with a snake.
 *
 */
public abstract class Bonus implements Drawable {

	protected Ellipse2D.Float ellipse;
	protected Color color;

	/**
	 * Apply a bonus to a snake in a given context.
	 * @param s the snake to apply the bonus to.
	 * @param context the main context which runs the loop.
	 */
	public abstract void applyBonus(Snake s, ApplicationContext context);

	/**
	 * 
	 * @return the shape of the bonus.
	 */
	public Ellipse2D getShape() {
		return this.ellipse;
	}

	/* (non-Javadoc)
	 * @see fr.upem.snake.interfaces.Drawable#draw(fr.umlv.zen5.ApplicationContext)
	 */
	@Override
	public void draw(ApplicationContext context) {
		context.renderFrame(graphics -> {
			graphics.setColor(color);
			graphics.fill(ellipse);
		});
	}

}
