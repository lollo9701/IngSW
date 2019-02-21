package social;

import java.io.Serializable;

/*
 * Classe calcio, eredita i parametri da categoria e aggiunge sesso e 
 * fascia d'et�
 */
public class Calcio extends Categoria {
	
	private final static String NOME="Calcio";
	String sesso;
	int et�_max;
	int et�_min;
	
	public Calcio ()
	{
		
	}
	
	public Calcio(String titolo,int numero_partecipanti,int anno_t,int mese_t,int giorno_t,String luogo,int anno_i,int  mese_i, 
			int giorno_i,int ora,int minuti,int durata,float quota,String extra,int anno_f,int mese_f, int giorno_f,int ora_conclusione, int minuti_conclusione,
			String note,String sesso, int et�_max, int et�_min)
	{
		super(titolo,numero_partecipanti,anno_t,mese_t,giorno_t,luogo,anno_i, mese_i, 
				giorno_i,ora, minuti,durata,quota,extra,anno_f,mese_f,giorno_f,ora_conclusione, minuti_conclusione,note );
		this.sesso=sesso;
		this.et�_max=et�_max;
		this.et�_min=et�_min;
	}
	//getter e setter
	
	//sesso
	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	//et� max
	public int getEt�_max() {
		return et�_max;
	}

	public void setEt�_max(int et�_max) {
		this.et�_max = et�_max;
	}

	//et� min
	public int getEt�_min() {
		return et�_min;
	}

	public void setEt�_min(int et�_min) {
		this.et�_min = et�_min;
	}

	public static String getNome() {
		return NOME;
	}
	
	
	
	
}
	

