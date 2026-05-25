# DIP - Dependency Inversion Principle

## Definicao
Modulos de alto nivel nao devem depender de modulos de baixo nivel; ambos devem depender de abstracoes.
Abstracoes nao devem depender de detalhes; detalhes devem depender de abstracoes.

## Problema no exemplo `antes`
No arquivo `antes/DIPAntes.java`, `CreditApprovalService` instancia diretamente:
- `OracleCustomerRepository`
- `SoapCreditBureauClient`
- `SmtpDecisionNotifier`

A regra de negocio fica acoplada a tecnologias especificas (Oracle, SOAP, SMTP), dificultando evolucao, testes e substituicao de integracoes.

## Solucao no exemplo `depois`
No arquivo `depois/DIPDepois.java`, o servico de negocio depende de contratos:
- `ClientProfileRepository`
- `CreditScoreProvider`
- `CreditDecisionNotifier`

As implementacoes concretas (`Oracle...`, `Rest...`, `EventBus...`) sao detalhes injetados no momento de composicao.

## Beneficios arquiteturais
- nucleo de negocio isolado de infraestrutura
- troca de tecnologia com menor impacto
- facil criacao de doubles para testes
- melhor separacao entre politica e mecanismo

## Ponto de discussao em aula
DIP nao e "usar interface por usar"; o valor aparece quando ha variacao real de infraestrutura, requisitos de teste e evolucao de arquitetura.
