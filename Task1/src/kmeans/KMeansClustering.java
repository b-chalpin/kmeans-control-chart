package kmeans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class KMeansClustering {
	private int k;
	
	public KMeansClustering(final int k) {
		this.k = k;
	}
	
	public ArrayList<DataObject> cluster(final ArrayList<DataObject> data) {
		// pick initial centroids
		ArrayList<Cluster> clusters = this.pickRandomInitialCentroids(data);
		
		int reassignments = -1;
		while (reassignments != 0) { // stop condition once we stop reassigning data objects
			reassignments = 0;
			
			// reset the list of clustered data objects in each cluster object (this does not reset centroids)
			for (Cluster cluster : clusters) {
				cluster.resetClusterData();
			}
			
			for (DataObject dataObject : data) {
				boolean isReassigned =  this.reassignDataObjectToCluster(dataObject, clusters); // returns true if there is a reassignment, false if not
				
				if (isReassigned) {
					reassignments++;
				}
			}
			
			// update centroids of clusters
			for (Cluster cluster : clusters) {
				cluster.updateCentroid();
			}
		}
		
		return data;
	}
	
	private ArrayList<Cluster> pickRandomInitialCentroids(final ArrayList<DataObject> data) {
		ArrayList<Cluster> clusters = new ArrayList<Cluster>(
				Arrays.asList(
							new Cluster(0, null), // cluster 1
							new Cluster(1, null), // cluster 2
							new Cluster(2, null), // cluster 3
							new Cluster(3, null), // cluster 4
							new Cluster(4, null), // cluster 5
							new Cluster(5, null)  // cluster 6
						)
			);
		
		// pick k random centroids from data
		int[] initialCentroidIndices = new Random().ints(0, data.size() - 1).distinct().limit(k).toArray();
		
		for (int i = 0; i < k; i++) {
			DataObject centroid = data.get(initialCentroidIndices[i]);
			Cluster cluster = clusters.get(i);
			
			cluster.centroid = centroid;
			centroid.assignedCluster = cluster;
		}
		
		return clusters;
	}

	private boolean reassignDataObjectToCluster(final DataObject dataObject, ArrayList<Cluster> clusters) {
		ArrayList<Double> distanceToClusters = new ArrayList<Double>(this.k);
		
		for (Cluster cluster : clusters) {
			distanceToClusters.add(this.calculateDistance(dataObject, cluster.centroid));
		}
		
		// get index of cluster with minimum distance 
		int minDistanceIndex = distanceToClusters.indexOf(Collections.min(distanceToClusters));
		
		Cluster closestCluster = clusters.get(minDistanceIndex);
		
		// add data object to the closest cluster
		closestCluster.assignDataObject(dataObject);
		
		if (dataObject.assignedCluster == null) { // if we're on the first pass
			dataObject.assignedCluster = closestCluster;
			
			return true;
		}
		else {	
			int prevClusterId = dataObject.assignedCluster.id;
			
			// reassign data object to closest cluster
			dataObject.assignedCluster = closestCluster;
			
			return !(prevClusterId == minDistanceIndex); // return true if new cluster id does not match
		}
	}
	
	// euclidean distance measure
	private double calculateDistance(final DataObject u, final DataObject v) {
        double sum = 0;
        
        for(int i = 0; i < u.data.size() ; i++) {
           sum = sum + Math.pow((u.data.get(i) - v.data.get(i)), 2.0);
        }
        
        return Math.sqrt(sum);
	}
}
