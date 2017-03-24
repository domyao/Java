import java.util.*;



/**
 * 
 * @author DominicYao (Chenyu Yao), 38186145
 *
 *<p> This class models a vibrating guitar string of a given frequency.
 *
 */
public class GuitarString {
	
	private final double  DECAY_FACTOR = 0.996;	
	private Queue<Double> ringbuffer;
	private int sampleNum;


	
	
	/**
	 *  Constructs a guitar string of the given frequency.  
	 *  <p>It creates a ring buffer of the desired capacity <b> N </b> (sampling rate divided by frequency, rounded to the nearest integer), 
	 *  and initializes it to represent a guitar string at rest by enqueueing <b> N </b> zeros. 
	 *  The sampling rate is specified by the constant <em>`StdAudio.SAMPLE_RATE`.</em>  
	 *  If the frequency is less than or equal to 0 or if the resulting size of the ring buffer would be less than 2,
	 *  the method throw an `IllegalArgumentException`.
     * 
	 * @param frequency that is larger than 0
	 * @throws IllegalArgumentException
	 * 
	 */
	public GuitarString( double frequency ){

		
		sampleNum = Math.round((float)(StdAudio.SAMPLE_RATE/frequency));
		
		if( frequency <= 0 || sampleNum < 2 ){
			throw new IllegalArgumentException();
		}
		
		ringbuffer = new LinkedList<>();		
		for( int i = 0; i < sampleNum; i++){
			ringbuffer.add(0.0);
			
		}
	}
	
 
	
	/**
	 * Constructs a guitar string and initializes the contents of the ring buffer to the values in the array.  
	 * <p>If the array has fewer than two elements, the constructor throw an `IllegalArgumentException`.  
	 * <em>This constructor is used only for testing purposes.</em>
	 * 
	 * 
	 * @param  init - an Array of decimal numbers 
	 * @throws IllegalArgumentException
	 */
	public GuitarString( double[] init ){
		
		sampleNum = init.length;
		
		if(sampleNum < 2) {
			throw new IllegalArgumentException();
		}
		
		ringbuffer = new LinkedList<>();
		
		for(Double values: init){
			ringbuffer.add(values);			
		}	
		
		System.out.println(ringbuffer);
	}
	
	
	
	/**
	 * This method replaces the N elements in the ring buffer with N random values 
	 * between -0.5 inclusive and +0.5 exclusive (i.e. -0.5 <= value < 0.5)
	 * 
	 * @modifies ringbuffer
	 */
	public void pluck( ){
		
		for(int i = 0; i < sampleNum; i++){
			ringbuffer.add(Math.random() - 0.5);
			ringbuffer.remove();
		}
   	
    }
	
	
	/**
	 * 
	 * This method applies the Karplus-Strong update <b>ONCE</b>. 
	 * <p>It delete the sample at the front of the ring buffer and add to the end of the ring buffer the average of the first two samples, multiplied by the energy decay factor (0.996)
	 * DECAY_FACTOR = 0.996
	 * 
	 * @modifies ringbuffer
	 */
	public void tic( ) {
		
	    double first = ringbuffer.remove();
		double second = ringbuffer.peek();	
			ringbuffer.add(DECAY_FACTOR * 0.5 * (first + second));
		
	}
	
	
	
	/**
	 * This method should return the current sample (the value at the front of the ring buffer)
	 * @return the front value of the ring buffer
	 */
	public double sample( ){
		
		return ringbuffer.peek();
		
	}



}


