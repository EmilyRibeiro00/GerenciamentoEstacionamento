package Servicos;

import Modelos.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class GerenciamentoVagas {
    private Vagas vaga;
    private DAOVagasImp vagasDAO;

    public GerenciamentoVagas() {
        this.vagasDAO = new DAOVagasImp();
    }


    public boolean cadastrarVaga(String local, String status, String tipoVeiculo) {
        vaga = new Vagas(local, status, tipoVeiculo);
        vagasDAO.addVaga(vaga);
        return true;
    }
    public boolean vagaExiste(String idVaga){
        Vagas vaga = vagasDAO.getVaga(idVaga);
        if(vaga!=null){
            return true;
        }
        return false;
    }

    public String getStatusVaga(String idVaga){
        Vagas vaga = getVaga(idVaga);
        return vaga.getStatus();
    }

    public void liberaVaga(Vagas vagaALiberar) {
        vagaALiberar.setStatus("Livre");
        vagasDAO.updateVaga(vagaALiberar);
    }
    public void liberaVaga(String idVaga){
        Vagas vagaALiberar = getVaga(idVaga);
        vagaALiberar.setStatus("Livre");
        vagasDAO.updateVaga(vagaALiberar);
    }
    public String reservarVaga(String tipoVeiculo,String horarioReservado){
        if(isAfter(horarioReservado)){
            return null;
        }else {
            Vagas vagaLivre = vagasDAO.getVagaLivre(tipoVeiculo);
            if (vagaLivre != null) {
                String idVaga = vagaLivre.getNumero();
                vagasDAO.updateStatusVaga(idVaga, "Reservada");
                return idVaga;
            }
        }
        return null;
    }
    public static boolean isAfter(String horarioEspecificoStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        try {
            // Converter a string do horário específico para LocalTime
            LocalTime horarioEspecifico = LocalTime.parse(horarioEspecificoStr, formatter);
            // Obter o horário atual
            LocalTime horarioAtual = LocalTime.now();
            // Verificar se o horário atual é posterior ao horário específico
            boolean stat = horarioAtual.isAfter(horarioEspecifico);
            return stat;

        } catch (DateTimeParseException e) {
            // Tratar exceção se a string não puder ser analisada
            System.out.println("Formato de horário inválido: " + e.getMessage());
            return false;
        }
    }
    public Vagas getVagaLivre(String tipoVeiculo) {
        Vagas vagaLivre = vagasDAO.getVagaLivre(tipoVeiculo);
        String idVaga = vagaLivre.getNumero();
        vagasDAO.updateStatusVaga(idVaga, "Ocupada");
        if(vagaLivre!=null) {
            return vagasDAO.getVaga(idVaga);//Retorna vaga livre, porém com status já alterado para Ocupada
        }
        return null;
    }
    public int qtdVagasCadastradas() {
        return vagasDAO.getAllVagas().size();
    }
    public int getNumVagasLivres(String tipoVeiculo) {
        return vagasDAO.getNumeroVagasLivres(tipoVeiculo);
    }
    public int getNumVagasLivresTotal(){
        return vagasDAO.getNumeroVagasLivresTotal();
    }
    public int getNumVagasOcupadas() {
        return vagasDAO.getNumeroVagasOcupadas();
    }
    public int getNumVagasReservadas() {
        return vagasDAO.getNumeroVagasReservadas();
    }
    public void excluirVaga(String idVaga) {
        vagasDAO.deleteVaga(idVaga);
    }
    public void atualizarVaga(String idVaga, String local, String status, String tipoVeiculo) {
        vaga = new Vagas(idVaga, local, status, tipoVeiculo);
        vagasDAO.updateVaga(vaga);
    }
    public String getTipoVeiculo(String idVaga) {
        return vagasDAO.getTipoVeiculo(idVaga);
    }
    public Vagas getVaga(String idVaga) {
        return vagasDAO.getVaga(idVaga);
    }
}