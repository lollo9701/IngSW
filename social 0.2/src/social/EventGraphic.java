package social;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class EventGraphic {

	protected JFrame frame;
	protected JTextField txtTitoloEvento;
	protected JTextField txtIn;
	protected JTextField txtGiorno;
	protected JTextField txtMese;
	protected JTextField txtAnno;
	protected JLabel lblLuogo;
	protected JTextField txtInserisciLuogo;
	protected JLabel lblDataInizioEvento;
	protected JTextField txtGiorno_1;
	protected JTextField textField;
	protected JTextField textField_1;
	protected JLabel lblOrarioInizioEvento;
	protected JTextField txtOra;
	protected JTextField txtMinuti;
	protected JLabel lblDurata;
	protected JTextField textField_2;
	protected JLabel lblQuota;
	protected JTextField txtDenaro;
	protected JLabel lblInclusiNellaQuota;
	protected JTextField txtInserisciRobaInclusa;
	protected JLabel lblDataFineEvento;
	protected JTextField textField_3;
	protected JTextField textField_4;
	protected JTextField textField_5;
	protected JLabel lblOrarioFineEvento;
	protected JTextField textField_6;
	protected JTextField textField_7;
	protected JLabel lblNote;
	protected JTextField txtInserisciNote;
	protected JLabel lblCategorie;
	protected JLabel lblNomeCategoria;
	protected JButton btnNewButton;
//	public static Categoria categoria = new Categoria();

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					eventGraphic window = new eventGraphic();
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
	public EventGraphic() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	protected void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1014, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtTitoloEvento = new JTextField();
		txtTitoloEvento.setText("INSERISCI TITOLO EVENTO");
		txtTitoloEvento.setBounds(277, 118, 165, 22);
		frame.getContentPane().add(txtTitoloEvento);
		txtTitoloEvento.setColumns(10);
		
		JLabel lblTitoloEvento = new JLabel("TITOLO EVENTO:");
		lblTitoloEvento.setBounds(63, 121, 123, 16);
		frame.getContentPane().add(lblTitoloEvento);
		
		JLabel lblNumeroPartecipanti = new JLabel("NUMERO PARTECIPANTI");
		lblNumeroPartecipanti.setBounds(63, 173, 145, 16);
		frame.getContentPane().add(lblNumeroPartecipanti);
		
		txtIn = new JTextField();
		txtIn.setText("10");
		txtIn.setBounds(277, 170, 195, 22);
		frame.getContentPane().add(txtIn);
		txtIn.setColumns(10);
		
		JLabel lblDataTermineIscrizione = new JLabel("DATA TERMINE ISCRIZIONE");
		lblDataTermineIscrizione.setBounds(63, 220, 171, 16);
		frame.getContentPane().add(lblDataTermineIscrizione);
		
		txtGiorno = new JTextField();
		txtGiorno.setText("1");
		txtGiorno.setBounds(277, 217, 59, 22);
		frame.getContentPane().add(txtGiorno);
		txtGiorno.setColumns(10);
		
		txtMese = new JTextField();
		txtMese.setText("2");
		txtMese.setBounds(361, 217, 59, 22);
		frame.getContentPane().add(txtMese);
		txtMese.setColumns(10);
		
		txtAnno = new JTextField();
		txtAnno.setText("3");
		txtAnno.setBounds(445, 217, 59, 22);
		frame.getContentPane().add(txtAnno);
		txtAnno.setColumns(10);
		
		lblLuogo = new JLabel("LUOGO");
		lblLuogo.setBounds(63, 271, 56, 16);
		frame.getContentPane().add(lblLuogo);
		
		txtInserisciLuogo = new JTextField();
		txtInserisciLuogo.setText("INSERISCI LUOGO");
		txtInserisciLuogo.setBounds(277, 268, 116, 22);
		frame.getContentPane().add(txtInserisciLuogo);
		txtInserisciLuogo.setColumns(10);
		
		lblDataInizioEvento = new JLabel("DATA INIZIO EVENTO");
		lblDataInizioEvento.setBounds(63, 320, 145, 16);
		frame.getContentPane().add(lblDataInizioEvento);
		
		txtGiorno_1 = new JTextField();
		txtGiorno_1.setText("3");
		txtGiorno_1.setBounds(277, 317, 59, 22);
		frame.getContentPane().add(txtGiorno_1);
		txtGiorno_1.setColumns(10);
		
		textField = new JTextField();
		textField.setText("4");
		textField.setColumns(10);
		textField.setBounds(361, 317, 59, 22);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setText("5");
		textField_1.setColumns(10);
		textField_1.setBounds(445, 317, 59, 22);
		frame.getContentPane().add(textField_1);
		
		lblOrarioInizioEvento = new JLabel("ORARIO INIZIO EVENTO");
		lblOrarioInizioEvento.setBounds(63, 374, 145, 16);
		frame.getContentPane().add(lblOrarioInizioEvento);
		
		txtOra = new JTextField();
		txtOra.setText("2");
		txtOra.setColumns(10);
		txtOra.setBounds(277, 371, 59, 22);
		frame.getContentPane().add(txtOra);
		
		txtMinuti = new JTextField();
		txtMinuti.setText("1");
		txtMinuti.setColumns(10);
		txtMinuti.setBounds(361, 371, 59, 22);
		frame.getContentPane().add(txtMinuti);
		
		lblDurata = new JLabel("DURATA");
		lblDurata.setBounds(63, 439, 145, 16);
		frame.getContentPane().add(lblDurata);
		
		textField_2 = new JTextField();
		textField_2.setText("2");
		textField_2.setColumns(10);
		textField_2.setBounds(277, 436, 59, 22);
		frame.getContentPane().add(textField_2);
		
		lblQuota = new JLabel("QUOTA");
		lblQuota.setBounds(63, 497, 145, 16);
		frame.getContentPane().add(lblQuota);
		
		txtDenaro = new JTextField();
		txtDenaro.setText("30");
		txtDenaro.setColumns(10);
		txtDenaro.setBounds(277, 494, 59, 22);
		frame.getContentPane().add(txtDenaro);
		
		lblInclusiNellaQuota = new JLabel("INCLUSI NELLA QUOTA");
		lblInclusiNellaQuota.setBounds(63, 547, 145, 16);
		frame.getContentPane().add(lblInclusiNellaQuota);
		
		txtInserisciRobaInclusa = new JTextField();
		txtInserisciRobaInclusa.setText("INSERISCI INCLUSI NELLA QUOTA");
		txtInserisciRobaInclusa.setColumns(10);
		txtInserisciRobaInclusa.setBounds(277, 544, 302, 22);
		frame.getContentPane().add(txtInserisciRobaInclusa);
		
		lblDataFineEvento = new JLabel("DATA FINE EVENTO");
		lblDataFineEvento.setBounds(63, 595, 145, 16);
		frame.getContentPane().add(lblDataFineEvento);
		
		textField_3 = new JTextField();
		textField_3.setText("4");
		textField_3.setColumns(10);
		textField_3.setBounds(277, 592, 59, 22);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setText("5");
		textField_4.setColumns(10);
		textField_4.setBounds(361, 592, 59, 22);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setText("6");
		textField_5.setColumns(10);
		textField_5.setBounds(445, 592, 59, 22);
		frame.getContentPane().add(textField_5);
		
		lblOrarioFineEvento = new JLabel("ORARIO FINE EVENTO");
		lblOrarioFineEvento.setBounds(63, 637, 145, 16);
		frame.getContentPane().add(lblOrarioFineEvento);
		
		textField_6 = new JTextField();
		textField_6.setText("2");
		textField_6.setColumns(10);
		textField_6.setBounds(277, 634, 59, 22);
		frame.getContentPane().add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setText("3");
		textField_7.setColumns(10);
		textField_7.setBounds(361, 634, 59, 22);
		frame.getContentPane().add(textField_7);
		
		lblNote = new JLabel("NOTE");
		lblNote.setBounds(63, 676, 145, 16);
		frame.getContentPane().add(lblNote);
		
		txtInserisciNote = new JTextField();
		txtInserisciNote.setText("INSERISCI NOTE");
		txtInserisciNote.setColumns(10);
		txtInserisciNote.setBounds(277, 669, 302, 22);
		frame.getContentPane().add(txtInserisciNote);
		
		lblCategorie = new JLabel("CATEGORIA");
		lblCategorie.setBounds(257, 26, 116, 31);
		frame.getContentPane().add(lblCategorie);
		
		/*lblNomeCategoria = new JLabel("NOME CATEGORIA");
		lblNomeCategoria.setBounds(432, 33, 116, 16);
		frame.getContentPane().add(lblNomeCategoria);*/
		
		//BOTTONE COLLEGATO AL METODO CHE CREA EVENTO DI TIPO GENERICO
		btnNewButton = new JButton("Crea");
		btnNewButton.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e)
		{
			creaEvent();
		}
		});
		btnNewButton.setBounds(780, 569, 137, 47);
		frame.getContentPane().add(btnNewButton);
		
	}
	public void creaEvent()
	{
				Categoria categoria= new Categoria(txtTitoloEvento.getText(),(Integer.parseInt(txtIn.getText())),Integer.parseInt(txtAnno.getText()),Integer.parseInt(txtMese.getText()),
				Integer.parseInt(txtGiorno.getText()),txtInserisciLuogo.getText(),Integer.parseInt(textField_1.getText()),Integer.parseInt(textField.getText()),
				Integer.parseInt(txtGiorno_1.getText()),Integer.parseInt(txtOra.getText()),Integer.parseInt(txtMinuti.getText()),Integer.parseInt(textField_2.getText()),
				Float.parseFloat(txtDenaro.getText()),txtInserisciRobaInclusa.getText(),Integer.parseInt(textField_5.getText()),Integer.parseInt(textField_4.getText()),
				Integer.parseInt(textField_3.getText()),Integer.parseInt(textField_6.getText()),Integer.parseInt(textField_7.getText()),txtInserisciNote.getText());
				System.out.println("fumo");
				
	}
	

}
