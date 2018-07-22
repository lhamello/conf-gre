# language: pt
# encoding: iso-8859-1
Funcionalidade: Inserir Partida
  
  Sendo um usuário
  Eu quero inserir partidas
  Para manter os registros destas partidas

  Esquema do Cenario: calcular o número da partida
    Dado que crio uma nova partida
    E <existemOuNaoExistem> partidas cadastradas no banco de dados
    E preencho o campo data com valor <data>
    E preencho o campo horario com valor <horario>
    Quando uma nova partida for cadastrada no banco de dados
    Entao ela deve possuir numero igual à <numero>

    Exemplos: 
      | existemOuNaoExistem | data         | horario | numero |
      | não existem         | "01/07/1986" | "18:00" | 1      |
      | existem             | "01/07/1986" | "19:00" | 1      |
      | existem             | "01/07/2010" | "20:00" | 5      |
      | existem             | "01/07/1986" | "21:30" | 2      |
      | existem             | "01/07/1986" | null    | 3      |
      | existem             | "04/07/1986" | null    | 5      |
