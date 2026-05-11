package formas_geometricas;

abstract class FormaRegular extends Forma{

    protected int numLados;
    protected float comprimentoLado;

    public FormaRegular(int numLados, float comprimentoLado){
        this.numLados = numLados;
        this.comprimentoLado = comprimentoLado;
    }

    public abstract float getArea();

    public float getPerimetro(){
        return numLados * comprimentoLado;
    }
}
