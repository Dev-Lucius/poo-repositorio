package exemplo2;

public class Main {
    public static void main(String[] args) {
        
        List<IFazivel> coisas = new ArrayList<IFazivel>();

        coisas.add(new Tesoura());  // corte
        coisas.add(new Comediante());  // faz piada
        coisas.add(new Programador());  // programa
        coisas.add(new Virus());  // faz doenca

        for (IFazivel coisa : coisa) {
            coisa.faz();
        }

    }
}
