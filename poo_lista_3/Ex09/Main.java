package Ex09;

public class Main {
    public static void main(String[] args) {

        // ORDEM ELÉTRICA
        OrdemEletrica ordem_eletrica = new OrdemEletrica(1, "Rodrigo Souza", "Troca de Resistência no Maquinário",
                1200.00, true);

        // ORDEM HIDRAULICA
        OrdemHidraulica ordem_hidraulica = new OrdemHidraulica(2, "Felipe Sanchez",
                "Compras de Materias de Tubulação Para Estoque Interno", 2300.00, false);

        // ORDEM INFORMATICA
        OrdemInformatica ordem_informatica = new OrdemInformatica(3, "Paolo Gomes",
                "Troca de Placa de Vídeo nos Computadores do Setor de Engenharia", 1650.00, 4);

        // Validação 
        // Ordem Elétrica
        ordem_eletrica.validar();
        System.out.println(
                "Valor Final: " + 
                ordem_eletrica.calcularValorFinal()
        );

        // Ordem Hidráulica
        ordem_hidraulica.validar();
        System.out.println(
                "Valor Final: " + 
                ordem_hidraulica.calcularValorFinal()
        );

        // Ordem Informatica
        ordem_informatica.validar();
        System.out.println(
                "Valor Final: " + 
                ordem_informatica.calcularValorFinal()
        );
    }
}
