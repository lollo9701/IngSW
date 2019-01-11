package social;

import java.awt.Color;

//ricordarsi di creare una classe per la grafica della baheca dell'evento specifico

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JTabbedPane;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class BachecaEventi {

	
 	protected JFrame frame;
 	private  ArrayList <JPanel> pannelli= new ArrayList();
    private DatiUtili dati= null;
    private JPanel	pannello;
    private JLabel lblLuogo;
    private JLabel lblDataInizioEvento;
    private JLabel lblOrarioInizioEvento;
    private JLabel lblDurata;
    private JLabel lblQuota;
    private JLabel lblInclusiNellaQuota;
    private JLabel lblDataFineEvento;
    private JLabel lblOrarioFineEvento;
    private JLabel lblNote;
	private JLabel lblCategorie;
    private JLabel lblNomeCategoria;
    private JButton iscrizione;
    private JButton indietro;
    private JButton creaEvento;
    private JLabel lblTitolo;
    private JLabel lblPartecipanti;
    private JLabel lblDataTermine;
    private JLabel lblLuogo_1;
	private JLabel lblDataInizio; 
	private JLabel lblOraraioInizio; 
	private JLabel lblDurata_1 ;
	private	JLabel lblQuota_1 ;
	private JLabel lblExtra;
	private JLabel lblDataFine; 
	private JLabel lblOrarioFine; 
	private JLabel lblNote_1 ;
	private JLabel lblTitoloEvento ;
	private JLabel lblNumeroPartecipanti;
	private JLabel lblDataTermineIscrizione;
	 
	 
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
		frame.setBounds(0, 0, 1100, 850);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    JTabbedPane tabs = new JTabbedPane();    
	    tabs.setBounds(0,0, 1050, 750);
	    tabs.setTabPlacement(JTabbedPane.LEFT); 
	    tabs.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		   
		        
	// Aggiunta dei pannelli al JTabbedPane (ogni pannello contiene dati relativi a eventi specifici + bottone iscrizione 
	    if(dati.getListaEventi().size()==0)
	    {
	    	EventCalcioGraphic testCrea = new EventCalcioGraphic();
	    	frame.setVisible(true);
	    }
	    else
	    {	
		for(int i=0; i<dati.getListaEventi().size(); i++)
        {
		      
        	pannelli.add(inizializzaEvento(dati.getListaEventi().get(i)));
        	pannelli.get(i).setPreferredSize(new Dimension(1000,600));
        	tabs.addTab(dati.getListaEventi().get(i).getTitolo(),pannelli.get(i));
        	
        	
        /*	if(dati.getListaEventi().get(i).getTitolo().equals("calcetto"))
        	{
        		aggiungiParametri(pannelli.get(i));
        	}  */
        }
	    }
  
		        
        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(tabs);
        frame.setLocation(300, 100);
        frame.setVisible(true); 
        
	}
	
//metodo per permettere l'inizializzazione dei pannelli della TabbedPane con dati di eventi specifici
	
	protected JPanel inizializzaEvento(Categoria evento)
	{
		
		pannello = new JPanel();
		pannello.setLayout(null);
		
		//BOTTONE PER PERMETTERE LA CREAZIONE DI UN EVENTO , in realtà così puoi solo di calcio,dovrebbe essere generico
		creaEvento=new JButton("CREA EVENTO");
		creaEvento.setBounds(760, 670, 150, 50);
		creaEvento.setBackground(Color.GREEN); 
		pannello.add(creaEvento);
				
		creaEvento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				EventCalcioGraphic event = new EventCalcioGraphic();
				frame.setVisible(false);
			}
		});
		
		
		//BOTTONE PER TORNARE ALLA PAGINA PERSONALE
		indietro=new JButton("BackToPersonalPage");
		indietro.setBounds(500, 600, 180, 50);
		indietro.setBackground(Color.GREEN); 
		pannello.add(indietro);
				
		indietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				PaginaPersonaleGraphic pag= new PaginaPersonaleGraphic();
				pag.inizializzaDati(MainClass.getUtenteConnesso());
				frame.setVisible(false);
			}
		});
		
		
		
		//BOTTONE CHE PERMETTE DI ISCRIVERE UN UTENTE ALL'EVENTO (+controllo se già iscritto non re-iscrive)
		iscrizione = new JButton("ISCRIVITI");
		iscrizione.setBounds(600, 670, 150, 50);
		iscrizione.setBackground(Color.GREEN); 
		pannello.add(iscrizione);
		
		iscrizione.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {     //mettere iscrizione anche in Utente eventiPersonali
				
				boolean iscritto=false;
				
				if(evento.getUtentiIscritti().size() == 0)
				{	
					//dati.getListaEventi().get(numeroEvento)
					evento.getUtentiIscritti().add(MainClass.getUtenteConnesso());
					MainClass.getUtenteConnesso().getEventiPersonali().add(evento);
					
					try {
						Serializator.saveData(MainClass.getDati());
					} catch (IOException e) {
						e.printStackTrace();
					}
					// System.out.println("sei il primo iscritto :)");
				
				}	
				else
				{	
					for(int i=0 ; i<evento.getUtentiIscritti().size() ; i++)
					{
						if(evento.getUtentiIscritti().get(i).equals(MainClass.getUtenteConnesso()))
						{
							iscritto=true;
						//	System.out.println("sei già iscritto");
						}
					
					}	
	
						if(iscritto==false)
						{
							evento.getUtentiIscritti().add(MainClass.getUtenteConnesso());
							MainClass.getUtenteConnesso().getEventiPersonali().add(evento);
							
							try {
								Serializator.saveData(MainClass.getDati());
							} catch (IOException e) {
								e.printStackTrace();
							}
						//	System.out.println("sei stato iscritto");
						}
					 
				}	 
			}	
			});
		
		lblTitoloEvento = new JLabel("TITOLO EVENTO:");
		lblTitoloEvento.setBounds(63, 121, 123, 16);
		pannello.add(lblTitoloEvento);
		
		lblNumeroPartecipanti = new JLabel("NUMERO PARTECIPANTI:");
		lblNumeroPartecipanti.setBounds(63, 173, 145, 16);
		pannello.add(lblNumeroPartecipanti);
		
		lblDataTermineIscrizione = new JLabel("DATA TERMINE ISCRIZIONE:");
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
		
		lblTitolo = new JLabel(evento.getTitolo());
		lblTitolo.setBounds(300, 121, 56, 16);
		pannello.add(lblTitolo);
		
		lblPartecipanti = new JLabel(String.valueOf(evento.getNumero_partecipanti()));
		lblPartecipanti.setBounds(300, 173, 106, 16);
		pannello.add(lblPartecipanti);
		
		lblDataTermine = new JLabel(String.valueOf(evento.getGiorno_t()) + "/" + String.valueOf(evento.getMese_t()) 
		+ "/" + String.valueOf(evento.getAnno_t()));
		lblDataTermine.setBounds(300, 220, 123, 16);
		pannello.add(lblDataTermine);
		
		lblLuogo_1 = new JLabel(evento.getLuogo());
		lblLuogo_1.setBounds(300, 271, 123, 16);
		pannello.add(lblLuogo_1);
		
		lblDataInizio = new JLabel(String.valueOf(evento.getGiorno_i()) + "/" + String.valueOf(evento.getMese_i())
		+ "/" +String.valueOf(evento.getAnno_i()));
		lblDataInizio.setBounds(300, 320, 123, 16);
		pannello.add(lblDataInizio);
		
		lblOraraioInizio = new JLabel(String.valueOf(evento.getOra()));
		lblOraraioInizio.setBounds(300, 374, 123, 16);
		pannello.add(lblOraraioInizio);
		
		lblDurata_1 = new JLabel(String.valueOf(evento.getDurata()));
		lblDurata_1.setBounds(300, 439, 123, 16);
		pannello.add(lblDurata_1);
		
		lblQuota_1 = new JLabel(String.valueOf(evento.getQuota())+"€");
		lblQuota_1.setBounds(300, 497, 123, 16);
		pannello.add(lblQuota_1);
		
		lblExtra = new JLabel(evento.getExtra());
		lblExtra.setBounds(300, 547, 123, 16);
		pannello.add(lblExtra);
		
		lblDataFine = new JLabel(String.valueOf(evento.getGiorno_f()) + "/" + String.valueOf(evento.getMese_f())
		+ "/" +String.valueOf(evento.getAnno_f()));
		lblDataFine.setBounds(300, 595, 123, 16);
		pannello.add(lblDataFine);
		
		lblOrarioFine = new JLabel(String.valueOf(evento.getOra_conclusione()));
		lblOrarioFine.setBounds(300, 637, 123, 16);
		pannello.add(lblOrarioFine);
		
		lblNote_1 = new JLabel(evento.getNote());
		lblNote_1.setBounds(300, 676, 123, 16);
		pannello.add(lblNote_1);
		
		//rende visibile la finestra
		//frame.setVisible(true);
		return pannello;
	}
	
/*	//tentativo brutale di cui parlavo
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
	}*/
	
	
	
}
