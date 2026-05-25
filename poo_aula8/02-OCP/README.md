# OCP - Open/Closed Principle

## Definicao
Entidades de software devem estar abertas para extensao e fechadas para modificacao.

## Problema no exemplo `antes`
No arquivo `antes/OCPAntes.java`, `ShippingCostService` usa `if/else` por tipo de modal (`ROAD`, `AIR`, `SEA`, `RAIL`).
Para incluir um novo modal, e necessario alterar a classe existente, aumentando risco de regressao.

## Solucao no exemplo `depois`
No arquivo `depois/OCPDepois.java`, o calculo foi encapsulado em estrategias:
- `ShippingCostPolicy` define o contrato
- cada modal implementa sua politica (`RoadShippingPolicy`, `AirShippingPolicy`, etc.)
- `ShippingCostCalculator` apenas seleciona a politica adequada

Novo modal (`DroneShippingPolicy`) e adicionado por extensao, sem alterar o comportamento central.

## Beneficios arquiteturais
- inclusao de novas regras sem alterar codigo estabilizado
- reducao de regressao em fluxos existentes
- melhoria de isolamento para testes por estrategia
- evolucao orientada a plugins/regras

## Ponto de discussao em aula
Mesmo com OCP, existe decisao de descoberta da politica (lista, mapa, DI container). Essa decisao define flexibilidade versus simplicidade.
