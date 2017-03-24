

/**
 * 
 * 
 * 
 * @author DominicYao( Chenyu yao) 38186145
 * 
 * <p>The Guitar221 class models a stringed instrument containing 37 notes on the chromatic scale from 110Hz to 880Hz 
 * 
 * */

public class Guitar221 implements Guitar {
	
    public static final String KEYBOARD =  "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";  // keyboard layout 
    private static final int KEYBOARD_LENGTH = KEYBOARD.length(); // The length of the keyboard will be used for multiple times in this code.    
    private GuitarString[] pianoStrings;    
    private int tic_calltimes = 0;
    

    
    /**
     * The constructor create a array of GuitarSting objects with 37 notes form 100Hz to 880Hz respectively 
     * 
     */
    
    public Guitar221(){
    	
    	pianoStrings = new GuitarString[KEYBOARD_LENGTH];
    	
    	for(int i = 0; i < KEYBOARD_LENGTH; i ++){ 	
    		pianoStrings[i] = new GuitarString(440.0 * Math.pow(2, ((i-24.0)/12.0)));    		
    	}  
    	
    }
    
    
    
    /** Plays the given note if possible by plucking an appropriate string;
     *  the pitch uses a chromatic scale where Concert-A has a pitch of 12.
     *  
     *  <p><em>Not every value of pitch can be played by any given guitar.  
     *  If it can’t be played, it is ignored.  It does not throw an exception.</em>
     *  
     *  @param pitch (Integer) 
     */
       
    public void playNote(int pitch){
    	int idx = pitch + 12;
    	
    	if ((idx < KEYBOARD_LENGTH ) & (idx > 0)){
    		pianoStrings[idx].pluck();
       	}   	
    	
    }
    

    
    /** 
     * Determine whether a the character user typed on keyboard is contained in the KEYBOARD
     * @param key - a letter character on the keyboard
     * @return true if there is a string that corresponds to this character, false otherwise
     * 
     */
    
    public boolean hasString(char key){
    	return( KEYBOARD.indexOf(key) != -1 ); // String.indexOf(key) return -1 if "key" is not found in the stringaa
    }
    
    

    
    /**
     * Plucks the string for this character
     * 
     * @param key - a letter character on the keyboard
     * @throws IllegalArgumentException
     * 
     */
    
    public void pluck(char key){
    	
    	if(!hasString(key)){
    		throw new IllegalArgumentException();   		
    	} 

    	pianoStrings[KEYBOARD.indexOf(key)].pluck(); 


    }
    

    /**
     * 
     * @return <b>sample_all</b> (the current sound, sum of all strings)
     * 
     */
    
    public double sample(){
    	double sample_all= 0.0;
    	
    	for(GuitarString pianostring: pianoStrings){    		
    		sample_all += pianostring.sample();   		
    	}
    	
    	return sample_all;
    	
    }

    /**
     * advances the simulation by having each string tic forward.
     *
     */
    public void tic(){
    	for(GuitarString pianostring: pianoStrings){
    		pianostring.tic();
    	}
    	tic_calltimes ++;
    }

    /**
     * return the time tic has been called
     * @return <b>tic_calltimes</b>  \
     */

    public int time(){
    	
    	return tic_calltimes;
      
    }
    
    
}