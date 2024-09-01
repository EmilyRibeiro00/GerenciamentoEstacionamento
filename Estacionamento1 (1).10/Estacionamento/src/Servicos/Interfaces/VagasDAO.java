package Servicos.Interfaces;
import Modelos.Vagas;
import java.util.List;

public interface VagasDAO {

        boolean addVaga(Vagas vaga);
        Vagas getVaga(String numero);
        List<Vagas> getAllVagas();
        void updateVaga(Vagas vaga);
        void deleteVaga(String numero);

}
