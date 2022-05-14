package ConfigfileReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Base64;
import java.util.Properties;

import javax.management.RuntimeErrorException;

public class ConfigFileReader {
	BufferedReader reader;
	private Properties p;
	public ConfigFileReader()  {
		try {
			reader=new BufferedReader(new FileReader("src\\resource\\java\\configs\\Config.properties"));
			p=new Properties();
		try {
				p.load(reader);
				
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		}catch(FileNotFoundException e) {
			throw new RuntimeException("properties file not found");
				
		}finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public long getpageLoadTimeOut() {
		String pageloadtimeout= p.getProperty("pageLoadTimeOut");
		if(pageloadtimeout!=null) {
			return Long.valueOf(pageloadtimeout);
		}else {
			throw new RuntimeException("pageloadtimeout  is not specified in properties file");
		}
	
	}

	public String getBrowser() {
		String browser= p.getProperty("browser");
		if(browser!=null) {
			return browser;
		}else {
			throw new RuntimeException("browser  is not specified in properties file");
		}
	
	}
	public String getEnvironment() {
		String env=p.getProperty("environment");
		if(env!=null) {
			return env;
		}else {
			throw new RuntimeException("env  is not specified in properties file");
		}
	}
	public long getImplictwait() {
		String implicitlyWait=p.getProperty("implicitlyWait");
		if(implicitlyWait!=null) {
			return Long.parseLong(implicitlyWait) ;
			
		}else {
			throw new RuntimeException("implicitlyWait  is not specified in properties file");
		}
	}
	public String geturl() {
		String url=p.getProperty("crmPro.Url");
		if(url!=null) {
			return url;
		}else {
			throw new RuntimeException("url  is not specified in properties file");
		}
	}
	
	public String getCRMUserName() {
		String userName=p.getProperty("crm.userName");
		if(userName!=null) {
			return userName;
		}else {
			throw new RuntimeException("userName  is not specified in properties file");
		}
	}
	public String getcogmentourl() {
		String url=p.getProperty("crmPro.Url");
		if(url!=null) {
			return url;
		}else {
			throw new RuntimeException("url  is not specified in properties file");
		}
	}
	public String getCRMPassword() {
		byte[] Password = p.getProperty("crm.Password").getBytes();
		String encodedPassword=Base64.getEncoder().encodeToString(Password);
		if (Password != null) {
			return encodedPassword;
		} else {
			throw new RuntimeException("Password  is not specified in properties file");
		}
		
	}
	
	public String getCognetoUserName() {
		String uName = p.getProperty("crm.userName");
		if (uName != null) {
			return uName;
		}else {
			throw new RuntimeException("username is null in property file");
		}

	}
	public String getCognetoPassworde() {
		String pwd=p.getProperty("crm.Password");
		if(pwd!=null) {
			return pwd;
		}else {
			throw new RuntimeException("password is blank in prop filed");
		}
	}
	public String getUrlOfDemo() {
		String UrlDemo=p.getProperty("demo.Url");
		if(UrlDemo!=null) {
			return UrlDemo;
		}else {
			throw new RuntimeException("Url in prop file is blank");
		}
		
	}
	public String getToolsQAUrl() {
		String toolsQAUrl=p.getProperty("toolsQA.Url");
		if(toolsQAUrl!=null) {
			return toolsQAUrl;
			
		}else {
			throw new RuntimeException("url of toolsqa is missing in proopertyy file");
		}
	}

}
