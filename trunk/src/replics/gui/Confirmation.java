package replics.gui;

import java.io.FileOutputStream;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class Confirmation {

	public Shell sShell = null;  //  @jve:decl-index=0:visual-constraint="111,6"
	public Label label = null;
	public Label label1 = null;
	public Label label2 = null;
	public Label label3 = null;
	public Label label4 = null;
	public Label label5 = null;
	public Label label6 = null;
	public Label label7 = null;
	public Label label8 = null;
	public Label label9 = null;
	public Label label10 = null;
	public Label label11 = null;
	public Label label12 = null;
	private Button button = null;
	private Button button1 = null;
	/**
	 * @param args
	 */
	public Confirmation(){
		createSShell();
		sShell.open();
	

	}
	//public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* Before this is run, be sure to set up the launch configuration (Arguments->VM Arguments)
		 * for the correct SWT library path in order to run with the SWT dlls. 
		 * The dlls are located in the SWT plugin jar.  
		 * For example, on Windows the Eclipse SWT 3.1 plugin jar is:
		 *       installation_directory\plugins\org.eclipse.swt.win32_3.1.0.jar
		 */
		/*Display display = Display.getDefault();
		Confirmation thisClass = new Confirmation();
		thisClass.createSShell();
		thisClass.sShell.open();

		while (!thisClass.sShell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}*/

	/**
	 * This method initializes sShell
	 */
	private void createSShell() {
		sShell = new Shell();
		sShell.setText("Shell");
		sShell.setSize(new org.eclipse.swt.graphics.Point(353,222));
		label = new Label(sShell, SWT.NONE);
		label.setBounds(new org.eclipse.swt.graphics.Rectangle(4,6,222,19));
		label.setText("Confirmez-vous les informations suivantes ?");
		label1 = new Label(sShell, SWT.NONE);
		label1.setBounds(new org.eclipse.swt.graphics.Rectangle(42,31,50,13));
		label1.setText("Fisrt name");
		label2 = new Label(sShell, SWT.NONE);
		label2.setBounds(new org.eclipse.swt.graphics.Rectangle(42,55,49,13));
		label2.setText("Last name");
		label3 = new Label(sShell, SWT.NONE);
		label3.setBounds(new org.eclipse.swt.graphics.Rectangle(43,77,33,13));
		label3.setText("Adress");
		label4 = new Label(sShell, SWT.NONE);
		label4.setBounds(new org.eclipse.swt.graphics.Rectangle(42,97,61,13));
		label4.setText("Date of Birth");
		label5 = new Label(sShell, SWT.NONE);
		label5.setBounds(new org.eclipse.swt.graphics.Rectangle(44,116,63,13));
		label5.setText("Place of birth");
		label6 = new Label(sShell, SWT.NONE);
		label6.setBounds(new org.eclipse.swt.graphics.Rectangle(42,136,63,13));
		label6.setText("Census place");
		label7 = new Label(sShell, SWT.NONE);
		label7.setBounds(new org.eclipse.swt.graphics.Rectangle(136,34,98,16));
		label7.setText("Label");
		label8 = new Label(sShell, SWT.NONE);
		label8.setBounds(new org.eclipse.swt.graphics.Rectangle(135,56,100,13));
		label8.setText("Label");
		label9 = new Label(sShell, SWT.NONE);
		label9.setBounds(new org.eclipse.swt.graphics.Rectangle(132,75,105,13));
		label9.setText("Label");
		label10 = new Label(sShell, SWT.NONE);
		label10.setBounds(new org.eclipse.swt.graphics.Rectangle(131,97,101,13));
		label10.setText("Label");
		label11 = new Label(sShell, SWT.NONE);
		label11.setBounds(new org.eclipse.swt.graphics.Rectangle(132,118,103,13));
		label11.setText("Label");
		label12 = new Label(sShell, SWT.NONE);
		label12.setBounds(new org.eclipse.swt.graphics.Rectangle(132,136,102,13));
		label12.setText("Label");
		button1 = new Button(sShell, SWT.NONE);
		button1.setBounds(new org.eclipse.swt.graphics.Rectangle(199,158,65,20));
		button1.setText("annuler");
		button1.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				sShell.close();
				}
		});
		button = new Button(sShell, SWT.NONE);
		button.setBounds(new org.eclipse.swt.graphics.Rectangle(274,156,65,20));
		button.setText("confirmer");
		
		button.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				JDOM1 xml1= new JDOM1();
				xml1.ville.addContent(label12.getText());
				xml1.first_name.addContent(label7.getText());
				xml1.last_name.addContent(label8.getText());
				xml1.adress.addContent(label9.getText());
				xml1.date_of_birth.addContent(label10.getText());
				xml1.place_of_birth.addContent(label11.getText());
				xml1.ID.addContent(label7.getText()+label8.getText());
				try
		        {
		           //On utilise ici un affichage classique avec getPrettyFormat()
		           XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
		           //Remarquez qu'il suffit simplement de cr�er une instance de FileOutputStream
		           //avec en argument le nom du fichier pour effectuer la s�rialisation.
		           sortie.output(xml1.document, new FileOutputStream("ex3.xml"));
		        }
		        catch (java.io.IOException y){}
		        sShell.close();
		     }
		});

	}

}
