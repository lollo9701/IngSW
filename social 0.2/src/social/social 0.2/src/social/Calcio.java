package social;

import java.io.Serializable;

/*
 * Classe calcio, eredita i parametri da categoria e aggiunge sesso e 
 * fascia d'età
 */
public class Calcio extends Categoria {
	
	private final static String NOME="Calcio";
	String sesso;
	int età_max;
	int età_min;
	
	public Calcio ()
	{
		
	}
	
	public Calcio(String titolo,int numero_partecipanti,int anno_t,int mese_t,int giorno_t,String luogo,int anno_i,int  mese_i, 
			int giorno_i,int ora,int minuti,int durata,float quota,String extra,int anno_f,int mese_f, int giorno_f,int ora_conclusione, int minuti_conclusione,
			String note,String sesso, int età_max, int età_min)
	{
		super(titolo,numero_partecipanti,anno_t,mese_t,giorno_t,luogo,anno_i, mese_i, 
				giorno_i,ora, minuti,durata,quota,extra,anno_f,mese_f,giorno_f,ora_conclusione, minuti_conclusione,note );
		this.sesso=sesso;
		this.età_max=età_max;
		this.età_min=età_min;
	}
	//getter e setter
	
	//sesso
	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	//età max
	public int getEtà_max() {
		return età_max;
	}

	public void setEtà_max(int età_max) {
		this.età_max = età_max;
	}

	//età min
	public int getEtà_min() {
		return età_min;
	}

	public void setEtà_min(int età_min) {
		this.età_min = età_min;
	}

	public static String getNome() {
		return NOME;
	}
	
	
	
	
}
	

