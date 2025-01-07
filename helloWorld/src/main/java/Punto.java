public class Punto {
    int x;
    int y;
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
}
