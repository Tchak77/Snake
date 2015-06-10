/**
 * 
 */
package fr.upem.snake.components;

import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import fr.umlv.zen5.ApplicationContext;
import fr.upem.snake.interfaces.Drawable;
import fr.upem.snake.interfaces.Updatable;

/**
 * @author MIGNON Frederic - TCHAKMAKDJIAN Kevin
 *
 */

/**
 * A snake that is allowed to move inside of a window.
 *
 */
public class Snake implements Drawable, Updatable {

	private final ArrayList<Ellipse2D> parts; /* Liste des parties du serpent */
	private Ellipse2D head; /* Tete du serpent */
	private float speed; /* Vitesse de deplacement */
	private float alpha; /* Angle de direction */
	private float radius; /* Epaisseur du serpent */

	/**
	 * A snake that move in a direction with a speed.
	 */
	public Snake() {
		this.head = new Ellipse2D.Float(200, 200, radius, radius);
		this.parts = new ArrayList<Ellipse2D>();
		this.parts.add(head);
		this.speed = 2;
		this.alpha = 0;
		this.radius = 10;
	}

	/**
	 * Increases the speed of the snake if it is not yet to high.
	 */
	public void speedUp() {
		if (speed <= 5) {
			this.speed *= 2;
		}
	}

	/**
	 * Decreases the speed of the snake if it is not yet to low.
	 */
	public void speedDown() {
		if (speed >= 2) {
			this.speed /= 2;
		}
	}

	/**
	 * Increases the radius of the snake's shape.
	 */
	public void widthUp(){
		if(radius <= 50){
			this.radius += 5;
		}
	}
	
	/**
	 * Decreases the radius of the snake's shape.
	 */
	public void widthDown(){
		if(radius >= 10){
			this.radius -= 5;
		}
	}
	
	/**
	 * 
	 * @return the head's shape of the snake.
	 */
	public Ellipse2D getHead() {
		return this.head;
	}

	/**
	 * Modify the angle of the direction to allow the snake to move.
	 */
	public void rotateLeft() {
		System.out.println("Rotate left");
		alpha -= 0.2;
	}

	/**
	 * Modify the angle of the direction to allow the snake to move.
	 */
	public void rotateRight() {
		System.out.println("Rotate right");
		alpha += 0.2;
	}

	/**
	 * 
	 * @return the list of parts of the snake.
	 */
	public ArrayList<Ellipse2D> getParts() {
		return this.parts;
	}

	/**
	 * Tells if the snake collides with a window's border
	 * or with a part of itself.
	 * @param width the width of the window
	 * @param height the height of the window
	 * @return a boolean
	 */
	public boolean collides(float width, float height) {
		if (head.getCenterX() - head.getWidth() / 2 <= 0
				|| head.getCenterX() + head.getWidth() / 2 >= width
				|| head.getCenterY() - head.getHeight() / 2 <= 0
				|| head.getCenterY() + head.getHeight() / 2 >= height)
			return true;
		for (int i = 0; i < parts.size() - 20; i++) {
			if (head.intersects(parts.get(i).getBounds2D())) {
				return true;
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.upem.snake.interfaces.Updatable#update()
	 */
	@Override
	public void update() {
		Ellipse2D newE = new Ellipse2D.Float((float) (head.getX() + speed
				* Math.cos(alpha)), (float) (head.getY() + speed
				* Math.sin(alpha)), radius, radius);
		this.head = newE;
		this.parts.add(head);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.upem.snake.interfaces.Drawable#draw(fr.umlv.zen5.ApplicationContext)
	 */
	@Override
	public void draw(ApplicationContext context) {
		context.renderFrame(graphics -> {
			graphics.setColor(Color.BLACK);
			graphics.fill(head);
		});
	}

}
