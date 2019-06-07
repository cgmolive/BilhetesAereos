package AEP;

import java.util.List;

public interface BilheteRepository {
	void inserir(Bilhete bilhete);
	List<Bilhete> obterTodos();
	void alterar(Bilhete bilhete);
	void excluir(Integer numero);
}