# LSP - Liskov Substitution Principle

## Definicao
Subtipos devem poder substituir seus tipos base sem quebrar o comportamento esperado pelo cliente.

## Problema no exemplo `antes`
No arquivo `antes/LSPAntes.java`, `ComplianceHoldAccount` herda de `SettlementAccount`, mas sobrescreve `debit` com `UnsupportedOperationException`.

O cliente `DailySettlementJob` assume que toda `SettlementAccount` aceita debito. Essa premissa falha em runtime, caracterizando violacao de LSP.

## Solucao no exemplo `depois`
No arquivo `depois/LSPDepois.java`, o modelo foi refinado por capacidade:
- `BalanceView` para leitura de saldo
- `DebitCapableAccount` para contas que realmente suportam debito
- `CustodyFeeCollector` recebe apenas `DebitCapableAccount`

Contas restritas por compliance permanecem validas no sistema, mas nao sao tratadas como debitaveis.

## Beneficios arquiteturais
- contratos mais precisos
- eliminacao de excecoes por substituicao invalida
- maior seguranca semantica no polimorfismo
- regras de dominio expressas no tipo

## Ponto de discussao em aula
LSP normalmente indica modelagem incorreta de hierarquia. A correcao costuma vir por composicao, segregacao de capacidades ou revisao de invariantes.
