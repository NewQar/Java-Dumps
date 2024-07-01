abstract class Autoclass {
    private String carMake;
    protected double price;

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public double getPrice() {
        return price;
    }

    public abstract void setPrice();

}
class Perodua extends Autoclass {

    @Override
    public void setPrice() {
        price=5500;

    }
}
class Proton extends Autoclass {

    @Override
    public void setPrice() {
        price=5000;

    }

}
public class Testt {

    public static void main(String[] args) {
         
        Perodua p1=new Perodua();
        p1.setCarMake("bezza");
        p1.setPrice();
        
        Proton p2=new Proton();
        p2.setCarMake("IRIZ");
        p2.setPrice();
        
        System.out.println("Car \""+p1.getCarMake()+"\" which is of Price $"+p1.getPrice());
        System.out.println("Car \""+p2.getCarMake()+"\" which is of Price $"+p2.getPrice());
        

    }

}