import java.sql.ResultSet;
import java.sql.SQLException;

public class Usuario {

    private Integer id;
    private String nome;
    private String senha;
    private Integer idade;
    private Carro carro;


    public Usuario(Integer id, String nome, String senha, Integer idade) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.idade = idade;
    }

    public Usuario(Integer id, String nome, String senha, Integer idade, Carro carro) {
        this(id, nome, senha, idade);
        this.carro = carro;
    }

    public Usuario(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt("idusuarios");
        this.idade = resultSet.getInt("idade");
        this.nome = resultSet.getString("nome");
        this.senha = resultSet.getString("senha");
        int idCarro = resultSet.getInt("carro");
        if(idCarro != 0) {
            this.carro = new Carro(idCarro);
        }
    }

    public String getNome() {
        return nome;
    }

    public Integer getId() {
        return id;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getSenha() {
        return senha;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                ", idade=" + idade + ", " + this.carro +

                '}';
    }
}
