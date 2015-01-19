# language: pt
# encoding: iso-8859-1

Funcionalidade: Inserir Times
  Como usuario
  Quero inserir um time no sistema
  Para que possa manter um cadastro de times

  Cenário: Deve incluir um time
    Dado que quero efetuar o cadastro de um novo "validTeam5"
    Quando efetuo a operacao de incluir um time
    Então o time cadastrado deve possuir um identificador unico

  Esquema do Cenário: Deve validar campos obrigatório
    Dado que quero efetuar o cadastro de um novo "validTeam5"
    E nao preencho o <campo obrigatorio>
    Quando efetuo a operacao de incluir um time
    Então devo receber uma TeamServiceException

    Exemplos:
      | campo obrigatorio |
      | nome completo     |
      | nome comum        |
