package social;


import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;


import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

/*
 * Interfaccia grafica per un evento della categoria calcio
 */
public class EventCalcioGraphic extends EventGraphic{

	private JTextField txtInserisciSessoPartecipanti;
	private JTextField txtInserisciEtaMinima;
	private JTextField txtInserisciEtaMax;
	private ControlloInserimento control= new ControlloInserimento();
	


	/**
	 * Launch the application.
	 */
	//public static eventGraphic eventExt= new eventGraphic();
	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					eventCalcioGraphic window = new eventCalcioGraphic();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public EventCalcioGraphic() {
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
		
		txtInserisciSessoPartecipanti = new JTextField();
		txtInserisciSessoPartecipanti.setText("M - F");
		txtInserisciSessoPartecipanti.setBounds(750, 118, 40, 22);
		frame.getContentPane().add(txtInserisciSessoPartecipanti);
		txtInserisciSessoPartecipanti.setColumns(10);
		
		//Fascia d'età
		JLabel lblFascia = new JLabel("FASCIA D'ETA'");
		lblFascia.setBounds(600, 170, 100, 16);
		frame.getContentPane().add(lblFascia);
		
		txtInserisciEtaMinima = new JTextField();
		txtInserisciEtaMinima.setText("5");   //per evitare di risciriverlo sempre
		txtInserisciEtaMinima.setBounds(750, 170, 70, 22);
		frame.getContentPane().add(txtInserisciEtaMinima);
		txtInserisciEtaMinima.setColumns(10);
		
		txtInserisciEtaMax = new JTextField();
		txtInserisciEtaMax.setText("8");
		txtInserisciEtaMax.setBounds(850, 170, 70, 22);
		frame.getContentPane().add(txtInserisciEtaMax);
		txtInserisciEtaMax.setColumns(10);
		frame.getContentPane().setLayout(null);
		//rende visibile la finestra
		frame.setVisible(true);
				
				
		
	}
	public void creaEvent()
	{
		//CONTROLLO TEMPORANEO PERCHè UN METODO DISISCRIVE IN BASE A TITOLO EVENTO
		if(control.checkEvento(txtTitoloEvento.getText()))
		{	
		Calcio calcio = new Calcio(txtTitoloEvento.getText(),(Integer.parseInt(txtIn.getText())),Integer.parseInt(txtAnno.getText()),
				Integer.parseInt(txtMese.getText()),Integer.parseInt(txtGiorno.getText()),txtInserisciLuogo.getText(),Integer.parseInt(textField_1.getText()),
				Integer.parseInt(textField.getText()),Integer.parseInt(txtGiorno_1.getText()),Integer.parseInt(txtOra.getText()),Integer.parseInt(txtMinuti.getText()),
				Integer.parseInt(textField_2.getText()),Float.parseFloat(txtDenaro.getText()),txtInserisciRobaInclusa.getText(),Integer.parseInt(textField_5.getText()),
				Integer.parseInt(textField_4.getText()),Integer.parseInt(textField_3.getText()),Integer.parseInt(textField_6.getText()),Integer.parseInt(textField_7.getText()),
				txtInserisciNote.getText(),txtInserisciSessoPartecipanti.getText(),Integer.parseInt(txtInserisciEtaMax.getText()),Integer.parseInt(txtInserisciEtaMinima.getText()));
		
				MainClass.getDati().getListaEventi().add(calcio); //salva nuovo evento nell'elenco
				calcio.getUtentiIscritti().add(MainClass.getUtenteConnesso());  //chi crea evento viene in automatico iscritto
				MainClass.getUtenteConnesso().getEventiPersonali().add(calcio);
				try {
					Serializator.saveData(MainClass.getDati());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				PaginaPersonaleGraphic pag = new PaginaPersonaleGraphic();
				frame.setVisible(false);
	}
		else txtTitoloEvento.setText("Titolo già presente");	
		
	}
	
	
	
}
