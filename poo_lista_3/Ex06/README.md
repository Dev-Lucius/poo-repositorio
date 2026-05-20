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
