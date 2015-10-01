import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator {
    
    private JFrame mainFrame;
    private JLabel userInput;
    private JLabel displayOutput;
    private JTextField userTextField;
    private JTextField displayTextField;
    private JButton resultButton,addButton,subButton,mulButton,divButton;
    private JButton clearButton;
    private JPanel userPanel;
    private JPanel displayPanel;
    private JPanel comboPanel;
    private JPanel buttonPanel;
    private JButton Button0, Button1, Button2, Button3, Button4, Button5, Button6, Button7, Button8, Button9, Buttonpt;
    private JPanel inputButtonPanel;
    static boolean decimalPoint = true; 
    public double firstInput,secondInput;
    public String choiceOfOperation;	
    
    public Calculator() {
	makeGUI();
    }
    
    public static void main( String[] args ) {
	Calculator calculator = new Calculator();      
    }
    
    private void makeGUI() {
	mainFrame = new JFrame( "Convertor" );
	mainFrame.setSize( 400, 400 );
	mainFrame.setLayout( new GridLayout( 3, 1 ) );
	mainFrame.addWindowListener( new WindowAdapter() {
		
		public void windowClosing( WindowEvent windowEvent ) {
		    System.exit( 0 ); 
		}        
	    });
	
	userInput = new JLabel( "Input : ", JLabel.CENTER );        
	displayOutput = new JLabel( "Output : ", JLabel.CENTER );
	userTextField = new JTextField(15);
	displayTextField = new JTextField(15);
	userPanel = new JPanel( new FlowLayout() );
	displayPanel = new JPanel( new FlowLayout() );
	userPanel.add( userInput );
	userPanel.add( userTextField );
	displayPanel.add( displayOutput );
	displayPanel.add( displayTextField );
	comboPanel = new JPanel( new FlowLayout() );
	buttonPanel = new JPanel( new FlowLayout() );
	Button0 = new JButton( "0" );
	Button1 = new JButton( "1" );
	Button2 = new JButton( "2" );
	Button3 = new JButton( "3" );
	Button4 = new JButton( "4" );
	Button5 = new JButton( "5" );
	Button6 = new JButton( "6" );
	Button7 = new JButton( "7" );
	Button8 = new JButton( "8" );
	Button9 = new JButton( "9" );
	Buttonpt = new JButton( "." );
	addButton = new JButton( "Add(+)" );
	subButton= new JButton( "Sub(-)" );
	mulButton= new JButton( "Mul(*)" );
	divButton= new JButton( "Div(/)" );
	inputButtonPanel = new JPanel( new FlowLayout() );
	resultButton = new JButton( "Result" );
	clearButton = new JButton( "Clear" );
	resultButton.setActionCommand( "Result" );
	clearButton.setActionCommand( "Clear" );
	resultButton.addActionListener( new ButtonClickListener() ); 
	clearButton.addActionListener( new ButtonClickListener() );
	
	Button1.addActionListener( new ButtonClickListener() {
		public void actionPerformed( ActionEvent e ) {
		    userTextField.setText(userTextField.getText()+"1");
		}
	    });
	
	Button2.addActionListener( new ButtonClickListener() {
		public void actionPerformed( ActionEvent e ) {
		    userTextField.setText(userTextField.getText()+"2");
		}
	    });
	
	Button3.addActionListener( new ButtonClickListener() {
		public void actionPerformed( ActionEvent e ) {
		    userTextField.setText(userTextField.getText()+"3");
		}
	    });
	
	Button4.addActionListener( new ButtonClickListener() {
		public void actionPerformed( ActionEvent e ) {
		    userTextField.setText(userTextField.getText()+"4");
		}
	    });
	
	Button5.addActionListener( new ButtonClickListener() {
		public void actionPerformed( ActionEvent e ) {
		    userTextField.setText(userTextField.getText()+"5");
		}
	    });
	
	Button6.addActionListener( new ButtonClickListener() {
		public void actionPerformed( ActionEvent e ) {
		    userTextField.setText(userTextField.getText()+"6");
		}
	    });
	
	Button7.addActionListener( new ButtonClickListener() {
		public void actionPerformed( ActionEvent e ) {
		    userTextField.setText(userTextField.getText()+"7");
		}
	    });
	
	Button8.addActionListener( new ButtonClickListener() {
		public void actionPerformed( ActionEvent e ) {
		    userTextField.setText(userTextField.getText()+"8");
		}
	    });
	
	Button9.addActionListener( new ButtonClickListener() {
		public void actionPerformed( ActionEvent e ) {
		    userTextField.setText(userTextField.getText()+"9");
		}
	    });
	
	Button0.addActionListener( new ButtonClickListener() {
		public void actionPerformed( ActionEvent e ) {
		    userTextField.setText(userTextField.getText()+"0");
		}
	    });
	
	Buttonpt.addActionListener( new ButtonClickListener() {
		public void actionPerformed( ActionEvent e ) {
		    if(decimalPoint == true) {
			userTextField.setText(userTextField.getText()+".");
			decimalPoint=false;
		    }
		}
	    });
	
	addButton.addActionListener( new ButtonClickListener() {
		public void actionPerformed( ActionEvent e ) {
		    firstInput= Double.parseDouble(userTextField.getText());
		    choiceOfOperation="+";
		    userTextField.setText("");
		}
	    });
	
	subButton.addActionListener( new ButtonClickListener() {
		public void actionPerformed( ActionEvent e ) {
		    firstInput= Double.parseDouble(userTextField.getText());
		    choiceOfOperation="-";
		    userTextField.setText("");
		}
	    });
	
	mulButton.addActionListener( new ButtonClickListener() {
		public void actionPerformed( ActionEvent e ) {
		    firstInput= Double.parseDouble(userTextField.getText());
		    choiceOfOperation="*";
		    userTextField.setText("");
		}
	    });
	
	divButton.addActionListener( new ButtonClickListener() {
		public void actionPerformed( ActionEvent e ) {
		    firstInput= Double.parseDouble(userTextField.getText());
		    choiceOfOperation="/";
		    userTextField.setText("");
		}
	    });
	
	inputButtonPanel.add( Button1 );
	inputButtonPanel.add( Button2 );
	inputButtonPanel.add( Button3 );
	inputButtonPanel.add( Button4 );
	inputButtonPanel.add( Button5 );
	inputButtonPanel.add( Button6 );
	inputButtonPanel.add( Button7 );
	inputButtonPanel.add( Button8 );
	inputButtonPanel.add( Button9 );
	inputButtonPanel.add( Button0 );
	inputButtonPanel.add( Buttonpt );
	buttonPanel.add( resultButton );
	buttonPanel.add( clearButton );
	comboPanel.add( addButton );
	comboPanel.add( subButton );
	comboPanel.add( mulButton );
	comboPanel.add( divButton );
	mainFrame.add( userPanel );
	mainFrame.add( displayPanel );
	mainFrame.add( inputButtonPanel );
	mainFrame.add( comboPanel );
	mainFrame.add( buttonPanel );
	mainFrame.setVisible( true ); 
    }
    
    private class ButtonClickListener implements ActionListener {
	public void actionPerformed( ActionEvent e ) {
	    double result;
	    String command = e.getActionCommand();  
	    
	    if( command.equals( "Result" ) ) {
		secondInput=Double.parseDouble(userTextField.getText());
		switch( choiceOfOperation )
		    {
		    case "+":
			result = secondInput + firstInput;
			displayTextField.setText(""+result );
			break;
		    case "-":
			result = firstInput-secondInput;
			displayTextField.setText(""+result );
			break;
		    case "*":
			result = secondInput * firstInput;
			displayTextField.setText(""+result );
			break;
		    case "/":
			result = firstInput/secondInput;
			displayTextField.setText(""+result );
			break;
		    case "null":
			displayTextField.setText(""+userTextField.getText() );
		    }
	    }
	    else {
		firstInput=0;
		secondInput=0;	
		choiceOfOperation=null;
		userTextField.setText( "" );
		displayTextField.setText( "" ); 
		decimalPoint=true;
	    }
	}
    }
}
