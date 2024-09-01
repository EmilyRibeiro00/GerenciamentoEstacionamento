package GUI;
import Modelos.Cliente;
import Servicos.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EstacionamentoGUI extends JFrame {

    private ClienteGUI clienteGUI;
    private VeiculosGUI veiculosGUI;
    private VagasGUI vagasGUI;
    private GerenciamentoClientes gerenciamentoClientes;
    private GerenciamentoVagas gerenciamentoVagas;
    private GerenciamentoVeiculos gerenciamentoVeiculos;
    private GerenciamentoPagamento gerenciamentoPagamento;
    private GerenciamentoReservas gerenciamentoReservas;

    public EstacionamentoGUI() {

        configurarFrameGeral();
        configurarClienteGUI();
        configurarVeiculosGUI();
        configurarVagasGUI();

    }

    private void configurarVagasGUI(){
        this.gerenciamentoVagas = new GerenciamentoVagas();
        this.gerenciamentoReservas = new GerenciamentoReservas();
        this.vagasGUI = new VagasGUI(gerenciamentoVagas,gerenciamentoReservas);
    }
    private void configurarVeiculosGUI(){
        this.gerenciamentoVeiculos = new GerenciamentoVeiculos();
        this.gerenciamentoPagamento = new GerenciamentoPagamento();
        this.veiculosGUI = new VeiculosGUI(gerenciamentoVeiculos, gerenciamentoClientes,gerenciamentoPagamento);
    }

    private void configurarClienteGUI(){
        this.gerenciamentoClientes = new GerenciamentoClientes();
        this.clienteGUI = new ClienteGUI(gerenciamentoClientes);
    }
    private void configurarFrameGeral(){
        // Configurações do frame
        setTitle("Sistema de Gerenciamento de Estacionamento");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);


        Color pinkColor = new Color(255, 182, 193);

        // Gerenciamento de Vagas
        JButton btnGerenciarVagas = new JButton("Gerenciamento de Vagas");
        btnGerenciarVagas.setBounds(150, 50, 200, 30);
        btnGerenciarVagas.setBackground(pinkColor);
        btnGerenciarVagas.addActionListener(e -> vagasGUI.abrirDialogoGerenciamentoDeVagas());

        // Gerenciamento de Veiculos
        JButton btnGerenciarVeiculos = new JButton("Gerenciamento de Veículo");
        btnGerenciarVeiculos.setBounds(150, 100, 200, 30);
        btnGerenciarVeiculos.setBackground(pinkColor);
        btnGerenciarVeiculos.addActionListener(e -> veiculosGUI.abrirDialogoOpcoesGerenciamento());

        // Gerenciamento e Cadastro de Clientes
        JButton btnGerenciarClientes = new JButton("Gerenciamento de Clientes");
        btnGerenciarClientes.setBounds(150, 150, 200, 30);
        btnGerenciarClientes.setBackground(pinkColor);
        btnGerenciarClientes.addActionListener(e -> clienteGUI.abrirDialogoGerenciamentoDeClientes());

        // Relatórios
        JButton btnRelatoriosConsultas = new JButton("Relatórios");
        btnRelatoriosConsultas.setBounds(150, 200, 200, 30);
        btnRelatoriosConsultas.setBackground(pinkColor); 
        btnRelatoriosConsultas.addActionListener(e -> {
            RelatorioGUI relatorioGUI = new RelatorioGUI(this);
            relatorioGUI.setVisible(true);
        });

        // Adicionar os botões ao frame
        add(btnGerenciarVagas);
        add(btnGerenciarVeiculos);
        add(btnGerenciarClientes);
        add(btnRelatoriosConsultas);

        setVisible(true);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EstacionamentoGUI());
    }
}