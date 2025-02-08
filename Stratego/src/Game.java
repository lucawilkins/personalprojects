import java.io.IOException;
import java.util.Scanner;

public class Game {
    private GamePiece activePiece;
    private Board board;
    // -----------------------------------------------------------

    /**
     * Default Constructor
     */
    public Game() {
        this.board = new Board(); // creates game
    }

    /**
     * @param row: row index of attacking piece
     * @param col: col index of attacking piece
     * @param i:   row index of defending piece
     * @param j:   col index of defending piece
     */
    public void attack(int row, int col, int i, int j) {
        GamePiece offense = board.getCell(row, col);
        GamePiece defense = board.getCell(i, j);

        if (offense.getPieceValue() == 3 && defense.getPieceValue() == 11) {
            board.remove(i, j);
            board.setCell(offense, i, j);
            board.remove(row, col);
        } else if (offense.getPieceValue() == 1 && defense.getPieceValue() == 10) {
            board.remove(i, j);
            board.setCell(offense, i, j);
            board.remove(row, col);
        } else if (offense.getPieceValue() < defense.getPieceValue()) {
            board.remove(row, col);
        } else if (offense.getPieceValue() > defense.getPieceValue()) {
            board.remove(i, j);
            board.setCell(offense, i, j);
            board.remove(row, col);
        } else {
            board.remove(row, col);
            board.remove(i, j);
        }
    }

    /**
     * Uses Scanner to gather current location and desired location.
     *
     * @param team
     * @throws Exception   when player makes invalid move (e.g., tries to move onto lake).
     * @throws IOException
     */
    public void getMove(String team) throws Exception {
        Scanner console = new Scanner(System.in);
        System.out.println("what piece do you want to move? Enter row then column: ");
        int row = console.nextInt();
        int col = console.nextInt();

        // checks for integers out of range
        if ((row < 0 || row > 9) || (col < 0 || col > 9)) {
            throw new Exception("That location does not exist");
        }
        // checks for attempt to move an empty space
        else if (board.getCell(row, col) != (null)) {
            activePiece = board.getCell(row, col);
        } else {
            throw new Exception("That location is empty.");
        }
        // checks for illegal move of opposing team's piece or lake piece
        if (!activePiece.getTeam().equals(team)) {
            if (activePiece.getTeam().equals("black")) {
                throw new Exception("You cannot move a lake.");
            } else {
                throw new Exception("You cannot move the other team's piece.");
            }
        }

        System.out.println("Where do you want to move? Enter coordinates: ");
        int i = console.nextInt();
        int j = console.nextInt();

        if (board.isValidMove(row, col, i, j)) {
            if (board.occupiedByOtherTeam(row, col, i, j)) {
                System.out.println();
                attack(row, col, i, j);
            } else {
                board.setCell(activePiece, i, j);
                board.remove(row, col);
            }
        } else {
            throw new Exception("Try again."); // specific exception messages are included in relevant board methods.
        }
    }

    /**
     * Runs game of Stratego
     */
    public void Gameloop() {
        Scanner console = new Scanner(System.in);
        while (true) {
            System.out.print("Red's Turn: \n");
            board.printRedBoard();
            System.out.println();
            while (true) {
                try {
                    getMove("red");
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            board.printRedBoard();
            System.out.println();
            if (!board.canMove() || !board.hasFlags()) {
                break; // check winning conditions at the end of each turn
            }
            System.out.println("Enter any character to finish turn.");
            console.next();
            board.clearConsole();
            // --------------------------------------------------------------
            System.out.print("Blue's Turn: \n");
            board.printBlueBoard();
            System.out.println();
            while (true) {
                try {
                    getMove("blue");
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            board.printBlueBoard();
            System.out.println();
            if (!board.canMove() || !board.hasFlags()) {
                break; // check winning conditions at the end of each turn
            }
            System.out.println("Enter any character to finish turn");
            console.next();
            board.clearConsole();
        }
    }
}