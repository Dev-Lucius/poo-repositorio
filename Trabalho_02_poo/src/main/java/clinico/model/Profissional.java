package clinico.model;

import clinico.enums.TipoProfissional;

public class Profissional {

    private String nome;
    private String registroProfissional;
    private TipoProfissional tipo;

    public Profissional(String nome, String registroProfissional, TipoProfissional tipo) {
        this.nome = nome;
        this.registroProfissional = registroProfissional;
        this.tipo = tipo;
    }

    public String getNome() { return nome; }
    public String getRegistroProfissional() { return registroProfissional; }
    public TipoProfissional getTipo() { return tipo; }

    @Override
    public String toString() {
        return nome + " [" + tipo + " - " + registroProfissional + "]";
    }
}
