package learning.Days;

import java.util.ArrayList;
import java.util.List;

/**********************    STREAMS   *************************
 * A sequence of elements supporting sequential and parallel operations.
 * A stream is a mechanism of describing whole series of processes before actually executing them.
 * A stream is designed to manage the processing of the elements.
 * 
 *  
 *  Streams are exciting addition to java - 
 *  1. They make the code to process data uniform, concise and repeatable -- feel similar to database's SQL.
 *  2. when working with large collection parallel stream will provide a performance advantage.
 * 
 * 
 * */
public class Five {
	public static void main(String[] args){
		//Lets play BINGO!
		List<String> bingoPool = new ArrayList<>(75);
		
		
		int start = 1;
		
		for(char c: "BINGO".toCharArray()) {
			for(int i=start;i< (start+15) ;i++) {
				bingoPool.add("" + c + i);
				System.out.println("" + c + i);
			}
			start = start + 15;
		}
	}

}
