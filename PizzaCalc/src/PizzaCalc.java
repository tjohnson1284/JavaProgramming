import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.text.*;

public class PizzaCalc {
	
	public static void main(String[] args)
	{
		JFrame frame = new PizzaCalFrame();
		frame.setVisible(true);
	}

}
class PizzaCalFrame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PizzaCalFrame()
	{
		setTitle("Pizza Calculator");
		setSize(267, 200);
        centerWindow(this);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new PizzaPanel();
        this.add(panel);
        this.pack();
        
    }

    private void centerWindow(Window w)
    {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        setLocation((d.width-w.getWidth())/2, (d.height-w.getHeight())/2);
    }
	
}

class PizzaPanel extends JPanel implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JRadioButton small, medium, large;
	
	private JTextField priceField;
	
	private JLabel priceLabel;
	
	private JCheckBox saus, oliv, pepp, mush, salmi, ancho;
	
	private JButton calc, exit;
	
	private double price;
	
	public PizzaPanel()
	{
		setLayout(new GridBagLayout());
		
		//Border loweredBorder = BorderFactory.createBevelBorder(BevelBorder.LOWERED);
		Border raisedBorder = BorderFactory.createEtchedBorder();
		
		
		//Size panel - Radio Buttons, Flow Layout
		JPanel radioPanel = new JPanel();
		ButtonGroup pizzaSize = new ButtonGroup();
		radioPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		radioPanel.setBorder(BorderFactory.createTitledBorder(raisedBorder, "Size: "));
		
		small = new JRadioButton("Small", true);
		small.addActionListener(this);
		pizzaSize.add(small);
		radioPanel.add(small);
		
		medium = new JRadioButton("Medium", false);
		medium.addActionListener(this);
		pizzaSize.add(medium);
		radioPanel.add(medium);
		
		large = new JRadioButton("Large", false);
		large.addActionListener(this);
		pizzaSize.add(large);
		radioPanel.add(large);
		
		add(radioPanel, getConstraints(0,0,4,1, GridBagConstraints.WEST, GridBagConstraints.NONE));
		
		
		//Toppings Panel CheckBoxes, Grid Layout
		GridLayout toppingsLayout = new GridLayout(3,2);
		JPanel toppingsPanel = new JPanel();
		toppingsPanel.setLayout(toppingsLayout);
		toppingsPanel.setBorder(BorderFactory.createTitledBorder(raisedBorder, "Size: "));
		
		
		saus = new JCheckBox("Sausage", false);
		saus.addActionListener(this);
		toppingsPanel.add(saus);
		
		oliv = new JCheckBox("Olives", false);
		oliv.addActionListener(this);
		toppingsPanel.add(oliv);
		
		pepp = new JCheckBox("Pepperoni", false);
		pepp.addActionListener(this);
		toppingsPanel.add(pepp);
		
		mush = new JCheckBox("Mushrooms", false);
		mush.addActionListener(this);
		toppingsPanel.add(mush);
		
		salmi = new JCheckBox("Salami", false);
		salmi.addActionListener(this);
		toppingsPanel.add(salmi);
		
		ancho = new JCheckBox("Anchovies", false);
		ancho.addActionListener(this);
		toppingsPanel.add(ancho);
		
		
		add(toppingsPanel, getConstraints(0,1,0,2, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL));
		
		//Price Panel - Design: Flow Layout
		JPanel pricePanel = new JPanel();
		radioPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		priceLabel = new JLabel("Price: ");
		pricePanel.add(priceLabel);
		
		priceField = new JTextField(5);
		priceField.setEditable(false);
		priceField.setFocusable(false);
		pricePanel.add(priceField);
		
		add(pricePanel, getConstraints(0,4,1,1, GridBagConstraints.LINE_START, GridBagConstraints.NONE));
		
		// calculate button
        calc = new JButton("Calculate");
        calc.addActionListener(this);
        add(calc, getConstraints(0,5,1,1, GridBagConstraints.LINE_END, GridBagConstraints.NONE));

        // exit button
        exit = new JButton("Exit");
        exit.addActionListener(this);
        add(exit, getConstraints(3,5,1,1, GridBagConstraints.LINE_END, GridBagConstraints.NONE));
		
		
		
	}
	
	
	private GridBagConstraints getConstraints(int gridx, int gridy,
            int gridwidth, int gridheight, 
            int anchor, int fill)
	{
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 5, 5, 5);
		c.ipadx = 10;
		c.ipady = 0;
		c.gridx = gridx;
		c.gridy = gridy;
		c.gridwidth = gridwidth;
		c.gridheight = gridheight;
		c.anchor = anchor;
		c.fill = fill;
		return c;
	}
	public void actionPerformed(ActionEvent e) 
	{
		Object source = e.getSource();
		if(source == exit)
		{
			System.exit(0);
		}
		else if(source == calc)
		{
			price = 0.00;
			if(small.isSelected())
			{
				price += 6.99;
			}
			if(medium.isSelected())
			{
				price += 8.99;
			}
			if(large.isSelected())
			{
				price += 10.99;
			}
			if(saus.isSelected())
			{
				price += 1.49;
			}
			if(pepp.isSelected())
			{
				price += 1.49;
			}
			if(salmi.isSelected())
			{
				price += 1.49;
			}
			if(oliv.isSelected())
			{
				price += .99;
			}
			if(ancho.isSelected())
			{
				price += .99;
			}
			if(mush.isSelected())
			{
				price += .99;
			}
			NumberFormat currency = NumberFormat.getCurrencyInstance();
			priceField.setText(currency.format(price));
		}
	}
		
		
}
	
	
