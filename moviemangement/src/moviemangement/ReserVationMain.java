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
	영화 예매 
	좌석 [0-0] [0-1] [0-2] [0-3]
	    [1-0] [1-1] [1-2] [1-3]
	    [2-0] [2-1] [2-2] [2-3]
	    [3-0] [3-1] [3-2] [3-3]
	<< ITWill CIneMa >>    
	1. 좌석보기    
	2. 좌석예약
	3. 예매내역조회
	4. 예매취소하기
 */
// 메인 실행 클래스 
public class ReserVationMain { 
	static ReserVationMain reser = new ReserVationMain(); // 메인
	static String[][] seat;	// 좌석
	static int[][] reservedNumber; // 예매번호
	Scanner sc; // 입력
	List<UserDTO> user; // 유저정보 
	
	ArrayList<UserDTO> arr = Join2.arr;
	
	// 생성자 초기화 싱글톤 
	ReserVationMain() {
		seat = new String[4][4];
		reservedNumber = new int[4][4];
		sc = new Scanner(System.in);
		user = new ArrayList<UserDTO>();
		
	}

	// 프로그램 시작 시 좌석 초기화
	public void setInfo() {
		for(int i = 0; i < seat.length; i++) {
			for(int j = 0; j < seat[i].length; j++) {
				seat[i][j] = i + "-" + j;
			}
		}
	}
	// 라인 
	public void line() {
		System.out.println("=================");
	}
	// 1. 좌석 보기
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
	// 2. 좌석 예약하기
	public String[][] seatReserVation(String[][] seat) {
		System.out.print("좌석 번호를 선택해주세요. 예) 1-1> ");
		System.out.println(" ☜ 뒤로가기를 원하시면 1번버튼이 눌러주세요 ▼ ");
		reser.showSeat(seat);
		String seatNo = sc.nextLine();
		for(int i = 0; i < seat.length; i++) {
			for(int j = 0; j < seat[i].length; j++) {
				if(seatNo.equals(seat[i][j])) {
					seat[i][j] = "예매";
					reservedNumber[i][j] = (int)(Math.random()*1000000);
					
					// 접속된 사람한테 예매번호 부여 
					Iterator it = arr.iterator();		
					while(it.hasNext()) {
						UserDTO userdto = (UserDTO)it.next();
						userdto.setReservedNumber(reservedNumber[i][j]);						
					}
				
					System.out.println("예매가 완료 되었습니다.");
					reser.showSeat(seat);
					System.out.println(String.format("예매 좌석은 [%s-%s]부여된 예매번호는 %d 입니다.",i,j,reservedNumber[i][j] ));

					break;
				} else if(seatNo.equals("예매")) {
					System.out.println("예매됨");
				}
				if(seatNo.equals("예매") && reservedNumber[i][j] == 0) {
					System.out.println("예매됨");
				}
			}
		}
		if(seatNo == null) {
			System.out.println("존재하지않습니다.");
		}
		return seat;
	}
	// 3. 예매 내역 조회하기
	public void reservedConfirm(String[][] seat) {
		line();
		System.out.println(" ▼ 예매권 번호를 입력해주세요 ▼ ");
		System.out.println(" ☜ 뒤로가기를 원하시면 1번버튼이 눌러주세요 ▼ ");
		line();
		int number = sc.nextInt();

		for(int i = 0; i < reservedNumber.length; i++) {
			for(int j = 0; j < reservedNumber[i].length; j++) {
				if(number == reservedNumber[i][j]) {
					line();
					System.out.println(String.format("조회된 예매의 좌석은 [%s-%s] 입니다", i , j));
					line();
				}
			}
		}
	}
	 // 4. 예매 취소하기
	   public void cancelSeat(String[][] seat) {
	      System.out.println("▼ 예매권 번호를 입력해주세요 ▼ ");
	      System.out.println(" ☜ 뒤로가기를 원하시면 1번 버튼 눌러주세요 ▼ ");
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
	               System.out.println("예매가 취소되었습니다.");
	               line();
	               break;
	            
	            }
	            //reser.showMenu(null);
	            //reser.loginusermenu(null);
	            }
	         }
	      }
	
	// 프로그램 종료하기
	public static void exit() {	
		try {
			System.out.println("프로그램을 종료중입니다");			
			
			for(int i = 0;i<21;i++) {
				System.out.print("■");
				Thread.sleep(100);
			}
			new GoodBye();
			System.out.println("\n종료되었습니다");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		System.exit(0);
	}

	// 메뉴 
	public static void showMenu(ArrayList<UserDTO> arr) {
		ITWILLCINEMA itwill = new ITWILLCINEMA();
		int menu = 0;
		do {	
			System.out.println("\n■-■-■-■-■-■-■-■-■-■-■-■-■-ITWill CineMa -■-■-■-■-■-■-■-■-■-■-■-■-■");
			System.out.println("│ 메뉴를 선택해주세요.                                                                  │");
			System.out.println("■ 1. 로그인 & 회원 가입 페이지로 이동하기   2. 영화 좌석 예약     3. 예매 내역 조회     ■"); 
			System.out.println("│ 4. 좌석 보기  5. 예매 내역 취소  6. 종료 하기                                         │");
			System.out.println("■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■");

			Scanner sc = new Scanner(System.in);
			String choice = sc.nextLine();
			menu = Integer.parseInt(choice);
			Join2 j = new Join2();
			switch(menu) {		
			
			case 1:
				j.showMenu(); // 회원 가입 페이지로 이동 
				break;
			case 2:
				reser.seatReserVation(seat); // 좌석예약하기
				break;
			case 3:
				reser.reservedConfirm(seat); // 예매내역 조회하기
				break;
			case 4:
				reser.showSeat(seat); // 좌석보기 
				break;
			case 5:	
				reser.cancelSeat(seat);	// 예매내역 취소하기 
				break;
			case 6:
				exit();
			default :
				System.out.println("다시 입력 하세요.");
			}
		} while(!(1 > menu || menu >= 5));
	}
	public static void main(String[] args) {		
		reser.setInfo(); // 좌석초기화
		reser.showMenu(null); // 메뉴보여주기 
	}
	
	public static void loginusermenu(ArrayList<UserDTO> arr) {
		ITWILLCINEMA itwill = new ITWILLCINEMA();
		int menu = 0;
		
		do {	
			System.out.println("\n■-■-■-■-■-■-■-■-■-■-■-■-■-ITWill CineMa -■-■-■-■-■-■-■-■-■-■-■-■-■");
			System.out.println("│ 메뉴를 선택해주세요.                                                                  │");
			System.out.println("■ 1. 회원 정보   2. 영화 좌석 예약     3. 예매 내역 조회                                ■"); 
			System.out.println("│ 4. 좌석 보기  5. 예매 내역 취소  6. 종료 하기                                         │");
			System.out.println("■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■");

			Scanner sc = new Scanner(System.in);
			String choice = sc.nextLine();
			menu = Integer.parseInt(choice);
			
			Join2 j = new Join2();
			
			switch(menu) {		
			case 1:
				j.loginInfo(arr);//  회원정보 
				break;
				 //  로그아웃
				 // 회원수정
			case 2:
				reser.seatReserVation(seat); // 좌석예약하기
				break;
			case 3:
				reser.reservedConfirm(seat); // 예매내역 조회하기
				break;
			case 4:
				reser.showSeat(seat); // 좌석보기 
				break;
			case 5:	
				reser.cancelSeat(seat);	// 예매내역 취소하기 
				break;
			case 6:
				exit(); //종료 나가기
			default :
				System.out.println("다시 입력 하세요.");
			}
		} while(!(1 > menu || menu >= 5));
	}
	
}
