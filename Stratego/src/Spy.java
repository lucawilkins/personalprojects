import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Spy extends GamePiece {
    public Spy(String teamColor, int value) {
        super(teamColor, value);
    }

    @Override
    public String toString() {
        return "S";
    }
}