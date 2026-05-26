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