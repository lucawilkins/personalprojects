import java.util.Objects;
public class Location {
    private int row, col;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return row == location.row && col == location.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }

    public Location(int row, int col) {
        this.row = row;
        this.col = col;


    }

}


