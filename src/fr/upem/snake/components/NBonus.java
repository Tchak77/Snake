package fr.upem.snake.components;

import java.awt.Color;
import java.awt.geom.Rectangle2D;

import fr.umlv.zen5.ApplicationContext;
import fr.umlv.zen5.Event;
import fr.umlv.zen5.KeyboardKey;
import fr.umlv.zen5.Event.Action;

public abstract class NBonus {

	private final float x;
	private final float y;
	private final int value;
		
	public NBonus(float width, float height){
		value =(int) (Math.random()*4);
		x = (float) (Math.random()*width);
		y = (float) (Math.random()*height);
	}
	
	public float getX(){
		return this.x;
	}
	public float getY(){
		return this.y;
	}
	
	public void erase(Snake s, ApplicationContext context, float width, float height){
		s.getParts().clear();
		context.renderFrame(graphics -> {
	          graphics.setColor(Color.ORANGE);
	          graphics.fill(new  Rectangle2D.Float(0, 0, width, height));
	        });
	}
	
	public void dash(Snake snake, ApplicationContext context, float width, float height){
		
		long chrono = java.lang.System.currentTimeMillis() ; 
		int compteur =0;
		 while(java.lang.System.currentTimeMillis() - chrono <= 10000){ //10 secondes de bonus pointilles	          
	          Event event = context.pollOrWaitEvent(30);
	          if(compteur % 50 >= 25){
			      snake.draw(context);
			      snake.update();
			      if(snake.collides(width, height)){
			    	  context.exit(0);
		              return;
			      }
	          }
	          else{
			      snake.updateDash();
	          }
	          compteur ++;
	          if (event == null) {
		    	  continue;
		      }
		      if(event.getAction().equals(Action.KEY_PRESSED)){
		    	  KeyboardKey key = event.getKey();
		    	  if(key != null){
			    	  System.out.println(key);
			    	  if(key.equals(KeyboardKey.RIGHT)){
			    		  snake.rotateRight();
			    	  }else if(key.equals(KeyboardKey.LEFT)){
			    		  snake.rotateLeft();
			    	  }else if(key.equals(KeyboardKey.M)){
			              context.exit(0);
			              return;
			    	  }
		    	  }
		      }
	        }	
	}
	
	public void slow (Snake snake, ApplicationContext context, float width, float height){
		long chrono = java.lang.System.currentTimeMillis() ; 
//		snake.setSpeed(1);
		 while( java.lang.System.currentTimeMillis() - chrono <= 10000){ //10 secondes de bonus lenteur
	          Event event = context.pollOrWaitEvent(30);
			      snake.draw(context);
			      snake.update();
			      if(snake.collides(width, height)){
			    	 context.exit(0);
		             return;  
			      }
	          if (event == null) {
		    	  continue;
		      }
		      if(event.getAction().equals(Action.KEY_PRESSED)){
		    	  KeyboardKey key = event.getKey();
		    	  if(key != null){
			    	  System.out.println(key);
			    	  if(key.equals(KeyboardKey.RIGHT)){
			    		  snake.rotateRight();
			    	  }else if(key.equals(KeyboardKey.LEFT)){
			    		  snake.rotateLeft();
			    	  }else if(key.equals(KeyboardKey.M)){
			              context.exit(0);
			              return;
			    	  }
		    	  }
		      }
	        }
//		 snake.setSpeed(2);
	}
	
	
	public void fast (Snake snake, ApplicationContext context, float width, float height){
		long chrono = java.lang.System.currentTimeMillis() ; 
//		snake.setSpeed(4);
		 while( java.lang.System.currentTimeMillis() - chrono <= 10000){ //10 secondes de bonus lenteur
	          
	          Event event = context.pollOrWaitEvent(30);
			      snake.draw(context);
			      snake.update();
			      if(snake.collides(width, height)){
			    	 context.exit(0);
		             return;
			    	  
			      }


	          if (event == null) {
		    	  continue;
		      }
		      if(event.getAction().equals(Action.KEY_PRESSED)){
		    	  KeyboardKey key = event.getKey();
		    	  if(key != null){
			    	  System.out.println(key);
			    	  if(key.equals(KeyboardKey.RIGHT)){
			    		  snake.rotateRight();
			    	  }else if(key.equals(KeyboardKey.LEFT)){
			    		  snake.rotateLeft();
			    	  }else if(key.equals(KeyboardKey.M)){
			              context.exit(0);
			              return;
			    	  }
		    	  }
		      }
	        }
//		 snake.setSpeed(2);
	}
}
