import java.util.*;

public class main {
    static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("name of player X: ");
        String xName = reader.nextLine();

        System.out.println("name of player O: ");
        String oName = reader.nextLine();
        playGame();

    }

    public static void playGame() {
        char[][] board = new char[3][3];
        initBoard(board);
        drawBoard(board);

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
        char[] letters = { 'a', 'b', 'c' };
        for (int y = 0; y <= board[0].length; y++) {
            for (int x = 0; x <= board[0].length; x++) {
                if (y == 0 && x > 0) {
                    System.out.print("| " + (x) + " ");
                } else if (x == 0 && y > 0) {

                    System.out.print("| " + letters[y - 1] + " ");

                } else {
                    System.out.print("|   ");
                }

            }

            System.out.println("");
            System.out.println("----------------");
            
        }
    }

}