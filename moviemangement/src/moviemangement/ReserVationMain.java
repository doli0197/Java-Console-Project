package moviemangement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import draw.GoodBye;
import draw.ITWILLCINEMA;
import draw.Screen;

import dto.UserDTO;

/*
	��ȭ ���� 
	�¼� [0-0] [0-1] [0-2] [0-3]
	    [1-0] [1-1] [1-2] [1-3]
	    [2-0] [2-1] [2-2] [2-3]
	    [3-0] [3-1] [3-2] [3-3]
	<< ITWill CIneMa >>    
	1. �¼�����    
	2. �¼�����
	3. ���ų�����ȸ
	4. ��������ϱ�
 */
// ���� ���� Ŭ���� 
public class ReserVationMain { 
	static ReserVationMain reser = new ReserVationMain(); // ����
	static String[][] seat;	// �¼�
	static int[][] reservedNumber; // ���Ź�ȣ
	Scanner sc; // �Է�
	List<UserDTO> user; // �������� 
	
	ArrayList<UserDTO> arr = Join2.arr;
	
	// ������ �ʱ�ȭ �̱��� 
	ReserVationMain() {
		seat = new String[4][4];
		reservedNumber = new int[4][4];
		sc = new Scanner(System.in);
		user = new ArrayList<UserDTO>();
		
	}

	// ���α׷� ���� �� �¼� �ʱ�ȭ
	public void setInfo() {
		for(int i = 0; i < seat.length; i++) {
			for(int j = 0; j < seat[i].length; j++) {
				seat[i][j] = i + "-" + j;
			}
		}
	}
	// ���� 
	public void line() {
		System.out.println("=================");
	}
	// 1. �¼� ����
	public String[][] showSeat(String[][] seat) {
		Screen screen = new Screen();	
		for(int i = 0; i < seat.length; i++) {
			for(int j = 0; j < seat[i].length; j++) {
				System.out.print("|" + seat[i][j]+"|");
			}
			System.out.println();
		}
		line();
		return seat;
	}
	// 2. �¼� �����ϱ�
	public String[][] seatReserVation(String[][] seat) {
		System.out.print("�¼� ��ȣ�� �������ּ���. ��) 1-1> ");
		System.out.println(" �� �ڷΰ��⸦ ���Ͻø� 1����ư�� �����ּ��� �� ");
		reser.showSeat(seat);
		String seatNo = sc.nextLine();
		for(int i = 0; i < seat.length; i++) {
			for(int j = 0; j < seat[i].length; j++) {
				if(seatNo.equals(seat[i][j])) {
					seat[i][j] = "����";
					reservedNumber[i][j] = (int)(Math.random()*1000000);
					
					// ���ӵ� ������� ���Ź�ȣ �ο� 
					Iterator it = arr.iterator();		
					while(it.hasNext()) {
						UserDTO userdto = (UserDTO)it.next();
						userdto.setReservedNumber(reservedNumber[i][j]);						
					}
				
					System.out.println("���Ű� �Ϸ� �Ǿ����ϴ�.");
					reser.showSeat(seat);
					System.out.println(String.format("���� �¼��� [%s-%s]�ο��� ���Ź�ȣ�� %d �Դϴ�.",i,j,reservedNumber[i][j] ));

					break;
				} else if(seatNo.equals("����")) {
					System.out.println("���ŵ�");
				}
				if(seatNo.equals("����") && reservedNumber[i][j] == 0) {
					System.out.println("���ŵ�");
				}
			}
		}
		if(seatNo == null) {
			System.out.println("���������ʽ��ϴ�.");
		}
		return seat;
	}
	// 3. ���� ���� ��ȸ�ϱ�
	public void reservedConfirm(String[][] seat) {
		line();
		System.out.println(" �� ���ű� ��ȣ�� �Է����ּ��� �� ");
		System.out.println(" �� �ڷΰ��⸦ ���Ͻø� 1����ư�� �����ּ��� �� ");
		line();
		int number = sc.nextInt();

		for(int i = 0; i < reservedNumber.length; i++) {
			for(int j = 0; j < reservedNumber[i].length; j++) {
				if(number == reservedNumber[i][j]) {
					line();
					System.out.println(String.format("��ȸ�� ������ �¼��� [%s-%s] �Դϴ�", i , j));
					line();
				}
			}
		}
	}
	 // 4. ���� ����ϱ�
	   public void cancelSeat(String[][] seat) {
	      System.out.println("�� ���ű� ��ȣ�� �Է����ּ��� �� ");
	      System.out.println(" �� �ڷΰ��⸦ ���Ͻø� 1�� ��ư �����ּ��� �� ");
	      int number = sc.nextInt();
	      for(int i = 0; i < reservedNumber.length; i++) {
	         for(int j = 0; j < reservedNumber[i].length; j++) {
	            if(number == reservedNumber[i][j]) {
	               seat[i][j] = i+"-"+j;
	               reservedNumber[i][j] = 0;
	               line();
	               ArrayList<UserDTO> arr = Join2.arr;
	               Iterator<UserDTO> it = arr.iterator();      
	               while(it.hasNext()) {
	                  UserDTO userdto = it.next();
	                  userdto.setReservedNumber(reservedNumber[i][j]);                  
	                  //Join2.file.write(arr);
	               }   
	               System.out.println("���Ű� ��ҵǾ����ϴ�.");
	               line();
	               break;
	            
	            }
	            //reser.showMenu(null);
	            //reser.loginusermenu(null);
	            }
	         }
	      }
	
	// ���α׷� �����ϱ�
	public static void exit() {	
		try {
			System.out.println("���α׷��� �������Դϴ�");			
			
			for(int i = 0;i<21;i++) {
				System.out.print("��");
				Thread.sleep(100);
			}
			new GoodBye();
			System.out.println("\n����Ǿ����ϴ�");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		System.exit(0);
	}

	// �޴� 
	public static void showMenu(ArrayList<UserDTO> arr) {
		ITWILLCINEMA itwill = new ITWILLCINEMA();
		int menu = 0;
		do {	
			System.out.println("\n��-��-��-��-��-��-��-��-��-��-��-��-��-ITWill CineMa -��-��-��-��-��-��-��-��-��-��-��-��-��");
			System.out.println("�� �޴��� �������ּ���.                                                                  ��");
			System.out.println("�� 1. �α��� & ȸ�� ���� �������� �̵��ϱ�   2. ��ȭ �¼� ����     3. ���� ���� ��ȸ     ��"); 
			System.out.println("�� 4. �¼� ����  5. ���� ���� ���  6. ���� �ϱ�                                         ��");
			System.out.println("��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��");

			Scanner sc = new Scanner(System.in);
			String choice = sc.nextLine();
			menu = Integer.parseInt(choice);
			Join2 j = new Join2();
			switch(menu) {		
			
			case 1:
				j.showMenu(); // ȸ�� ���� �������� �̵� 
				break;
			case 2:
				reser.seatReserVation(seat); // �¼������ϱ�
				break;
			case 3:
				reser.reservedConfirm(seat); // ���ų��� ��ȸ�ϱ�
				break;
			case 4:
				reser.showSeat(seat); // �¼����� 
				break;
			case 5:	
				reser.cancelSeat(seat);	// ���ų��� ����ϱ� 
				break;
			case 6:
				exit();
			default :
				System.out.println("�ٽ� �Է� �ϼ���.");
			}
		} while(!(1 > menu || menu >= 5));
	}
	public static void main(String[] args) {		
		reser.setInfo(); // �¼��ʱ�ȭ
		reser.showMenu(null); // �޴������ֱ� 
	}
	
	public static void loginusermenu(ArrayList<UserDTO> arr) {
		ITWILLCINEMA itwill = new ITWILLCINEMA();
		int menu = 0;
		
		do {	
			System.out.println("\n��-��-��-��-��-��-��-��-��-��-��-��-��-ITWill CineMa -��-��-��-��-��-��-��-��-��-��-��-��-��");
			System.out.println("�� �޴��� �������ּ���.                                                                  ��");
			System.out.println("�� 1. ȸ�� ����   2. ��ȭ �¼� ����     3. ���� ���� ��ȸ                                ��"); 
			System.out.println("�� 4. �¼� ����  5. ���� ���� ���  6. ���� �ϱ�                                         ��");
			System.out.println("��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��");

			Scanner sc = new Scanner(System.in);
			String choice = sc.nextLine();
			menu = Integer.parseInt(choice);
			
			Join2 j = new Join2();
			
			switch(menu) {		
			case 1:
				j.loginInfo(arr);//  ȸ������ 
				break;
				 //  �α׾ƿ�
				 // ȸ������
			case 2:
				reser.seatReserVation(seat); // �¼������ϱ�
				break;
			case 3:
				reser.reservedConfirm(seat); // ���ų��� ��ȸ�ϱ�
				break;
			case 4:
				reser.showSeat(seat); // �¼����� 
				break;
			case 5:	
				reser.cancelSeat(seat);	// ���ų��� ����ϱ� 
				break;
			case 6:
				exit(); //���� ������
			default :
				System.out.println("�ٽ� �Է� �ϼ���.");
			}
		} while(!(1 > menu || menu >= 5));
	}
	
}
