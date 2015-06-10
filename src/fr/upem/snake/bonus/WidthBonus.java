/**
 * 
 */
package fr.upem.snake.bonus;

import java.awt.Color;
import java.awt.geom.Ellipse2D;

import fr.umlv.zen5.ApplicationContext;
import fr.upem.snake.components.Snake;

/**
 * @author MIGNON Frederic - TCHAKMAKDJIAN Kevin
 *
 */

/**
 * A bonus which increases the width of a snake.
 *
 */
public class WidthBonus extends Bonus {

	/**
	 * @param x the x coord to draw at.
	 * @param y the y coord to draw at.
	 */
	public WidthBonus(float x, float y) {
		this.ellipse = new Ellipse2D.Float(x - 10, y - 10, 20, 20);
		this.color = Color.CYAN;
	}

	/* (non-Javadoc)
	 * @see fr.upem.snake.bonus.Bonus#applyBonus(fr.upem.snake.components.Snake, fr.umlv.zen5.ApplicationContext)
	 */
	@Override
	public void applyBonus(Snake s, ApplicationContext context) {
		s.widthUp();
	}

}
