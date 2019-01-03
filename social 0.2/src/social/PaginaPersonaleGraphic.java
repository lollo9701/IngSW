package social;

import java.awt.EventQueue;
import java.time.Year;
import java.time.YearMonth;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JLabel;



/*
 * Interfaccia grafica della pagina utente
 */
public class PaginaPersonaleGraphic {

	private JFrame frame;
	private JLabel lblNome ;
	private JLabel lblEta_1;
	private JLabel lblSesso_1;
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
