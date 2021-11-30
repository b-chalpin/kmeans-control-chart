# Assignment: CSCD429 HW4
# Instructor: Dr. Li
# Author: Blake Chalpin

# Libraries
install.packages("ggpubr")
library(ggpubr)

install.packages("factoextra")
library(factoextra)

# Load data
data <- read.table("synthetic_control_data.txt", header = FALSE)
str(data)

# Use kmeans to cluster the data
clustered_data <- kmeans(data, centers = 6)

# Visualize the data
fviz_cluster(res.km, data = data,
             palette = c("#2E9FDF", "#00AFBB", "#E7B800", 
                         "#c21e1e", "#7b6aa7", "#d2893d"), 
             geom = "point",
             ellipse.type = "convex", 
             ggtheme = theme_bw())
