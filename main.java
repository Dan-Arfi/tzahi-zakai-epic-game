import java.util.*;

public class main {
    static Scanner reader = new Scanner(System.in);
   public static String oName;
    public static String xName;
    public static void main(String[] args) {

        System.out.println("name of player X: ");
        xName = reader.nextLine();

        System.out.println("name of player O: ");
        xName = reader.nextLine();
        
        playGame();

    }

    public static void playGame() {
        char currentPlayer = 'x';
        boolean end = false;
        char[][] board = new char[3][3];
        initBoard(board);
        while (!end) {
            drawBoard(board);

            makeMove(currentPlayer, board);
            System.out.println(checkForWinner('x', board));
            if (checkForWinner(currentPlayer, board)) {
                end = true;
                if (currentPlayer == 'x') {
                    System.out.println(xName + " won!" );
                } else {
                    System.out.println( oName + " won!" );
                }
                
                
            }
            else if (checkIfFull(board)) {
                end = true;
                System.out.println("Draw!" );
            }
            else{
            if (currentPlayer == 'x') {
                currentPlayer = 'o';
            } else {
                currentPlayer = 'x';
            }
        }
        }

    }

    public static void initBoard(char[][] board) {
        for (int i = 0; i < board[0].length; i++) {
            for (int x = 0; x < board[0].length; x++) {
                board[i][x] = ' ';
            }

        }
        // System.out.println(board);
        // clear console
        System.out.print("\033[H\033[2J");
    }

    public static void drawBoard(char[][] board) {
        // clear console
        System.out.print("\033[H\033[2J");

        char[] letters = { 'a', 'b', 'c' };
        for (int y = 0; y <= board[0].length; y++) {
            for (int x = 0; x <= board[0].length; x++) {
                if (y == 0 && x > 0) {
                    System.out.print("| " + (x) + " ");
                } else if (x == 0 && y > 0) {

                    System.out.print("| " + letters[y - 1] + " ");

                } else if (y == 0 && x == 0) {
                    System.out.print("|  ");
                } else {

                    System.out.print("| " + board[x - 1][y - 1]);

                }

            }

            System.out.println("");
            System.out.println("----------------");

        }

    }

    public static void makeMove(char player, char[][] board) {
        boolean validMove = false;
    while (!validMove) {
        System.out.println("Where do you want to place " + player + " on the x axis? (1 - 3)");
        int xPos = reader.nextInt();
        System.out.println("Where do you want to place " + player + " on the y axis? (a - c)");
        char yPos = reader.next().charAt(0);
        int y = 0;
        xPos -= 1;
        if (yPos == 'a') {
            y = 0;
        } else if (yPos == 'b') {
            y = 1;
        } else if (yPos == 'c') {
            y = 2;
        }
        if (checkIfValid(yPos, xPos, board)) {
            board[xPos][y] = player;
            validMove = true; 
        } else {
            System.out.println("Invalid move! Try again.");
        }
    }
    
        
        

    }
    public static boolean checkIfFull(char[][] board){
        boolean isFull = true;
        for(int y =0; y<board.length; y++){
            for(int x = 0; x< board[0].length; x++){
                if (board[y][x] == ' ') {
                    isFull = false;
                }

            }
        }
        return isFull;
    }

    public static boolean checkIfValid(char yPos, int xPos, char[][] board) {
        
        int y = 0;
        if (yPos == 'a') {
            y = 0;
        } else if (yPos == 'b') {
            y = 1;
        } else if (yPos == 'c') {
            y = 2;
        }
        else {
            return false;
        }
        if (xPos < 0 || xPos+1 > board.length) {
            return false;
        }
        if (board[xPos][y] == ' ') {
            return true;
        } else {
            System.out.println("sorry! place " + xPos + "" + yPos + " is not available :(");
            return false;
        }
    }

    public static boolean checkForWinner(char player, char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }

        for (int i = 0; i < board.length; i++) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        char previous_figure = player;
        boolean win_diag = true;
        for(int i = 0; i< board.length; i++){
            if (board[i][i] == previous_figure && board[i][i] == player) {
                previous_figure = board[i][i];
            }
            else{
                win_diag = false;
            }
            if (i == board.length-1 && win_diag == true) {
                return true;
            }
        }
        previous_figure = player;
        win_diag = true;
        for(int i = 0; i< board.length; i++){
            if (board[i][board.length-i-1] == previous_figure && board[i][board.length-i-1] == player) {
                previous_figure = board[i][board.length-i-1];
            }
            else{
                win_diag = false;
            }
            if (i == board.length-1 && win_diag == true) {
                return true;
            }
        }
        return false;
    }
    
}