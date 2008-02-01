package replics.gui;
import java.io.*;
import java.io.IOException;
import org.jdom.*;
import org.jdom.output.*;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.custom.CLabel;

public class UserInterface {

	public Shell sShell = null;  //  @jve:decl-index=0:visual-constraint="10,-2"
	private Label label = null;
	private Label label1 = null;
	private Label label2 = null;
	private Label label3 = null;
	private Label label4 = null;
	private Label label5 = null;
	private Text text = null;
	private Text text1 = null;
	private Text text2 = null;
	private Text text3 = null;
	private Text text4 = null;
	private Text text5 = null;
	private Button button = null;
	private Button buttonPrec = null;
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
		label = new Label(sShell, SWT.NONE);
		label.setBounds(new org.eclipse.swt.graphics.Rectangle(78,16,50,13));
		label.setText("Fisrt name");
		label1 = new Label(sShell, SWT.NONE);
		label1.setBounds(new org.eclipse.swt.graphics.Rectangle(79,45,49,13));
		label1.setText("Last name");
		label2 = new Label(sShell, SWT.NONE);
		label2.setBounds(new org.eclipse.swt.graphics.Rectangle(79,73,32,13));
		label2.setText("Adress");
		label3 = new Label(sShell, SWT.NONE);
		label3.setBounds(new org.eclipse.swt.graphics.Rectangle(78,96,61,13));
		label3.setText("Date of Birth");
		label4 = new Label(sShell, SWT.NONE);
		label4.setBounds(new org.eclipse.swt.graphics.Rectangle(78,153,63,13));
		label4.setText("Census place");
		label5 = new Label(sShell, SWT.NONE);
		label5.setBounds(new org.eclipse.swt.graphics.Rectangle(78,122,63,13));
		label5.setText("Place of birth");
		text = new Text(sShell, SWT.BORDER);
		text.setBounds(new org.eclipse.swt.graphics.Rectangle(167,14,76,19));
		text1 = new Text(sShell, SWT.BORDER);
		text1.setBounds(new org.eclipse.swt.graphics.Rectangle(167,45,76,19));
		text2 = new Text(sShell, SWT.BORDER);
		text2.setBounds(new org.eclipse.swt.graphics.Rectangle(167,71,76,19));
		text3 = new Text(sShell, SWT.BORDER);
		text3.setBounds(new org.eclipse.swt.graphics.Rectangle(167,95,76,19));
		text4 = new Text(sShell, SWT.BORDER);
		text4.setBounds(new org.eclipse.swt.graphics.Rectangle(167,124,25,19));
		text4.setTextLimit(2);
		text5 = new Text(sShell, SWT.BORDER);
		text6 = new Text(sShell, SWT.BORDER);
		text6.setBounds(new org.eclipse.swt.graphics.Rectangle(199,124,25,19));
		text6.setTextLimit(2);
		text7 = new Text(sShell, SWT.BORDER);
		text7.setBounds(new org.eclipse.swt.graphics.Rectangle(232,125,41,19));
		text7.setTextLimit(4);
		text5.setBounds(new org.eclipse.swt.graphics.Rectangle(167,150,76,19));
		button = new Button(sShell, SWT.NONE);
		button.setBounds(new org.eclipse.swt.graphics.Rectangle(212,255,88,25));
		button.setText("take the picture");

		button.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				
				String cmd= "C:/Program Files/Dorgem/Dorgem.exe";
                try {  
                   	 Runtime r = Runtime.getRuntime();  
                     Process p = r.exec(cmd);  
                     p.waitFor();
                     System.out.println(p.exitValue());
                }catch(Exception ex) {  
                System.out.println("erreur d'execution " + cmd + e.	toString());  
                }  
     
				Confirmation confirmation = new Confirmation();
				confirmation.label7.setText(text.getText());
				confirmation.label8.setText(text1.getText());
				confirmation.label9.setText(text2.getText());
				confirmation.label10.setText(text3.getText());
				confirmation.label11.setText(text4.getText()+"/"+text6.getText()+"/"+text7.getText());
				confirmation.label12.setText(text5.getText());
				
			}
		});
		buttonPrec = new Button(sShell, SWT.ARROW | SWT.LEFT);
		buttonPrec.setBounds(new org.eclipse.swt.graphics.Rectangle(0,0,40,20));
		label6 = new Label(sShell, SWT.NONE);
		label6.setBounds(new org.eclipse.swt.graphics.Rectangle(77,184,63,13));
		label6.setText("height");
		text8 = new Text(sShell, SWT.BORDER);
		text8.setBounds(new org.eclipse.swt.graphics.Rectangle(167,178,76,19));
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
