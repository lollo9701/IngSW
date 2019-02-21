package social;

import java.io.Serializable;
import java.util.ArrayList;

/*
 * contiene i dati utili da salvare come gli utenti registrati e gli eventi creati
 */
public class DatiUtili implements Serializable
{
	
	private ArrayList <Utente> listaUtenti= new ArrayList();
	private ArrayList <Categoria> listaEventi= new ArrayList();
	
	
	
    //setter e getter
	
	//Lista utenti
	public  ArrayList<Utente> getListaUtenti() 
	{
		return listaUtenti;
	}
	public  void setListaUtenti(ArrayList<Utente> listaUtenti) 
	{
		listaUtenti = listaUtenti;
	}
	
	//lista Eventi
	public ArrayList<Categoria> getListaEventi() {
		return listaEventi;
	}
	public void setEventi(ArrayList<Categoria> eventi) {
		this.listaEventi = eventi;
	}
	
	
	

}
