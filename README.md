# testeDBC

Validar Investimento

	No primeiro teste pensei em como fazer para validar o formulário utilizando o valor mínimo de 20.00, para garantir a aceitação, tal como boundary testing, validar com valor inferior ao permitido, igual ao mínimo, máximo e superior ao máximo. Como neste caso não temos um valor máximo, não realizei demais testes, podendo realizar se necessário. Pensei, também, em validar os 4 retornos na tabela, mas teria que realizar o cálculo para os diferentes retornos dependendo do valor e quantidade de tempo, poderia adicionar variáveis para "se mês X / valor = y", mas não identifiquei a melhor maneira de abordar esse approach, então validei o retorno do formulário

	No segundo teste realizei a inserção dos valores inferiores a 20, para validar a mensagem de erro, onde foram validadas com sucesso. Também pensei em adicionar uma lógica de if/else, clicando no botão "simular" e conforme resultado, se a mensagem persistisse aprovar o caso, se não avançaria para a tabela de valores e falharia o teste. Mas, novamente, não identifiquei como iria falhar o teste, para poder adicionar a lógica de forma correta.

Validar API

	Ao que compreendi, esta validação dependia apenas de efetuar get na API e validar o response do Body, contendo os valores do response. Tentei validar como arrayContaining, mas não funcionou da maneira adequada, então alterei para o "Matchers.contains" para validar os valores dentro do body
