import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        // creating an empty board
        char[][] board = new char[3][3];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }
        //
        char palyer = 'x';
        boolean gameover = false;
        Scanner scanner = new Scanner(System.in);
        //
        while (!gameover) {
            printBoard(board);
            System.out.print("player" + palyer + "Enter : ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            System.out.println();

            //
            if (board[row][col] == ' ') {
                board[row][col] = palyer;
                gameover = havewon(board, palyer);
                if (gameover) {
                    System.out.println("player" + palyer + "have won!");
                } else {
                    palyer = (palyer == 'x') ? 'o' : 'x';
                }
            } else {
                System.out.println("Invalid Move please try again");
            }

        }
        printBoard(board);
    }

    public static boolean havewon(char[][] board, char palyer) {
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == palyer && board[row][1] == palyer && board[row][2] == palyer) {
                return true;
            }
        }
        for (int col = 0; col < board.length; col++) {
            if (board[0][col] == palyer && board[1][col] == palyer && board[2][col] == palyer) {
                return true;
            }
        }
        if (board[0][0] == palyer && board[1][1] == palyer && board[2][2] == palyer) {
            return true;
        }
        if (board[0][2] == palyer && board[1][1] == palyer && board[2][0] == palyer) {
            return true;
        }
        return false;

    }

    public static void printBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }

    }
}