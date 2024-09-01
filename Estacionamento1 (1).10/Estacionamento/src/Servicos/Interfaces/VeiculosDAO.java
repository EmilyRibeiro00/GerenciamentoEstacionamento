package Servicos.Interfaces;
import Modelos.Veiculo;
import java.util.List;

public interface VeiculosDAO {
    boolean addVeiculo(Veiculo veiculo);
    Veiculo getVeiculo(String placa);
    List<Veiculo> getAllVeiculos();
    void updateVeiculo(Veiculo veiculo);
    void deleteVeiculo(String placa);
}
