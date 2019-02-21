package social;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

/*
 * Interfaccia grafica per registrazione e login utente
 */

public class RegistraGraphic {

	private JFrame frame;
	private JTextField txtNomeReg;
	private JTextField textAnno;
	private JTextArea textNoteReg;
	private JTextField textFieldLoginNome;
	private JTextArea textNote;
	private PaginaPersonaleGraphic paginaPersonale;
	private JTextField textMese;
	private JTextField textGiorno;
	private JButton btnMaschio;
	private JButton btnFemmina;
	private String genere;
	
	private JPasswordField passwordFieldReg;
	private JPasswordField passwordFieldLog;  
	private JLabel labelNomeLog; 
	private JLabel labelPswLog;
	private JLabel lblNome;
	private JLabel lblSesso;
	private JLabel lblPsw;
	private JLabel lblDataDiNascita;
	private JButton btnRegistrati; 
	private JButton btnLogin; 
	private ControlloInserimento control = new ControlloInserimento();


	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistraGraphic window = new RegistraGraphic();
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
	public RegistraGraphic() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	private void initialize() {
		
		genere="Maschio"; //settabile via tasto
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1014, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Registrazione-Nome, Password, Sesso, Data di nascita, Note
		lblNome = new JLabel("Nome Utente:");
		lblNome.setBounds(87, 133, 134, 20);
		frame.getContentPane().add(lblNome);
		
		lblSesso = new JLabel("Sesso");
		lblSesso.setBounds(87, 254, 69, 20);
		frame.getContentPane().add(lblSesso);
		
		lblPsw = new JLabel("Password:");
		lblPsw.setBounds(87, 171, 111, 20);
		frame.getContentPane().add(lblPsw);
		
		lblDataDiNascita = new JLabel("Data di Nascita");
		lblDataDiNascita.setBounds(87, 290, 122, 20);
		frame.getContentPane().add(lblDataDiNascita);
		
		textMese = new JTextField();
		textMese.setText("mm");
		textMese.setColumns(10);
		textMese.setBounds(285, 289, 54, 26);
		frame.getContentPane().add(textMese);
		
		textGiorno = new JTextField();
		textGiorno.setText("gg");
		textGiorno.setColumns(10);
		textGiorno.setBounds(213, 290, 54, 26);
		frame.getContentPane().add(textGiorno);
		
		txtNomeReg = new JTextField();
		txtNomeReg.setBounds(219, 130, 146, 26);
		frame.getContentPane().add(txtNomeReg);
		
		textAnno = new JTextField();
		textAnno.setText("aaaa");
		textAnno.setBounds(362, 290, 54, 26);
		frame.getContentPane().add(textAnno);
		
		textNoteReg = new JTextArea();
		textNoteReg.setBounds(514, 186, 209, 88);
		textNoteReg.setColumns(10);
		frame.getContentPane().add(textNoteReg);
		textNoteReg.setEditable(false);
		textNoteReg.setWrapStyleWord(true);
		
			
		
		//BOTTONE PER EFFETUARE LA REGISTRAZIONE DELL'UTENTE (+relativi controlli sui dati inseriti)
		btnRegistrati = new JButton("Registrati");
		btnRegistrati.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0)
		{
			
			if(txtNomeReg.getText().length()!=0 && passwordFieldReg.getPassword().length!=0 && 
			   textAnno.getText().length()!=0 && textMese.getText().length()!=0 && textGiorno.getText().length()!= 0)
			{
			
				if(control.isNumeric(textAnno.getText())&& control.isNumeric(textMese.getText())
				   && control.isNumeric(textGiorno.getText())&& control.data(textGiorno.getText(),
				   textMese.getText(),textAnno.getText()))
				{
					if(control.checkUtente(txtNomeReg.getText()))
					{		
						Utente nuovoUtente = new Utente();
				
						char pwd [] = passwordFieldReg.getPassword(); 
						nuovoUtente.creaUtente(txtNomeReg.getText(),gestionePsw(pwd),textAnno.getText(), textMese.getText(),
						textGiorno.getText(),genere );
						MainClass.getDati().getListaUtenti().add(nuovoUtente);
						textNoteReg.setText("Registrazione completata con\nsuccesso");
					}
					else  textNoteReg.setText("Nome utente già presente,\nUsarne uno diverso");  //nel caso mettere /n
				}
				else textNoteReg.setText("Inserisci una data valida");
				
				try {
					Serializator.saveData(MainClass.getDati());
					} 
				catch (IOException e)
				    {
					e.printStackTrace();
					}
			  } else textNoteReg.setText("Compilare tutti i campi");
			}
		});
		
		
		btnRegistrati.setBounds(514, 129, 115, 29);
		frame.getContentPane().add(btnRegistrati);
		
		
		//LOGIN UTENTE
		btnLogin = new JButton("Login");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				for(int i=0 ; i<MainClass.getDati().getListaUtenti().size() ; i++)
				{
					char pwd [] = passwordFieldLog.getPassword();
					
					if((MainClass.getDati().getListaUtenti().get(i).getUsername().equals(textFieldLoginNome.getText())) && 
						(MainClass.getDati().getListaUtenti().get(i).getPassword().equals(gestionePsw(pwd))))
					{
						
						paginaPersonale = new PaginaPersonaleGraphic();
						paginaPersonale.inizializzaDati(MainClass.getDati().getListaUtenti().get(i));
						MainClass.setUtenteConnesso(MainClass.getDati().getListaUtenti().get(i));
						//System.out.println(MainClass.getUtenteConnesso().getUsername());  //controlla identità
						
						frame.setVisible(false);
				
					}
					else textNote.setText("Utente inesistente o dati errati");
				}
			}
		});
		btnLogin.setBounds(514, 414, 115, 29);
		frame.getContentPane().add(btnLogin);
		
		labelNomeLog = new JLabel("Nome Utente:");
		labelNomeLog.setBounds(87, 418, 134, 20);
		frame.getContentPane().add(labelNomeLog);
		
		labelPswLog = new JLabel("Password:");
		labelPswLog.setBounds(87, 454, 111, 20);
		frame.getContentPane().add(labelPswLog);
		
		textFieldLoginNome = new JTextField();
		textFieldLoginNome.setColumns(10);
		textFieldLoginNome.setBounds(219, 415, 146, 26);
		frame.getContentPane().add(textFieldLoginNome);
		
		//bottoni per settera il genere dell'utente
		btnMaschio = new JButton("Maschio");
		btnMaschio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				genere="Maschio";
			}
		});
		btnMaschio.setBounds(197, 252, 97, 25);
		frame.getContentPane().add(btnMaschio);
		
		btnFemmina = new JButton("Femmina");
		btnFemmina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				genere="Femmina";
			}
		});
		btnFemmina.setBounds(319, 252, 97, 25);
		frame.getContentPane().add(btnFemmina);
		
		//come per textNoteReg rende area non scrivibile e se testo troppo lungo va a capo in automatico
		textNote = new JTextArea();
		textNote.setColumns(10);
		textNote.setBounds(514, 472, 209, 88);
		frame.getContentPane().add(textNote);
		textNote.setEditable(false);
		textNote.setWrapStyleWord(true);
		
		//per oscuare psw durante la digitazione
		passwordFieldReg = new JPasswordField();
		passwordFieldReg.setBounds(219, 168, 146, 26);
		frame.getContentPane().add(passwordFieldReg);
		
		passwordFieldLog = new JPasswordField();
		passwordFieldLog.setBounds(219, 451, 146, 26);
		frame.getContentPane().add(passwordFieldLog);
		//rende visibile finestra
		frame.setVisible(true);
		
		
	}
	
	/*public  void caricamento()
	{
				if(Serializator.getSalvataggio().exists()) 
			{
				try {
					dati = Serializator.readSavedData(Serializator.getFilename());
				} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();
				}
				
			}
			else 
			{
				dati = new DatiUtili();
			}
			
	}*/
	
	//METODO PER GESTIRE PSW MEDIANTE CARATTERE OSCURATO
	private String gestionePsw(char [] convertPsw)
	{
		String psw="";
		
		for(int i=0 ; i<convertPsw.length ; i++)
		{
			psw = psw + Character.toString(convertPsw[i]);
		}
		return psw; 
	}
	
}
