import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @author Xenowar
 *
 */

public class GUI extends JFrame implements ActionListener,ChangeListener,KeyListener{
	JPanel mainpanel = new JPanel(new GridBagLayout());
	JPanel panel = new JPanel(new GridBagLayout());
	JPanel panel2 = new JPanel(new GridBagLayout());
	GridBagConstraints c = new GridBagConstraints();
	
	char[] asciitable = {'\u2718',
			'\u2718','\u2718','\u2718','\u2718','\u2718','\u2718','\u2718','\u2718','\u2718','\u2718','\u2718',
			'\u2718','\u2718','\u2718','\u2718','\u2718','\u2718','\u2718','\u2718','\u2718','\u2718','\u2718',
			'\u2718','\u2718','\u2718','\u2718','\u2718','\u2718','\u2718','\u2718','\u2718','\u2718','\u2718',
			'\u2718','\u2718','\u2718','\u2718','\u2718','\u2718','\u2718','\u2718','\u2718','\u2718','\u2718',
			'\u2718','\u2718','\u2718',
			'0','1','2','3','4','5','6','7','8','9',
			'\u2718','\u2718','\u2718','\u2718','\u2718','\u2718','\u2718',
			'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
			'\u2718','\u2718','\u2718','\u2718','\u2718','\u2718',
			'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'
	};
	
	String[] morse ={	
			".-",	//a
			"-...",	//b
			"-.-.",	//c
			"-..",	//d
			".",	//e
			"..-.",	//f
			"--.",	//g
			"....",	//h
			"..",	//i
			".---",	//j
			"-.-",	//k
			".-..",	//l
			"--",	//m
			"-.",	//n
			"---",	//o
			".--.",	//p
			"--.-",	//q
			".-.",	//r
			"...",	//s
			"-",	//t
			"..-",	//u
			"...-",	//v
			".--",	//w
			"-..-",	//x
			"-.--",	//y
			"--..",	//z	
			"-----",//0
			".----",//1
			"..---",//2	
			"...--",//3	
			"....-",//4	
			".....",//5	
			"-....",//6	
			"--...",//7	
			"---..",//8	
			"----."	//9	
	};
	String[] morseletters ={
		"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q",
		"R","S","T","U","V","W","X","Y","Z","0","1","2","3","4","5","6","7",
		"8","9"
	};
	
	JTextField tf_code = new JTextField();
	
	JTextField tf_reversed = new JTextField();
	JTextField tf_dectoasc = new JTextField();
	JTextField tf_zeros = new JTextField();
	JTextField tf_ones = new JTextField();
	JTextField tf_patttobin = new JTextField();
	JTextField tf_short = new JTextField();
	JTextField tf_long = new JTextField();
	JTextField tf_pattmorstoascii = new JTextField();
	JTextField tf_caesarian = new JTextField();
	JTextField tf_atbash = new JTextField();
	
	JTextField tf_vinegere = new JTextField();
	JTextField tf_vinegerepass = new JTextField();
	JTextField tf_lettertonumber = new JTextField();
	JTextField tf_l2n_start = new JTextField();
	
	JSlider sl_caesarian = new JSlider(JSlider.HORIZONTAL,0, 25,0);
	//JComboBox cb_caesarian = new JComboBox(caesar);
	JButton btn_generate = new JButton("Generate");
	JCheckBox alwaysontop = new JCheckBox("Always on top");
	JTabbedPane tabbedPane = new JTabbedPane();
	java.net.URL imgURL = getClass().getResource("/images/Ingress_Logo.png");
	ImageIcon icon =  new ImageIcon(imgURL);
	java.net.URL imgURL2 = getClass().getResource("/images/Ingress_Logo_Middle.png");
	ImageIcon icon2 =  new ImageIcon(imgURL);
	String mop = "";
	Font font = new Font(Font.MONOSPACED, Font.PLAIN, 12);
	
	public GUI(){
		tf_atbash.addKeyListener(this);
		setSize(new Dimension(780,565));
		setResizable(false);
		setTitle("Decoder");
		setIconImage(icon2.getImage());
		sl_caesarian.addChangeListener(this);
		sl_caesarian.setMajorTickSpacing(5);
		sl_caesarian.setMinorTickSpacing(1);
		sl_caesarian.setPaintTicks(true);
		sl_caesarian.setPaintLabels(true);
		btn_generate.addActionListener(this);
		alwaysontop.addActionListener(this);
		tf_code.addKeyListener(this);
		
		//fields that are not supposed to be editable are not anymore
		tf_reversed.setEditable(false);
	    tf_reversed.setEditable(false);
		tf_dectoasc.setEditable(false);
		tf_patttobin.setEditable(false);
		tf_pattmorstoascii .setEditable(false);
		tf_caesarian.setEditable(false);
		tf_atbash.setEditable(false);
		tf_vinegere.setEditable(false);
		tf_lettertonumber.setEditable(false);
		
		//set the font to monospaced
		tf_code.setFont(font);
		tf_reversed.setFont(font);
		tf_dectoasc.setFont(font);
		tf_zeros.setFont(font);
		tf_ones.setFont(font);
		tf_patttobin.setFont(font);
		tf_short.setFont(font);
		tf_long.setFont(font);
		tf_pattmorstoascii.setFont(font);
		tf_caesarian.setFont(font);
		tf_atbash.setFont(font);
		tf_vinegere.setFont(font);
		tf_vinegerepass.setFont(font);
		tf_lettertonumber.setFont(font);
		tf_l2n_start.setFont(font);
		
		add(mainpanel);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1.0;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(0,5,0,5);
		mainpanel.add(new JLabel("<html><b>Code</b></html>"),c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0;
		c.gridx = 1;
		c.gridy = 0;
		c.insets = new Insets(0,5,0,5);
		mainpanel.add(alwaysontop,c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1.0;
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 2;
		c.insets = new Insets(0,5,5,5);
		mainpanel.add(tf_code,c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1.0;
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 2;
		c.insets = new Insets(0,0,0,0);
		mainpanel.add(tabbedPane,c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1.0;
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 2;
		c.insets = new Insets(5,5,5,5);
		mainpanel.add(btn_generate,c);
		
		tabbedPane.addTab("Page 1 ", icon, panel,"Reversed, Decimal to Ascii, Pattern to Binary, Morse, Caesarian Shift, Atbash");
		tabbedPane.addTab("Page 2 ", icon, panel2,"Vigenere Cipher");
		//tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1.0;
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 4;
		c.insets = new Insets(0,5,0,5);
		panel.add(new JLabel("<html><b>Reversed</b></html>"),c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1.0;
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 4;
		c.insets = new Insets(0,5,5,5);
		panel.add(tf_reversed,c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1.0;
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 4;
		c.insets = new Insets(0,5,0,5);
		panel.add(new JLabel("<html><b>Decimal to Ascii</b></html>"),c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1.0;
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 4;
		c.insets = new Insets(0,5,5,5);
		panel.add(tf_dectoasc,c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1.0;
		c.gridx = 0;
		c.gridy = 6;
		c.gridwidth = 4;
		c.insets = new Insets(0,5,0,5);
		panel.add(new JLabel("<html><b>Pattern to binary</b></html>"),c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.02;
		c.gridx = 0;
		c.gridy = 7;
		c.gridwidth = 1;
		c.insets = new Insets(0,5,5,5);
		panel.add(new JLabel("0:"),c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.48;
		c.gridx = 1;
		c.gridy = 7;
		c.insets = new Insets(0,5,5,5);
		panel.add(tf_zeros,c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.02;
		c.gridx = 2;
		c.gridy = 7;
		c.insets = new Insets(0,5,5,5);
		panel.add(new JLabel("1:"),c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.48;
		c.gridx = 3;
		c.gridy = 7;
		c.insets = new Insets(0,5,5,5);
		panel.add(tf_ones,c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1.0;
		c.gridx = 0;
		c.gridy = 8;
		c.gridwidth = 4;
		c.insets = new Insets(0,5,5,5);
		panel.add(tf_patttobin,c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1.0;
		c.gridx = 0;
		c.gridy = 9;
		c.gridwidth = 4;
		c.insets = new Insets(0,5,0,5);
		panel.add(new JLabel("<html><b>Morsepattern to Ascii</b></html>"),c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.02;
		c.gridx = 0;
		c.gridy = 10;
		c.gridwidth = 1;
		c.insets = new Insets(0,5,5,5);
		panel.add(new JLabel("short:"),c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.48;
		c.gridx = 1;
		c.gridy = 10;
		c.insets = new Insets(0,5,5,5);
		panel.add(tf_short,c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.02;
		c.gridx = 2;
		c.gridy = 10;
		c.insets = new Insets(0,5,5,5);
		panel.add(new JLabel("long:"),c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.48;
		c.gridx = 3;
		c.gridy = 10;
		c.insets = new Insets(0,5,5,5);
		panel.add(tf_long,c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1.0;
		c.gridx = 0;
		c.gridy = 11;
		c.gridwidth = 4;
		c.insets = new Insets(0,5,5,5);
		panel.add(tf_pattmorstoascii,c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1.0;
		c.gridx = 0;
		c.gridy = 12;
		c.gridwidth = 4;
		c.insets = new Insets(0,5,0,5);
		panel.add(new JLabel("<html><b>Caesarian Shift</b></html>"),c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.05;
		c.gridx = 0;
		c.gridy = 13;
		c.insets = new Insets(0,5,2,5);
		panel.add(new JLabel("Shift:"),c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.1;
		c.gridx = 1;
		c.gridy = 13;
		c.insets = new Insets(0,5,2,5);
		panel.add(sl_caesarian,c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1.0;
		c.gridx = 0;
		c.gridy = 14;
		c.insets = new Insets(0,5,5,5);
		panel.add(tf_caesarian,c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 15;
		c.insets = new Insets(0,5,0,5);
		panel.add(new JLabel("<html><b>Atbash</b></html>"),c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1.0;
		c.gridx = 0;
		c.gridy = 16;
		c.insets = new Insets(0,5,3,5);
		panel.add(tf_atbash,c);
		
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1.0;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 4;
		c.insets = new Insets(0,5,0,5);
		panel2.add(new JLabel("<html><b>Vigenere Cipher</b></html>"),c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.05;
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.insets = new Insets(0,5,2,5);
		panel2.add(new JLabel("Passphrase:"),c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 3;
		c.insets = new Insets(0,5,2,5);
		panel2.add(tf_vinegerepass,c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 4;
		c.insets = new Insets(0,5,5,5);
		panel2.add(tf_vinegere,c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1.0;
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 4;
		c.insets = new Insets(0,5,0,5);
		panel2.add(new JLabel("<html><b>Letters to Numbers</b></html>"),c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.01;
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 1;
		c.insets = new Insets(0,5,2,5);
		panel2.add(new JLabel("a = "),c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth = 3;
		c.insets = new Insets(0,5,2,5);
		panel2.add(tf_l2n_start,c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 4;
		c.insets = new Insets(0,5,5,5);
		panel2.add(tf_lettertonumber,c);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource().equals(btn_generate)){
			reverse();
			patttobin();
			pattmorstoascii();
			caesarianShift();
			atbash();
			vinegere();
			lettertonumber();
			dectoasc();
		}
		else if(e.getSource().equals(alwaysontop)){
			if(alwaysontop.isSelected()){
				setAlwaysOnTop(true);
			}
			else{
				setAlwaysOnTop(false);
			}
		}
		
	}
	
	public void reverse(){
		char[] codeline = tf_code.getText().toCharArray();
		String reversed="";
		for(int i = codeline.length-1;i>=0;i--){
			reversed+=codeline[i];
		}
		tf_reversed.setText(reversed);
	}
	
	public void caesarianShift(){
		int shift = sl_caesarian.getValue();
		char[] codeline = tf_code.getText().toCharArray();
		String result = "";
		for(int i = 0;i < codeline.length;i++){
			if(codeline[i] >= 'a' && codeline[i] <= 'z'){
				if(codeline[i]+shift > 'z')
					codeline[i]= (char)(('a'-1)+((codeline[i]+shift)-'z'));
				else
					codeline[i]= (char)(codeline[i]+shift);
			}
			else if(codeline[i] >= 'A' && codeline[i] <= 'Z'){
				if(codeline[i]+shift > 'Z')
					codeline[i]= (char)(('A'-1)+((codeline[i]+shift)-'Z'));
				else
					codeline[i]= (char)(codeline[i]+shift);
			}
		}
		for(int i = 0; i < codeline.length;i++){
			result+= codeline[i];
		}
		tf_caesarian.setText(result);
	}
	
	public void dectoasc(){
		char[] codeline = removeSpaces(tf_code.getText()).toCharArray();
		boolean check = true;
		String solution="";
		
		for( int i=0;i< codeline.length;i++){
			if(codeline[i]<'0' || codeline[i] >'9')
				check=false;
		}
		
		if(check){
			String[] parted = new String[(int)((codeline.length+2)/3)];

			for(int i =0; i < parted.length;i++){
				parted[i]="";
			}
			for(int i = 0,j = 0; i < codeline.length;i++){
				if(i==0){
					parted[j]+=codeline[i];
				}
				else if(i%3==0){
					j++;
					parted[j]+=codeline[i];
				}
				else
					parted[j]+=codeline[i];
			}
	
			for(int i =0; i < parted.length;i++){
				if(Integer.parseInt(parted[i]) < 123){
					solution += asciitable[Integer.parseInt(parted[i])];
				}
				else
					solution += '\u2718';
			}
		}
		tf_dectoasc.setText(solution);
	}
	
	public void atbash(){
		char[] codeline = tf_code.getText().toCharArray();
		String result = "";
		for(int i = 0; i < codeline.length;i++){
			if(codeline[i]>='a' && codeline[i]<='z'){
				codeline[i]= (char)('z'-(codeline[i]-'a'));
			}
			else if(codeline[i]>='A' && codeline[i]<='Z'){
				codeline[i]= (char)('Z'-(codeline[i]-'A'));
			}
			result+= codeline[i];
		}
		tf_atbash.setText(result);

	}
	
	public void pattmorstoascii(){
		if(!tf_short.getText().equals("") || !tf_long.getText().equals("")){
			char[] dot = tf_short.getText().toCharArray();
			char[] line = tf_long.getText().toCharArray();
			char[] codeline = tf_code.getText().toCharArray();
			int spaces =0;
			String result = "";
			
			for(int i = 0; i < dot.length;i++){
				System.out.print(dot[i]);
			}
			System.out.println("");
			for(int i = 0; i < line.length;i++){
				System.out.print(line[i]);
			}
			System.out.println("");
			for(int i = 0; i < codeline.length;i++){
				System.out.print(codeline[i]);
			}
			System.out.println("");
			
			for(int i = 0; i < codeline.length; i++){
				for(int x =0; x< dot.length;x++){
					if(codeline[i]==dot[x])
						codeline[i]='\u00B7';
				}
				for(int x =0; x< line.length;x++){
					if(codeline[i]==line[x])
						codeline[i]='\u23AF';
				}
			}
			for(int i = 0; i < codeline.length;i++){
				System.out.print(codeline[i]);
			}
			System.out.println("");
			
			for(int i = 0; i < codeline.length; i++){
				if(codeline[i]=='\u00B7')
					codeline[i]='.';
				else if(codeline[i]=='\u23AF')
					codeline[i]='-';
				else 
					spaces++;
			}
			
			for(int i = 0; i < codeline.length;i++){
				System.out.print(codeline[i]);
			}
			System.out.println("");
			
			String[] parted = new String[spaces+1];
			parted[0]="";
			for(int i = 0,j=0;i < codeline.length;i++){
				if(codeline[i]!='.' && codeline[i]!='-'){
					j++;
					parted[j]="";
				}
				else
					parted[j]+=codeline[i];
			}
			
			for(int i = 0; i < parted.length;i++){
				System.out.print(parted[i]+" ");
			}
			System.out.println("");
			
			for(int i = 0; i < parted.length;i++){
				for(int j =0; j < morse.length;j++){
					if(parted[i].equals(morse[j])){
						result+=morseletters[j];
					}
				}
			}
			tf_pattmorstoascii.setText(result);
		}
	}
	
	public void patttobin(){
		if(!tf_zeros.getText().equals("") || !tf_ones.getText().equals("")){
			char[] zeros = tf_zeros.getText().toCharArray();
			char[] ones = tf_ones.getText().toCharArray();
			char[] codeline = tf_code.getText().toCharArray();
			String result = "";
			for(int i = 0; i < codeline.length; i++){
				boolean done = false;
				for(int x =0; x< zeros.length;x++){
					if(codeline[i]==zeros[x]){
						codeline[i]='0';
						done= true;
						break;
					}
				}
				if(!done){
					for(int x =0; x< ones.length;x++){
						if(codeline[i]==ones[x]){
							codeline[i]='1';
							break;
						}
					}
				}
			}
			for(int i = 0; i< codeline.length;i++){
				result+= codeline[i];
			}
			tf_patttobin.setText(result);
		}
	}
	
	public void vinegere(){
		char[] passcode;
		if(!tf_vinegerepass.getText().equals(""))
			 passcode = tf_vinegerepass.getText().toCharArray();
		else{
			passcode = new char[1];
			passcode[0]= 'a';
		}
		char[] codeline = tf_code.getText().toCharArray();
		String result = "";
		for(int i = 0,j=0;i < codeline.length;i++){
			if(codeline[i] >= 'a' && codeline[i] <= 'z'){
				if((codeline[i]-Character.toLowerCase(passcode[j])) +'a'< 'a'){
					codeline[i]= (char)(('z'+1)+(codeline[i]-Character.toLowerCase(passcode[j])));
				}
				else
					codeline[i]= (char)(codeline[i]-(Character.toLowerCase(passcode[j])-'a'));
			}
			else if(codeline[i] >= 'A' && codeline[i] <= 'Z'){
				if((codeline[i]-Character.toUpperCase(passcode[j])) +'A'< 'A'){
					codeline[i]= (char)(('Z'+1)+(codeline[i]-Character.toUpperCase(passcode[j])));
				}
				else
					codeline[i]= (char)(codeline[i]-(Character.toUpperCase(passcode[j])-'A'));
			}
			if(j==passcode.length-1){
				j=0;
			}
			else{
				j++;
			}
		}
		for(int i = 0; i < codeline.length;i++){
			result+= codeline[i];
		}
		tf_vinegere.setText(result);
		
	}
	
	public void lettertonumber(){
		char[] codeline = tf_code.getText().toCharArray();
		int start = Integer.parseInt(tf_l2n_start.getText());
		String result ="";
		for(int i = 0; i<codeline.length;i++){
			if( Character.toLowerCase(codeline[i]) >= 'a' && Character.toLowerCase(codeline[i]) <= 'z')
				result += (Character.toLowerCase(codeline[i])-'a')+start;
		}
		tf_lettertonumber.setText(result);
	}
	
	public String removeSpaces(String input){
		char[] withSpace = input.toCharArray();
		input="";
		for(int i = 0; i < withSpace.length;i++){
			if(withSpace[i]!=' '){
				input+=withSpace[i];
			}
		}
		return input;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(sl_caesarian)){
			caesarianShift();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(mop.equals("mo")){
			if(e.getKeyCode()==KeyEvent.VK_P)
				mop+="p";
			else
				mop="";
		}
		else if(mop.equals("m")){
			if(e.getKeyCode()==KeyEvent.VK_O)
				mop+="o";
			else
				mop="";
		}
		else if(e.getKeyCode()==KeyEvent.VK_M){
			mop+="m";
			System.out.println("m");
		}
			
		if(mop.equals("mop"))
			setResizable(true);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
