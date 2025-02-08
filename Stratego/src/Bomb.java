import java.util.ArrayList;
import java.util.Arrays;

public class Bomb extends GamePiece {
    public Bomb(String teamColor, int value) {
        super(teamColor, value);
    }

    @Override
    public String toString() {
        return "B";
    }
}
