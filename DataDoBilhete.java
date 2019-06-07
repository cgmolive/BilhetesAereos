package AEP;
import java.util.Date;
import java.time.LocalDate;

public class DataDoBilhete {
	
	public DataDoBilhete() {
		
	}
	
	public static LocalDate agendarVoo() {
		LocalDate dataDoVoo = LocalDate.now().plusDays(3);
		
		return dataDoVoo;
	}
	
}
