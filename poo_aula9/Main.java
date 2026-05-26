public class Main {
    public static void main(String[] args) {
        
        PoliticaDescontoPremium politicaDescontoPremium = new PoliticaDescontoPremium();
        PedidoItens pedidoItens = new PedidoItens();
        Pedido pedido = new Pedido(pedidoItens, politicaDescontoPremium);

        // TRATAR A REGRA DE 1 PONTO POR LINHA
        pedido.pedidoItens.calculaTotal().floatValue();
        // quem precisa saber o floatValue do total do pedido? o cliente? o sistema de pagamento? o sistema de entrega?

        // pedido.getCliente().getEndereco().getCidade().getName()

        // isso representa um possivel problema de DESIGN do código
        // quem precisa saber o nome da cidade?

        /*
            a solucao é criar métodos auxiliares que representem o que o cliente precisa saber, e nao como o cliente precisa saber
            pedido.getCliente().getCidade();
            para isso sera necessario criar um método getCidade no cliente.            
        */


    }
}
