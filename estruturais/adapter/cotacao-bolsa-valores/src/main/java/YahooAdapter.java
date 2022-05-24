import io.github.mainstringargs.yahooFinance.YahooFinanceModules;
import io.github.mainstringargs.yahooFinance.YahooFinanceRequest;
import io.github.mainstringargs.yahooFinance.YahooFinanceUrlBuilder;

public class YahooAdapter implements  ServicoCotacao{

    @Override
    public Cotacao getCotacao(String codEmpresa) {

        /**
         * Acessa a cotação de uma determinada empresa utilizando o serviço do <a href="https://finance.yahoo.com">Yahoo Finance</a>
         * por meio da biblioteca <a href="https://github.com/mainstringargs/yahoo-finance-scraper">Yahoo Finance Scrapper</a>.
         * @param codigoEmpresa
         * @see <a href="http://meumobi.github.io/stocks%20apis/2016/03/13/get-realtime-stock-quotes-yahoo-finance-api.html">Get realtime stock quotes yahoo finance API</a>
         */

            System.out.printf("Cotação da Empresa %s obtida pelo serviço Yahoo Finance: https://finance.yahoo.com%n", codEmpresa);
            var builder =
                    new YahooFinanceUrlBuilder().modules(YahooFinanceModules.values()).symbol(codEmpresa);

            //YahooFinanceRequest request = new YahooFinanceRequest();
            var request = new YahooFinanceRequest();
            var financeData = request.getFinanceData(request.invoke(builder));

            var financials = financeData.getFinancialData();

        if (financials == null) {
            return new Cotacao();
        }

        System.out.printf("Preço: %s %s%n", financials.getFinancialCurrency(), financials.getCurrentPrice().getRaw());
            var cotacao = new Cotacao(codEmpresa, financials.getCurrentPrice().getRaw().doubleValue());
            cotacao.setMoeda(financials.getFinancialCurrency());
            
        System.out.println("---------------------------------------------------------------------");

            return cotacao;



    }
}
