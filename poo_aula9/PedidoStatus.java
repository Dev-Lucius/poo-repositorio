public class PedidoStatus {
    
    private PedidoStatusEnum status;

    public PedidoStatus() {
        this.status = PedidoStatusEnum.PENDENTE;
    }

    public PedidoStatusEnum getStatus() {
        return status;
    }

    public void cancelar() {
        this.status = PedidoStatusEnum.CANCELADO;
    }

    public void aprovar() {
        if (status != PedidoStatusEnum.PENDENTE) {
            throw new IllegalStateException("Pedido não pode ser aprovado");
        }

        this.status = PedidoStatusEnum.APROVADO;

    }

}
