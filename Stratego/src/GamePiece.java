
public abstract class GamePiece {
    private int pieceValue;
    private String team;

    /**
     * Constructor
     *
     * @param teamColor red or blue team
     */
    public GamePiece(String teamColor, int value) {
        team = teamColor;
        pieceValue = value;
    }

    public String getTeam() {
        return team;
    }

    public int getPieceValue() {
        return pieceValue;
    }
}
