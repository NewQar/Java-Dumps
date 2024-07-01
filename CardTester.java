
abstract class Card{
    String recipient;
    public abstract void greeting();
}
class Holiday extends Card{
    public Holiday(String r){
        recipient =r;
    }
    public void greeting(){
        System.out.println("Dear " + recipient + ",\n");
        System.out.println("Season's Greeting!\n\n");
    }
}
class Birthday extends Card{
    int age;
    public Birthday(String r, int years){
        recipient = r;
        age = years;
    }
        public void greeting(){
        System.out.println("Dear " + recipient + ",\n");
        System.out.println("Season's Greeting!\n\n");
    }
}
public class CardTester{
    public static void main(String[] args){
        Holiday hol = new Holiday("Santa");
        hol.greeting();
        Birthday bd = new Birthday("Maria",21);
        bd.greeting();
    }
}