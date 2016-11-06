package main;
import java.lang.*;
import java.util.*;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


// e1 class : 마타하리암호(author : 차수환)
// e2 class : 카이사르암호(author : 성현우)
// e3 class : 전치형암호(author : 맹성호)
// e4 class : 스키테일암호(author : 성현우)
// main class : 모든 소스를 합침(author : 차수환)

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

class decode{
	public static  Object decode(String s){
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
		        System.out.print(o+ " ");
		        return o;
		     }
		   }
		return "no object";
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
				System.out.println("Check your input type");
			}else{
				int count = this.key.length() / 6;
				this.stringArray = new String[count];
				for(int i = 1; i<=count; i++){
					int start = (i-1)*6;
					int end = (i)*6;
//					System.out.println(this.key.substring(start,end));
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
	public Object[] key;
	
	public void main() {
		decode decoder = new decode();
		encoder encoder = new encoder();
		setting main = new setting();
		char[] toEncode = main.GetCharKey();
		if(main.mod == 1){
			for(char val : toEncode){
				String c = "";
				c = new Character(val).toString();
				System.out.println(encoder.encode(c));
			}
		}else if(main.mod == 2){
			String str[] = main.getstrArray();
			key = new Object[str.length];
			for(int i = 0; i< str.length; i++){
				decode.decode(str[i]);
			}
	
		}

	}

}

}

class e2{
	public class Caesar {
		public void main(){
			Scanner sc = new Scanner(System.in);
			Han han = new Han();
			Eng eng = new Eng();
			int key = (int) (Math.random()*20) + 1;
			int hankey = (int) (Math.random()*20) + 25;
			System.out.println("JAVA ANALOG/DIGITAL CIPHER PROGRAM : TYPE CAESAR\n");
			System.out.println("Type the Cipher Service & Language of Your Sentenses.\n");
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
				key = sc.nextInt();
				han.deci(hankey);
				break;
			default:
				System.out.println("Wrong Answer!");	
			}
		}
	}
	class Eng {
		protected void ci(int key) {
			Scanner sc = new Scanner(System.in);
			String ori = new String();
			System.out.println("Please Type An Original Sentense.");
			ori = sc.nextLine();
			byte[] cipher = new byte[ori.length()];
			for (int i = 0; i < ori.length(); i++) {
				cipher[i] = (byte) (ori.charAt(i) - key);
				System.out.print((char) cipher[i]);
			}
			System.out.println("\nUsed Key Value : " + key);
		}
		protected void deci(int key) {
			Scanner sc = new Scanner(System.in);
			String req = new String(); // request(암호문 입력)
			System.out.println("Please Type A Ciphered Sentense.");
			req = sc.nextLine();
			byte[] reqbyte = new byte[req.length()];
			System.out.print("Original Sentense : ");
			for (int i = 0;i<req.length();i++) {
				reqbyte[i] = (byte) req.charAt(i);
				System.out.print((char) (reqbyte[i] + key)); // 해독한 원문
			}
			
			/* for (int i=0;i<ori.length();i++) {
				System.out.print((char) (cipher[i] + key));
			} */
		}
	}
	class Han {
		protected void ci(int key) {
			Scanner sc = new Scanner(System.in);
			String ori = new String();
			System.out.println("Please Type An Original Sentense.");
			ori = sc.nextLine();
			int[] hanint = new int[ori.length()];
			char[] cipher = new char[ori.length()];
			for (int i = 0;i<ori.length();i++) {
				hanint[i] = (int) ori.charAt(i) + key;
				cipher[i] = (char) hanint[i];
				System.out.print(cipher[i]); // 암호문
			}
			System.out.println("\nUsed Key Value : " + key);		
		}
		protected void deci(int key) {
			Scanner sc = new Scanner(System.in);
			String req = new String(); // request(암호문 입력)
			System.out.println("Please Type A Ciphered Sentense.");
			req = sc.nextLine();
			int[] reqint = new int[req.length()];
			System.out.print("\nOriginal Sentense : ");
			for (int i = 0;i<req.length();i++) {
				reqint[i] = (int) req.charAt(i);
				System.out.print((char) (reqint[i] - key)); // 해독한 원문
			}
		}
	}

}
	
class e3{
	class mm {

		public void main() {
			
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
			else if(i == 5) System.out.println("뇌없습니까?");
			else System.out.println(i + "번째 오류입니다. 다시입력하십시오.");
			}
			
			
			
			
		}
	}
		
	class passwording{

		Scanner scan = new Scanner(System.in);
		List<Character> list = new ArrayList<>();
		char[][] pw = new char[3][5];
		char[][] pw2 = new char[5][3];
		char[][] pw3 = new char[3][5];
		String str = null;
		
		public void cal(String str) {
		
			for (int i = 0; i < str.length(); i++){
				list.add(str.charAt(i));
			}
			System.out.println(list);
			
			
			for(int j = 0; j < 3; j++)
			{
				for(int z = 0; z < 5; z++)
				{
					pw[j][z] = str.charAt(j*5 + z); 
				}
			}
			
			
			//여기서.
			
			for(int i1 = 0; i1 < 3; i1++)
			{
				for(int a = 0; a < 5; a++)
				{
					pw2[a][i1] = pw[i1][a];
				}
			}
			
			System.out.print("암호문 : ");
			for(int j1 = 0; j1 < 5; j1++)
			{
				for(int z = 0; z < 3; z++)
				{
					System.out.print(pw2[j1][z]); 
				}
			}
			//여기까지 부호화
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
			
			System.out.print("원문 : ");
			for(int m = 0; m < 3; m++)
			{
				for(int z = 0; z < 5; z++)
				{
					System.out.print(pw3[m][z]); 
				}
			}
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
	    void makeRandom(int key) {
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
		    System.out.println(sb);
		    System.out.println("Used Key Value : " + key);
	    }
	    void decodeRandom(int key) {
	    	Scanner sc = new Scanner(System.in);
	    	StringBuffer newsb = new StringBuffer();
	    	String ci = new String();
			System.out.println("\nPlease Input A Ciphered Sentense.");
	    	ci = sc.nextLine();
		    for (int i=0; i<ci.length();i+=key+1) {
		    	newsb.append(ci.charAt(i));
		    }
		    System.out.println(newsb);
	    }
	}
	public class Scytale {
		public void main() {
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

public class main{
	public static void main(String[] args) throws IOException, URISyntaxException{
		int sel = 0;
		System.out.println("1.마타하암호\t2.카이사르암호\n3.전치형암호  \t4.스키테일암호");
		Scanner scan = new Scanner(System.in);
		sel = scan.nextInt();
		switch (sel){
		case 1:
			e1 temp1 = new e1();
			e1.main main1 = temp1.new main();
			main1.main();
			Desktop.getDesktop().browse(new URI("http://gdb.kr"));
			break;
		case 2:
			e2 temp2 = new e2();
			e2.Caesar main2 = temp2.new Caesar();
			main2.main();
			Desktop.getDesktop().browse(new URI("http://gdb.kr"));
			break;
		case 3:
			e3 temp3 = new e3();
			e3.mm main3 = temp3.new mm(); 
			main3.main();
			Desktop.getDesktop().browse(new URI("http://gdb.kr"));
			break;
		case 4:
			e4 temp4 = new e4();
			e4.Scytale main4 = temp4.new Scytale();
			main4.main();
			Desktop.getDesktop().browse(new URI("http://gdb.kr"));
			break;
		}
			
		
	}
}