package Servicos;

import Modelos.VeiculoOcupaVaga;
import Servicos.Interfaces.VeiculoOcupaVagaDAO;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DAOVeiculoOcupaVagaImp implements VeiculoOcupaVagaDAO {
    private final String filePath = "carros_ocupando_vagas.txt";

    @Override
    public void addVeiculoOcupaVaga(VeiculoOcupaVaga veiculoOcupaVaga) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(veiculoOcupaVaga.getVaga().getNumero().toString());
            writer.write(",");
            writer.write(veiculoOcupaVaga.getVeiculo().getPlaca().toString());
            writer.write(",");
            writer.write(veiculoOcupaVaga.getHorarioEntrada().toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public VeiculoOcupaVaga getVeiculoOcupaVaga(String placa) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {

//                VeiculoOcupaVaga veiculoOcupaVaga = VeiculoOcupaVaga.fromString(line);

                VeiculoOcupaVaga veiculoOcupaVaga = VeiculoOcupaVaga.fromString2(line);


                if (veiculoOcupaVaga.getPlaca().equals(placa)) {
                    return veiculoOcupaVaga;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<VeiculoOcupaVaga> getAllVeiculoOcupaVagas() {
        List<VeiculoOcupaVaga> carrosOcupaVagas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                carrosOcupaVagas.add(VeiculoOcupaVaga.fromString2(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return carrosOcupaVagas;
    }

    @Override
    public void updateVeiculoOcupaVaga(VeiculoOcupaVaga veiculoOcupaVaga) {
        List<VeiculoOcupaVaga> carrosOcupaVagas = getAllVeiculoOcupaVagas();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (VeiculoOcupaVaga c : carrosOcupaVagas) {
                if (c.getVeiculo().getPlaca().equals(veiculoOcupaVaga.getVeiculo().getPlaca())) {
                    writer.write(veiculoOcupaVaga.toString());
                } else {
                    writer.write(c.toString());
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteVeiculoOcupaVaga(String placa) {

        List<String> linhas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                // Verificar se a placa na linha corresponde à placa fornecida
                String[] partes = linha.split(",");
                if (!partes[1].equals(placa)) {
                    linhas.add(linha);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Escrever de volta para o arquivo apenas as linhas que não correspondem à placa fornecida
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String linha : linhas) {
                writer.write(linha);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
