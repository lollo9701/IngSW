package social;

import java.io.IOException;
import java.io.Serializable;

public class MainClass implements Serializable

{
	private static DatiUtili dati = new DatiUtili();
	private static Utente utenteConnesso = null;
	
	
	public static void main(String[] args) 
	{
		caricamento();
		
		//BachecaEventi bac = new BachecaEventi();
		//EventCalcioGraphic calcio= new EventCalcioGraphic();
		RegistraGraphic reg= new RegistraGraphic();
		//PaginaEventoGraphic ev= new PaginaEventoGraphic();
		
	/*	for(int i=0; i<dati.getListaEventi().size() ;i++)
		{
			for (int x=0 ; x<dati.getListaEventi().get(i).getUtentiIscritti().size(); x++)
			{
			System.out.println(dati.getListaEventi().get(i).getUtentiIscritti().get(x).getUsername()+"evento"+i);
			
		}
		}  */
	    
		
	}
	public static void caricamento()
	{
				if(Serializator.getSalvataggio().exists()) 
			{
				try {
					dati = Serializator.readSavedData(Serializator.getFilename());
				} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();
				}
				
			}
			else 
			{
				System.out.println("Creazione nuovo salvataggio");
			}
			
	}
	
	//SETTER E GETTER
	public static DatiUtili getDati() {
		return dati;
	}
	public static void setDati(DatiUtili dati) {
		MainClass.dati = dati;
	}
	
	public static Utente getUtenteConnesso() {
		return utenteConnesso;
	}
	public static void setUtenteConnesso(Utente utenteConnesso) {
		MainClass.utenteConnesso = utenteConnesso;
	}
	
}
