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
 * @author MIGNON Frederic
 *
 */
public class Snake implements Drawable, Updatable {

	private final ArrayList<Ellipse2D> parts; /*Liste des parties du serpent*/
	private Ellipse2D head; /*Tete du serpent*/
	
	private float speed; /*Vitesse de deplacement*/
	private float alpha; /*Angle de direction*/
	private float radius;
	
	/**
	 * 
	 */
	public Snake() {
		this.head = new Ellipse2D.Float(200, 200, radius, radius);
		this.parts = new ArrayList<Ellipse2D>();
		this.parts.add(head);
		this.speed = 2;
		this.alpha = 0;
		this.radius = 10;
	}
	
	public void rotateLeft(){
		System.out.println("Rotate left");
		alpha -= 0.2;
	}
	
	public void rotateRight(){
		System.out.println("Rotate right");
		alpha += 0.2;
	}
	
	public boolean collidesWithBody(){
		for(int i=0;i<parts.size()-10;i++){
			if(head.intersects(parts.get(i).getBounds2D())){
				System.out.println("COLLISION");
				return true;
			}
		}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see fr.upem.snake.interfaces.Updatable#update()
	 */
	@Override
	public void update() {
		Ellipse2D newE = new Ellipse2D.Float((float)(head.getX()+speed*Math.cos(alpha)), (float)(head.getY()+speed*Math.sin(alpha)), radius, radius);
		this.head = newE;
		this.parts.add(head);
	}

	/* (non-Javadoc)
	 * @see fr.upem.snake.interfaces.Drawable#draw(fr.umlv.zen5.ApplicationContext)
	 */
	@Override
	public void draw(ApplicationContext context) {
		context.renderFrame(graphics -> {
	        graphics.setColor(Color.BLACK);
	        graphics.fill(head);
		});
	}

}
