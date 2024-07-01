public class VariousAnimal{
    public static void main(String[] args){
        Animal ref;
        Dog aDog = new Dog("Lassie");
        Cow aCow = new Cow("Mabel");
        Snake aSnake = new Snake("Ikan");
        Cat aCat = new Cat("Fish");
        ref = aSnake;
        ref.speak();
        ref = aCat;
        ref.speak();
        ref = aCow;
        ref.speak();
        ref = aDog;
        ref.speak();
    }
}
