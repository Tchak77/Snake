/**
 * 
 */
package fr.upem.snake.main;

import java.awt.Color;
import java.awt.geom.Rectangle2D;


import fr.umlv.zen5.Application;
import fr.umlv.zen5.Event;
import fr.umlv.zen5.KeyboardKey;
import fr.umlv.zen5.ScreenInfo;
import fr.umlv.zen5.Event.Action;
import fr.upem.snake.components.Snake;


/**
 * @author MIGNON Frederic
 *
 */
public class Main {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
	    Application.run(Color.ORANGE, context -> {	        
	        // get the size of the screen
	        ScreenInfo screenInfo = context.getScreenInfo();
	        float width = screenInfo.getWidth();
	        float height = screenInfo.getHeight();
	        System.out.println("size of the screen (" + width + " x " + height + ")");
	        
	        context.renderFrame(graphics -> {
	          graphics.setColor(Color.ORANGE);
	          graphics.fill(new  Rectangle2D.Float(0, 0, width, height));
	        });
	        
	        Snake snake = new Snake();
	        long chrono = java.lang.System.currentTimeMillis() ;
	        for(;;){
	          
	          if(java.lang.System.currentTimeMillis() - chrono > 5000){//On ajoute un bonus toutes les 15sec
	        	  snake.addBonus(width, height);
	        	  snake.drawBonus(context);
	        	  chrono = java.lang.System.currentTimeMillis();
	        	  
	          }
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
	      });

	}

}
