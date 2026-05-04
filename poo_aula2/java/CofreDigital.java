public class CofreDigital{
    
    // Não tem Visibilidade Declarada
    // O Main consegue Visualizar / Editar
    // private -> Outras Classes (como o Main) não podem acessá-la
    private int valor = 0; // Variável Declarado no Corpo da Classe --> Vira um Atributo !!

    // Regra!
    // Método --> public
    // Atributo --> private

    // Método de Depósito
    public void Depositar(int v){
        if(v > 0){
            valor = valor + v;
        }
    }

    // Método para Visualizar o Saldo
    public int Saldo(){
        return valor;
    }

    public boolean Sacar(int v){
        
        if(v <= valor){
            valor = valor - v;
            return true;
        }
        return false;
    }
}
