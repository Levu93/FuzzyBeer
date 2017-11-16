package fuzzyBeer;

import java.awt.Color;
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
	private JLabel lblCompleteResults;
	private JLabel lblNoOne;
	private JLabel lblNoTwo;
	private JLabel lblNoThree;
	private JLabel lblResultOne;
	private JLabel lblResultTwo;
	private JLabel lblResultThree;
	private JButton btnReccomandBeers;
	private JLabel lblResultValueOne;
	private JLabel lblResultValueTwo;
	private JLabel lblResultValueThree;
	
	
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
		frmFuzzybeer.setBounds(100, 100, 643, 393);
		frmFuzzybeer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFuzzybeer.getContentPane().setLayout(null);
		frmFuzzybeer.getContentPane().add(getLblResultValueThree());
		frmFuzzybeer.getContentPane().add(getLblResultValueTwo());
		frmFuzzybeer.getContentPane().add(getLblResultValueOne());
		frmFuzzybeer.getContentPane().add(getBtnReccomandBeers());
		frmFuzzybeer.getContentPane().add(getLblResultThree());
		frmFuzzybeer.getContentPane().add(getLblResultTwo());
		frmFuzzybeer.getContentPane().add(getLblResultOne());
		frmFuzzybeer.getContentPane().add(getLblNoThree());
		frmFuzzybeer.getContentPane().add(getLblNoTwo());
		frmFuzzybeer.getContentPane().add(getLblNoOne());
		frmFuzzybeer.getContentPane().add(getLblCompleteResults());
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
			btnNext.setBounds(261, 314, 89, 23);
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
			lblQuestion.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
			lblQuestion.setBounds(90, 11, 428, 74);
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
			int i = 0;
			for (Entry<String, Double> entry : map.entrySet())
	        {
				i++;
				x += i +". "+ entry.getKey()+" "+df.format(entry.getValue().doubleValue())+ "\n";
				if (i==1) {
					lblResultOne.setText(entry.getKey());
					lblResultValueOne.setText(df.format(entry.getValue().doubleValue()));
				}else if (i==2){
					lblResultTwo.setText(entry.getKey());
					lblResultValueTwo.setText(df.format(entry.getValue().doubleValue()));
				}else if (i==3){
					lblResultThree.setText(entry.getKey());
					lblResultValueThree.setText(df.format(entry.getValue().doubleValue()));
				}
	        }
			textArea.setText(x);
			textArea.setVisible(true);
			btnReccomandBeers.setVisible(true);
			lblCompleteResults.setVisible(true);
			lblNoOne.setVisible(true);
			lblNoTwo.setVisible(true);
			lblNoThree.setVisible(true);
			lblResultOne.setVisible(true);
			lblResultTwo.setVisible(true);
			lblResultThree.setVisible(true);
			lblResultValueOne.setVisible(true);
			lblResultValueTwo.setVisible(true);
			lblResultValueThree.setVisible(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private JLabel getLblBackground() {
		if (lblBackground == null) {
			lblBackground = new JLabel("");
			lblBackground.setIcon(new ImageIcon(MainForm.class.getResource("/img/beer.jpg")));
			lblBackground.setBounds(0, -17, 646, 395);
		}
		return lblBackground;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
			textArea.setRows(10);
			textArea.setColumns(10);
			textArea.setEditable(false);
			textArea.setBounds(474, 137, 172, 232);
			textArea.setVisible(false);
			textArea.setOpaque(false);
			textArea.setBackground(new Color(0,0,0,0));
		}
		return textArea;
	}
	private JLabel getLblCompleteResults() {
		if (lblCompleteResults == null) {
			lblCompleteResults = new JLabel("Complete results:  ");
			lblCompleteResults.setHorizontalAlignment(SwingConstants.CENTER);
			lblCompleteResults.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			lblCompleteResults.setBounds(474, 98, 172, 26);
			lblCompleteResults.setVisible(false);
		}
		return lblCompleteResults;
	}
	private JLabel getLblNoOne() {
		if (lblNoOne == null) {
			lblNoOne = new JLabel("1.");
			lblNoOne.setFont(new Font("Comic Sans MS", Font.BOLD, 21));
			lblNoOne.setBounds(67, 131, 27, 26);
			lblNoOne.setVisible(false);
		}
		return lblNoOne;
	}
	private JLabel getLblNoTwo() {
		if (lblNoTwo == null) {
			lblNoTwo = new JLabel("2.");
			lblNoTwo.setFont(new Font("Comic Sans MS", Font.BOLD, 21));
			lblNoTwo.setBounds(228, 131, 27, 26);
			lblNoTwo.setVisible(false);
		}
		return lblNoTwo;
	}
	private JLabel getLblNoThree() {
		if (lblNoThree == null) {
			lblNoThree = new JLabel("3.");
			lblNoThree.setFont(new Font("Comic Sans MS", Font.BOLD, 21));
			lblNoThree.setBounds(370, 131, 27, 26);
			lblNoThree.setVisible(false);
		}
		return lblNoThree;
	}
	private JLabel getLblResultOne() {
		if (lblResultOne == null) {
			lblResultOne = new JLabel("");
			lblResultOne.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
			lblResultOne.setHorizontalAlignment(SwingConstants.CENTER);
			lblResultOne.setBounds(0, 168, 151, 49);
			lblResultOne.setVisible(false);
		}
		return lblResultOne;
	}
	private JLabel getLblResultTwo() {
		if (lblResultTwo == null) {
			lblResultTwo = new JLabel("");
			lblResultTwo.setHorizontalAlignment(SwingConstants.CENTER);
			lblResultTwo.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
			lblResultTwo.setBounds(161, 168, 151, 49);
			lblResultTwo.setVisible(false);
		}
		return lblResultTwo;
	}
	private JLabel getLblResultThree() {
		if (lblResultThree == null) {
			lblResultThree = new JLabel("");
			lblResultThree.setHorizontalAlignment(SwingConstants.CENTER);
			lblResultThree.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
			lblResultThree.setBounds(307, 168, 145, 49);
			lblResultThree.setVisible(false);
		}
		return lblResultThree;
	}
	private JButton getBtnReccomandBeers() {
		if (btnReccomandBeers == null) {
			btnReccomandBeers = new JButton("Recommand beers for me! ");
			btnReccomandBeers.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String[] result = new String[3];
					result[0] = lblResultOne.getText();
					result[1] = lblResultTwo.getText();
					result[2] = lblResultThree.getText();
					RecommandDialog rd = new RecommandDialog(result);
					rd.setVisible(true);
				}
			});
			btnReccomandBeers.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
			btnReccomandBeers.setBounds(127, 314, 223, 23);
			btnReccomandBeers.setVisible(false);
		}
		return btnReccomandBeers;
	}
	private JLabel getLblResultValueOne() {
		if (lblResultValueOne == null) {
			lblResultValueOne = new JLabel("");
			lblResultValueOne.setHorizontalAlignment(SwingConstants.CENTER);
			lblResultValueOne.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
			lblResultValueOne.setBounds(48, 228, 46, 36);
			lblResultValueOne.setVisible(false);
		}
		return lblResultValueOne;
	}
	private JLabel getLblResultValueTwo() {
		if (lblResultValueTwo == null) {
			lblResultValueTwo = new JLabel("");
			lblResultValueTwo.setHorizontalAlignment(SwingConstants.CENTER);
			lblResultValueTwo.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
			lblResultValueTwo.setBounds(209, 228, 46, 36);
			lblResultValueTwo.setVisible(false);
		}
		return lblResultValueTwo;
	}
	private JLabel getLblResultValueThree() {
		if (lblResultValueThree == null) {
			lblResultValueThree = new JLabel("");
			lblResultValueThree.setHorizontalAlignment(SwingConstants.CENTER);
			lblResultValueThree.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
			lblResultValueThree.setBounds(353, 228, 46, 36);
			lblResultValueThree.setVisible(false);
		}
		return lblResultValueThree;
	}
}
