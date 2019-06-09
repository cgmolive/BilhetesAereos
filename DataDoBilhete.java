package AEP;
import java.util.Date;
import java.time.LocalDate;

public class DataDoBilhete {
	
	//Acho que não é assim
	public DataDoBilhete() {
		LocalDate dataDoVoo = agendarVoo();
	}
	
	public static LocalDate agendarVoo() {
		LocalDate dataDoVoo = LocalDate.now().plusDays(3);
		
		return dataDoVoo;
	}
	
}
