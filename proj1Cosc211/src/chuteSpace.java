//Normal Space Class: Defines a chute space
//Alex Wells, William Rathbun | Project 1
public class chuteSpace extends Space
{
    public chuteSpace(){    
    }
    public int onLanding(int position){
    	
    	switch (position) { //returns how many spaces behind a player should fall
    		case 16: return  -10; 
    		case 47: return  -21; 
    		case 49: return  -38; 
    		case 56: return  -3; 
    		case 62: return -43; 
			case 64: return  -4; 
			case 87: return  -63; 
			case 93: return  -20;
			case 95: return  -20; 
			case 98: return  -20; 
			default: return 0; //never reached
    		}	
    	
}
}
