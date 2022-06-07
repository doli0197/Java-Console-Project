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
	��ȭ�� ����Ʈ ȸ������
	<< cinema Join >>
	1. �α���
	2. ȸ�� ����
	3. �����ϱ�  
	========ȸ������========
	Z. ���ư���
	���̵��Է�
	��й�ȣ �Է�
	�̸� �Է�
	���� �Է�
	���ԿϷ�!
 */
public class Join2 implements Join {
	   static ArrayList<UserDTO> arr = new ArrayList<UserDTO>();
	   FileIo file = new FileIo();
	   int choice; // ����
	   Scanner sc = new Scanner(System.in);
	   
	   public Join2() {
	      
	   }
	   public void line() {
	      System.out.println("=================");
	   }
	   public void loginInfo(ArrayList<UserDTO> arr) {
	      // �α��� ����
	      Iterator it = arr.iterator();
	      while(it.hasNext()) {
	         UserDTO user = (UserDTO)it.next();
	         System.out.println(user.toString());
	         choiceloginMenu(arr);
	         break;
	      }
	   }
	   // ���� ������
	   public void join() {
	      line();
	 loop : while(true) { // ȸ������ �Ǹ�       
	    while(true) { // Ʋ���� �Է� 
	       System.out.print("<ȸ�� ���� ������ �Դϴ�.>\n");      
	         
	         System.out.println("�����ðڽ��ϱ� ? 1. Yes 2. no");
	         int choice = sc.nextInt();
	            if(choice == 1) {
	               break loop;
	         }             
	         UserDTO userdto = new UserDTO();
	         System.out.println("���̵� �ټ����� ~ ������ �����ּ���.");   
	         String id = sc.next();      
	         if(!(file.idCheck(id))) {
	            System.out.println("���̵� �ߺ��˴ϴ�.");
	            break;
	         } else if(!(userdto.setId(id))) {
	            break;
	         }
	         System.out.println("�н����� 10���� �̻� �Է��� �ּ���.");
	         
	         if(!userdto.setPwd(sc.next())) {
	            break;
	         }
	         System.out.println("�̸� �α��� �̻� �Է����ּ���.");
	         
	         if(!userdto.setName(sc.next())) {
	            break;
	         }
	         System.out.println("���� 1�� ~ 120�� ���� �Է����ּ���.");
	         
	         if(!userdto.setAge(sc.nextInt())) {
	            break;
	         }
	         System.out.println("�ֹι�ȣ�� �Է����ּ���. ex)940114-11xxxxx");
	         
	         if(!userdto.setJumin(sc.next())) {
	            break;
	         }
	         System.out.print("���� �Է��� �ּ��� . > ");
	         
	         if(!userdto.setGender(sc.next())) {
	            break;
	         }
	         arr.add(userdto);
	         file.write(arr);
	         
	         System.out.println("ȸ�������� �Ϸ�Ǿ����ϴ�.");            
	         break loop;
	         }
	       }
	   }
	      
	   // �α��� ������
	   public void login() {
	      System.out.print("���̵� > ");
	      String idCheck = sc.next();
	      System.out.print("��й�ȣ �Է� > ");
	      String pwdCheck =  sc.next();
	      
	      arr = file.print();   
	      Iterator<UserDTO> it = arr.iterator();
	      
	      while(it.hasNext()) {
	         UserDTO dto = it.next();
	         if(idCheck.equals(dto.getId())) {
	            if(pwdCheck.equals(dto.getPwd())) {
	               System.out.println("���ӵǾ����ϴ�.");
	                  choiceloginMenu(arr);
	            } else {   
	               }
	         } else {
	            }
	         /*
	      for(int i = 0; i < arr.size(); i++) {
	         if(idCheck.equals(arr.get(i).getId())) {
	            if(pwdCheck.equals(arr.get(i).getPwd())) {
	                  System.out.println("���ӵǾ����ϴ�.");
	                  choiceloginMenu(arr);
	            } else {
	               System.out.println("��й�ȣ�� Ʋ���ϴ�.");
	               break;
	            }
	         } else {
	            System.out.println("���̵� �������� �ʽ��ϴ�.");
	            break;
	            }
	         }
	      */
	      } 
	   }
	   // �α��� �� �޴�
	   public void choiceloginMenu(ArrayList<UserDTO> arr) {
	      line();
	      HelloITWILLCinema.start();
	      logAfterMenu();
	      do {
	         int choice = sc.nextInt();
	         switch(choice) {
	         case 1:
	            loginInfo(arr); break; // �α��� ����
	         case 2:
	            loginupdate(arr); break; // ����
	         case 3:
	            loginOut(arr); break; // �α׾ƿ�
	         case 4:
	            joinCancel(arr); break; // ȸ��Ż��
	         case 5:   
	            ReserVationMain.loginusermenu(arr);// �ڷΰ���
	         }
	      } while(!(1 >= choice || choice >= 6));
	   }
	   
	   // ����
	   public void loginupdate(ArrayList<UserDTO> arr) {
	      System.out.print("���̵� > ");
	      String idCheck = sc.next();
	      System.out.print("��й�ȣ �Է� > ");
	      String pwdCheck =  sc.next();
	      arr = file.print();   
	      Iterator<UserDTO> it = arr.iterator();
	      
	      while(it.hasNext()) {
	         UserDTO dto = it.next();
	         if(idCheck.equals(dto.getId())) {
	            if(pwdCheck.equals(dto.getPwd())) {
	               System.out.println("��-��-��-��-��-��-��-��-��-��-��-Cinema--��-��-��-��-��-��-��-��-��-��-��-��-��-��-��");
	               System.out.println("��                                                                                 ��");
	               System.out.println("��          1. �н����� ����  2. �̸� ����    3. ������                            ��");
	               System.out.println("��                                                                                 ��");
	               System.out.println("��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��");
	               
	               int choice = sc.nextInt();
	               if(choice == 1) {
	                  System.out.print("�ٲ� �н����� �Է� > ");
	                  dto.setPwd(sc.next());
	               } else if(choice == 2) {
	                  System.out.print("�ٲ� �̸� �Է� > ");
	                  dto.setName(sc.next());
	               } else if(choice == 3) {
	                  break;
	               }
	            } else {   
	               }
	         } else {
	            }
	      }
	      file.write(arr); // ���� ���� 
	      choiceloginMenu(arr);
	   }   
	   
	   // �α׾ƿ�
	   public void loginOut(ArrayList<UserDTO> arr) {
	      showMenu();
	      line();
	   }

	   // �α��� �� �ܼ�
	   public void logAfterMenu() {
	      System.out.println("��-��-��-��-��-��-��-��-��-��-��-Cinema--��-��-��-��-��-��-��-��-��-��-��-��-��-��-��");
	      System.out.println("��                                                                                 ��");
	      System.out.println("�� 1. �α��� ���� 2. ȸ�� ���� 3. �α׾ƿ�  4. ȸ�� Ż��  5. �ڷΰ���              ��");
	      System.out.println("��                                                                                 ��");
	      System.out.println("��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��");
	   }
	   // �α��� �ʱ�޴�
	   public void showMenu() {
	      line();
	      new JoinDraw().start();
	   while(true) {   
	      do {
	         System.out.println("��-��-��-��-��-��-��-��-��-��-��-Cinema Join-��-��-��-��-��-��-��-��-��-��-��-��");
	         System.out.println("��                                                                            ��");
	         System.out.println("�� 1. �α���  2. ȸ������  3. �ǵ��ư���  4. ���̵� ã��                      ��");
	         System.out.println("��                                                                            ��");
	         System.out.println("��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��-��");
	         choice = sc.nextInt();
	         choiceMenu(choice);
	         line();
	         } while(1 > choice && choice > 4);
	      }
	   }
	   
	   // ȸ��Ż�� �� �α��� �ٽ� �Է�
	   public void joinCancel(ArrayList<UserDTO> arr) {
	      
	      line();   
	      arr = file.print();
	      
	      for(int i = 0; i < arr.size(); i++) {
	         sc.nextLine();
	         System.out.print("���̵� > ");
	         String idCheck = sc.nextLine();   
	         if(idCheck.equals(arr.get(i).getId())) {
	            System.out.print("��й�ȣ �Է� > ");
	               String pwdCheck = sc.nextLine();
	            if(pwdCheck.equals(arr.get(i).getPwd())) {
	               System.out.println("���ӵǾ����ϴ�.");
	               // ȸ�� Ż�� ����
	               arr.remove(i);
	               System.out.println("Ż�� �Ϸ� �Ͽ����ϴ�.");         
	               file.write(arr); // ���� ���� 
	               
	               // �α��� �������� 
	               showMenu();
	               break;
	            } else {
	               System.out.println("��й�ȣ�� Ʋ���ϴ�.");
	               break;
	            }
	         } else {
	            System.out.println("���̵� �������� �ʽ��ϴ�.");
	            choiceloginMenu(arr);
	            break;
	         }
	      }
	   }
	   // ���� �޴�
	   public void choiceMenu(int choice) {
	      line();
	      switch(choice) {
	      case 1:
	         // �α���
	         login();
	         break;
	      case 2:
	         // ȸ������
	         join();
	         break;
	      case 3:
	         // �ǵ��ư���
	         ReserVationMain.showMenu(arr);
	         break;
	      case 4: // ���̵� ��� ã�� 
	         searchInfo();
	      }
	   }
	   // ���̵� ��� ���� ã��
	   public void searchInfo() {
	      System.out.println("���� �Է� > ");
	      String name = sc.next();
	      System.out.println("�ֹι�ȣ �Է� > ");
	      String jumin = sc.next();
	      
	      arr = file.print();
	      Iterator it = arr.iterator();
	      while(it.hasNext()) {
	         UserDTO dto = (UserDTO)it.next();
	         if(name.equals(dto.getName())) {
	            if(jumin.equals(dto.getJumin())) {
	               System.out.println("���̵�� : " + dto.getId() + "�н������ : " + dto.getPwd() + "�Դϴ�.");
	         }
	      } else {      
	      }
	               
	   }
	      System.out.println("ȸ�� �����ϴ�.");
	   }
	}
