package poo_ex17;

public class Jogador{

    private int id;
    private String nome;
    private String posicao;
    private Time time;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getPosicao() {
        return posicao;
    }
    
    public Time getTime() {
        return time;
    }

    public Jogador(int id, String nome, String posicao, Time time){
        setId(id);
        setNome(nome);
        setPosicao(posicao);
        this.time = time;
    }

    public void setId(int id){
        if(id <= 0){
            System.out.println("ID Inválida");
        } else{
            this.id = id;
        }
    }

    public void setNome(String nome){
        if(nome.trim().isEmpty() || nome == null){
            System.out.println("Nome Inválido");
        } else {
            this.nome = nome;
        }
    }

    public void setPosicao(String posicao){
        if(posicao.trim().isEmpty() || posicao == null){
            System.out.println("Posição Inválida");
        } else {
            this.posicao = posicao;
        }
    }

    @Override
    public String toString(){
        return  "\nJogador: " + nome + 
                "\nPosição: " + posicao + 
                "\nTime: " + time.getNome();
    }
}