import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public abstract class DAOPadrao<T, ID> implements ICRUD<T, ID> {

    private Connection connection;
    private String comandoSql;
    private String tabela;

    public DAOPadrao(Connection connection, String tabela) {
        this.connection = connection;
        this.tabela = tabela;
    }

    public Connection getConnection() {
        return connection;
    }

    public String getComandoSql() {
        return comandoSql;
    }

    public void setComandoSql(String comandoSql) {
        this.comandoSql = comandoSql;
    }

    @Override
    public Set<T> buscarTodos() {
        this.comandoSql = "Select * from " + tabela;
        Set<T> set = new HashSet<>();
        try (PreparedStatement s = connection.prepareStatement(this.comandoSql)){
            ResultSet results = s.executeQuery();
            while (results.next()) {
                set.add(converter(results));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return set;
    }

    public abstract T converter(ResultSet resultSet) throws SQLException;
}
