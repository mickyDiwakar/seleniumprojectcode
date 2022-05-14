package ConfigfileReader;

public class fileReaderManager {
	private static fileReaderManager filereaderManager=null;
	private static ConfigFileReader configFileReader;
	//priavte constructor to stop making instance from outside the class
	private fileReaderManager() {
		
	}
	public static fileReaderManager getfileReaderManagerInstance() {
		
		return (filereaderManager==null)?new fileReaderManager():filereaderManager;
		
	}
	public ConfigFileReader getConfigReader() {
		return (configFileReader==null)?new ConfigFileReader():configFileReader;
	}

}
