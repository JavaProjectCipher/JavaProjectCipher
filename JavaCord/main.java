package main;
import java.lang.*;
import java.util.*;

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

public class main {
	public static Object[] key;
	
	public static void main(String[] args) {
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
