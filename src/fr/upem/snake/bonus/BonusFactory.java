/**
 * 
 */
package fr.upem.snake.bonus;

import fr.umlv.zen5.ApplicationContext;
import fr.umlv.zen5.ScreenInfo;

/**
 * @author MIGNON Frederic - TCHAKMAKDJIAN Kevin
 *
 */
public final class BonusFactory {

	public static Bonus getRandomBonus(ApplicationContext context) {
		ScreenInfo screeninfo = context.getScreenInfo();
		int value = (int) (Math.random() * 4);
		float x = (float) (Math.random() * screeninfo.getWidth());
		float y = (float) (Math.random() * screeninfo.getHeight());
		switch (value) {
		case 1:
			return new CleanBonus(x, y);
		case 2:
			return new SpeedBonus(x, y);
		case 3:
			return new SpeedMalus(x, y);
		default:
			return new CleanBonus(x, y);
		}
	}

}
