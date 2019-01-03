package social;



import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;

import javax.swing.JTabbedPane;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class BachecaEventi {

	protected JFrame frame;
	
	   ArrayList <JPanel> pannelli= new ArrayList();
	   DatiUtili dati= null;
	
   /**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public BachecaEventi() {
		dati=MainClass.getDati();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public void initialize() {
			frame = new JFrame();
		    frame.setBounds(0, 0, 1000, 850);
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    
				 
		        // Aggiunta dei pannelli al JTabbedPane
		     
		    JTabbedPane tabs = new JTabbedPane();    
		    tabs.setBounds(0,0, 950, 750);
		    tabs.setTabPlacement(JTabbedPane.LEFT);  
		   
		        
		        
		for(int i=0; i<dati.getListaEventi().size(); i++)
        {
		        	
        	pannelli.add(inizializzaEvento(dati.getListaEventi().get(i)));
        	pannelli.get(i).setPreferredSize(new Dimension(900,600));
        	tabs.addTab(dati.getListaEventi().get(i).getTitolo(),pannelli.get(i));
        	
        	
        	if(dati.getListaEventi().get(i).getTitolo().equals("calcetto"))
        	{
        		aggiungiParametri(pannelli.get(i));
        	}
        }
  
		        
        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(tabs);
        frame.setLocation(300, 100);
        frame.setVisible(true); 
        
	}
	
	protected JPanel inizializzaEvento(Categoria evento)
	{
		 JPanel	pannello = new JPanel();
		 JLabel lblLuogo;
		 JLabel lblDataInizioEvento;
		 JLabel lblOrarioInizioEvento;
		 JLabel lblDurata;
		 JLabel lblQuota;
		 JLabel lblInclusiNellaQuota;
		 JLabel lblDataFineEvento;
		 JLabel lblOrarioFineEvento;
		 JLabel lblNote;
		 JLabel lblCategorie;
		 JLabel lblNomeCategoria;
		
		pannello.setLayout(null);
		
		
		JLabel lblTitoloEvento = new JLabel("TITOLO EVENTO:");
		lblTitoloEvento.setBounds(63, 121, 123, 16);
		pannello.add(lblTitoloEvento);
		
		JLabel lblNumeroPartecipanti = new JLabel("NUMERO PARTECIPANTI:");
		lblNumeroPartecipanti.setBounds(63, 173, 145, 16);
		pannello.add(lblNumeroPartecipanti);
		
		JLabel lblDataTermineIscrizione = new JLabel("DATA TERMINE ISCRIZIONE:");
		lblDataTermineIscrizione.setBounds(63, 220, 171, 16);
		pannello.add(lblDataTermineIscrizione);
		
		lblLuogo = new JLabel("LUOGO:");
		lblLuogo.setBounds(63, 271, 56, 16);
		pannello.add(lblLuogo);
		
		lblDataInizioEvento = new JLabel("DATA INIZIO EVENTO:");
		lblDataInizioEvento.setBounds(63, 320, 145, 16);
		pannello.add(lblDataInizioEvento);
		
		lblOrarioInizioEvento = new JLabel("ORARIO INIZIO EVENTO:");
		lblOrarioInizioEvento.setBounds(63, 374, 145, 16);
		pannello.add(lblOrarioInizioEvento);
		
		lblDurata = new JLabel("DURATA:");
		lblDurata.setBounds(63, 439, 145, 16);
		pannello.add(lblDurata);
		
		lblQuota = new JLabel("QUOTA:");
		lblQuota.setBounds(63, 497, 145, 16);
		pannello.add(lblQuota);
		
		lblInclusiNellaQuota = new JLabel("INCLUSI NELLA QUOTA:");
		lblInclusiNellaQuota.setBounds(63, 547, 145, 16);
		pannello.add(lblInclusiNellaQuota);
		
		lblDataFineEvento = new JLabel("DATA FINE EVENTO:");
		lblDataFineEvento.setBounds(63, 595, 145, 16);
		pannello.add(lblDataFineEvento);
		
		lblOrarioFineEvento = new JLabel("ORARIO FINE EVENTO:");
		lblOrarioFineEvento.setBounds(63, 637, 145, 16);
		pannello.add(lblOrarioFineEvento);
		
		lblNote = new JLabel("NOTE:");
		lblNote.setBounds(63, 676, 145, 16);
		pannello.add(lblNote);
		
		lblCategorie = new JLabel("CATEGORIA:");
		lblCategorie.setBounds(257, 26, 116, 31);
		pannello.add(lblCategorie);
		
	//	lblNomeCategoria = new JLabel("GENERICA");
	//	lblNomeCategoria.setBounds(432, 33, 116, 16);
	//	pannello.add(lblNomeCategoria);
		
		JLabel lblTitolo = new JLabel(evento.getTitolo());
		lblTitolo.setBounds(300, 121, 56, 16);
		pannello.add(lblTitolo);
		
		JLabel lblPartecipanti = new JLabel(String.valueOf(evento.getNumero_partecipanti()));
		lblPartecipanti.setBounds(300, 173, 106, 16);
		pannello.add(lblPartecipanti);
		
		JLabel lblDataTermine = new JLabel(String.valueOf(evento.getGiorno_t()) + "/" + String.valueOf(evento.getMese_t()) 
		+ "/" + String.valueOf(evento.getAnno_t()));
		lblDataTermine.setBounds(300, 220, 123, 16);
		pannello.add(lblDataTermine);
		
		JLabel lblLuogo_1 = new JLabel(evento.getLuogo());
		lblLuogo_1.setBounds(300, 271, 123, 16);
		pannello.add(lblLuogo_1);
		
		JLabel lblDataInizio = new JLabel(String.valueOf(evento.getGiorno_i()) + "/" + String.valueOf(evento.getMese_i())
		+ "/" +String.valueOf(evento.getAnno_i()));
		lblDataInizio.setBounds(300, 320, 123, 16);
		pannello.add(lblDataInizio);
		
		JLabel lblOraraioInizio = new JLabel(String.valueOf(evento.getOra()));
		lblOraraioInizio.setBounds(300, 374, 123, 16);
		pannello.add(lblOraraioInizio);
		
		JLabel lblDurata_1 = new JLabel(String.valueOf(evento.getDurata()));
		lblDurata_1.setBounds(300, 439, 123, 16);
		pannello.add(lblDurata_1);
		
		JLabel lblQuota_1 = new JLabel(String.valueOf(evento.getQuota())+"€");
		lblQuota_1.setBounds(300, 497, 123, 16);
		pannello.add(lblQuota_1);
		
		JLabel lblExtra = new JLabel(evento.getExtra());
		lblExtra.setBounds(300, 547, 123, 16);
		pannello.add(lblExtra);
		
		JLabel lblDataFine = new JLabel(String.valueOf(evento.getGiorno_f()) + "/" + String.valueOf(evento.getMese_f())
		+ "/" +String.valueOf(evento.getAnno_f()));
		lblDataFine.setBounds(300, 595, 123, 16);
		pannello.add(lblDataFine);
		
		JLabel lblOrarioFine = new JLabel(String.valueOf(evento.getOra_conclusione()));
		lblOrarioFine.setBounds(300, 637, 123, 16);
		pannello.add(lblOrarioFine);
		
		JLabel lblNote_1 = new JLabel(evento.getNote());
		lblNote_1.setBounds(300, 676, 123, 16);
		pannello.add(lblNote_1);
		
		//rende visibile la finestra
		//frame.setVisible(true);
		return pannello;
	}
	
	//tentativo brutale di cui parlavo
protected void aggiungiParametri(JPanel pannello) {
		
		//Nome categoria
		JLabel lblNomeCat = new JLabel(Calcio.getNome());
		lblNomeCat.setBounds(400, 26, 300, 31);
		pannello.add(lblNomeCat);
		
		
		
		//Sesso
		JLabel lblNewLabel = new JLabel("SESSO");
		lblNewLabel.setBounds(450, 118, 56, 16);
		pannello.add(lblNewLabel);
		
		
		
		//Fascia d'età
		JLabel lblFascia = new JLabel("FASCIA D'ETA'");
		lblFascia.setBounds(450, 170, 100, 16);
		pannello.add(lblFascia);
		
		
		
		
		frame.getContentPane().setLayout(null);
		//rende visibile la finestra
		frame.setVisible(true);
	}
	
}
