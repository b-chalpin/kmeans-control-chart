package kmeans;

import java.util.ArrayList;

public class Cluster {
	public int id;
	public DataObject centroid; 
	
	private ArrayList<DataObject> assignedDataObjects = new ArrayList<DataObject>();
	
	public Cluster(final int id, final DataObject centroid) {
		this.id = id;
		this.centroid = centroid;
	}
	
	public void resetClusterData() {
		this.assignedDataObjects.clear();
	}
	
	public void assignDataObject(final DataObject dataObject) {
		this.assignedDataObjects.add(dataObject);	
	}
	
	public void updateCentroid() {
		DataObject newCentroid = new DataObject(this, new ArrayList<Double>(this.centroid.data.size()));
		
		for (int i = 0; i < this.centroid.data.size(); i++) {
			double colSum = 0.0;
			
			for (DataObject dataObject : this.assignedDataObjects) {
				colSum += dataObject.data.get(i);
			}
	
			newCentroid.data.add(i, colSum / this.assignedDataObjects.size());
		}

		this.centroid = newCentroid;
	}
}
