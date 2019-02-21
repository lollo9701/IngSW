package social;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BachecaCalcio extends BachecaEventi {
	
	//classe da controllare perchè non eredita i componenti della bachecaEventi
     
	DatiUtili dati = null;
   

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BachecaCalcio window = new BachecaCalcio();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BachecaCalcio() {
		dati=MainClass.getDati();
		initialize();
		aggiungiParametri();
	}

	/**
	 * Initialize the contents of the frame.
	 */
protected void aggiungiParametri() {
		
		//Nome categoria
		JLabel lblNomeCat = new JLabel(Calcio.getNome());
		lblNomeCat.setBounds(400, 26, 300, 31);
		frame.getContentPane().add(lblNomeCat);
		
		
		
		//Sesso
		JLabel lblNewLabel = new JLabel("SESSO");
		lblNewLabel.setBounds(600, 118, 56, 16);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		//Fascia d'età
		JLabel lblFascia = new JLabel("FASCIA D'ETA'");
		lblFascia.setBounds(600, 170, 100, 16);
		frame.getContentPane().add(lblFascia);
		
		
		
		
		frame.getContentPane().setLayout(null);
		//rende visibile la finestra
		frame.setVisible(true);
	}
	

}
