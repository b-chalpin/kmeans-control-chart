import java.io.IOException;
import java.util.ArrayList;
import kmeans.*;

public class CSCD429HW4Main {
	public static void main(String[] args) throws IOException {
		System.out.println("Beginning k-means clustering for 6 clusters...");
		
		// load data
		DataLoader loader = new DataLoader("synthetic_control_data.txt");
		ArrayList<DataObject> data = loader.load();
		
		// do k-means clustering for 6 clusters
		int k = 6;
		KMeansClustering kMeansClustering = new KMeansClustering(k);
		ArrayList<DataObject> clusters = kMeansClustering.cluster(data); 
		
		// write 6 clusters to output
		OutputWriter outputWriter = new OutputWriter();
		outputWriter.writeClusterOutput(clusters);
		
		System.out.println("Clustering complete.");
	}
}
