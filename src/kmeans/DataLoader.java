package kmeans;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataLoader {
	private String filespec;
	
	public DataLoader(String filespec) {
		this.filespec = filespec;
	}
	
	public ArrayList<String[]> load() throws IOException {
		
		ArrayList<String[]> data = new ArrayList<String[]>();
		
		Scanner fin = new Scanner(new FileInputStream(filespec));
		
		while (fin.hasNextLine()) {
			data.add(fin.nextLine().split("\\s+"));
		}
		
		fin.close();
		
		return data;
	}
}
