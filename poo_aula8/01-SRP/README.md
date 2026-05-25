# SRP - Single Responsibility Principle

## Definicao
O principio da responsabilidade unica estabelece que uma classe deve ter apenas um motivo para mudar.

## Problema no exemplo `antes`
No arquivo `antes/SRPAntes.java`, a classe `InvoiceProcessor` concentra multiplas responsabilidades:
- valida dados da fatura
- calcula imposto
- persiste em banco
- envia notificacao por e-mail
- publica auditoria

Essa concentracao aumenta acoplamento e dificulta manutencao, testes e evolucao. Mudancas em qualquer uma dessas regras afetam a mesma classe.

## Solucao no exemplo `depois`
No arquivo `depois/SRPDepois.java`, as responsabilidades foram separadas por papeis:
- `InvoiceValidator` para validacao
- `TaxPolicy` para calculo fiscal
- `InvoiceRepository` para persistencia
- `BillingNotifier` para notificacoes
- `AuditPublisher` para auditoria
- `InvoiceApplicationService` para orquestracao

## Beneficios arquiteturais
- menor impacto de mudanca
- maior testabilidade por componente
- substituicao simples de implementacoes
- melhor legibilidade e governanca de regras de negocio

## Ponto de discussao em aula
A classe de orquestracao nao viola SRP: ela possui uma responsabilidade clara, coordenar o caso de uso de emissao de fatura.
