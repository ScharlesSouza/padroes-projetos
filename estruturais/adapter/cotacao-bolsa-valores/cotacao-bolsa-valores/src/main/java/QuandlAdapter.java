import com.jimmoores.quandl.DataSetRequest;
import com.jimmoores.quandl.classic.ClassicQuandlSession;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class QuandlAdapter implements ServicoCotacao{
    @Override
    public Cotacao getCotacao(String codEmpresa) {

        System.out.printf("Cotação da Empresa %s obtida pelo serviço Quandl: http://quandl.com/%n", codEmpresa);
        var session = ClassicQuandlSession.create();
        var request = DataSetRequest.Builder
                .of(codEmpresa)
                .withMaxRows(1)
                .build();
        var result = session.getDataSet(request);
        var cotacao = new Cotacao();
        if(result.size() > 0) {
            var row = result.get(0);
            var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String date = formatter.format(row.getLocalDate("Date"));
            System.out.printf("Data: %s Preço: %s%n", date, row.getDouble("Close"));

            cotacao.setCodEmpresa(codEmpresa);
            cotacao.setPreco(row.getDouble("Close"));
            cotacao.setData(row.getLocalDate("Date"));

            //System.out.println(result.toPrettyPrintedString());
        }
        System.out.println("---------------------------------------------------------------------");
        return cotacao;
    }
}
