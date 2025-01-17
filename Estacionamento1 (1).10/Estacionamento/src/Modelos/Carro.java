package Modelos;

import java.time.LocalDateTime;

public class Carro extends Veiculo {
    private String cor;
    private String marca;
    private String modelo;

    public Carro(String placa,String cor, String marca, String modelo) {
        super(placa);
        this.cor = cor;
        this.marca = marca;
        this.modelo = modelo;
    }


    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    @Override
   public String toString() {
       return "Carro," + getPlaca() + "," + cor + "," + marca + "," + modelo;
   }
}