# language: pt
# encoding: iso-8859-1

Funcionalidade: Pesquisar Times
  Como usuário
  Quero pesquisar os times cadastrados

  Cenário: Deve listar times filtrando por nome completo existente
    Dado que existam times cadastrados
    E preencho o filtro nome completo com um valor existente
    Quando efetuo a pesquisa de times
    Então são apresentados os registros correspondentes ao filtro informado

  Cenário: Deve listar times filtrando por nome completo inexistente
    Dado que existam times cadastrados
    E preencho o filtro nome completo com um valor inexistente
    Quando efetuo a pesquisa de times
    Então nenhum registro é retornado pela pesquisa

  Cenário: Deve listar times filtrando por nome comum existente
    Dado que existam times cadastrados
    E preencho o filtro nome comum com um valor existente
    Quando efetuo a pesquisa de times
    Então são apresentados os registros correspondentes ao filtro informado

  Cenário: Deve listar times filtrando por nome comum inexistente
    Dado que existam times cadastrados
    E preencho o filtro nome comum com um valor inexistente
    Quando efetuo a pesquisa de times
    Então nenhum registro é retornado pela pesquisa
