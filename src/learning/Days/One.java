package learning.Days;


import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class One {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello!!");
		Logger mLogger = Logger.getLogger(One.class.getName());
		
		// Syntax - 1 public void log(Level level, String msg)
		mLogger.log(Level.INFO,"This is an informative msg");
		mLogger.log(Level.SEVERE,"This is a severe msg");
		
		
		//Syntax - 2 public void log(Level level, String msg, Object param1)
		mLogger.log(Level.INFO,"INFO LOGSS! {0} WITH PARAMETERS","REPLACING");
		
		
		//more than one parameter
		//Syntax - 3 public void log(Level level, String msg, Object[] params)
		mLogger.log(Level.INFO,"INFO LOGSS, {0}th {1}st {2}rd parameters replaced!",new Object[] {"1","2","3"});
		
		
		//Syntax - 4 public void log(Level level, String msg, Throwable thrown)
		//In case logging error also can throw an exception along with it.
		mLogger.log(Level.SEVERE,
				"This is a severe error, exception!!",
				new RuntimeException("Exception while processing data"));
		
		//or can throw a generic exception
		mLogger.log(Level.SEVERE,
				"This is a severe error, exception!!",
				new Exception("Exception Occurred"));
		
		
		//Syntax - 5 public void log(Level level, Throwable thrown, Supplier msgSupplier) -- Lazy logging 
		Supplier<String> logSupplier = () -> new String("Supplier function for lazyy logging!!");
		
		mLogger.log(Level.SEVERE, new Exception("Error"),logSupplier);
		
		
		//you can also use the supplier function without throwing any error
		logSupplier = () -> new String("Supplier function for lazyy logging with throwing any exception!!");
		mLogger.log(Level.WARNING, logSupplier);
		
		
		//Syntax - 6 public void log(LogRecord record)
		LogRecord record1 = new LogRecord(Level.INFO,"logs created via LogRecord method with info as level!");
		mLogger.log(record1);
		
		
		
		
	}

}
