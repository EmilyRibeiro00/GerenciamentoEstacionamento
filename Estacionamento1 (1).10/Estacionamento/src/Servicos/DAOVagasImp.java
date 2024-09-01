package Servicos;

import Modelos.Vagas;
import Servicos.Interfaces.VagasDAO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DAOVagasImp implements VagasDAO {
    private final String filePath = "vagas.txt";

    @Override
    public boolean addVaga(Vagas vaga) {
        int idAtual = gerarIDAtual();
        vaga.setNumero(String.valueOf(idAtual));
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(vaga.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Vagas getVaga(String numero) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Vagas vaga = Vagas.fromString(line);
                if (vaga.getNumero().equals(numero)) {
                    return vaga;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Vagas> getAllVagas() {
        List<Vagas> vagas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                vagas.add(Vagas.fromString(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vagas;
    }

    @Override
    public void updateVaga(Vagas vaga) {
        List<Vagas> vagas = getAllVagas();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Vagas v : vagas) {
                if (v.getNumero().equals(vaga.getNumero())) {
                    writer.write(vaga.toString());
                } else {
                    writer.write(v.toString());
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteVaga(String idVaga) {
        List<Vagas> vagas = getAllVagas();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Vagas v : vagas) {
                if (!v.getNumero().equals(idVaga)) {
                    writer.write(v.toString());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int gerarIDAtual() {
        List<Vagas> vagas = getAllVagas();
        return vagas.size() + 1;
    }

    public int getNumeroVagasLivres(String tipoVeiculo) {
        int contador = 0;
        List<Vagas> todasVagas = getAllVagas();
        for (Vagas vaga : todasVagas) {
            String tipo = vaga.getTipoVeiculo();
            String status = vaga.getStatus();
            if (tipo.equalsIgnoreCase(tipoVeiculo) && status.equalsIgnoreCase("Livre")) {
                contador++;
            }
        }
        return contador;
    }

    public int getNumeroVagasLivresTotal(){
        int contador = 0;
        List<Vagas> todasVagas = getAllVagas();
        for (Vagas vaga : todasVagas) {
            String status = vaga.getStatus();
            if ( status.equalsIgnoreCase("Livre")) {
                contador++;
            }
        }
        return contador;
    }

    public int getNumeroVagasOcupadas() {
        int contador = 0;
        List<Vagas> todasVagas = getAllVagas();
        for (Vagas vaga : todasVagas) {
            String status = vaga.getStatus();
            if (status.equalsIgnoreCase("Ocupada")) {
                contador++;
            }
        }
        return contador;
    }

    public int getNumeroVagasReservadas() {
        int contador = 0;
        List<Vagas> todasVagas = getAllVagas();
        for (Vagas vaga : todasVagas) {
            String status = vaga.getStatus();
            if (status.equalsIgnoreCase("Reservada")) {
                contador++;
            }
        }
        return contador;
    }

    public Vagas getVagaLivre(String tipoVeiculo) {
        for (Vagas vaga : getAllVagas()) {
            if (vaga.getTipoVeiculo().equalsIgnoreCase(tipoVeiculo) && vaga.getStatus().equalsIgnoreCase("Livre")) {
                return vaga;
            }
        }
        return null;
    }

    public void updateStatusVaga(String numero, String novoStatus) {
        List<Vagas> vagas = getAllVagas();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Vagas v : vagas) {
                if (v.getNumero().equals(numero)) {
                    v.setStatus(novoStatus);
                }
                writer.write(v.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getTipoVeiculo(String idVaga){
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Vagas vaga = Vagas.fromString(line);
                if (vaga.getNumero().equals(idVaga)) {
                    return vaga.getTipoVeiculo();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Vagas getVagaLivreMoto() {
        return getVagaLivre("Moto");
    }

    public Vagas getVagaLivreCaminhao() {
        return getVagaLivre("Caminhão");
    }

    public Vagas getVagaLivreCarro() {
        return getVagaLivre("Carro");
    }
}
