public class Punto {
    private int x;
    private int y;
    public Punto(){
        this.x = 0;
        this.y = 0;
    }
    public Punto(int x, int y){
        this.x = x;
        this.y = y;
    }
    public Punto(Punto otro){
        this.x = otro.x;
        this.y = otro.y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("(x: %d, y: %d)", this.x, this.y);
    }
}
