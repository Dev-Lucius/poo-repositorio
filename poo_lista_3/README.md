
# Lista de Exercícios — Herança em Java

## Orientações gerais

* Utilize **classes, atributos, construtores, getters quando necessário e métodos de negócio**.
* Evite criar soluções “hardcoded”.
* Sempre que fizer sentido, use:

  * `abstract class`
  * `protected`
  * sobrescrita com `@Override`
  * `super(...)`
* Em todos os exercícios, o foco principal é **modelar corretamente a hierarquia** e **aplicar regras de negócio coerentes**.



# Exercício 1 — Sistema de funcionários com regras salariais reais

## Contexto

Uma empresa possui diferentes tipos de funcionários, mas todos possuem:

* nome
* matrícula
* salário base

Entretanto, o cálculo do salário final varia conforme o cargo.

## Objetivo

Criar uma hierarquia de funcionários em que a superclasse represente o conceito comum, mas as subclasses implementem regras específicas.

## Regras

Crie uma superclasse abstrata `Funcionario` com:

* `nome`
* `matricula`
* `salarioBase`
* método abstrato `calcularSalarioFinal()`
* método concreto `exibirResumo()`

Crie as subclasses:

* `Desenvolvedor`
* `Gerente`
* `AnalistaSuporte`

### Regras específicas

* `Desenvolvedor`: recebe bônus de 10% sobre o salário base
* `Gerente`: recebe bônus de 20% + auxílio gestão fixo
* `AnalistaSuporte`: recebe adicional por plantão, baseado em quantidade de plantões

## Desafio

A classe base deve concentrar o que é comum, mas sem conhecer detalhes indevidos das subclasses.



# Exercício 2 — Sistema de entrega com cálculo de frete

## Contexto

Uma transportadora trabalha com diferentes tipos de entrega:

* entrega padrão
* entrega expressa
* entrega internacional

Todas possuem:

* destinatário
* peso do pacote
* valor declarado

Mas o cálculo do frete e a validação da entrega mudam conforme o tipo.

## Objetivo

Modelar uma hierarquia `Entrega` que represente bem o domínio.

## Requisitos

Crie a classe abstrata `Entrega` com:

* atributos comuns
* método `validarDados()`
* método abstrato `calcularFrete()`
* método `gerarResumoEntrega()`

Crie:

* `EntregaPadrao`
* `EntregaExpressa`
* `EntregaInternacional`

### Regras

* `EntregaPadrao`: frete baseado apenas no peso
* `EntregaExpressa`: frete do peso + taxa fixa de urgência
* `EntregaInternacional`: frete do peso + taxa alfandegária + percentual sobre valor declarado

## Desafio

Impedir cálculo de frete quando os dados forem inválidos, por exemplo:

* peso menor ou igual a zero
* valor declarado negativo



# Exercício 3 — Sistema acadêmico com avaliação diferente por disciplina

## Contexto

Uma instituição possui diferentes tipos de disciplinas:

* disciplina teórica
* disciplina prática
* disciplina de projeto

Todas possuem:

* nome
* carga horária
* professor responsável

Mas a forma de cálculo da média final é diferente.

## Objetivo

Criar uma classe abstrata `Disciplina` e subclasses com regras distintas de avaliação.

## Requisitos

A superclasse deve ter:

* atributos comuns
* método abstrato `calcularMediaFinal()`
* método concreto `verificarAprovacao()`, considerando média mínima 6.0
* método `exibirSituacao()`

Crie as subclasses:

* `DisciplinaTeorica`
* `DisciplinaPratica`
* `DisciplinaProjeto`

### Regras

* `DisciplinaTeorica`: média entre prova 1 e prova 2
* `DisciplinaPratica`: média entre prática e relatório
* `DisciplinaProjeto`: média ponderada entre entrega parcial, entrega final e apresentação

## Desafio

A superclasse deve usar o resultado do método polimórfico para verificar aprovação sem precisar saber o tipo concreto.



# Exercício 4 — Biblioteca de produtos com imposto e desconto

## Contexto

Um sistema comercial possui produtos com características em comum, mas alguns tipos de produtos têm regras próprias de imposto e desconto.

## Objetivo

Construir uma hierarquia de produtos com regras financeiras mais realistas.

## Requisitos

Crie uma superclasse abstrata `Produto` com:

* nome
* preço base
* método `validarPreco()`
* método abstrato `calcularPrecoFinal()`

Crie:

* `ProdutoFisico`
* `ProdutoDigital`
* `ProdutoImportado`

### Regras

* `ProdutoFisico`: pode ter taxa de envio
* `ProdutoDigital`: não tem frete, mas pode ter taxa de licença
* `ProdutoImportado`: tem imposto de importação adicional

## Desafio

Adicionar um método na classe base para exibir um resumo detalhado, usando o preço final calculado pela subclasse.



# Exercício 5 — Sistema bancário com restrições reais por conta

## Contexto

Um banco oferece diferentes tipos de conta:

* conta corrente
* conta poupança
* conta empresarial

Todas compartilham:

* número
* titular
* saldo

Mas regras de saque, depósito e tarifas variam.

## Objetivo

Criar uma hierarquia útil, com regras de negócio relevantes.

## Requisitos

Crie uma classe abstrata `ContaBancaria` com:

* número
* titular
* saldo
* método `depositar(double valor)`
* método abstrato `sacar(double valor)`
* método `consultarSaldo()`

Crie:

* `ContaCorrente`
* `ContaPoupanca`
* `ContaEmpresarial`

### Regras

* `ContaCorrente`: pode sacar pagando tarifa por operação
* `ContaPoupanca`: não pode sacar além do saldo, sem tarifa
* `ContaEmpresarial`: possui limite de crédito adicional

## Desafio

Modelar corretamente o comportamento da conta empresarial sem duplicar a lógica das demais.



# Exercício 6 — Plataforma de conteúdo com publicações diferentes

## Contexto

Uma plataforma possui vários tipos de publicação:

* notícia
* artigo técnico
* tutorial

Todas possuem:

* título
* autor
* texto base

Mas a forma de exibição resumida e o critério de publicação variam.

## Objetivo

Criar uma hierarquia com regras de validação e exibição.

## Requisitos

Classe abstrata `Publicacao` com:

* atributos comuns
* método `validarPublicacao()`
* método abstrato `gerarResumo()`
* método abstrato `podeSerPublicada()`

Subclasses:

* `Noticia`
* `ArtigoTecnico`
* `Tutorial`

### Regras sugeridas

* `Noticia`: precisa ter título e texto com tamanho mínimo
* `ArtigoTecnico`: precisa ter referências mínimas
* `Tutorial`: precisa ter quantidade mínima de passos

## Desafio

Criar um fluxo em que o sistema percorra várias publicações e publique apenas as válidas.



# Exercício 7 — Sistema de veículos de frota

## Contexto

Uma empresa possui uma frota com diferentes tipos de veículos:

* carro
* caminhão
* moto

Todos possuem:

* placa
* modelo
* consumo base

Mas o cálculo de autonomia e custo operacional é diferente.

## Objetivo

Criar uma hierarquia funcional e não apenas estrutural.

## Requisitos

Classe abstrata `VeiculoFrota` com:

* atributos comuns
* método abstrato `calcularAutonomia(double litros)`
* método abstrato `calcularCustoViagem(double distancia, double precoCombustivel)`
* método `exibirDados()`

Subclasses:

* `Carro`
* `Caminhao`
* `Moto`

### Regras

* `Caminhao` pode ter fator de carga que reduz a autonomia
* `Moto` tem consumo melhor, mas não pode transportar carga pesada
* `Carro` usa consumo padrão

## Desafio

No programa principal, calcular e comparar qual veículo é mais econômico para determinada viagem.



# Exercício 8 — Sistema de membros de assinatura

## Contexto

Uma plataforma possui assinantes com diferentes planos:

* básico
* premium
* corporativo

Todos têm:

* nome
* email
* mensalidade base

Mas os benefícios e o valor final mudam.

## Objetivo

Criar uma hierarquia para representar os planos de assinatura.

## Requisitos

Classe abstrata `PlanoAssinatura` com:

* atributos comuns
* método abstrato `calcularMensalidadeFinal()`
* método abstrato `listarBeneficios()`
* método `exibirPlano()`

Subclasses:

* `PlanoBasico`
* `PlanoPremium`
* `PlanoCorporativo`

### Regras

* `PlanoPremium`: inclui desconto anual opcional
* `PlanoCorporativo`: inclui múltiplos usuários e cobrança por quantidade de licenças
* `PlanoBasico`: regras simples

## Desafio

Criar uma simulação com vários assinantes e exibir quem paga mais e quem possui mais benefícios.



# Exercício 9 — Sistema de ordens de serviço

## Contexto

Uma empresa de manutenção registra ordens de serviço de tipos diferentes:

* elétrica
* hidráulica
* informática

Toda ordem possui:

* número
* cliente
* descrição
* valor base

Mas o orçamento final depende do tipo de serviço.

## Objetivo

Criar uma hierarquia coerente para ordens de serviço.

## Requisitos

Classe abstrata `OrdemServico` com:

* atributos comuns
* método `validar()`
* método abstrato `calcularValorFinal()`
* método `imprimirResumo()`

Subclasses:

* `OrdemEletrica`
* `OrdemHidraulica`
* `OrdemInformatica`

### Regras

* elétrica: taxa de risco adicional
* hidráulica: custo extra por urgência
* informática: custo adicional por horas técnicas

## Desafio

Permitir que o sistema some o total de várias ordens diferentes sem depender do tipo específico.



# Exercício 10 — Jogo com unidades de combate

## Contexto

Um jogo possui diferentes unidades:

* soldado
* arqueiro
* mago

Todas têm:

* nome
* vida
* ataque base
* defesa

Mas cada tipo possui forma diferente de calcular dano e habilidades.

## Objetivo

Criar uma hierarquia mais rica, com regras e estado.

## Requisitos

Classe abstrata `Unidade` com:

* atributos comuns
* método abstrato `atacar(Unidade alvo)`
* método `receberDano(int dano)`
* método `estaViva()`

Subclasses:

* `Soldado`
* `Arqueiro`
* `Mago`

### Regras

* `Soldado`: recebe menos dano por defesa física
* `Arqueiro`: pode causar dano crítico
* `Mago`: pode gastar mana para ataque ampliado

## Desafio

Criar uma batalha simples entre unidades, com turnos, até uma ser derrotada.
