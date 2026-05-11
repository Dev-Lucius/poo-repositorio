package Atv_03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContaBancaria {

    private int id;
    private String titular;
    private String cpf;
    private double saldo;
    private List<Transacao> historico; // <-- Uma lista para as transações

    // Construtor da ContaBancaria
    public ContaBancaria(int id, String titular, String cpf, double saldo){
        setId(id);
        setTitular(titular);
        setCPF(cpf);
        this.saldo = saldo;
        this.historico = new ArrayList<>();
    }

    public void setId(int id){
        if(id <= 0){
            System.out.println("Inválido");
        } else {
            this.id = id;
        }
    }

    public void setTitular(String titular){
        if(titular == null || titular.trim().isEmpty()){
            System.out.println("Nome Inválido para Titular");
        } else {
            this.titular = titular;
        }
    }

    public void setCPF(String cpf){
        if(cpf == null || cpf.trim().isEmpty()){
            System.out.println("CPF Inválido");
        } else if(cpf.length() != 11) {
            System.out.println("CPF Inválido");
        } else {
            this.cpf = cpf;
        }
    }

    public void depositar(double v){
        if(v <=0 ){
            System.out.println("Valor para depósito Inválido");
        } else {
            System.out.println("Seu Depósito de " + v + " foi realizado com sucesso");
            this.saldo += v;
            // Registro no histórico
            historico.add(new Transacao("depósito", v)); 
        }
    }

    public void sacar(double v){
        if(v <= 0 || v > saldo){
            System.out.println("Valor Inválido para Saque");
        } else {
            System.out.println("Seu Saque de " + v + " foi realizado com sucesso");
            this.saldo -= v;
            // Registro no histórico
            historico.add(new Transacao("Saque", v));
        }
    }

    public double consultarSaldo(){
        return saldo;
    }

    public List<Transacao> getHistorico() {
        // método utilitário que cria uma visualização (view) somente leitura de uma lista original
        // Qualquer tentativa de modificar essa nova lista, lançará um erro
        return Collections.unmodifiableList(historico);
    }
}
