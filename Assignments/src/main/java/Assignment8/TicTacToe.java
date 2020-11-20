package Assignment8;

import java.util.*;

public class TicTacToe {

    private final static Set<Integer> positions = new HashSet<>();
    private final static Random random = new Random();
    private static int count = 0;
    private static char[][] gameBoard;

    public TicTacToe() {
        gameBoard = new char[3][3];
    }

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();

        //Fill the board with '#' i.e. start the board with
        for (char[] chars : gameBoard) {
            Arrays.fill(chars, '#');
        }
        printGameBoard(gameBoard);

        takeInput();
    }

    public static void printAvailablePositions() {
        for(int i = 1; i <= 9; i ++) {
            if(!positions.contains(i)) {
                System.out.print(i + "\t");
            }
        }
    }

    public static void takeInput() {
        int turn = 0;
        while (turn < 9) {
            if (turn % 2 == 0) {
                turn = getPlayerInput(turn);
                System.out.println("The board so far is: ");
                printGameBoard(gameBoard);
                //Check winner
            } else {
                turn = getComputerInput(turn);
                System.out.println("Computer is done choosing it's position");
                System.out.println("The board so far is: ");
                printGameBoard(gameBoard);
                //Check winner
            }

            String winner = checkWinner();

            if(winner.equals("A")) {
                System.out.println("Yay! You WON!");
                break;
            } else if(winner.equals("B")) {
                System.out.println("OOPS! You LOST!");
                break;
            } else if(winner.equals("Draw")){
                System.out.println("That was close. But it's a DRAW");
                break;
            }
        }
    }

    private static int getComputerInput(int turn) {
        int result = generateRandomNumber();
        while(!positions.add(result)) {
            result = generateRandomNumber();
        }
        int row = (result - 1) / 3;
        int col = (result - 1) % 3;
        gameBoard[row][col] = 'O';

        turn ++;
        return turn;
    }

    private static int generateRandomNumber() {
        int low = 1;
        int high = 9;
        return random.nextInt(high-low) + low;
    }

    private static int getPlayerInput(int turn) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Available positions are: ");
        printAvailablePositions();

        System.out.println("\nEnter your placement (1-9): " +
                "1 is the top-left corner and 9 is the bottom-right corner");

        // write your code here
        int input = scan.nextInt();
        if (!positions.add(input)) {
            System.out.println("That position is already taken. Take some other position between");
        } else if (input > 9 || input <= 0) {
            System.out.println("Choose a valid number between 1 - 9");
            printAvailablePositions();
        } else {
            int row = (input - 1) / 3;
            int col = (input - 1) % 3;
            gameBoard[row][col] = 'X';
        }
        turn ++;
        return turn;
    }

    public static void printGameBoard(char[][] gameBoard) {

        for (char[] c : gameBoard) {
            System.out.println(c);
        }
    }

    public static String checkWinner() {
        //Traverse rows
        for(int i = 0; i < gameBoard.length; i ++) {
            for(int j = 0; j < 1; j ++) {

                count = 0;
                goRight(gameBoard, i , j, gameBoard[i][j]);

                if(count == 3)
                    if(gameBoard[i][j] == 'X')
                        return "A";
                    else if(gameBoard[i][j] == 'O')
                        return "B";
            }
        }

        //Traverse cols
        for(int i = 0; i < 1; i ++) {
            for(int j = 0; j < gameBoard[i].length; j ++) {

                count = 0;
                goDown(gameBoard, i , j, gameBoard[i][j]);

                if(count == 3)
                    if(gameBoard[i][j] == 'X')
                        return "A";
                    else if(gameBoard[i][j] == 'O')
                        return "B";
            }
        }

        //Check left diagonal
        if(gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2]) {
            if(gameBoard[0][0] == 'X')
                return "A";
            else if(gameBoard[0][0]== 'O')
                return "B";
        }

        //Check right diagonal
        if(gameBoard[0][2]== gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][0]) {
            if(gameBoard[0][2] =='X')
                return "A";
            else if(gameBoard[0][2]=='O')
                return "B";
        }

        for(int i = 0; i < gameBoard.length; i ++) {
            for(int j = 0; j < gameBoard[i].length; j ++) {
                if(gameBoard[i][j]=='#')
                    return "Pending";
            }
        }

        return "Draw";
    }

    private static void goRight(char[][] board, int i, int j, char mark) {
        if(i >= board.length || j >= board[i].length || board[i][j]!= mark)
            return;

        count = count + 1;
        goRight(board, i, j + 1, mark);
    }

    private static void goDown(char[][] board, int i, int j, char mark) {
        if(i >= board.length || j >= board[i].length || board[i][j]!=mark)
            return;

        count = count + 1;
        goDown(board, i + 1, j, mark);
    }

}
