abstract class TailorHouse {
    String custNo; // customer I/C number
    String custName; // customer Name
    String date; // date of order
    char Cust_type; // regular customer or new customer
    public TailorHouse(String custNo, String custName, String date, char cust_type) {
        this.custNo = custNo;
        this.custName = custName;
        this.date = date;
        this.Cust_type = cust_type;
    }
    public abstract double calCharges();
    public abstract String toString();
}
class Dress extends TailorHouse {
    String dressType; // Type of dress, Kebaya or Kurung or Jubah
    boolean silk; // either Yes or No to silk
    public Dress(String custNo, String custName, String date, char cust_type, String dressType, boolean silk) {
        super(custNo, custName, date, cust_type);
        this.dressType = dressType;
        this.silk = silk;
    }
    public double calCharges() {
        double charges = 0.0;
        if(dressType.equalsIgnoreCase("Kebaya")) {
            charges = silk ? 80 : 40;
        } else if(dressType.equalsIgnoreCase("Kurung")) {
            charges = silk ? 50 : 25;
        } else if(dressType.equalsIgnoreCase("Jubah")) {
            charges = silk ? 100 : 50;
        }
        return charges;
    }
    public String toString() {
        return "\nId: " + custNo + " Name: " + custName + ", " + date + " Regular(R) or No(N): " + Cust_type + "\nDress Type: " + dressType + " Silk: " + silk;
    }
}
class Curtain extends TailorHouse {
    int windows; // total number of windows
    int doors; // total number of doors
    final double windowPrice = 45.00; //cost per piece
    final double doorPrice = 55.00; //cost per piece
    public Curtain(String custNo, String custName, String date, char cust_type, int windows, int doors) {
        super(custNo, custName, date, cust_type);
        this.windows = windows;
        this.doors = doors;
    }
    public double calCharges() {
        double charges = 0.0;
        charges = (windows * windowPrice) + (doors * doorPrice);
        return charges;
    }
    public String toString() {
        return "\nId:" + custNo + " Name: " + custName + ", " + date + "Regular(R) or No(N): " + Cust_type + "\nQuantity Windows: " + windows + " Quantity Doors: " + doors;
    }
}

class Main {
    public static void main(String[] args) {
        TailorHouse[] T = new TailorHouse[25];
        T[0] = new Dress("123", "John", "2022-01-01", 'R', "Kebaya", true);
        T[1] = new Dress("124", "Jane", "2022-01-02", 'N', "Jubah", false);
        T[2] = new Curtain("125", "Bob", "2022-01-03", 'R', 2, 1);
        T[3] = new Dress("126", "Mary", "2022-01-04", 'N', "Kurung", true);
        T[4] = new Curtain("127", "Mike", "2022-01-05", 'R', 3, 2);
        // add more elements to the array as needed
        int kebayaCount = 0;
        int kurungCount = 0;
        int jubahCount = 0;
        for(TailorHouse t : T) {
            if(t instanceof Dress) {
                Dress d = (Dress) t;
                if(d.dressType.equalsIgnoreCase("Kebaya")) {
                    kebayaCount++;
                } else if(d.dressType.equalsIgnoreCase("Kurung")) {
                    kurungCount++;
                } else if(d.dressType.equalsIgnoreCase("Jubah")) {
                    jubahCount++;
                }
            }
        }
        System.out.println("Kebaya count: " + kebayaCount);
        System.out.println("Kurung count: " + kurungCount);
        System.out.println("Jubah count: " + jubahCount);
            
        double regularCustomerCurtainCharges = 0.0;
        for(TailorHouse t : T) {
            if(t instanceof Curtain && t.Cust_type == 'R') {
                Curtain c = (Curtain) t;
                regularCustomerCurtainCharges += c.calCharges();
            }
        }
        System.out.println("Total charges of regular customer curtains: " + regularCustomerCurtainCharges);
            
        for(TailorHouse t : T) {
            System.out.println(t);
        }
    }
}
