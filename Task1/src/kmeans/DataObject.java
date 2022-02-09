package kmeans;

import java.util.ArrayList;

public class DataObject {
	public Cluster assignedCluster;
	public ArrayList<Double> data;
	
	public DataObject(final Cluster assignedCluster, final ArrayList<Double> data) {
		this.assignedCluster = assignedCluster;
		this.data = data;
	}
}
