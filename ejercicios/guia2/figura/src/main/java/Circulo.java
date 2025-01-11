public class Circulo implements Figura{
    private final double radio;

    public Circulo(double radio){
        this.radio = radio;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radio, 2);
    }
}
