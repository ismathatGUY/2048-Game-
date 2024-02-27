
# Project Title
Project #1 (2048 Game)
A brief description of what this project does and who it's for

Name: Ismael Kabore
Net id: ikabore
Partner: Jaden Addae
Lab section:   M/W 2:00 PM - 3:15 PM at Gavett 244,

Welcome to the 2048 game, a simple but addictive puzzle game where you slide tiles to merge them and reach the 2048 tile. This game is implemented using two Java classes: a Main class and a Board class.

Welcome to 2048, a basic but compelling puzzle game in which you slide tiles together to create the 2048 tile. Two Java classes are used to create this game: the Main class and the Board class. 

Main Class:
The Main class is where the game begins. The main class creates an instance of the Board class and executes the run function while diplays the game board and handles users input. 

The 4x4 grid that makes up the game board is represented by the class Board.java. It offers ways to create new random tiles, verify whether the game is ended, and update the board based on the user's moves. 

The Board class has several methods:

setBoard: This method sets the game board with a new board, passed as a 2D array.

maxTile: This method returns the maximum value tile in the game board.

printBoard: This method prints the current game board to the console.

printStatement: This method prints whether the move made by the player was valid or not, the maximum value tile, and the number of valid moves.

spawnNumber: This method randomly places a 2 or 4 on the game board in an empty space.

up: This method moves all the tiles up, combining and collapsing tiles if they are of the same value.

down: This method moves all the tiles down, combining and collapsing tiles if they are of the same value.

How to play the game:

To play the game, run the Main class. Use the letter a, s, d, and w keys to slide the tiles in the desired direction. The goal of the game is to reach the 2048 tile by merging tiles with the same value. If you reach a state where no moves are possible, the game is over.