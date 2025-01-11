public class Cuadrado implements Figura{
    private double lado;
    public Cuadrado(double lado){
        this.lado = lado;
    }
    @Override
    public double area() {
        return Math.pow(lado, 2);
    }
}
