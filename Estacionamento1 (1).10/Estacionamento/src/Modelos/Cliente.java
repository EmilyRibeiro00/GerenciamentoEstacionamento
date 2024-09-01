package Modelos;

import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String telefone;


    private String email;
    private ArrayList<String> veiculos = new ArrayList<String>();

    public Cliente(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<String> getVeiculos() {
        return veiculos;
    }
    public void adicionarVeiculo(String placa){
       if (!veiculos.contains(placa)) {
           this.veiculos.add(placa);
       }
    }
    public void setVeiculos(ArrayList<String> veiculos) {
        this.veiculos = veiculos;
    }

    public void removerVeiculo(String placa) {
        this.veiculos.remove(placa);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nome).append(",").append(telefone).append(",").append(email).append(",");
        for (String veiculo : veiculos) {
            sb.append(veiculo).append(",");
        }
        return sb.toString();
    }

    public static Cliente fromString(String str) {
        String[] parts = str.split(",");
        int partsLen = parts.length;
        Cliente cliente = new Cliente(parts[0], parts[1], parts[2]);
        if (partsLen> 3) {
            int x = 3;
            while(x < partsLen) {
                String veiculoPlaca = parts[x];
                cliente.adicionarVeiculo(veiculoPlaca);
                x++;
            }
        }
        return cliente;
    }

}
