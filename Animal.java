abstract class Animal{
    private String name;
    public Animal(String nm){
        name = nm;
    }
    public String getName(){
        return(name);
    }
    public abstract void speak();
}