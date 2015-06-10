/**
 * 
 */
package fr.upem.snake.components;

import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.LinkedList;

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
	
	private final LinkedList<Bonus> bonus;
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
		this.bonus = new LinkedList<Bonus>();
	}
	
	public void setSpeed(float speed){
		this.speed = speed;
	}
	
	public LinkedList<Bonus> getBonus(){
		return this.bonus;
	}
	
	
	public void rotateLeft(){
		System.out.println("Rotate left");
		alpha -= 0.2;
	}
	public ArrayList<Ellipse2D> getParts(){
		return this.parts;
	}
	
	public void rotateRight(){
		System.out.println("Rotate right");
		alpha += 0.2;
	}
	
	public boolean collides(float width, float height){
		//if(head.getCenterX() <= 0 || head.getCenterX() >= width || head.getCenterY() <= 0 || head.getCenterY() >= height)
		if(head.getCenterX() - head.getWidth()/2 <= 0 || head.getCenterX() + head.getWidth()/2 >= width || head.getCenterY() - head.getHeight()/2 <= 0 || head.getCenterY() + head.getHeight()/2 >= height)
			return true;
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
	public void updateDash(){
		
		this.head = new Ellipse2D.Float((float)(head.getX()+speed*Math.cos(alpha)), (float)(head.getY()+speed*Math.sin(alpha)), radius, radius);
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

	public void addBonus(float width, float height){
		bonus.add(new Bonus(width,height));
	}
	
	public void applyBonus(Bonus b, ApplicationContext context, float width, float height){
		
		switch(b.getValue()){
		
		case(0):
			b.erase(this, context, width, height);
		break;
		
		case(1):
			b.dash(this, context, width, height);
		break;
		
		case(2):
			b.slow(this, context, width, height);
		break;
		
		case(3):
			b.fast(this, context, width, height);
		}
	}
	public void drawBonus(ApplicationContext context){
		Bonus b = bonus.getLast();
		
		switch(b.getValue()){
		
		case(0):
			context.renderFrame(graphics -> {
		        graphics.setColor(Color.RED);
		        graphics.fillOval(b.getX(), b.getY(), 20, 20);
			});
		break;
		
		case(1):
			context.renderFrame(graphics -> {
		        graphics.setColor(Color.BLUE);
		        graphics.fillOval(b.getX(), b.getY(), 20, 20);
			});
		break;
		
		case(2):
			context.renderFrame(graphics -> {
		        graphics.setColor(Color.GREEN);
		        graphics.fillOval(b.getX(), b.getY(), 20, 20);
			});
		break;
		
		case(3):
			context.renderFrame(graphics -> {
		        graphics.setColor(Color.WHITE);
		        graphics.fillOval(b.getX(), b.getY(), 20, 20);
			});
		}
	}
	
	public void collideBonus(ApplicationContext context, float width, float height){
		
		for(Bonus b: bonus){
			if(head.intersects(b.getX()-10, b.getY()-10, 20, 20)){
				context.renderFrame(graphics -> {
			        graphics.setColor(Color.ORANGE);
			        graphics.fillOval(b.getX(), b.getY(), 20, 20);

				});
		        applyBonus(b,context, width, height);
		        bonus.remove(b);
		        break;
			}
		}
	}

}
