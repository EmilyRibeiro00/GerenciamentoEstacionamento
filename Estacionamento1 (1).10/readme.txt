######  AUTORES ###### 
Amanda Almeida Cardoso  
Danilo Silva Carneiro
Emily Gabriela Costa Ribeiro

##### DISCIPLINA #####

Linguagem de Programação II

#######################
 

O código utiliza classes GUI para acessar os Serviços (Gerenciamentos e Data Access Objects).

Os Gerenciamentos instanciam os objetos a serem criados com base nas classes Modelo: Veiculo (podendo ser Carro, Moto, Caminhão), Vagas, VeiculoOcupaVaga, Ticket e Clientes. 

Os DAOS salvam as informações em arquivos de texto, que serviram como um tipo de banco de dados para o nosso trabalho.

Destacamos que os veículos não possuem um atributo vaga, assim como as vagas não possuem um atributo veículo, por isso, foi necessário a criação de uma classe para realizar a associação entre ambos, a classe VeiculoOcupaVaga.

As informações cadastradas pelo usuário são salvas em arquivos txt. 
Os arquivos base são: clientes, vagas, veículos. Os dados cadastrados aqui não são excluídos quando o veículo sai do estacionamento. Porém é possível excluir um cliente, caso o usuário deseje. O status da vaga muda de acordo com a lotação do estacionamento.

O arquivo que é responsável pelos veículos estacionados em tempo real é o "carros_ocupando_vagas". Esse arquivo é atualizado de acordo com os veículos que entram e saem do estacionamento. 



#### Funcionalidades ####

## Gerenciamento Vagas ##

É possível cadastrar vaga para um tipo específico de veículo, reservar vaga para tipo específico de veículo e apenas para clientes, e liberar uma vaga reservada.
O id da vaga é gerado automaticamente.

## Gerenciamento Veículo ## 

Entrada e saída de veículo do estacionamento. É possível associar um cliente cadastrado a um veículo. Ao sair, a vaga é liberada automaticamente e o cliente é levado a janela de pagamento automaticamente. É gerado um ticket de pagamento e o cliente deve optar pela forma de pagamento. 

## Gerenciamento de Clientes ## 

Adiciona, exclui e atualiza cliente.

## Relatórios ##

Gera um relatório na tela com informações do estacionamento, como valor arrecadado, numero de vagas livres, numero de vagas reservadas, etc. 
