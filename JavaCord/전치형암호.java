
import java.util.*;
public class 전치형암호 {

	public static void main(String[] args) {
		
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
	
	public void cal(String str) {
	
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
		
		System.out.print("암호문 : ");
		for(int j1 = 0; j1 < 5; j1++)
		{
			for(int z = 0; z < 3; z++)
			{
				System.out.print(pw2[j1][z]); 
			}
		}
		
	
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
		
		
	

 

	
	
	

