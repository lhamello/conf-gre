# language: pt
# encoding: iso-8859-1

Funcionalidade: Inserir Times
  Como usu�rio
  Quero inserir inserir um time no sistema

  Cen�rio: Deve retornar lista vazia
    Dado que quero efetuar o cadastro de um novo "projetoFundopemValido"
	Quando efetuo a operacao de incluir
	Entao o projeto cadastrado deve possuir um identificador

  Cen�rio: Deve validar preenchimento de campo obrigat�rio