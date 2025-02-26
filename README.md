# Notice
This project is currently unfinished and while it may work at smaller scales it works pretty poorly when scaling large data samples.
I do want to keep working on this project in the future but for now I have school work to do and some other interesting projects that I'm wanting to work on.

# ASCII Graphing
This cool library allows data to be stored/graphed in simple ASCII.


## Types of Graphs
The ASCII Graphing package includes the following types of graphs:
<br>
### Modes
Due to the limitations of displaying graphs brought on by terminal lines there will be two main ways to create graphs when graphing with doubles
1. Efficient - Each value of a graph will take up only 1 line. For example if 0, 1, and 5 were to be graphed each would have its own line with an arrow to the left of it displaying its value i.e. 0, , etc. While this uses the least lines it does lose visualization accuracy as the spacing of points becomes uneven

2. Scaled - **Caution - This mode may cause massive performance issues, see [^1]** This maintains equal spacing between all points at the cost of space. For example, when graphing the points 0, 1, and 5 each line will have spacing between it graphing to 0, 1, 2, 3, 4, and 5.

### 2D
* Bar
    * Values will be graphed to the # of lines declared, if no scale is specified the top of the graph will fit to the highest data point. 
* Scatterd Point

### 3D
None yet but perhaps coming soon...


## Getting Started

Getting started is simple with some quick examples found in the `Examples` folder!


## Terminology

* DataSet - An object which stores some data along with helpful pieces of information to be included when graphed 
* Frame - Objects which store a completed graph
* Graph - Methods in the Graph class which graph DataSets returning a Frame object

## Footnotes

[^1]: While the Scaled mode does allow for more accurate visualizations it should be used with extreme care as graphing things may have unforseen large performence issues; Take for example 0.1 to graph this accurately, using only whole number amounts of lines, 10 lines will have to be created between every point to allow for the point to fit percisely.
