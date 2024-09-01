package GUI;

import Modelos.Cliente;
import Modelos.Ticket;
import Modelos.Vagas;
import Modelos.VeiculoOcupaVaga;
import Servicos.GerenciamentoReservas;
import Servicos.GerenciamentoVagas;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class VagasGUI extends JFrame{

    private GerenciamentoVagas gerenciamentoVagas;
    private GerenciamentoReservas gerenciamentoReservas;


    public VagasGUI(GerenciamentoVagas gerenciamentoVagas, GerenciamentoReservas gerenciamentoReservas) {
        this.gerenciamentoVagas = gerenciamentoVagas;
        this. gerenciamentoReservas = gerenciamentoReservas;

    }

    public void abrirDialogoGerenciamentoDeVagas() {
        //Criação do diálogo
        JDialog dialogo = new JDialog(this, "Gerenciamento de Vagas", true);
        dialogo.setSize(400, 300);
        dialogo.setLocationRelativeTo(this);
        dialogo.setLayout(null);

        //Cadastrar Vaga
        JButton btnCadastrarVaga = new JButton("Cadastrar Vaga");
        btnCadastrarVaga.setBounds(100, 80, 200, 30);
        btnCadastrarVaga.setBackground(new Color(255, 192, 203));
        btnCadastrarVaga.addActionListener(e -> abrirDialogoCadastrarVaga());

        //Cadastro de Reserva
        JButton btnCadastroReserva = new JButton("Cadastro de Reserva");
        btnCadastroReserva.setBounds(100, 130, 200, 30);
        btnCadastroReserva.setBackground(new Color(255, 192, 203));
        btnCadastroReserva.addActionListener(e -> abrirDialogoCadastrarReserva());

        //Libera Reserva
        JButton btnLiberaReserva = new JButton("Libera Reserva");
        btnLiberaReserva.setBounds(100, 180, 200, 30);
        btnLiberaReserva.setBackground(new Color(255, 192, 203));
        btnLiberaReserva.addActionListener(e -> abrirDialogoLiberaReserva());


        dialogo.add(btnCadastrarVaga);
        dialogo.add(btnCadastroReserva);
        dialogo.add(btnLiberaReserva);

        dialogo.setVisible(true);
    }
    private void abrirDialogoLiberaReserva(){

        JDialog dialogoLiberaReserva = new JDialog(this, "Libera Reserva", true);
        dialogoLiberaReserva.setSize(300, 400);
        dialogoLiberaReserva.setLocationRelativeTo(this);
        dialogoLiberaReserva.setLayout(null);

        JLabel lblVaga = new JLabel("Número da Vaga:");
        lblVaga.setBounds(90, 50, 150, 25);
        dialogoLiberaReserva.add(lblVaga);

        JTextField txtVaga = new JTextField();
        txtVaga.setBounds(90, 80, 120, 25);
        dialogoLiberaReserva.add(txtVaga);

        JButton btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setBounds(90, 150, 120, 30);
        btnConfirmar.setBackground(new Color(255, 192, 203));
        btnConfirmar.addActionListener(e -> {
                    String vaga = txtVaga.getText();
                    if (vaga.isEmpty()) {
                        JOptionPane.showMessageDialog(dialogoLiberaReserva, "Por favor, insira a placa do veículo.", "Erro", JOptionPane.ERROR_MESSAGE);
                    } else {
                        //Altera status da vaga
                        if (gerenciamentoVagas.vagaExiste(vaga) && (gerenciamentoVagas.getStatusVaga(vaga).equals("Reservada"))) {
                            gerenciamentoVagas.liberaVaga(vaga);
                            JOptionPane.showMessageDialog(dialogoLiberaReserva, "Vaga " + vaga + " foi liberada");
                            dialogoLiberaReserva.dispose();
                        } else {
                            JOptionPane.showMessageDialog(dialogoLiberaReserva, "Vaga não existe ou não está reservada!");
                        }
                    }
                }
            );
        dialogoLiberaReserva.add(btnConfirmar);
        dialogoLiberaReserva.setVisible(true);
    }

    private void abrirDialogoCadastrarReserva() {

        JDialog dialogoReserva = new JDialog(this, "Cadastro de Reserva", true);
        dialogoReserva.setSize(300, 400);
        dialogoReserva.setLocationRelativeTo(this);
        dialogoReserva.setLayout(null);

        // Componentes do diálogo
        JLabel lblCliente = new JLabel("Cliente:");
        lblCliente.setBounds(20, 20, 100, 25);
        dialogoReserva.add(lblCliente);

        JTextField txtCliente = new JTextField(20);
        txtCliente.setBounds(140, 20, 120, 25);
        dialogoReserva.add(txtCliente);

        JLabel lblTipoVeiculo = new JLabel("Tipo de Veículo:");
        lblTipoVeiculo.setBounds(20, 60, 120, 25);
        dialogoReserva.add(lblTipoVeiculo);

        String[] tiposVeiculo = {"Carro", "Caminhao", "Moto"};
        JComboBox<String> cbTipoVeiculo = new JComboBox<>(tiposVeiculo);
        cbTipoVeiculo.setBounds(140, 60, 120, 25);
        dialogoReserva.add(cbTipoVeiculo);

        JLabel lblHorarioReserva = new JLabel("Horário da Reserva:");
        lblHorarioReserva.setBounds(20, 100, 200, 25);
        dialogoReserva.add(lblHorarioReserva);

        JTextField txtHorarioReserva = new JTextField(20);
        txtHorarioReserva.setBounds(140, 100, 120, 25);
        dialogoReserva.add(txtHorarioReserva);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(90, 140, 100, 30);
        btnSalvar.setBackground(new Color(255, 192, 203));
        btnSalvar.addActionListener(e -> {
            // Lógica para salvar a reserva
            if (lblCliente.getText().isEmpty() || cbTipoVeiculo.getSelectedItem() == null || lblHorarioReserva.getText() == null) {
                JOptionPane.showMessageDialog(dialogoReserva, "Todos os campos devem ser preenchidos.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                // Lógica para salvar a vaga
                String vagaReservada = gerenciamentoReservas.reservaVaga(txtCliente.getText(),(String) cbTipoVeiculo.getSelectedItem(),txtHorarioReserva.getText());
                if(vagaReservada!=null)   {
                JOptionPane.showMessageDialog(dialogoReserva, "Vaga reservada com sucesso. ID da Vaga: " + vagaReservada);
                } else {
                    JOptionPane.showMessageDialog(dialogoReserva, "Erro ao reservar a vaga.");
                }
                dialogoReserva.dispose();
            }
        });
        dialogoReserva.add(btnSalvar);

        dialogoReserva.setVisible(true);

    }

    private void abrirDialogoCadastrarVaga() {
        JDialog dialogoVaga = new JDialog(this, "Cadastrar Vaga", true);
        dialogoVaga.setSize(300, 400);
        dialogoVaga.setLocationRelativeTo(this);
        dialogoVaga.setLayout(null);


        JLabel lblLocalizacao = new JLabel("Localização:");
        lblLocalizacao.setBounds(20, 60, 120, 25);
        dialogoVaga.add(lblLocalizacao);

        JTextField txtLocalizacao = new JTextField(20);
        txtLocalizacao.setBounds(150, 60, 120, 25);
        dialogoVaga.add(txtLocalizacao);

        JLabel lblStatus = new JLabel("Status:");
        lblStatus.setBounds(20, 100, 120, 25);
        dialogoVaga.add(lblStatus);

        String[] status = {"Livre", "Ocupada", "Reservada"};
        JComboBox<String> cbStatus = new JComboBox<>(status);
        cbStatus.setBounds(150, 100, 120, 25);
        dialogoVaga.add(cbStatus);

        JLabel lblTipoVeiculo = new JLabel("Tipo de Veículo:");
        lblTipoVeiculo.setBounds(20, 140, 120, 25);
        dialogoVaga.add(lblTipoVeiculo);

        String[] tiposVeiculo = {"Carro", "Caminhao", "Moto"};
        JComboBox<String> cbTipoVeiculo = new JComboBox<>(tiposVeiculo);
        cbTipoVeiculo.setBounds(150, 140, 120, 25);
        dialogoVaga.add(cbTipoVeiculo);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(90, 180, 100, 30);
        btnSalvar.setBackground(new Color(255, 192, 203));
        btnSalvar.addActionListener(e -> {
            // Verifica se todos os campos estão preenchidos
            if (txtLocalizacao.getText().isEmpty() || cbStatus.getSelectedItem() == null || cbTipoVeiculo.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(dialogoVaga, "Todos os campos devem ser preenchidos.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                // Lógica para salvar a vaga
                boolean stat = gerenciamentoVagas.cadastrarVaga(txtLocalizacao.getText(),(String) cbStatus.getSelectedItem(), (String) cbTipoVeiculo.getSelectedItem());
                if (stat) {
                    JOptionPane.showMessageDialog(dialogoVaga, "Vaga cadastrada com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(dialogoVaga, "Erro ao cadastrar a vaga. Verifique os limites de vagas.");
                }
                dialogoVaga.dispose();
            }
        });

        dialogoVaga.add(btnSalvar);
        dialogoVaga.setVisible(true);
    }

}
