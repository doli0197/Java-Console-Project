package interface_;

import java.util.ArrayList;

import dto.UserDTO;

public interface Join {
	public void join();
	public void login();
	public void choiceloginMenu(ArrayList<UserDTO> arr);
	public void loginOut(ArrayList<UserDTO> arr);
	public void logAfterMenu();
	public void showMenu();
	public void joinCancel(ArrayList<UserDTO> arr);
	public void choiceMenu(int choice);
	public void searchInfo();
}
