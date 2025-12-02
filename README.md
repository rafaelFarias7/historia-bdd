📘 Projeto BDD – Abertura de Conta Corrente
🧪 Java + Cucumber + JUnit + Maven

Este projeto implementa uma funcionalidade de abertura de conta corrente, modelada por meio de História de Usuário, Cenários BDD em Gherkin, Step Definitions em Java e execução automatizada com Cucumber + JUnit.

Foi desenvolvido com fins acadêmicos e demonstra boas práticas de Behavior-Driven Development.

📌 1. História de Usuário

Como cliente do banco,
Quero abrir uma conta corrente,
Para guardar meu dinheiro com segurança.

📝 Critérios de Aceitação (BDD)
✅ Cenários Positivos

1. Criar conta com saldo inicial informado

Dado que o usuário informa nome, CPF e saldo inicial válidos

Quando confirma a criação

Então o sistema deve gerar um número de conta único

E armazenar a conta com o saldo informado

2. Criar conta sem saldo inicial

Dado que o usuário informa nome e CPF

Quando confirma a criação

Então a conta deve ser criada com saldo inicial de R$ 0,00

❌ Cenários Negativos

3. CPF já cadastrado

Dado que o CPF já está vinculado a outra conta

Quando tenta criar uma nova conta

Então o sistema deve recusar a operação

E exibir a mensagem “CPF já vinculado a uma conta”

4. Nome vazio

Dado que o usuário informa nome vazio

Quando tenta criar a conta

Então o sistema deve exibir a mensagem “Nome inválido”

📁 2. Estrutura do Projeto
historia/
 ├── src/
 │   ├── main/java/com/example/
 │   │       ├── App.java
 │   │       ├── Conta.java
 │   │       └── ContaService.java
 │   └── test/
 │       ├── java/com/example/
 │       │       ├── AppTest.java
 │       │       ├── ContaSteps.java
 │       │       └── RunCucumberTest.java
 │       └── resources/features/
 │               └── abertura_conta.feature
 └── pom.xml
 └── README.md

🧪 3. Cenários BDD (arquivo .feature)

Local:
src/test/resources/features/abertura_conta.feature

Funcionalidade: Abertura de conta corrente
  Para guardar meu dinheiro de forma segura
  Como cliente do banco
  Quero poder abrir uma conta corrente

  Cenario: Criar conta com saldo inicial informado
    Dado que o usuário informou nome "Rafael", CPF "12345678900" e saldo inicial de 1000 reais
    Quando confirma a criação da conta
    Então o sistema deve gerar um número de conta único
    E o sistema deve armazenar a conta com saldo inicial de 1000 reais

  Cenario: Criar conta sem saldo inicial
    Dado que o usuário informou nome "Joao", CPF "98765432100" e não informou saldo inicial
    Quando confirma a criação da conta
    Então o sistema deve criar a conta com saldo inicial de 0 reais

  Cenario: Impedir criação de conta com CPF já cadastrado
    Dado que já existe uma conta para o CPF "12345678900"
    Quando o usuário tenta criar uma nova conta com o mesmo CPF
    Então o sistema deve recusar a operação
    E o sistema deve exibir a mensagem "CPF já vinculado a uma conta"

  Cenario: Nome obrigatório
    Dado que o usuário informou um nome vazio e CPF "11122233344"
    Quando tenta criar a conta
    Então o sistema deve exibir a mensagem "Nome inválido"

🛠️ 4. Como Executar os Testes
🔹 Pré-requisitos

Java 17+

Maven instalado e configurado

VS Code / IntelliJ / Eclipse

🔹 Para rodar os testes:
mvn clean test


Ou execute a classe:

RunCucumberTest.java

🧩 5. Tecnologias Utilizadas

Java 17

JUnit 4 + JUnit 5

Cucumber JVM 7

Gherkin

Maven

Checkstyle

JaCoCo (cobertura de testes)

🤖 6. Uso de Inteligência Artificial (IA)

Durante o desenvolvimento deste trabalho:

A IA foi utilizada para estruturar o documento,

Auxiliar na formatação de códigos,

Auxiliar na depuração de erros de build (Maven, Checkstyle, Surefire),

Gerar exemplos de cenários BDD,

Melhorar a organização geral do projeto,

E otimizar a escrita deste README.

A implementação final, estrutura e interpretação dos resultados foram executadas pelo aluno.

📜 7. Licença

Este projeto é acadêmico e não tem fins comerciais.
