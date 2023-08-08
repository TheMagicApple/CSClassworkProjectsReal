import java.util.Scanner;
public class Runner{
    public static void main(String[] args){
        Graph<String> graph=new Graph<>();

        Scanner sc = new Scanner(System.in);

        graph.add("Jose");
        graph.add("John");
        graph.add("Jane");

        graph.addEdge("Jose", "John");
        graph.addEdge("Jose", "Jane");
        graph.addEdge("John", "Jose");
        graph.addEdge("John", "Jane");
        graph.addEdge("Jane", "Jose");
        graph.addEdge("Jane", "John");


        while(true){
            System.out.println("1. add a new Node (Vertex)");
            System.out.println("2. add a new Edge");
            System.out.println("3. remove a Node (Vertex)");
            System.out.println("4. view graph");
            System.out.println("5. quit");

            int choice = sc.nextInt();

            if(choice == 1){
                System.out.println("Node: ");
                String s = sc.next();
                graph.add(s);
            }
            if(choice == 2){
                System.out.println("Node1: ");
                String s1 = sc.next();
                System.out.println("Node2: ");
                String s2 = sc.next();
                graph.addEdge(s1,s2);
            }
            if(choice == 3){
                System.out.println("Node: ");
                String s = sc.next();
                graph.remove(s);
            }
            if(choice == 4){
                System.out.println(graph.toString());
            }
            if(choice == 5){
                break;
            }
        }

    }
}