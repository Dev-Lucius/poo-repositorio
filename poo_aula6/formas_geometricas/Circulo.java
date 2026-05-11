package formas_geometricas;

public class Circulo extends Forma{
    private float raio;

    public Circulo(float raio){
        this.raio = raio;
    }

    @Override
    public float getArea(){
        return (float)(Math.PI * Math.pow(raio, 2));
    }

    @Override
    public float getPerimetro(){
        return (float)(Math.PI * raio * 2);
    }
}
