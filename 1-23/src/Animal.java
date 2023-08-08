public class Animal implements Comparable<Animal>{
    private String name;
    private int age;
    public Animal(String name, int age){
        this.name = name;
        this.age = age;
    }
    
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }


    public int compareTo(Animal animal){
        if(animal.getName().compareTo(this.name) > 0){
            return -1;
        }
        if(animal.getName().compareTo(this.name) < 0){
            return 1;
        }
        if(animal.getName().compareTo(this.name) == 0){
            if(animal.getAge() > this.age){
                return -1;
            }
            if(animal.getAge() < this.age){
                return 1;
            }
            if(animal.getAge() == this.age){
                return 0;
            }
        }
        return 0;
    }
    public String toString(){
        return name + " - " + age;
    }


}