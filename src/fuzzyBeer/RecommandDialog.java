package fuzzyBeer;

import javax.swing.JDialog;

import db.DatabaseBroker;
import domen.Beer;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.util.LinkedList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class RecommandDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<Beer> comboBox;
	private JLabel lblName;
	private JLabel lblStyle;
	private JLabel lblNameValue;
	private JLabel lblStyleValue;
	private JLabel lblBrewery;
	private JLabel lblBreveryValue;
	private JLabel lblOrigin;
	private JLabel lblOriginValue;
	private JLabel lblAlcohol;
	private JLabel lblAlcoholValue;
	private URI uri;
	private JButton btnInfo;
	private JLabel label;

	/**
	 * Create the dialog.
	 */
	public RecommandDialog(String[] beerStyles) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setModal(true);
		setTitle("Your results");
		setIconImage(Toolkit.getDefaultToolkit().getImage(RecommandDialog.class.getResource("/img/beer-icon-yellow.png")));
		setBounds(100, 100, 400, 281);
		getContentPane().setLayout(null);
		LinkedList<Beer> beers = new LinkedList<Beer>();
		try {
			DatabaseBroker db = new DatabaseBroker();
			beers = db.findBeerStyle(beerStyles);
		} catch (Exception e) {
			e.printStackTrace();
		}
			getContentPane().add(getComboBox(beers));
			getContentPane().add(getBtnInfo());
			getContentPane().add(getLblName());
			getContentPane().add(getLblStyle());
			getContentPane().add(getLblNameValue());
			getContentPane().add(getLblStyleValue());
			getContentPane().add(getLblBrewery());
			getContentPane().add(getLblBreveryValue());
			getContentPane().add(getLblOrigin());
			getContentPane().add(getLblOriginValue());
			getContentPane().add(getLblAlcohol());
			getContentPane().add(getLblAlcoholValue());	
			getContentPane().add(getLabel());
	}
	
	private JComboBox<Beer> getComboBox(LinkedList<Beer> beers) {
		if (comboBox == null) {
			comboBox = new JComboBox<Beer>();
			comboBox.setBounds(36, 30, 215, 25);
			comboBox.removeAllItems();
			for (int i = 0; i < beers.size(); i++) {
				comboBox.addItem(beers.get(i));
			}
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Beer b = (Beer) comboBox.getSelectedItem();
					if	(b != null){
						lblNameValue.setText(b.getNaziv());
						lblAlcoholValue.setText(b.getAlkohol());
						lblBreveryValue.setText(b.getProizvodjac());
						lblOriginValue.setText(b.getZemlja());
						lblStyleValue.setText(b.getStil());

					try {
						if (b.getInfo() != null) {
							uri = new URI(b.getInfo());
							btnInfo.setToolTipText(uri.toString());
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					} else {
						System.out.println("Beer is null");
					}
				}
			});
		}
		return comboBox;
	}
	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Name:");
			lblName.setForeground(Color.WHITE);
			lblName.setBounds(41, 74, 46, 14);
		}
		return lblName;
	}
	private JLabel getLblStyle() {
		if (lblStyle == null) {
			lblStyle = new JLabel("Style:");
			lblStyle.setForeground(Color.WHITE);
			lblStyle.setBounds(41, 124, 46, 20);
		}
		return lblStyle;
	}
	private JLabel getLblNameValue() {
		if (lblNameValue == null) {
			lblNameValue = new JLabel("");
			lblNameValue.setForeground(Color.WHITE);
			lblNameValue.setBounds(89, 74, 215, 14);
		}
		return lblNameValue;
	}
	private JLabel getLblStyleValue() {
		if (lblStyleValue == null) {
			lblStyleValue = new JLabel("");
			lblStyleValue.setForeground(Color.WHITE);
			lblStyleValue.setBounds(89, 124, 305, 20);
		}
		return lblStyleValue;
	}
	private JLabel getLblBrewery() {
		if (lblBrewery == null) {
			lblBrewery = new JLabel("Brewery:");
			lblBrewery.setForeground(Color.WHITE);
			lblBrewery.setBounds(41, 155, 59, 14);
		}
		return lblBrewery;
	}
	private JLabel getLblBreveryValue() {
		if (lblBreveryValue == null) {
			lblBreveryValue = new JLabel("");
			lblBreveryValue.setForeground(Color.WHITE);
			lblBreveryValue.setBounds(41, 177, 316, 14);
		}
		return lblBreveryValue;
	}
	private JLabel getLblOrigin() {
		if (lblOrigin == null) {
			lblOrigin = new JLabel("Origin");
			lblOrigin.setForeground(Color.WHITE);
			lblOrigin.setBounds(41, 191, 46, 14);
		}
		return lblOrigin;
	}
	private JLabel getLblOriginValue() {
		if (lblOriginValue == null) {
			lblOriginValue = new JLabel("");
			lblOriginValue.setForeground(Color.WHITE);
			lblOriginValue.setBounds(89, 191, 87, 14);
		}
		return lblOriginValue;
	}
	private JLabel getLblAlcohol() {
		if (lblAlcohol == null) {
			lblAlcohol = new JLabel("Alcohol:");
			lblAlcohol.setForeground(Color.WHITE);
			lblAlcohol.setBounds(41, 99, 46, 14);
		}
		return lblAlcohol;
	}
	private JLabel getLblAlcoholValue() {
		if (lblAlcoholValue == null) {
			lblAlcoholValue = new JLabel("");
			lblAlcoholValue.setForeground(Color.WHITE);
			lblAlcoholValue.setBounds(89, 99, 215, 14);
		}
		return lblAlcoholValue;
	}
	
	private void open() {
		if (Desktop.isDesktopSupported() && uri != null) {
			try {
				Desktop.getDesktop().browse(uri);
			} catch (IOException e) { /* TODO: error handling */
				e.printStackTrace();
			}
		} else { /* TODO: error handling */
		}
	}
	private JButton getBtnInfo() {
		if (btnInfo == null) {
			btnInfo = new JButton("Find more information about this beer");
			btnInfo.setOpaque(false);
			btnInfo.setBorderPainted(false);
			btnInfo.setBackground(Color.WHITE);
			btnInfo.setHorizontalAlignment(SwingConstants.LEFT);
			btnInfo.setForeground(Color.BLUE);
			btnInfo.setFont(new Font("Verdana", Font.PLAIN, 14));
			btnInfo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					open();
				}
			});
			btnInfo.setBounds(41, 216, 337, 23);
		}
		return btnInfo;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setIcon(new ImageIcon(RecommandDialog.class.getResource("/img/beer2.jpg")));
			label.setBounds(0, 0, 394, 252);
		}
		return label;
	}
}
