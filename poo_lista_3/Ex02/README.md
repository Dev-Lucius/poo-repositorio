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
