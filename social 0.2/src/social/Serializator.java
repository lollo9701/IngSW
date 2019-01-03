package social;

import java.io.*;
import java.util.ArrayList;

import it.unibs.fp.mylib.ServizioFile;

//classe per salvare i dati degli utenti

public class Serializator
{
	private final static String filename="database.bin";
	private static File salvataggio=new File(filename);  //controllare per problema che o nella registrazione o nel login da errore, per esistenza o no file

/** Classe di utilità per la serializzazione e deserializzazione 
 * 
 *
 */

	/** Serializza un oggetto scrivendo su un file dato per nome
	 * 
	 * @param filename Il nome del file su cui scrivere
	 * @param L'oggetto da serializzare
	 * @throws IOException In caso qualcosa vada storto
	 */
	public static void saveData(DatiUtili dati) throws IOException {
		if(salvataggio.exists())
		{
		OutputStream stream = new FileOutputStream(filename);
		ObjectOutputStream objStream = new ObjectOutputStream(stream);
		
		objStream.writeObject(dati);
		objStream.flush();  //forza scrittura 
		objStream.close();
		}
		else
		{
			OutputStream stream = new FileOutputStream(filename);
			ObjectOutputStream objStream = new ObjectOutputStream(stream);
			
			objStream.writeObject(dati);
			objStream.flush();  //forza scrittura 
			objStream.close();
			}
	}
	
	/** Deserializza precedentemente salvato nel file specificato dal nome passato
	 * 
	 * @param filename Il nome del file da cui leggere l'oggetto
	 * @return L'oggetto precedentemente salvato nel file specificato
	 * @throws IOException In caso qualcosa vada storto
	 * @throws ClassNotFoundException In caso qualcosa vada storto pt.2
	 */
	public static DatiUtili readSavedData(String filename) throws IOException, ClassNotFoundException {
		DatiUtili output = null;
		if(salvataggio.exists()) {
		InputStream stream = new FileInputStream(filename);
		ObjectInputStream objStream = new ObjectInputStream(stream);
		output = (DatiUtili) objStream.readObject();
		objStream.close();
		}
		return output;
	}

	//setter e getter di salv
	public static File getSalvataggio() {
		return salvataggio;
	}

	public static void setSalvataggio(File salvataggio) {
		Serializator.salvataggio = salvataggio;
	}

	public static String getFilename() {
		return filename;
	}
	
	
	
	
}

	
			
