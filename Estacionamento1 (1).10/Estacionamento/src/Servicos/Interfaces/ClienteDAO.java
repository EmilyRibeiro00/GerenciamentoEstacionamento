package Servicos.Interfaces;

import Modelos.Cliente;

import java.util.List;

public interface ClienteDAO {
    public boolean encontraCliente(String nome);
    void addCliente(Cliente cliente);
    Cliente getCliente(String nome);
    List<Cliente> getAllClientes();
    boolean updateCliente(Cliente cliente);
    boolean deleteCliente(String nome);
}
