package replics.gui;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class UserInterface {

	public Shell sShell = null;  //  @jve:decl-index=0:visual-constraint="10,-2"
	private Label session =null;
	private Label firstName = null;
	private Label lastName = null;
	private Label adress = null;
	private Label placeOfBirth = null;
	private Label censusPlace = null;
	private Label dateOfBirth = null;
	private Label height = null;
	private Text firstNameF = null;
	private Text lastNameF = null;
	private Text adressF = null;
	private Text dateOfBirthF = null;
	private Text text4 = null;
	private Text censusPlaceF = null;
	private Text heightF = null;
	private Button buttonPicture = null;
	private Button buttonPrec = null;
	private Button buttonCheck = null;
	private Button buttonEnd_session = null;
	private Text text6 = null;
	private Text text7 = null;
	private Label label6 = null;
	private Text text8 = null;
	/**
	 * @param args
	 */
	public UserInterface(){
		createSShell();
		this.sShell.setVisible(true);
	}
	

	/**
	 * This method initializes sShell
	 */
	private void createSShell() {
		sShell = new Shell();
		sShell.setText("Shell");
		sShell.setSize(new org.eclipse.swt.graphics.Point(Welcome.xSize,Welcome.ySize));
		sShell.setLocation(Welcome.xPos,Welcome.yPos);
		session= new Label(sShell, SWT.NONE);
		session.setBounds(new org.eclipse.swt.graphics.Rectangle(450,10,140,13));
		session.setText("session number : "+"12456257");
		firstName = new Label(sShell, SWT.NONE);
		firstName.setBounds(new org.eclipse.swt.graphics.Rectangle(80,40,70,13));
		firstName.setText("Fisrt name");
		lastName = new Label(sShell, SWT.NONE);
		lastName.setBounds(new org.eclipse.swt.graphics.Rectangle(80,70,70,13));
		lastName.setText("Last name");
		adress = new Label(sShell, SWT.NONE);
		adress.setBounds(new org.eclipse.swt.graphics.Rectangle(80,100,45,13));
		adress.setText("Adress");
		placeOfBirth = new Label(sShell, SWT.NONE);
		placeOfBirth.setBounds(new org.eclipse.swt.graphics.Rectangle(80,130,80,13));
		placeOfBirth.setText("Place of Birth");
		height = new Label(sShell, SWT.NONE);
		height.setBounds(new org.eclipse.swt.graphics.Rectangle(80,220,80,13));
		height.setText("height");
		censusPlace = new Label(sShell, SWT.NONE);
		censusPlace.setBounds(new org.eclipse.swt.graphics.Rectangle(80,160,80,13));
		censusPlace.setText("Census place");
		dateOfBirth = new Label(sShell, SWT.NONE);
		dateOfBirth.setBounds(new org.eclipse.swt.graphics.Rectangle(80,190,80,13));
		dateOfBirth.setText("Date of birth");
		firstNameF = new Text(sShell, SWT.BORDER);
		firstNameF.setBounds(new org.eclipse.swt.graphics.Rectangle(170,40,76,19));
		lastNameF = new Text(sShell, SWT.BORDER);
		lastNameF.setBounds(new org.eclipse.swt.graphics.Rectangle(170,70,76,19));
		adressF = new Text(sShell, SWT.BORDER);
		adressF.setBounds(new org.eclipse.swt.graphics.Rectangle(170,100,76,19));
		dateOfBirthF = new Text(sShell, SWT.BORDER);
		dateOfBirthF.setBounds(new org.eclipse.swt.graphics.Rectangle(170,130,76,19));
		censusPlaceF = new Text(sShell, SWT.BORDER);
		censusPlaceF.setBounds(new org.eclipse.swt.graphics.Rectangle(170,160,76,19));
		heightF = new Text(sShell, SWT.BORDER);
		heightF.setBounds(new org.eclipse.swt.graphics.Rectangle(170,220,76,19));
		text4 = new Text(sShell, SWT.BORDER);
		text4.setBounds(new org.eclipse.swt.graphics.Rectangle(170,190,25,19));
		text4.setTextLimit(2);
		text6 = new Text(sShell, SWT.BORDER);
		text6.setBounds(new org.eclipse.swt.graphics.Rectangle(200,190,25,19));
		text6.setTextLimit(2);
		text7 = new Text(sShell, SWT.BORDER);
		text7.setBounds(new org.eclipse.swt.graphics.Rectangle(230,190,41,19));
		text7.setTextLimit(4);
		buttonCheck= new Button(sShell, SWT.NONE);
		buttonCheck.setBounds(new org.eclipse.swt.graphics.Rectangle(10,400,100,50));
		buttonCheck.setText("Confirmation");
		buttonEnd_session= new Button(sShell, SWT.NONE);
		buttonEnd_session.setBounds(new org.eclipse.swt.graphics.Rectangle(210,400,100,50));
		buttonEnd_session.setText("End session");
		buttonPicture = new Button(sShell, SWT.NONE);
		buttonPicture.setBounds(new org.eclipse.swt.graphics.Rectangle(212,285,100,25));
		buttonPicture.setText("take the picture");
		buttonCheck.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
					try {  
						Confirmation confirmation = new Confirmation();
						confirmation.firstNameF.setText(firstNameF.getText());
						confirmation.lastNameF.setText(lastNameF.getText());
						confirmation.adressF.setText(adressF.getText());
						confirmation.placeOfBirthF.setText(dateOfBirthF.getText());
						confirmation.dateOfBirthF.setText(text4.getText()+"/"+text6.getText()+"/"+text7.getText());
						confirmation.censusPlaceF.setText(censusPlaceF.getText());
						confirmation.heightF.setText(heightF.getText());
                }catch(Exception ex) {  
                }
			}
		});
        buttonEnd_session.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
        	public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
        			try {  
        				sShell.setVisible(false);
        				
        				Welcome welcome=new Welcome();
        				welcome.setVisible(true);
                        }
        			catch(Exception ex) {  
                        } 
        	}
        });
		buttonPicture.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				String cmd= "C:/Program Files/Dorgem/Dorgem.exe";
				auxThread thread = new auxThread();
				thread.start();
				
				try {  
                	 Runtime r = Runtime.getRuntime();  
                     Process p = r.exec(cmd);  
                     p.waitFor();
                     System.out.println(p.exitValue());
                     
                }catch(Exception ex) {  
                System.out.println("erreur d'execution " + cmd + e.	toString());  
                }
     
				Confirmation confirmation = new Confirmation();
				confirmation.firstNameF.setText(firstNameF.getText());
				confirmation.lastNameF.setText(lastNameF.getText());
				confirmation.adressF.setText(adressF.getText());
				confirmation.placeOfBirthF.setText(dateOfBirthF.getText());
				confirmation.dateOfBirthF.setText(text4.getText()+"/"+text6.getText()+"/"+text7.getText());
				confirmation.censusPlaceF.setText(censusPlaceF.getText());
			}
		});
		buttonPrec = new Button(sShell, SWT.ARROW | SWT.LEFT);
		buttonPrec.setBounds(new org.eclipse.swt.graphics.Rectangle(0,0,40,20));
		buttonPrec.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				sShell.setVisible(false);
				
				Welcome welcome=new Welcome();
				welcome.setVisible(true);
			}
		});
	}
	public void setVisible(boolean b){
		this.sShell.setVisible(b);
}

}
