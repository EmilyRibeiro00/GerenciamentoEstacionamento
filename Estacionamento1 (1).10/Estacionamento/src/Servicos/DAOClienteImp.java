package Servicos;
import Modelos.Cliente;
import Servicos.Interfaces.ClienteDAO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DAOClienteImp implements ClienteDAO {

    private final String filePath = "clientes.txt";

    @Override
    public boolean encontraCliente(String nome){
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                // Verificar se o cliente existe
                String[] partes = linha.split(",");
                if (partes[0].equals(nome)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void addCliente(Cliente cliente) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(cliente.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Cliente getCliente(String nome) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Cliente cliente = Cliente.fromString(line);
                if (cliente.getNome().equals(nome)) {
                    return cliente;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Cliente> getAllClientes() {
        List<Cliente> clientes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                clientes.add(Cliente.fromString(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return clientes;
    }

    @Override
    public boolean updateCliente(Cliente cliente) {
        List<Cliente> clientes = getAllClientes();
        boolean clienteEncontrado = false; // Variável para verificar se o cliente foi encontrado

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Cliente c : clientes) {
                if (c.getNome().equals(cliente.getNome())) {
                    writer.write(cliente.toString()); // Escreve o cliente atualizado
                    clienteEncontrado = true; // Marca que o cliente foi encontrado e atualizado
                } else {
                    writer.write(c.toString()); // Mantém os outros clientes como estavam
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false; // Retorna falso em caso de erro de E/S
        }

        return clienteEncontrado; // Retorna true se o cliente foi encontrado e atualizado, senão false
    }

    @Override
    public boolean deleteCliente(String nome) {
        List<Cliente> clientes = getAllClientes();
        boolean clienteEncontrado = false; // Variável para verificar se o cliente foi encontrado

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Cliente c : clientes) {
                if (!c.getNome().equals(nome)) {
                    writer.write(c.toString());
                    writer.newLine();
                } else {
                    clienteEncontrado = true; // Marca que o cliente foi encontrado e deletado
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false; // Retorna falso em caso de erro de E/S
        }

        return clienteEncontrado; // Retorna true se o cliente foi encontrado e deletado, senão false
    }
}

