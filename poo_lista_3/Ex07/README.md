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