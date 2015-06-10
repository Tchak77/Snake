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
public class SpeedMalus extends Bonus {

	public SpeedMalus(float x, float y) {
		this.ellipse = new Ellipse2D.Float(x - 10, y - 10, 20, 20);
		this.color = Color.RED;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.upem.snake.bonus.Bonus#applyBonus(fr.upem.snake.components.Snake)
	 */
	@Override
	public void applyBonus(Snake s, ApplicationContext context) {
		s.speedDown();
	}

}
