package composicao_dois;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Representa uma Empresa que pode ser Matriz ou Filial.
 *
 * CONCEITO — COMPOSIÇÃO:
 * As Filiais são partes integrantes da Empresa Matriz. Se a Matriz
 * deixar de existir, todas as suas Filiais perdem o sentido junto.
 * Isso caracteriza uma Composição: o ciclo de vida das partes
 * (Filiais) está atrelado ao ciclo de vida do todo (Matriz).
 *
 * CONCEITO — AUTO-REFERÊNCIA (Self-Reference):
 * Uma classe pode conter referências a objetos do seu próprio tipo.
 * Aqui, uma Empresa (Matriz) possui uma lista de Empresas (Filiais).
 * Isso é um padrão muito comum em estruturas hierárquicas.
 *
 * CONCEITO — ENCAPSULAMENTO:
 * Todos os atributos são privados. O estado interno do objeto
 * só é alterado por meio de métodos públicos controlados.
 */
public class Empresa {

    // Nome da empresa — imutável após a criação
    private final String nome;

    /**
     * CONCEITO — FLAG BOOLEANA:
     * O atributo "filial" funciona como uma "bandeira" (flag) que
     * indica o papel desta instância na hierarquia.
     * false → esta instância é uma Matriz
     * true  → esta instância é uma Filial
     * Começa como false pois toda empresa é criada como Matriz por padrão.
     */
    private boolean filial;

    /**
     * Lista de filiais da Matriz.
     * Começa como null e só é inicializada quando a primeira filial
     * é adicionada — técnica chamada de "Lazy Initialization"
     * (inicialização preguiçosa): evita alocar memória desnecessária
     * para empresas que nunca terão filiais.
     */
    private List<Empresa> filiais;

    /**
     * Construtor da Empresa.
     *
     * CONCEITO — ESTADO INICIAL:
     * Toda empresa começa como Matriz (filial = false) e sem filiais
     * (filiais = null). O papel de Filial só é atribuído posteriormente,
     * pelo método addFilial() da Matriz.
     *
     * @param nome Nome da empresa. Não pode ser nulo ou vazio.
     * @throws IllegalArgumentException se o nome for inválido.
     */
    public Empresa(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome da empresa inválido: não pode ser nulo ou vazio.");
        }

        this.nome = nome.trim();
        this.filial = false;   // começa como Matriz
        this.filiais = null;   // sem filiais até que addFilial() seja chamado
    }

    /**
     * Adiciona uma Filial a esta Empresa Matriz.
     *
     * CONCEITO — COMPOSIÇÃO NO MÉTODO:
     * Este método estabelece a relação de composição: a Empresa
     * recebida passa a ser "parte" desta Matriz. Sua flag "filial"
     * é marcada como true, indicando que ela não é mais independente.
     *
     * CONCEITO — EXCEPTION CHECKED:
     * O "throws Exception" na assinatura indica que este método pode
     * lançar uma exceção verificada (checked exception). Isso força
     * quem chama o método a tratar o erro com try/catch ou propagar
     * com throws — o compilador exige isso.
     *
     * CONCEITO — LAZY INITIALIZATION:
     * A lista de filiais só é criada na primeira vez que este método
     * é chamado, economizando memória para empresas sem filiais.
     *
     * CONCEITO — RETORNO DO PRÓPRIO OBJETO:
     * Retornar a própria "empresa" adicionada permite encadear
     * operações ou guardar a referência da filial criada diretamente:
     * Ex: Empresa filial1 = matriz.addFilial(new Empresa("Filial SP"));
     *
     * @param empresa Empresa a ser adicionada como filial.
     * @return a própria empresa adicionada como filial.
     * @throws Exception se esta empresa já for uma Filial (filiais não podem ter filiais).
     */
    public Empresa addFilial(Empresa empresa) throws Exception {

        // Lazy Initialization: inicializa a lista apenas na primeira chamada
        if (filiais == null && !this.filial) {
            this.filiais = new ArrayList<>();
        }

        // Verifica se esta empresa é uma Matriz antes de adicionar filiais
        // Uma Filial não pode ter suas próprias filiais — regra de negócio
        if (!this.filial) {
            this.filiais.add(empresa);

            // Marca a empresa adicionada como Filial
            // Isso é Composição: a Matriz "toma posse" da Filial
            empresa.filial = true;

            return empresa; // retorna a filial para uso externo se necessário
        }

        // Se chegou aqui, esta empresa é uma Filial tentando adicionar outra Filial
        // Lança uma exceção com mensagem clara sobre a regra violada
        throw new Exception("Filiais não podem ter filiais.");
    }

    /**
     * Getter da lista de filiais.
     *
     * CONCEITO — DEFENSIVE COPY:
     * Retorna uma visão somente-leitura da lista para evitar
     * modificações externas que burlariam as regras do addFilial().
     * Retorna lista vazia se ainda não houver filiais (evita null).
     *
     * @return lista imutável de filiais, ou lista vazia se não houver.
     */
    public List<Empresa> getFiliais() {
        if (filiais == null) {
            return Collections.emptyList(); // evita retornar null — boa prática
        }
        return Collections.unmodifiableList(filiais);
    }

    /**
     * Indica se esta empresa é uma Filial.
     *
     * CONCEITO — GETTER DE BOOLEANO:
     * Por convenção, getters de atributos booleanos em Java usam
     * o prefixo "is" em vez de "get" — ex: isFilial() em vez de getFilial().
     *
     * @return true se for Filial, false se for Matriz.
     */
    public boolean isFilial() {
        return filial;
    }

    /**
     * Sobrescrita do toString() para identificar o papel da Empresa.
     *
     * CONCEITO — @Override:
     * A representação muda dinamicamente com base no estado do objeto:
     * o mesmo tipo (Empresa) se apresenta de formas diferentes
     * dependendo do valor do atributo "filial".
     *
     * @return "MATRIZ <nome>" ou "FILIAL <nome>" conforme o papel.
     */
    @Override
    public String toString() {
        if (!filial) {
            return "MATRIZ - " + nome;
        } else {
            return "FILIAL - " + nome;
        }
    }
}