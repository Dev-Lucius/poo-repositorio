# Object Calisthenics com Java e POO

## 1. Objetivo da aula

1. Entender o que é **Object Calisthenics**.
2. Relacionar Object Calisthenics com **Programação Orientada a Objetos**.
3. Aplicar as principais regras em código Java.
4. Refatorar código procedural/anêmico para código mais orientado a objetos.
5. Identificar quando essas regras ajudam e quando podem ser excessivas.

Object Calisthenics é um conjunto de exercícios de programação orientada a objetos popularizado por **Jeff Bay** no livro *The ThoughtWorks Anthology*. A ideia central é usar restrições rígidas para treinar melhor design de código, especialmente encapsulamento, coesão, baixo acoplamento e distribuição adequada de responsabilidades. ([developerhandbook.stakater.com][1])

---

# 2. O que é Object Calisthenics?

**Object Calisthenics** pode ser entendido como uma “ginástica” para treinar código orientado a objetos.

Assim como uma pessoa faz exercícios físicos para melhorar postura, força e controle corporal, o programador usa Object Calisthenics para melhorar:

* encapsulamento;
* expressividade;
* coesão;
* baixo acoplamento;
* distribuição de comportamento;
* redução de código procedural dentro de classes;
* redução de objetos anêmicos.

Object Calisthenics não é um design pattern. Também não é uma arquitetura. É um conjunto de **regras de treino** para forçar o programador a escrever código mais orientado a objetos. Essas regras não precisam ser aplicadas literalmente em todo projeto real, o tempo todo. Elas são mais úteis como exercício de refatoração, estudo e melhoria de design. ([Softensity][2])

---

# 3. Problema que Object Calisthenics tenta resolver

Muitos códigos Java parecem orientados a objetos apenas porque usam classes.

Exemplo ruim:

```java
public class Order {
    public List<OrderItem> items;
    public double discount;
    public String status;
}
```

E em outro lugar:

```java
public class OrderService {

    public double calculateTotal(Order order) {
        double total = 0;

        for (OrderItem item : order.items) {
            total += item.price * item.quantity;
        }

        if (order.discount > 0) {
            total = total - order.discount;
        }

        return total;
    }

    public void approve(Order order) {
        if (order.status.equals("PENDING")) {
            order.status = "APPROVED";
        }
    }
}
```

Esse código usa classes, mas a lógica está concentrada em serviços externos. A classe `Order` é praticamente uma estrutura de dados pública.

Isso é comum em sistemas Java:

```java
getX();
setX();
getY();
setY();
service.doEverything(entity);
```

Object Calisthenics tenta combater esse estilo, forçando o aluno a perguntar:

> “Quem deveria ser responsável por esse comportamento?”

Em POO, objetos não devem ser apenas pacotes de dados. Eles devem proteger seu próprio estado e expor comportamentos significativos.

---

# 4. As 9 regras de Object Calisthenics

As nove regras geralmente associadas a Object Calisthenics são: um nível de indentação por método, não usar `else`, encapsular primitivos e strings, usar coleções de primeira classe, usar apenas um ponto por linha, não abreviar nomes, manter entidades pequenas, não ter classes com mais de dois atributos de instância e evitar getters/setters/properties. ([bolcom.github.io][3])

Vamos estudar cada uma com exemplos em Java.

---

# 5. Regra 1 — Apenas um nível de indentação por método

## Ideia

Um método não deve ter muitos blocos aninhados.

Código com muitos níveis de indentação costuma indicar:

* método fazendo coisas demais;
* mistura de validação, regra de negócio e iteração;
* baixa legibilidade;
* ausência de métodos auxiliares;
* responsabilidades mal distribuídas.

## Exemplo ruim

```java
public void approve(Order order) {
    if (order != null) {
        if (order.hasItems()) {
            if (order.isPaid()) {
                if (!order.isCancelled()) {
                    order.approve();
                }
            }
        }
    }
}
```

Esse código tem vários níveis de indentação. A leitura fica difícil.

## Refatoração 1: usar retornos antecipados

```java
public void approve(Order order) {
    if (order == null) {
        return;
    }

    if (!order.hasItems()) {
        return;
    }

    if (!order.isPaid()) {
        return;
    }

    if (order.isCancelled()) {
        return;
    }

    order.approve();
}
```

Melhorou a indentação, mas ainda temos muita lógica sobre o pedido fora do próprio pedido.

## Refatoração 2: levar regra para o objeto

```java
public class Order {

    private final List<OrderItem> items;
    private OrderStatus status;
    private boolean paid;

    public void approve() {
        if (!canBeApproved()) {
            throw new IllegalStateException("Order cannot be approved.");
        }

        this.status = OrderStatus.APPROVED;
    }

    private boolean canBeApproved() {
        return hasItems() && paid && !isCancelled();
    }

    private boolean hasItems() {
        return !items.isEmpty();
    }

    private boolean isCancelled() {
        return status == OrderStatus.CANCELLED;
    }
}
```

Agora a regra pertence ao objeto `Order`.

O serviço pode ficar simples:

```java
public class OrderService {

    public void approve(Order order) {
        order.approve();
    }
}
```

## Discussão didática

A regra não significa que todo método com dois níveis de indentação é automaticamente errado. O objetivo é forçar o aluno a perceber métodos grandes e extraí-los em comportamentos menores.

---

# 6. Regra 2 — Não usar `else`

## Ideia

O `else` frequentemente aparece quando o método está controlando muitos caminhos possíveis.

Object Calisthenics incentiva:

* retorno antecipado;
* polimorfismo;
* objetos de estado;
* guard clauses;
* separação de responsabilidades.

## Exemplo ruim

```java
public double calculateShipping(Order order) {
    if (order.isExpress()) {
        return 50.0;
    } else {
        return 20.0;
    }
}
```

Esse exemplo é pequeno, mas já pode ser melhorado.

## Sem `else`

```java
public double calculateShipping(Order order) {
    if (order.isExpress()) {
        return 50.0;
    }

    return 20.0;
}
```

## Exemplo mais problemático

```java
public double calculateDiscount(Customer customer, double total) {
    if (customer.isVip()) {
        return total * 0.15;
    } else if (customer.isPremium()) {
        return total * 0.10;
    } else if (customer.isNewCustomer()) {
        return total * 0.05;
    } else {
        return 0;
    }
}
```

Aqui o problema não é apenas o `else`. O problema é que a regra de desconto está concentrada em condicionais.

## Refatoração usando polimorfismo

```java
public interface DiscountPolicy {
    Money calculate(Money total);
}
```

```java
public class VipDiscountPolicy implements DiscountPolicy {

    @Override
    public Money calculate(Money total) {
        return total.percentage(15);
    }
}
```

```java
public class PremiumDiscountPolicy implements DiscountPolicy {

    @Override
    public Money calculate(Money total) {
        return total.percentage(10);
    }
}
```

```java
public class NoDiscountPolicy implements DiscountPolicy {

    @Override
    public Money calculate(Money total) {
        return Money.zero();
    }
}
```

Uso:

```java
public class Order {

    private final Money total;
    private final DiscountPolicy discountPolicy;

    public Money discount() {
        return discountPolicy.calculate(total);
    }
}
```

## Discussão didática

A regra “não use `else`” não significa que `else` é proibido na vida real. Ela serve para treinar alternativas melhores, principalmente quando há muitos fluxos condicionais.

Em sistemas orientados a objetos, muitos `ifs` baseados em tipo, status ou categoria podem indicar uma oportunidade para usar polimorfismo.

---

# 7. Regra 3 — Encapsule primitivos e strings

## Ideia

Tipos primitivos como `String`, `int`, `double`, `BigDecimal` e `boolean` frequentemente carregam regras de domínio que ficam espalhadas pelo sistema.

Exemplo:

```java
public class Customer {
    private String email;
    private String cpf;
    private String phone;
}
```

A princípio parece normal. Mas onde ficam as regras?

* Validação de e-mail.
* Formatação do CPF.
* Comparação de CPF.
* Normalização de telefone.
* Proibição de e-mail vazio.

Se tudo isso fica espalhado em services, validators e controllers, o domínio fica fraco.

## Exemplo ruim

```java
public class CustomerService {

    public void register(String name, String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email.");
        }

        Customer customer = new Customer(name, email);
        // salvar cliente
    }
}
```

## Refatoração criando Value Object

```java
public final class Email {

    private final String value;

    public Email(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Email is required.");
        }

        if (!value.contains("@")) {
            throw new IllegalArgumentException("Invalid email.");
        }

        this.value = value.toLowerCase();
    }

    public String value() {
        return value;
    }
}
```

Agora `Customer` usa `Email`:

```java
public class Customer {

    private final String name;
    private final Email email;

    public Customer(String name, Email email) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name is required.");
        }

        this.name = name;
        this.email = email;
    }
}
```

Uso:

```java
Email email = new Email("student@example.com");
Customer customer = new Customer("Ana", email);
```

## Benefício

Agora não é possível criar um `Customer` com e-mail inválido, desde que o construtor exija `Email`.

Isso melhora encapsulamento e reduz validações repetidas.

## Outro exemplo: Money

Evite isso:

```java
private double price;
```

Prefira:

```java
public final class Money {

    private final BigDecimal amount;

    public Money(BigDecimal amount) {
        if (amount == null) {
            throw new IllegalArgumentException("Amount is required.");
        }

        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Amount cannot be negative.");
        }

        this.amount = amount;
    }

    public Money add(Money other) {
        return new Money(this.amount.add(other.amount));
    }

    public Money multiply(int quantity) {
        return new Money(this.amount.multiply(BigDecimal.valueOf(quantity)));
    }

    public Money percentage(int percentage) {
        BigDecimal result = amount
                .multiply(BigDecimal.valueOf(percentage))
                .divide(BigDecimal.valueOf(100));

        return new Money(result);
    }

    public static Money zero() {
        return new Money(BigDecimal.ZERO);
    }
}
```

## Discussão didática

Essa é uma das regras mais importantes para ensinar POO de verdade.

Ela mostra que uma classe não precisa representar apenas entidades grandes como `Customer`, `Order` ou `Product`. Pequenos conceitos do domínio também podem ser objetos: `Email`, `Cpf`, `Money`, `Quantity`, `Password`, `Score`, `Age`, `Period`, `Address`.

---

# 8. Regra 4 — Use coleções de primeira classe

## Ideia

Uma coleção de primeira classe é uma classe criada para encapsular uma coleção e concentrar os comportamentos relacionados a ela.

Evite deixar `List`, `Set` e `Map` espalhados pelo domínio com regras externas manipulando essas coleções.

## Exemplo ruim

```java
public class Order {

    private final List<OrderItem> items;

    public List<OrderItem> getItems() {
        return items;
    }
}
```

E em outro lugar:

```java
public class OrderService {

    public BigDecimal calculateTotal(Order order) {
        BigDecimal total = BigDecimal.ZERO;

        for (OrderItem item : order.getItems()) {
            total = total.add(item.getSubtotal());
        }

        return total;
    }
}
```

O serviço conhece demais a estrutura interna do pedido.

## Refatoração

Criamos uma coleção de primeira classe:

```java
public class OrderItems {

    private final List<OrderItem> items;

    public OrderItems(List<OrderItem> items) {
        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException("Order must have at least one item.");
        }

        this.items = List.copyOf(items);
    }

    public Money total() {
        Money total = Money.zero();

        for (OrderItem item : items) {
            total = total.add(item.subtotal());
        }

        return total;
    }

    public int count() {
        return items.size();
    }
}
```

Agora `Order` fica assim:

```java
public class Order {

    private final OrderItems items;

    public Money total() {
        return items.total();
    }
}
```

## Benefícios

A classe `OrderItems` pode concentrar regras como:

* pedido deve ter ao menos um item;
* não pode ter item duplicado;
* total do pedido;
* quantidade total;
* limite máximo de itens;
* remoção de item;
* verificação de produtos indisponíveis.

## Discussão didática

Essa regra ajuda muito os alunos a entenderem que `List<OrderItem>` não representa uma regra de negócio por si só. Já `OrderItems` representa um conceito do domínio.

---

# 9. Regra 5 — Um ponto por linha

## Ideia

Essa regra está ligada à **Lei de Demeter**, ou princípio do menor conhecimento.

Evite chamadas encadeadas como:

```java
order.getCustomer().getAddress().getCity().getName();
```

Esse código indica que uma parte do sistema conhece detalhes demais da estrutura interna de vários objetos.

## Exemplo ruim

```java
public boolean isInternational(Order order) {
    return !order.getCustomer()
            .getAddress()
            .getCountry()
            .getCode()
            .equals("BR");
}
```

Esse método conhece:

* `Order`;
* `Customer`;
* `Address`;
* `Country`;
* `code`.

## Refatoração

Pergunte: quem deveria saber se o pedido é internacional?

Talvez o próprio pedido:

```java
public class Order {

    private final Customer customer;

    public boolean isInternational() {
        return customer.isInternational();
    }
}
```

```java
public class Customer {

    private final Address address;

    public boolean isInternational() {
        return address.isOutsideBrazil();
    }
}
```

```java
public class Address {

    private final Country country;

    public boolean isOutsideBrazil() {
        return country.isNotBrazil();
    }
}
```

```java
public class Country {

    private final String code;

    public boolean isNotBrazil() {
        return !code.equals("BR");
    }
}
```

Uso:

```java
if (order.isInternational()) {
    // aplicar regra internacional
}
```

## Discussão didática

A regra “um ponto por linha” não deve ser aplicada cegamente para APIs fluentes, builders ou streams.

Por exemplo, isso pode ser aceitável:

```java
users.stream()
        .filter(User::isActive)
        .map(User::email)
        .toList();
```

O problema principal é atravessar objetos de domínio como se fossem estruturas de dados públicas.

---

# 10. Regra 6 — Não abrevie nomes

## Ideia

Nomes abreviados reduzem a clareza do código.

Evite:

```java
public class OrdSvc {
    public void calcTot(Ord ord) {
        // ...
    }
}
```

Prefira:

```java
public class OrderService {
    public void calculateTotal(Order order) {
        // ...
    }
}
```

## Mais exemplos ruins

```java
int qtd;
BigDecimal vlr;
Customer cust;
Product prod;
```

## Melhor

```java
int quantity;
BigDecimal amount;
Customer customer;
Product product;
```

## Discussão didática

Código é lido muito mais vezes do que é escrito.

Nomes bons reduzem a necessidade de comentários. Em POO, nomes são ainda mais importantes porque expressam conceitos do domínio.

Compare:

```java
order.approve();
```

com:

```java
order.setStatus("APPROVED");
```

O primeiro expressa uma ação de negócio. O segundo apenas altera dado.

---

# 11. Regra 7 — Mantenha entidades pequenas

## Ideia

Classes, métodos e pacotes muito grandes costumam indicar excesso de responsabilidade.

Object Calisthenics força classes pequenas para melhorar:

* coesão;
* testabilidade;
* legibilidade;
* manutenção;
* evolução do domínio.

## Exemplo ruim

```java
public class OrderService {

    public void createOrder() {
        // valida cliente
        // valida estoque
        // calcula desconto
        // calcula frete
        // salva pedido
        // envia email
        // baixa estoque
        // gera nota fiscal
    }
}
```

Esse serviço sabe demais.

## Possível decomposição

```java
public class OrderApplicationService {

    private final Inventory inventory;
    private final Orders orders;
    private final PaymentGateway paymentGateway;
    private final Notification notification;

    public void place(PlaceOrderCommand command) {
        Order order = Order.place(command.customerId(), command.items());

        inventory.reserve(order.items());
        paymentGateway.authorize(order.total());
        orders.save(order);
        notification.orderPlaced(order);
    }
}
```

E as regras internas ficam no domínio:

```java
public class Order {

    private final CustomerId customerId;
    private final OrderItems items;
    private OrderStatus status;

    public static Order place(CustomerId customerId, OrderItems items) {
        return new Order(customerId, items, OrderStatus.PLACED);
    }

    public Money total() {
        return items.total();
    }

    public void approve() {
        if (status != OrderStatus.PLACED) {
            throw new IllegalStateException("Only placed orders can be approved.");
        }

        this.status = OrderStatus.APPROVED;
    }
}
```

## Discussão didática

“Classe pequena” não significa “classe sem sentido”.

Criar muitas classes artificiais também pode piorar o design. O objetivo é separar conceitos reais do domínio.

---

# 12. Regra 8 — Não use classes com mais de dois atributos de instância

## Ideia

Essa é uma das regras mais polêmicas.

A intenção é forçar o programador a perceber que uma classe com muitos atributos pode estar escondendo objetos menores.

## Exemplo ruim

```java
public class Customer {

    private String name;
    private String email;
    private String cpf;
    private String street;
    private String number;
    private String city;
    private String country;
}
```

Essa classe mistura dados pessoais e endereço.

## Refatoração

```java
public class Customer {

    private final CustomerProfile profile;
    private final Address address;

    public Customer(CustomerProfile profile, Address address) {
        this.profile = profile;
        this.address = address;
    }
}
```

```java
public class CustomerProfile {

    private final Name name;
    private final Email email;
    private final Cpf cpf;

    public CustomerProfile(Name name, Email email, Cpf cpf) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
    }
}
```

```java
public class Address {

    private final Street street;
    private final City city;

    public Address(Street street, City city) {
        this.street = street;
        this.city = city;
    }
}
```

## Discussão didática

Em sistemas reais, a regra “no máximo dois atributos” pode ser excessiva. Mas como exercício, ela é excelente para mostrar que muitos atributos podem ser agrupados em conceitos mais expressivos.

Exemplos de agrupamento:

```java
street, number, city, country -> Address
startDate, endDate -> Period
amount, currency -> Money
email, phone -> ContactInfo
width, height -> Dimension
latitude, longitude -> Coordinate
```

---

# 13. Regra 9 — Não use getters e setters

## Ideia

Essa regra não quer dizer que métodos de leitura nunca podem existir.

Ela combate o uso automático de getters e setters que expõem o estado interno e transformam objetos em estruturas de dados.

## Exemplo ruim

```java
public class Order {

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
```

Uso:

```java
if (order.getStatus().equals("PENDING")) {
    order.setStatus("APPROVED");
}
```

Problema: qualquer parte do sistema pode colocar qualquer status.

```java
order.setStatus("ANYTHING");
```

## Melhor

```java
public class Order {

    private OrderStatus status;

    public void approve() {
        if (status != OrderStatus.PENDING) {
            throw new IllegalStateException("Only pending orders can be approved.");
        }

        this.status = OrderStatus.APPROVED;
    }

    public boolean isApproved() {
        return status == OrderStatus.APPROVED;
    }
}
```

Agora o objeto protege sua própria regra.

## Outro exemplo ruim

```java
customer.setEmail("invalid-email");
```

Melhor:

```java
customer.changeEmail(new Email("new@example.com"));
```

Comportamento explícito:

```java
public class Customer {

    private Email email;

    public void changeEmail(Email email) {
        if (email == null) {
            throw new IllegalArgumentException("Email is required.");
        }

        this.email = email;
    }
}
```

## Discussão didática

Getters podem ser aceitáveis para:

* DTOs;
* serializers;
* frameworks;
* views;
* consultas;
* APIs;
* records;
* objetos imutáveis simples.

O problema é usar getters e setters como padrão automático em entidades de domínio.

Em POO, prefira perguntar:

> “Qual comportamento esse objeto deveria oferecer?”

Em vez de:

> “Quais dados eu preciso pegar desse objeto para fazer a regra fora dele?”

---

# 14. Exemplo completo de refatoração

## Situação inicial

Imagine um sistema simples de pedidos.

Código inicial:

```java
public class OrderItem {

    public String productName;
    public BigDecimal price;
    public int quantity;
}
```

```java
public class Order {

    public List<OrderItem> items;
    public String status;
    public String customerEmail;
}
```

```java
public class OrderService {

    public BigDecimal calculateTotal(Order order) {
        BigDecimal total = BigDecimal.ZERO;

        for (OrderItem item : order.items) {
            total = total.add(item.price.multiply(BigDecimal.valueOf(item.quantity)));
        }

        return total;
    }

    public void approve(Order order) {
        if (order.status.equals("PENDING")) {
            if (order.items.size() > 0) {
                order.status = "APPROVED";
            } else {
                throw new IllegalStateException("Order has no items.");
            }
        } else {
            throw new IllegalStateException("Order is not pending.");
        }
    }

    public boolean shouldNotifyCustomer(Order order) {
        if (order.customerEmail != null && order.customerEmail.contains("@")) {
            return true;
        } else {
            return false;
        }
    }
}
```

Problemas:

* atributos públicos;
* strings representando estado;
* primitivos sem encapsulamento;
* regra de aprovação fora de `Order`;
* cálculo de subtotal fora de `OrderItem`;
* validação de e-mail espalhada;
* `else` desnecessário;
* indentação excessiva;
* `List` exposta;
* objeto anêmico.

---

## Versão refatorada

### `Money`

```java
import java.math.BigDecimal;

public final class Money {

    private final BigDecimal amount;

    public Money(BigDecimal amount) {
        if (amount == null) {
            throw new IllegalArgumentException("Amount is required.");
        }

        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Amount cannot be negative.");
        }

        this.amount = amount;
    }

    public Money add(Money other) {
        return new Money(this.amount.add(other.amount));
    }

    public Money multiply(Quantity quantity) {
        return new Money(this.amount.multiply(BigDecimal.valueOf(quantity.value())));
    }

    public BigDecimal value() {
        return amount;
    }

    public static Money zero() {
        return new Money(BigDecimal.ZERO);
    }
}
```

### `Quantity`

```java
public final class Quantity {

    private final int value;

    public Quantity(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }

        this.value = value;
    }

    public int value() {
        return value;
    }
}
```

### `Email`

```java
public final class Email {

    private final String value;

    public Email(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Email is required.");
        }

        if (!value.contains("@")) {
            throw new IllegalArgumentException("Invalid email.");
        }

        this.value = value.toLowerCase();
    }

    public String value() {
        return value;
    }
}
```

### `OrderStatus`

```java
public enum OrderStatus {
    PENDING,
    APPROVED,
    CANCELLED
}
```

### `OrderItem`

```java
public class OrderItem {

    private final String productName;
    private final Money price;
    private final Quantity quantity;

    public OrderItem(String productName, Money price, Quantity quantity) {
        if (productName == null || productName.isBlank()) {
            throw new IllegalArgumentException("Product name is required.");
        }

        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public Money subtotal() {
        return price.multiply(quantity);
    }
}
```

### `OrderItems`

```java
import java.util.List;

public class OrderItems {

    private final List<OrderItem> items;

    public OrderItems(List<OrderItem> items) {
        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException("Order must have at least one item.");
        }

        this.items = List.copyOf(items);
    }

    public Money total() {
        Money total = Money.zero();

        for (OrderItem item : items) {
            total = total.add(item.subtotal());
        }

        return total;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
```

### `Order`

```java
public class Order {

    private final OrderItems items;
    private final Email customerEmail;
    private OrderStatus status;

    public Order(OrderItems items, Email customerEmail) {
        this.items = items;
        this.customerEmail = customerEmail;
        this.status = OrderStatus.PENDING;
    }

    public Money total() {
        return items.total();
    }

    public void approve() {
        if (status != OrderStatus.PENDING) {
            throw new IllegalStateException("Only pending orders can be approved.");
        }

        this.status = OrderStatus.APPROVED;
    }

    public boolean shouldNotifyCustomer() {
        return customerEmail != null;
    }

    public boolean isApproved() {
        return status == OrderStatus.APPROVED;
    }
}
```

### `OrderService`

```java
public class OrderService {

    public void approve(Order order) {
        order.approve();

        if (order.shouldNotifyCustomer()) {
            // enviar notificação
        }
    }
}
```

## O que melhorou?

A versão refatorada:

* protege os dados;
* elimina strings soltas para status;
* encapsula regras de quantidade, dinheiro e e-mail;
* coloca cálculo de subtotal em `OrderItem`;
* coloca cálculo de total em `OrderItems`;
* coloca regra de aprovação em `Order`;
* reduz `if/else`;
* reduz manipulação externa de estado;
* cria objetos com significado de domínio.

---

# 15. Relação com princípios de POO

## Encapsulamento

Object Calisthenics fortalece encapsulamento.

Em vez de:

```java
order.setStatus(OrderStatus.APPROVED);
```

Preferimos:

```java
order.approve();
```

A diferença é grande.

`setStatus` altera dado.

`approve` executa uma regra de negócio.

---

## Coesão

Uma classe coesa concentra responsabilidades relacionadas.

Exemplo:

```java
public class Email {
    // valida, normaliza e representa e-mail
}
```

Essa classe é coesa porque tudo nela gira em torno do conceito de e-mail.

---

## Baixo acoplamento

Evitar chamadas como:

```java
order.getCustomer().getAddress().getCity().getName();
```

reduz acoplamento, porque uma classe deixa de depender da estrutura interna de várias outras.

---

## Polimorfismo

A regra “não use else” frequentemente conduz ao uso de polimorfismo.

Exemplo:

```java
public interface ShippingPolicy {
    Money calculate(Order order);
}
```

```java
public class ExpressShipping implements ShippingPolicy {

    @Override
    public Money calculate(Order order) {
        return new Money(new BigDecimal("50.00"));
    }
}
```

```java
public class RegularShipping implements ShippingPolicy {

    @Override
    public Money calculate(Order order) {
        return new Money(new BigDecimal("20.00"));
    }
}
```

Em vez de:

```java
if (type.equals("EXPRESS")) {
    // ...
} else if (type.equals("REGULAR")) {
    // ...
}
```

---

# 16. Object Calisthenics e objetos anêmicos

Um **modelo anêmico** é um modelo onde as classes têm dados, mas quase nenhum comportamento.

Exemplo:

```java
public class Account {

    private BigDecimal balance;

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
```

E a regra fica fora:

```java
public class AccountService {

    public void withdraw(Account account, BigDecimal amount) {
        if (account.getBalance().compareTo(amount) < 0) {
            throw new IllegalStateException("Insufficient balance.");
        }

        account.setBalance(account.getBalance().subtract(amount));
    }
}
```

Melhor:

```java
public class Account {

    private Money balance;

    public void withdraw(Money amount) {
        if (balance.isLessThan(amount)) {
            throw new IllegalStateException("Insufficient balance.");
        }

        this.balance = balance.subtract(amount);
    }
}
```

Agora `Account` protege sua própria regra.

---

# 17. Object Calisthenics com Java moderno

## Records

Java records são úteis para DTOs, comandos, respostas e value objects simples.

Exemplo:

```java
public record CreateCustomerRequest(String name, String email) {
}
```

Mas cuidado: records expõem seus componentes por métodos públicos.

Para domínio rico, uma classe tradicional pode ser melhor quando há comportamento, invariantes e encapsulamento mais forte.

Ainda assim, records podem ser usados em Value Objects simples:

```java
public record CustomerId(String value) {

    public CustomerId {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("CustomerId is required.");
        }
    }
}
```

## Enums

Enums são melhores que strings para estados conhecidos.

Ruim:

```java
private String status;
```

Melhor:

```java
private OrderStatus status;
```

```java
public enum OrderStatus {
    PENDING,
    APPROVED,
    CANCELLED
}
```

## Imutabilidade

Value Objects devem ser preferencialmente imutáveis.

```java
public final class Cpf {

    private final String value;

    public Cpf(String value) {
        // validação
        this.value = value;
    }
}
```

---

# 18. Quando não aplicar Object Calisthenics literalmente

Object Calisthenics é excelente para treino, mas pode virar exagero.

## Não aplique cegamente em DTOs

DTOs podem ter getters, setters ou records:

```java
public record CustomerResponse(
        String name,
        String email
) {
}
```

Aqui não há problema.

## Não force classe para todo primitivo sem necessidade

Nem todo `int` precisa virar objeto.

Este código pode ser aceitável:

```java
for (int i = 0; i < 10; i++) {
    System.out.println(i);
}
```

O problema é quando o primitivo representa conceito de domínio:

```java
int age;
int quantity;
String cpf;
String email;
BigDecimal amount;
```

Esses podem merecer encapsulamento.

## Não complique código simples

Às vezes, um `if` simples é mais claro que uma hierarquia de classes.

Ruim:

```java
if (user.isActive()) {
    sendEmail(user);
}
```

Não há necessidade de criar polimorfismo para tudo.

## Não confunda regra didática com arquitetura

Object Calisthenics ajuda a melhorar design, mas não substitui:

* Clean Architecture;
* DDD;
* testes;
* arquitetura hexagonal;
* padrões de integração;
* modelagem de domínio;
* boas decisões de persistência.

---

# 19. Exemplo para sala de aula: antes e depois

## Código inicial para os alunos refatorarem

```java
import java.math.BigDecimal;
import java.util.List;

public class Subscription {

    public String customerEmail;
    public String plan;
    public String status;
    public BigDecimal monthlyPrice;
    public List<String> benefits;

    public void activate() {
        if (status.equals("PENDING")) {
            if (customerEmail != null && customerEmail.contains("@")) {
                if (monthlyPrice.compareTo(BigDecimal.ZERO) > 0) {
                    status = "ACTIVE";
                } else {
                    throw new IllegalStateException("Invalid price.");
                }
            } else {
                throw new IllegalStateException("Invalid email.");
            }
        } else {
            throw new IllegalStateException("Subscription is not pending.");
        }
    }
}
```

## Problemas esperados

Os alunos devem identificar:

* uso de atributos públicos;
* `String` para e-mail;
* `String` para plano;
* `String` para status;
* `BigDecimal` sem encapsulamento;
* `List<String>` exposta;
* muitos `ifs` aninhados;
* uso de `else`;
* validações misturadas;
* classe com muitos atributos;
* ausência de objetos de domínio.

## Possível solução

### `Email`

```java
public final class Email {

    private final String value;

    public Email(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Email is required.");
        }

        if (!value.contains("@")) {
            throw new IllegalArgumentException("Invalid email.");
        }

        this.value = value.toLowerCase();
    }
}
```

### `Price`

```java
import java.math.BigDecimal;

public final class Price {

    private final BigDecimal value;

    public Price(BigDecimal value) {
        if (value == null) {
            throw new IllegalArgumentException("Price is required.");
        }

        if (value.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero.");
        }

        this.value = value;
    }
}
```

### `SubscriptionStatus`

```java
public enum SubscriptionStatus {
    PENDING,
    ACTIVE,
    CANCELLED
}
```

### `Plan`

```java
public enum Plan {
    BASIC,
    PREMIUM,
    ENTERPRISE
}
```

### `Benefits`

```java
import java.util.List;

public class Benefits {

    private final List<String> values;

    public Benefits(List<String> values) {
        if (values == null || values.isEmpty()) {
            throw new IllegalArgumentException("At least one benefit is required.");
        }

        this.values = List.copyOf(values);
    }

    public int count() {
        return values.size();
    }
}
```

### `Subscription`

```java
public class Subscription {

    private final Email customerEmail;
    private final SubscriptionPlan plan;
    private SubscriptionStatus status;

    public Subscription(Email customerEmail, SubscriptionPlan plan) {
        this.customerEmail = customerEmail;
        this.plan = plan;
        this.status = SubscriptionStatus.PENDING;
    }

    public void activate() {
        if (status != SubscriptionStatus.PENDING) {
            throw new IllegalStateException("Only pending subscriptions can be activated.");
        }

        this.status = SubscriptionStatus.ACTIVE;
    }

    public boolean isActive() {
        return status == SubscriptionStatus.ACTIVE;
    }
}
```

### `SubscriptionPlan`

```java
public class SubscriptionPlan {

    private final Plan plan;
    private final Price monthlyPrice;
    private final Benefits benefits;

    public SubscriptionPlan(Plan plan, Price monthlyPrice, Benefits benefits) {
        this.plan = plan;
        this.monthlyPrice = monthlyPrice;
        this.benefits = benefits;
    }
}
```

---

# 20. Atividade prática em aula

## Enunciado

Refatore o código abaixo aplicando Object Calisthenics.

```java
import java.math.BigDecimal;
import java.util.List;

public class Invoice {

    public String customerName;
    public String customerDocument;
    public List<BigDecimal> itemPrices;
    public String status;
    public BigDecimal tax;

    public BigDecimal calculateTotal() {
        BigDecimal total = BigDecimal.ZERO;

        for (BigDecimal price : itemPrices) {
            if (price.compareTo(BigDecimal.ZERO) > 0) {
                total = total.add(price);
            } else {
                throw new IllegalArgumentException("Invalid item price.");
            }
        }

        if (tax.compareTo(BigDecimal.ZERO) > 0) {
            total = total.add(tax);
        } else {
            throw new IllegalArgumentException("Invalid tax.");
        }

        return total;
    }

    public void issue() {
        if (status.equals("DRAFT")) {
            if (itemPrices.size() > 0) {
                status = "ISSUED";
            } else {
                throw new IllegalStateException("Invoice has no items.");
            }
        } else {
            throw new IllegalStateException("Invoice is not draft.");
        }
    }
}
```

## Requisitos da refatoração

Os alunos devem:

1. Remover atributos públicos.
2. Substituir `String status` por `enum`.
3. Criar Value Objects para valores relevantes.
4. Criar uma coleção de primeira classe para os itens.
5. Remover `else`.
6. Evitar getters e setters desnecessários.
7. Colocar regras dentro dos objetos corretos.
8. Melhorar nomes.
9. Reduzir indentação.

## Possíveis classes esperadas

* `Invoice`
* `InvoiceItems`
* `InvoiceItem`
* `Money`
* `Tax`
* `Customer`
* `Document`
* `InvoiceStatus`

---

# 21. Exercício avaliativo mais difícil

## Domínio: sistema de matrícula em cursos

Uma escola online permite que alunos se matriculem em cursos. Cada curso possui um nome, uma carga horária, uma quantidade máxima de alunos e uma lista de matrículas. Um aluno possui nome, e-mail e documento. A matrícula começa com status `PENDING`, pode ser confirmada se o curso ainda possui vagas e pode ser cancelada se ainda não foi concluída.

O código inicial abaixo foi escrito por um programador iniciante:

```java
import java.util.ArrayList;
import java.util.List;

public class Course {

    public String name;
    public int workloadHours;
    public int maxStudents;
    public List<Enrollment> enrollments = new ArrayList<>();

    public void enroll(Student student) {
        if (student.email != null && student.email.contains("@")) {
            if (enrollments.size() < maxStudents) {
                Enrollment enrollment = new Enrollment();
                enrollment.student = student;
                enrollment.status = "PENDING";
                enrollments.add(enrollment);
            } else {
                throw new IllegalStateException("Course is full.");
            }
        } else {
            throw new IllegalArgumentException("Invalid student email.");
        }
    }

    public void confirmEnrollment(String document) {
        for (Enrollment enrollment : enrollments) {
            if (enrollment.student.document.equals(document)) {
                if (enrollment.status.equals("PENDING")) {
                    enrollment.status = "CONFIRMED";
                } else {
                    throw new IllegalStateException("Enrollment is not pending.");
                }
            }
        }
    }
}
```

```java
public class Student {

    public String name;
    public String email;
    public String document;
}
```

```java
public class Enrollment {

    public Student student;
    public String status;
}
```

## Tarefa

Refatore o código aplicando Object Calisthenics.

## Resultado esperado

O aluno deve criar conceitos como:

* `Email`
* `Document`
* `Student`
* `Course`
* `CourseName`
* `Workload`
* `Enrollment`
* `Enrollments`
* `EnrollmentStatus`
* `Capacity`

## Possível direção de solução

```java
public enum EnrollmentStatus {
    PENDING,
    CONFIRMED,
    CANCELLED,
    COMPLETED
}
```

```java
public final class Email {

    private final String value;

    public Email(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Email is required.");
        }

        if (!value.contains("@")) {
            throw new IllegalArgumentException("Invalid email.");
        }

        this.value = value.toLowerCase();
    }
}
```

```java
public final class Capacity {

    private final int value;

    public Capacity(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than zero.");
        }

        this.value = value;
    }

    public boolean isExceededBy(int amount) {
        return amount >= value;
    }
}
```

```java
public class Enrollment {

    private final Student student;
    private EnrollmentStatus status;

    public Enrollment(Student student) {
        this.student = student;
        this.status = EnrollmentStatus.PENDING;
    }

    public void confirm() {
        if (status != EnrollmentStatus.PENDING) {
            throw new IllegalStateException("Only pending enrollments can be confirmed.");
        }

        this.status = EnrollmentStatus.CONFIRMED;
    }

    public boolean belongsTo(Document document) {
        return student.hasDocument(document);
    }
}
```

```java
import java.util.ArrayList;
import java.util.List;

public class Enrollments {

    private final List<Enrollment> values;

    public Enrollments() {
        this.values = new ArrayList<>();
    }

    public void add(Student student, Capacity capacity) {
        if (capacity.isExceededBy(values.size())) {
            throw new IllegalStateException("Course is full.");
        }

        values.add(new Enrollment(student));
    }

    public void confirm(Document document) {
        Enrollment enrollment = findByDocument(document);
        enrollment.confirm();
    }

    private Enrollment findByDocument(Document document) {
        for (Enrollment enrollment : values) {
            if (enrollment.belongsTo(document)) {
                return enrollment;
            }
        }

        throw new IllegalArgumentException("Enrollment not found.");
    }
}
```

```java
public class Course {

    private final CourseName name;
    private final Workload workload;
    private final Capacity capacity;
    private final Enrollments enrollments;

    public Course(CourseName name, Workload workload, Capacity capacity) {
        this.name = name;
        this.workload = workload;
        this.capacity = capacity;
        this.enrollments = new Enrollments();
    }

    public void enroll(Student student) {
        enrollments.add(student, capacity);
    }

    public void confirmEnrollment(Document document) {
        enrollments.confirm(document);
    }
}
```

---

# 22. Checklist de Object Calisthenics para revisão de código

Use este checklist antes de considerar a refatoração concluída.

## Estrutura

* A classe tem uma responsabilidade clara?
* O método faz apenas uma coisa?
* Há métodos muito grandes?
* Há classes com muitos atributos?
* Existem conceitos escondidos em `String`, `int`, `double` ou `BigDecimal`?

## Encapsulamento

* Existem atributos públicos?
* Existem setters que permitem estado inválido?
* O objeto protege suas próprias regras?
* O comportamento está perto dos dados que utiliza?

## Condicionais

* Há muitos `if/else`?
* Há `if` baseado em tipo, status ou categoria?
* O polimorfismo resolveria melhor?
* Um enum com comportamento ajudaria?

## Coleções

* Alguma `List`, `Set` ou `Map` está sendo manipulada por vários lugares?
* A coleção possui regras de negócio?
* Faz sentido criar uma classe como `OrderItems`, `Enrollments`, `Benefits` ou `InvoiceLines`?

## Nomes

* Os nomes expressam o domínio?
* Existem abreviações desnecessárias?
* Os métodos representam ações de negócio?
* O código depende menos de comentários porque os nomes são claros?

---

# 23. Como explicar Object Calisthenics para alunos

Uma boa forma de explicar é:

> “Object Calisthenics é um treino para parar de escrever classes que apenas carregam dados e começar a escrever objetos que protegem regras e expressam comportamentos.”

Outra forma:

> “Quando você aplica Object Calisthenics, você é forçado a transformar dados soltos em conceitos do domínio.”

Exemplo:

```java
String email
```

vira:

```java
Email email
```

```java
List<OrderItem> items
```

vira:

```java
OrderItems items
```

```java
order.setStatus("APPROVED")
```

vira:

```java
order.approve()
```

Essa mudança é o coração da POO.

---

# 24. Conclusão

Object Calisthenics é especialmente útil para ensinar Programação Orientada a Objetos porque força o aluno a sair do pensamento procedural.

Em vez de escrever:

```java
service.validate(entity);
service.calculate(entity);
service.changeStatus(entity);
```

O aluno começa a escrever:

```java
order.approve();
order.total();
customer.changeEmail(email);
account.withdraw(amount);
```

A diferença não é apenas estética. É uma mudança de modelo mental.

Object Calisthenics treina a pensar em objetos como unidades de comportamento, regra e proteção de estado, não apenas como estruturas com atributos e métodos getters/setters.

[1]: https://developerhandbook.stakater.com/architecture/object-calisthenics.html?utm_source=chatgpt.com "Object Calisthenics - Developer Handbook"
[2]: https://www.softensity.com/blog/improve-your-code-with-object-calisthenics/?utm_source=chatgpt.com "Improve Your Code With Object Calisthenics"
[3]: https://bolcom.github.io/student-dojo/legacy-code/DevelopersAnonymous-ObjectCalisthenics.pdf?utm_source=chatgpt.com "Object Calisthenics by Jeff Bay"
