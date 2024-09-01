package Servicos;
import Modelos.Vagas;
import Modelos.Veiculo;
import Modelos.VeiculoOcupaVaga;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class GerenciamentoVeiculoOcupaVaga {
    private DAOVeiculoOcupaVagaImp veiculoOcupaVagaDAO;
    private GerenciamentoVagas gerenciamentoVagas;
    private VeiculoOcupaVaga veiculoOcupaVaga;


    public GerenciamentoVeiculoOcupaVaga(){
        this.veiculoOcupaVagaDAO = new DAOVeiculoOcupaVagaImp();
        this.gerenciamentoVagas = new GerenciamentoVagas();
        this.veiculoOcupaVaga = new VeiculoOcupaVaga();

    }



    public boolean estacionaVeiculo(Veiculo veiculo){
        String tipoDeVeiculo = veiculo.getClass().getSimpleName();
        int vagasLivres = gerenciamentoVagas.getNumVagasLivres(tipoDeVeiculo) ;
            if(vagasLivres > 0) {
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String horarioEntrada = now.format(formatter);
                Vagas vagaLivre = gerenciamentoVagas.getVagaLivre(tipoDeVeiculo);
                veiculoOcupaVaga = new VeiculoOcupaVaga(veiculo, vagaLivre, horarioEntrada);
                veiculoOcupaVagaDAO.addVeiculoOcupaVaga(veiculoOcupaVaga);
                return true;
            }
            return false;
    }

    public VeiculoOcupaVaga veiculoSeRetira(String placa){
        //aqui temos que atualizar a vaga para que o status seja livre
        //Gravamos no objeto veiculoOcupaVAga o horário de saida
        VeiculoOcupaVaga veiculoASair = veiculoOcupaVagaDAO.getVeiculoOcupaVaga(placa);
        if(veiculoASair!=null) {

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String horarioDeSaida = now.format(formatter);

            veiculoASair.setHorarioSaida(horarioDeSaida);

            Vagas vagaALiberar = gerenciamentoVagas.getVaga(veiculoASair.getIdVaga());


            gerenciamentoVagas.liberaVaga(vagaALiberar); // libera vaga

            veiculoOcupaVagaDAO.deleteVeiculoOcupaVaga(placa); //deleta ele dos veiculos que estão ocupando vagas no momento

            return veiculoASair; //retorna o veículo que saiu
        }
        return null;//não achou o veiculo
    }

    public int calculaTempoPercorrido(VeiculoOcupaVaga exitVeiculo) {
        String entrada = exitVeiculo.getHorarioEntrada();
        String saida = exitVeiculo.getHorarioSaida();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        LocalTime horarioEntrada = LocalTime.parse(entrada, formatter);
        LocalTime horarioSaida = LocalTime.parse(saida, formatter);

        Duration duration = Duration.between(horarioEntrada, horarioSaida);

        long horas = duration.toHours();

        return (int) horas;
    }
    public int getCarrosEstacionados() {
        return veiculoOcupaVagaDAO.getAllVeiculoOcupaVagas().size();
    }

}
