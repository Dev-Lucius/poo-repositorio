package formas_geometricas;

public class Quadrado extends FormaRegular{

    public Quadrado(float comprimentoLado){
        super(4, comprimentoLado);
    }

    @Override
    public float getArea(){
        return comprimentoLado * comprimentoLado;
    }
}
