/**
 * 
 */
package fr.upem.snake.components;

import java.util.ArrayList;

import fr.umlv.zen5.ApplicationContext;
import fr.upem.snake.interfaces.Drawable;
import fr.upem.snake.interfaces.Updatable;

/**
 * @author MIGNON Frederic
 *
 */
public class Snake implements Drawable, Updatable {

	private final ArrayList<Part> parts;
	private Part head;	
	
	private float speed;
	private float xDir;
	private float yDir;
	
	/**
	 * 
	 */
	public Snake() {
		this.head = new Part(20, 200, 10);
		this.parts = new ArrayList<Part>();
		this.parts.add(head);
		this.speed = 5;
		this.xDir = 1;
		this.yDir = 0;
	}
	
	
	public void rotateLeft(){
		System.out.println("Rotate left");
		double x = (xDir*Math.cos(-Math.PI/12) - yDir*Math.sin(-Math.PI/12));
		double y = (xDir*Math.sin(-Math.PI/12) + yDir*Math.cos(-Math.PI/12));;
		System.out.println(x + " - " + y);
		this.xDir = (float) x;
		this.yDir = (float) y;
	}
	
	public void rotateRight(){
		System.out.println("Rotate right");
		double x = (xDir*Math.cos(Math.PI/12) - yDir*Math.sin(Math.PI/12));
		double y = (xDir*Math.sin(Math.PI/12) + yDir*Math.cos(Math.PI/12));;
		System.out.println(x + " - " + y);
		this.xDir = (float) x;
		this.yDir = (float) y;
	}
	
	/* (non-Javadoc)
	 * @see fr.upem.snake.interfaces.Updatable#update()
	 */
	@Override
	public void update() {
		Part newHead = new Part((int)(head.getX()+speed*xDir), (int)(head.getY()+speed*yDir), head.getRadius());
		this.head = newHead;
		this.parts.add(head);
	}

	/* (non-Javadoc)
	 * @see fr.upem.snake.interfaces.Drawable#draw(fr.umlv.zen5.ApplicationContext, float, float)
	 */
	@Override
	public void draw(ApplicationContext context) {
		for (Part part : parts) {
			part.draw(context);
		}
	}

}
