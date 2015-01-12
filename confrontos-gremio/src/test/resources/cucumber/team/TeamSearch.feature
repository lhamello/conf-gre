# language: pt
# encoding: iso-8859-1

Funcionalidade: Pesquisar Times
  Como usu�rio
  Quero pesquisar os times cadastrados

  Cen�rio: Deve listar times filtrando por nome completo existente
    Dado que existam times cadastrados
    E preencho o filtro nome completo com um valor existente
    Quando efetuo a pesquisa de times
    Ent�o s�o apresentados os registros correspondentes ao filtro informado

  Cen�rio: Deve listar times filtrando por nome completo inexistente
    Dado que existam times cadastrados
    E preencho o filtro nome completo com um valor inexistente
    Quando efetuo a pesquisa de times
    Ent�o nenhum registro � retornado pela pesquisa

  Cen�rio: Deve listar times filtrando por nome comum existente
    Dado que existam times cadastrados
    E preencho o filtro nome comum com um valor existente
    Quando efetuo a pesquisa de times
    Ent�o s�o apresentados os registros correspondentes ao filtro informado

  Cen�rio: Deve listar times filtrando por nome comum inexistente
    Dado que existam times cadastrados
    E preencho o filtro nome comum com um valor inexistente
    Quando efetuo a pesquisa de times
    Ent�o nenhum registro � retornado pela pesquisa
