import java.io.FileNotFoundException;

/*
Complete your details...
Name and Surname: 
Student/staff Number: 
*/


/*
MAKE SURE YOU HAVE 2 GRAPH FILES...

1) graph.txt... containing the following:
    7
    E,A,3
    E,I,2
    E,F,5
    A,I,8
    A,F,4
    A,G,6
    I,F,7
    G,B,4
    C,A,2


 2) graph2.txt... containing the following
    5
    A,D,6
    A,B,1
    C,E,5
    B,C,2
    B,D,4
    C,D,5
 */


public class Main
{
        public static void main(String[] args) throws FileNotFoundException
        {
            Graph hello = new Graph("graph.txt");

            // System.out.println();
            // System.out.println("TESTING NUM EDGES FUNCTION");

                            //FOR TASK 1
            //----------------------------------------------------------
            // System.out.println(hello.numEdges("E","A"));
            // System.out.println(hello.numEdges("A","E"));
            // System.out.println(hello.numEdges("E","I"));
            // System.out.println(hello.numEdges("I","E"));
            // System.out.println(hello.numEdges("E","F"));
            // System.out.println(hello.numEdges("A","I"));
            // System.out.println(hello.numEdges("I","A"));
            // System.out.println(hello.numEdges("A","F"));
            // System.out.println(hello.numEdges("A","G"));
            // System.out.println(hello.numEdges("G","A"));
            // System.out.println(hello.numEdges("A","F"));
            // System.out.println(hello.numEdges("A","G"));
            // System.out.println(hello.numEdges("G","A"));
            // System.out.println(hello.numEdges("I","F"));
            // System.out.println(hello.numEdges("F","I"));
            // System.out.println(hello.numEdges("G","B"));
            // System.out.println(hello.numEdges("B","G"));
            // System.out.println(hello.numEdges("C","H"));
            // System.out.println(hello.numEdges("H","C"));
            // System.out.println(hello.numEdges("H","D"));
            // System.out.println(hello.numEdges("D","H"));

            //----------------------------------------------------------


                            //FOR TASK 2
            //----------------------------------------------------------
            // System.out.println(hello.numEdges("A","B"));
            // System.out.println(hello.numEdges("A","C"));
            // System.out.println(hello.numEdges("A","D"));
            // System.out.println(hello.numEdges("B","C"));
            // System.out.println(hello.numEdges("B","D"));
            // System.out.println(hello.numEdges("C","D"));
            // System.out.println(hello.numEdges("D","C"));
            // System.out.println(hello.numEdges("R","A"));
             //----------------------------------------------------------

            // System.out.println();
            // System.out.println("TESTING GET DEGREE FUNCTIONS");


                            //FOR TASK 1
            //----------------------------------------------------------
            // System.out.println(hello.getDegree("A"));
            // System.out.println(hello.getDegree("B"));
            // System.out.println(hello.getDegree("C"));
            // System.out.println(hello.getDegree("D"));
            // System.out.println(hello.getDegree("E"));
            // System.out.println(hello.getDegree("F"));
            // System.out.println(hello.getDegree("G"));
            // System.out.println(hello.getDegree("H"));
            // System.out.println(hello.getDegree("I"));
            // System.out.println(hello.getDegree("J"));
            // System.out.println(hello.getDegree("K"));
            // System.out.println(hello.getDegree("L"));

            //-------------------------------------------------------------


                            //FOR TASK 2
            //-------------------------------------------------------------
            // System.out.println(hello.getDegree("A"));
            // System.out.println(hello.getDegree("B"));
            // System.out.println(hello.getDegree("C"));
            // System.out.println(hello.getDegree("D"));
            // System.out.println(hello.getDegree("E"));
            // System.out.println(hello.getDegree("F"));
            // System.out.println(hello.getDegree("G"));
            // System.out.println(hello.getDegree("R"));
            // System.out.println(hello.getDegree("L"));

            // System.out.println();
            // System.out.println("TESTING GET ODD FUNCTIONS");
            // System.out.println(hello.getOdd());


            // System.out.println("TESTING GET ADJACENT EDGE SIZE FUNCTIONS");
            // System.out.println();
            // System.out.print(hello.getAdjacentEdgesSize("A"));
            // System.out.println();
            // // System.out.print(hello.getAdjacentEdgesSize("R"));

            // System.out.println();
            // System.out.println("TESTING GET ADJACENT EDGE ARRAY FUNCTIONS");
            // System.out.println();
            // hello.getAdjacentEdges("A");

            System.out.println();
            System.out.println("TESTING GET PATH FUNCTIONS");
            System.out.println();
            hello.getPath("F", "A");
    //----------------------------------------------------------------------
     
            // System.out.println();
            // System.out.println("TESTING DEPTH FIRST TRAVERSAL");
			// System.out.println();

			// //hello.getAdjacentVertex("G");
		
			// System.out.println(hello.depthFirstTraversal("A"));
			// System.out.println(hello.depthFirstTraversal("B"));
			// System.out.println(hello.depthFirstTraversal("C"));
			// System.out.println(hello.depthFirstTraversal("D"));
			// System.out.println(hello.depthFirstTraversal("E"));
			// System.out.println(hello.depthFirstTraversal("F"));
			// System.out.println(hello.depthFirstTraversal("G"));
			// System.out.println(hello.depthFirstTraversal("H"));
			// System.out.println(hello.depthFirstTraversal("I"));

            // System.out.println();
            // System.out.println("TESTING DFS USING EMPTY VALUES");
            // System.out.println(hello.depthFirstTraversal("J"));
            // System.out.println(hello.depthFirstTraversal("K"));

            // Graph clone=hello.clone();

            // System.out.println("NOW USING A CLONE OF THE GRAPH");

            // System.out.println();
            // System.out.println("TESTING NUM EDGES FUNCTION");
            // System.out.println(clone.numEdges("E","A"));
            // System.out.println(clone.numEdges("A","E"));
            // System.out.println(clone.numEdges("E","I"));
            // System.out.println(clone.numEdges("I","E"));
            // System.out.println(clone.numEdges("E","F"));
            // System.out.println(clone.numEdges("A","I"));
            // System.out.println(clone.numEdges("I","A"));
            // System.out.println(clone.numEdges("A","F"));
            // System.out.println(clone.numEdges("A","G"));
            // System.out.println(clone.numEdges("G","A"));
            // System.out.println(clone.numEdges("A","F"));
            // System.out.println(clone.numEdges("A","G"));
            // System.out.println(clone.numEdges("G","A"));
            // System.out.println(clone.numEdges("I","F"));
            // System.out.println(clone.numEdges("F","I"));
            // System.out.println(clone.numEdges("G","B"));
            // System.out.println(clone.numEdges("B","G"));
            // System.out.println(clone.numEdges("C","H"));
            // System.out.println(clone.numEdges("H","C"));
            // System.out.println(clone.numEdges("H","D"));
            // System.out.println(clone.numEdges("D","H"));


            // System.out.println();
            // System.out.println("TESTING GET DEGREE FUNCTIONS");
            // System.out.println(clone.getDegree("A"));
            // System.out.println(clone.getDegree("B"));
            // System.out.println(clone.getDegree("C"));
            // System.out.println(clone.getDegree("D"));
            // System.out.println(clone.getDegree("E"));
            // System.out.println(clone.getDegree("F"));
            // System.out.println(clone.getDegree("G"));
            // System.out.println(clone.getDegree("H"));
            // System.out.println(clone.getDegree("I"));
            // System.out.println(clone.getDegree("J"));
            // System.out.println(clone.getDegree("K"));
            // System.out.println(clone.getDegree("L"));


            // System.out.println();
            // System.out.println("TESTING DEPTH FIRST TRAVERSAL");
            // System.out.println();
            // System.out.println(clone.depthFirstTraversal("A"));
            // System.out.println(clone.depthFirstTraversal("B"));
            // System.out.println(clone.depthFirstTraversal("C"));
            // System.out.println(clone.depthFirstTraversal("D"));
            // System.out.println(clone.depthFirstTraversal("E"));
            // System.out.println(clone.depthFirstTraversal("F"));
            // System.out.println(clone.depthFirstTraversal("G"));
            // System.out.println(clone.depthFirstTraversal("H"));
            // System.out.println(clone.depthFirstTraversal("I"));

            // System.out.println();
            // System.out.println("TESTING DFS USING EMPTY VALUES... (should be empty)");
            // System.out.println(clone.depthFirstTraversal("J"));
            // System.out.println(clone.depthFirstTraversal("K"));


            // System.out.println("NOW TESTING WITH A RECONSTRUCTED GRAPH");
            // hello.reconstructGraph("graph2.txt");

            // System.out.println();

            // System.out.println(hello.numEdges("A","D"));
            // System.out.println(hello.numEdges("D","A"));
            // System.out.println(hello.numEdges("A","B"));
            // System.out.println(hello.numEdges("B","A"));
            // System.out.println(hello.numEdges("C","E"));
            // System.out.println(hello.numEdges("E","C"));
            // System.out.println(hello.numEdges("B","C"));
            // System.out.println(hello.numEdges("C","B"));
            // System.out.println(hello.numEdges("B","D"));
            // System.out.println(hello.numEdges("D","B"));
            // System.out.println(hello.numEdges("C","D"));
            // System.out.println(hello.numEdges("D","C"));


            // System.out.println();
            // System.out.println("TESTING GET DEGREE FUNCTIONS");
            // System.out.println(hello.getDegree("A"));
            // System.out.println(hello.getDegree("B"));
            // System.out.println(hello.getDegree("C"));
            // System.out.println(hello.getDegree("D"));
            // System.out.println(hello.getDegree("E"));
            // System.out.println(hello.getDegree("F"));
            // System.out.println(hello.getDegree("G"));
            // System.out.println(hello.getDegree("H"));

            // System.out.println("TESTING DEPTH FIRST TRAVERSAL");
            // System.out.println();
            // System.out.println(hello.depthFirstTraversal("A"));
            // System.out.println(hello.depthFirstTraversal("B"));
            // System.out.println(hello.depthFirstTraversal("C"));
            // System.out.println(hello.depthFirstTraversal("D"));
            // System.out.println(hello.depthFirstTraversal("E"));
            // System.out.println(hello.depthFirstTraversal("F"));
            // System.out.println(hello.depthFirstTraversal("G"));
            // System.out.println(hello.depthFirstTraversal("H"));
            // System.out.println(hello.depthFirstTraversal("I"));

            // System.out.println();
            // System.out.println("TESTING DFS USING EMPTY VALUES");
            // System.out.println(hello.depthFirstTraversal("J"));
            // System.out.println(hello.depthFirstTraversal("K"));

            // System.out.println();
            // hello.changeLabel("A", "Banana");

            // System.out.println("TESTING DEPTH FIRST TRAVERSAL");
            // System.out.println();
            // System.out.println(hello.depthFirstTraversal("A"));
            // System.out.println(hello.depthFirstTraversal("Apple"));
            // System.out.println(hello.depthFirstTraversal("B"));
            // System.out.println(hello.depthFirstTraversal("C"));
            // System.out.println(hello.depthFirstTraversal("D"));
            // System.out.println(hello.depthFirstTraversal("E"));
            // System.out.println(hello.depthFirstTraversal("F"));
            // System.out.println(hello.depthFirstTraversal("G"));
            // System.out.println(hello.depthFirstTraversal("H"));
            // System.out.println(hello.depthFirstTraversal("I"));


            // System.out.println("TESTING CHANGE LABEL FUNCTION");
            // System.out.println();
            // hello.changeLabel("Banana", "Apple");

            // System.out.println("TESTING DEPTH FIRST TRAVERSAL");
            // System.out.println();
            // System.out.println(hello.depthFirstTraversal("A"));
            // System.out.println(hello.depthFirstTraversal("Apple"));
            // System.out.println(hello.depthFirstTraversal("B"));
            // System.out.println(hello.depthFirstTraversal("C"));
            // System.out.println(hello.depthFirstTraversal("D"));
            // System.out.println(hello.depthFirstTraversal("E"));
            // System.out.println(hello.depthFirstTraversal("F"));
            // System.out.println(hello.depthFirstTraversal("G"));
            // System.out.println(hello.depthFirstTraversal("H"));
            // System.out.println(hello.depthFirstTraversal("I"));

         }
}

/*

MY OUTPUT IS SHOWN FROM HERE...

TESTING NUM EDGES FUNCTION
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
0
0
0
0

TESTING GET DEGREE FUNCTIONS
5
1
1
0
3
3
2
0
3
0
0
0

TESTING DEPTH FIRST TRAVERSAL

A,C,E,F,I,G,B
B,G,A,C,E,F,I
C,A,E,F,I,G,B

E,A,C,F,I,G,B
F,A,C,E,I,G,B
G,A,C,E,F,I,B

I,A,C,E,F,G,B

TESTING DFS USING EMPTY VALUES


NOW USING A CLONE OF THE GRAPH

TESTING NUM EDGES FUNCTION
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
1
0
0
0
0

TESTING GET DEGREE FUNCTIONS
5
1
1
0
3
3
2
0
3
0
0
0

TESTING DEPTH FIRST TRAVERSAL

A,C,E,F,I,G,B
B,G,A,C,E,F,I
C,A,E,F,I,G,B

E,A,C,F,I,G,B
F,A,C,E,I,G,B
G,A,C,E,F,I,B

I,A,C,E,F,G,B

TESTING DFS USING EMPTY VALUES... (should be empty)


NOW TESTING WITH A RECONSTRUCTED GRAPH

1
1
1
1
1
1
1
1
1
1
1
1

TESTING GET DEGREE FUNCTIONS
2
3
3
3
1
0
0
0
TESTING DEPTH FIRST TRAVERSAL

A,B,C,D,E
B,A,D,C,E
C,B,A,D,E
D,A,B,C,E
E,C,B,A,D





TESTING DFS USING EMPTY VALUES



TESTING DEPTH FIRST TRAVERSAL



B,Banana,D,C,E
C,B,Banana,D,E
D,B,Banana,C,E
E,C,B,Banana,D




TESTING CHANGE LABEL FUNCTION

TESTING DEPTH FIRST TRAVERSAL


Apple,B,C,D,E
B,Apple,D,C,E
C,B,Apple,D,E
D,Apple,B,C,E
E,C,B,Apple,D





 */