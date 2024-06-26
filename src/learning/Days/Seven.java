package learning.Days;

import java.util.Random;
import java.util.stream.Stream;

public class Seven {

	public static void main(String[] args) {
		Random random = new Random();
		
		var employeeList = Stream.iterate(126, t -> random.nextInt(1000)).distinct().limit(10);
		
		
		employeeList.map(t -> new Employee("E" + t,random.nextLong(20000, 500000),Department.values()[random.nextInt(8)].toString(),random.nextBoolean()))
		.forEach(t -> System.out.println(t.toString()));

		/* Output
		 * 
		 	Employee [EmployeeCode=E126, Salary=357800, Department=DEPT4, hashCode()=985922955]
			Employee [EmployeeCode=E814, Salary=130448, Department=DEPT2, hashCode()=357863579]
			Employee [EmployeeCode=E616, Salary=455783, Department=DEPT8, hashCode()=1811044090]
			Employee [EmployeeCode=E913, Salary=135495, Department=DEPT5, hashCode()=114132791]
			Employee [EmployeeCode=E644, Salary=189406, Department=DEPT6, hashCode()=586617651]
			Employee [EmployeeCode=E849, Salary=284901, Department=DEPT4, hashCode()=328638398]
			Employee [EmployeeCode=E147, Salary=313765, Department=DEPT4, hashCode()=1789550256]
			Employee [EmployeeCode=E182, Salary=426005, Department=DEPT4, hashCode()=3447021]
			Employee [EmployeeCode=E521, Salary=114982, Department=DEPT4, hashCode()=440434003]
			Employee [EmployeeCode=E935, Salary=49419, Department=DEPT1, hashCode()=1032616650]
		 
		 * */
		
		/*
		 * 
			int i = 0;
			
			//random intstream generated by Random class
			random.ints(4,0,1000).forEach(System.out::println);
			while(i!=5) {
				System.out.println(random.nextInt(1000));
				System.out.println(random.nextLong(500000));
				System.out.println(random.nextBoolean());
				
				i++;
			}
		*
		*/
		
	}
}
