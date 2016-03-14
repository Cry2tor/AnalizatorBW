package bw;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class GUI extends JFrame implements ActionListener {
	
	private int licznik;
	private static int width;
	private static int height;
	private static String textLine;
	private JButton sprawdz;
	private JButton dodaj;
	private String prefIt1 = null;
	private String prefIt2 = null;
	private String nazwaIt1 = null;
	private String nazwaIt2 = null;
	private String suffIt1 = null;
	private String suffIt2 = null;
	private static String token1 = "";

	private static String[][] kombinacjeHelm;
	private static String[] preff;
	private static String[] nazwa;
	private static String[] suff;
	
	public String[] itemek = {"Wybierz","Hełmy", "Zbroje", "Amulety", "Pierścienie", 
							"Spodnie","Bronie dwuręczne", "Bronie dystansowe dwuręczne",
							"Bronie jednoręczne", "Bronie palne dwuręczne",
							"Bronie palne jednoręczne"};
	public String[] helm = {"Brak","Śmiercionośny", "Bojowy","Elegancki","Krwawy",
							"Kuloodporny","Kunsztowny","Leniwy","Magnetyczny",
							"Ozdobny","Pomocny","Rogaty","Runiczny","Rytualny",
							"Szamański","Szturmowy","Tygrysi","Utwardzony",
							"Wzmocniony","Złośliwy"};
	public String[] rodzajHelmu = {"Brak","Bandana","Czapka","Hełm","Kapelusz","Kask",
							"Kominiarka","Korona","Maska","Obręcz","Opaska"};
	public String[] suffHelmu = {"Brak","Adrenaliny"};
	public String[] zbroja = {"Brak","Ćwiekowana","Łowiecka","Łuskowa","Śmiercionośna",
							"Bojowa","Elfia","Giętka","Krwawa","Kuloodporna",
							"Lekka","Płytowa","Runiczna","Szamańska","Tygrysia",
							"Władcza","Wzmocniana"};
	public String[] rodzajZbroi = {"Brak","Gorset","Kamizelka","Kolczuga","Kamizelka",
							"Kurtka","Marynarka","Pełna Zbroja","Peleryna","Smoking",
							"Zbroja Warstwowa"};
	public String[] suffZbroi = {"Brak","Adepta","Adreanaliny","Centuriona",
							"Grabieżcy","Gwardzisty","Kaliguli","Kobry","Mistrza",
							"Narkomana","Odporności","Orchidei","Siłacza",
							"Siewcy śmierci","Skorupy żółwia","Strażnika","Szermierza",
							"Szybkości","Uników","Złodzieja","Zabójcy"};
	public String[] preffixSpodnie = {"Aksamitny","Elfi","Giętki","Kolczy",
							"Kompozytowy","Krwawy","Krótki","Kuloodporny","Lekki",
							"Pancerny","Pikowany","Runiczny","Szamański","Tygrysi",
							"Wzmocniony","Ćwiekowany","Śmiercionośny"};
	public String[] rodzajSpodnie = {"Kilt","Spodnie","Spódnica","Szorty"};
	public String[] suffixSpodnie={"Cichych Ruchów","Handlarza Bronią","Inków",
							"Narkomana","Nocy","Pasterza","Przemytnika","Rzezimieszka",
							"Siłacza","Skrytości","Słońca","Tropiciela","Uników",
							"Węża","Łowcy Cieni"};
	public String[] preffixPierscien={"Archaiczny","Czarny","Diamentowy","Dystyngowany",
							"Elastyczny","Gwiezdny","Hipnotyczny","Jastrzębi",
							"Kardynalski","Miedziany","Mściwy","Nekromancki",
							"Niedzwiedzi","Pajęczy","Plastikowy","Platynowy",
							"Przebiegły","Rubinowy","Spaczony","Srebny","Szmaragdowy",
							"Słoneczny","Tańczący","Twardy","Tytanowy","Zdradziecki",
							"Zwierzęcy","Złoty"};
	public String[] rodzajPierscien={"Bransoleta","Pierścień","Sygnet"};
	public String[] suffixPierscien={"Celności","Geniuszu","Koncentracaji","Krwi",
							"Lewitacji","Lisa","Mądrości","Młodości","Przebiegłości",
							"Siły","Szaleńca","Szczęścia","Sztuki","Twardej Skóry",
							"Urody","Wilkołaka","Występku","Władzy","Łatwości"};
	public String[] preffixAmulet={"Archaiczny","Czarny","Diamentowy","Dystyngowany",
							"Elastyczny","Gwiezdny","Hipnotyczny","Jastrzębi",
							"Kardynalski","Miedziany","Mściwy","Nekromancki",
							"Niedzwiedzi","Pajęczy","Plastikowy","Platynowy",
							"Przebiegły","Rubinowy","Spaczony","Srebny",
							"Szmaragdowy","Słoneczny","Tańczący","Twardy","Tytanowy",
							"Zdradziecki","Zwierzęcy","Złoty"};
	public String[] rodzajAmulet={"Amulet","Apaszka","Krawat","Naszyjnik","Łańuch"};
	public String[] suffixAmulet={"Celności","Geniuszu","Koncentracaji","Krwi",
							"Lewitacji","Mądrości","Młodości","Pielgrzyma",
							"Przebiegłości","Siły","Szaleńca","Szczęścia","Sztuki",
							"Twardej Skóry","Urody","Wilkołaka","Występku","Władzy",
							"Zdolności","Łatwości"};
	public String[] preffixBiala1h={"Antyczny","Demoniczny","Jadowity","Kościany",
							"Kryształowy","Kąsający","Lekki","Mistyczny","Okrutny",
							"Opiekuńczy","Ostry","Przeklęty","Przyjacielski",
							"Szybki","Wzmacniający","Zabójczy","Zatruty","Zwinny",
							"Zębaty","Świecący"};
	public String[]rodzajBiala1h={"Kama","Kastet","Miecz","Nóż","Pałka",
							"Pięść Niebios","Rapier","Sztylet","Topór","Wakizashi"};
	public String[] suffixBiala1h={"Biegłości","Bólu","Dowódcy","Drakuli",
							"Imperatora","Klanu","Kontuzji","Krwi","Mocy","Męstwa",
							"Odwagi","Podkowy","Precyzji","Przodków","Samobójcy",
							"Sekty","Trafienia","Władzy","Zarazy","Zdobywcy",
							"Zemsty","Zwinności"};
	public String[] preffixBiala2h={"Antyczny","Ciężki","Demoniczny","Jadowity",
							"Kosztowny","Kryształowy","Kąsający","Lekki","Mistyczny",
							"Napromieniowany","Okrutny","Opiekuńczy","Ostry",
							"Przeklęty","Szeroki","Wzmacniający","Zabójczy","Zatruty",
							"Zwinny","Zębaty","Świecący"};
	public String[] rodzajBiala2h={"Halabarda","Katana","Korbacz","Kosa","Maczuga",
							"Miecz dwuręczny","Pika","Piła łańcuchowa",
							"Topór dwuręczny","łom"};
	public String[] suffixBiala2h={"Autokraty","Bazyliszka","Bólu","Drakuli",
							"Hazardzisty","Inkwizytora","Krwi","Krwiopijcy","Mocy",
							"Ołowiu","Podkowy","Podstępu","Samobójcy","Władzy",
							"Zarazy","Zdobywcy","Zdrady","Zemsty"};
	public String[] rodzajPalna1h={"Beretta","Desert Eagle","Glock","Magnum","Mp5k",
							"Skorpion","Uzi"};
	public String[] rodzajPalna2h={"AK-47","Fn-Fal","Karabin myśliwski",
							"Karabin snajperski","Miotacz płomieni",
							"Półautomat snajperski","Strzelba"};
	public String[] rodzajDystans={"Ciężka kusza","Długi łuk","Krótki łuk","Kusza",
							"Nóż do rzucania","Oszczep","Pilum","Shuriken",
							"Toporek do rzucania","Łuk","Łuk refleksyjny"};
	public String[] suffixDystans={"Dalekiego zasięgu","Doskonałości","Driady",
							"Precyzji","Reakcji","Szybkostrzelności","Wilka","Zemsty"};
			
	private JPanel panel;
	private JPanel panelOne;
	private JPanel panelSecond;
	private JPanel panelThrid;
	
	private JTextArea wejsciepreff;
	private JTextArea wejscienazwa;
	private JTextArea wejsciesuff;
	private JTextArea wyjsciepreff;
	private JTextArea wyjscienazwa;
	private JTextArea wyjsciesuff;
	private JTextField preffItem;
	JComboBox rodzajItemka = new JComboBox(itemek);
	JComboBox prefix_itemka = new JComboBox();
	JComboBox preffix_itemka2 = new JComboBox();
	JComboBox nazwa_itemka = new JComboBox();
	JComboBox nazwa_itemka2 = new JComboBox();
	JComboBox suffix_itemka = new JComboBox();
	JComboBox suffix_itemka2 = new JComboBox();
	JComboBox JChelm = new JComboBox(helm);
	JComboBox JCzbroja = new JComboBox(zbroja);
	
	GUI()
	{
		setTitle("Analizator");
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(d.width, d.height);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = (JPanel) getContentPane();
		panel.setLayout(new GridLayout(1,3,3,3));
		panelOne = createPanelOne();
		panelSecond = createPanelSecond();
		panelThrid = createPanelThrid();
		panel.add(panelSecond);
		panel.add(panelOne);
		panel.add(panelThrid);
	}
	
	public JPanel createPanelOne(){
		panelOne = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		sprawdz = new JButton("Sprawdz");
		dodaj = new JButton("Dodaj");
		dodaj.addActionListener(this);
		sprawdz.addActionListener(this);
		rodzajItemka.setSelectedIndex(0);
		rodzajItemka.addActionListener(this);
		
		c.gridx = 1;
		c.gridy = 0;
		panelOne.add(rodzajItemka, c);
		
		c.gridx = 0;
		c.gridy = 1;
		panelOne.add(prefix_itemka, c);
		
		
		c.gridx = 1;
		c.gridy = 1;
		panelOne.add(nazwa_itemka, c);
		
		
		c.gridx = 2;
		c.gridy = 1;
		panelOne.add(suffix_itemka, c);
		
		
		c.gridx = 1;
		c.gridy = 4;
		panelOne.add(sprawdz, c);
		
		c.gridx = 0;
		c.gridy = 4;
		panelOne.add(dodaj, c);
		
		
		return panelOne;	
	}
	
	public JPanel createPanelSecond(){
		panelSecond = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		Border line = BorderFactory.createLineBorder(Color.BLACK);
		Border titled = BorderFactory.createTitledBorder(line, "Wejście: ");
		panelSecond.setBorder(titled);
		panelSecond.setBackground(Color.RED);
		
		wejsciepreff = new JTextArea(40,10);
		wejsciepreff.setBorder(line);
		wejsciepreff.setEditable(false);
		c.gridx = 0;
		panelSecond.add(wejsciepreff, c);
		
		wejscienazwa = new JTextArea(40,10);
		wejscienazwa.setBorder(line);
		wejscienazwa.setEditable(false);
		c.gridx = 1;
		panelSecond.add(wejscienazwa, c);
		
		wejsciesuff = new JTextArea(40,10);
		wejsciesuff.setBorder(line);
		wejsciesuff.setEditable(false);
		c.gridx = 2;
		panelSecond.add(wejsciesuff, c);
		
		return panelSecond;
	}
	
	public JPanel createPanelThrid(){
		panelThrid = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		Border line = BorderFactory.createLineBorder(Color.BLACK);
		Border titled = BorderFactory.createTitledBorder(line, "Wyjście: ");
		panelThrid.setBorder(titled);
		panelThrid.setBackground(Color.RED);
		
		wyjsciepreff = new JTextArea(40,10);
		wyjsciepreff.setBorder(line);
		wyjsciepreff.setEditable(false);
		c.gridx = 0;
		panelThrid.add(wyjsciepreff, c);
		
		wyjscienazwa = new JTextArea(40,10);
		wyjscienazwa.setBorder(line);
		wyjscienazwa.setEditable(false);
		c.gridx = 1;
		panelThrid.add(wyjscienazwa, c);
		
		wyjsciesuff = new JTextArea(40,10);
		wyjsciesuff.setBorder(line);
		wyjsciesuff.setEditable(false);
		c.gridx = 2;
		panelThrid.add(wyjsciesuff, c);
		
		
		return panelThrid;
	}
	
	public JComboBox prefixItemka(JComboBox box,String[] nazwa)
	{
		return getDefaultComboBoxModel(box, nazwa);
	}
	
	public JComboBox nazwaItemka(JComboBox box, String[] nazwa)
	{
		return getDefaultComboBoxModel(box, nazwa);
	}
	
	public JComboBox suffixItemka(JComboBox box, String[] nazwa)
	{
		return getDefaultComboBoxModel(box, nazwa);
	}

	private JComboBox getDefaultComboBoxModel(JComboBox box, String[] nazwa) {
		DefaultComboBoxModel model = new DefaultComboBoxModel( nazwa );
		box.setModel( model );
		return box;
	}

	public void actionPerformed(ActionEvent e) {
		Silnik silnik = new Silnik();
		if(e.getSource() == rodzajItemka)
		{
			String itemek = (String) rodzajItemka.getSelectedItem();
			
			switch(itemek)
			{
			case "Hełmy" : prefix_itemka = prefixItemka(prefix_itemka,helm);
							preffix_itemka2 = prefixItemka(preffix_itemka2,helm);
							nazwa_itemka = nazwaItemka(nazwa_itemka,rodzajHelmu);
							nazwa_itemka2 = nazwaItemka(nazwa_itemka2,rodzajHelmu);
							suffix_itemka = suffixItemka(suffix_itemka,suffHelmu);
							suffix_itemka2 = suffixItemka(suffix_itemka2,suffHelmu);
							break;
			case "Zbroje" : prefix_itemka = prefixItemka(prefix_itemka,zbroja);
							nazwa_itemka = nazwaItemka(nazwa_itemka,rodzajZbroi);
							suffix_itemka = suffixItemka(suffix_itemka,suffZbroi);
							break;
			case "Amulety" :prefix_itemka = prefixItemka(prefix_itemka,preffixAmulet);
							nazwa_itemka = nazwaItemka(nazwa_itemka,rodzajAmulet);
							suffix_itemka = suffixItemka(suffix_itemka,suffixAmulet);
							break;
			case "Pierścienie" : prefix_itemka = prefixItemka(prefix_itemka,preffixPierscien);
							nazwa_itemka = nazwaItemka(nazwa_itemka,rodzajPierscien);
							suffix_itemka = suffixItemka(suffix_itemka,suffixPierscien);
							break;
			case "Spodnie": prefix_itemka = prefixItemka(prefix_itemka,preffixSpodnie);
							nazwa_itemka = nazwaItemka(nazwa_itemka,rodzajSpodnie);
							suffix_itemka = suffixItemka(suffix_itemka,suffixSpodnie);
							break;
			case "Bronie dwuręczne" : prefix_itemka = prefixItemka(prefix_itemka,preffixBiala2h);
							nazwa_itemka = nazwaItemka(nazwa_itemka,rodzajBiala2h);
							suffix_itemka = suffixItemka(suffix_itemka,suffixBiala2h);
							break;
			case "Bronie dystansowe dwuręczne" :
							nazwa_itemka = nazwaItemka(nazwa_itemka,rodzajDystans);
							suffix_itemka = suffixItemka(suffix_itemka,suffixDystans); 
							break;
			case "Bronie jednoręczne" :
							prefix_itemka = prefixItemka(prefix_itemka,preffixBiala1h);
							nazwa_itemka = nazwaItemka(nazwa_itemka,rodzajBiala1h);
							suffix_itemka = suffixItemka(suffix_itemka,suffixBiala1h);
							break;
			case "Bronie palne dwuręczne" :
							nazwa_itemka = nazwaItemka(nazwa_itemka,rodzajPalna2h);
							break;
			case "Bronie palne jednoręczne" : 
							nazwa_itemka = nazwaItemka(nazwa_itemka,rodzajPalna1h);
							break;
			
			default:
				JChelm.setVisible(false);
				JCzbroja.setVisible(false);
			}
		}
		if(e.getSource() == dodaj){
			prefIt1 =(String) prefix_itemka.getSelectedItem();
			
			nazwaIt1 = (String) nazwa_itemka.getSelectedItem();
		
			suffIt1 = (String) suffix_itemka.getSelectedItem();
			
			token1 = wejsciepreff.getText();
			wejsciepreff.setText(token1 + "\n + \n" + prefIt1);
			token1 = wejscienazwa.getText();
			wejscienazwa.setText(token1 + "\n + \n" + nazwaIt1);
			token1 = wejsciesuff.getText();
			wejsciesuff.setText(token1 + "\n + \n" + suffIt1);
			licznik = licznik + 1;	
		}
		if(e.getSource() == sprawdz){
			
				try{	
						kombinacjeHelm = silnik.getValue(kombinacjeHelm);
					}catch(Exception e2){
						System.out.println("blad");
					}
					
					for(int i = 0; i <= 10; i++){
						String value = kombinacjeHelm[i][0];
						System.out.println(value);
					}
					
					String text = silnik.getItem(kombinacjeHelm,prefIt2,prefIt1);
					preffItem.setText(text);
		}
	}

}