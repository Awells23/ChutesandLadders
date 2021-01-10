//Normal Space Class: Defines a ladder space
//Alex Wells, William Rathbun | Project 1
public class ladderSpace extends Space
{
    public ladderSpace(){   
    }
    public int onLanding(int position){ 
    	switch (position) { //returns how many spaces ahead a player should climb
    		case 1:  return 37; 
    		case 4:  return 10; 
    		case 9:  return 22; 
    		case 21: return 41; 
    		case 28: return 56; 
    		case 36: return 8;  
    		case 51: return 16; 
    		case 71: return 20;
    		case 80: return 20; 
    		default: return 0;	//never reached
    		}	
}
}
