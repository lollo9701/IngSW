package social;

import java.io.IOException;

public class MainClass 
{
	private static DatiUtili dati = new DatiUtili();
	
	
	public static void main(String[] args) 
	{
		caricamento();
		RegistraGraphic reg= new RegistraGraphic();
		reg.main(args);
	}
	
	public static void caricamento()
	{
			if(Serializator.getSalvataggio().exists()) 
			{
				try
				{
					dati = Serializator.readSavedData(Serializator.getFilename());
				}catch (ClassNotFoundException | IOException e) 
				{
					e.printStackTrace();
				}
				
			}
			else 
			{
				dati = new DatiUtili();
			}
			
	}
	public static DatiUtili getDati() {
		return dati;
	}
	public static void setDati(DatiUtili dati) {
		MainClass.dati = dati;
	}
	
}
