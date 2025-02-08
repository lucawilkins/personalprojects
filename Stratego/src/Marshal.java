import java.util.ArrayList;
import java.util.Arrays;

public class Marshal extends GamePiece {
    public Marshal(String teamColor, int value) {
        super(teamColor, value);
    }
    @Override
    public String toString() {
        return "M";
    }
}
