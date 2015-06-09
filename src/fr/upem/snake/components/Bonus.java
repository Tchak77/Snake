package fr.upem.snake.components;

import java.awt.Color;
import java.awt.geom.Rectangle2D;

import fr.umlv.zen5.ApplicationContext;
import fr.umlv.zen5.Event;
import fr.umlv.zen5.KeyboardKey;
import fr.umlv.zen5.Event.Action;

public class Bonus {

	
	
	public static void erase(Snake s, ApplicationContext context, float width, float height){
		
		
		s.getParts().clear();
		context.renderFrame(graphics -> {
	          graphics.setColor(Color.ORANGE);
	          graphics.fill(new  Rectangle2D.Float(0, 0, width, height));
	        });
	}
	
	public static void dash(Snake snake, ApplicationContext context, float width, float height){
		
		long chrono = java.lang.System.currentTimeMillis() ; 
		int compteur =0;
		 while( java.lang.System.currentTimeMillis() - chrono <= 10000){ //10 secondes de bonus pointillés
	          
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
	
	public static void slow (Snake snake, ApplicationContext context, float width, float height){
		long chrono = java.lang.System.currentTimeMillis() ; 
		snake.setSpeed(1);
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
		 snake.setSpeed(2);
	}
	
	
	public static void fast (Snake snake, ApplicationContext context, float width, float height){
		long chrono = java.lang.System.currentTimeMillis() ; 
		snake.setSpeed(4);
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
		 snake.setSpeed(2);
	}
}
