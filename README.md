# K-Means Control Chart Clustering

## Requirements

Tasks:

1. Clustering: implement k-means clustering algorithm in JAVA to find six clusters from
   control chart data. Once the clusters are formed, extract the examples that belong to the
   same cluster into a .txt file. All together, your program should output six .txt files.
2. Visualization using RapidMiner: Use appropriate “chart view” to visualize the six
   clusters found from the previous step. As an example, the following graph is the
   visualization of one cluster using RapidMiner.
3. Clustering and Visualization using R: use R to generate six clusters from
   control chart data, and use R to visualize the six clusters.

## Specifications

### Dataset

The dataset synthetic_control_data.txt contains 600 examples of control chart
time series data. The data is stored in an ASCII file, 600 rows, 60 columns, with a single chart
per line. There are six different classes of control charts:

- Normal
- Cyclic
- Increasing trend
- Decreasing trend
- Upward shift
- Downward shift

### Deliverables

- Workable program files and result files for Task 1.
- Six images generated for Task 2 using RapidMiner.
- Workable R code and result images for Task 3.

## Installation

To run the program, execute the following commands in the terminal:

```
$cd Task1/src
$javac KMeansMain.java
$java KMeansMain
```

## Author

Blake Chalpin ([b-chalpin](https://github.com/b-chalpin))

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License

[MIT](https://choosealicense.com/licenses/mit/)
