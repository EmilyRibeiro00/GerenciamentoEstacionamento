package Servicos;
import Modelos.Veiculo;
import Servicos.Interfaces.VeiculosDAO;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DAOVeiculosImp implements VeiculosDAO {
    private final String filePath = "veiculos.txt";

    @Override
    public boolean addVeiculo(Veiculo veiculo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(veiculo.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Veiculo getVeiculo(String placa) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Veiculo veiculo = Veiculo.fromString(line);
                if (veiculo.getPlaca().equals(placa)) {
                    return veiculo;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Veiculo> getAllVeiculos() {
        List<Veiculo> veiculos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                veiculos.add(Veiculo.fromString(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return veiculos;
    }

    @Override
    public void updateVeiculo(Veiculo veiculo) {
        List<Veiculo> veiculos = getAllVeiculos();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Veiculo v : veiculos) {
                if (v.getPlaca().equals(veiculo.getPlaca())) {
                    writer.write(veiculo.toString());
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
    public void deleteVeiculo(String placa) {
        List<Veiculo> veiculos = getAllVeiculos();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Veiculo v : veiculos) {
                if (!v.getPlaca().equals(placa)) {
                    writer.write(v.toString());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}