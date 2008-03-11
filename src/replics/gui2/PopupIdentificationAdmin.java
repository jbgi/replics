package replics.gui2;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;


public class PopupIdentificationAdmin {

	// variables d'instance
	
	private Shell coquillage = null;
	
	private Label login = null;
	private Label mdp = null;
	
	private Text textLogin = null;
	private Text textMdp = null;
	
	private Button boutonConf = null;
	private Button boutonPrec = null;

	private static String passwordString="pass";
	
	// création de la fenêtre
	
	public PopupIdentificationAdmin(){
		createCoquillage();
		this.coquillage.setVisible(true);
	}
	
	// spécifications de la fenêtre
	
	private void createCoquillage() {
		
		// coquillage
		coquillage = new Shell();
		coquillage.setSize(new org.eclipse.swt.graphics.Point(Welcome.xSize,Welcome.ySize));
	    coquillage.setLocation(Welcome.xPos,Welcome.yPos);
		coquillage.setText("montrez patte blanche d'abord!");
		
		// labels
		login = new Label(coquillage, SWT.NONE);
		login.setBounds(new org.eclipse.swt.graphics.Rectangle(47,16,110,15));
		mdp.setText("     ENTER YOUR LOGIN");
	
		mdp = new Label(coquillage, SWT.NONE);
		mdp.setBounds(new org.eclipse.swt.graphics.Rectangle(205,180,150,20));
		mdp.setText("     ENTER YOUR PASSWORD");
		
		// boutons
		boutonConf = new Button(coquillage, SWT.NONE);
		bouton.setBounds(new org.eclipse.swt.graphics.Rectangle(57,62,89,24));
		bouton.setText("OK");
		
		bouton.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				coquillage.setVisible(false);
				
				Welcome welcome=new Welcome();
				welcome.setVisible(true);
			}
		});
		
		boutonPrec = new Button();
	}
	
	
	public void setText(String s){
		this.label.setText(s);
	}	
}
