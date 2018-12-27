package social;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;

public class BachecaEventi {

	private JFrame frame;
	   /*JPanel p1 = new JPanel(); 
	   JPanel p2 = new JPanel();  
	   JPanel p3 = new JPanel(); */
	   
	   
	   private DatiUtili dati= new DatiUtili();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BachecaEventi window = new BachecaEventi();
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
	public BachecaEventi() {
		dati=MainClass.getDati();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		 frame = new JFrame();
		    frame.setBounds(100, 100, 1014, 768);
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    
		   
		        // Aggiunta dei pannelli al JTabbedPane
		     
		        JTabbedPane tabs = new JTabbedPane();    
		        tabs.setTabPlacement(JTabbedPane.LEFT);  
		        /*tabs.addTab("Tab 1", p1);  
		        tabs.addTab("Tab 2", p2); 
		        tabs.addTab("Tab 3", p3);*/
		        for(int i=0; i<dati.getEventi().size(); i++)
		        {
		        	//controllare perchè temo non funzioni
		        	 tabs.addTab(dati.getEventi().get(i).getTitolo(), new JPanel()); 
		        }
		        frame.getContentPane().add(tabs);   
		        frame.setSize(860,706);  
		        frame.setLocation(100,100); 
		        frame.setVisible(true); 	
	}
}
