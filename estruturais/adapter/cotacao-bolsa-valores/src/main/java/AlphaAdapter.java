import io.github.mainstringargs.alphavantagescraper.AlphaVantageConnector;
import io.github.mainstringargs.alphavantagescraper.StockQuotes;
import io.github.mainstringargs.alphavantagescraper.output.AlphaVantageException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AlphaAdapter implements ServicoCotacao{
    @Override
    public Cotacao getCotacao(String codEmpresa) {
        System.out.printf("Cotação da Empresa %s obtida pelo serviço Alpha Vantage: http://www.alphavantage.co%n", codEmpresa);

        /*
        Verifica se existe uma variável de ambiente para a chave da API do serviço Alpha Vantage.
        Você pode se cadastrar e obter uma chave em http://www.alphavantage.co
        */
        final String s = System.getenv("ALPHAVANTAGE_APIKEY");
        final String apiKey = s == null ? "50M3AP1K3Y" : s;
        final int timeout = 3000;
        var apiConnector = new AlphaVantageConnector(apiKey, timeout);

        //Permite obter a cotação (quotes) de ações (stocks).
        var stockQuotes = new StockQuotes(apiConnector);
        var cotacao = new Cotacao();
        try {
            var response = stockQuotes.quote(codEmpresa);
            var stock = response.getStockQuote();
            var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            System.out.printf("Data: %s Preço: %s%n", formatter.format(stock.getLatestTradingDay()), stock.getPrice());

            cotacao.setCodEmpresa(codEmpresa);
            cotacao.setPreco(stock.getPrice());
            cotacao.setData(stock.getLatestTradingDay());


        } catch (AlphaVantageException e) {
            System.out.println("Erro ao solicitar cotação da empresa " + codEmpresa + ": " + e.getMessage());
        }
        System.out.println("---------------------------------------------------------------------");


        return cotacao;
    }
}
