import java.util.*;
public class ��ġ����ȣ {

	public static void main(String[] args) {
		
		String str = null;
		Scanner scan = new Scanner(System.in);
		passwording pass = new passwording();
		for(int i = 1; i <= 5; i++)
		{
		System.out.println("15���� ��ȣ�� �Է��� �ּ���.");
		System.out.print("��ȣ : ");
		str = scan.nextLine();
		pass.cal(str);
		if(str.length() == 15) break; 
		else if(i == 5) System.out.println("�������ϱ�?");
		else System.out.println(i + "��° �����Դϴ�. �ٽ��Է��Ͻʽÿ�.");
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
		
		
		//���⼭.
		
		for(int i1 = 0; i1 < 3; i1++)
		{
			for(int a = 0; a < 5; a++)
			{
				pw2[a][i1] = pw[i1][a];
			}
		}
		
		System.out.print("��ȣ�� : ");
		for(int j1 = 0; j1 < 5; j1++)
		{
			for(int z = 0; z < 3; z++)
			{
				System.out.print(pw2[j1][z]); 
			}
		}
		//������� ��ȣȭ
		System.out.println();
		System.out.println("���� �ٽ� ��ȣȭ ��Ű�ڽ��ϴ�.");
		System.out.println();
		for(int k = 0; k < 5; k++)
		{
			for(int a = 0; a < 3; a++)
			{
				pw3[a][k] = pw2[k][a];
			}
		}
		
		System.out.print("���� : ");
		for(int m = 0; m < 3; m++)
		{
			for(int z = 0; z < 5; z++)
			{
				System.out.print(pw3[m][z]); 
			}
		}
	}
}
		
		/*List<List<Character>> outerList = new ArrayList<>();
		outerList.add(list);
		System.out.println(outerList);*/
	//���ڿ� ���� �Ҵ� ���� �� �װ��� �迭�� ��ȯ��Ŵ
	//�༺�а� �������� �ٲپ ���
	//��ȣȭ �ÿ� �� ������
	
	
	
	
	

