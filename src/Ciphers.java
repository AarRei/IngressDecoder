
public class Ciphers {

	static char[] asciitable = {'\u2718',
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
	
	static String[] morse ={	
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
	
	static String[] morseletters ={
		"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q",
		"R","S","T","U","V","W","X","Y","Z","0","1","2","3","4","5","6","7",
		"8","9"
	};
	
	public static String reverse(String code){
		char[] codeline = code.toCharArray();
		String reversed="";
		for(int i = codeline.length-1;i>=0;i--){
			reversed+=codeline[i];
		}
		return reversed;
	}
	
	public static String caesarianShift(String code, int shift){
		char[] codeline = code.toCharArray();
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
		return result;
	}
	
	public static String dectoasc(String code){
		char[] codeline = removeSpaces(code).toCharArray();
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
		return solution;
	}
	
	public static String atbash(String code){
		char[] codeline = code.toCharArray();
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
		return result;

	}
	
	public static String pattmorstoascii(String code, String shorts, String longs){
		if(!shorts.equals("") || !longs.equals("")){
			char[] dot = shorts.toCharArray();
			char[] line = longs.toCharArray();
			char[] codeline = code.toCharArray();
			int spaces =0;
			String result = "";
			
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
			
			for(int i = 0; i < codeline.length; i++){
				if(codeline[i]=='\u00B7')
					codeline[i]='.';
				else if(codeline[i]=='\u23AF')
					codeline[i]='-';
				else 
					spaces++;
			}
			
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
				for(int j =0; j < morse.length;j++){
					if(parted[i].equals(morse[j])){
						result+=morseletters[j];
					}
				}
			}
			return result;
		}
		return "";
	}
	
	public static String patttobin(String code, String zero, String one){
		if(!zero.equals("") || !one.equals("")){
			char[] zeros = zero.toCharArray();
			char[] ones = one.toCharArray();
			char[] codeline = code.toCharArray();
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
			return result;
		}
		return "";
	}
	
	public static String vinegere(String code, String pass){
		char[] passcode;
		if(!pass.equals(""))
			 passcode = pass.toCharArray();
		else{
			passcode = new char[1];
			passcode[0]= 'a';
		}
		char[] codeline = code.toCharArray();
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
		return result;
		
	}
	
	public static String lettertonumber(String code, int start){
		char[] codeline = code.toCharArray();
		String result ="";
		for(int i = 0; i<codeline.length;i++){
			if( Character.toLowerCase(codeline[i]) >= 'a' && Character.toLowerCase(codeline[i]) <= 'z')
				result += (Character.toLowerCase(codeline[i])-'a')+start;
		}
		return result;
	}
	
	private static String removeSpaces(String input){
		char[] withSpace = input.toCharArray();
		input="";
		for(int i = 0; i < withSpace.length;i++){
			if(withSpace[i]!=' '){
				input+=withSpace[i];
			}
		}
		return input;
	}

}
