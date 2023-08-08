import java.util.Scanner;
public class Runner3{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
    	Graph<String> graph = new Graph<String>();

        graph.add("A");
        graph.add("B");
        graph.add("K");
        graph.add("E");
        graph.add("F");
        graph.add("D");
        graph.add("C");
        graph.add("H");
        graph.add("I");
        graph.add("G");
        

        graph.addEdge("A", "B");
        graph.addEdge("A", "K");
        graph.addEdge("B", "E");
        graph.addEdge("F", "D");
        graph.addEdge("B", "D");
        graph.addEdge("E", "F");
        graph.addEdge("C", "H");
        graph.addEdge("C", "G");
        graph.addEdge("H", "I");
        graph.addEdge("H", "G");






        while(true){
            System.out.println("1. Display All Users");
            System.out.println("2. Select User");
            System.out.println("3. Quit");
            int choice = sc.nextInt();

            if(choice == 1){
                graph.displayAll();
            }
            if(choice == 2){
                System.out.println("Choose User: ");
                String userChoice = sc.next();
                while(true){
                    System.out.println("1. Display Friends");
                    System.out.println("2. Search and Connect a Friend");
                    System.out.println("3. Quit");

                    int choice2 = sc.nextInt();


                    if(choice2 == 1){
                        graph.displayConnections(userChoice);
                    }
                    if(choice2 == 2){
                        System.out.println("Which Friend? ");
                        String friendChoice = sc.next();

                        graph.searchAndConnect(userChoice, friendChoice);
                    }
                    if(choice2 == 3){
                        break;
                    }
                }
            }
            if(choice == 3){
                break;
            }
        }
        
        
       
        
    }
}