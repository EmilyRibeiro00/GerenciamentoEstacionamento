package Servicos;

import Modelos.Ticket;
import Modelos.VeiculoOcupaVaga;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class GerenciamentoPagamento {

    private static double caixaTotal;
    private double minCaminhao = 0.08; // 5 reais a hora
    private double minCarro = 0.05 ; //3 reais a hora
    private double minMoto = 0.03; // 2 reais a hora
    private GerenciamentoVagas gerenciamentoVagas;

    public GerenciamentoPagamento() {
        this.gerenciamentoVagas = new GerenciamentoVagas();

    }


    public GerenciamentoPagamento(double minCaminhao, double minCarro, double minMoto) {
        this.minCaminhao = minCaminhao;
        this.minCarro = minCarro;
        this.minMoto = minMoto;
    }

    public Ticket getTicket(VeiculoOcupaVaga veiculoASair){
        double tempoPercorrido = calculaTempoPercorrido(veiculoASair.getHorarioEntrada(), veiculoASair.getHorarioSaida());
        String idVaga = veiculoASair.getIdVaga();
        String tipoDeVeiculo = gerenciamentoVagas.getTipoVeiculo(idVaga);
        double valorAPagar = 0.0;

        switch (tipoDeVeiculo) {
            case "Carro" -> {
                valorAPagar = tempoPercorrido * this.minCarro;
            }
            case "Caminhao" -> {
                valorAPagar=  tempoPercorrido * this.minCaminhao;
            }
            case "Moto" -> {
                valorAPagar= tempoPercorrido * this.minMoto;
            }
        }
        caixaTotal+=valorAPagar;
        String total = String.valueOf(valorAPagar);
        String tempo = String.valueOf(tempoPercorrido);

        return new Ticket(idVaga,veiculoASair.getPlaca(),veiculoASair.getHorarioEntrada(),veiculoASair.getHorarioSaida(), tempo,total);
    }
    public int calculaTempoPercorrido(String entrada, String saida) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime horarioEntrada = LocalDateTime.parse(entrada, formatter);
        LocalDateTime horarioSaida = LocalDateTime.parse(saida, formatter);
        Duration duration = Duration.between(horarioEntrada, horarioSaida);
        long minutos = duration.toMinutes();
        return (int) minutos;
    }

    public String calcularTroco(String txtValorRecebido, String totalPagamento){
       double valorRecebido = Double.parseDouble(txtValorRecebido);
       double valorPagar = Double.parseDouble(totalPagamento);
       double troco = valorRecebido - valorPagar;
       return String.valueOf(troco);
    }
    public String gerarRecibo(Ticket ticket, String formaDePagamento, String valorRecebido, double totalPagamento, String troco) {
        String recibo = String.format(
                "Recibo de Pagamento\n" +
                        "---------------------\n" +
                        "Horário de Entrada: %s\n" +
                        "Horário de Saída: %s\n" +
                        "Tempo Estacionado: %s minutos\n" +
                        "Total a Pagar: R$%.2f\n" +
                        "Valor Recebido: R$%s\n" +
                        "Troco: R$%s\n" +
                        "Forma de Pagamento: %s",
                ticket.getHorarioEntrada(),
                ticket.getHorarioSaida(),
                ticket.getTempoDePermanencia(),
                totalPagamento,
                valorRecebido,
                troco,
                formaDePagamento
        );
        return recibo;
    }
    public double getCaixaTotal(){
        return caixaTotal;
    }



}
