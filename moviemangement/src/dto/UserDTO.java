package dto;

import java.io.Serializable;

public class UserDTO implements Serializable {
	
		// 유저정보 캡슐화 
		private String id;   	// 아이디
		private String pwd;  	// 비번
		private String name; 	// 이름
		private int age; 	 	// 나이
		private String jumin;   // 주민번호
		private String gender;      // 성별
		private int reservedNumber; // 예매 번호
		
		// 유저 정보 생성자 초기화
		public UserDTO(){}
		
		public int getReservedNumber() {
			return reservedNumber;
		}

		public void setReservedNumber(int reservedNumber) {
			this.reservedNumber = reservedNumber;
		}

		public UserDTO(String id, String pwd, String name, int age, String jumin, String gender, int reservedNumber) {
			super();
			this.id = id;
			this.pwd = pwd;
			this.name = name;
			this.age = age;
			this.jumin = jumin;
			this.gender = gender;
			this.reservedNumber = reservedNumber;
		}

		// getter setter 유효성 검사 
		public String getId() {
			return id;
		}
		
		// 아이디 유효성 
		public boolean setId(String id) {
			do {
			if( 5 <= id.length() && id.length() <= 10) {
				this.id = id;
				return true; // 유효성 완료 
			} else {
				System.out.println(" 유효성 조건을 확인 후 다시 입력해 주시오.");
					return false;// 유효성 실패 
				} 
			} while(!(5 <= id.length() && id.length() <= 10)); 
			// false 이면 다시 돌게 함 
		}
		
		public String getPwd() {
			return pwd;
		}

		// 패스워드 유효성
		public boolean setPwd(String pwd) {
			do {
			if(pwd.length() >= 10) {
				this.pwd = pwd;		
				return true;
			} else {
				System.out.println(" 유효성 조건을 확인 후 다시 입력해 주시오.");
					return false;
				}
			} while(!(10 <= pwd.length()));
		}
		public String getName() {
			return name;
		}
		
		// 이름 유효성 
		public boolean setName(String name) {
			do {
			if(name.length() >= 2) {
				this.name = name;			
				return true;
			} else {
				System.out.println(" 유효성 조건을 확인 후 다시 입력해 주시오.");
					return false;
				}	 
			}while(!(2 <= name.length()));
		}
		public int getAge() {
			return age;
		}

		// 나이 유효성
		public boolean setAge(int age) {
			do {
				if(1 <= age && age <= 100) {
					this.age = age;			
					return true;
				} else {
					System.out.println("다시 입력해 주시오.");
						return false;
				}
			} while(!(1 <= age && age <= 100));
		}
		public String getJumin() {
			return jumin;
		}
		// 주민번호 유효성 
		public boolean setJumin(String jumin) {
			// 주민번호 940114 - 1 ? 2? 3? 4? 는 무조건 와야함 
			// 1 , 3 = 남자
			// 2 , 4 = 여자
			// 모두 14자리 
			do {
				// 주민번호 유효성 검사 
				if((jumin.charAt(8) == '1' || jumin.charAt(8) == '3') && jumin.length() == 14 ) {
					this.jumin = jumin;
					return true;
				} 
				if((jumin.charAt(8) == '2' || jumin.charAt(8) == '4') && jumin.length() == 14 ) {
					this.jumin = jumin;
					return true;
				} else {
					return false;
					}
				} while(!(jumin.charAt(8) == '2' || jumin.charAt(8) == '4') && jumin.length() == 14);
			}
		
		public String getGender() {
			return gender;
		}
		public boolean setGender(String gender) {
			do {
				if(gender.equals("남자") || gender.equals("여자")) {
					this.gender = gender;					
					return true;
				} else {
					System.out.println("남자 or 여자로 입력해주세요.");
					return false;
				}
			}while(!(gender.equals("남자") || gender.equals("여자")));
			
		}
		// 아이디 비밀번호 찾기 
		@Override
		public String toString() {
			String infoPrint = String.format("아이디 : %s 패스워드 %s 이름 %s 나이 %d 주민번호 %s 성별 %s 예매번호 %d", 
					id , pwd , name , age , jumin , gender ,reservedNumber);
			return infoPrint;
		}
	}

