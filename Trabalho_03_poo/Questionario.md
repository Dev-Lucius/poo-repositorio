# Questionário 

1. **Descrição geral da solução**

   * Como o sistema foi organizado;
   * Quais são os principais módulos, pacotes ou camadas;
   * Qual foi a lógica geral adotada para representar usuários, papéis, permissões e políticas de acesso.


2. **Justificativa do uso de herança**

   * Onde a herança foi utilizada;
   * Por que a herança foi escolhida nesses pontos;
   * Que relação de especialização existe entre as classes;
   * Quais alternativas foram consideradas, como composição ou interfaces;
   * Quais riscos ou limitações essa escolha pode gerar.

3. **Justificativa do uso de interfaces**

   * Quais interfaces foram criadas;
   * Que contratos elas representam;
   * Como elas contribuem para baixo acoplamento;
   * Como elas permitem trocar implementações sem alterar o domínio;
   * Exemplos de classes que dependem de abstrações em vez de implementações concretas.

4. **Uso de composição**

   * Onde a composição foi utilizada;
   * Por que composição foi preferida em vez de herança;
   * Como os objetos colaboram entre si;
   * Como a composição ajudou a reduzir acoplamento e duplicação.

5. **Aplicação dos princípios SOLID**

   * Exemplos concretos de aplicação do Single Responsibility Principle;
   * Exemplos concretos de aplicação do Open/Closed Principle;
   * Exemplos concretos de aplicação do Liskov Substitution Principle;
   * Exemplos concretos de aplicação do Interface Segregation Principle;
   * Exemplos concretos de aplicação do Dependency Inversion Principle;
   * Pontos em que algum princípio não foi plenamente aplicado e por quê.

6. **Aplicação de Object Calisthenics**

   * Quais regras foram aplicadas com mais rigor;
   * Quais regras foram difíceis de aplicar;
   * Exemplos de refatorações feitas para reduzir `if/else`, métodos longos ou classes grandes;
   * Exemplos de objetos de valor, coleções de primeira classe ou encapsulamento de primitivas;
   * Pontos em que os alunos decidiram não aplicar determinada regra e a justificativa técnica.

7. **Tratamento de erros e validações**

   * Quais validações foram implementadas;
   * Que exceções ou estratégias de erro foram usadas;
   * Como o sistema evita permissões duplicadas, usuários inválidos ou papéis inexistentes;

8. **Discussão crítica**

   * Quais foram as decisões mais difíceis;
   * Quais partes do código ficaram melhores do ponto de vista orientado a objetos;
   * Quais partes ainda poderiam ser melhoradas;
   * O que seria alterado se o sistema precisasse evoluir para um banco de dados real;
 


# Repostas do Questionário

1. **Descrição geral da solução** 

    - O sistema foi baseado em uma **Arquitetura em Camadas**, isto é, existe uma separação clara entre as responsabilidades entre o domínio, aplicação, infraestrutura e camadas auxiliares.

    - No **domínio** encontram-se as entidades centrais do sistema, como ``User``, ``Role`` e  ``Permission`` os quais são responsáveis por representar as regras de negócio.

    - Por sua vez, a camada de **aplicação** contém os serviços e políticas de autorização, responsáveis por coordenar os fluxos do sistemas sem conter as regras de persistência

    - Por fim, na **infraestrutura** estão os repositórios em memória, responsáveis por armazenar e recuperar dados.

    - Assim, a lógica central desse mini-sistema se concentra na associação entre Usuários, Papéis, e Permissões, na qual um Usuário Possui Papéis (roles), cada uma com suas respectivas permissões e políticas de acesso que validam se uma ação pode, ou não, ser executada.

---

2. **Justificativa do uso de herança**

    - Lugares nos Quais a Herança foi aplicada
        * ``User`` -> Classe Abstrada para os Demais Tipos Usuários
        * ``AdminUser``, ``CommonUser``, ``SystemUser``
    
    - O conceito de Herança foi usada dentro da Hierarquia de Usuários, na qual a Super Classe ``User`` representou o comportamento comum de todos os usuários

    - Por sua vez, as demais classes supracitadas assumem o papel de "especializar" tais comportamentos, na medida em que tornam possível a existência de diversos tipos de usuários com regras específicas para cada tipo

    - A escolha pela Herança foi feita pensando em implementar a relação de especialização "é um" entre as classes na qual todo "AdminUser **É UM** User", porém, com comportamentos distintos entre si.

    - Contudo, é importante resaltar que algumas alternativas foram levadas em consideração ao longo do processo de modelagem das classes, esse foi o caso da **Composição**. Assim, apesar de ser possível o uso da **Composição** dentro do Sistema dado que ela é preferível na maioria de casos modernos por estar melhor alinhada com os princípio de Clean Code e SOLID, porém, a **Herança** foi escolhida dado a existência de uma hierarquia clara, e até um pouco rígida, entre as classes de ``User``. 

    > ℹ️ Como fator limitador, essa abordagem gera um certo grau de rigidez na evolução do sistema, o que torna mais dificultosa a criação de novos tipos de usuários sem alterar a hierarquia. Nesse sentido, como forma de mitigar essa limitação, as validações dentro dos construtores das classes estruturam-se de forma minimalista

---

3. **Justificativa do uso de interfaces**

    - Interfaces Usadas
        *  UserRepository
        *  RoleRepository
        *  PermissionRepository
        *  AuditRepository
        *  AccessPolicy

    - Elas foram implementadas a fim de garantirem o baixo acoplamento pois permitem que a Camada de Aplicação dependa apenas de Abstrações, e não de Implementações Complexas

    - Graças a elas, a substituição de implementações tornou-se possível de um modo estramamente prático.

    > 📌 Exemplo: **AuthorizationServiceImpl**, que depende de **AccessPolicy** e **AuditRepository**, e não de implementações específicas.

---

4. **Uso de composição**

    - Lugares nos Quais a Composição foi aplicada
        * ``User`` Contém ``Roles``
        * ``Roles`` Contém ``Permissions`` (via ``Permissions``)
        * ``AuthorizationService`` usa ``Policies``
    
    - Apesar de não ter sido utilizada na estruturação dos Usuários, a **Composição** foi amplamente utilizada para modelar as relações entre objetos. Ela permite que objetos sejam combinados dinamicamente, reduzindo acoplamento e aumentando a flexibilidade.

    - Tal abordagem mostrou-se mais eficiente por melhorar representar relações do tipo "tem um", ao invés de "é um". Além disso, nesse contexto, é possível notar a utilização do Princípio **Prefira Composição a Herança**

    > 📌 Exemplo: Um usuário pode ter múltiplos papéis, e cada papel pode conter diferentes permissões sem necessidade de modificar hierarquias de classes.

---

5. **Aplicação dos princípios SOLID**

    - **SRP (Princípio da Responsabilidade Única)**
        * ``User`` só gerencia o estado de Usuário 
        * ``Permission`` representa apenas a permissão
        > O princípio da Responsabilidade Única foi aplicado ao separar entidades como User, Permission e Role, cada uma com uma responsabilidade bem definida.
    
    - **OCP (Princípio Aberto/Fechado)**
        * ``Policies`` podem ser adicionadas sem alterar ``AuthorizationService``
        * Novos tipos de ``User`` podem ser criados sem modificar base
        > O princípio Open/Closed é observado no sistema de políticas de acesso, onde novas regras podem ser adicionadas sem modificar o serviço de autorização.

    - **LSP (Princípio de Substituição de Liskov)**
        * **AdminUser** pode substituir User sem quebrar o sistema
        > O princípio de Substituição de Liskov é respeitado ao permitir que AdminUser e outros tipos de usuário sejam usados como substitutos de User sem afetar o comportamento do sistema.

    - **ISP (Princípio de Segragação de Responsabilidade)**
        * Interfaces são estruturadas separadamente (``UserRepository``, ``AuditRepository`` e afins)
        > O Interface Segregation Principle foi aplicado ao dividir repositórios em interfaces específicas por entidade.

    - **DIP (Princípio da Inversão de Dependência)**
        * ``AuthorizationService`` depende de abstrações (``AccessPolicy``, ``AuditRepository``)
        > O Dependency Inversion Principle é aplicado na camada de aplicação, onde serviços dependem de abstrações e não de implementações concretas.

---

6. **Aplicação de Object Calisthenics**

    - Regras Aplicadas 
        * Classes pequenas
        *  Encapsulamento
        * Coleções de primeira classe (Permissions)
        * Evitar lógica complexa em services

    - Ao longo do desenvolvimento do trabalho, foram aplicados diversos princípios de **Object Calisthenics** como o uso de classes minimalistas e foco em encapsulamento

    - A regra de coleções de primeira classe foi aplicada na Classe ``Permissions``, a qual encapsula operações sobre conjuntos de permissões. Além disso, houve diversos esforços para evitar métodos longos e centralizar regras dentro do domínio

    > 🔗​ Contudo, apesar de todo o esforço, algumas regras foram difícies de serem aplicadas, como evitar complementamente o uso de estruturas de condicionais em políticas de acesso, devido à necessidade de validações de regras de negócio.

---

7. **Tratamento de erros e validações**

    - Recursos de Tratamento Usados ao longo do trabalho
        * Valicações com ``null`` e ``isBlank()``
        * ``IllegalArgumentException``
        * Implementações de Exceções de Domínio (``UserNotFound``, ``PermissionNotFound``)

    - O sistema em questão implementa validações defensivas em construtores e métodos públicos visando assegurar que estados inválidos ou indesejados sejam evitados.

    - Foram utilizadas IllegalArgumentException para validações gerais e exceções específicas para cenários de domínio, como usuário ou permissão não encontrada. Além disso, o sistema também evita duplicações ao validar nomes antes da persistência nos repositórios

    > ⚙️ Entretanto, apesar do sistema ser sólido no que tange o tratamento de erros, ele frequentemente mostra-se redundante na hora de realizar as validações, na medida em que as validações e tratamento de exceções para variações ``null``, por exemplo, se repete com uma frequência considerável. E isso poderia ser facilmente evitado com a criação de métodos responsáveis por validações.

---

8. **Discussão crítica**

    - Todo o projeto cobriu os conteúdos abordados em sala de aula então não havia nada de obstante daquilo já havia sido discutido anteriormente. Porém, as decições mais difícies envolveram equilibrar a simplicidade e aderência a padrões SOLID e Object Calisthenics.

    - As partes do código mais bem estruturadas são o modelo de domínio e o sistema de políticas de autorização, os quais encontram-se desacoplados e extensíveis.

    - Existem diversas partes do código que poderiam ser melhoradas (ou simplesmente simplificadas) a fim de "elevar o nível" deste código. De início, percebe-se que o erro mais gritante seria o excesso uso de ramificações ``if`` ao longo das valiçãoes e dos métodos, além disso, outro aspecto que o sistema deixa a desejar seria a falta de uma padronização mais rigorosa das exceções de domínio

    - Se porventura o sistema evoluísse para um ambiente real, seria necessário introduzir diversos elementos envolvendo camadas de persistência com ORM, controle transacional e possivelmente uma API REST para acesso externo.
