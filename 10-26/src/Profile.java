public class Profile {
    private String first,last;
    private int id;

    public Profile(String first, String last, int id){
        this.first = first;
        this.last = last;
        this.id = id;
    }

    public String getFirst(){
        return first;
    }

    public String getLast(){
        return last;
    }

    public int getID(){
        return id;
    }
    public String toString() {
    	return first+" "+last+" "+id;
    }
    @Override
    public int hashCode(){
        int hash = id * 29;
        return hash;
    }

    @Override
    public boolean equals(Object obj){
        Profile stuff = (Profile)(obj);
        if(stuff.getID() == id){
            return true;
        }
        return false;
    }
}