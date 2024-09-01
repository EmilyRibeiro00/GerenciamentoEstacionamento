package Servicos;

public class GerenciamentoRelatorio {
    private GerenciamentoVagas gerenciamentoVagas ;
    private GerenciamentoClientes gerenciamentoClientes;
    private GerenciamentoVeiculos gerenciamentoVeiculos ;
    private GerenciamentoVeiculoOcupaVaga gerenciamentoVeiculoOcupaVaga;
    private GerenciamentoReservas gerenciamentoReservas;
    private GerenciamentoPagamento gerenciamentoPagamento ;

    public GerenciamentoRelatorio() {
        this.gerenciamentoVagas = new GerenciamentoVagas();
        this.gerenciamentoVeiculos = new GerenciamentoVeiculos();
        this.gerenciamentoClientes = new GerenciamentoClientes();
        this.gerenciamentoVeiculoOcupaVaga = new GerenciamentoVeiculoOcupaVaga();
        this.gerenciamentoReservas = new GerenciamentoReservas();
        this.gerenciamentoPagamento = new GerenciamentoPagamento();
    }



    public int qtdCarrosCadastrados() {
        return gerenciamentoVeiculos.getQuantidadeCarrosCadastrados();

    }
    public int qtdCarrosEstacionados() {
        return gerenciamentoVeiculoOcupaVaga.getCarrosEstacionados();
    }
    public int qtdClientesCadastrados() {
        return gerenciamentoClientes.qtdClientesCadastrados();
    }
    public int qtdVagasCadastradas() {
        return gerenciamentoVagas.qtdVagasCadastradas();
    }
    public int qtdVagasLivresTotal(){
        return gerenciamentoVagas.getNumVagasLivresTotal();
    }
    public int qtdVagasOcupadasTotal(){
        return gerenciamentoVagas.getNumVagasOcupadas();
    }
    public int qtdVagasReservadas(){
        return gerenciamentoVagas.getNumVagasReservadas();
    }
    public double caixaTotal(){
        return gerenciamentoPagamento.getCaixaTotal();
    }
    public String gerarRelatorio() {
        String relatorio = String.format(
                "\nRelatório do Estacionamento\n\n" +
                        "CARROS\n"+
                        "cadastrados: %d\n" +
                        "estacionados: %d\n\n" +
                        "VAGAS\n"+
                        "cadastradas: %d\n" +
                        "livres: %d\n" +
                        "ocupadas: %d\n" +
                        "reservadas: %d\n\n"+
                        "CLIENTES\n" +
                        "cadastrados: %d\n\n" +
                        "Valor em caixa: %.2f\n",
                qtdCarrosCadastrados(),
                qtdCarrosEstacionados(),
                qtdVagasCadastradas(),
                qtdVagasLivresTotal(),
                qtdVagasOcupadasTotal(),
                qtdVagasReservadas(),
                qtdClientesCadastrados(),

                caixaTotal());
        return relatorio;

    }
}
