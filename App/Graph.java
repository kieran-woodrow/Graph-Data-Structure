/*
Complete your details...
Name and Surname: Kieran Woodrow
Student/staff Number: u19304308
*/

/*
 You must complete this class to solve the Chinese Postman problem for any given graph.
 Additional instructions are provided in comments throughout the class.
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class Graph 
{

				//GLOBAL VARIABLES BELOW
	//------------------------------------------------------------
	int edgeArraySize=0;
	int vertexArraySize=0;
	Vertex[] vertexArray;
	Edge[] edgeArray;
	String edges="";
	Edge [] edgeArrayForVertex;

	//void populateArray(edgeArrayForVertex, vertexArray);
		
	


				//GLOBAL VARIABLES BELOW END
	//------------------------------------------------------------

	/*
	 * 1. You may not change the signatures of any of the given methods. You may
	 * however add any additional methods and/or fields which you may require to aid
	 * you in the completion of this assignment.
	 * 
	 * 2. You will have to design and implement your own Graph class in terms of
	 * graph representation.
	 * 
	 * 3. You may add any additional classes and/or methods to your assignment.
	 */

	public Graph(String f) 
	{
		/*
		The constructor receives the name of the file from which a graph
		is read and constructed.
		*/
		if( f != "")
		{
			try
			{
				File file = new File(f); 
				Scanner myReader = new Scanner(file);
				vertexArraySize=myReader.nextInt();
				//System.out.println(arrayNumber);
				
				vertexArray = new Vertex[vertexArraySize];
				edgeArray = new Edge[vertexArraySize*3];
		
					while ( myReader.hasNext() ) 
					{	
						Scanner Line=new Scanner(myReader.next());
						Line.useDelimiter(",");
						
						String firstVertex=Line.next();
						Vertex A=new Vertex(firstVertex);
						addVertexFunction(A, vertexArray);
			
						String secondVertex=Line.next();
						Vertex B=new Vertex(secondVertex);
						addVertexFunction(B, vertexArray);
			
						int weight=Line.nextInt();
			
						addEdgeFunction(findVertexFunction(A, vertexArray), findVertexFunction(B, vertexArray), weight, edgeArray);
						
					}
	
				myReader.close();
		
				sortVertexArray(vertexArray);//sort the array once everything is added so that it can be traversed in alphavetical order
			
				//for testing purposes
				// for(int i=0; i<vertexArraySize; i++)
				// {
				// 	System.out.print(vertexArray[i].vertexName+" ");

				// }
				// System.out.println();
				// System.out.println();

				// for(int i=0; i<edgeArraySize; i++)
				// {
				// 	System.out.print(edgeArray[i].startVertex.vertexName+" "+edgeArray[i].endVertex.vertexName+" "+edgeArray[i].weight+" "+" ");
					
				// }
				// for( int t=0; t<vertexArraySize; t++)
				// {
				// 	//vertexArray[t].edgeArrayForVertex=getAdjacentEdges(vertexArray[t].vertexName);
				// 	//sortEdge(vertexArray[t].edgeArrayForVertex);
				// 	Vertex [] temp=getAdjacentVertex(vertexArray[t].vertexName);
				// 	//vertexArray[t]
				// 	Edge [] Temp=getAdjacentEdges(temp[t].vertexName);
				// 	vertexArray[t].edgeArrayForVertex=Temp;
				// }

				// for(int i=0; i < vertexArray[i].edgeArrayForVertex.length; i++)
				// {
				// 	{
				// 		if(vertexArray[i].edgeArrayForVertex[i] != null)
				// 			System.out.println(vertexArray[i].edgeArrayForVertex[i].startVertex.vertexName+" "+ vertexArray[i].edgeArrayForVertex[i].endVertex.vertexName+" "+ vertexArray[i].edgeArrayForVertex[i].weight);
				// 	}
				// }
	


			}

			catch(FileNotFoundException e)
			{

			}
		}
	}
	
	public Graph clone()
	{
		/*
		The clone method should return a deep copy/clone
		of this graph.
		*/
		Graph clonedGraph = new Graph();

		clonedGraph.vertexArray = new Vertex[vertexArraySize];
		clonedGraph.edgeArray = new Edge[vertexArraySize*3];

            for (int i = 0; i< vertexArraySize; i++)
            {
				if( vertexArray[i] != null )
				{
					clonedGraph.vertexArray[i] = vertexArray[i];
					clonedGraph.vertexArraySize++;
				}
            }

			for (int j = 0; j < edgeArraySize; j++) 
			{
				if( edgeArray[j] != null )
				{
					clonedGraph.edgeArray[j] = edgeArray[j];
					clonedGraph.edgeArraySize++;
				}
			}
			
        return clonedGraph;
	}
		
	public boolean reconstructGraph(String fileName) 
	{
		/*
		This method should discard the current graph and construct a new
		graph contained in the file named "fileName". Return true if reconstruction
		was successful.
		*/
		boolean value=false;

		if( fileName != "")
		{
			try
			{
				vertexArray=null; //set to null
				edgeArray=null;
				edgeArraySize=0;
				vertexArraySize=0;
		
				File file = new File(fileName); 
				Scanner myReader = new Scanner(file);
				vertexArraySize=myReader.nextInt();
			   //System.out.println(arrayNumber);
		
				vertexArray = new Vertex[vertexArraySize];
				edgeArray = new Edge[vertexArraySize*3];
		
					while ( myReader.hasNext() ) 
					{	
						Scanner Line=new Scanner(myReader.next());
						Line.useDelimiter(",");
						
						String firstVertex=Line.next();
						Vertex A=new Vertex(firstVertex);
						addVertexFunction(A, vertexArray);
		
						String secondVertex=Line.next();
						Vertex B=new Vertex(secondVertex);
						addVertexFunction(B, vertexArray);
		
						int weight=Line.nextInt();
		
						addEdgeFunction(findVertexFunction(A, vertexArray), findVertexFunction(B, vertexArray), weight, edgeArray);  
					}
	
			   myReader.close();
		
			   sortVertexArray(vertexArray);
		
			   value=true;
		
					if(value==true)
					{
						return true;
					}
			}

			catch (FileNotFoundException e)
			{

			}

		}
		
		return false;
	}

	public int numEdges(String u, String v)
	{
		/*
		This method returns the number of direct edges between u and v vertices.
		If there are no direct edges, return 0.
		In there is 1 or more direct edges, return the number of edges.
		*/

		int numEdgeCounter=0;

		if( u != "" && v != "")
		{
			for (int k=0; k < edgeArraySize; k++)
			{
				if( edgeArray[k] != null )
				{
					if( edgeArray[k].startVertex.vertexName.equals(u) && edgeArray[k].endVertex.vertexName.equals(v) )
					{
						numEdgeCounter++;
					}
					
					if (edgeArray[k].startVertex.vertexName.equals(v) && edgeArray[k].endVertex.vertexName.equals(u)  )
					{
						numEdgeCounter++;
					}
				}
					
			}
		}

        return numEdgeCounter;
	}
	
	public int getDegree(String u)
	{
		/*
		This method returns the degree of vertex u.
		*/
		int degreeCounter=0;

		if( u != "")
		{
			for ( int k = 0; k < edgeArraySize; k++ ) 
			{
				if( edgeArray[k] != null )
				{
					if( edgeArray[k].startVertex.vertexName.equals( u ) )
					{
						degreeCounter++;
					}
					
					if( edgeArray[k].endVertex.vertexName.equals( u ) )
					{
						degreeCounter++;
					}	
				}
			
			}
		}
			
        return degreeCounter;	
	}
	
	
	public boolean changeLabel(String v, String newLabel)
	{
		/*
		Change the label of the vertex v to newLabel.  The method returns true
		if the label change was successful, and false otherwise.
		*/
		if( v != "")
		{
			for( int k = 0; k < vertexArraySize; k++ )
			{
				if( vertexArray[k] != null )
				{
					if( vertexArray[k].vertexName.equals(v) ) 
					{
						vertexArray[k].vertexName = newLabel;
						return true;
					}
				}	
			}
		}

		return false;
	}

	public String depthFirstTraversal(String v)
	{
		// /*
		// This method returns a depth first traversal of the graph,
		// starting with node v. When there is choice between vertices,
		// choose in alphabetical order.
		
		// The list must be separated by commas containing no additional 
		// white space.
		// */
		if( v != "")
		{
			Vertex newVertex=new Vertex(v);

			newVertex=findVertexFunction(newVertex, vertexArray);
	
			if( newVertex != null )
			{
					edges=newVertex.vertexName+",";
			
					int indexNumber=findVertexFunctionIndex(newVertex, vertexArray);
					int counter=0;
			
						while(  counter < vertexArraySize )
						{
							if( vertexArray[counter].visited == false && vertexArray[counter] != null )
							{
								depthfirstRecursiveHelperFunction( vertexArray[indexNumber] );
							}
							
							counter++;	
						}
			
							for(int i=0; i< vertexArraySize; i++) //RESET ALL VALUES BACK TO FALSE
							{
								if( vertexArray[i] != null )
								{
									vertexArray[i].visited=false;
								}
							}
			
					int comma = edges.length(); 
			
					edges = edges.substring(0,comma-1) ;
			
					return edges;
			
			}

		}
	

		return "";	
	}

	//TASK 1 END HERE
	public String getOdd()	
	{
		/*
		This method returns a list of all vertices with odd degrees.
		The vertices should be sorted alphabetically. If there are no
		vertices with odd degrees, return an empty string.
		
		The list must be separated by commas containing no additional 
		white space.
		*/

		String listOfOddvertices="";
		int numberOfDegree=0;

			for( int k = 0; k < vertexArraySize; k++)
			{
				if( vertexArray[k] != null)
				{
					numberOfDegree=getDegree( vertexArray[k].vertexName );

					if( numberOfDegree %2 !=0 )
					{
						listOfOddvertices=listOfOddvertices+vertexArray[k].vertexName+",";
					}

				}
			}

		int comma = listOfOddvertices.length(); 
		listOfOddvertices = listOfOddvertices.substring(0,comma-1);

		return listOfOddvertices;

		
	}
	
	public String getPath(String u, String v)
	{
		/*
		This method should return the shortest path between two vertices.
		Inputs are the vertex labels, as read from the input file.
		
		The returned string should be the vertex labels, starting with u and
		ending with v. The list must be separated by commas containing no additional 
		white space.
		
		Assumption: both vertices are present in the graph, and a path between 
		them exists.
		*/

	
		// int distance=0;


		// Vertex [] newArray=new Vertex[vertexArraySize];

		// for( int i = 0; i < vertexArraySize; i++)
		// {
		// 	if( vertexArray[i] != null )
		// 	{
		// 		newArray[i]=vertexArray[i];
		// 	}
		// }

		// // int x=findVertexFunctionIndex(startVertex, newArray);
		// // newArray[x].distance=0;
		// startVertex.setDistance(0);

		// int counter=0;
		// while( newArray[counter] != null && counter < newArray.length && newArray[counter].visited == false ) 
		// {
		// 	Vertex current=newArray[counter];
		// 	current.visited = true;

		// 	int count=getAdjacentEdgesSize(current.vertexName);

		// 	Edge [] kieran=new Edge[count];
		// 	kieran=getAdjacentEdges(current.vertexName);

		// 	for(int k = 0; k < count; k++)
		// 	{
		// 		if( kieran[k] != null)
		// 		{
		// 			distance=current.getDistance() + kieran[k].weight;
				
		// 			if( distance < kieran[k].endVertex.distance )
		// 			{
		// 				kieran[k].endVertex.setDistance(distance);
		// 				kieran[k].endVertex.setPredecessor(current);

		// 				if( kieran[k].endVertex.visited == true)
		// 				{
		// 					if(newArray[k] == null)
		// 					{
		// 						newArray[k]=kieran[k].endVertex;
		// 					}
		// 				}

		// 				kieran[k].endVertex.visited=false;
		// 			}
		// 		}

		// 	}
		// 	counter++;
		// }

		// Vertex [] newNewList= new Vertex[vertexArraySize*2];

		// if( endVertex.distance == 2147483647 )
		// {
		// 	//return newNewList;
		// 	return "";
		// }
		
		// else
		// {
		// 	Vertex temp=endVertex;

		// 	int tallyho=0;
		// 	while(true)
		// 		{
		// 			if( newNewList[tallyho] == null ) 
		// 			{
		// 				newNewList[tallyho]=temp;
		// 			}

		// 			if( temp == startVertex )
		// 			{
		// 				break;
		// 			}

		// 			temp=temp.getPredecessor();
		// 		}
		// }

		// for(int t =0; t < newNewList.length; t++ )
		// {
		// 	if( newNewList[t] != null)
		// 	{
		// 		path=path+newNewList[t].vertexName+",";
		// 	}
		// }


		// int comma = path.length(); 
	
		// path = path.substring(0,comma-1) ;
			
		// return path;

		//return "";
		// Vertex [] unvisitedVertices = new Vertex[vertexArraySize];
		// Vertex a=new Vertex(u);

		// populateArray(unvisitedVertices, vertexArray);
		// int cf=findVertexFunctionIndex(a, unvisitedVertices);
		// unvisitedVertices[cf].distance=0;

		// recursiveDjiska(u, v, unvisitedVertices);

		// String [] path=new String[s.length];
		// // for(int h=0; h<path.length; h++)
		// // {
		// // 	path[h]="";
		// // }

		// path=s;

		// String g="";
		// int y=0;

		// // for(int e=0; e<path.length; e++)
		// // {
		// // 	if(path[e] != null)
		// // 	{
		// // 		y++;
		// // 	}
		// // }

		// 	for(int n=path.length-1; n >= 0; --n)
		// 	{
		// 		if( path[n] != null )
		// 		{
		// 			if(path[n] != "")
		// 			{
		// 				g=g+path[n]+",";
		// 				y++;
						
		// 			}
		// 		}
				
		// 	}
			
		// int comma = y*2; 
	
		// g = g.substring(0,comma-1) ;
			
		// return g;
		
	

		// for(int i=0; i < start.edgeArrayForVertex.length; i++)
		// {
		// 	if(start.edgeArrayForVertex[i] != null)
		// 		System.out.println(start.edgeArrayForVertex[i].startVertex.vertexName+" "+ start.edgeArrayForVertex[i].endVertex.vertexName+" "+ start.edgeArrayForVertex[i].weight);
		// }

		// for(int f=0; f < end.edgeArrayForVertex.length; f++)
		// {
		// 	if(start.edgeArrayForVertex[f] != null)
		// 		System.out.println(end.edgeArrayForVertex[f].startVertex.vertexName+" "+ end.edgeArrayForVertex[f].endVertex.vertexName+" "+ end.edgeArrayForVertex[f].weight);
		// }
		// Vertex start=new Vertex(u);
		
		// Vertex [] copy=new Vertex[vertexArraySize];
		// copy=populateArray(copy, vertexArray);
		// copy=alwaysAtFront(start, copy);
		// copy[0].setDistance(0);

		// for(int i=0; i < copy.length; i++)
		// {
		// 	int h=getAdadjacencySizeFunction(copy[i].vertexName);
		// 	Vertex [] A= new Vertex[h];

		// 	A=getAdjacentVertex(copy[i].vertexName);
	
		// 	int k=getAdadjacencySizeFunction(copy[i].vertexName);
		// 	copy[i].setEdgeSize(k);
		// 	copy[i].edgeArrayForVertex=getAdjacentEdges(copy[i].vertexName);
		// 	sortEdge(copy[i].edgeArrayForVertex);

		// }

		// int counter=0;
		// while( copy[counter].removed == false && counter < copy.length ) 
		// {
		// 	copy[counter].removed =true;
		// 	copy[counter].visited =true;

		// 	int x=copy[counter].edgeArrayForVertex.length;

		// 	for(int s=0; s< x; s++)
		// 	{
		// 		int distance=copy[counter].getDistance()+ copy[counter].edgeArrayForVertex[s].getWeight();

		// 		if( distance < copy[counter].edgeArrayForVertex[s].endVertex.getDistance() )
		// 		{
		// 			copy[counter].edgeArrayForVertex[s].endVertex.setDistance(distance);;

		// 			copy[counter].edgeArrayForVertex[s].endVertex.setPredecessor(copy[counter]);

		// 			if( copy[counter].edgeArrayForVertex[s].endVertex.visited==true )
		// 			{
		// 				copy[counter].edgeArrayForVertex[s].endVertex.setRemoved(true);
		// 			}

		// 			copy[counter].edgeArrayForVertex[s].endVertex.setVisited(false);
		// 		}
		// 	}
		// 	counter++;
		// }

		// String [] Kieran=new String[10];

		// Vertex end=new Vertex(v);

		// Vertex m=end;

		// while(true)
		// {
		// 	for(int w=0; w<Kieran.length; w++)
		// 	{
		// 		if(Kieran[w] == null)
		// 		{
		// 			Kieran[w]=m.vertexName;
		// 		}
		// 	}
			
		// 	if( m.vertexName == u )
		// 	{
		// 		break;
		// 	}

		// 	m=m.getPredecessor();
		// }

		// reset();
		
		// String pathNames="";

		// for(int jkl=0; jkl<Kieran.length; jkl++)
		// {
		// 	if( Kieran[jkl] != null )
		// 	{
		// 		pathNames=pathNames+Kieran[jkl];
		// 	}
		// }


		return "";


	}



	
	public int getChinesePostmanCost()
	{
		/*
		This method should return the cost of the optimal Chinese Postman
		route determined by your algorithm.
		*/
		
		return 0;
	}
		
	public Graph getChinesePostmanGraph()
	{
		/*
		This method should return your graph with the extra edges as constructed
		during the optimal Chinese postman route calculation.
		*/
		
		return null;
	}
		
		
	public String getChinesePostmanRoute(String v)
	{
		/*
		This method should return the circular optimal Chinese postman path from v 
		back to v. If there are vertices with odd degrees, return "not available".
		Otherwise, return a list of vertices starting and ending in v.
		When there are alternative paths, choose the next vertex in alphabetical order.

		The list must be separated by commas containing no additional 
		white space.
		*/
		
		return "not available";
	}

						//HELPER FUNCTIONS BELOW FOR TASK 1
		// ------------------------------------------------------------------------------------
	public void addVertexFunction(Vertex newVertex, Vertex [] vertexArray)
	{
		for(int i = 0; i < vertexArray.length; i++)
		{
			if( vertexArray[i] != null && vertexArray[i].vertexName.equals( newVertex.vertexName ) )
			{
				break;
			}
		
			if( vertexArray[i] == null ) 
			{
				vertexArray[i] = newVertex;
				break;
			}
		}			
	}

	public void addEdgeFunction(Vertex start, Vertex end, int weight, Edge [] edgeArray)
	{
		Edge newEdge=new Edge(start, end, weight);

			for(int i = 0; i < edgeArray.length; i++)
			{
				if( edgeArray[i] == null ) 
				{
					edgeArray[i] = newEdge;
					edgeArraySize++;
					break;
				}					
			}
	}

	public Vertex findVertexFunction(Vertex A, Vertex [] vertexArray)
	{
		for(int i = 0; i < vertexArray.length; i++)
		{	
			if( vertexArray[i] != null )
			{
				if( vertexArray[i].vertexName.equals( A.vertexName ) )
				{
					return vertexArray[i];	
				}
			}
		}

		return null;
	}


	public int findVertexFunctionIndex(Vertex A, Vertex [] vertexArray)
	{
		for(int i = 0; i < vertexArray.length; i++)
		{
			if( vertexArray[i] != null )
			{
				if( vertexArray[i].vertexName.equals( A.vertexName ) )
				{
					return i;	
				}
			}
			
		}

		return -1;
	}

	public void sortVertexArray(Vertex [] array)
	{
		Vertex temp;

		for (int a = 0; a < array.length; a++) 
        {
			if( (a != array.length-1) && ( array[a+1].vertexName.compareTo( array[a].vertexName ) < 0 ) && array[a] != null )
			{
				temp=array[a+1];
				array[a+1]=array[a];
				array[a]=temp;
				sortVertexArray(array);//use recursion to keep sorting until done
			} 
		}
	}

	public Vertex[] /*void*/ getAdjacentVertex(String vertex)
    {

		Vertex[] adjacencyList;
		int adjacentcyListSize=getAdadjacencySizeFunction(vertex);
		
		adjacencyList=new Vertex[adjacentcyListSize];

		int counterSize=0;
		
			for (int k = 0; k < edgeArraySize; k++)
			{
				if( edgeArray[k] != null )
				{
					if ( edgeArray[k].startVertex.vertexName.equals( vertex ) )
					{
						if ( edgeArray[k].endVertex.visited.equals( false ) )
						{
							adjacencyList[counterSize]=edgeArray[k].endVertex;
							counterSize++;
						}
					}
	
					if ( edgeArray[k].endVertex.vertexName.equals( vertex ) )
					{
						if (edgeArray[k].startVertex.visited.equals( false ) )
						{
							adjacencyList[counterSize]=edgeArray[k].startVertex;
							counterSize++;
						}
					}
				}
				
			}
		
		sortVertexArray(adjacencyList);

		return adjacencyList;
		// for(int k=0; k< adjacencyList.length; k++)
		// {
		// 	System.out.println(adjacencyList[k].vertexName);
		// }
		
    }


	public int getAdadjacencySizeFunction(String vertex)
    {
		//  Vertex[] adjacencyList;

		//  adjacencyList=new Vertex[vertexArraySize];

		int counterSize = 0;
		
			for (int k = 0 ; k < edgeArraySize; k++)
			{
				if( edgeArray[k] != null )
				{
					if ( edgeArray[k].startVertex.vertexName.equals( vertex ) )
					{
						if ( edgeArray[k].endVertex.visited.equals( false ) )
						{
							counterSize++;
						}	
					}
	
					if ( edgeArray[k].endVertex.vertexName.equals( vertex ) )
					{
						if ( edgeArray[k].startVertex.visited.equals( false ) )
						{
							counterSize++;
						}
					}
				}
				
			}

        return counterSize;
	}
	
	public void depthfirstRecursiveHelperFunction(Vertex vertex)
	{
		vertex.visited=true;
	
		Vertex [] arrayAdjacent=getAdjacentVertex(vertex.vertexName);

			for( int k = 0; k < arrayAdjacent.length; k++ )
			{
				if( arrayAdjacent[k].visited==false && arrayAdjacent[k] != null )
				{
						edges=edges+arrayAdjacent[k].vertexName+",";
						depthfirstRecursiveHelperFunction(arrayAdjacent[k]);
					
				}
			}
	}

					//HELPER FUNCTIONS BELOW FOR TASK 1 END
		// ------------------------------------------------------------------------------------

					//HELPER FUNCTIONS FOR TASK 2
		// ------------------------------------------------------------------------------------
		public Vertex findVertexFunctionWithCounter(int A, Vertex [] vertexArray)
	{
		
		for(int i = 0; i < vertexArray.length; i++)
		{	
			if( vertexArray[i] != null )
			{
					return vertexArray[i];	
			}
		}

		return null;
	}

	



	public Vertex [] alwaysAtFront(Vertex V, Vertex [] Array)
	{
		if( V != null)
		{
			if(Array[0].vertexName != V.vertexName )
			{
				Vertex temp= null;
				for( int i = 1; i < Array.length; i++ )
				{
					
					if( Array[i].vertexName.equals(V.vertexName) )
					{
						temp=Array[i];
						Array[i]=Array[0];
						Array[0]=temp;
					}
				}
				return Array;
			}
			
		}
		return null;
	}

	public int getMin( Vertex [] Array)
	{ 
		// if(Array)
		// int minValue = Array[0].distance; 
		

		int trueVar = 0;
		int falseVar = 0;

			for(int i = 0; i < Array.length; i ++)
			{
				if(Array[i].visited == true && Array[i] != null)
				{
					trueVar++;
				}
				else
					falseVar++;
			}

			Vertex [] temp1=new Vertex[trueVar];
			Vertex [] temp2=new Vertex[falseVar];
			Vertex [] temp3=new Vertex[Array.length];

			int count1=0;
			int count2=0;

			for(int p=0; p < Array.length; p++)
			{
				if(Array[p] != null)
				{
					if(Array[p].visited == true )
					{
						temp1[count1]=Array[p];
						count1++;
					}

					else
					{
						temp2[count2]=Array[p];
						count2++;
					}
				}
			}

				int count4=0;
				int count5=0;
				

				for(int r=0; r< temp2.length; r++)
				{
					if(temp2[r] != null)
					{
						temp3[r]=temp2[count5];
						count5++;
					}
				}
		
				for(int r=count5; r< temp3.length; r++)
				{
					if(temp1[count4] != null)
					{
						temp3[r]=temp1[count4];
						count4++;
					}
				}

				for(int l=0; l<temp3.length; l++)
				{
					Array[l]=temp3[l];
				}
				

			int zz=0;
			int minValue = Array[0].distance;
			for(int i=0; i < Array.length; i++)
			{ 

					if( Array[i].visited != true )
					{
						if( Array[i].distance < minValue )
						{ 
							minValue=Array[i].distance;
							zz=0+i;
						}
					}		
			}	
		
		return zz; 
		
	}

	Vertex tempB;
	String [] B=new String[10];
	int again=0;

	String [] pathArray=new String[10];
	int pie=0;

	String [] s=new String[10];

	

	public void recursiveDjiska(String u, String v, Vertex [] unvisitedVertices)
	{
		// Vertex current=new Vertex(u);
		// Vertex End=new Vertex(v);
		// //String path="";
	
	
		// //Vertex Current=Begin;
		// unvisitedVertices=alwaysAtFront(current, unvisitedVertices);

		// //unvisitedVertices[0].setDistance(0);

		// while( unvisitedVertices[0].visited == false )
		// {
		// 		Vertex [] temp=getAdjacentVertex(current.vertexName);
		// 		Edge [] tempEdge=getAdjacentEdges(current.vertexName);

		// 		for(int p=0; p<temp.length; p++)
		// 		{
		// 			if( temp[p] != null )
		// 			{
		// 				for(int r=0; r<tempEdge.length; r++)
		// 				{
		// 					if( tempEdge!=null )
		// 					{
		// 						if( tempEdge[r].startVertex.vertexName.equals(temp[p].vertexName) || tempEdge[r].endVertex.vertexName.equals(temp[p].vertexName)  )
		// 						{
		// 							int size=findVertexFunctionIndex(temp[p], unvisitedVertices);
		// 							int weight=unvisitedVertices[0].distance+tempEdge[r].weight;

		// 							if( weight < unvisitedVertices[size].distance )
		// 							{
		// 								unvisitedVertices[size].distance=unvisitedVertices[0].distance+tempEdge[r].weight;
		// 								int sizeCurr=findVertexFunctionIndex(current, unvisitedVertices);
		// 								unvisitedVertices[sizeCurr].visited =true;
										
		// 								tempB=unvisitedVertices[sizeCurr];
		// 								unvisitedVertices[size].predecessor=tempB;

		// 							}

		// 						}

		// 					}
		// 				}

		// 			}
		// 		}
				
	
		// 		int Min=getMin(unvisitedVertices);


		// 		Vertex newCurrent=unvisitedVertices[Min];
		// 		//newCurrent.predecessor=tempB;

		// 		if(newCurrent.vertexName.equals(End.vertexName))
		// 		{

		// 			Vertex tempzz;
		// 			int sizeCurr2=findVertexFunctionIndex(newCurrent, unvisitedVertices);
		// 			tempzz=unvisitedVertices[sizeCurr2];
		// 			unvisitedVertices[sizeCurr2].visited=true;
		// 			unvisitedVertices=alwaysAtFront(unvisitedVertices[sizeCurr2], unvisitedVertices);

		// 			for(int b=0; b<pathArray.length; b++)
		// 			{
		// 				pathArray[b]="";
		// 			}

		// 			if(pathArray[pie]=="")
		// 			{
		// 				pathArray[pie]=tempzz.vertexName;
		// 				pie++;
		// 			}
					

		// 			while(true)
		// 			{	
		// 				if(pathArray[pie]=="")
		// 				{
		// 					pathArray[pie]=tempzz.predecessor.vertexName;
		// 					pie++;
		// 				}
			
		// 				if( tempzz.vertexName == current.vertexName )
		// 				{
		// 					break;
		// 				}
			
		// 				tempzz=tempzz.getPredecessor();
		// 			}
					
		// 		}

		// 		else
		// 		{	// again++;
		// 			 recursiveDjiska(newCurrent.vertexName, End.vertexName, unvisitedVertices);

		// 		}

		// }


		// //String [] x=secureTheBagArray(pathArray);
		// s=secureTheBagArray(pathArray);
		// //return x;
		





	}

	public String [] secureTheBagArray(String [] A)
	{
		
		for(int k=0; k < vertexArraySize; k++)
		{
			if(A[k] != null)
			{
				B[k] = A[k];
			}
			
		}

		return B;

	}

	public Vertex [] populateArray(Vertex [] A, Vertex [] B)
	{
		for(int k=0; k < vertexArraySize; k++)
		{
			A[k] = B[k];
		}

		return A;
	}	

	public int /*void*/ getAdjacentEdgesSize(String A)
		{
			//Vertex B=new Vertex(A);
			if( A != null)
			{
				int tally=0;
				for(int k = 0; k < edgeArraySize; k++)
				{
					if( edgeArray[k] != null)
					{
						if( edgeArray[k].startVertex.vertexName.equals( A ) || edgeArray[k].endVertex.vertexName.equals( A ) )
						{
							tally++;
						}
					}
				}
		
				return tally;
			}
		
			// for(int i=0; i<B.edgeArrayForVertex.length; i++)
			// {
			// 	if(B.edgeArrayForVertex[i] != null)
			// 		System.out.print(B.edgeArrayForVertex[i].startVertex.vertexName +" "+B.edgeArrayForVertex[i].endVertex.vertexName +" "+B.edgeArrayForVertex[i].weight+" "  );
			// }
			return -1;
		}

		public Edge[] /*void*/ getAdjacentEdges(String A)
		{
			if( A != null )
			{
				Vertex B=new Vertex(A);
	
				int apple=getAdjacentEdgesSize(B.vertexName);
				int banana=0;
				edgeArrayForVertex=new Edge[apple];
		
				for(int k = 0; k < edgeArraySize; k++)
				{
					if( edgeArray[k] != null)
					{
						if( edgeArray[k].startVertex.vertexName.equals( B.vertexName ) || edgeArray[k].endVertex.vertexName.equals( B.vertexName ) )
						{
							if( banana < apple )
							{
								edgeArrayForVertex[banana]=edgeArray[k];
								banana++;
							}
								
						}
					}
				}
		
				return edgeArrayForVertex;
			}
	
			return null;
	
			// for(int i=0; i<edgeArrayForVertex.length; i++)
			// {
			// 	if(edgeArrayForVertex[i] != null)
			// 		System.out.print(edgeArrayForVertex[i].startVertex.vertexName +" "+edgeArrayForVertex[i].endVertex.vertexName +" "+edgeArrayForVertex[i].weight+" "  );
			// }
			//return null;
		}

		public void sortEdge(Edge [] e)
		{
			for(int i = 0; i < e.length; i++)
			{
				if(e[i] != null)
				{
					if(e[i].startVertex.vertexName.compareTo(e[i].endVertex.vertexName) > 0 )
					{
						Vertex temp=e[i].endVertex;
						e[i].endVertex=e[i].startVertex;
						e[i].startVertex=temp;
					}
				}
			}

		}

		public void reset()
		{
			for(int j=0; j<vertexArraySize; j++)
			{
				vertexArray[j].distance=2147483647;
				vertexArray[j].setVisited(false);
				vertexArray[j].setPredecessor(null);
				vertexArray[j].setRemoved(false);
			}
		}


	public Graph()
	{

	}


	class Vertex
	{
		String vertexName;
		Boolean visited;
		Vertex predecessor;
		int distance=0;
		Edge edgeArrayForVertex [];
		int edgeSize=0;
		Boolean removed;

		Vertex(String label)
		{
			
			this.vertexName = label;
			this.visited = false;
			this.distance = 2147483647;
			this.removed=false;	//max value for int
			// edgeSize=getAdjacentEdgesSize(label);
			// edgeArrayForVertex=new Edge[edgeSize];
			// edgeArrayForVertex=getAdjacentEdges(label);
			// sortEdge(edgeArrayForVertex);

		}

		public Vertex getPredecessor() 
		{
			return predecessor;
		}
	 
		public void setPredecessor(Vertex predecessor) 
		{
			this.predecessor = predecessor;
		}

		public void setDistance(int distance) 
		{
			this.distance = distance;
		}

		public int getDistance() 
		{
			return distance;
		}

		public void setEdgeSize(int size) 
		{
			this.edgeSize = size;
		}

		public Boolean getRemoved() 
		{
			return removed;
		}
	 
		public void setRemoved(Boolean r) 
		{
			this.removed = r;
		}

		public Boolean getVisited() 
		{
			return removed;
		}
	 
		public void setVisited(Boolean v) 
		{
			this.visited = v;
		}


    }

	class Edge 
	{
        Vertex startVertex;
        Vertex endVertex;
        int weight;

		public Edge(Vertex startVertex, Vertex endVertex, int weight) 
		{
            this.startVertex = startVertex;
            this.endVertex = endVertex;
            this.weight = weight;
		}

		
	public int getWeight() 
	{
		return weight;
	}
 
	public void setWeight(int weight) 
	{
		this.weight = weight;
	}
		
		
    }
	
}
