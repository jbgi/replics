package replics.gui2;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;

public class Welcome {
	public Shell WelcomeShell = null;
	
	private Button administrator; // bouton d'en haut
	private Button traitement; // bouton d'en bas
	
	final static int xPos=400; // x Position of the shell
	final static int yPos=100; // y Position of the shell
	final static int xSize=600; // x Size of the shell
	final static int ySize=500; // y Size of the shell
	
	public Welcome(){createWelcomeShell();
		this.WelcomeShell.setVisible(true);
	}
	
	private void createWelcomeShell() {
		
		WelcomeShell = new Shell();
		WelcomeShell.setSize(new org.eclipse.swt.graphics.Point(xSize,ySize));
	    WelcomeShell.setLocation(xPos,yPos);
		WelcomeShell.setText("accueil");
	    
	    // administrator button
	
	    administrator = new Button(WelcomeShell, SWT.NONE);
	    administrator.setBounds(new org.eclipse.swt.graphics.Rectangle(200,100,180,29));
	    administrator.setText("ADMINISTRATOR");
	    
	    administrator.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				WelcomeShell.setVisible(false);
				PopupIdentificationAdmin popup1 = new PopupIdentificationAdmin();
				popup1.setVisible(true);
			}
		});
		
		// bouton traitement
		
	    traitement = new Button(WelcomeShell, SWT.NONE);
		traitement.setBounds(new org.eclipse.swt.graphics.Rectangle(200,250,181,29));
		traitement.setText("DATABASE MANAGEMENT");
		
		traitement.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				WelcomeShell.setVisible(false);
				PopupIdentificationDB popup2 = new PopupIdentificationDB();
				popup2.setVisible(true);			
			}
		});	
	}	
	
	public void setVisible(boolean b){
		this.WelcomeShell.setVisible(b);
}
}
