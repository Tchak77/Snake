This project is a simple Tron-like game developped by MIGNON Frederic and TCHAKMAKDJIAN Kevin.
10/06/2015

---------------------------------------------------------------------------------------------

API :

This project uses the lib Zen.
You can find this library and its sources in the "Res" repository at the project's root.

---------------------------------------------------------------------------------------------

SOURCES :

    Packages :
        fr.upem.snake.bonus :	   Contains the differents Bonus of the game.
				   The Bonus class is abstract and implements the Drawable interface.
			      	   All the bonus extend the Bonus class and can be drown.
			      	   BonusFactory is used to create different Bonus in the game.

	fr.upem.snake.components : Contains the snake of the game.
				   This snake implements the Drawable and Updatable interfaces.

	fr.upem.snake.interfaces : Contains the interfaces of this game.
				   Drawable is used for objects that need to be drown.
				   Updatable is used for objects that need to be updated.

	fr.upem.snake.main :	   Contains the main class of this game which runs the game loop.

---------------------------------------------------------------------------------------------





