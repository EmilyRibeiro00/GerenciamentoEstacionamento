package Modelos;

import java.time.LocalDateTime;

public class Caminhao extends Veiculo {
    private int cargaMaxima;
    private int comprimento;

    public Caminhao(String placa, int cargaMaxima, int comprimento) {
        super(placa);
        this.cargaMaxima = cargaMaxima;
        this.comprimento = comprimento;
    }


    public int getCargaMaxima() { return cargaMaxima; }
    public void setCargaMaxima(int cargaMaxima) { this.cargaMaxima = cargaMaxima; }
    public int getComprimento() { return comprimento; }
    public void setComprimento(int comprimento) { this.comprimento = comprimento; }

    @Override
    public String toString() {
        return "Caminhao," + getPlaca() + "," + cargaMaxima + "," + comprimento;
    }
}
