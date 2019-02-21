package social;

import java.awt.Color;

//ricordarsi di creare una classe per la grafica della baheca dell'evento specifico

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.text.html.HTMLDocument.Iterator;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class PaginaEventoGraphic {

	
 	protected JFrame frame;
 	private ArrayList <JPanel> pannelli= new ArrayList();
// 	private ArrayList <Utente> copiaEventi =new ArrayList<>();           //array utili a rimozione iscrizioni
// 	private ArrayList <Categoria> copiaEventiPersonali =new ArrayList<>();
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
    private JButton revoca;
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
	private JButton back;
	private JTabbedPane tabs; 
	 
	 
	/**
	 * Create the application.
	 */
	public PaginaEventoGraphic() {
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
	    
	    tabs = new JTabbedPane();    
	    tabs.setBounds(0,0, 1050, 750);
	    tabs.setTabPlacement(JTabbedPane.LEFT); 
	    tabs.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		   
		        
	// Aggiunta dei pannelli al JTabbedPane (ogni pannello contiene dati relativi a eventi specifici + bottone iscrizione     
	    for(int i=0; i<MainClass.getUtenteConnesso().getEventiPersonali().size() ;i++)
		{
			
		    pannelli.add(inizializzaEvento(MainClass.getUtenteConnesso().getEventiPersonali().get(i)));
		    pannelli.get(i).setPreferredSize(new Dimension(1000,600));
		    tabs.addTab(MainClass.getUtenteConnesso().getEventiPersonali().get(i).getTitolo(),pannelli.get(i));
		    	
        }
  
		        
        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(tabs);
        frame.setLocation(300, 100);
        frame.setVisible(true); 
        
	}
	
	//metodo per permettere l'inizializzazione dei pannelli della TabbedPane con dati di eventi a cui utente è iscritto
	protected JPanel inizializzaEvento(Categoria evento)
	{
		
		pannello = new JPanel();
		pannello.setLayout(null);
		
	//BOTTONE PER PERMETTERE LA CREAZIONE DI UN EVENTO , in realtà così puoi solo di calcio,dovrebbe essere generico
		revoca=new JButton("REVOCA ISCRIZIONE");
		revoca.setBounds(550, 655, 150, 50);
		revoca.setBackground(Color.RED); 
		pannello.add(revoca);
				
		revoca.addMouseListener(new MouseAdapter() 
		{
		@Override
		public void mouseClicked(MouseEvent arg0)
		{
				
			int k= tabs.getSelectedIndex();
			System.out.println(k);
			
			int x=0;
			for(int i=0; i<dati.getListaEventi().size(); i++)
	        {
				if(dati.getListaEventi().get(i).getTitolo().equals(MainClass.getUtenteConnesso().getEventiPersonali().get(k).getTitolo()))
				{
					 x=i;
				}
	        }
			
			//dovrebbe eliminare l'evento se creatore si toglie
			if(MainClass.getUtenteConnesso().getUsername().equals(dati.getListaEventi().get(x).getUtentiIscritti().get(0).getUsername()))
			{	
				//ci son quasi ma credo ci sia problema con ordine in cui si eseguono i passaggi
				evento.revocaIscrizionePlus(MainClass.getUtenteConnesso().getEventiPersonali().get(k).getTitolo(),dati.getListaEventi().get(x));
			}
			else
			{
				evento.revocaIscrizioneCat(MainClass.getUtenteConnesso().getEventiPersonali().get(k).getTitolo());
				//provo passando nome evento invece dell'indice
				 
				MainClass.getUtenteConnesso().revocaIscrizioneUtente(dati.getListaEventi().get(x));  //questo si è giusto
			}
			
			try {
				Serializator.saveData(MainClass.getDati());
				} catch (IOException e) {
					e.printStackTrace();
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
		

		//BOTTONE PER TORNARE ALLA PAGINA PERSONALE
		back = new JButton("BackToPersonalPage");
		back.setBounds(550, 600, 180, 50);
		back.setBackground(Color.GREEN); 
		pannello.add(back);
				
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				PaginaPersonaleGraphic pag= new PaginaPersonaleGraphic();
				pag.inizializzaDati(MainClass.getUtenteConnesso());
				frame.setVisible(false);
			}
		});
		
		//rende visibile la finestra
		//frame.setVisible(true);
		return pannello;
	}
	
}
