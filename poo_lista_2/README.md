# Lista de exercícios

1. Crie uma classe `Pessoa`  com os atributos `nome` e `idade`, ambos privados.

   * Crie getters e setters.
   * Não permita idade negativa.

2. Crie uma classe `Produto` com:

   * `nome`
   * `preco`
   * construtor
   * método para exibir os dados

3. Crie uma classe `Livro` com:

   * `titulo`
   * `autor`
   * `numeroPaginas`
   * construtor
   * getters para todos os atributos

4. Crie uma classe `Funcionario` com:

* `nome`
* `salario`
* setter que impeça salário negativo

5. Crie uma classe `Motor` e uma classe `Carro`.

* `Carro` deve possuir um atributo do tipo `Motor`.
* Crie um método para exibir os dados do carro e do motor.

6. Crie uma classe `Cliente` e uma classe `Pedido`.

* `Pedido` deve estar associado a `Cliente`.

7. Crie uma classe `Professor` e uma classe `Turma`.

* `Turma` deve possuir referência para `Professor`.

8. Crie uma classe `Departamento` e uma classe `Funcionario`.

* Cada funcionário deve pertencer a um departamento.

9. Crie uma classe `Filme` e uma classe `Diretor`.

* Um filme deve armazenar o diretor responsável.

10. Crie uma classe `ContaBancaria` com saldo e método `depositar`.
    Depois, crie uma classe `CaixaEletronico` com um método que receba uma `ContaBancaria` por parâmetro e faça um depósito.

11. Crie uma classe `Aluno` com atributo `nota`.
    Crie um método em outra classe que receba um aluno por parâmetro e altere sua nota.

12. Crie uma classe `Lampada` com atributo `ligada`.
    Crie uma classe `Interruptor` com método que receba uma lâmpada e altere seu estado.

13. Crie uma classe `Carrinho` com quantidade de itens.
    Crie uma classe `Loja` com método que receba um carrinho por parâmetro e adicione item.

14. Crie uma classe `Usuario` com atributo `email`.
    Crie um método em uma classe `Sistema` que receba um usuário por parâmetro e altere o email.


15. Crie um sistema com as classes:

* `Autor`
* `Livro`
* `Biblioteca`

Regras:

* `Livro` deve estar associado a `Autor`
* `Biblioteca` deve receber um `Livro` por parâmetro em um método de cadastro
* crie métodos para exibir os dados

16. Crie um sistema com:

* `Paciente`
* `Medico`
* `Consulta`

Regras:

* `Consulta` deve associar um paciente a um médico
* use construtores e getters
* crie um método para exibir resumo da consulta

17. Crie um sistema com:

* `Jogador`
* `Time`
* `Tecnico`

Regras:

* `Time` deve ter associação com `Tecnico`
* `Jogador` deve estar associado a `Time`

18. Crie um sistema com:

* `Cliente`
* `Produto`
* `Venda`

Regras:

* `Venda` deve estar associada a `Cliente`
* `Venda` deve receber um `Produto` por parâmetro em método de adicionar item

19. Crie um sistema acadêmico com:

* `Aluno`
* `Disciplina`
* `Professor`

Regras:

* `Disciplina` associada a `Professor`
* `Aluno` associado a `Disciplina`
* crie construtores, getters e ao menos um setter com validação
