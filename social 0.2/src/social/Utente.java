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
	
	private ArrayList <Categoria> eventiPersonali= new ArrayList();
	
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

	

}
