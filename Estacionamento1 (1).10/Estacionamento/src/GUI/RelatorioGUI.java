package GUI;

import Servicos.GerenciamentoRelatorio;

import javax.swing.*;
import java.awt.*;

public class RelatorioGUI extends JDialog {
    private GerenciamentoRelatorio gerenciamentoRelatorio = new GerenciamentoRelatorio();

    public RelatorioGUI(GerenciamentoRelatorio gerenciamentoRelatorio){
        this.gerenciamentoRelatorio = gerenciamentoRelatorio;
    }

    public RelatorioGUI(JFrame parent) {
        super(parent, "Relatório", true);
        setSize(310, 300);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(null);

        // Botão histórico
        JButton btnGerarRelatorio = new JButton("Gerar Relatório");
        btnGerarRelatorio.setBounds(50, 125, 200, 30);
        btnGerarRelatorio.setBackground(new Color(255, 192, 203));
        btnGerarRelatorio.addActionListener(e->{

            JDialog dialogo = new JDialog(this, "Relatório", true);
            dialogo.setSize(400, 300);
            dialogo.setLocationRelativeTo(this);
            dialogo.setLayout(null);

            String relatorio =  gerenciamentoRelatorio.gerarRelatorio();
            JOptionPane.showMessageDialog(null, relatorio, "Relatório", JOptionPane.INFORMATION_MESSAGE);
            dialogo.dispose();

        });
        panel.add(btnGerarRelatorio);
        add(panel);
    }
}
