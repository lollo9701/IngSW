package social;

import java.awt.Color;
import java.awt.EventQueue;
import java.time.Year;
import java.time.YearMonth;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



/*
 * Interfaccia grafica della pagina utente
 */
public class PaginaPersonaleGraphic {

	private JFrame frame;
	private JLabel lblNome ;
	private JLabel lblEta_1;
	private JLabel lblSesso_1;
	private JButton btnLogout; 
	GregorianCalendar calendar = new GregorianCalendar();
	private JTextArea textNoteInfo;
	private DatiUtili dati= null;
	
	
	
	
/*	
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaginaPersonaleGraphic window = new PaginaPersonaleGraphic();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}   */

	/**
	 * Create the application.
	 */
	public PaginaPersonaleGraphic() {
		dati = MainClass.getDati();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 1014, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPaginaPersonaleDi = new JLabel("PAGINA PERSONALE DI");
		lblPaginaPersonaleDi.setBounds(48, 108, 151, 16);
		frame.getContentPane().add(lblPaginaPersonaleDi);
		
		 lblNome = new JLabel("nome");
		lblNome.setBounds(307, 108, 56, 16);
		frame.getContentPane().add(lblNome);
		
		JLabel lblEta = new JLabel("ETA'");
		lblEta.setBounds(48, 170, 56, 16);
		frame.getContentPane().add(lblEta);
		
		 lblEta_1 = new JLabel("et\u00E0");
		lblEta_1.setBounds(307, 170, 56, 16);
		frame.getContentPane().add(lblEta_1);
		
		JLabel lblSesso = new JLabel("SESSO");
		lblSesso.setBounds(48, 249, 56, 16);
		frame.getContentPane().add(lblSesso);
		
		lblSesso_1 = new JLabel("sesso");
		lblSesso_1.setBounds(307, 249, 56, 16);
		frame.getContentPane().add(lblSesso_1);
		
//bottone per passare da pagina personale a pagina categorie,se non esistono eventi crea bottone "temporaneo" per crearne uno
		JButton categorieBtn = new JButton("Gestione Bacheca");
		categorieBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if(dati.getListaEventi().size()==0)
				{
					textNoteInfo.setText("Non esistono ancora eventi\nCreane uno tramite tasto CreaEvento");
					JButton creaEvento = new JButton("CreaEvento");
					creaEvento.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							
							if(dati.getListaEventi().size()==0)
							{
								EventCalcioGraphic ev= new EventCalcioGraphic();
								frame.setVisible(false);
							}
							else
							{	
								creaEvento.setEnabled(false);
								creaEvento.setVisible(false);
							}
						}
					});
					creaEvento.setBounds(582, 400, 179, 50);
					creaEvento.setVisible(true);
					frame.getContentPane().add(creaEvento);
					frame.repaint();
				}
				else
				{	
					BachecaEventi bac = new BachecaEventi();
					frame.setVisible(false);
				}
			}
		});
		categorieBtn.setBounds(582, 90, 179, 50);
		frame.getContentPane().add(categorieBtn);
		
		//bottone per gestione eventi (creati e a cui iscritto)
		JButton eventiBtn = new JButton("Gestione Eventi");
		eventiBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//scegliere se far solo vedere eventi a cui è iscritto o se anche poter creare nuovo evento
			//	EventCalcioGraphic event = new EventCalcioGraphic();
				
				if(MainClass.getUtenteConnesso().getEventiPersonali().size()>0)
				{
				PaginaEventoGraphic ev= new PaginaEventoGraphic();
				frame.setVisible(false);
				}
				else textNoteInfo.setText("Non sei iscritto a nessun evento\nPuoi trovarli in gestione bacheca");
			
			}
		});
		eventiBtn.setBounds(582, 160, 179, 50);
		frame.getContentPane().add(eventiBtn);
		
		//bottone per accedere alla propria area notifiche
		JButton notificheBtn = new JButton("Area Notifiche");
		notificheBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		notificheBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			//creare classe o cmq un qualcosa per raccogliere le notifiche, scrivere nella textarea se ci sono o no
				frame.setVisible(false);
			}
		});
		notificheBtn.setBounds(582, 230, 180, 50);
		frame.getContentPane().add(notificheBtn);
		
		btnLogout = new JButton("Logout");
		btnLogout.setBounds(582, 543, 115, 29);
		btnLogout.setBackground(Color.RED);
		frame.getContentPane().add(btnLogout);
		
		//RIPORTA A PAG LOGIN E REG
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
			//	MainClass.setUtenteConnesso(null);
				RegistraGraphic rx = new RegistraGraphic();	
				frame.setVisible(false);
			}
		});
		
	/*	//CREATO SOLO QUANDO NON ESISTONO ANCORA EVENTI
		JButton creaEvento = new JButton("CreaEvento");
		creaEvento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if(dati.getListaEventi().size()==0)
				{
					PaginaEventoGraphic ev= new PaginaEventoGraphic();
					frame.setVisible(false);
				}
				else
				{	
					creaEvento.setEnabled(false);
					creaEvento.setVisible(false);
				}
			}
		});
		creaEvento.setBounds(582, 400, 179, 50);
		creaEvento.setVisible(false);
		frame.getContentPane().add(creaEvento);  */
		
		//PER VISUALIZZARE MESSAGGI DI UTILITA'
		textNoteInfo = new JTextArea();
		textNoteInfo.setBounds(582, 300, 209, 88);
		textNoteInfo.setColumns(10);
		frame.getContentPane().add(textNoteInfo);
		textNoteInfo.setEditable(false);
		textNoteInfo.setWrapStyleWord(true);
		
		frame.setVisible(true);
		
		
	}
	
	public void inizializzaDati(Utente user)
	{
		int età;
		if((calendar.get(calendar.MONTH) < Integer.parseInt( user.getMeseNascita())) || (calendar.get(calendar.MONTH) ==  Integer.parseInt(user.getMeseNascita()) && calendar.get(calendar.DAY_OF_MONTH) < Integer.parseInt( user.getGiornoNascita())))
			età =((calendar.get(calendar.YEAR) - Integer.parseInt(user.getAnnoNascita())))-1;
		else
			età =(calendar.get(calendar.YEAR) - Integer.parseInt(user.getAnnoNascita()));
		lblNome.setText(user.getUsername());
		lblEta_1.setText(String.valueOf(età));
		lblSesso_1.setText(user.getSesso());
	}
}
