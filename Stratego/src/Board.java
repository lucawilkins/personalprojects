import java.util.*;

public class Board {
    private final int SIZE = 10;
    private Map<Location, GamePiece> gameBoard = new HashMap<>(); // Collection #1
    private ArrayList<GamePiece> blueMobilePieces = new ArrayList<>(); // Collection #2
    private ArrayList<Location> blueImmobile = new ArrayList<>();
    private ArrayList<GamePiece> redMobilePieces = new ArrayList<>();
    private ArrayList<Location> redImmobile = new ArrayList<>();

    public void makeBlueTeam() {

        blueMobilePieces.add(new Marshal("blue", 10)); // marshal
        blueMobilePieces.add(new General("blue", 9)); // general
        blueMobilePieces.add(new Colonel("blue", 8)); // colonel1
        blueMobilePieces.add(new Colonel("blue", 8)); // colonel2
        blueMobilePieces.add(new Major("blue", 7)); // major1
        blueMobilePieces.add(new Major("blue", 7)); // major2
        blueMobilePieces.add(new Major("blue", 7)); // major3
        blueMobilePieces.add(new Captain("blue", 6)); // captain1
        blueMobilePieces.add(new Captain("blue", 6)); // captain2
        blueMobilePieces.add(new Captain("blue", 6)); // captain3
        blueMobilePieces.add(new Captain("blue", 6)); // captain4
        blueMobilePieces.add(new Lt("blue", 5)); // lt1
        blueMobilePieces.add(new Lt("blue", 5)); // lt2
        blueMobilePieces.add(new Lt("blue", 5)); // lt3
        blueMobilePieces.add(new Lt("blue", 5)); // lt4
        blueMobilePieces.add(new Sgt("blue", 4)); // sgt1
        blueMobilePieces.add(new Sgt("blue", 4)); // sgt2
        blueMobilePieces.add(new Sgt("blue", 4)); // sgt3
        blueMobilePieces.add(new Sgt("blue", 4)); // sgt4
        blueMobilePieces.add(new Miner("blue", 3)); // miner1
        blueMobilePieces.add(new Miner("blue", 3)); // miner2
        blueMobilePieces.add(new Miner("blue", 3)); // miner3
        blueMobilePieces.add(new Miner("blue", 3)); // miner4
        blueMobilePieces.add(new Miner("blue", 3)); // miner5
        blueMobilePieces.add(new Scout("blue", 2)); // scout1
        blueMobilePieces.add(new Scout("blue", 2)); // scout2
        blueMobilePieces.add(new Scout("blue", 2)); // scout3
        blueMobilePieces.add(new Scout("blue", 2)); // scout4
        blueMobilePieces.add(new Scout("blue", 2)); // scout5
        blueMobilePieces.add(new Scout("blue", 2)); // scout6
        blueMobilePieces.add(new Scout("blue", 2)); // scout7
        blueMobilePieces.add(new Scout("blue", 2)); // scout8
        blueMobilePieces.add(new Spy("blue", 1)); // spy
        //blueMobilePieces.add(new Flag("blue")); // flag
    } // creates each piece and adds to blue team

    public void makeRedTeam() {
        redMobilePieces.add(new Marshal("red", 10)); // marshal
        redMobilePieces.add(new General("red", 9)); // general
        redMobilePieces.add(new Colonel("red", 8)); // colonel1
        redMobilePieces.add(new Colonel("red", 8)); // colonel2
        redMobilePieces.add(new Major("red", 7)); // major1
        redMobilePieces.add(new Major("red", 7)); // major2
        redMobilePieces.add(new Major("red", 7)); // major3
        redMobilePieces.add(new Captain("red", 6)); // captain1
        redMobilePieces.add(new Captain("red", 6)); // captain2
        redMobilePieces.add(new Captain("red", 6)); // captain3
        redMobilePieces.add(new Captain("red", 6)); // captain4
        redMobilePieces.add(new Lt("red", 5)); // lt1
        redMobilePieces.add(new Lt("red", 5)); // lt2
        redMobilePieces.add(new Lt("red", 5)); // lt3
        redMobilePieces.add(new Lt("red", 5)); // lt4
        redMobilePieces.add(new Sgt("red", 4)); // sgt1
        redMobilePieces.add(new Sgt("red", 4)); // sgt2
        redMobilePieces.add(new Sgt("red", 4)); // sgt3
        redMobilePieces.add(new Sgt("red", 4)); // sgt4
        redMobilePieces.add(new Miner("red", 3)); // miner1
        redMobilePieces.add(new Miner("red", 3)); // miner2
        redMobilePieces.add(new Miner("red", 3)); // miner3
        redMobilePieces.add(new Miner("red", 3)); // miner4
        redMobilePieces.add(new Miner("red", 3)); // miner5
        redMobilePieces.add(new Scout("red", 2)); // scout1
        redMobilePieces.add(new Scout("red", 2)); // scout2
        redMobilePieces.add(new Scout("red", 2)); // scout3
        redMobilePieces.add(new Scout("red", 2)); // scout4
        redMobilePieces.add(new Scout("red", 2)); // scout5
        redMobilePieces.add(new Scout("red", 2)); // scout6
        redMobilePieces.add(new Scout("red", 2)); // scout7
        redMobilePieces.add(new Scout("red", 2)); // scout8
        redMobilePieces.add(new Spy("red", 1)); // spy
    } // creates each mobile piece and adds to red team


    /**
     * sets up the board
     */
    public Board() {
        for (int i = 0; i < 2; i++) { // Add locations in rows 0-1 to blueImmobile ArrayList
            for (int j = 0; j < SIZE; j++) {
                blueImmobile.add(new Location(i, j));
            }
        }

        for (int i = 8; i < SIZE; i++) { // Add locations in rows 8-9 to redImmobile ArrayList
            for (int j = 0; j < SIZE; j++) {
                redImmobile.add(new Location(i, j));
            }
        }
        makeBlueTeam();
        makeRedTeam();
        Random r = new Random();

        for (int i = 0; i < 6; i++) { // Set up bombs for blue team
            Bomb b = new Bomb("blue", 11);
            Location l = blueImmobile.remove(r.nextInt(blueImmobile.size())); // pull random location from rows 0-1)
            gameBoard.put(l, b); // assign Bomb to random blue location
        }
        Flag blueFlag = new Flag("blue", 0); // Set up flag for blue team
        Location blueLoc = blueImmobile.remove(r.nextInt(blueImmobile.size())); // pull random location
        gameBoard.put(blueLoc, blueFlag); // assign Flag to random location (rows 0-1)


        for (int i = 0; i < 6; i++) { // Set up bombs and flag for red team, repeat above steps for rows 8-9
            Bomb b = new Bomb("red", 11);
            Location l = redImmobile.remove(r.nextInt(redImmobile.size()));
            gameBoard.put(l, b);
        }
        Flag redFlag = new Flag("red", 0);
        Location redLoc = redImmobile.remove(r.nextInt(redImmobile.size()));
        gameBoard.put(redLoc, redFlag);


        // set up blue team mobile pieces, rows 0-3
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < SIZE; j++) {
                Location loc = new Location(i, j);
                if (!gameBoard.containsKey(loc)) { // only places mobile piece if gameBoard index is empty
                    GamePiece temp = blueMobilePieces.get(r.nextInt(blueMobilePieces.size())); // pull random piece
                    blueMobilePieces.remove(temp); //remove piece from ArrayList
                    gameBoard.put(loc, temp); // Assign piece to map
                }
            }
        }

        // set up red team mobile pieces, repeats steps above, rows 6-9
        for (int i = 6; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                Location loc = new Location(i, j);
                if (!gameBoard.containsKey(loc)) {
                    GamePiece temp = redMobilePieces.get(r.nextInt(redMobilePieces.size()));
                    redMobilePieces.remove(temp);
                    gameBoard.put(loc, temp);
                }
            }
        }

        //set up middle row indexes occupied by 'Lakes'
        gameBoard.put(new Location(4, 2), new Lake("black", 0));
        gameBoard.put(new Location(4, 3), new Lake("black", 0));
        gameBoard.put(new Location(4, 6), new Lake("black", 0));
        gameBoard.put(new Location(4, 7), new Lake("black", 0));
        gameBoard.put(new Location(5, 2), new Lake("black", 0));
        gameBoard.put(new Location(5, 3), new Lake("black", 0));
        gameBoard.put(new Location(5, 6), new Lake("black", 0));
        gameBoard.put(new Location(5, 7), new Lake("black", 0));
    }

    /**
     * @param row: row index of cell to be returned
     * @param col: column index of cell to be returned
     * @return GamePiece to be returned
     */
    public GamePiece getCell(int row, int col) {
        return gameBoard.get(new Location(row, col));
    }

    /**
     * @param piece the piece being moved
     * @param row:  row index of piece's new location
     * @param col:  col index of piece's new location
     */
    public void setCell(GamePiece piece, int row, int col) {
        // sets the cell to hold piece
        gameBoard.put(new Location(row, col), piece);
    }

    /**
     * Removes specified gamePiece from the board
     *
     * @param row
     * @param col
     */
    public void remove(int row, int col) {
        // removes the piece from the board
        gameBoard.put(new Location(row, col), null);
    }

    /**
     * @param row: row index of active piece
     * @param col: col index of active piece
     * @param i:   row index of potential move
     * @param j:   col index of potential move
     * @return true if move is valid
     */
    public boolean isValidMove(int row, int col, int i, int j) {
        // checks the capability of the piece that called the method to move to board[row][col]
        return !(ownTeam(row, col, i, j)) && !(isLake(i, j)) && isInRange(row, col, i, j);
    }

    /**
     * @return true if specified index's team .equals "black"
     */
    public boolean isLake(int i, int j) {
        if (gameBoard.get(new Location(i, j)) != null && gameBoard.get(new Location(i, j)).getTeam().equals("black")) {
            System.out.print("Cannot move onto a lake. ");
            return true;
        }
        return false;
    }

    /**
     * Ensures gamePieces (other than Scouts) can only move one index per turn
     *
     * @param row
     * @param col
     * @param i
     * @param j
     * @return true if destination is only one index away and unoccupied
     */
    public boolean isInRange(int row, int col, int i, int j) {
        if (gameBoard.get(new Location(row, col)).getPieceValue() == 2) {
            return !isObstructed(row, col, i, j);
        } else if (gameBoard.get(new Location(row, col)).getPieceValue() != 0 && gameBoard.get(new Location(row, col)).getPieceValue() != 11) {
            // can only move to a cell within [row-1][col] to [row+1][col] and [row][col-1] to [row][col+1]
            if ((i == row) && ((j == col - 1) || (j == col + 1))) {
                return true;
            } else return (j == col) && ((i == row - 1) || (i == row + 1));
        }
        return false;
    }

    /**
     * Used for 'Scout' Objects
     *
     * @param row: row index of starting location
     * @param col: col index of starting location
     * @param i: row index of potential new location
     * @param j: col index of potential new location
     * @return true if indexes between Scout's location and destination are clear
     */
    public boolean isObstructed(int row, int col, int i, int j) {

        if (i == row) {  // checks for horizontal moves
            if (j < col) { // checks for moves to the left
                // decrementing for loop
                for (int k = col - 1; k > j; k--) {
                    // returns true if space is occupied
                    if (!(gameBoard.get(new Location(i, k)) == null)) {
                        return true;
                    }
                }
            }
            if (j > col) { // checks for moves to the right
                // check for all the spaces up to
                for (int k = col + 1; k < j; k++) {
                    if (!(gameBoard.get(new Location(i, k)) == null)) {
                        return true;
                    }
                }
            }
        }
        if (j == col) { // checks for vertical moves
            if (i < row) { // moves up
                for (int k = row - 1; k > i; k--) {
                    if (!(gameBoard.get(new Location(k, j)) == null)) {
                        return true;
                    }
                }
            }
            if (i > row) { // checks for moves down
                for (int k = row + 1; k < i; k++) {
                    if (!(gameBoard.get(new Location(k, j)) == null)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * @param row: row index of active piece
     * @param col: col index of active piece
     * @param i: row index of potential new location
     * @param j: col index of potential new location
     * @return true if board index is occupied by current player's team
     */
    public boolean ownTeam(int row, int col, int i, int j) {
        if (gameBoard.get(new Location(i, j)) != null) {
            if (gameBoard.get(new Location(row, col)).getTeam().equals(gameBoard.get(new Location(i, j)).getTeam())) {
                System.out.print("Cannot move onto space occupied by teammate. ");
                return true;
            }
        }
        return false;
    }

    /**
     * @param row: row index of active piece
     * @param col: col index of active piece
     * @param i: row index of potential new location
     * @param j: col index of potential new location
     * @return true if board index is occupied by opposite team
     */
    public boolean occupiedByOtherTeam(int row, int col, int i, int j) {
        return gameBoard.get(new Location(i, j)) != null &&
                !(gameBoard.get(new Location(row, col)).getTeam().equals(gameBoard.get(new Location(i, j)).getTeam()));

    }

    /**
     * Checks for red and blue flag.
     *
     * @return true if both teams have flag remaining, false if one team's flag has been captured
     */
    public boolean hasFlags() {

        boolean redFlagFound = false;
        boolean blueFlagFound = false;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (gameBoard.get(new Location(i, j)) == null) {
                    continue;
                } else if (gameBoard.get(new Location(i, j)).getPieceValue() == 0
                        && gameBoard.get(new Location(i, j)).getTeam().equals("red")) {
                    redFlagFound = true;
                } else if (gameBoard.get(new Location(i, j)).getPieceValue() == 0
                        && gameBoard.get(new Location(i, j)).getTeam().equals("blue")) {
                    blueFlagFound = true;
                }
            }
        }
        if (blueFlagFound && !redFlagFound) {
            System.out.println("Blue Wins!\nRed, better luck next time..."); // blue wins if blue flag remains on board while red's does not
            printBoard();
            return false;
        } else if (redFlagFound && !blueFlagFound) {
            System.out.println("Red Wins!\nBlue, better luck next time...");
            printBoard();
            return false;
        } else {
            return true;
        }
    }

    public boolean canMove() {
        boolean redCanPlay = false;
        boolean blueCanPlay = false;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (gameBoard.get(new Location(i, j)) != null && gameBoard.get(new Location(i, j)).getPieceValue() > 0
                        && gameBoard.get(new Location(i, j)).getPieceValue() < 11) {
                    if (gameBoard.get(new Location(i, j)).getTeam().equals("red")) {
                        redCanPlay = true;
                    }
                    if (gameBoard.get(new Location(i, j)).getTeam().equals("blue")) {
                        blueCanPlay = true;
                    }
                }
            }
            if (redCanPlay && blueCanPlay) {
                break; // avoids unnecessarily scanning entire board
            }
        }
        if (redCanPlay && !blueCanPlay) {
            System.out.println("Red Team Wins!\nFinal Board: ");
            printBoard();
        }
        if (blueCanPlay && !redCanPlay) {
            System.out.println("Blue Team Wins!\nFinal Board");
            printBoard();
        }
        return redCanPlay && blueCanPlay;
    }

    /**
     * Prints board with all gamePiece values visible
     */
    public void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            System.out.println();
            for (int j = 0; j < SIZE; j++) {
                if (gameBoard.get(new Location(i, j)) != null) {
                    System.out.print("|" + gameBoard.get(new Location(i, j)).toString() + "|");
                } else {
                    System.out.print("| |");
                }
            }
        }
    }

    /**
     * Prints board with hidden Blue-Team values
     */
    public void printRedBoard() {
        System.out.print("   0  1  2  3  4  5  6  7  8  9"); // for easier index reference
        for (int i = 0; i < SIZE; i++) {
            System.out.println();
            System.out.print(i + " "); // for easier index reference
            for (int j = 0; j < SIZE; j++) {
                if (gameBoard.get(new Location(i, j)) == null) {
                    System.out.print("| |");
                } else if (gameBoard.get(new Location(i, j)).getTeam().equals("red")) {
                    System.out.print("|" + gameBoard.get(new Location(i, j)).toString() + "|");
                } else if (gameBoard.get(new Location(i, j)).getTeam().equals("black")) {
                    System.out.print("|X|");
                } else {
                    System.out.print("|" + "?" + "|");
                }
            }
        }
        System.out.println();
    }

    /**
     * Prints board with hidden Red-Team Values
     */
    public void printBlueBoard() {
        System.out.print("   0  1  2  3  4  5  6  7  8  9"); // for easier index reference
        for (int i = 0; i < SIZE; i++) {
            System.out.println();
            System.out.print(i + " "); // for easier index reference
            for (int j = 0; j < SIZE; j++) {
                if (gameBoard.get(new Location(i, j)) == null) {
                    System.out.print("| |");
                } else if (gameBoard.get(new Location(i, j)).getTeam().equals("blue")) {
                    System.out.print("|" + gameBoard.get(new Location(i, j)).toString() + "|");
                } else if (gameBoard.get(new Location(i, j)).getTeam().equals("black")) {
                    System.out.print("|X|");
                } else {
                    System.out.print("|" + "?" + "|");
                }
            }
        }
        System.out.println();
    }

    public void clearConsole() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}