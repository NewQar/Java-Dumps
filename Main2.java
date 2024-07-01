
class Laptop
{
private String brand;
private double price;
private int RAM;
private int USBport;
    public Laptop (String a, double b, int c, int d){
    this.brand = a;
    this.price = b;
    this.RAM = c;
    this.USBport = d;
}
    public String getBrand(){
        return brand;
    }
    public double getPrice(){
        return price;
    }
    public int getRAM(){
        return RAM;
    }
    public int getUSB(){
        return USBport;
    }
    double upgradeRAM (int fin){
        if(fin==8)
            return 98.00;
        else if(fin==16)
            return 299.00;
        else
        return 0;
    }
}
public class Main2 {

    public static void main(String[] args) {
        Laptop Laptops[]= new Laptop[100];
        double fins=0.00,temp=0.00;
        for(int i=0;i<100;i++){
            temp=Laptops[i].getPrice();
            fins=fins+temp;
        }
        System.out.println("Total Price: "+fins);
        int[] nums= new int[100];
        int o=0;
        for(int j=0;j<100;j++){
            if(Laptops[j].getUSB()==4){
                for(int p=0;p<o;p++){
                if(Laptops[j].getBrand().equals(Laptops[nums[p]])){
                break;
                }
                else{
                j = nums[o];
                o++;
                }
            }
        }
        for(int k=0;k<100;k++){
            System.out.println("Brand: "+Laptops[nums[k]].getBrand());
        }
    }
}