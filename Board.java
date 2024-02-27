package mypackagemain2048;

import java.util.Random;
import java.util.Scanner;

public class Board {
    private static final int GRID_SIZE = 4;
    private final int[][] board;
    private int validMoves;

    public Board() {
        board = new int[GRID_SIZE][GRID_SIZE];
        validMoves = 0;
    }

    public void setBoard(int[][] newBoard) {
        if (newBoard == null) {
            throw new IllegalArgumentException("The new board cannot be null.");
        }
              if (newBoard.length != GRID_SIZE || newBoard[0].length != GRID_SIZE) {
               throw new IllegalArgumentException("The new board must be a 4x4 array.");
        }
        for (int i = 0; i < GRID_SIZE; i++) {

            System.arraycopy(newBoard[i], 0, this.board[i], 0, GRID_SIZE);
        }
    }

    public int maxTile() {
        int max = 0;
        for (int[] row : board) {
            for (int cell : row) {
                max = Math.max(max, cell);
            }
        }
        return max;
    }

    public void printBoard() {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.printf("%5s", cell == 0 ? "*" : cell);
            }
            System.out.println();
        }
        System.out.println();
    }


    public void printStatement(boolean valid, String move){
        System.out.println("You pressed: "+move);

        if (valid){
            System.out.println("Valid Move!");
            validMoves++;
            spawnNumber();
        }

        else {
            System.out.println("Not a Valid Move!");
        }

        System.out.println("Max Number: " + maxTile());
        System.out.println("Valid Moves: "+validMoves);

        if (!canMove())
            return;
        System.out.println("Enter your move: ");
    }


    public void spawnNumber() {
        int availableTiles = 0;
        for (int i = 0; i < GRID_SIZE; i++){
            for (int j = 0; j < GRID_SIZE; j++){
                if (board[i][j] == 0){
                    availableTiles += 1;
                }
            }
        }

        if (availableTiles == 0){
            return;
        }

        int newNumber;
        Random random = new Random();


        int randInt = random.nextInt(100);
        if (randInt < 80){
            newNumber = 2;
        }
        else newNumber = 4;


        int rowNum = random.nextInt(GRID_SIZE);
        int columnNum = random.nextInt(GRID_SIZE);


        if (board[rowNum][columnNum] > 0){
            spawnNumber();
        }
        else board[rowNum][columnNum] = newNumber;
    }

    public void up(){

        for (int j = 0; j < GRID_SIZE; j++){
            int zeroCount = 0;
            for (int i = 0; i < GRID_SIZE; i++){
                if (board[i][j] == 0){
                    zeroCount++;
                }
                else{

                    board[i-zeroCount][j] = board[i][j];

                    if (zeroCount != 0){
                        board[i][j] = 0;
                    }
                }
            }
        }
        for (int j = 0; j < GRID_SIZE; j++){
            for (int i = 1; i < GRID_SIZE; i++){

                if (board[i][j] == board[i-1][j]){
                    board[i-1][j] += board[i][j];
                    board[i][j] = 0;
                }
            }
        }

        for (int j = 0; j < GRID_SIZE; j ++){
            int zeroCount = 0;
            for (int i = 0; i < GRID_SIZE; i++){
                if (board[i][j] == 0){
                    zeroCount++;
                }
                else{

                    board[i-zeroCount][j] = board[i][j];
                    if (zeroCount != 0){
                        board[i][j] = 0;
                    }
                }
            }
        }
    }

    public void down() {

        for (int j = 0; j < GRID_SIZE; j ++){
            int zeroCount = 0;
            for (int i = GRID_SIZE-1; i >= 0; i--){

                if (board[i][j] == 0){
                    zeroCount++;
                }
                else{

                    board[i+zeroCount][j] = board[i][j];

                    if (zeroCount!=0){
                        board[i][j] = 0;
                    }
                }
            }
        }

        for (int j = 0; j < GRID_SIZE; j++){
            for (int i = GRID_SIZE-1; i > 0; i--){

                if (board[i][j] == board[i-1][j]){
                    board[i][j] += board[i-1][j];
                    board[i-1][j] = 0;
                }
            }
        }

        for (int j = 0; j < GRID_SIZE; j ++){
            int zeroCount = 0;
            for (int i = GRID_SIZE-1; i >= 0; i--){

                if (board[i][j] == 0){
                    zeroCount++;
                }
                else{

                    board[i+zeroCount][j] = board[i][j];

                    if (zeroCount!=0){
                        board[i][j] = 0;
                    }
                }
            }
        }
    }

    public void left(){

        for (int i = 0; i < GRID_SIZE; i++){

            int zeroCount = 0;
            for (int j = 0; j < GRID_SIZE; j++){
                if (board[i][j] == 0){
                    zeroCount++;
                }
                else{

                    board[i][j-zeroCount] = board[i][j];

                    if (zeroCount!=0){
                        board[i][j] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < GRID_SIZE; i++){
            for (int j = 1; j < GRID_SIZE; j++){

                if (board[i][j] == board[i][j-1]){
                    board[i][j-1] += board[i][j];
                    board[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < GRID_SIZE; i++){
            int zeroCount = 0;

            for (int j = 0; j < GRID_SIZE; j++){
                if (board[i][j] == 0){
                    zeroCount++;
                }
                else{

                    board[i][j-zeroCount] = board[i][j];

                    if (zeroCount!=0){
                        board[i][j] = 0;
                    }
                }
            }
        }
    }

    public void right(){

        for (int i = 0; i < GRID_SIZE; i++){

            int zeroCount = 0;
            for (int j = GRID_SIZE-1; j >= 0; j--){
                if (board[i][j] == 0){
                    zeroCount++;
                }
                else {

                    board[i][j+zeroCount] = board[i][j];

                    if (zeroCount != 0){
                        board[i][j] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < GRID_SIZE; i++){
            for (int j = GRID_SIZE-1; j > 0; j--){

                if (board[i][j] == board[i][j-1]){
                    board[i][j] += board[i][j-1];
                    board[i][j-1] = 0;
                }
            }
        }

        for (int i = 0; i < GRID_SIZE; i++){
            // if there is no number at the position, then the zeroCount goes up
            int zeroCount = 0;
            for (int j = GRID_SIZE-1; j >= 0; j--){
                if (board[i][j] == 0){
                    zeroCount++;
                }
                else {

                    board[i][j+zeroCount] = board[i][j];

                    if (zeroCount != 0){
                        board[i][j] = 0;
                    }
                }
            }
        }
    }


    public boolean canMove(){
        return canMoveLeft() || canMoveRight() || canMoveUp() || canMoveDown();
    }

    public boolean canMoveLeft(){

        for (int i = 0; i < GRID_SIZE; i++){
            for (int j = 0; j < GRID_SIZE-1; j++){

                if (board[i][j] == 0 && board[i][j+1] != 0){
                    return true;
                }

                if (board[i][j] !=0 && board[i][j] == board[i][j+1]){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean canMoveRight(){

        for (int i = 0; i < GRID_SIZE; i++){
            for (int j = GRID_SIZE-1; j > 0; j--){

                if (board[i][j] == 0 && board[i][j-1] != 0){
                    return true;
                }

                if (board[i][j] !=0 && board[i][j] == board[i][j-1]){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean canMoveUp(){

        for (int j = 0; j < GRID_SIZE; j++){
            for (int i = 0; i < GRID_SIZE-1; i++){

                if (board[i][j] == 0 && board[i+1][j]!=0){
                    return true;
                }

                if (board[i][j] != 0 && board[i][j] == board[i+1][j]){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean canMoveDown(){

        for (int j = 0; j < GRID_SIZE; j++){
            for (int i = GRID_SIZE-1; i > 0; i--){

                if (board[i][j] == 0 && board[i-1][j] != 0){
                    return true;
                }

                if (board[i][j]!= 0 && board[i][j] == board[i-1][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * method: run
     * purpose: run the program.
     * */
    public void run(){
        Scanner in  = new Scanner(System.in);
        int decision = 0;


        spawnNumber();
        spawnNumber();

        // prints out the menu
        System.out.println("""
                Options:
                W - UP
                S - DOWN
                A - LEFT
                D - RIGHT
                Q - quit
                R - restart
                """);

        // prints the board
        printBoard();
        System.out.println("Enter your move: ");
        String move = in.next();

        boolean win = false;


        while (canMove()){
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n");

            //
            if (move.equalsIgnoreCase("W")){
                if (canMoveUp()){
                    up();
                    printStatement(true, move);
                }

                else {
                    printStatement(false, move);
                    move = in.next();
                    continue;
                }
            }

            else if (move.equalsIgnoreCase("S")){
                if (canMoveDown()){
                    down();
                    printStatement(true, move);
                }

                else {
                    printStatement(false, move);
                    move = in.next();
                    continue;
                }
            }

            else if (move.equalsIgnoreCase("A")){
                if (canMoveLeft()){
                    left();
                    printStatement(true, move);
                }

                else {
                    printStatement(false, move);
                    move = in.next();
                    continue;
                }
            }

            else if (move.equalsIgnoreCase("D")){
                if (canMoveRight()){
                    right();
                    printStatement(true, move);
                }

                else {
                    printStatement(false, move);
                    move = in.next();
                    continue;
                }
            }

            else if (move.equalsIgnoreCase("Q")){
                System.out.println("""
                        Are you sure you want to quit?
                        Y - yes
                        anything else - no""");
                String quit = in.next();

                if (quit.equalsIgnoreCase("Y")){
                    decision = 2;
                    break;
                }

                else {
                    System.out.println("Enter your move: ");
                    move = in.next();
                    continue;
                }
            }

            else if (move.equalsIgnoreCase("R")){
                System.out.println("""
                        Are you sure you want to restart?
                        Y - yes
                        anything else - no""");
                String quit = in.next();

                if (quit.equalsIgnoreCase("Y")){
                    decision = 1;
                    break;
                }

                else {
                    System.out.println("Enter your move: ");
                    move = in.next();
                    continue;
                }
            }

            else {
                System.out.println("Invalid input, please try again");
                move = in.next();
                continue;
            }

            if (maxTile() == 2048){
                win = true;
                break;
            }

            else if (!canMove()){
                break;
            }

            move = in.next();
        }

        if (win){
            System.out.println("You Win!");
            System.out.println("Max Numb: "+ maxTile());
            System.out.println("Numb of Valid Moves: "+ validMoves);
        }
        else{

            if (decision == 0){
                System.out.println("Game Over");
                System.out.println("Max Numb: "+ maxTile());
                System.out.println("Numb of Valid Moves: "+ validMoves);
            }

            else if (decision == 1){
                System.out.println("Max Numb: "+ maxTile());
                System.out.println("Numb of Valid Moves: "+ validMoves);
                int[][] newBoard = new int[][] {{0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0}};
                setBoard(newBoard);
                run();
            }

            else {
                System.out.println("Max Numb: "+ maxTile());
                System.out.println("Numb of Valid Moves: "+ validMoves);
            }
        }
    }
}