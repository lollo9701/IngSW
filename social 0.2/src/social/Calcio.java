package social;

public class Calcio extends Categoria {
	
	String sesso;
	int età_max;
	int età_min;
	
	public Calcio ()
	{
		
	}
	
	public Calcio(String sesso, int età_max, int età_min)
	{
		super();
		this.sesso=sesso;
		this.età_max=età_max;
		this.età_min=età_min;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public int getEtà_max() {
		return età_max;
	}

	public void setEtà_max(int età_max) {
		this.età_max = età_max;
	}

	public int getEtà_min() {
		return età_min;
	}

	public void setEtà_min(int età_min) {
		this.età_min = età_min;
	}
	
	
	
}
	

