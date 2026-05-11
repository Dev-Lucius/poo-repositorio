package poo_ex17;

import java.util.ArrayList;
import java.util.List;

public class Time{

    private String nome;
    private Tecnico tecnico;
    private List<Jogador> jogadores;

    public String getNome() {
        return nome;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public Time(String nome, Tecnico tecnico){
        setNome(nome);
        this.tecnico = tecnico;
        this.jogadores = new ArrayList<>();
    }

    public void setNome(String nome){
        if(nome == null || nome.trim().isEmpty()){
            System.out.println("Nome Inválido");
        } else {
            this.nome = nome;
        }
    }

    public void adicionarJogador(Jogador jogador){
        if(jogador == null){
            System.out.println("Jogador Inválido");
        } else if(jogadores.contains(jogador)){
            System.out.println("Jogador Já Está nesse Time");
            return;
        } else {
            jogadores.add(jogador);
            System.out.println("Jogador Adicionado com Sucesso");
        }
    }

    public void totalJogadores(){
        if(jogadores.isEmpty()){
            System.out.println("Este time não possui Jogadores");
        } else {
            for (Jogador jogador : jogadores) {
                System.out.println(jogador);
            }
        }
    }

    @Override
    public String toString(){
        return  "Time: " + nome +
                "\nTécnico: " + tecnico.getNome();
    }
}