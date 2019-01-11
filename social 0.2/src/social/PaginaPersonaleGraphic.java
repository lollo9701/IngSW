package social;

import java.awt.Color;
import java.awt.EventQueue;
import java.time.Year;
import java.time.YearMonth;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



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
	
	/**
	 * Launch the application.
	 */
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
	}

	/**
	 * Create the application.
	 */
	public PaginaPersonaleGraphic() {
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
		
		//bottone per passare da pagina personale a pagina categorie
		JButton categoriebtn = new JButton("Gestione Categorie");
		categoriebtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				BachecaEventi bac = new BachecaEventi();
				frame.setVisible(false);
			}
		});
		categoriebtn.setBounds(612, 91, 179, 50);
		frame.getContentPane().add(categoriebtn);
		
		//bottone per gestione eventi (creati e a cui iscritto)
		JButton eventibtn = new JButton("Gestione Eventi");
		eventibtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//scegliere se far solo vedere eventi a cui è iscritto o se anche poter creare nuovo evento
			//	EventCalcioGraphic event = new EventCalcioGraphic();
				
				PaginaEventoGraphic ev= new PaginaEventoGraphic();
				frame.setVisible(false);
			}
		});
		eventibtn.setBounds(612, 157, 179, 50);
		frame.getContentPane().add(eventibtn);
		
		//bottone per accedere alla propria area notifiche
		JButton notifichebtn = new JButton("Area Notifiche");
		notifichebtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				frame.setVisible(false);
			}
		});
		notifichebtn.setBounds(612, 216, 179, 50);
		frame.getContentPane().add(notifichebtn);
		
		btnLogout = new JButton("Logout");
		btnLogout.setBounds(669, 543, 115, 29);
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
