/**
 * 
 */
package fr.upem.snake.bonus;

import java.awt.Color;
import java.awt.geom.Ellipse2D;

import fr.umlv.zen5.ApplicationContext;
import fr.upem.snake.components.Snake;

/**
 * @author MIGNON Frederic
 *
 */
public class SpeedBonus extends Bonus {

	public SpeedBonus(float x, float y) {
		this.ellipse = new Ellipse2D.Float(x-10, y-10, 20, 20);
		this.color = Color.BLUE;
	}

	/* (non-Javadoc)
	 * @see fr.upem.snake.bonus.Bonus#applyBonus(fr.upem.snake.components.Snake)
	 */
	@Override
	public void applyBonus(Snake s, ApplicationContext context) {
		s.speedUp();
	}

}
