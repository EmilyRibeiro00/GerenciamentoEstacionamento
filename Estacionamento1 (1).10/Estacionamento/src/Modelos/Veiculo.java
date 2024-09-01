package Modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Veiculo {
    protected String placa;
    public Veiculo(String placa) {
        this.placa = placa;
    }
    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

//   @Override
//    public String toString() {
//       return placa + ",";
//    }

    public static Veiculo fromString(String str) {
        String[] parts = str.split(",");
        switch (parts[0]) {
            case "Carro":
                return new Carro(parts[1], parts[2], parts[3], parts[4]);
            case "Caminhao":
                return new Caminhao(parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
            case "Moto":
                return new Moto(parts[1], parts[2], Integer.parseInt(parts[3]));
            default:
                throw new IllegalArgumentException("Tipo de veículo desconhecido: " + parts[0]);
        }
    }
}
