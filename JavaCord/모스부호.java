import java.util.*; 
import javax.sound.sampled.*;  
public class 모스부호 {

	public static void main(String[] args) {
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


class Beep {  
     public static float SAMPLE_RATE = 8000f;  
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
