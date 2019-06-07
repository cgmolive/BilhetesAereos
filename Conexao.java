package AEP_JDBC;
import java.time.LocalDate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;


public class Conexao {
	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/aep2019",
					"postgres",
					"thiago_cassius");
			
			criarTabelaBilhetes(conn);
			
			excluirTodos(conn);
			
			gerarBilhete(conn, 5878, "Nova York", "Madagascar", LocalDate.now().plusDays(3));
			

			gerarBilhete(conn, 5657, "Destino", "Origem", LocalDate.now().plusDays(3));
		
			
			System.out.println("Conectado!");
			conn.close();
			System.out.println("Fechado.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Fim.");
	}

	// Para atualizar um Bilhete vamos excluir um bilhete e gerar um novo bilhete
	
	public static void gerarBilhete(Connection conexao, Integer numero, String origem, String destino, LocalDate data) throws Exception {
		String sql = "insert into bilhetes (numero, origem, destino, data) values (?,?,?,?)";
		
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, numero);
		statement.setString(2, "Lugar Qualquer");
		statement.setString(3, "Aonde tenha sol");
		statement.setDate(4, java.sql.Date.valueOf(LocalDate.now().plusDays(3)));

		
		statement.execute();
		statement.close();
	}
	

	// Como fazer uma exclus�o com parametros em JDBC
	public static void excluirBilhete(Connection conexao, Integer numero) throws Exception {
		String sql = "delete from bilhetes where numero = ?";
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, numero);
		statement.execute(sql);
		statement.close();		
	}
	
	public static void criarTabelaBilhetes(Connection conexao) throws Exception {
		String sql = "create table if not exists bilhetes ("
				+ "numero integer not null primary key,"
				+ "origem varchar(255) not null unique,"
				+ "destino varchar(255) not null unique,"
				+ "data date not null"
				+ ")";
		
		Statement statement = conexao.createStatement();
		statement.execute(sql);
		statement.close();		
	}
	
	public static void excluirTodos(Connection conexao)throws Exception {
		String sql = "delete from bilhetes";
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.execute();
		statement.close();
	}
}