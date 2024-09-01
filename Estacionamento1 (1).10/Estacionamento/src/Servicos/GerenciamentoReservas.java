package Servicos;

import Modelos.Vagas;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class GerenciamentoReservas {
    private GerenciamentoVagas gerenciamentoVagas;
    private GerenciamentoVeiculoOcupaVaga gerenciamentoVeiculoOcupaVaga;
    private GerenciamentoClientes gerenciamentoClientes;


    public GerenciamentoReservas() {
        this.gerenciamentoVagas = new  GerenciamentoVagas();
        this.gerenciamentoVeiculoOcupaVaga = new GerenciamentoVeiculoOcupaVaga();
        this.gerenciamentoClientes = new GerenciamentoClientes();
    }

    public String reservaVaga(String nome, String tipoVeiculo, String horario){
        //Verifica se cliente está na lista de cliente
        boolean clienteEncontrado = gerenciamentoClientes.verificaSeClienteEstaCadastrado(nome);
        if(clienteEncontrado){
            //Muda o status de vaga pra ocupada
            String idVaga = gerenciamentoVagas.reservarVaga(tipoVeiculo, horario);
  //          agendarLiberacaoVaga(horario,idVaga);
            return idVaga;
        }
        return null;
    }
//
//    private void agendarLiberacaoVaga(String horario, String idVaga) {
//        Vagas vagaALiberar = gerenciamentoVagas.getVaga(idVaga);
//        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
//        try {
//            Date dataReserva = dateFormat.parse(horario);
//            // Adiciona 10 minutos à data da reserva para tolerância
//            long delay = dataReserva.getTime() + 600000 - System.currentTimeMillis(); // 600000 ms = 10 minutos
//            Timer timer = new Timer();
//            timer.schedule(new TimerTask() {
//                @Override
//                public void run() {
//                    gerenciamentoVagas.liberaVaga(vagaALiberar);
//                }
//            }, delay);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

}
