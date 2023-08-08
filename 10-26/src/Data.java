public class Data {
    private String school;
    private DLList<String> classes;
    private int id;
    public Data(String school, DLList<String> classes,int id){
        this.school = school;
        this.classes = classes;
        this.id=id;
    }
    @Override
    public boolean equals(Object other) {
    	Data d=(Data)other;
    	return d.getID()==id;
    }
    public int getID() {
    	return id;
    }
    
    public String getSchool(){
        return school;
    }

    public DLList<String> getClasses(){
        return classes;
    }
}