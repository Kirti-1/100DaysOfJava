package learning.Days;

import java.util.List;
import java.util.stream.Stream;

public class Six {
	
	/*
	 * We'll continue building remaining Pool with the help of stream class
	 * Using different approaches
	 * 
	 * */

	public static void main(String[] args) {
		
		
//		System.out.println("*********************** N-Pool ********************************");
		
		
		
		//Continue with making N-Pool
		int start = 31;
			
		/*	Using iterate function without using any predicate needs to followed up by any limiting function
		 *	Otherwise it'll goes into a finite loop and stack overflow.
		*/
		Stream<String> nStream = Stream.iterate(start, t -> t + 1)
								.limit(15)
								.map(t -> "N" + t);
		
		
//		nStream.forEach(System.out::println);		
		
		
//		System.out.println("*********************** G-Pool ********************************");
		
		
		start = start + 15;
		
		//Let's make G-Pool
		//iterate with predicate
		Stream<String> gStream = Stream.iterate(start, t -> t<=t+15,t -> t + 1)
								.limit(15)
								.map(t -> "G" + t);
		
		
//		gStream.forEach(System.out::println);	
		
		
//		System.out.println("*********************** O-Pool ********************************");
		

		Stream<String> oStream = Stream.of("O61","O62","O63","O64","O65","O66","O67","O68","O69","O70","O71","O72","O73","O74","O75");
		
//		oStream.forEach(System.out::println);
		
		System.out.println("*********************** BINGO *********************************");
		
		var bStream = Five.generateBStream();
		var iStream = Five.generateIStream();
		
		var biStream = Stream.concat(bStream, iStream);
		
		var ngStream = Stream.concat(nStream, gStream);
		
		var bingStream = Stream.concat(biStream, ngStream);
		
		var bingoStream = Stream.concat(bingStream, oStream);
		
//		bingoStream.forEach(System.out::println);
		
		
		//toList() is a terminal operation in the Java Stream API, so comment the above before running the below.
		
		List<String> bingo  = bingoStream.toList();
		
		for(int i=0;i<bingo.size();i++) {
			System.out.println(bingo.get(i));
		}
		
		
		
	}

}
