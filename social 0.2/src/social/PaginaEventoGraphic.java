package social;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/*
 * Classe per visualizzare una evento
 */

public class PaginaEventoGraphic {

	protected JFrame frame;
	protected JLabel lblLuogo;
	protected JLabel lblDataInizioEvento;
	protected JLabel lblOrarioInizioEvento;
	protected JLabel lblDurata;
	protected JLabel lblQuota;
	protected JLabel lblInclusiNellaQuota;
	protected JLabel lblDataFineEvento;
	protected JLabel lblOrarioFineEvento;
	protected JLabel lblNote;
	protected JLabel lblCategorie;
	protected JLabel lblNomeCategoria;
//	public static Categoria categoria = new Categoria();

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaginaEventoGraphic window = new PaginaEventoGraphic();
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
	public PaginaEventoGraphic() {
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
		
		
		JLabel lblTitoloEvento = new JLabel("TITOLO EVENTO:");
		lblTitoloEvento.setBounds(63, 121, 123, 16);
		frame.getContentPane().add(lblTitoloEvento);
		
		JLabel lblNumeroPartecipanti = new JLabel("NUMERO PARTECIPANTI");
		lblNumeroPartecipanti.setBounds(63, 173, 145, 16);
		frame.getContentPane().add(lblNumeroPartecipanti);
		
		JLabel lblDataTermineIscrizione = new JLabel("DATA TERMINE ISCRIZIONE");
		lblDataTermineIscrizione.setBounds(63, 220, 171, 16);
		frame.getContentPane().add(lblDataTermineIscrizione);
		
		lblLuogo = new JLabel("LUOGO");
		lblLuogo.setBounds(63, 271, 56, 16);
		frame.getContentPane().add(lblLuogo);
		
		lblDataInizioEvento = new JLabel("DATA INIZIO EVENTO");
		lblDataInizioEvento.setBounds(63, 320, 145, 16);
		frame.getContentPane().add(lblDataInizioEvento);
		
		lblOrarioInizioEvento = new JLabel("ORARIO INIZIO EVENTO");
		lblOrarioInizioEvento.setBounds(63, 374, 145, 16);
		frame.getContentPane().add(lblOrarioInizioEvento);
		
		lblDurata = new JLabel("DURATA");
		lblDurata.setBounds(63, 439, 145, 16);
		frame.getContentPane().add(lblDurata);
		
		lblQuota = new JLabel("QUOTA");
		lblQuota.setBounds(63, 497, 145, 16);
		frame.getContentPane().add(lblQuota);
		
		lblInclusiNellaQuota = new JLabel("INCLUSI NELLA QUOTA");
		lblInclusiNellaQuota.setBounds(63, 547, 145, 16);
		frame.getContentPane().add(lblInclusiNellaQuota);
		
		lblDataFineEvento = new JLabel("DATA FINE EVENTO");
		lblDataFineEvento.setBounds(63, 595, 145, 16);
		frame.getContentPane().add(lblDataFineEvento);
		
		lblOrarioFineEvento = new JLabel("ORARIO FINE EVENTO");
		lblOrarioFineEvento.setBounds(63, 637, 145, 16);
		frame.getContentPane().add(lblOrarioFineEvento);
		
		lblNote = new JLabel("NOTE");
		lblNote.setBounds(63, 676, 145, 16);
		frame.getContentPane().add(lblNote);
		
		lblCategorie = new JLabel("CATEGORIA");
		lblCategorie.setBounds(257, 26, 116, 31);
		frame.getContentPane().add(lblCategorie);
		
		lblNomeCategoria = new JLabel("NOME CATEGORIA");
		lblNomeCategoria.setBounds(432, 33, 116, 16);
		frame.getContentPane().add(lblNomeCategoria);
		
		JLabel lblTitolo = new JLabel("titolo");
		lblTitolo.setBounds(317, 121, 56, 16);
		frame.getContentPane().add(lblTitolo);
		
		JLabel lblPartecipanti = new JLabel("partecipanti");
		lblPartecipanti.setBounds(310, 173, 106, 16);
		frame.getContentPane().add(lblPartecipanti);
		
		JLabel lblDataTermine = new JLabel("data termine");
		lblDataTermine.setBounds(317, 220, 123, 16);
		frame.getContentPane().add(lblDataTermine);
		
		JLabel lblLuogo_1 = new JLabel("luogo");
		lblLuogo_1.setBounds(317, 271, 123, 16);
		frame.getContentPane().add(lblLuogo_1);
		
		JLabel lblDataInizio = new JLabel("data inizio");
		lblDataInizio.setBounds(317, 320, 123, 16);
		frame.getContentPane().add(lblDataInizio);
		
		JLabel lblOraraioInizio = new JLabel("oraraio inizio");
		lblOraraioInizio.setBounds(327, 374, 123, 16);
		frame.getContentPane().add(lblOraraioInizio);
		
		JLabel lblDurata_1 = new JLabel("durata");
		lblDurata_1.setBounds(317, 439, 123, 16);
		frame.getContentPane().add(lblDurata_1);
		
		JLabel lblQuota_1 = new JLabel("quota");
		lblQuota_1.setBounds(317, 497, 123, 16);
		frame.getContentPane().add(lblQuota_1);
		
		JLabel lblExtra = new JLabel("extra");
		lblExtra.setBounds(317, 547, 123, 16);
		frame.getContentPane().add(lblExtra);
		
		JLabel lblDataFine = new JLabel("data fine");
		lblDataFine.setBounds(293, 595, 123, 16);
		frame.getContentPane().add(lblDataFine);
		
		JLabel lblOrarioFine = new JLabel("orario fine");
		lblOrarioFine.setBounds(293, 637, 123, 16);
		frame.getContentPane().add(lblOrarioFine);
		
		JLabel lblNote_1 = new JLabel("note");
		lblNote_1.setBounds(293, 676, 123, 16);
		frame.getContentPane().add(lblNote_1);
		//rende visibile la finestra
		//frame.setVisible(true);
	}
}
