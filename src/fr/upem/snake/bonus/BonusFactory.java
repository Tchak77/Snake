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
/**
 * A factory that creates Bonus.
 *
 */
public final class BonusFactory {

	/**
	 * Returns a bonus depending on the random value between 5 types of bonus.
	 * @param context the main context which runs the loop.
	 * @return a Bonus-type randomly created
	 */
	public static Bonus getRandomBonus(ApplicationContext context) {
		ScreenInfo screeninfo = context.getScreenInfo();
		int value = (int) (Math.random() * 6);
		float x = (float) (Math.random() * screeninfo.getWidth());
		float y = (float) (Math.random() * screeninfo.getHeight());
		switch (value) {
		case 1:
			return new CleanBonus(x, y);
		case 2:
			return new SpeedBonus(x, y);
		case 3:
			return new SpeedMalus(x, y);
		case 4:
			return new WidthBonus(x, y);
		case 5:
			return new WidthMalus(x, y);
		default:
			return new CleanBonus(x, y);
		}
	}

}
