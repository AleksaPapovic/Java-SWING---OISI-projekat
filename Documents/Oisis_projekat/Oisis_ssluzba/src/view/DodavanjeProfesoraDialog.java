package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.DocumentListener;

import controller.DocumentListenerProfesorFields;
import controller.ProfesorController;
import view.FocusField.TipPolja;

public class DodavanjeProfesoraDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static FocusField imeField;
	public static FocusField prezimeField;
	public static FocusField datumRField;
	public static FocusField adresaSField;
	public static FocusField kontaktTelField;
	public static FocusField emailField;
	public static FocusField adresaKField;
	public static FocusField brlkField;
	public static JComboBox<String> combobox1;
	public static JComboBox<String> combobox2;
	public static JButton prihvati;
	private DocumentListener docList = new DocumentListenerProfesorFields();

	public DodavanjeProfesoraDialog(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
		setTitle(title);
		setSize(450, 550);
		setLocationRelativeTo(parent);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JPanel textPanel = new JPanel(new GridLayout(11, 1, 1, 10));
		JPanel buttonsPanel = new JPanel(new GridLayout(1, 2, 20, 20));

		textPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		buttonsPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		Dimension polje = new Dimension(100, 30);

		JLabel imeLabela = new JLabel("Unesite ime");
		imeLabela.setPreferredSize(polje);
		imeLabela.setMaximumSize(polje);
		imeField = new FocusField(TipPolja.Ime, "Ime");

		JLabel prezimeLabela = new JLabel("Unesite prezime");
		prezimeLabela.setPreferredSize(polje);
		prezimeLabela.setMaximumSize(polje);
		prezimeField = new FocusField(TipPolja.Prezime, "Prezime");

		JLabel datumRLabela = new JLabel("Unesite datum rodjenja");
		datumRLabela.setPreferredSize(polje);
		datumRLabela.setMaximumSize(polje);
		datumRField = new FocusField(TipPolja.DatumR, "dd.mm.yyyy.");

		JLabel adresaSLabela = new JLabel("Unesite adresu stanovanja");
		adresaSLabela.setPreferredSize(polje);
		adresaSLabela.setMaximumSize(polje);
		adresaSField = new FocusField(TipPolja.AdresaS, "...");

		JLabel kontaktTelLabela = new JLabel("Unesite kontakt telefon");
		kontaktTelLabela.setPreferredSize(polje);
		kontaktTelLabela.setMaximumSize(polje);
		kontaktTelField = new FocusField(TipPolja.BrojTel, "9 ili vise  brojeva");

		JLabel emailLabela = new JLabel("Unesite email");
		emailLabela.setPreferredSize(polje);
		emailLabela.setMaximumSize(polje);
		emailField = new FocusField(TipPolja.Email, "...@...");

		JLabel adresaKLabela = new JLabel("Unesite adresu kancelarije");
		adresaKLabela.setPreferredSize(polje);
		adresaKLabela.setMaximumSize(polje);
		adresaKField = new FocusField(TipPolja.AdresaK, "...");

		JLabel brlkLabela = new JLabel("Unesite broj lične karte");
		brlkLabela.setPreferredSize(polje);
		brlkLabela.setMaximumSize(polje);
		brlkField = new FocusField(TipPolja.BrojLK, "mora imati 9 brojeva");

		JLabel titulaLabela = new JLabel("Izaberite titulu");
		titulaLabela.setPreferredSize(polje);
		titulaLabela.setMaximumSize(polje);
		String titule[] = { "Master", "Doktor", "Profesor doktor" };
		combobox1 = new JComboBox<String>(titule);

		JLabel zvanjeLabela = new JLabel("Izaberite zvanje");
		zvanjeLabela.setPreferredSize(polje);
		zvanjeLabela.setMaximumSize(polje);
		String zvanja[] = { "Saradnik", "Asistent", "Redovni Profesor", "Vanredni Profesor", "Docent" };
		combobox2 = new JComboBox<String>(zvanja);

		prihvati = new JButton("Potvrdi");
		prihvati.setPreferredSize(polje);
		prihvati.setEnabled(false);
		JButton odbaci = new JButton("Odustani");
		odbaci.setPreferredSize(polje);

		prihvati.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (ProfesorController.getInstance().dodatiProfesora())
					dispose();

			}
		});

		odbaci.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}
		});

		imeField.getDocument().addDocumentListener(docList);
		prezimeField.getDocument().addDocumentListener(docList);
		datumRField.getDocument().addDocumentListener(docList);
		adresaSField.getDocument().addDocumentListener(docList);
		kontaktTelField.getDocument().addDocumentListener(docList);
		emailField.getDocument().addDocumentListener(docList);
		adresaKField.getDocument().addDocumentListener(docList);
		brlkField.getDocument().addDocumentListener(docList);

		add(panel);

		panel.add(textPanel, BorderLayout.NORTH);
		panel.add(buttonsPanel, BorderLayout.CENTER);

		textPanel.add(imeLabela);
		textPanel.add(imeField);
		textPanel.add(prezimeLabela);
		textPanel.add(prezimeField);
		textPanel.add(datumRLabela);
		textPanel.add(datumRField);
		textPanel.add(adresaSLabela);
		textPanel.add(adresaSField);
		textPanel.add(kontaktTelLabela);
		textPanel.add(kontaktTelField);
		textPanel.add(emailLabela);
		textPanel.add(emailField);
		textPanel.add(adresaKLabela);
		textPanel.add(adresaKField);
		textPanel.add(brlkLabela);
		textPanel.add(brlkField);
		textPanel.add(titulaLabela);
		textPanel.add(combobox1);
		textPanel.add(zvanjeLabela);
		textPanel.add(combobox2);

		buttonsPanel.add(prihvati);
		buttonsPanel.add(odbaci);

		setVisible(true);
	}
}
