package Modelos;

public class VeiculoOcupaVaga {
    private Veiculo veiculo;
    private Vagas vaga;
    private String horarioSaida; //ta errado

    private String idVaga;
    private String placa;

    public VeiculoOcupaVaga() {

    }

    public String getIdVaga() {
        return idVaga;
    }

    public void setIdVaga(String idVaga) {
        this.idVaga = idVaga;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    private String horarioEntrada;

    public VeiculoOcupaVaga(String idVaga, String placa, String horarioEntrada) {
        this.idVaga = idVaga;
        this.placa = placa;
        this.horarioEntrada = horarioEntrada;
    }

    public VeiculoOcupaVaga(Veiculo veiculo, Vagas vaga, String horarioEntrada) {
        this.veiculo = veiculo;
        this.vaga = vaga;
        this.horarioEntrada = horarioEntrada;
        this.horarioSaida = "";
    }

    public Veiculo getVeiculo() { return veiculo; }
    public void setVeiculo(Veiculo veiculo) { this.veiculo = veiculo; }
    public Vagas getVaga() { return vaga; }
    public void setVaga(Vagas vaga) { this.vaga = vaga; }
    public String getHorarioEntrada() { return horarioEntrada; }
    public void setHorarioEntrada(String horarioEntrada) { this.horarioEntrada = horarioEntrada; }
    public String getHorarioSaida() { return horarioSaida; }
    public void setHorarioSaida(String horarioSaida) { this.horarioSaida = horarioSaida; }

//    @Override
//    public String toString() {
//        return veiculo.toString() + "," + vaga.toString() + "," + horarioEntrada + "," + horarioSaida;
//    }

//    public static VeiculoOcupaVaga fromString(String str) {
//        String[] parts = str.split(",");
//        Veiculo veiculo = Veiculo.fromString(parts[0] + "," + parts[1] + "," + parts[2] + "," + parts[3]);
//        Vagas vaga = Vagas.fromString(parts[4] + "," + parts[5] + "," + parts[6] + "," + parts[7]);
//        return new VeiculoOcupaVaga(veiculo, vaga, parts[8]);
//    }

    public static VeiculoOcupaVaga fromString2(String str) {
        String[] parts = str.split(",");
        return new VeiculoOcupaVaga(parts[0], parts[1], parts[2]);
    }


}