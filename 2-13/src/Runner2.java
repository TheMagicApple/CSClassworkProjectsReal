import java.util.Scanner;
public class Runner2{
    public static void main(String[] args){
        Graph<String> graph = new Graph<String>();


        Graph<String> graph2 = new Graph<String>();


        Scanner sc = new Scanner(System.in);

        graph.add("A");
        graph.add("B");
        graph.add("C");
        graph.add("D");
        graph.add("E");
        graph.add("F");
        graph.add("G");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
        graph.addEdge("B", "D");
        graph.addEdge("B", "E");
        graph.addEdge("C", "F");
        graph.addEdge("C", "G");

        graph2.add("A");
        graph2.add("B");
        graph2.add("C");
        graph2.add("K");
        graph2.add("D");
        graph2.add("E");
        graph2.add("H");
        graph2.add("F");
        graph2.add("G");
        graph2.add("I");

        

        graph2.addEdge("A", "K");
        graph2.addEdge("A", "B");
        graph2.addEdge("B", "D");
        graph2.addEdge("B", "E");
        graph2.addEdge("E", "F");
        graph2.addEdge("D", "F");
        graph2.addEdge("F", "G");
        graph2.addEdge("A", "C");
        graph2.addEdge("C", "H");
        graph2.addEdge("C", "I");
        graph2.addEdge("H", "I");



        while(true){
            System.out.println("1. Breadth First Search");
            System.out.println("2. Depth First Search");
            System.out.println("3. Quit");
            int choice = sc.nextInt();

            if(choice == 1){

                System.out.println("Node to search: ");
                String c = sc.next();

                graph.bfs(c, "A");


            }
            if(choice == 2){
                System.out.println("Node to search: ");
                String c = sc.next();
                

                graph2.dfs(c, "A");
            }
            if(choice == 3){
                break;
            }
        }
        
        
       
        
    }
}