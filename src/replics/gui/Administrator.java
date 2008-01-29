package replics.gui;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
public class Administrator {
	
	private Shell sShell = null;
	private Button buttonPrec;
	private Combo combo = null;
	private Combo comboRemoveUser=null;
	private Label labelLanguage = null;
	private Text textNewPassword = null;
	private Button buttonNewPassword = null;
	private Text textUserLogin = null;
	private Text textPassWordUser = null;
	private Button buttonNewUser = null;
	private Label labelNewPassword = null;
	private Label labelNewUser = null;
	private Label labelRemoveUser=null;
	private Text textConfirmNewPassword=null;//!!!!!! textNewPasswordConfirm and textConfirmNewPassword are different
	private Button buttonRemoveUser=null;
	private Text textNewPasswordConfirm=null; //!!!!!! textNewPasswordConfirm and textConfirmNewPassword are different
	
	public Administrator(){
		createAdministratorShell();
		this.sShell.setVisible(true);
	}
	
	private void createAdministratorShell() {
		sShell = new Shell();
		sShell.setText("Shell");
		sShell.setSize(new Point(Welcome.xSize,Welcome.ySize));
		sShell.setLocation(Welcome.xPos,Welcome.yPos);
		//button prec	
		buttonPrec = new Button(sShell, SWT.ARROW | SWT.LEFT);
		buttonPrec.setBounds(new org.eclipse.swt.graphics.Rectangle(0,0,40,20));
		buttonPrec.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				sShell.setVisible(false);
				AdministratorPassword admin=new AdministratorPassword();
			}
		});
		//combo
		getCombo();
		//comboRemoveUser
		getComboRemoveUser();
		//label New User
		labelNewUser = new Label(sShell, SWT.NONE);
		labelNewUser.setBounds(new org.eclipse.swt.graphics.Rectangle(20,270,122,17));
		labelNewUser.setText("add new user");
		//label New Password
		labelNewPassword = new Label(sShell, SWT.NONE);
		labelNewPassword.setBounds(new org.eclipse.swt.graphics.Rectangle(20,170,200,17));
		labelNewPassword.setText("change administrator password");
		//button new user
		buttonNewUser = new Button(sShell, SWT.NONE);
		buttonNewUser.setBounds(new org.eclipse.swt.graphics.Rectangle(300,300,70,20));
		buttonNewUser.setText("VALID");
		//text password user
		textPassWordUser = new Text(sShell, SWT.BORDER);
		textPassWordUser.setBounds(new org.eclipse.swt.graphics.Rectangle(150,300,100,20));
		textPassWordUser.setText("password");
		//text user login
		textUserLogin = new Text(sShell, SWT.BORDER);
		textUserLogin.setBounds(new org.eclipse.swt.graphics.Rectangle(20,300,100,20));
		textUserLogin.setText("login");
		//button new password
		buttonNewPassword = new Button(sShell, SWT.NONE);
		buttonNewPassword.setBounds(new org.eclipse.swt.graphics.Rectangle(300,200,70,20));
		buttonNewPassword.setText("VALID");
		//text Password confirm
		textNewPasswordConfirm = new Text(sShell, SWT.BORDER);
		textNewPasswordConfirm.setBounds(new org.eclipse.swt.graphics.Rectangle(150,200,100,20));
		textNewPasswordConfirm.setText("confirm password");
		
		buttonNewPassword.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				//textPassWordUser
				if(textNewPassword.getText().equals(textNewPasswordConfirm.getText())){
				AdministratorPassword.changeAdministratorPassword(textNewPassword.getText());
				ConfirmationPopup c=new ConfirmationPopup();
				c.setText("PASSWORD CHANGED");
				
				}else{
					ConfirmationPopup c=new ConfirmationPopup();
					c.setText("ERROR PASSWORD");
				}
			}
		});
		//text new password
		textNewPassword = new Text(sShell, SWT.BORDER);
		textNewPassword.setBounds(new org.eclipse.swt.graphics.Rectangle(20,200,100,20));
		textNewPassword.setText("password");
		
		//text confirm new password
		textConfirmNewPassword = new Text(sShell, SWT.BORDER);
		textConfirmNewPassword.setBounds(new org.eclipse.swt.graphics.Rectangle(150,325,100,20));
		textConfirmNewPassword.setText(" confirm password");
		//label language
		labelLanguage = new Label(sShell, SWT.NONE);
		labelLanguage.setBounds(new org.eclipse.swt.graphics.Rectangle(20,50,106,19));
		labelLanguage.setText("choose your language");
		//label remove User
		labelRemoveUser=new Label(sShell, SWT.NONE);
		labelRemoveUser.setBounds(20,370,200,200);
		labelRemoveUser.setText("remove user");
		//button remove user
		buttonRemoveUser=new Button(sShell, SWT.NONE);
		buttonRemoveUser.setBounds(300,370,70,20);
		buttonRemoveUser.setText("VALID");
	}
	private Combo getCombo() {
		if (combo == null) {
			combo = new Combo(sShell, SWT.NONE);
			combo.setBounds(new org.eclipse.swt.graphics.Rectangle(150,50,100,20));
		}
		return combo;
	}
	
	private Combo getComboRemoveUser() {
		if (comboRemoveUser == null) {
			comboRemoveUser = new Combo(sShell, SWT.NONE);
			comboRemoveUser.setBounds(new org.eclipse.swt.graphics.Rectangle(150,370,100,20));
		}
		return comboRemoveUser;
	}

}