package Servicos;
import Modelos.*;

public class GerenciamentoVeiculos {

    private DAOVeiculosImp veiculosDAO;
    private GerenciamentoVeiculoOcupaVaga veiculoOcupaVaga;

    //Construtor

    public GerenciamentoVeiculos() {
        this.veiculosDAO = new DAOVeiculosImp();
        this.veiculoOcupaVaga = new GerenciamentoVeiculoOcupaVaga();
    }

    public int getQuantidadeCarrosCadastrados(){
        return veiculosDAO.getAllVeiculos().size();
    }

    //Carro
    public boolean cadastrarVeiculo(String placa,String cor, String marca, String modelo){
        Veiculo carro = new Carro(placa, cor, marca, modelo);
         veiculosDAO.addVeiculo(carro);
         //estaciona:
         return veiculoOcupaVaga.estacionaVeiculo(carro);
    }
    //Caminhao
    public boolean cadastrarVeiculo(String placa, int cargaMaxima, int comprimento){
        Veiculo caminhao = new Caminhao(placa, cargaMaxima,comprimento);
        veiculosDAO.addVeiculo(caminhao);
        //estaciona:
        return veiculoOcupaVaga.estacionaVeiculo(caminhao);

    }
    //Moto
    public boolean cadastrarVeiculo(String placa, String marca, int cilindradas){
        Veiculo moto = new Moto(placa, marca, cilindradas);
        veiculosDAO.addVeiculo(moto);
        //estaciona:
        return veiculoOcupaVaga.estacionaVeiculo(moto);

    }

    public VeiculoOcupaVaga excluirVeiculo(String placa){
        return veiculoOcupaVaga.veiculoSeRetira(placa);
    }

}
