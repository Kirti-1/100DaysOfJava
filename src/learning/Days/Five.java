package learning.Days;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
//				System.out.println("" + c + i);
			}
			start = start + 15;
		}
		
		//Shuffling the bingoPool
		Collections.shuffle(bingoPool);
		
		//Let's print first 15 shuffled numbers
		for(int i=0;i<15;i++) {
//			System.out.println(bingoPool.get(i));
		}
		
		
		//warm up on streams
		
		long count = bingoPool.stream()
					.count();
		
//		System.out.println(count);
	
		var stream = bingoPool.stream()
				.filter((t) -> {
					System.out.println(" --- >>>>> " + t);
					return true;
					});
		
		//This is a terminal operator, that's why we call stream lazy as they won't execute unless a terminal operator is chained.
		
//		stream.forEach(System.out::println);
		
		
		
		System.out.println("*********************** B-Pool ********************************");
		
		
		
		//Now Let's make bingoPool using stream	
		//B-Pool ranging from 1-15
		

		var bStream =generateBStream();
//		bStream.forEach(System.out::println);
		
		
	
//		System.out.println("***************************************************");
		
		//I-Pool ranging from 16-30
		
		
		System.out.println("**********************  I-Pool *********************************");
		
		/*
		 * Our aim is to get the below result for generating I-Pool
		 * */
		
		var iStream =generateIStream();
//		iStream.forEach(System.out::println);
		
		
		System.out.println("***************************************************************");
		
		
		
		/*
		 * *************************** IMPORTANT NOTE ****************************
		 * IntStream: (B-Pool)
		 * .map() in IntStream expects an IntUnaryOperator as its argument. 
		 * An IntUnaryOperator is a functional interface that takes an int as input and produces an int as output.
		 * That's why we used mapToObj
		 * 
		 * Stream<Integer>: (I-Pool)
		 * .map() in Stream<Integer> expects a Function as its argument. 
		 * The Function takes an element of the stream (in this case, an Integer) as input and produces a result of any type as output.
		 * */
		
	}
	
	
	public static Stream<String> generateBStream(){
		IntStream intStream = IntStream.range(1, 100);
		
		var bStream = intStream
				.limit(15)
				//mapToObj will give no error while converting intStream to stringStream
				.mapToObj(t -> "B" + t);
		
		//Terminal operator
//		bStream.forEach(System.out::println);
		
		return bStream;
	}
	
	
	public static Stream<String> generateIStream(){
		
		
		
		Stream.generate(() -> (int)((Math.random() * 15) + 16))
				.limit(15)
				/* 
				 * The arrangement of dinstinct can play an interesting role as when placed after limit 
				 * it'll only take 15 numbers that may or may not contain multiple occurances of same number
				*/
				.distinct()
				.sorted();
//				.forEach(System.out::println);
	
	
		
		
		var iStream = Stream.generate(() -> (int)((Math.random() * 15) + 16))
				/*
				 * But when placed before limit it'll generate infinite number of distinct number also checking the next condition
				 * of limiting the generated number till 15
				 * then sorting it in an order provided by comparator.
				*/
				.distinct()
				.limit(15)
				.sorted()
				.map(t -> "I"+t);
				//.forEach(System.out::println);
		
		return iStream;
	}
	

	
	

}
