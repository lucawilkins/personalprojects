import java.util.ArrayList;

public class Lake extends GamePiece {
    public Lake(String teamColor, int value) {
        super(teamColor, value);
    }
    @Override
    public String toString() {
        return "X";
    }
}
