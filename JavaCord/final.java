package main;
import java.lang.*;
import java.util.*;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.io.*;
import javax.sound.sampled.*;  

// e1 class : 마타하리암호(author : 차수환)
// e2 class : 카이사르암호(author : 성현우)
// e3 class : 전치형암호(author : 맹성호)
// e4 class : 스키테일암호(author : 성현우)
// e5 class : 모스부호(author : 맹성호)
// main class : 모든 소스를 합침(author : 차수환)
// 각자의 소스코드에서 웹사이트로 연결하기 위해 일부 소스코드를 임의로 수정하였음(수정자 : 차수환)

class e1{
class encoder{
	public String encode(String E){
		Map<String, String> map = new HashMap<String, String>();
		map.put("a", "83G83G");
		map.put("b", "43G000");
		map.put("c", "84G84G");
		map.put("d", "84E83E");
		map.put("e", "43G000");
		map.put("f", "83A83A");
		map.put("g", "43G000");
		map.put("h", "43B000");
		map.put("i", "83D83E");
		map.put("j", "83B84C");
		map.put("k", "83B83B");
		map.put("l", "43E000");
		map.put("m", "43F000");
		map.put("n", "24E000");
		map.put("o", "83G84D");
		map.put("p", "44F000");
		map.put("q", "84E84F");
		map.put("r", "44E000");
		map.put("s", "83A84C");
		map.put("t", "44A000");
		map.put("u", "43E000");
		map.put("v", "83E83A");
		map.put("w", "43C000");
		map.put("x", "84C84E");
		map.put("y", "83B84D");
		map.put("z", "83C83F");
		E = E.toLowerCase();
		return map.get(E);
	}
}

static class decode{
	public static Object decode(String s){
		Map<String, String> map = new HashMap<String, String>();
		map.put("a", "83G83G");
		map.put("b", "43G000");
		map.put("c", "84G84G");
		map.put("d", "84E83E");
		map.put("e", "43G000");
		map.put("f", "83A83A");
		map.put("g", "43G000");
		map.put("h", "43B000");
		map.put("i", "83D83E");
		map.put("j", "83B84C");
		map.put("k", "83B83B");
		map.put("l", "43E000");
		map.put("m", "43F000");
		map.put("n", "24E000");
		map.put("o", "83G84D");
		map.put("p", "44F000");
		map.put("q", "84E84F");
		map.put("r", "44E000");
		map.put("s", "83A84C");
		map.put("t", "44A000");
		map.put("u", "43E000");
		map.put("v", "83E83A");
		map.put("w", "43C000");
		map.put("x", "84C84E");
		map.put("y", "83B84D");
		map.put("z", "83C83F");
		for (Object o : map.keySet()) {
		    if (map.get(o).equals(s)) {
		        return o;
		     }
		   }
		System.out.println("Check your input");
		return "";
	}
}

class setting{
	private String token;
	public int mod;
	private String key;
	private char[] charArray;
	private String[] stringArray;
	
	public setting(){
		Scanner scan = new Scanner(System.in);
		System.out.println("JAVA ANALOG/DIGITAL CIPHER PROGRAM\n");
		System.out.println("1. Encoder\t2. Decoder");
		this.mod = scan.nextInt();
		
		System.out.println("Type text");
		this.key = scan.next();
		
		if(this.mod == 1)
			this.charArray = this.key.toCharArray();
		else if(this.mod == 2){
//			TODO
			if(this.key.length() % 6 != 0){
				System.out.println("Check your input Length");
				System.exit(0);
			}else{
				int count = this.key.length() / 6;
				this.stringArray = new String[count];
				for(int i = 1; i<=count; i++){
					int start = (i-1)*6;
					int end = (i)*6;
					this.stringArray[i-1] = this.key.substring(start,end);
				}
			}
		}
	}
	public char[] GetCharKey(){
		return this.charArray;
	}
	public String[] getstrArray(){
		return this.stringArray;
	}
}

class main {
	public String temp = "";
	public Object[] key;
	
	public void main() throws IOException, URISyntaxException {
		decode decoder = new decode();
		encoder encoder = new encoder();
		setting main = new setting();
		char[] toEncode = main.GetCharKey();
		if(main.mod == 1){
			for(char val : toEncode){
				String c = "";
				c = new Character(val).toString();
				temp += (encoder.encode(c));
			}
			Desktop.getDesktop().browse(new URI("https://java.gdb.kr/?type=en&method=1&text="+temp));
		}else if(main.mod == 2){
			String str[] = main.getstrArray();
			key = new Object[str.length];
			for(int i = 0; i< str.length; i++){
				temp += String.format("%s", decode.decode(str[i]));
			}
			Desktop.getDesktop().browse(new URI("https://java.gdb.kr/?type=de&method=1&text="+temp));
		}

	}

}

}

class e2{
	class Caesar {
		public void main() throws IOException, URISyntaxException {
			Scanner sc = new Scanner(System.in);
			Hangul han = new Hangul();
			English eng = new English();
			int key = (int) (Math.random()*20) + 5;
			int hankey = (int) (Math.random()*25) + 50;
			System.out.println("JAVA ANALOG/DIGITAL CIPHER PROGRAM : TYPE CAESAR");
			System.out.println("Type the Cipher Service & Language of Your Sentenses.");
			System.out.println("1. English Cipher   2. English DeCipher");
			System.out.println("3. 한글 암호화                        4. 한글 복호화\n");
			int flag = sc.nextInt();
			switch (flag) {
			case 1:
				eng.ci(key);
				break;
			case 2:
				System.out.print("Type the Key Value : ");
				key = sc.nextInt();
				eng.deci(key);
				break;
			case 3:
				han.ci(hankey);
				break;
			case 4:
				System.out.print("Type the Key Value : ");
				hankey = sc.nextInt();
				han.deci(hankey);
				break;
			default:
				System.out.println("Wrong Answer!");	
			}
		}
	}
	class English {
		protected void ci(int key) throws IOException, URISyntaxException {
			String temp = "";
			Scanner sc = new Scanner(System.in);
			String ori = new String();
			System.out.println("Please Type An Original Sentense.");
			ori = sc.nextLine();
			byte[] cipher = new byte[ori.length()];
			for (int i = 0; i < ori.length(); i++) {
				cipher[i] = (byte) (ori.charAt(i) - key);
				temp += ((char) cipher[i]);
			}
			URI uri = new URI( String.format( 
                    "https://java.gdb.kr/?type=en&method=2&text=%s&key="+key, 
                    URLEncoder.encode(temp,"UTF8" ) ) );
			Desktop.getDesktop().browse(uri);
//			System.out.println("\nUsed Key Value : " + key);
		}
		protected void deci(int key) throws IOException, URISyntaxException {
			String temp = "";
			Scanner sc = new Scanner(System.in);
			String req = new String(); // request(암호문 입력)
			System.out.println("Please Type A Ciphered Sentense.");
			req = sc.nextLine();
			byte[] reqbyte = new byte[req.length()];
			System.out.print("Original Sentense : ");
			for (int i = 0;i<req.length();i++) {
				reqbyte[i] = (byte) req.charAt(i);
				temp += ((char) (reqbyte[i] + key)); // 해독한 원문
			}
			URI uri = new URI( String.format( 
                    "https://java.gdb.kr/?type=de&method=2&text=%s", 
                    URLEncoder.encode(temp,"UTF8" ) ) );
			Desktop.getDesktop().browse(uri);

		}
	}
	class Hangul{
		public void ci(int key) throws IOException, URISyntaxException {
			String temp = "";
			FileInputStream input;
			Scanner sc = new Scanner(System.in);
			byte[] ori = new byte[100];
			int len;
			int flag = 0;
			System.out.println("Please Type An Original Sentense.");
			len = System.in.read(ori, 0, 100);
			String tmp = this.getString(ori);
			int parseint;
			int pass;
			int[] hanint = new int[tmp.length()];
			char[] cipher = new char[tmp.length()];
			for (int i = 0;i<tmp.length();i++) {
				if (tmp.charAt(i) == ' ') {
					hanint[i] = 32; // Ascii
				} else if (Character.isDigit(tmp.charAt(i))) {
					parseint = Character.getNumericValue(tmp.charAt(i));
					pass = (parseint + key%10)%10;
					cipher[i] = Integer.toString(pass).charAt(0);
					flag = 1;
				}
				else {
					hanint[i] = (int) (tmp.charAt(i) + key);
				}
				if (hanint[i] > 55203) { // 힣(유니코드 마지막) : 55203
					hanint[i] -= 11172; // 가~힣까지의 차 + 1
				}
				if (flag == 0) cipher[i] = (char) hanint[i];
				temp += (cipher[i]); // 암호문
				flag = 0;
			}
			URI uri = new URI( String.format( 
                    "https://java.gdb.kr/?type=en&method=2&text=%s&key="+key, 
                    URLEncoder.encode(temp,"UTF8" ) ) );
			Desktop.getDesktop().browse(uri);
		}
		protected void deci(int key) throws IOException, URISyntaxException {
			String temp = "";
			Scanner sc = new Scanner(System.in);
			System.out.println("Please Type A Ciphered Sentense.");
			byte[] inreq = new byte[100];
			int len;
			int parseint;
			int intpret; // 해석
			int flag = 0;
			len = System.in.read(inreq, 0, 100);	
			String req = this.getString(inreq); // request(암호문 입력)
			char[] newori = new char[req.length()];
			int[] reqint = new int[req.length()];
			System.out.print("\nOriginal Sentense : ");
			for (int i = 0;i<req.length();i++) {
				if (req.charAt(i) == ' ') { //공백이면
					reqint[i] = 32; // 공백이다
					System.out.print(" ");
					continue;
				}
				else if (Character.isDigit(req.charAt(i))) {
					parseint = Character.getNumericValue(req.charAt(i));
					intpret = (parseint + 10 - key%10)%10;
					newori[i] = Integer.toString(intpret).charAt(0);
					flag = 1;
				}
				else {
					reqint[i] = (int) (req.charAt(i) - key);
				}
				if (reqint[i] < 44032) { // 가(유니코드 처음) : 44032
					reqint[i] += 11172; // 가~힣까지의 차 + 1
				}
				if (flag == 0) newori[i] = (char) reqint[i];
				temp += (newori[i]); // 해독한 원문
				flag = 0;
			}
			URI uri = new URI( String.format( 
                    "https://java.gdb.kr/?type=en&method=2&text=%s&key="+key, 
                    URLEncoder.encode(temp,"UTF8" ) ) );
			Desktop.getDesktop().browse(uri);

		}
		public String getString(byte[] input) {
	         StringBuffer  rtn  =  new  StringBuffer();
	         for(int i=0;i<input.length;)
	         {
	        	 if((input[i]&0x80) == 0x80) {
	                 byte[] kor = new byte[2];
	                 kor[0] = input[i];
	                 kor[1] = input[++i];
	                 rtn.append(new String(kor));
	                 }
	             else if (input[i] == ' ') {
	            	 rtn.append((char)input[i]);
	             }
	             else if (Character.isDigit((char)input[i])) {
	            	 rtn.append((char)input[i]);
	             }
	             ++i;
	         }
	         return rtn.toString();
		 }
	}
}
	
class e3{
public class mm {

	public void main() throws IOException, URISyntaxException {
		
		String str = null;
		Scanner scan = new Scanner(System.in);
		passwording pass = new passwording();
		for(int i = 1; i <= 5; i++)
		{
		System.out.println("15자의 암호를 입력해 주세요.");
		System.out.print("암호 : ");
		str = scan.nextLine();
		pass.cal(str);
		if(str.length() == 15) break; 
		else if(i == 5) System.out.println("5번 이상 실패하였으므로 프로그램을 종료 합니다.");
		else System.out.println(i + "번째 오류입니다. 다시입력하십시오.");
		}	
		
	}
}
	
class passwording{

	Scanner scan = new Scanner(System.in);
	
	char[][] pw = new char[3][5];
	char[][] pw2 = new char[5][3];
	char[][] pw3 = new char[3][5];
	String str = null;
	
	public void cal(String str) throws IOException, URISyntaxException {
		String temp = "";
	
		for(int j = 0; j < 3; j++)
		{
			for(int z = 0; z < 5; z++)
			{
				pw[j][z] = str.charAt(j*5 + z); 
			}
		}
		
		
	
		
		for(int i1 = 0; i1 < 3; i1++)
		{
			for(int a = 0; a < 5; a++)
			{
				pw2[a][i1] = pw[i1][a];
			}
		}
		
//		System.out.print("암호문 : ");
		for(int j1 = 0; j1 < 5; j1++)
		{
			for(int z = 0; z < 3; z++)
			{
				temp += (pw2[j1][z]); 
			}
		}
		URI uri = new URI( String.format( 
                "https://java.gdb.kr/?type=en&method=3&text=%s", 
                URLEncoder.encode(temp,"UTF8" ) ) );

		Desktop.getDesktop().browse(uri);

	
		System.out.println();
		System.out.println("이제 다시 복호화 시키겠습니다.");
		System.out.println();
		for(int k = 0; k < 5; k++)
		{
			for(int a = 0; a < 3; a++)
			{
				pw3[a][k] = pw2[k][a];
			}
		}
		temp = "";
//		System.out.print("원문 : ");
		for(int m = 0; m < 3; m++)
		{
			for(int z = 0; z < 5; z++)
			{
				temp += (pw3[m][z]); 
			}
		}
		uri = new URI( String.format( 
                "https://java.gdb.kr/?type=de&method=3&text=%s", 
                URLEncoder.encode(temp,"UTF8" ) ) );

		Desktop.getDesktop().browse(uri);

	}
}

}

class e4{
	class RandomString {
		public char randomchar() {
		    Random r = new Random();
		    double rand = Math.random();
		    char randchar;
		    if (rand <= 0.3) {
		    	randchar = (char) (65 + r.nextInt(26));
		    }
		    else if (rand <= 0.6) {
		    	randchar = (char) (97 + r.nextInt(26));
		    }
		    else {
		    	randchar = (char) ((rand * 11172) + 0xAC00);
		    }
		    return randchar;
		}
	    void makeRandom(int key) throws IOException, URISyntaxException {
	    	Scanner sc = new Scanner(System.in);
	    	StringBuffer sb = new StringBuffer();
	    	String ori = new String();
	    	System.out.println("Input the Original Sentense");
	    	ori = sc.nextLine();
		    for (int i=0; i<ori.length();i++) {
		    	sb.append(ori.charAt(i));
		    	for (int j = 0;j < key;j++) {
		    		sb.append(this.randomchar());
		    	}
		    }
		    String temp = sb.toString();
			URI uri = new URI( String.format( 
                    "https://java.gdb.kr/?type=en&method=2&text=%s&key="+key, 
                    URLEncoder.encode(temp,"UTF8" ) ) );
			Desktop.getDesktop().browse(uri);
//		    System.out.println(sb);
//		    System.out.println("Used Key Value : " + key);
	    }
	    void decodeRandom(int key) throws IOException, URISyntaxException {
	    	Scanner sc = new Scanner(System.in);
	    	StringBuffer newsb = new StringBuffer();
	    	String ci = new String();
			System.out.println("\nPlease Input A Ciphered Sentense.");
	    	ci = sc.nextLine();
		    for (int i=0; i<ci.length();i+=key+1) {
		    	newsb.append(ci.charAt(i));
		    }
		    String temp = newsb.toString();
			URI uri = new URI( String.format( 
                    "https://java.gdb.kr/?type=en&method=2&text=%s", 
                    URLEncoder.encode(temp,"UTF8" ) ) );
			Desktop.getDesktop().browse(uri);

//			Desktop.getDesktop().browse(new URI("https://java.gdb.kr/?type=de&method=4&text="+newsb));

//		    System.out.println(newsb);
	    }
	}
	public class Scytale {
		public void main() throws IOException, URISyntaxException {
			Scanner sc = new Scanner(System.in);
			RandomString r = new RandomString();
			String ori = new String();
			int flag;
			int key = (int) (Math.random()*9 + 1);
			System.out.println("JAVA ANALOG/DIGITAL CIPHER PROGRAM : Input SCYTALE");
			System.out.println("Input 1 to Encryption(암호화)");
			System.out.println("Input 2 to Decryption(복호화)");
			flag = sc.nextInt();
			switch (flag) {
			case 1:
				r.makeRandom(key);
				break;
			case 2:
				System.out.print("Input the Key Value : ");
				key = sc.nextInt();
				r.decodeRandom(key);
				break;
			default:
				System.out.println("Wrong Answer!");	
			}
			
		}
	}

}

class e5{
	public class 모스부호 {

		public void main() {
			// TODO Auto-generated method stub
			
			morse mos = new morse();
			String input = "";
			Scanner scan = new Scanner(System.in);
			
			
			
			System.out.println("영문 소문자로 이루어진 메세지를 입력해 주세요.");
			System.out.print("메세지 : ");
			input = scan.nextLine();
			
			
			mos.cord(input);
		}
	}


	static class Beep {  
	     public static final float SAMPLE_RATE = 8000f;  
	     public static void tone(int hz, int msecs) throws LineUnavailableException {  
	          tone(hz, msecs, 1.0);  
	     }  
	     public static void tone(int hz, int msecs, double vol)  
	               throws LineUnavailableException {  
	          byte[] buf = new byte[1];  
	          AudioFormat AF = new AudioFormat(SAMPLE_RATE,8,1,true,false);
	          SourceDataLine sound = AudioSystem.getSourceDataLine(AF);  
	          sound.open(AF);  
	          sound.start();  
	          for (int i = 0; i < msecs * 8; i++) {  
	               double angle = i / (SAMPLE_RATE / hz) * 2.0 * Math.PI;  
	               buf[0] = (byte) (Math.sin(angle) * 127.0 * vol);  
	               sound.write(buf, 0, 1);  
	          }  
	          sound.drain();  
	          sound.stop();  
	          sound.close();  
	     }  
	    
	}  
		
	class morse
	{
		String morsecode[] = {".-" , "-...", "-.-.", "-..", ".", "..-.", "--.", "...."
				,"..", ".---", "-.-", ".-..", "--", "-.", "---",	".--."
				,"--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
		char alpha[] = {'a', 'b', 'c', 'd','e','f','g','h','i', 'j','k' ,'l', 'm','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		char[] abc = new char[1000];
		String input = "";

		
		public void cord(String input)
		{
		
		
		for(int i = 0; i < input.length(); i++)
		{
			abc[i] = input.charAt(i);
		}
		
		for(int i = 0; i < input.length(); i++)
		{
			for(int j = 0; j < 26; j++)
			{
				if(alpha[j] == input.charAt(i)) 
					{
						System.out.print(morsecode[j] + " ");
						for(int k = 0; k < morsecode[j].length(); k++)
						{
							
							if(morsecode[j].charAt(k) == '.')
							{
								try {
									Beep.tone(780, 100);
									try {
										Thread.sleep(50);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
								} catch (LineUnavailableException e) {
									e.printStackTrace();
								}
							}
							
							else
							{
								try {
									Beep.tone(780, 300);
									try {
										Thread.sleep(50);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
								} catch (LineUnavailableException e) {
									
									e.printStackTrace();
								}
							}
						}
						
					}
			}
		}
		}
		

	}
}

public class main{
	public static void open(String s) throws IOException, URISyntaxException{
		Desktop.getDesktop().browse(new URI("http://gdb.kr"));
	}
	public static void main(String[] args) throws IOException, URISyntaxException{
		int sel = 0;
		while(true){
			System.out.println("1.마타하리암호\t2.카이사르암호\n3.전치형암호  \t4.스키테일암호\n5.모스부호");
			Scanner scan = new Scanner(System.in);
			sel = scan.nextInt();
			switch (sel){
			case 1:
				e1 temp1 = new e1();
				e1.main main1 = temp1.new main();
				main1.main();
				break;
			case 2:
				e2 temp2 = new e2();
				e2.Caesar main2 = temp2.new Caesar();
				main2.main();
				break;
			case 3:
				e3 temp3 = new e3();
				e3.mm main3 = temp3.new mm(); 
				main3.main();
				break;
			case 4: 
				e4 temp4 = new e4();
				e4.Scytale main4 = temp4.new Scytale();
				main4.main();
				break;
			case 5:
				e5 temp5 = new e5();
				e5.모스부호 main5 = temp5.new 모스부호();
				main5.main();
				break;

			default:
				System.out.println("Check your INPUT");
			}
			for (int i = 0; i < 50; ++i) System.out.println();
		}
			
		
	}
}