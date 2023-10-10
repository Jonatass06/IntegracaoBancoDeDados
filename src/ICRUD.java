import java.util.Set;

public interface ICRUD <T, ID>{

    void inserir(T obj) throws InvalidIndex;
    T buscarUm(ID id);
    Set<T> buscarTodos();
    void atualizar(T obj);
    void deletar (ID id);
}
