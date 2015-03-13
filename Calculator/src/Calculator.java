/*
 * Name: Terrence Johnson
 * ID: 1202
 * Abstract: Develop a simple calculator similar in design to the windows calculator. This is implemented in Java using swing 
 * Date: 4/18/2014
 */

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Calculator {
	
	public static void main(String[] args)
	{
		JFrame frame = new CalcFrame();
		
		frame.setVisible(true);
	}

}
class CalcFrame extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenuItem menuItem;
	private JMenu menu;
	
	public CalcFrame()
	{
		setTitle("Calculator");
		setSize(367, 300);
        centerWindow(this);
        setResizable(false);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new CalcPanel();
        this.add(panel);
        this.pack();
        menu = new JMenu("Help");
		menuBar = new JMenuBar();
		menuItem = new JMenuItem("About");
		menuItem.addActionListener(this);
		this.menu.add(menuItem);
		this.menuBar.add(menu);
		setJMenuBar(menuBar);
    }

    private void centerWindow(Window w)
    {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        setLocation((d.width-w.getWidth())/2, (d.height-w.getHeight())/2);
    }
public void actionPerformed(ActionEvent e) {
		
		String source = e.getActionCommand();
		if(source == "About")
		{
			//System.exit(0);
			JFrame newFrame = new AboutFrame();
			newFrame.setVisible(true);
		}
		
	}
	
}
class CalcPanel extends JPanel implements ActionListener
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField calcWindow;
	private static final int NUMBER_OF_CHAR = 30;
	private JPanel buttonPanel;
	private JButton one,two,three,four,five,six,seven,eight,nine,zero,
					plus, minus, multiplication, division, equals, clear; 
	
	private double result = 0.0;
	private String windowText = "", operator = "";
	
	public CalcPanel()
	{
		setLayout(new GridBagLayout());
		
		//Border loweredBorder = BorderFactory.createBevelBorder(BevelBorder.LOWERED);
		//Border raisedBorder = BorderFactory.createEtchedBorder();
		
		
		
		calcWindow = new JTextField(NUMBER_OF_CHAR);
		calcWindow.setEditable(false);
		calcWindow.setFocusable(false);
		calcWindow.setHorizontalAlignment(JTextField.RIGHT);
		add(calcWindow, getConstraints(0,0,2,1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL));
		
		GridLayout numberLayout = new GridLayout(4,5);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(numberLayout);
		
		one = new JButton("1");
		one.addActionListener(this);
		buttonPanel.add(one);
		
		five = new JButton("5");
		five.addActionListener(this);
		buttonPanel.add(five);
		
		eight = new JButton("8");
		eight.addActionListener(this);
		buttonPanel.add(eight);
		
		plus = new JButton("+");
		plus.addActionListener(this);
		buttonPanel.add(plus);
		
		two = new JButton("2");
		two.addActionListener(this);
		buttonPanel.add(two);
		
		six = new JButton("6");
		six.addActionListener(this);
		buttonPanel.add(six);
		
		nine = new JButton("9");
		nine.addActionListener(this);
		buttonPanel.add(nine);
		
		minus = new JButton("-");
		minus.addActionListener(this);
		buttonPanel.add(minus);
		
		three = new JButton("3");
		three.addActionListener(this);
		buttonPanel.add(three);
		
		seven = new JButton("7");
		seven.addActionListener(this);
		buttonPanel.add(seven);
		
		zero = new JButton("0");
		zero.addActionListener(this);
		buttonPanel.add(zero);
		
		multiplication = new JButton("*");
		multiplication.addActionListener(this);
		buttonPanel.add(multiplication);
		
		four = new JButton("4");
		four.addActionListener(this);
		buttonPanel.add(four);
		
		equals = new JButton("=");
		equals.addActionListener(this);
		buttonPanel.add(equals);
		
		clear = new JButton("C");
		clear.addActionListener(this);
		buttonPanel.add(clear);
		
		division = new JButton("/");
		division.addActionListener(this);
		buttonPanel.add(division);
		
		add(buttonPanel, getConstraints(0,1,0,2, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL));
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String source = e.getActionCommand();
		if(source == "1")
		{
			
			if(calcWindow.getText().equals("0"))
			{
				calcWindow.setText("1");
			}
			else
			{
				calcWindow.setText(calcWindow.getText() + "1");
			}
		}
		else if(source == "2")
		{
			if(calcWindow.getText().equals("0"))
			{
				calcWindow.setText("2");
			}
			else
			{
				calcWindow.setText(calcWindow.getText() + "2");
			}
		}
		else if(source == "3")
		{
			if(calcWindow.getText().equals("0"))
			{
				calcWindow.setText("3");
			}
			else
			{
				calcWindow.setText(calcWindow.getText() + "3");
			}
		}
		else if(source == "4")
		{
			if(calcWindow.getText().equals("0"))
			{
				calcWindow.setText("4");
			}
			else
			{
				calcWindow.setText(calcWindow.getText() + "4");
			}
		}
		else if(source == "5")
		{
			if(calcWindow.getText().equals("0"))
			{
				calcWindow.setText("5");
			}
			else
			{
				calcWindow.setText(calcWindow.getText() + "5");
			}
		}
		else if(source == "6")
		{
			if(calcWindow.getText().equals("0"))
			{
				calcWindow.setText("6");
			}
			else
			{
				calcWindow.setText(calcWindow.getText() + "6");
			}
		}
		else if(source == "7")
		{
			if(calcWindow.getText().equals("0"))
			{
				calcWindow.setText("7");
			}
			else
			{
				calcWindow.setText(calcWindow.getText() + "7");
			}
		}
		else if(source == "8")
		{
			if(calcWindow.getText().equals("0"))
			{
				calcWindow.setText("8");
			}
			else
			{
				calcWindow.setText(calcWindow.getText() + "8");
			}
		}
		else if(source == "9")
		{
			if(calcWindow.getText().equals("0"))
			{
				calcWindow.setText("9");
			}
			else
			{
				calcWindow.setText(calcWindow.getText() + "9");
			}
		}
		else if(source == "0")
		{
			if(calcWindow.getText().equals("0"))
			{
				calcWindow.setText("0");
			}
			else
			{
				calcWindow.setText(calcWindow.getText() + "0");
			}
		}
		else if(source.equals("+"))
		{		
			if(operator.equals("+"))
			{
				result = result + Double.parseDouble(calcWindow.getText());
			}
			else
			{
				result = Double.parseDouble(calcWindow.getText());
			}
            calcWindow.setText("0");
            operator = "+";
		}
		else if(source.equals("-"))
		{
			if(operator.equals("-"))
			{
				result = result - Double.parseDouble(calcWindow.getText());
			}
			else
			{
				result = Double.parseDouble(calcWindow.getText());
			}
            calcWindow.setText("0");
            operator = "-";
		}
		else if(source.equals("*"))
		{
			if(operator.equals("*"))
			{
				result = result * Double.parseDouble(calcWindow.getText());
			}
			else
			{
				result = Double.parseDouble(calcWindow.getText());
			}
            calcWindow.setText("0");
            operator = "*";
		}
		else if(source.equals("/"))
		{
			if(operator.equals("/"))
			{
				if(Double.parseDouble(calcWindow.getText()) == 0)
				{
					calcWindow.setText("Divide by Zero error");
					source = "C";
				}
				result = result - Double.parseDouble(calcWindow.getText());
			}
			else
			{
				result = Double.parseDouble(calcWindow.getText());
			}
            calcWindow.setText("0");
            operator = "/";
		}
		else if (source.equals("C"))
        {
            result = 0.0;
            calcWindow.setText("0");
            operator = "";
        }
		else if (source.equals("="))
        {
			if(operator.equals("+"))
			{
				result = result + Double.parseDouble(calcWindow.getText());
				calcWindow.setText(Double.toString(result));
			}
			else if(operator.equals("-"))
			{
				result = result - Double.parseDouble(calcWindow.getText());
				calcWindow.setText(Double.toString(result));
			}
			else if(operator.equals("*"))
			{
				result = result * Double.parseDouble(calcWindow.getText());	
				calcWindow.setText(Double.toString(result));
			}
			else if(operator.equals("/"))
			{
				double temp = Double.parseDouble(calcWindow.getText());
				if(temp == 0.0)
				{
					calcWindow.setText("Divide by Zero error");
				}
				else
				{
					result = result / Double.parseDouble(calcWindow.getText());
					calcWindow.setText(Double.toString(result));
				}
			}
            //calcWindow.setText(Double.toString(result));
        }
	}
	private GridBagConstraints getConstraints(int gridx, int gridy,
            int gridwidth, int gridheight, 
            int anchor, int fill)
	{
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 5, 5, 5);
		c.ipadx = 0;
		c.ipady = 20;
		c.gridx = gridx;
		c.gridy = gridy;
		c.gridwidth = gridwidth;
		c.gridheight = gridheight;
		c.anchor = anchor;
		c.fill = fill;
		return c;
	}
}
class AboutFrame extends JFrame
{
	private JLabel name, program;
	private JButton close;
	
	{
		setTitle("About");
		setSize(267, 200);
        centerWindow(this);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());
        JLabel name = new JLabel("Name: Terrence Johnson");
        add(name);
        JLabel program = new JLabel("Bad version of window's calculator");
        add(program);
        //JButton close = new JButton("Click here to close this message");
    }
	
	private void centerWindow(Window w)
    {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        setLocation((d.width-w.getWidth())/2, (d.height-w.getHeight())/2);
    }
	
	
}