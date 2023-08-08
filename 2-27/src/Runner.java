import java.util.Scanner;
public class Runner{
    public static void main(String[] args){
        Graph<String> graph = new Graph<String>();


       


        Scanner sc = new Scanner(System.in);
/*
        graph.add("A");
        graph.add("B");
        graph.add("C");
        graph.add("D");
        graph.add("E");
       
        graph.addEdge("A", "B", 5);
        graph.addEdge("A", "C", 3);
        graph.addEdge("B", "C", 1);
        graph.addEdge("C", "E", 9);
        graph.addEdge("B", "E", 11);
        graph.addEdge("B", "D", 2);
        graph.addEdge("D", "E", 1);
       
*/
       

       

       

       



        while(true){
            System.out.println("1. View Graph");
            System.out.println("2. Add new Node");
            System.out.println("3. Add Edge");
            System.out.println("4. Get Weight");
            System.out.println("5. Find Shortest Path");
            System.out.println("6. Quit");
            int choice = sc.nextInt();

            if(choice == 1){

                System.out.println(graph);


            }
            if(choice == 2){
                System.out.println("Node to add: ");
                String s = sc.next();

                graph.add(s);
            }
            if(choice == 3){
                System.out.println("Node 1: ");
                String s1 = sc.next();
                System.out.println("Node 2: ");
                String s2 = sc.next();
                System.out.println("Weight: ");
                int i = sc.nextInt();

                graph.addEdge(s1, s2, i);

            }
            if(choice == 4){
                System.out.println("Node 1: ");
                String s1 = sc.next();
                System.out.println("Node 2: ");
                String s2 = sc.next();
               

                System.out.println(graph.getWeight(s1, s2));
               
            }
            if(choice == 5){
                System.out.println("Node 1: ");
                String s1 = sc.next();
                System.out.println("Node 2: ");
                String s2 = sc.next();
               
                graph.shortestPath(s1, s2);
         
            }
           
            if(choice == 6){
                break;
            }
        }
       
       
       
       
    }
}
