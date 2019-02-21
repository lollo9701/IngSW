package social;

import java.io.Serializable;
import java.util.ArrayList;

public class Utente implements Serializable
{
	
	private String username;
	private String password;
	private String annoNascita;
	private String meseNascita;
	private String giornoNascita;
	private String sesso;
	private ArrayList <Categoria> copiaEventiPersonali =new ArrayList<>();  //per revoca iscrizione
	private ArrayList <Categoria> eventiPersonali= new ArrayList();
	protected DatiUtili dati=MainClass.getDati();
	
	public Utente()
	{
		
	}
	
	
	//creazione utente richiamando i metodi 
	public void creaUtente(String _nome,String passw, String anno,String mese,String giorno, String sex)
	{
		inserisciNome(_nome);
		inserisciPsw(passw);
		inserisciEtà(anno);
		inserisciSesso(sex);
		inserisciMese(mese);
		inserisciGiorno(giorno);
	
	}
	
	//PER TOGLIERE EVENTO DA LISTA EVENTI A CUI UTENTE è ISCRITTO
	public void revocaIscrizioneUtente(Categoria eventoDaRimuovere)
	{
		System.out.println("CONTROLLO UTENTEREV");
		for (int x=0 ; x<MainClass.getUtenteConnesso().getEventiPersonali().size(); x++)
		{
		    if(!MainClass.getUtenteConnesso().getEventiPersonali().get(x).equals(eventoDaRimuovere))
		    {
		    	copiaEventiPersonali.add(MainClass.getUtenteConnesso().getEventiPersonali().get(x));
			    	//dati.getListaEventi().get(k).getUtentiIscritti().remove(x);
			}	
		    System.out.println(MainClass.getUtenteConnesso().getEventiPersonali().get(x).getTitolo());
			
			//salvare cambiamenti   
		} 
		
			MainClass.getUtenteConnesso().getEventiPersonali().clear();
			System.out.println("seconda stampa ver");
			
			for (int x=0 ; x<copiaEventiPersonali.size(); x++)
			{
				System.out.println(copiaEventiPersonali.get(x).getTitolo());
				MainClass.getUtenteConnesso().getEventiPersonali().add(copiaEventiPersonali.get(x));
			}
			
			System.out.println("terza verifica");
			
			for (int x=0 ; x<MainClass.getUtenteConnesso().getEventiPersonali().size(); x++)
			{
				System.out.println(MainClass.getUtenteConnesso().getEventiPersonali().get(x).getTitolo());
			}	
			
			copiaEventiPersonali.clear();
	}
	
	//DISISCRIVE UNO A UNO SE EVENTO VIENE ELIMINATO
	public void revocaIscrizioneUtentePlus(Categoria eventoDaRimuovere)
	{
		System.out.println("CONTROLLO UTENTEPLUS");

		for(int i=0 ; i<dati.getListaUtenti().size() ; i++)  //scorre un utente per volta
		{	
		
			for (int x=0 ; x<dati.getListaUtenti().get(i).getEventiPersonali().size(); x++)
			{
				if(!dati.getListaUtenti().get(i).getEventiPersonali().get(x).equals(eventoDaRimuovere))
				{
					//temo il problema sia il riuso di copiaEvPers , perchè confonde gli eventi a cui gli utenti son iscritti
					copiaEventiPersonali.add(dati.getListaUtenti().get(i).getEventiPersonali().get(x));
			    	//dati.getListaEventi().get(k).getUtentiIscritti().remove(x);
				}	
				System.out.println(dati.getListaUtenti().get(i).getEventiPersonali().get(x).getTitolo());
			
			  
			} 
	     	
				dati.getListaUtenti().get(i).getEventiPersonali().clear();
				System.out.println("seconda stampa ver");
			
				for (int x=0 ; x<copiaEventiPersonali.size(); x++)
				{
					System.out.println(copiaEventiPersonali.get(x).getTitolo());
					dati.getListaUtenti().get(i).getEventiPersonali().add(copiaEventiPersonali.get(x));
				}
			
				System.out.println("terza verifica");
			
				for (int x=0 ; x<dati.getListaUtenti().get(i).getEventiPersonali().size(); x++)
				{
					System.out.println(dati.getListaUtenti().get(i).getEventiPersonali().get(x).getTitolo()+" "+i);
				}	
			
				copiaEventiPersonali.clear();
				
				System.out.println("***CAMBIO UTENTE***");
		}	
	}
	
	

	public String getMeseNascita() {
		return meseNascita;
	}


	public void setMeseNascita(String meseNascita) {
		this.meseNascita = meseNascita;
	}


	public String getGiornoNascita() {
		return giornoNascita;
	}


	public void setGiornoNascita(String giornoNascita) {
		this.giornoNascita = giornoNascita;
	}


	//iniz dati utente
	public void inserisciNome(String nome)
	{
		username=nome;
	}
	public void inserisciMese(String mese)
	{
		meseNascita=mese;
	}
	public void inserisciGiorno(String giorno)
	{
		giornoNascita=giorno;
	}
	
	public void inserisciPsw(String _psw)
	{
		password=_psw;
	}
	
	public void inserisciEtà(String _annoNascita)
	{
		annoNascita=_annoNascita;
	}
	
	public void inserisciSesso(String _sesso)
	{
		sesso=_sesso;
	}
	
	//setter e getter
	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username) 
	{
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getAnnoNascita() 
	{
		return annoNascita;
	}
	
	public void setAnnoNascita(String annoNascita) 
	{
		this.annoNascita = annoNascita;
	}

	public String getSesso() 
	{
		return sesso;
	}

	public void setSesso(String sesso)
	{
		this.sesso = sesso;
	}
	
	//lista eventi
	public ArrayList<Categoria> getEventiPersonali() {
		return eventiPersonali;
	}

	public void setEventiPersonali(ArrayList<Categoria> eventiPersonali) {
		this.eventiPersonali = eventiPersonali;
	}

	public ArrayList<Categoria> getCopiaEventiPersonali() {
		return copiaEventiPersonali;
	}


	public void setCopiaEventiPersonali(ArrayList<Categoria> copiaEventiPersonali) {
		this.copiaEventiPersonali = copiaEventiPersonali;
	}

	

}
