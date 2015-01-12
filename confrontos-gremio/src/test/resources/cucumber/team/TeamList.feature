# language: pt
# encoding: iso-8859-1

Funcionalidade: Listar Times
  Como usuário
  Quero visualizar os times cadastrados

  Cenário: Deve retornar lista vazia
    Dado que não existam times cadastrados
    Quando eu acesso a listagem de times
    Então devo receber uma lista vazia como resposta

  Cenário: Deve retornar todos registros
    Dado que existam times cadastrados
    Quando eu acesso a listagem de times
    Então devo receber uma lista com todos times cadastrados
