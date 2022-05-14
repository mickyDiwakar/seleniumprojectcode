package commonUtils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Logg {
	public static Logger log;
	
	
	public static Logger getLogger(Class clazz) {
		log=Logger.getLogger(clazz);
		PropertyConfigurator.configure("src\\resource\\java\\configs\\log4j.properties");
		return log;
		
	}

}
