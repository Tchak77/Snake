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

	private final ArrayList<Part> parts; /*Liste des parties du serpent*/
	private Part head; /*Tete du serpent*/
	
	private float speed; /*Vitesse de deplacement*/
	private float alpha; /*Angle de direction*/
	
	/**
	 * 
	 */
	public Snake() {
		this.head = new Part(20, 200, 10);
		this.parts = new ArrayList<Part>();
		this.parts.add(head);
		this.speed = 2;
		this.alpha = 2;
	}
	
	
	public void rotateLeft(){
		System.out.println("Rotate left");
		alpha -= 0.1;
	}
	
	public void rotateRight(){
		System.out.println("Rotate right");
		alpha += 0.1;
	}
	
	
	/* (non-Javadoc)
	 * @see fr.upem.snake.interfaces.Updatable#update()
	 */
	@Override
	public void update() {
		Part newHead = new Part((int)(head.getX()+speed*Math.cos(alpha)), (int)(head.getY()+speed*Math.sin(alpha)), head.getRadius());
		this.head = newHead;
		this.parts.add(head);
	}

	/* (non-Javadoc)
	 * @see fr.upem.snake.interfaces.Drawable#draw(fr.umlv.zen5.ApplicationContext)
	 */
	@Override
	public void draw(ApplicationContext context) {
		head.draw(context);
	}

}
