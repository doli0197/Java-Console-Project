package FileIo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import dto.UserDTO;

public class FileIo {
	String  path = "src\\FileIo\\movie.txt";
	// 파일이 없는 경우
	public FileIo() {
		try {	
			File f = new File(path);
			if(f.exists()) {
				System.out.println("환영합니다.");
			} else {
				// 파일이 없을 경우
				if(f.createNewFile()) { 
					System.out.println("파일이 생성되었습니다.");
					}
				} 
			} catch(Exception e) {
				System.out.println(e.toString());
			}
	}
	public void write(ArrayList<UserDTO> arrayList) {
		
		try {	
				FileOutputStream fos = new FileOutputStream(path);
				ObjectOutputStream oop = new ObjectOutputStream(fos);
				System.out.println();
				System.out.println("저장완료");
			
				oop.writeObject(arrayList);
				oop.flush();
				oop.close();
				fos.close();
				
			} catch(IOException ie) {
				System.out.println(ie.toString());
			}
		}
	
	public  ArrayList<UserDTO> print() {	
		try { 
			FileInputStream fos = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fos);
			
			@SuppressWarnings("unchecked")
			ArrayList<UserDTO> arrayList = (ArrayList<UserDTO>)ois.readObject();
			Iterator<UserDTO> it = arrayList.iterator();
			
			while(it.hasNext()) {
				UserDTO dto = it.next();
			}
			
			ois.close();
			fos.close();
			return arrayList;
			
			} catch(Exception e) {
					System.out.println(e.toString());
			}
		return null;
	}
	public boolean idCheck(String id) {
		try { 
			FileInputStream fos = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fos);
			ArrayList<UserDTO> arrayList = (ArrayList<UserDTO>)ois.readObject();
			Iterator<UserDTO> it = arrayList.iterator();	
			
			while(it.hasNext()) {
				UserDTO dto = it.next();
				if(id.equals(dto.getId())) {
					return false;
				}
			}
			ois.close();
			fos.close();
			return true;
			} catch(Exception e) {
					System.out.println(e.toString());
			}
		return true;
	}
}
