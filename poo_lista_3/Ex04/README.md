
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