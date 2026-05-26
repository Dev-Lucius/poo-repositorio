
/*
1. Somente um nível de identação por método

*/

import java.math.BigDecimal;


// O PROBLEMA QUE ESSA CLASSE RESOLVE É A GESTAO DO PEDIDO - STATUS (APROVAÇÃO), VALOR, DESCONTO
public class Pedido {

    PedidoItens pedidoItens;
    // private List<Item> itens;    // quando olhamos assim - é uma variavel que nao tem REGRA DE NEGOCIO associada

    private String status;
    private String pagamento;
    private IPoliticaDesconto politicaDesconto;
    
    public Pedido(PedidoItens pedidoItens, IPoliticaDesconto politicaDesconto) {
        this.pedidoItens = pedidoItens;
        // this.itens = new ArrayList<>();
        this.status = "Pendente";
        this.pagamento = "Não Pago";
        this.politicaDesconto = politicaDesconto;
    }

    // cria pedido
    // a inversao de dependencia faz com que os objetos injetados já tenham sido validados pelo seu proprio dominio.
    // altera o design para receber como parametro da classe ou da funcao os objetos que ja estao prontos para o uso.
    // para o banco de dados podemos utilizar um Repository/DAO
    // para email pode utilizar um sistema de notificação
    public void create() {
        // valida o pedido
        // valida cliente
        // valida itens
        // calcula total
        // calcula frete
        // calcula desconto
        // salva no banco
        // envia email
        // baixa no estoque
        // gera nota fiscal
        // manda nota fiscal para o cliente
        // etc etc etc
    }


    public BigDecimal total() {
        // total dos itens
        // - desconto
        // + entrega
        BigDecimal total = pedidoItens.calculaTotal();

        float desconto = calcularDesconto(null, total.floatValue());
        total = total.subtract(BigDecimal.valueOf(desconto));

        float entrega = calcularTaxaEntrega(12.0f);
        total = total.add(BigDecimal.valueOf(entrega));

        return total;
    }

    // remover item
    // atualizar/alterar item
    // sei la quantas outras opcoes

    /*
    problema nas strings (lembrar enum)
    LEGIBILIDADE BAIXA
    código muito sensível a qualquer modificação
    falta de métodos auxiliares
    responsabilidade mal distribuida SRP
    */
    // public void aprovar() {
    //     if (itens == null || itens.isEmpty()) {
    //         if (!this.status.equals("Cancelado")) {
    //             if (this.pagamento.equals("Pago")) {
    //                 this.status = "Aprovado";
    //             }
    //         }
    //     }
    // }

    // código refatorado
    /*
        - early return
        - o que pode ser separado em métodos auxiliares (a fim de facilitar a leitura)
    */
    public void aprovarMelhor() {
        if (pedidoItens.quantosItens() == 0) {
            return;
        }
        if (isCancelado()) {
            return;
        }
        if (!isPago()) {
            return;
        }
        this.status = "Aprovado";
    }

    // REGRA 2 - NAO UTILIZAR ELSE
    public float calcularTaxaEntrega(float distancia) {
        // if (distancia <= 5) {
        //     return 10.0f;
        // } else if (distancia <= 10) {
        //     return 15.0f;
        // } else {
        //     return 20.0f;
        // }

        if (distancia <= 5) {
            return 10.0f;
        }

        if (distancia <= 10) {
            return 15.0f;
        }

        return 20.0f;
    }

    public float calcularDesconto(Cliente cliente, float total) {
        // if (cliente.isVip()) {
        //     return total * 0.1f;
        // } else if (cliente.isSuperPremium()) {
        //     return total * 0.15f;
        // } else if (cliente.isNew()) {
        //     return total * 0.05f;
        // } else {
        //     return 0.0f;
        // }
        return politicaDesconto.calcularDesconto(total);
    }

    private boolean isCancelado() {
        return this.status.equals("Cancelado");
    }

    private boolean isPago() {
        return this.pagamento.equals("Pago");
    }
}
