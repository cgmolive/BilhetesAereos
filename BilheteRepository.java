package AEP;

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;


public class BilheteRepository {

	private Set<Bilhete> bilhetes = new HashSet<>();
	
	
	public void inserir(Bilhete bilhete) {
		this.bilhetes.add(bilhete);
	}
	List<Bilhete> obterTodos(){
		return Collections.unmodifiableList(new ArrayList<>(bilhetes));
	}
	void alterar(Bilhete bilhete) {
		this.excluir(bilhete.getVoo());
		this.inserir(bilhete);
	}
	void excluir(Integer numero) {
		Bilhete aRemover = null;
		for (Bilhete bilhete : this.bilhetes) {
			if (bilhete.getVoo() == numero) {
				aRemover = bilhete;
				break;
			}
		}
		if (aRemover != null) {
			this.bilhetes.remove(aRemover);
		}
	} 
}
