import java.sql.ResultSet;
import java.sql.SQLException;

public class Carro {
    private Integer id;
    private String marca;
    private String cor;
    private String modelo;
    private Double preco;
    private Integer ano;

    public Carro(Integer id){
        this.id = id;
    }

    public Carro(Integer id, String marca, String cor, String modelo, Double preco, Integer ano) {
        this.id = id;
        this.marca = marca;
        this.cor = cor;
        this.modelo = modelo;
        this.preco = preco;
        this.ano = ano;
    }

    public Carro(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt("id");
        this.marca = resultSet.getString("marca");
        this.modelo = resultSet.getString("modelo");
        this.cor = resultSet.getString("cor");
        this.ano = resultSet.getInt("ano");
        this.preco = resultSet.getDouble("preco");
    }


    public Integer getId() {
        return id;
    }

    public Double getPreco() {
        return preco;
    }

    public Integer getAno() {
        return ano;
    }

    public String getCor() {
        return cor;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", cor='" + cor + '\'' +
                ", modelo='" + modelo + '\'' +
                ", preco=" + preco +
                ", ano=" + ano +
                '}';
    }
}
