/**
 * 
 */
package fr.upem.snake.components;

import java.awt.Color;
import java.awt.geom.Ellipse2D;

import fr.umlv.zen5.ApplicationContext;
import fr.upem.snake.interfaces.Drawable;

/**
 * @author MIGNON Frederic
 *
 */
public class Part implements Drawable{

	private final float x;
	private final float y;
	private final int radius;
	
	/**
	 * 
	 */
	public Part(float x, float y, int radius) {
		this.x = x;
		this.y = y;
		if (radius > 1){
			this.radius = radius;
		}else{
			this.radius = 10;
		}
	}

	public float getX(){
		return this.x;
	}
	
	public float getY(){
		return this.y;
	}
	
	public int getRadius(){
		return this.radius;
	}
	
	@Override
	public void draw(ApplicationContext context) {
	      context.renderFrame(graphics -> {
	    	  /*Draw a simple cicle at the coords given*/
	          graphics.setColor(Color.BLACK);
	          graphics.fill(new Ellipse2D.Float(x - radius/2, y - radius/2, radius, radius));
	        });
	}

}
