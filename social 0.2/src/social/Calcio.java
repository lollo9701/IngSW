package social;

public class Calcio extends Categoria {
	
	String sesso;
	int et�_max;
	int et�_min;
	
	public Calcio ()
	{
		
	}
	
	public Calcio(String sesso, int et�_max, int et�_min)
	{
		super();
		this.sesso=sesso;
		this.et�_max=et�_max;
		this.et�_min=et�_min;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public int getEt�_max() {
		return et�_max;
	}

	public void setEt�_max(int et�_max) {
		this.et�_max = et�_max;
	}

	public int getEt�_min() {
		return et�_min;
	}

	public void setEt�_min(int et�_min) {
		this.et�_min = et�_min;
	}
	
	
	
}
	

