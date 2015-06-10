/**
 * 
 */
package fr.upem.snake.main;

import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import fr.umlv.zen5.Application;
import fr.umlv.zen5.Event;
import fr.umlv.zen5.KeyboardKey;
import fr.umlv.zen5.ScreenInfo;
import fr.umlv.zen5.Event.Action;
import fr.upem.snake.components.Snake;
import fr.upem.snake.bonus.Bonus;
import fr.upem.snake.bonus.BonusFactory;

/**
 * @author MIGNON Frederic - TCHAKMAKDJIAN Kevin
 *
 */
/**
 * The main class used to run the game.
 *
 */
public class Main {

	/**
	 * The main method. The args have no effect here.
	 * @param args the args given at the execution.
	 */
	public static void main(String[] args) {
		Application.run(Color.ORANGE, context -> {
			// get the size of the screen
				ScreenInfo screenInfo = context.getScreenInfo();
				float width = screenInfo.getWidth();
				float height = screenInfo.getHeight();
				System.out.println("size of the screen (" + width + " x "
						+ height + ")");
				ArrayList<Bonus> bonus = new ArrayList<Bonus>();

				context.renderFrame(graphics -> {
					graphics.setColor(Color.ORANGE);
					graphics.fill(new Rectangle2D.Float(0, 0, width, height));
				});

				Snake snake = new Snake();
				long chrono = java.lang.System.currentTimeMillis();
				for (;;) {
					if (java.lang.System.currentTimeMillis() - chrono > 5000
							&& bonus.size() < 9) {// On ajoute un bonus toutes
													// les 5sec
					bonus.add(BonusFactory.getRandomBonus(context));
					chrono = java.lang.System.currentTimeMillis();
				}
				Event event = context.pollOrWaitEvent(30);
				snake.draw(context);
				snake.update();
				if (snake.collides(width, height)) {
					context.exit(0);
					return;
				}
				for (int i = 0; i < bonus.size(); i++) {
					if (snake.getHead().intersects(
							bonus.get(i).getShape().getBounds2D())) {
						bonus.get(i).applyBonus(snake, context);
						Ellipse2D e = bonus.get(i).getShape();
						context.renderFrame(graphics -> {
							graphics.setColor(Color.ORANGE);
							graphics.fill(e);
						});
						bonus.remove(i);
					}
				}

				for (Bonus b : bonus) {
					b.draw(context);
				}
				if (event == null) {
					continue;
				}
				if (event.getAction().equals(Action.KEY_PRESSED)) {
					KeyboardKey key = event.getKey();
					if (key != null) {
						System.out.println(key);
						if (key.equals(KeyboardKey.RIGHT)) {
							snake.rotateRight();
						} else if (key.equals(KeyboardKey.LEFT)) {
							snake.rotateLeft();
						} else if (key.equals(KeyboardKey.M)) {
							context.exit(0);
							return;
						}
					}
				}
			}
		});

	}

}
