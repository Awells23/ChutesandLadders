//Player class used to hold player positions and modify them
//Alex Wells, William Rathbun | Project 1
public class Player {
	private int position = 0;//Int to represent the position on the board

	public  Player() {
		 
	}
	public int getPosition(){
		return position; //getter method for position
	}
	public void changePosition(int amount){ 
		position += amount;  
	}
}