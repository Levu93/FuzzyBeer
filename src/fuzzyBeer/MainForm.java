package fuzzyBeer;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.JTextArea;

public class MainForm {

	private JFrame frmFuzzybeer;
	private JSlider slider;
	private JButton btnNext;
	private int counter;
	private JLabel labelOne = new JLabel("1");
	private JLabel labelTwo = new JLabel("2");
	private JLabel labelThree = new JLabel("3");
	private JLabel labelFour = new JLabel("4");
	private JLabel labelFive = new JLabel("5");
	private JLabel lblBeerColor;
	private JLabel lblQuestion;
	private int bitterness;
	private int strength;
	private int color;
	private int aroma;
	private JLabel lblBackground;
	private JTextArea textArea;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm window = new MainForm();
					window.frmFuzzybeer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainForm() {
		labelOne.setPreferredSize(new Dimension(120,20));
		labelOne.setText("Very little");
		labelOne.setHorizontalAlignment(SwingConstants.CENTER);
		labelOne.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		labelTwo.setPreferredSize(new Dimension(120,20));
		labelTwo.setText("Little");
		labelTwo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTwo.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		labelThree.setPreferredSize(new Dimension(120,20));
		labelThree.setText("Medium");
		labelThree.setHorizontalAlignment(SwingConstants.CENTER);
		labelThree.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		labelFour.setPreferredSize(new Dimension(120,20));
		labelFour.setText("Bitter");
		labelFour.setHorizontalAlignment(SwingConstants.CENTER);
		labelFour.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		labelFive.setPreferredSize(new Dimension(120,20));
		labelFive.setText("Very bitter");
		labelFive.setHorizontalAlignment(SwingConstants.CENTER);
		labelFive.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFuzzybeer = new JFrame();
		frmFuzzybeer.setIconImage(Toolkit.getDefaultToolkit().getImage(MainForm.class.getResource("/img/beer-icon-yellow.png")));
		frmFuzzybeer.setResizable(false);
		frmFuzzybeer.setTitle("FuzzyBeer");
		frmFuzzybeer.setBounds(100, 100, 652, 411);
		frmFuzzybeer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFuzzybeer.getContentPane().setLayout(null);
		frmFuzzybeer.getContentPane().add(getTextArea());
		frmFuzzybeer.getContentPane().add(getSlider());
		frmFuzzybeer.getContentPane().add(getBtnNext());
		frmFuzzybeer.getContentPane().add(getLblBeerColor());
		frmFuzzybeer.getContentPane().add(getLblQuestion());
		frmFuzzybeer.getContentPane().add(getLblBackground());
	}
	private JSlider getSlider() {
		if (slider == null) {
			slider = new JSlider();
			slider.setOpaque(false);
			slider.setMinimum(1);
			slider.setMaximum(5);
			slider.setValue(3);
			slider.setBounds(10, 218, 600, 97);
			
			slider.setPaintTicks(true);

			//Create the label table
			Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
			labelTable.put( new Integer( 1 ), labelOne );
			labelTable.put( new Integer( 2 ), labelTwo );
			labelTable.put( new Integer( 3 ), labelThree );
			labelTable.put( new Integer( 4 ), labelFour );
			labelTable.put( new Integer( 5 ), labelFive );
			slider.setLabelTable( labelTable );
			
			slider.setPaintLabels(true);
		}
		return slider;
	}
	private JButton getBtnNext() {
		if (btnNext == null) {
			btnNext = new JButton("Next");
			btnNext.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
			btnNext.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					counter++;
					if (counter < 5) {
						prepareQuestion(counter, slider.getValue() );
					}
					if (counter==4) evaluate();
				}
			});
			btnNext.setBounds(261, 326, 89, 23);
		}
		return btnNext;
	}
	
	private JLabel getLblBeerColor() {
		if (lblBeerColor == null) {
			lblBeerColor = new JLabel("");
			lblBeerColor.setIcon(new ImageIcon("C:\\Users\\Vukasin\\Pictures\\ColorLabel.PNG"));
			lblBeerColor.setBounds(32, 175, 556, 36);
			lblBeerColor.setVisible(false);
		}
		return lblBeerColor;
	}
	private JLabel getLblQuestion() {
		if (lblQuestion == null) {
			lblQuestion = new JLabel("How bitter beer do you prefer?");
			lblQuestion.setHorizontalAlignment(SwingConstants.CENTER);
			lblQuestion.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			lblQuestion.setBounds(90, 0, 428, 85);
		}
		return lblQuestion;
	}
	
	protected void prepareQuestion(int counter, int value) {
		switch (counter) {
		case 1:
			bitterness = value;
			lblQuestion.setText("How strong beer do you prefer?");
			labelOne.setText("Very weak");
			labelTwo.setText("Weak");
			labelThree.setText("Medium");
			labelFour.setText("Strong");
			labelFive.setText("Very strong");
			slider.repaint();
			break;
		case 2:
			strength = value;
			lblQuestion.setText("Which beer color do you prefer?");
			labelOne.setText("Very pale");
			labelTwo.setText("Pale");
			labelThree.setText("Honey");
			labelFour.setText("Darker");
			labelFive.setText("Very dark");
			lblBeerColor.setVisible(true);
			slider.repaint();
			break;
		case 3:
			color = value;
			lblBeerColor.setVisible(false);
			lblQuestion.setText("Which beer aroma do you prefer?");
			labelOne.setText("Weak");
			labelTwo.setText("Medium weak");
			labelThree.setText("Medium");
			labelFour.setText("Full");
			labelFive.setText("Strong taste");
			btnNext.setText("Finish");
			slider.repaint();
			btnNext.repaint();
			break;
		case 4:
			aroma= value;
			lblQuestion.setText("Your result:");
			slider.setVisible(false);
			btnNext.setVisible(false);
			break;
		default:
			break;
		}	
	}
	
	protected void evaluate() {
		String x="";
		DecimalFormat df = new DecimalFormat("#.##"); 
		FuzzyLogic fl = new FuzzyLogic();
		try {
			HashMap<String, Double> map = fl.evaluate(bitterness, strength, color, aroma);
			for (Entry<String, Double> entry : map.entrySet())
	        {
				x += entry.getKey()+" "+df.format(entry.getValue().doubleValue())+ "\n";
	        }
			textArea.setText(x);
			textArea.setVisible(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private JLabel getLblBackground() {
		if (lblBackground == null) {
			lblBackground = new JLabel("");
			lblBackground.setIcon(new ImageIcon(MainForm.class.getResource("/img/beer.jpg")));
			lblBackground.setBounds(0, 0, 646, 382);
		}
		return lblBackground;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setRows(10);
			textArea.setColumns(10);
			textArea.setEditable(false);
			textArea.setBounds(154, 117, 316, 198);
			textArea.setVisible(false);
		}
		return textArea;
	}
}
