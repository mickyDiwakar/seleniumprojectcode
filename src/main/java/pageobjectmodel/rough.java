package pageobjectmodel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class rough {
	
	
	public static void main(String args[]) throws IOException {
		String str ="india is my c12343ounty";
		char[] ch=str.toCharArray();
		String newStr="";
		for(char c:ch) {
			if(!Character.isDigit(c)) {
				newStr+=c;
			}
		}
		System.out.println(newStr);
		char[] chr=newStr.toCharArray();
		Map<Character,Integer> map=new HashMap<Character,Integer>();
		for(char c:chr) {
			if(!map.containsKey(c)) {
				map.put(c, 1);
			}else {
				map.put(c, map.get(c)+1);
			}
		}
		for(Entry<Character, Integer> m:map.entrySet()) {
		System.out.println(m.getKey()+":"+m.getValue());	
		}
		
		Integer[] a= {1,2,4};
		Integer[] ab= {11,2,7,4};
	List<Integer>l1=new ArrayList<Integer>(Arrays.asList(a));
	//	List<Integer>l2=new ArrayList<Integer>(Arrays.asList(ab));
		//List<Integer>l1=Arrays.asList(a);
		List<Integer>l3=Arrays.asList(ab);
		l1.addAll(l3);
		System.out.println(l1.size());
		Set<Integer>s=new HashSet<Integer>(l1);
		
		for(Integer j:s) {
			//System.out.println(j);
		}
		
		//Integer[] p=new Integer[s.size()];
		Integer[] p=s.toArray(new Integer[s.size()]);
		System.out.println(p.length);
		Map<String,Integer>mapnew=new HashMap<String,Integer>();
		mapnew.put("roll",1);
		mapnew.put("nhame",5);
		mapnew.put("fa",3);
		mapnew.put("tq",2);
		//mapnew.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()));
		//Collections.sort(mapnew, Comparator.naturalOrder());
		SortedMap<String,Integer> mapsort=new TreeMap<String,Integer>(mapnew);
		for(Map.Entry<String,Integer>m:mapnew.entrySet()) {
			System.out.println(m.getValue());
		}
		String str1="rakm";
		String str2="";
	if(str1.matches("..k*")) {
		System.out.println("ram");
	}
	String SSN="CJRPK9998p";
	String patterm="^[A-Z]{5}+[0-9]{4}+[a-zA-Z]{1}$";
	Boolean b=Pattern.matches(patterm,SSN );
	Boolean aB1=SSN.matches(patterm);
	System.out.println(aB1);
	String url="https://www.guru99.com/find-broken-links-selenium-webdriver.ht";
		/*
		 * HttpURLConnection huc1=(HttpURLConnection)(new URL(url).openConnection());
		 * //huc1.setRequestMethod("HEAD"); huc1.connect(); int
		 * resp=huc1.getResponseCode(); System.out.println(resp);
		 */
	System.out.println(SSN.substring(2));	
	FileInputStream fis=new FileInputStream(new File("C:\\Users\\Admin\\Desktop\\seleniumtopics\\testdata.xlsx"));
	Workbook wb=new XSSFWorkbook(fis);
	 
	}
}
