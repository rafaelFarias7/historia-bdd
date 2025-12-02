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
