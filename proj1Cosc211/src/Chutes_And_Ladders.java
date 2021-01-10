//Chutes And Ladders Class: Driver program to play chutes and ladders 
//Alex Wells, William Rathbun | Project 1
import java.util.Scanner;
public class Chutes_And_Ladders
{
    public static void main(String[] args){
        Scanner next = new Scanner(System.in);
        int numplayers =0, p=0, move =0; //variables for number of players, players turn, and dice roll
        
        Space[] board = new Space[100]; //100 space long board array
            for(int i = 0;i<board.length;i++){
               if(i==16|| i== 47 || i== 49 || i== 56 || i== 62 || i== 64 || i== 87 || i == 93 || i == 95 || i == 98)
                  board[i] = new chuteSpace(); //creates chute spaces at these indices
               else if(i==1|| i== 4 || i== 9 || i== 21 || i== 28 || i== 36 || i== 51 || i== 71 || i== 80)
                  board[i] = new ladderSpace();// creates ladder spaces at these indices
               else
                  board[i]= new normalSpace(); //creates normal spaces everywhere else
            }
            
        System.out.println("Welcome to Chutes and Ladders!");
        System.out.print("Enter the number of players (2, 3, or 4): "); 
       while(numplayers <= 1 || numplayers > 4) {
        	numplayers = next.nextInt();
        	if(numplayers <= 1 || numplayers > 4) {
        		System.out.println("Incorrect number of players, try again");
        	}
       }	
       System.out.println();
        
        Player[] player = new Player[numplayers]; //create array of players
        for (int i=0;i<player.length;i++)
        	player[i] = new Player();
        
        while (true){
        	 //Main game loop
             next.nextLine();
             move = (int)Math.ceil(Math.random()*6.0); //dice roll
             System.out.println("Player " +(p+1) +" rolls a " + move +"!");
         
             player[p].changePosition(move); //Increment position by dice roll
             if(player[p].getPosition() > board.length-1) {
                 System.out.println("Player " +(p+1) +" Wins! Congratulations!");
                 break;//Someone reached the end! Break out of loop and end program
             }
             
             if(board[player[p].getPosition()] instanceof chuteSpace) { //if a player lands on a chute
                System.out.println("Player " +(p+1) +" landed on space " +player[p].getPosition() +" and fell down a chute! ");
                System.out.println("Player " +(p+1) +" fell down " +Math.abs(board[player[p].getPosition()].onLanding(player[p].getPosition())) +" spaces!");
             }
                
             if(board[player[p].getPosition()] instanceof ladderSpace) {//if a player lands on a ladder
                System.out.println("Player " +(p+1) +" landed on space " +player[p].getPosition() +" and went up a ladder! ");
                System.out.println("Player " +(p+1) +" climbed up " +board[player[p].getPosition()].onLanding(player[p].getPosition()) +" spaces!");
                System.out.println(player[p].getPosition());
                if(player[p].getPosition() == 80) { //for if a player wins from the space 80 ladder
                	System.out.println("Player " +(p+1) +" Wins! Congratulatons!");
                	break;
                }
             }
                
             player[p].changePosition(board[player[p].getPosition()].onLanding(player[p].getPosition()));
             //apply movement from the onlanding methods
             System.out.println("Player " +(p+1) +" is now on space " +player[p].getPosition());
             System.out.println("Press enter to continue");
           
             p++;
             if(p==player.length)//reset p back to player 1
            	 p=0;
             //End of turn
        }
      }
   }