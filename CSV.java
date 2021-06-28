/**
 * 
 */
package utilities;
import java.util.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author ynfor
 *
 */
public class CSV {
	
	// Method reads data from a CSV file and return file as a list
	public static List<String[]> read(String file){
		List<String[]> data = new LinkedList<String[]>();
		String dataRow;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			while ((dataRow = reader.readLine()) != null) {
				String[] dataRecords = dataRow.split(",");
				data.add(dataRecords);
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("FILE NOT FOUND");
			e.printStackTrace();
		}
		catch (IOException e) {
			System.out.println("FILE NOT FOUND");
			e.printStackTrace();
		}
		return data;
	}

}
