import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Cotacao {
    private String codEmpresa;
    private LocalDate data = LocalDate.now();
    private Double preco;
    private String moeda = "R$";

    public String getCodEmpresa() {
        return codEmpresa;
    }

    public Cotacao() {
        setCodEmpresa("");
        setPreco((double) 0);
    }

    public Cotacao(String codEmpresa, Double preco) {
        this.codEmpresa = codEmpresa;
        this.preco = preco;
    }

    public void setCodEmpresa(String codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getMoeda() {
        return moeda;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    @Override
    public String toString() {

        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Cotacao{" +
                "codEmpresa='" + codEmpresa + '\'' +
                ", data=" + formatter.format(data )+
                ", preco=" + preco +
                ", moeda='" + moeda + '\'' +
                '}';
    }
}
