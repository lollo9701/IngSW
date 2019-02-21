package social;

import java.util.GregorianCalendar;

//CLASSE IN CUI SON RACCOLTI I METODI PER CONTROLLARE I DATI INSERITI DAGLI UTENTI

public class ControlloInserimento 
{
	
	private GregorianCalendar calendar = new GregorianCalendar();
	
	//CONTROLLO PER VEDERE SE DATO INSERITO SIA DI TIPO NUMERICO
	
	public static boolean isNumeric(String str)  
	{  
		  try  
		  {  
		    double d = Double.parseDouble(str);  
		  }  
		  catch(NumberFormatException nfe)  
		  {  
		    return false;  
		  }  
		  return true;  
		}
	
	//CONTROLLO PER VEDERE SE DATA INSERITA SIA VALIDA
	public boolean data(String day,String month,String year) 
	{
		boolean ok = false;
		int giorno=Integer.parseInt(day);  //dati relativi alla data di nascita dell'utente
		int mese=Integer.parseInt(month);
		int anno=Integer.parseInt(year);
		int [] numeroGiorniPerMese = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		if(anno< calendar.get(calendar.YEAR)&& mese<=12 && giorno<=numeroGiorniPerMese[mese-1]) 
		{ 
			ok= true;
		}
		
		if(anno==calendar.get(calendar.YEAR) && mese <(calendar.get(calendar.MONTH)+1)
		   && giorno<=numeroGiorniPerMese[mese-1])
		{
			ok=true;
		}
		if(anno==calendar.get(calendar.YEAR) && mese==(calendar.get(calendar.MONTH)+1)&& 
		   giorno<=calendar.get(calendar.DAY_OF_MONTH))
		{
			ok=true;
		}
		
		return ok;
		
	}
	
	//CONTROLLO AL FINE DI IMPEDIRE A UN NUOVO UTENTE DI REGISTRARSI CON UN NOME GIA' PRESENTE
	public boolean checkUtente(String _nome) 
	{                                                         
		boolean check=true;
		
		for(int i=0; i<=(MainClass.getDati().getListaUtenti().size()-1) ; i++)
		{
			
			if(_nome.equals(MainClass.getDati().getListaUtenti().get(i).getUsername()))
			{
				check=false;
			}
		}
		return check;
	}
	
	//IMPEDISCE CI SIAN 2 EVENTI CON LO STESSO TITOLO
	public boolean checkEvento(String _nome) 
	{                                                         
		boolean check=true;
		
		for(int i=0; i<=(MainClass.getDati().getListaEventi().size()-1) ; i++)
		{
			
			if(_nome.equals(MainClass.getDati().getListaEventi().get(i).getTitolo()))
			{
				check=false;
			}
		}
		return check;
	}
}
