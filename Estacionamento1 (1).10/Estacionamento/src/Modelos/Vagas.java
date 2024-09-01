package Modelos;

public class Vagas {
    private String idVaga;
    private String local;
    private String status;
    private String tipoVeiculo;


    public Vagas(String idVaga, String local, String status, String tipoVeiculo) {
        this.idVaga = idVaga;
        this.local = local;
        this.status = status;
        this.tipoVeiculo = tipoVeiculo;
    }
    public Vagas( String local, String status, String tipoVeiculo) {
        this.local = local;
        this.status = status;
        this.tipoVeiculo = tipoVeiculo;
    }

    public String getNumero() {
        return idVaga;
    }

    public void setNumero(String numero) {
        this.idVaga = numero;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    @Override
   public String toString() {
        return idVaga + "," + local + "," + status + "," + tipoVeiculo;
    }

    public static Vagas fromString(String str) {
        String[] parts = str.split(",");
        return new Vagas(parts[0], parts[1], parts[2], parts[3]);
    }
}
