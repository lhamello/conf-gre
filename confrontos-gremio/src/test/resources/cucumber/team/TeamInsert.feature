# language: pt
# encoding: iso-8859-1

Funcionalidade: Inserir Times
  Como usuario
  Quero inserir um time no sistema
  Para que possa manter um cadastro de times

  Cen�rio: Deve incluir um time
    Dado que quero efetuar o cadastro de um novo "validTeam5"
    Quando efetuo a operacao de incluir um time
    Ent�o o time cadastrado deve possuir um identificador unico

  Esquema do Cen�rio: Deve validar campos obrigat�rio
    Dado que quero efetuar o cadastro de um novo "validTeam5"
    E nao preencho o <campo obrigatorio>
    Quando efetuo a operacao de incluir um time
    Ent�o devo receber uma TeamServiceException

    Exemplos:
      | campo obrigatorio |
      | nome completo     |
      | nome comum        |
