package moviemangement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import FileIo.FileIo;
import draw.HelloITWILLCinema;
import draw.JoinDraw;
import dto.UserDTO;
import interface_.Join;

/*
	영화관 사이트 회원가입
	<< cinema Join >>
	1. 로그인
	2. 회원 가입
	3. 종료하기  
	========회원가입========
	Z. 돌아가기
	아이디입력
	비밀번호 입력
	이름 입력
	나이 입력
	가입완료!
 */
public class Join2 implements Join {
	   static ArrayList<UserDTO> arr = new ArrayList<UserDTO>();
	   FileIo file = new FileIo();
	   int choice; // 메인
	   Scanner sc = new Scanner(System.in);
	   
	   public Join2() {
	      
	   }
	   public void line() {
	      System.out.println("=================");
	   }
	   public void loginInfo(ArrayList<UserDTO> arr) {
	      // 로그인 정보
	      Iterator it = arr.iterator();
	      while(it.hasNext()) {
	         UserDTO user = (UserDTO)it.next();
	         System.out.println(user.toString());
	         choiceloginMenu(arr);
	         break;
	      }
	   }
	   // 가입 페이지
	   public void join() {
	      line();
	 loop : while(true) { // 회원가입 되면       
	    while(true) { // 틀리게 입력 
	       System.out.print("<회원 가입 페이지 입니다.>\n");      
	         
	         System.out.println("나가시겠습니까 ? 1. Yes 2. no");
	         int choice = sc.nextInt();
	            if(choice == 1) {
	               break loop;
	         }             
	         UserDTO userdto = new UserDTO();
	         System.out.println("아이디 다섯글자 ~ 열글자 적어주세요.");   
	         String id = sc.next();      
	         if(!(file.idCheck(id))) {
	            System.out.println("아이디가 중복됩니다.");
	            break;
	         } else if(!(userdto.setId(id))) {
	            break;
	         }
	         System.out.println("패스워드 10글자 이상 입력해 주세요.");
	         
	         if(!userdto.setPwd(sc.next())) {
	            break;
	         }
	         System.out.println("이름 두글자 이상 입력해주세요.");
	         
	         if(!userdto.setName(sc.next())) {
	            break;
	         }
	         System.out.println("나이 1살 ~ 120살 사이 입력해주세요.");
	         
	         if(!userdto.setAge(sc.nextInt())) {
	            break;
	         }
	         System.out.println("주민번호를 입력해주세요. ex)940114-11xxxxx");
	         
	         if(!userdto.setJumin(sc.next())) {
	            break;
	         }
	         System.out.print("성별 입력해 주세요 . > ");
	         
	         if(!userdto.setGender(sc.next())) {
	            break;
	         }
	         arr.add(userdto);
	         file.write(arr);
	         
	         System.out.println("회원가입이 완료되었습니다.");            
	         break loop;
	         }
	       }
	   }
	      
	   // 로그인 페이지
	   public void login() {
	      System.out.print("아이디 > ");
	      String idCheck = sc.next();
	      System.out.print("비밀번호 입력 > ");
	      String pwdCheck =  sc.next();
	      
	      arr = file.print();   
	      Iterator<UserDTO> it = arr.iterator();
	      
	      while(it.hasNext()) {
	         UserDTO dto = it.next();
	         if(idCheck.equals(dto.getId())) {
	            if(pwdCheck.equals(dto.getPwd())) {
	               System.out.println("접속되었습니다.");
	                  choiceloginMenu(arr);
	            } else {   
	               }
	         } else {
	            }
	         /*
	      for(int i = 0; i < arr.size(); i++) {
	         if(idCheck.equals(arr.get(i).getId())) {
	            if(pwdCheck.equals(arr.get(i).getPwd())) {
	                  System.out.println("접속되었습니다.");
	                  choiceloginMenu(arr);
	            } else {
	               System.out.println("비밀번호가 틀립니다.");
	               break;
	            }
	         } else {
	            System.out.println("아이디가 존재하지 않습니다.");
	            break;
	            }
	         }
	      */
	      } 
	   }
	   // 로그인 후 메뉴
	   public void choiceloginMenu(ArrayList<UserDTO> arr) {
	      line();
	      HelloITWILLCinema.start();
	      logAfterMenu();
	      do {
	         int choice = sc.nextInt();
	         switch(choice) {
	         case 1:
	            loginInfo(arr); break; // 로그인 정보
	         case 2:
	            loginupdate(arr); break; // 수정
	         case 3:
	            loginOut(arr); break; // 로그아웃
	         case 4:
	            joinCancel(arr); break; // 회원탈퇴
	         case 5:   
	            ReserVationMain.loginusermenu(arr);// 뒤로가기
	         }
	      } while(!(1 >= choice || choice >= 6));
	   }
	   
	   // 수정
	   public void loginupdate(ArrayList<UserDTO> arr) {
	      System.out.print("아이디 > ");
	      String idCheck = sc.next();
	      System.out.print("비밀번호 입력 > ");
	      String pwdCheck =  sc.next();
	      arr = file.print();   
	      Iterator<UserDTO> it = arr.iterator();
	      
	      while(it.hasNext()) {
	         UserDTO dto = it.next();
	         if(idCheck.equals(dto.getId())) {
	            if(pwdCheck.equals(dto.getPwd())) {
	               System.out.println("■-■-■-■-■-■-■-■-■-■-■-Cinema--■-■-■-■-■-■-■-■-■-■-■-■-■-■-■");
	               System.out.println("│                                                                                 │");
	               System.out.println("■          1. 패스워드 수정  2. 이름 수정    3. 나가기                            ■");
	               System.out.println("│                                                                                 │");
	               System.out.println("■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■");
	               
	               int choice = sc.nextInt();
	               if(choice == 1) {
	                  System.out.print("바꿀 패스워드 입력 > ");
	                  dto.setPwd(sc.next());
	               } else if(choice == 2) {
	                  System.out.print("바꿀 이름 입력 > ");
	                  dto.setName(sc.next());
	               } else if(choice == 3) {
	                  break;
	               }
	            } else {   
	               }
	         } else {
	            }
	      }
	      file.write(arr); // 파일 저장 
	      choiceloginMenu(arr);
	   }   
	   
	   // 로그아웃
	   public void loginOut(ArrayList<UserDTO> arr) {
	      showMenu();
	      line();
	   }

	   // 로그인 후 콘솔
	   public void logAfterMenu() {
	      System.out.println("■-■-■-■-■-■-■-■-■-■-■-Cinema--■-■-■-■-■-■-■-■-■-■-■-■-■-■-■");
	      System.out.println("│                                                                                 │");
	      System.out.println("■ 1. 로그인 정보 2. 회원 수정 3. 로그아웃  4. 회원 탈퇴  5. 뒤로가기              ■");
	      System.out.println("│                                                                                 │");
	      System.out.println("■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■");
	   }
	   // 로그인 초기메뉴
	   public void showMenu() {
	      line();
	      new JoinDraw().start();
	   while(true) {   
	      do {
	         System.out.println("■-■-■-■-■-■-■-■-■-■-■-Cinema Join-■-■-■-■-■-■-■-■-■-■-■-■");
	         System.out.println("│                                                                            │");
	         System.out.println("■ 1. 로그인  2. 회원가입  3. 되돌아가기  4. 아이디 찾기                      ■");
	         System.out.println("│                                                                            │");
	         System.out.println("■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■-■");
	         choice = sc.nextInt();
	         choiceMenu(choice);
	         line();
	         } while(1 > choice && choice > 4);
	      }
	   }
	   
	   // 회원탈퇴 시 로그인 다시 입력
	   public void joinCancel(ArrayList<UserDTO> arr) {
	      
	      line();   
	      arr = file.print();
	      
	      for(int i = 0; i < arr.size(); i++) {
	         sc.nextLine();
	         System.out.print("아이디 > ");
	         String idCheck = sc.nextLine();   
	         if(idCheck.equals(arr.get(i).getId())) {
	            System.out.print("비밀번호 입력 > ");
	               String pwdCheck = sc.nextLine();
	            if(pwdCheck.equals(arr.get(i).getPwd())) {
	               System.out.println("접속되었습니다.");
	               // 회원 탈퇴 진행
	               arr.remove(i);
	               System.out.println("탈퇴가 완료 하였습니다.");         
	               file.write(arr); // 파일 저장 
	               
	               // 로그인 페이지로 
	               showMenu();
	               break;
	            } else {
	               System.out.println("비밀번호가 틀립니다.");
	               break;
	            }
	         } else {
	            System.out.println("아이디가 존재하지 않습니다.");
	            choiceloginMenu(arr);
	            break;
	         }
	      }
	   }
	   // 선택 메뉴
	   public void choiceMenu(int choice) {
	      line();
	      switch(choice) {
	      case 1:
	         // 로그인
	         login();
	         break;
	      case 2:
	         // 회원가입
	         join();
	         break;
	      case 3:
	         // 되돌아가기
	         ReserVationMain.showMenu(arr);
	         break;
	      case 4: // 아이디 비번 찾기 
	         searchInfo();
	      }
	   }
	   // 아이디 비번 정보 찾기
	   public void searchInfo() {
	      System.out.println("성함 입력 > ");
	      String name = sc.next();
	      System.out.println("주민번호 입력 > ");
	      String jumin = sc.next();
	      
	      arr = file.print();
	      Iterator it = arr.iterator();
	      while(it.hasNext()) {
	         UserDTO dto = (UserDTO)it.next();
	         if(name.equals(dto.getName())) {
	            if(jumin.equals(dto.getJumin())) {
	               System.out.println("아이디는 : " + dto.getId() + "패스워드는 : " + dto.getPwd() + "입니다.");
	         }
	      } else {      
	      }
	               
	   }
	      System.out.println("회원 없습니다.");
	   }
	}
