/**
 * 
 */
package fr.upem.snake.components;

import java.awt.geom.Ellipse2D.Float;

/**
 * @author MIGNON Frederic
 *
 */
public class MyEllipse extends Float {
	/**
	 * @param x
	 * @param y
	 * @param width
	 */
	public MyEllipse(float x, float y, float width) {
		super(x-width/2, y-width/2, width, width);
	}
	
	public double getX(){
		return this.x;
	}
	
	public double getY(){
		return this.y;
	}
	
	public float getRadius(){
		return this.width;
	}
	
	public boolean intersects(MyEllipse e){
		return super.intersects(e.getBounds2D());
	}

}
