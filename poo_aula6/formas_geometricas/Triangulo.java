package formas_geometricas;

public class Triangulo extends FormaRegular {
    public Triangulo(float comprimentoLado){
        super(3, comprimentoLado);
    }

    @Override
    public float getArea(){
        return (float)(Math.pow(comprimentoLado, 2) * Math.sqrt(3) / 4);
    }
}
