package social;

import java.io.IOException;
import java.io.Serializable;

public class MainClass implements Serializable

{
	private static DatiUtili dati = new DatiUtili();
	
	public static void main(String[] args) 
	{
		caricamento();
		BachecaEventi bac = new BachecaEventi();
		//EventCalcioGraphic calcio= new EventCalcioGraphic();
		//RegistraGraphic reg= new RegistraGraphic();
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
				System.out.println("creazione nuovo salvataggio");
			}
			
	}
	public static DatiUtili getDati() {
		return dati;
	}
	public static void setDati(DatiUtili dati) {
		MainClass.dati = dati;
	}
	
}
