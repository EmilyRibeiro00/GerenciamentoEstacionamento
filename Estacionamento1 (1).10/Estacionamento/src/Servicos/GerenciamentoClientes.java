package Servicos;
import Modelos.Cliente;
import Modelos.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class GerenciamentoClientes {

    private Cliente cliente;
    private DAOClienteImp clienteDAO = new DAOClienteImp();

    public GerenciamentoClientes() {}
    public int qtdClientesCadastrados() {
        return clienteDAO.getAllClientes().size();
    }

    public boolean verificaSeClienteEstaCadastrado(String nome){
        return clienteDAO.encontraCliente(nome);
    }
    public void cadastrarCliente(String nome, String telefone, String email) {
        cliente = new Cliente(nome, telefone, email);
        clienteDAO.addCliente(cliente);
    }
    public void cadastrarVeiculoDeCliente(String placa, String nome) {
        Cliente clienteComCarro = clienteDAO.getCliente(nome);
        clienteComCarro.adicionarVeiculo(placa);
        clienteDAO.updateCliente(clienteComCarro);
    }
    public boolean atualizarCliente(String nome, String telefone, String email){
        //Identificado pelo nome
        cliente = new Cliente(nome, telefone, email);
         return clienteDAO.updateCliente(cliente);
    }
    public boolean removerCliente(String nome) {
        return clienteDAO.deleteCliente(nome);
    }
    public Cliente buscarCliente(String nome) {
        cliente = clienteDAO.getCliente(nome);
        return cliente;
    }
    public List<Cliente> verTodosClientes() {
        return clienteDAO.getAllClientes(); //Retorna lista com todos os clientes
    }
}

