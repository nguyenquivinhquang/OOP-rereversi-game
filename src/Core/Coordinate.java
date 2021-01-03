package Core;

public class Coordinate {
    public int x, y, type;
    public Coordinate() {

    }
    public Coordinate(int x, int y) {
        setXY(x, y);
    }
    public Coordinate(int x, int y, int type) {
        setXYType(x, y, type);
    }
    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void setXYType(int x, int y, int type) {
        setXY(x, y);
        this.type = type;
    }
}
