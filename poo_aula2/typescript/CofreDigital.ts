export default class CofreDigital{
    
    // Atributo Privado
    private valor: number = 0;

    // Método de Depósito
    Depositar(v: number): void{
        if(v > 0){
            this.valor = this.valor + v;
        }
    }

    // Método para Visualizar Saldo
    Saldo(): number{
        return this.valor;
    }

    // Método de Saque
    Sacar(v: number): boolean{
        if (v <= this.valor){
            this.valor = this.valor - v;
            return true;
        }
        return false; 
    }
}
