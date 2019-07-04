package pageObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;



public class ReadFilee {

	public static String getLocatorValue(String locatorName, String fileName) {
		StringBuilder contents = new StringBuilder();
		String file = "src/pageObject/";
		File filePath = new File(file + File.separator + "xpath.txt");
		System.out.println(filePath);

		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			String s;

			while ((s = br.readLine()) != null) {
				contents.append(s);
				contents.append("->");
			}

		} catch (IOException e) {
			System.out.println("Cannot read the text file");
		}
		return contents.toString();
	}
	/*
	 * public void recieve(String locator,String fileName) { String
	 * data=ReadFilee.getLocatorValue(locator, fileName); String[]
	 * dataArray=data.split(","); for(int i=0;i<dataArray.length;i++) {
	 * System.out.println(dataArray); } }
	 */

	public static String recieve(String locator, String fileName) {
		String data = ReadFilee.getLocatorValue(locator, fileName);
		String[] dataArray = data.split("->");
		String locatorValue="";
		for (int i = 0; i < dataArray.length; i++) {
			if (dataArray[i].split(":")[0].equalsIgnoreCase(locator)) {
				locatorValue=dataArray[i].split(":")[1];
				System.out.println(dataArray[i].split(":")[1]);
			}
		}
		return locatorValue;
	}

	public static void main(String[] args) {
		recieve("clickOnBasic", "xpath.txt");
	}
}
