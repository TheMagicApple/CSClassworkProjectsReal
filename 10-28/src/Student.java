public class Student {
    private int id;
    private String name;

    public Student(String name, int id){
        this.name = name;
        this.id = id;
    }

    public int getID(){
        return id;
    }

    public String getName(){
        return name;
    }

    public boolean equals(Object obj){
        Student stuff = (Student)(obj);

        if(stuff.getID() == id){
            return true;
        }
        return false;
    }

    public int hashCode(){
        return 29 * id;
    }
}
