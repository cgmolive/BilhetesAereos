package AEP;

import java.time.LocalDate;

public class Bilhete {

	Integer voo;
	String origem;
	String destino;
	LocalDate data;
	public Bilhete(Integer voo, String origem, String destino) {
		setVoo(voo);
		setOrigem(origem);
		setDestino(destino);
		data = DataDoBilhete.agendarVoo();
	}
	
	
	
	
	public Integer getVoo() {
		return voo;
	}
	public void setVoo(Integer voo) {
		this.voo = voo;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public LocalDate getData() {
		return data;
	}

	
	
}
