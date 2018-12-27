package social;

import java.util.ArrayList;

//contiene tutte le categorie create nel programma
public class Categorie {
	
	private ArrayList <Categoria> elencoCategorie;
	private Categoria categoria = new Categoria();
	private int i=0;
	
	//costruttore
	public Categorie()
	{
		elencoCategorie =new ArrayList();
	}

	/**
	 * permette di aggiungere una categoria all'arraylist
	 * @param _categoria
	 * @param _nomeCat
	 */
	public void addCategorie(Categoria _categoria,String _nomeCat)
	{
		elencoCategorie.add(_categoria);
		elencoCategorie.get(i).setNome_cat(_nomeCat);
		i++;
	
	}
	
	/**
	 * restituisce una descrizione di ogni categoria presente nell'arraylist
	 */
	public void categorieToString()
	{
		int x=elencoCategorie.size();
		while(x>0)
		{
			x--;	
			System.out.println(elencoCategorie.get(x).getNome_cat());	
		}
	}

	//getter e setter
	public ArrayList<Categoria> getElencoCategorie()
	{
		return elencoCategorie;
	}
	public void setElencoCategorie(ArrayList<Categoria> elencoCategorie)
	{
		this.elencoCategorie = elencoCategorie;
	}
	public Categoria getCategoria()
	{
		return categoria;
	}
	public void setCategoria(Categoria categoria)
	{
		this.categoria = categoria;
	}
	
	
}
