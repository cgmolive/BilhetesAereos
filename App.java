package AEP;
import java.time.LocalDate;
import java.sql.Connection;
import java.util.List;

public class App {
	
	
	
	public static void main(String[] args) {
		Bilhete bilheteDoThiago = new Bilhete(5686, "Nova York", "Madagascar");
		Bilhete bilheteDoCassius = new Bilhete(5687, "S�o Paulo", "California");
		
		Connection conn = null; //DriverManager.getConnection...

		//CorRepository repo = new CorRepositoryJDBC(conn); //usar a conex�o para persistir os dados.
		//CorRepository repo = new CorRepositoryMem�ria(); //manter  os dados em uma cole��o.
		BilheteRepository repo = null;
		
		repo.inserir(bilheteDoThiago);
		repo.inserir(bilheteDoCassius);
		
		List<Bilhete> bilhetes = repo.obterTodos();
		System.out.println("Listando todos os bilhetes...");
		// reescrever o toString

		for (Bilhete bilhete : bilhetes) {
			System.out.println("  " + bilhete);
		}
		System.out.println("Fim da listagem.");

		repo.excluir(bilheteDoThiago.getVoo());
		
	}

}
