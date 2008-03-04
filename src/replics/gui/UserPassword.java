package replics.gui;

import java.awt.Image;

import javax.swing.ImageIcon;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

public class UserPassword {

	public Shell sShell = null;  //  @jve:decl-index=0:visual-constraint="7,4"
	private Label label = null;
	private Text Passwordtext = null;
	private Label Llogin =null;
	private Text Login = null;
	private Button buttonContinue = null;
	private static String passwordString="pass";
	private Button buttonPrec = null;
	public UserPassword(){
		createShellUserPassword();
		this.sShell.setVisible(true);
	}
	
	/**
	 * This method initializes sShell
	 */
	private void createShellUserPassword() {
		//shell
		sShell = new Shell();
		sShell.setText("Shell");
		sShell.setSize(new org.eclipse.swt.graphics.Point(Welcome.xSize,Welcome.ySize));
		sShell.setLocation(Welcome.xPos,Welcome.yPos);
		//label
		label = new Label(sShell, SWT.NONE);
		label.setBounds(new org.eclipse.swt.graphics.Rectangle(205,180,170,20));
		label.setText("     ENTER YOUR PASSWORD");
		//text
		Passwordtext = new Text(sShell, SWT.BORDER);
		Passwordtext.setBounds(new org.eclipse.swt.graphics.Rectangle(220,210,120,30));
		Llogin = new Label(sShell, SWT.NONE);
		Llogin.setBounds(new org.eclipse.swt.graphics.Rectangle(205,80,150,20));
		Llogin.setText("     ENTER YOUR LOGIN");
		Login = new Text(sShell, SWT.BORDER);
		Login.setBounds(new org.eclipse.swt.graphics.Rectangle(220,120,120,30));

		//button continue
		buttonContinue = new Button(sShell, SWT.NONE);
		buttonContinue.setBounds(new org.eclipse.swt.graphics.Rectangle(220,250,120,30));
		buttonContinue.setText("CONTINUE");
		//button prec	
		buttonPrec = new Button(sShell, SWT.ARROW | SWT.LEFT);
		buttonPrec.setBounds(new org.eclipse.swt.graphics.Rectangle(0,0,40,20));
		buttonPrec.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				sShell.setVisible(false);
				Welcome welcome=new Welcome();
				welcome.setVisible(true);
			}
		});
		//button continue	
		buttonContinue.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				if(Passwordtext.getText().equals(passwordString)){
				sShell.setVisible(false);
				UserInterface user = new UserInterface(); 
				}else{
					Passwordtext.setText("wrong password");
				}
			}
		});
		
	}
	
	public static void changeAdministratorPassword(String newPassword){
		passwordString=newPassword;
	}
	public void setVisible(boolean b){
		this.sShell.setVisible(b);
}
}
