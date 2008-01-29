package replics.gui;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;

public class Welcome {

	public Shell WelcomeShell = null;  //  @jve:decl-index=0:visual-constraint="19,26"
	private Button button1;
	private Button button2;
	final static int xPos=400; //x Position of the shell
	final static int yPos=100; //y Position of the shell
	final static int xSize=600;//x Size of the shell
	final static int ySize=500;//y Size of the shell
		
	public Welcome(){
		createWelcomeShell();
		//this.WelcomeShell.setVisible(true);
	}
	public static void main(String[] args) {
		try {
			Welcome window = new Welcome();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window
	 */
	public void open() {
		final Display display = Display.getDefault();
		createWelcomeShell();
		WelcomeShell.open();
		WelcomeShell.layout();
		while (!WelcomeShell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	/**
	 * Create contents of the window
	 */
	protected void createContents() {
		WelcomeShell = new Shell();
		WelcomeShell.setSize(500, 375);
		WelcomeShell.setText("SWT Application");
		//
	}
	private void createWelcomeShell() {
		WelcomeShell = new Shell();
		WelcomeShell.setSize(new org.eclipse.swt.graphics.Point(xSize,ySize));

		//center shell
	    WelcomeShell.setLocation(xPos,yPos);
	    //button1
	    button1 = new Button(WelcomeShell, SWT.NONE);
		button1.setBounds(new org.eclipse.swt.graphics.Rectangle(200,100,180,29));
		button1.setText("ADMINISTRATOR");
		button1.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				WelcomeShell.setVisible(false);
				AdministratorPassword admin=new AdministratorPassword();
				admin.setVisible(true);}
		});
		//button2
		button2 = new Button(WelcomeShell, SWT.NONE);
		button2.setBounds(new org.eclipse.swt.graphics.Rectangle(200,250,181,29));
		button2.setText("USER");
		button2.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				WelcomeShell.setVisible(false);
				UserPassword user=new UserPassword();
				//user.setVisible(true);
				
			}
		});
		
		}
	public void setVisible(boolean b){
			this.WelcomeShell.setVisible(b);
	}
		

}
