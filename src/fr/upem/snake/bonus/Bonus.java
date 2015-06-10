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
public abstract class Bonus implements Drawable {

	protected Ellipse2D.Float ellipse;
	protected Color color;

	public abstract void applyBonus(Snake s, ApplicationContext context);

	public Ellipse2D getShape() {
		return this.ellipse;
	}

	@Override
	public void draw(ApplicationContext context) {
		context.renderFrame(graphics -> {
			graphics.setColor(color);
			graphics.fill(ellipse);
		});
	}

}
