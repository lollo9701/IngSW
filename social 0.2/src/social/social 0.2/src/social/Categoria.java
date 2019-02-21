package social;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

/*
 * Categoria, superclasse di ogni diverso tipo di evento creato nel programma.
 * Contiene i poarametri base di ogni categoria.
 */
public class Categoria implements Serializable
{
	private ArrayList <Utente> copiaEventi =new ArrayList<>();           //array utili a rimozione iscrizioni
 	protected ArrayList <Utente> utentiIscritti = new ArrayList<>();
	protected String titolo ;
	protected int numero_partecipanti ;
	protected int anno_t, mese_t, giorno_t;
	protected String luogo;
	protected int anno_i, mese_i, giorno_i;
	protected int ora, minuti;
	protected int durata;
	protected float quota;
	protected String extra;
	protected int anno_f, mese_f, giorno_f;
	protected int ora_conclusione, minuti_conclusione;
	protected String note;
	protected DatiUtili dati= MainClass.getDati();
	protected ArrayList <Categoria> copiaListaEventi =new ArrayList<>();//per eliminare evento dalla bacheca 

	

	protected final String CONST="Nome categoria: %s \nTitolo: %s \nNumero partecipanti: %d \nTermine iscrizione: %d-%d-%d \nLuogo: %s\n"
			+ "Data inizio: %d-%d-%d\nOra inizio: %d:%d\nDurata: %d\nQuota:%f\nCompreso nella quota: %s\nData fine evento: %d-%d-%d\n"
			+ "Ora conclusione evento: %d:%d\nNote: %s";
	
	
	public Categoria(String tit, int num_par, int anno, int mese, int giorno, String _luogo, int annoi, int mesei, int giornoi, int ore, int min,
			int _durata, float _quota, String _extra, int annof, int mesef, int giornof, int orafin, int minfin, String _note)
	{
		titolo=tit;
		numero_partecipanti=num_par;
		anno_t=anno;
		mese_t=mese;
		giorno_t=giorno;
		luogo=_luogo;
		anno_i=annoi;
		mese_i=mesei;
		giorno_i=giornoi;
		ora=ore;
		minuti=min;
		durata=_durata;
		quota=_quota;
		extra=_extra;
		anno_f=annof;
		mese_f=mesef;
		giorno_f=giornof;
		ora_conclusione=orafin;
		minuti_conclusione=minfin;
		note=_note;
		
		
	}
	
	// costruttore
	public Categoria()
	{
		  
	}
	
	//metodo toString
/*	public String toString() 
	{
		return String.format(CONST,titolo,numero_partecipanti,anno_t,mese_t,giorno_t,luogo,anno_i, mese_i, 
				giorno_i,ora, minuti,durata,quota,extra,anno_f,mese_f,giorno_f,ora_conclusione, minuti_conclusione,note );
	}
	*/
	//METODO PER REVOCA ISCRIZIONE DALLA LISTA ISCRITTI ALL'EVENTO  bisogna far si che se si disiscrive creatore evento,evento si elimina
/*	public void revocaIscrizione(int k)
	{
		
		for (int x=0 ; x<dati.getListaEventi().get(k).getUtentiIscritti().size(); x++)
		{
		    if(!MainClass.getUtenteConnesso().getUsername().equals(dati.getListaEventi().get(k).getUtentiIscritti().get(x).getUsername()))
		    {
		    	copiaEventi.add(dati.getListaEventi().get(k).getUtentiIscritti().get(x));
			    	//dati.getListaEventi().get(k).getUtentiIscritti().remove(x);
			}	
		    System.out.println(dati.getListaEventi().get(k).getUtentiIscritti().get(x).getUsername());
			
			//salvare cambiamenti   
		} 
		
			dati.getListaEventi().get(k).getUtentiIscritti().clear();
			System.out.println("seconda stampa ver");
			
			for (int x=0 ; x<copiaEventi.size(); x++)
			{
				System.out.println(copiaEventi.get(x).getUsername());
				dati.getListaEventi().get(k).getUtentiIscritti().add(copiaEventi.get(x));
			}
			
			System.out.println("terza verifica");
			
			for (int x=0 ; x<dati.getListaEventi().get(k).getUtentiIscritti().size(); x++)
			{
				System.out.println(dati.getListaEventi().get(k).getUtentiIscritti().get(x).getUsername());
			}	
			
			copiaEventi.clear();
	}*/
	
	public void revocaIscrizioneCat(String titoloPassato)  //così tramite nome evento risale al suo indice nell'elenco degli eventi
	{
		int k=0;
		for(int i=0; i<dati.getListaEventi().size(); i++)
        {
			if(dati.getListaEventi().get(i).getTitolo().equals(titoloPassato))
			{
				 k=i;
				 System.out.println("****\n" + k + "\n******\n");
				 System.out.println("controllo REVCATEGORIA");
			}
        }
		
		for (int x=0 ; x<dati.getListaEventi().get(k).getUtentiIscritti().size(); x++)
		{
		    if(!MainClass.getUtenteConnesso().getUsername().equals(dati.getListaEventi().get(k).getUtentiIscritti().get(x).getUsername()))
		    {
		    	copiaEventi.add(dati.getListaEventi().get(k).getUtentiIscritti().get(x));
			    	//dati.getListaEventi().get(k).getUtentiIscritti().remove(x);
			}	
		    System.out.println(dati.getListaEventi().get(k).getUtentiIscritti().get(x).getUsername());
			
			//salvare cambiamenti   
		} 
		
			dati.getListaEventi().get(k).getUtentiIscritti().clear();
			System.out.println("seconda stampa ver");
			
			for (int x=0 ; x<copiaEventi.size(); x++)
			{
				System.out.println(copiaEventi.get(x).getUsername());
				dati.getListaEventi().get(k).getUtentiIscritti().add(copiaEventi.get(x));
			}
			
			System.out.println("terza verifica");
			
			for (int x=0 ; x<dati.getListaEventi().get(k).getUtentiIscritti().size(); x++)
			{
				System.out.println(dati.getListaEventi().get(k).getUtentiIscritti().get(x).getUsername());
			}	
			
			System.out.println("Fine controllo lista\n");
			copiaEventi.clear();
		}	
				
	
	//CONTROLLARE DEVE DIS-ALTRI UTENTI DAI LORO PERSONALI E POI CANCELLARE L'EVENTO		
	public void revocaIscrizionePlus(String titoloPassato,Categoria eventoDaRimuovere)  //così tramite nome evento risale al suo indice nell'elenco degli eventi
	{
		//richiama metodo in classe utente che disiscrive tutti gli utenti dall'evento(dalla lista personale)
		MainClass.getUtenteConnesso().revocaIscrizioneUtentePlus(eventoDaRimuovere);
		
		int k=0;
		for(int i=0; i<dati.getListaEventi().size(); i++)
        {
			if(dati.getListaEventi().get(i).getTitolo().equals(titoloPassato))
			{
				 k=i;
				 System.out.println("****\n" + k + "\n******\n");
				 System.out.println("controllo REVCATPLUS");
			}
        }
		
	if(MainClass.getUtenteConnesso().getUsername().equals(dati.getListaEventi().get(k).getUtentiIscritti().get(0).getUsername()))
		{
			
		
			
			for (int x=0 ; x<dati.getListaEventi().size(); x++)
			{
			    if(!dati.getListaEventi().get(x).getTitolo().equals(titoloPassato))
			    {
			    	copiaListaEventi.add(dati.getListaEventi().get(x));
				    	//dati.getListaEventi().get(k).getUtentiIscritti().remove(x);
				}	
			    System.out.println(dati.getListaEventi().get(x).getTitolo());
				
				//salvare cambiamenti   
			} 
			
				dati.getListaEventi().clear();
				System.out.println("seconda stampa ver");
				
				for (int x=0 ; x<copiaListaEventi.size(); x++)
				{
					System.out.println(copiaListaEventi.get(x).getTitolo());
					dati.getListaEventi().add(copiaListaEventi.get(x));
				}
				
					System.out.println("terza verifica");
				
				for (int x=0 ; x<dati.getListaEventi().size(); x++)
				{
					System.out.println(dati.getListaEventi().get(x).getTitolo());
				}	
				
					System.out.println("Fine controllo lista\n");
					copiaListaEventi.clear();
			
		}
		
		
	}
	
	

	//getter e setter

	//titolo
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	//numero partecipanti
	public int getNumero_partecipanti() {
		return numero_partecipanti;
	}

	public void setNumero_partecipanti(int numero_partecipanti) {
		this.numero_partecipanti = numero_partecipanti;
	}

	//anno, mese e giorno termine iscrizione
	public int getAnno_t() {
		return anno_t;
	}

	public void setAnno_t(int anno_t) {
		this.anno_t = anno_t;
	}

	public int getMese_t() {
		return mese_t;
	}

	public void setMese_t(int mese_t) {
		this.mese_t = mese_t;
	}

	public int getGiorno_t() {
		return giorno_t;
	}

	public void setGiorno_t(int giorno_t) {
		this.giorno_t = giorno_t;
	}

	//luogo
	public String getLuogo() {
		return luogo;
	}

	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}

	//anno mese e giorno inizio evento
	public int getAnno_i() {
		return anno_i;
	}

	public void setAnno_i(int anno_i) {
		this.anno_i = anno_i;
	}

	public int getMese_i() {
		return mese_i;
	}

	public void setMese_i(int mese_i) {
		this.mese_i = mese_i;
	}

	public int getGiorno_i() {
		return giorno_i;
	}

	public void setGiorno_i(int giorno_i) {
		this.giorno_i = giorno_i;
	}

	//ora e minuti inizio evento
	public int getOra() {
		return ora;
	}

	public void setOra(int ora) {
		this.ora = ora;
	}

	public int getMinuti() {
		return minuti;
	}

	public void setMinuti(int minuti) {
		this.minuti = minuti;
	}

	//durata evento
	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}

	//quota
	public float getQuota() {
		return quota;
	}

	public void setQuota(float quota) {
		this.quota = quota;
	}

	//compreso nella quota
	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	//anno, mese e giorno fine evento
	public int getAnno_f() {
		return anno_f;
	}

	public void setAnno_f(int anno_f) {
		this.anno_f = anno_f;
	}

	public int getMese_f() {
		return mese_f;
	}

	public void setMese_f(int mese_f) {
		this.mese_f = mese_f;
	}

	public int getGiorno_f() {
		return giorno_f;
	}

	public void setGiorno_f(int giorno_f) {
		this.giorno_f = giorno_f;
	}

	public int getOra_conclusione() {
		return ora_conclusione;
	}

	
	//ora e minuti fine evento
	public void setOra_conclusione(int ora_conclusione) {
		this.ora_conclusione = ora_conclusione;
	}

	public int getMinuti_conclusione() {
		return minuti_conclusione;
	}

	public void setMinuti_conclusione(int minuti_conclusione) {
		this.minuti_conclusione = minuti_conclusione;
	}
	
	//note
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	
	public ArrayList<Utente> getUtentiIscritti() {
		return utentiIscritti;
	}

	public void setUtentiIscritti(ArrayList<Utente> utentiIscritti) {
		this.utentiIscritti = utentiIscritti;
	}
	
}

