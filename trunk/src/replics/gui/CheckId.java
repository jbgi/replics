package replics.gui;

import java.awt.TextField;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;

public class CheckId {

	public Shell checkId = null;  //  @jve:decl-index=0:visual-constraint="19,26"
	private Button button1;
	private Label label1 = null;
	private Label label2 = null;
	private Label label3 = null;
	private Button labelfg1 = null;
	private Button labelfg2 = null;
	private Button labelfg3 = null;
	final static int xPos=400; //x Position of the shell
	final static int yPos=100; //y Position of the shell
	final static int xSize=600;//x Size of the shell
	final static int ySize=500;//y Size of the shell
		
	public CheckId(){
		createSessionShell();
		this.checkId.setVisible(true);
	}
	/**
	 * Open the window
	 */
	public void open() {
		final Display display = Display.getDefault();
		createSessionShell();
		checkId.open();
		checkId.layout();
		while (!checkId.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	/**
	 * Create contents of the window
	 */
	protected void createContents() {
		checkId = new Shell();
		checkId.setSize(500, 375);
		checkId.setText("SWT Application");
		//
	}
	private void createSessionShell() {
		checkId = new Shell();
		checkId.setSize(new org.eclipse.swt.graphics.Point(xSize,ySize));

		//center shell
	    checkId.setLocation(xPos,yPos);
	    //button1
	    button1 = new Button(checkId, SWT.NONE);
		button1.setBounds(new org.eclipse.swt.graphics.Rectangle(300,150,140,30));
		button1.setText("valid");
		button1.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				checkId.setVisible(false);
				UserInterface user = new UserInterface();}
		});
		label1 = new Label(checkId, SWT.NONE);
		label1.setBounds(new org.eclipse.swt.graphics.Rectangle(100,100,100,20));
		label1.setText("TL : ");
		label2 = new Label(checkId, SWT.NONE);
		label2.setBounds(new org.eclipse.swt.graphics.Rectangle(100,200,100,20));
		label2.setText("T : ");
		label3 = new Label(checkId, SWT.NONE);
		label3.setBounds(new org.eclipse.swt.graphics.Rectangle(100,300,100,20));
		label3.setText("C : ");
		labelfg1 = new Button(checkId, SWT.NONE);
		labelfg1.setBounds(new org.eclipse.swt.graphics.Rectangle(200,100,100,20));
		labelfg1.setText("Finger Print");
		labelfg2 = new Button(checkId, SWT.NONE);
		labelfg2.setBounds(new org.eclipse.swt.graphics.Rectangle(200,200,100,20));
		labelfg2.setText("Finger Print");
		labelfg3 = new Button(checkId, SWT.NONE);
		labelfg3.setBounds(new org.eclipse.swt.graphics.Rectangle(200,300,100,20));
		labelfg3.setText("Finger Print");
		}
	public void setVisible(boolean b){
			this.checkId.setVisible(b);
	}
		

}
