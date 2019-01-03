package social;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.GregorianCalendar;

import javax.swing.JPasswordField;

/*
 * Interfaccia grafica per registrazione e login utente
 */

public class RegistraGraphic {

	private JFrame frame;
	private JTextField txtNomeReg;
	private JTextField textAnno;
	private JTextField textNoteReg;
	private JTextField textFieldLoginNome;
	private JTextField textNote;
	private PaginaPersonaleGraphic paginaPersonale ;
	private JTextField textMese;
	private JTextField textGiorno;
	private JButton btnMaschio;
	private JButton btnFemmina;
	private String genere;
	private JPasswordField passwordFieldReg;
	private GregorianCalendar calendar = new GregorianCalendar();
	

	private JPasswordField passwordFieldLog;
	
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
		JLabel lblNome = new JLabel("Nome Utente:");
		lblNome.setBounds(87, 133, 134, 20);
		frame.getContentPane().add(lblNome);
		
		JLabel lblSesso = new JLabel("Sesso");
		lblSesso.setBounds(87, 254, 69, 20);
		frame.getContentPane().add(lblSesso);
		
		JLabel lblPsw = new JLabel("Password:");
		lblPsw.setBounds(87, 171, 111, 20);
		frame.getContentPane().add(lblPsw);
		
		JLabel lblDataDiNascita = new JLabel("Data di Nascita");
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
		txtNomeReg.setColumns(10);
		
		textAnno = new JTextField();
		textAnno.setText("aaaa");
		textAnno.setBounds(362, 290, 54, 26);
		frame.getContentPane().add(textAnno);
		textAnno.setColumns(10);
		
		
		JButton btnRegistrati = new JButton("Registrati");
		btnRegistrati.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//bisogna aggiungere i controlli per verificare che tutti i dati siano 
				//compatibili (es. nome è string, data è int etc.)
				if(txtNomeReg.getText().length() != 0 && passwordFieldReg.getPassword().length!= 0 && 
				   textAnno.getText().length() != 0 && textMese.getText().length() != 0
				   && textGiorno.getText().length() != 0)
					{
						//fai controllo su giorni mesi e anni
						if(isNumeric(textAnno.getText())&&isNumeric(textMese.getText())&&
							isNumeric(textGiorno.getText()) && data(textGiorno.getText(),textMese.getText(),textAnno.getText()) 
							&& checkUtente(txtNomeReg.getText()))
						{
							Utente nuovoUtente = new Utente();
				
							char pwd [] = passwordFieldReg.getPassword(); //non so se sia meglio farlo tramite un metodo
							String psw="";
							//necesseria parte sotto perchè getPassword ritorna char[]	
							for(int i=0 ; i<pwd.length ; i++)
								{
								psw = psw + Character.toString(pwd[i]);
								} 
							
							nuovoUtente.creaUtente(txtNomeReg.getText(),psw,textAnno.getText(), textMese.getText(), textGiorno.getText(),genere );
							MainClass.getDati().getListaUtenti().add(nuovoUtente);
						}
						else
							textNoteReg.setText("Inserisci una data numerica");
				
						
							try {
								Serializator.saveData(MainClass.getDati());
							} catch (IOException e) {
								e.printStackTrace();
							}
				}
			}
		});
		btnRegistrati.setBounds(514, 129, 115, 29);
		frame.getContentPane().add(btnRegistrati);
		
		textNoteReg = new JTextField();
		textNoteReg.setBounds(514, 186, 209, 88);
		frame.getContentPane().add(textNoteReg);
		textNoteReg.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				for(int i=0 ; i<MainClass.getDati().getListaUtenti().size() ; i++)
				{
						char pwd [] = passwordFieldLog.getPassword();
						String psw="";
					for(int x=0 ; x<pwd.length ; x++)
					{
						psw = psw + Character.toString(pwd[x]);
					} 
					if((MainClass.getDati().getListaUtenti().get(i).getUsername().equals(textFieldLoginNome.getText())) && 
						(MainClass.getDati().getListaUtenti().get(i).getPassword().equals(psw)))
					{
						
						paginaPersonale = new PaginaPersonaleGraphic();
						paginaPersonale.inizializzaDati(MainClass.getDati().getListaUtenti().get(i));
				
						frame.setVisible(false);
				
					}
				}
			}
		});
		btnLogin.setBounds(514, 414, 115, 29);
		frame.getContentPane().add(btnLogin);
		
		JLabel labelNomeLog = new JLabel("Nome Utente:");
		labelNomeLog.setBounds(87, 418, 134, 20);
		frame.getContentPane().add(labelNomeLog);
		
		JLabel labelPswLog = new JLabel("Password:");
		labelPswLog.setBounds(87, 454, 111, 20);
		frame.getContentPane().add(labelPswLog);
		
		textFieldLoginNome = new JTextField();
		textFieldLoginNome.setColumns(10);
		textFieldLoginNome.setBounds(219, 415, 146, 26);
		frame.getContentPane().add(textFieldLoginNome);
		
		textNote = new JTextField();
		textNote.setColumns(10);
		textNote.setBounds(514, 472, 209, 88);
		frame.getContentPane().add(textNote);
		
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
		
		//per oscuare psw durante la digitazione
		
		passwordFieldReg = new JPasswordField();
		passwordFieldReg.setBounds(219, 168, 146, 26);
		frame.getContentPane().add(passwordFieldReg);
		
		passwordFieldLog = new JPasswordField();
		passwordFieldLog.setBounds(219, 451, 146, 26);
		frame.getContentPane().add(passwordFieldLog);
		//rende visibile finestra
		frame.setVisible(true);
		//finisce qua
		
		
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
	
	public static boolean isNumeric(String str)  
	{  
		  try  
		  {  
		    double d = Double.parseDouble(str);  
		  }  
		  catch(NumberFormatException nfe)  
		  {  
		    return false;  
		  }  
		  return true;  
		}
	
	public boolean data(String day,String month,String year) 
	{
		boolean ok = false;
		int giorno=Integer.parseInt(day);  //dati relativi alla data di nascita dell'utente
		int mese=Integer.parseInt(month);
		int anno=Integer.parseInt(year);
		int [] numeroGiorniPerMese = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		if(anno< calendar.get(calendar.YEAR)&& mese<=12 && giorno<=numeroGiorniPerMese[mese-1]) 
		{ 
			ok= true;
		}
		
		if(anno==calendar.get(calendar.YEAR) && mese <(calendar.get(calendar.MONTH)+1)
		   && giorno<=numeroGiorniPerMese[mese-1])
		{
			ok=true;
		}
		if(anno==calendar.get(calendar.YEAR) && mese==(calendar.get(calendar.MONTH)+1)&& 
		   giorno<=calendar.get(calendar.DAY_OF_MONTH))
		{
			ok=true;
		}
		
		return ok;
		
	}
	
	public boolean checkUtente(String _nome)  //se già presente utente con quel nome impedisce registrazione
	{                                                         
		boolean check=true;
		
		for(int i=0; i<=(MainClass.getDati().getListaUtenti().size()-1) ; i++)
		{
			
			
			if(_nome.equals(MainClass.getDati().getListaUtenti().get(i).getUsername()))
			{
				check=false;
				
			}
		}
		
		
		return check;
	}
}
