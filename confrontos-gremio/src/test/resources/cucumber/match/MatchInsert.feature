# language: pt
# encoding: iso-8859-1

Funcionalidade: Inserir Times
  Como usuário
  Quero inserir inserir um time no sistema

  Cenário: Deve retornar lista vazia
    Dado que quero efetuar o cadastro de um novo "projetoFundopemValido"
	Quando efetuo a operacao de incluir
	Entao o projeto cadastrado deve possuir um identificador

  Cenário: Deve validar preenchimento de campo obrigatório