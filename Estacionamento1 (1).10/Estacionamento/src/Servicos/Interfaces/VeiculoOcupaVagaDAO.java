package Servicos.Interfaces;

import Modelos.VeiculoOcupaVaga;

import java.util.List;

public interface VeiculoOcupaVagaDAO {
    void addVeiculoOcupaVaga(VeiculoOcupaVaga veiculoOcupaVaga);
    VeiculoOcupaVaga getVeiculoOcupaVaga(String placa);
    List<VeiculoOcupaVaga> getAllVeiculoOcupaVagas();
    void updateVeiculoOcupaVaga(VeiculoOcupaVaga veiculoOcupaVaga);
    void deleteVeiculoOcupaVaga(String placa);
}
