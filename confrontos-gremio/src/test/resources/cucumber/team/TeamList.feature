# language: pt
# encoding: iso-8859-1

Funcionalidade: Listar Times
  Como usu�rio
  Quero visualizar os times cadastrados

  Cen�rio: Deve retornar lista vazia
    Dado que n�o existam times cadastrados
    Quando eu acesso a listagem de times
    Ent�o devo receber uma lista vazia como resposta

  Cen�rio: Deve retornar todos registros
    Dado que existam times cadastrados
    Quando eu acesso a listagem de times
    Ent�o devo receber uma lista com todos times cadastrados
