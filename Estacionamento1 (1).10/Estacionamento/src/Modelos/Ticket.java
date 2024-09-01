package Modelos;

public class Ticket {
    String idVaga;
    String placaCarro;
    String horarioEntrada;
    String horarioSaida;
    String tempoDePermanencia;
    String valorAPagar;

    public Ticket(String idVaga, String placaCarro, String horarioEntrada, String horarioSaida, String tempoDePermanencia, String valorAPagar) {
        this.idVaga = idVaga;
        this.placaCarro = placaCarro;
        this.horarioEntrada = horarioEntrada;
        this.horarioSaida = horarioSaida;
        this.tempoDePermanencia = tempoDePermanencia;
        this.valorAPagar = valorAPagar;
    }

    public Ticket() {

    }

    public String getIdVaga() {
        return idVaga;
    }

    public void setIdVaga(String idVaga) {
        this.idVaga = idVaga;
    }

    public String getPlacaCarro() {
        return placaCarro;
    }

    public void setPlacaCarro(String placaCarro) {
        this.placaCarro = placaCarro;
    }

    public String getHorarioEntrada() {
        return horarioEntrada;
    }

    public void setHorarioEntrada(String horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    public String getHorarioSaida() {
        return horarioSaida;
    }

    public void setHorarioSaida(String horarioSaida) {
        this.horarioSaida = horarioSaida;
    }

    public String getTempoDePermanencia() {
        return tempoDePermanencia;
    }

    public void setTempoDePermanencia(String tempoDePermanencia) {
        this.tempoDePermanencia = tempoDePermanencia;
    }

    public String getValorAPagar() {
        return valorAPagar;
    }

    public void setValorAPagar(String valorAPagar) {
        this.valorAPagar = valorAPagar;
    }
}
