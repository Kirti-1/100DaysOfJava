package learning.Days;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Supplier;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;


class CustomFormatter extends Formatter{
	
	// Define the date format
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public String format(LogRecord record) {
        // Get the current time
        long millis = record.getMillis();
        Date date = new Date(millis);

        // Format the date
        String formattedDate = dateFormat.format(date);

        // Return the formatted date
        return formattedDate;
    }
}

public class One {

	private static final Logger mLogger = Logger.getLogger(One.class.getName());
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello!!");
		// It doesn't matter what you inside Logger.getLogger("j") if it's defined inside a class it'll take that class name bydefault
		
		/*
		 * 
		 * *** When you set the logger level to INFO, 
		 * the logger should log messages at the INFO level or higher (INFO, WARNING, SEVERE), 
		 * but not messages at lower levels (FINE, FINER, FINEST).
		 * *** When you set the logger level to SEVERE, 
		 * the logger should only log messages at the SEVERE level.
		 * *** When you set the logger level to WARNING, 
		 * the logger should log messages at the WARNING level or higher (WARNING, SEVERE), 
		 * but not messages at lower levels (INFO, FINE, FINER, FINEST).
		 * */
		
		
		mLogger.setLevel(Level.INFO);
		
		
		ConsoleHandler handler1 = new ConsoleHandler();
		
		CustomFormatter formatter = new CustomFormatter();
		handler1.setFormatter(formatter);
		mLogger.addHandler(handler1);
		
		
		// Get the handlers associated with the logger
        Handler[] handlers = mLogger.getHandlers();

        
        // Iterate through the handlers
        for (Handler handler : handlers) {
            // Check if the handler is an instance of ConsoleHandler
            if (handler instanceof ConsoleHandler) {
                ConsoleHandler consoleHandler = (ConsoleHandler) handler;
                // Do something with the console handler
                System.out.println("Found ConsoleHandler: " + consoleHandler);
            }
        }
		
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
		//for more cleaner logging
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
