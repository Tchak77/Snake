/**
 * 
 */
package fr.upem.snake.main;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;




import fr.umlv.zen5.Application;
import fr.umlv.zen5.Event;
import fr.umlv.zen5.KeyboardKey;
import fr.umlv.zen5.ScreenInfo;
import fr.umlv.zen5.Event.Action;import fr.upem.snake.components.Snake;


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
	        for(;;) {
		      snake.draw(context);
		      snake.update();
	          Event event = context.pollOrWaitEvent(50);
		      if (event != null) {
		    	  Action action = event.getAction();
		    	  if (action == Action.KEY_PRESSED) {
			    	  KeyboardKey key = event.getKey();
			    	  if(key == KeyboardKey.D){
				    	  while(action != Action.KEY_RELEASED){
				    		  snake.rotateRight();
				    		  snake.draw(context);
						      snake.update();
						      event = context.pollOrWaitEvent(10);
						      if(event != null)
						    	  action = event.getAction();
				    	  }
			    	  }else if(key == KeyboardKey.Q){
				    	  while(action != Action.KEY_RELEASED){
				    		  snake.rotateLeft();
				    		  snake.draw(context);
						      snake.update();
						      event = context.pollOrWaitEvent(10);
						      if(event != null)
						    	  action = event.getAction();
				    	  }
			    	  }
				      snake.rotateLeft();
		    		  /*System.out.println("abort abort !");
		    		  context.exit(0);
		    		  return;*/
		    	  }
		          System.out.println(event);
	          }

	        }
	      });

	}

}
