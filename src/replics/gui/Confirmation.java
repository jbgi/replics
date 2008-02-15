package replics.gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class Confirmation {

	public Shell sShell = null;  //  @jve:decl-index=0:visual-constraint="111,6"
	public Label label = null;
	public Label firstName = null;
	public Label lastName = null;
	public Label adress = null;
	public Label dateOfBirth = null;
	public Label placeOfBirth = null;
	public Label censusPlace = null;
	public Label firstNameF = null;
	public Label lastNameF = null;
	public Label adressF = null;
	public Label dateOfBirthF = null;
	public Label placeOfBirthF = null;
	public Label censusPlaceF = null;
	private Button button = null;
	private Button button1 = null;
	private String picURL = null;
	/**
	 * @param args
	 */
	public Confirmation(String picURL){
		this.picURL = picURL;
		createSShell();
		sShell.open();
	

	}
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
		sShell.setSize(new org.eclipse.swt.graphics.Point(353,300));
		label = new Label(sShell, SWT.NONE);
		label.setBounds(new org.eclipse.swt.graphics.Rectangle(4,6,230,20));
		label.setText("Confirmez-vous les informations suivantes ?");
		firstName = new Label(sShell, SWT.NONE);
		firstName.setBounds(new org.eclipse.swt.graphics.Rectangle(40,35,80,15));
		firstName.setText("Fisrt name");
		lastName = new Label(sShell, SWT.NONE);
		lastName.setBounds(new org.eclipse.swt.graphics.Rectangle(40,55,80,15));
		lastName.setText("Last name");
		adress = new Label(sShell, SWT.NONE);
		adress.setBounds(new org.eclipse.swt.graphics.Rectangle(40,70,80,15));
		adress.setText("Adress");
		dateOfBirth = new Label(sShell, SWT.NONE);
		dateOfBirth.setBounds(new org.eclipse.swt.graphics.Rectangle(40,90,80,15));
		dateOfBirth.setText("Date of Birth");
		placeOfBirth = new Label(sShell, SWT.NONE);
		placeOfBirth.setBounds(new org.eclipse.swt.graphics.Rectangle(40,110,80,15));
		placeOfBirth.setText("Place of birth");
		censusPlace = new Label(sShell, SWT.NONE);
		censusPlace.setBounds(new org.eclipse.swt.graphics.Rectangle(40,130,80,15));
		censusPlace.setText("Census place");
		firstNameF = new Label(sShell, SWT.NONE);
		firstNameF.setBounds(new org.eclipse.swt.graphics.Rectangle(150,35,100,15));
		lastNameF = new Label(sShell, SWT.NONE);
		lastNameF.setBounds(new org.eclipse.swt.graphics.Rectangle(150,55,100,15));
		adressF = new Label(sShell, SWT.NONE);
		adressF.setBounds(new org.eclipse.swt.graphics.Rectangle(150,75,100,15));
		dateOfBirthF = new Label(sShell, SWT.NONE);
		dateOfBirthF.setBounds(new org.eclipse.swt.graphics.Rectangle(150,95,100,15));
		placeOfBirthF = new Label(sShell, SWT.NONE);
		placeOfBirthF.setBounds(new org.eclipse.swt.graphics.Rectangle(150,115,100,15));
		censusPlaceF = new Label(sShell, SWT.NONE);
		censusPlaceF.setBounds(new org.eclipse.swt.graphics.Rectangle(150,135,100,15));
		
		
		Image image = null;
		try {
        	
        	image = new Image(sShell.getDisplay(), new FileInputStream(picURL));

        } catch (FileNotFoundException e1) {

          e1.printStackTrace();
        }
		
        Label label13= new Label(sShell, SWT.NONE);
        label13.setImage(image);
        label13.setBounds(new org.eclipse.swt.graphics.Rectangle(70,156,100,100));
		
        button1 = new Button(sShell, SWT.NONE);
		button1.setBounds(new org.eclipse.swt.graphics.Rectangle(200,150,65,20));
		button1.setText("annuler");
		button1.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				sShell.close();
				}
		});
		button = new Button(sShell, SWT.NONE);
		button.setBounds(new org.eclipse.swt.graphics.Rectangle(275,150,65,20));
		button.setText("confirmer");
		
		button.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				JDOM1 xml1= new JDOM1();
				xml1.ville.addContent(censusPlaceF.getText());
				xml1.first_name.addContent(firstNameF.getText());
				xml1.last_name.addContent(lastNameF.getText());
				xml1.adress.addContent(adressF.getText());
				xml1.date_of_birth.addContent(dateOfBirthF.getText());
				xml1.place_of_birth.addContent(placeOfBirthF.getText());
				xml1.ID.addContent(firstNameF.getText()+lastNameF.getText());
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
