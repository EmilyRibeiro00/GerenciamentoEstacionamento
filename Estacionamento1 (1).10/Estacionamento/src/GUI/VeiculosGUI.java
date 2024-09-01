package GUI;

import Modelos.*;
import Servicos.GerenciamentoClientes;
import Servicos.GerenciamentoPagamento;
import Servicos.GerenciamentoVeiculos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VeiculosGUI extends JFrame {

    private GerenciamentoVeiculos gerenciamentoVeiculos;
    private GerenciamentoClientes gerenciamentoClientes;
    private GerenciamentoPagamento gerenciamentoPagamento;


    public VeiculosGUI(GerenciamentoVeiculos gerenciamentoVeiculos, GerenciamentoClientes gerenciamentoClientes,GerenciamentoPagamento gerenciamentoPagamento) {
        this.gerenciamentoVeiculos = gerenciamentoVeiculos;
        this.gerenciamentoClientes = gerenciamentoClientes;
        this.gerenciamentoPagamento = gerenciamentoPagamento;
    }

    public void abrirDialogoOpcoesGerenciamento() {
        //Criação do diálogo
        JDialog dialogoOpcoes = new JDialog(this, "Gerenciamento de Veículos", true);
        dialogoOpcoes.setSize(300, 200);
        dialogoOpcoes.setLocationRelativeTo(this);
        dialogoOpcoes.setLayout(null);

        //Entrada de Veículo
        JButton btnEntradaVeiculo = new JButton("Entrada de Veículo");
        btnEntradaVeiculo.setBounds(50, 20, 200, 40);
        btnEntradaVeiculo.setBackground(new Color(255, 192, 203));
        btnEntradaVeiculo.addActionListener(e -> abrirDialogoCadastrarVeiculo());

        //Saída de Veículo
        JButton btnSaidaVeiculo = new JButton("Saída de Veículo");
        btnSaidaVeiculo.setBounds(50, 80, 200, 40);
        btnSaidaVeiculo.setBackground(new Color(255, 192, 203));
        btnSaidaVeiculo.addActionListener(e -> abrirDialogoSaidaVeiculo());

        dialogoOpcoes.add(btnEntradaVeiculo);
        dialogoOpcoes.add(btnSaidaVeiculo);

        dialogoOpcoes.setVisible(true);
    }

    public void abrirDialogoCadastrarVeiculo() {
        JDialog dialogoVeiculo = new JDialog(this, "Cadastrar Veículo", true);
        dialogoVeiculo.setSize(400, 500);
        dialogoVeiculo.setLocationRelativeTo(this);
        dialogoVeiculo.setLayout(null);

        JLabel lblTipoVeiculo = new JLabel("Tipo de Veículo:");
        lblTipoVeiculo.setBounds(30, 20, 100, 25);
        dialogoVeiculo.add(lblTipoVeiculo);

        String[] tiposVeiculo = {"Carro", "Caminhao", "Moto"};
        JComboBox<String> cbTipoVeiculo = new JComboBox<>(tiposVeiculo);
        cbTipoVeiculo.setBounds(150, 20, 200, 25);
        dialogoVeiculo.add(cbTipoVeiculo);

        JPanel painelAtributos = new JPanel(null);
        painelAtributos.setBounds(30, 60, 340, 350);
        dialogoVeiculo.add(painelAtributos);

        cbTipoVeiculo.addActionListener(e -> {
            painelAtributos.removeAll();
            String tipoSelecionado = (String) cbTipoVeiculo.getSelectedItem();
            if (tipoSelecionado != null) {
                //Envia o tipo selecionado para fazer o cadastro
                adicionarCamposAtributosVeiculo(painelAtributos, tipoSelecionado);
            }
            painelAtributos.revalidate();
            painelAtributos.repaint();
        });

        dialogoVeiculo.setVisible(true);
    }

    private void adicionarCamposAtributosVeiculo(JPanel painelAtributos, String tipoSelecionado) {
        int y = 0;

        JLabel lblPlaca = new JLabel("Placa:");
        lblPlaca.setBounds(0, y, 100, 25);
        painelAtributos.add(lblPlaca);

        JTextField txtPlaca = new JTextField(20);
        txtPlaca.setBounds(150, y, 150, 25);
        painelAtributos.add(txtPlaca);

        y += 35;

        JTextField txtCor = new JTextField(20);
        JTextField txtMarca = new JTextField(20);
        JTextField txtModelo = new JTextField(20);
        JTextField txtCargaMaxima = new JTextField(20);
        JTextField txtComprimento = new JTextField(20);
        JTextField txtCilindradas = new JTextField(20);

        if (tipoSelecionado.equals("Carro")) {
            JLabel lblCor = new JLabel("Cor:");
            lblCor.setBounds(0, y, 100, 25);
            painelAtributos.add(lblCor);

            txtCor.setBounds(150, y, 150, 25);
            painelAtributos.add(txtCor);

            y += 35;

            JLabel lblMarca = new JLabel("Marca:");
            lblMarca.setBounds(0, y, 100, 25);
            painelAtributos.add(lblMarca);

            txtMarca.setBounds(150, y, 150, 25);
            painelAtributos.add(txtMarca);

            y += 35;

            JLabel lblModelo = new JLabel("Modelo:");
            lblModelo.setBounds(0, y, 100, 25);
            painelAtributos.add(lblModelo);

            txtModelo.setBounds(150, y, 150, 25);
            painelAtributos.add(txtModelo);

            y += 35;

        } else if (tipoSelecionado.equals("Caminhao")) {
            JLabel lblCargaMaxima = new JLabel("Carga Máxima:");
            lblCargaMaxima.setBounds(0, y, 100, 25);
            painelAtributos.add(lblCargaMaxima);

            txtCargaMaxima.setBounds(150, y, 150, 25);
            painelAtributos.add(txtCargaMaxima);

            y += 35;

            JLabel lblComprimento = new JLabel("Comprimento:");
            lblComprimento.setBounds(0, y, 100, 25);
            painelAtributos.add(lblComprimento);

            txtComprimento.setBounds(150, y, 150, 25);
            painelAtributos.add(txtComprimento);

            y += 35;

        } else if (tipoSelecionado.equals("Moto")) {
            JLabel lblMarca = new JLabel("Marca:");
            lblMarca.setBounds(0, y, 100, 25);
            painelAtributos.add(lblMarca);

            txtMarca.setBounds(150, y, 150, 25);
            painelAtributos.add(txtMarca);

            y += 35;

            JLabel lblCilindradas = new JLabel("Cilindradas:");
            lblCilindradas.setBounds(0, y, 100, 25);
            painelAtributos.add(lblCilindradas);

            txtCilindradas.setBounds(150, y, 150, 25);
            painelAtributos.add(txtCilindradas);

            y += 35;
        }

        JLabel lblCliente = new JLabel("Cliente:");
        lblCliente.setBounds(0, y, 100, 25);
        painelAtributos.add(lblCliente);

        JRadioButton rbSim = new JRadioButton("Sim");
        rbSim.setBounds(150, y, 60, 25);
        JRadioButton rbNao = new JRadioButton("Não");
        rbNao.setBounds(220, y, 60, 25);

        ButtonGroup bgCliente = new ButtonGroup();
        bgCliente.add(rbSim);
        bgCliente.add(rbNao);

        painelAtributos.add(rbSim);
        painelAtributos.add(rbNao);

        y += 35;

        JLabel lblNomeCliente = new JLabel("Nome do Cliente:");
        lblNomeCliente.setBounds(0, y, 150, 25);
        lblNomeCliente.setVisible(false);
        painelAtributos.add(lblNomeCliente);

        List<Cliente> clientes = gerenciamentoClientes.verTodosClientes();
        JComboBox<String> cbClientes = new JComboBox<>(clientes.stream().map(Cliente::getNome).toArray(String[]::new));
        cbClientes.setBounds(150, y, 150, 25);
        cbClientes.setVisible(false);
        painelAtributos.add(cbClientes);

        rbSim.addActionListener(e -> {
            lblNomeCliente.setVisible(true);
            cbClientes.setVisible(true);
        });

        rbNao.addActionListener(e -> {
            lblNomeCliente.setVisible(false);
            cbClientes.setVisible(false);
        });

        y += 35;

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(100, y, 100, 30);
        btnSalvar.setBackground(new Color(255, 192, 203));
        btnSalvar.addActionListener(e -> {
            try {
                String nomeCliente = null;
                String placa = txtPlaca.getText().trim();
                String cor = txtCor.getText().trim();
                String marca = txtMarca.getText().trim();
                String modelo = txtModelo.getText().trim();
                String cargaMaximaText = txtCargaMaxima.getText().trim();
                String comprimentoText = txtComprimento.getText().trim();
                String cilindradasText = txtCilindradas.getText().trim();
                nomeCliente = (String) cbClientes.getSelectedItem();

                if (placa.isEmpty() || (tipoSelecionado.equals("Carro") && (cor.isEmpty() || marca.isEmpty() || modelo.isEmpty())) ||
                        (tipoSelecionado.equals("Caminhao") && (cargaMaximaText.isEmpty() || comprimentoText.isEmpty())) ||
                        (tipoSelecionado.equals("Moto") && (marca.isEmpty() || cilindradasText.isEmpty())) ||
                        (rbSim.isSelected() && nomeCliente == null)) {
                    JOptionPane.showMessageDialog(painelAtributos.getTopLevelAncestor(), "Todos os campos devem ser preenchidos.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int cargaMaxima = 0;
                int comprimento = 0;
                int cilindradas = 0;

                if (!cargaMaximaText.isEmpty()) {
                    cargaMaxima = Integer.parseInt(cargaMaximaText);
                }
                if (!comprimentoText.isEmpty()) {
                    comprimento = Integer.parseInt(comprimentoText);
                }
                if (!cilindradasText.isEmpty()) {
                    cilindradas = Integer.parseInt(cilindradasText);
                }

                boolean stat = false;
                switch (tipoSelecionado) {
                    case "Carro" -> stat = gerenciamentoVeiculos.cadastrarVeiculo(placa, cor, marca, modelo);
                    case "Caminhao" -> stat = gerenciamentoVeiculos.cadastrarVeiculo(placa, cargaMaxima, comprimento);
                    case "Moto" -> stat = gerenciamentoVeiculos.cadastrarVeiculo(placa, marca, cilindradas);
                }
                int a = 0;
                if(nomeCliente!=null && stat && rbSim.isSelected()){
                    a = 3;
                    gerenciamentoClientes.cadastrarVeiculoDeCliente(placa,nomeCliente);

                }

                if (stat) {
                    JOptionPane.showMessageDialog(painelAtributos.getTopLevelAncestor(), "Veículo cadastrado com sucesso!");

                    ((JDialog) painelAtributos.getTopLevelAncestor()).dispose();
                } else {

                    JOptionPane.showMessageDialog(painelAtributos.getTopLevelAncestor(), "Falha ao cadastrar o veículo.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(painelAtributos.getTopLevelAncestor(), "Erro nos dados fornecidos. Verifique os campos numéricos.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
        painelAtributos.add(btnSalvar);
    }


    public void abrirDialogoSaidaVeiculo() {
        JDialog dialogoSaida = new JDialog(this, "Saída de Veículo", true);
        dialogoSaida.setSize(300, 200);
        dialogoSaida.setLocationRelativeTo(this);
        dialogoSaida.setLayout(null);

        JLabel lblPlaca = new JLabel("Placa do Veículo:");
        lblPlaca.setBounds(30, 30, 100, 25);
        dialogoSaida.add(lblPlaca);

        JTextField txtPlaca = new JTextField();
        txtPlaca.setBounds(140, 30, 120, 25);
        dialogoSaida.add(txtPlaca);

        JButton btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setBounds(90, 100, 120, 30);
        btnConfirmar.setBackground(new Color(255, 192, 203));
        btnConfirmar.addActionListener(e -> {
            String placa = txtPlaca.getText().trim();
            if (placa.isEmpty()) {
                JOptionPane.showMessageDialog(dialogoSaida, "Por favor, insira a placa do veículo.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                //Devolve um objeto do tipo VeiculoOcupaVaga
                VeiculoOcupaVaga veiculoOcupaVaga = gerenciamentoVeiculos.excluirVeiculo(placa);
                if(veiculoOcupaVaga!=null) {
                    JOptionPane.showMessageDialog(dialogoSaida, "Veículo com placa " + placa + " está saindo.");

                    //Manda o VeiculoOcupaVaga para o Gerenciamento Pagamento e recebe um Ticket de Pagamento
                    Ticket ticket = gerenciamentoPagamento.getTicket(veiculoOcupaVaga);

                    //Envia o Ticket para o Dialogo de Pagamento
                    abrirDialogoPagamento(ticket);
                    dialogoSaida.dispose();

                }else{
                    JOptionPane.showMessageDialog(dialogoSaida, "Veículo não encontrado!");
                }

            }
        });
        dialogoSaida.add(btnConfirmar);
        dialogoSaida.setVisible(true);
    }


    public void abrirDialogoPagamento(Ticket ticket) {
        // Criação do diálogo
        JDialog dialogo = new JDialog(this, "Pagamento", true);
        dialogo.setSize(400, 300);
        dialogo.setLocationRelativeTo(this);
        dialogo.setLayout(null);

        // Componentes do diálogo
        JLabel lblValorTotal = new JLabel("Valor a pagar: R$ "+ ticket.getValorAPagar()); // Exemplo de valor total
        lblValorTotal.setBounds(30, 20, 200, 25);
        dialogo.add(lblValorTotal);

        JLabel lblFormaDePagamento = new JLabel("Forma de Pagamento:");
        lblFormaDePagamento.setBounds(30, 60, 150, 25);
        dialogo.add(lblFormaDePagamento);

        String[] formaDePagamento = {"Dinheiro", "Cartão", "Pix"};
        JComboBox<String> cbFormaDePagamento = new JComboBox<>(formaDePagamento);
        cbFormaDePagamento.setBounds(180, 60, 150, 25);
        dialogo.add(cbFormaDePagamento);

        // Componentes adicionais
        JPanel painelAdicional = new JPanel(null);
        painelAdicional.setBounds(30, 100, 350, 150);
        dialogo.add(painelAdicional);


        // Painel para Dinheiro
        JPanel painelDinheiro = new JPanel(null);
        painelDinheiro.setBounds(0, 0, 350, 150);

        JLabel lblValorRecebido = new JLabel("Valor Recebido:");
        lblValorRecebido.setBounds(0, 0, 120, 25);
        painelDinheiro.add(lblValorRecebido);

        JTextField txtValorRecebido = new JTextField(10);
        txtValorRecebido.setBounds(130, 0, 200, 25);
        painelDinheiro.add(txtValorRecebido);

        JLabel lblTroco = new JLabel("Troco:");
        lblTroco.setBounds(0, 40, 120, 25);
        painelDinheiro.add(lblTroco);

        JTextField txtTroco = new JTextField(10);
        txtTroco.setBounds(130, 40, 200, 25);
        txtTroco.setEditable(false);
        painelDinheiro.add(txtTroco);

        JButton btnCalcularTroco = new JButton("Calcular Troco");
        btnCalcularTroco.setBounds(0, 80, 150, 30);
        painelDinheiro.add(btnCalcularTroco);

        btnCalcularTroco.addActionListener(e -> {
            String valorRecebidoStr = txtValorRecebido.getText().trim();
            if (!valorRecebidoStr.isEmpty()) {
                double valorRecebido = Double.parseDouble(valorRecebidoStr);
                double totalPagamento = Double.parseDouble(ticket.getValorAPagar());
                double troco = valorRecebido - totalPagamento;
                txtTroco.setText(String.format("%.2f", troco));
            } else {
                JOptionPane.showMessageDialog(dialogo, "Por favor, insira o valor recebido.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Painel para Cartão
        JPanel painelCartao = new JPanel(null);
        painelCartao.setBounds(0, 0, 350, 150);

        JLabel lblNumeroCartao = new JLabel("Número do Cartão:");
        lblNumeroCartao.setBounds(0, 0, 150, 25);
        painelCartao.add(lblNumeroCartao);

        JTextField txtNumeroCartao = new JTextField(16);
        txtNumeroCartao.setBounds(160, 0, 180, 25);
        painelCartao.add(txtNumeroCartao);

        JLabel lblCVV = new JLabel("CVV:");
        lblCVV.setBounds(0, 40, 120, 25);
        painelCartao.add(lblCVV);

        JTextField txtCVV = new JTextField(3);
        txtCVV.setBounds(160, 40, 50, 25);
        painelCartao.add(txtCVV);

        // Painel para Pix
        JPanel painelPix = new JPanel(null);
        painelPix.setBounds(0, 0, 350, 150);

        JLabel lblEmailPix = new JLabel("Email para Pix:");
        lblEmailPix.setBounds(0, 0, 150, 25);
        painelPix.add(lblEmailPix);

        JLabel lblEmailPixValor = new JLabel("exemplo@pix.com");
        lblEmailPixValor.setBounds(160, 0, 180, 25);
        painelPix.add(lblEmailPixValor);

        // Adiciona os painéis ao painelAdicional
        painelAdicional.add(painelDinheiro);
        painelAdicional.add(painelCartao);
        painelAdicional.add(painelPix);

        painelDinheiro.setVisible(true);
        painelCartao.setVisible(false);
        painelPix.setVisible(false);

        // Listener para o JComboBox
        cbFormaDePagamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String) cbFormaDePagamento.getSelectedItem();
                painelDinheiro.setVisible("Dinheiro".equals(selected));
                painelCartao.setVisible("Cartão".equals(selected));
                painelPix.setVisible("Pix".equals(selected));
            }
        });

        JButton btnGerarRecibo = new JButton("Gerar Recibo");
        btnGerarRecibo.setBounds(30, 220, 150, 30);
        dialogo.add(btnGerarRecibo);

        btnGerarRecibo.addActionListener(e -> {
            String selectedPaymentMethod = (String) cbFormaDePagamento.getSelectedItem();

            String troco = "0";
            String valorRecebido = "0";
            if ("Dinheiro".equals(selectedPaymentMethod)) {
                valorRecebido = txtValorRecebido.getText().trim();
                if (!valorRecebido.isEmpty()) {
                    //Calcula o troco
                    troco = gerenciamentoPagamento.calcularTroco(valorRecebido, ticket.getValorAPagar());
                } else {
                    JOptionPane.showMessageDialog(dialogo, "Por favor, insira o valor recebido.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            String recibo =  gerenciamentoPagamento.gerarRecibo(ticket, selectedPaymentMethod, valorRecebido, Double.parseDouble(ticket.getValorAPagar()), troco);
            JOptionPane.showMessageDialog(null, recibo, "Recibo", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(dialogo, "Recibo gerado com sucesso");
            dialogo.dispose();
        });

        dialogo.setVisible(true);
    }


}
