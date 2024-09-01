package GUI;
import Exceptions.ClienteNaoEncontradoException;
import Modelos.Cliente;
import Servicos.GerenciamentoClientes;
import Servicos.GerenciamentoVeiculos;
import GUI.ClienteGUI;

import javax.swing.*;
import java.awt.*;

public class ClienteGUI extends JFrame{
    private GerenciamentoClientes gerenciamentoCliente;


    public ClienteGUI(GerenciamentoClientes gerenciamentoCliente){
        this.gerenciamentoCliente = gerenciamentoCliente;

    }
    public void abrirDialogoGerenciamentoDeClientes() {
        // Criação do diálogo
        JDialog dialogo = new JDialog(this, "Gerenciamento de Clientes", true);
        dialogo.setSize(300, 200);
        dialogo.setLocationRelativeTo(this);
        dialogo.setLayout(null);

        // Botão de Adicionar Cliente
        JButton btnAdicionarCliente = new JButton("Adicionar Cliente");
        btnAdicionarCliente.setBounds(50, 20, 200, 30);
        btnAdicionarCliente.setBackground(new Color(255, 192, 203)); // Rosa claro
        btnAdicionarCliente.addActionListener(e -> adicionarCliente());
        dialogo.add(btnAdicionarCliente);

        // Botão de Excluir Cliente
        JButton btnExcluirCliente = new JButton("Excluir Cliente");
        btnExcluirCliente.setBounds(50, 60, 200, 30);
        btnExcluirCliente.setBackground(new Color(255, 192, 203)); // Rosa claro
        btnExcluirCliente.addActionListener(e -> excluirCliente());
        dialogo.add(btnExcluirCliente);

        // Botão de Atualizar Dados do Cliente
        JButton btnAtualizarCliente = new JButton("Atualizar Dados do Cliente");
        btnAtualizarCliente.setBounds(50, 100, 200, 30);
        btnAtualizarCliente.setBackground(new Color(255, 192, 203)); // Rosa claro
        btnAtualizarCliente.addActionListener(e -> atualizarCliente());
        dialogo.add(btnAtualizarCliente);

        dialogo.setVisible(true);
    }


    private void adicionarCliente() {
        JDialog dialogoCliente = new JDialog(this, "Adicionar Cliente", true);
        dialogoCliente.setSize(300, 200);
        dialogoCliente.setLocationRelativeTo(this);
        dialogoCliente.setLayout(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(20, 20, 100, 25);
        dialogoCliente.add(lblNome);

        JTextField txtNome = new JTextField(20);
        txtNome.setBounds(140, 20, 120, 25);
        dialogoCliente.add(txtNome);

        JLabel lblTelefone = new JLabel("Telefone:");
        lblTelefone.setBounds(20, 60, 100, 25);
        dialogoCliente.add(lblTelefone);

        JTextField txtTelefone = new JTextField(20);
        txtTelefone.setBounds(140, 60, 120, 25);
        dialogoCliente.add(txtTelefone);

        JLabel lblEmail = new JLabel("E-mail:");
        lblEmail.setBounds(20, 100, 100, 25);
        dialogoCliente.add(lblEmail);

        JTextField txtEmail = new JTextField(20);
        txtEmail.setBounds(140, 100, 120, 25);
        dialogoCliente.add(txtEmail);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(100, 140, 100, 30);
        btnSalvar.setBackground(new Color(255, 192, 203));
        btnSalvar.addActionListener(e -> {

            // Verifica se todos os campos estão preenchidos
            if (txtNome.getText().isEmpty() || txtTelefone.getText().isEmpty() || txtEmail.getText().isEmpty()) {
                JOptionPane.showMessageDialog(dialogoCliente, "Todos os campos devem ser preenchidos.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                // Salvar o cliente
                gerenciamentoCliente.cadastrarCliente(txtNome.getText(), txtTelefone.getText(), txtEmail.getText());
                JOptionPane.showMessageDialog(dialogoCliente, "Cliente adicionado com sucesso", "Sucesso", JOptionPane.PLAIN_MESSAGE);
                dialogoCliente.dispose();
            }
        });
        dialogoCliente.add(btnSalvar);

        dialogoCliente.setVisible(true);
    }
    private void excluirCliente() {
        // Caixa de diálogo para solicitar o nome do cliente
        String nomeCliente = JOptionPane.showInputDialog(this, "Digite o nome do cliente a ser excluído:");

        // Verifica se o nome foi fornecido e confirma a exclusão
        if (nomeCliente != null && !nomeCliente.isEmpty()) {
            int opcao = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o cliente com nome " + nomeCliente + "?", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);
            if (opcao == JOptionPane.YES_OPTION) {
                try {
                    boolean stat = gerenciamentoCliente.removerCliente(nomeCliente);
                    if (!stat) {
                        throw new ClienteNaoEncontradoException("Cliente não encontrado");
                    }

                    JOptionPane.showMessageDialog(this, "Cliente excluído com sucesso!");

                } catch (ClienteNaoEncontradoException e) {
                    JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nome do cliente não fornecido.");
        }
    }

    private void atualizarCliente() {
        JDialog dialogoAtualizarCliente = new JDialog(this, "Atualizar Dados do Cliente", true);
        dialogoAtualizarCliente.setSize(300, 200);
        dialogoAtualizarCliente.setLocationRelativeTo(this);
        dialogoAtualizarCliente.setLayout(null);

        JLabel lblEmail = new JLabel("Novo E-mail:");
        lblEmail.setBounds(20, 100, 100, 25);
        dialogoAtualizarCliente.add(lblEmail);

        JTextField txtNovoEmail = new JTextField(20);
        txtNovoEmail.setBounds(140, 100, 120, 25);
        dialogoAtualizarCliente.add(txtNovoEmail);

        JLabel lblNovoTelefone = new JLabel("Novo Telefone:");
        lblNovoTelefone.setBounds(20, 60, 100, 25);
        dialogoAtualizarCliente.add(lblNovoTelefone);

        JTextField txtNovoTelefone = new JTextField(20);
        txtNovoTelefone.setBounds(140, 60, 120, 25);
        dialogoAtualizarCliente.add(txtNovoTelefone);

        JLabel lblNome = new JLabel("Nome do Cliente:");
        lblNome.setBounds(20, 20, 100, 25);
        dialogoAtualizarCliente.add(lblNome);

        JTextField txtNome = new JTextField(20);
        txtNome.setBounds(140, 20, 120, 25);
        dialogoAtualizarCliente.add(txtNome);


        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(90, 140, 100, 30);
        btnSalvar.setBackground(new Color(255, 192, 203));
        btnSalvar.addActionListener(e -> {
            String nomeCliente = txtNome.getText();
            String telefoneNovo = txtNovoTelefone.getText();
            String emailNovo = txtNovoEmail.getText();

            // Chama o método para atualizar o cliente
            boolean clienteEncontrado = gerenciamentoCliente.atualizarCliente(nomeCliente, telefoneNovo, emailNovo);

            // Verifica se o cliente foi encontrado
            if (clienteEncontrado) {
                JOptionPane.showMessageDialog(dialogoAtualizarCliente, "Dados do cliente atualizados com sucesso!");
                dialogoAtualizarCliente.dispose();
            } else {
                JOptionPane.showMessageDialog(dialogoAtualizarCliente, "Cliente não encontrado!");
            }
        });

        dialogoAtualizarCliente.add(btnSalvar);
        dialogoAtualizarCliente.setVisible(true);
    }
}

