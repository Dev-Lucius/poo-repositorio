# ISP - Interface Segregation Principle

## Definicao
Clientes nao devem ser forçados a depender de metodos que nao utilizam.

## Problema no exemplo `antes`
No arquivo `antes/ISPAntes.java`, `EnterpriseRiskGateway` concentra operacoes heterogeneas (exposicao, stress test, reporte regulatorio, sincronizacao de mercado, incidente operacional).

`IntradayLimitMonitor` precisa apenas de exposicao, mas e obrigado a implementar todos os metodos, gerando `UnsupportedOperationException` e fragilidade de contrato.

## Solucao no exemplo `depois`
No arquivo `depois/ISPDepois.java`, a interface monolitica foi segregada:
- `ExposureQuery`
- `StressTestRunner`
- `RegulatoryReporter`
- `MarketDataSynchronizer`
- `IncidentManager`

`IntradayLimitMonitorV2` depende somente de `ExposureQuery`, reduzindo acoplamento e superficie de erro.

## Beneficios arquiteturais
- contratos mais coesos por contexto
- menor impacto de mudancas em API
- implementacoes mais simples e claras
- reducao de metodos "vazios" ou excecoes artificiais

## Ponto de discussao em aula
ISP e especialmente importante em integracoes externas: APIs muito amplas elevam custo de adaptacao e dificultam testes de consumidor.
