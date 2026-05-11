package veiculos;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Veiculo a = new Veiculo("Carro", "FIAT", "FASTBACK", 2021);
        a.exibirInfo();

        Moto moto = new Moto("Yamaha", "MT-07", 2020, "Guidão esportivo");
        moto.exibirInfo();  // exibirInfo é herdado da classe Veiculo

        Carro carro = new Carro("Honda", "Civic", 2019);

        Veiculo veiculo = new Veiculo("Caminhao", "Scania", "R500", 2018);

        List<Veiculo> veiculos = new ArrayList<>();
        veiculos.add(a);
        veiculos.add(moto);
        veiculos.add(carro);
        veiculos.add(veiculo);

        veiculos.forEach(Veiculo::exibirInfo);

        // NAO É ISSO! new Casa(new Comodo())
    }
}