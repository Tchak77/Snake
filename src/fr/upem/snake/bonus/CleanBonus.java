/**
 * 
 */
package fr.upem.snake.bonus;

import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import fr.umlv.zen5.ApplicationContext;
import fr.umlv.zen5.ScreenInfo;
import fr.upem.snake.components.Snake;

/**
 * @author MIGNON Frederic - TCHAKMAKDJIAN Kevin
 *
 */
public class CleanBonus extends Bonus {

	public CleanBonus(float x, float y) {
		this.ellipse = new Ellipse2D.Float(x - 10, y - 10, 20, 20);
		this.color = Color.GREEN;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.upem.snake.bonus.Bonus#applyBonus(fr.upem.snake.components.Snake)
	 */
	@Override
	public void applyBonus(Snake s, ApplicationContext context) {

		s.getParts().clear();
		ScreenInfo screenInfo = context.getScreenInfo();
		float width = screenInfo.getWidth();
		float height = screenInfo.getHeight();
		context.renderFrame(graphics -> {
			graphics.setColor(Color.ORANGE);
			graphics.fill(new Rectangle2D.Float(0, 0, width, height));
		});
	}

}
