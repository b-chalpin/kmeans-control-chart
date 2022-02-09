package kmeans;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class OutputWriter {
	public OutputWriter() {}
	
	public void writeClusterOutput(final ArrayList<DataObject> clusteredData) throws IOException {
		for (int i = 0; i < clusteredData.size(); i++) {
			this.writeClusteredDataObject(i, clusteredData.get(i));
		}
	}
	
	private void writeClusteredDataObject(final int index, final DataObject cluster) throws IOException {
		FileWriter writer;
		
		if (cluster.assignedCluster == null) {
			writer = new FileWriter("output/kmeans_cluster_null.txt", true);
		}
		else {
			writer = new FileWriter("output/kmeans_cluster_" + (cluster.assignedCluster.id + 1) + ".txt", true);
		}
		
		String rowStr = "";
		for (Double col : cluster.data) {
			rowStr += col + " ";
		}
		writer.write(rowStr.trim() + System.lineSeparator());
		
		writer.close();
	}
}
