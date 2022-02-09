package kmeans;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataLoader {
	private String filespec;
	
	public DataLoader(final String filespec) {
		this.filespec = filespec;
	}
	
	public ArrayList<DataObject> load() throws IOException {
		
		ArrayList<DataObject> dataObjects = new ArrayList<DataObject>();
		
		Scanner fin = new Scanner(new FileInputStream(filespec));
		
		while (fin.hasNextLine()) {
			String[] rawRow = fin.nextLine().trim().split("\\s+");
			
			ArrayList<Double> data = new ArrayList<Double>();
			
			for (String col : rawRow) {
				data.add(Double.parseDouble(col));
			}
			
			dataObjects.add(new DataObject(null, data));
		}
		
		fin.close();
		
		return dataObjects;
	}
}
