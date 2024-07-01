public class Room extends Patient {
   String typeRoom;
   int noDay;

   public Room(String name, int number, String address, String typeRoom, int noDay) {
      super(name, number, address);
      this.typeRoom = typeRoom;
      this.noDay = noDay;
   }

   // Mutators
   public void setTypeRoom(String typeRoom) {
      this.typeRoom = typeRoom;
   }
   public void setNoDay(int noDay) {
      this.noDay = noDay;
   }

   // Retrievers
   public String getTypeRoom() {
      return typeRoom;
   }
   public int getNoDay() {
      return noDay;
   }

   // Printer
   public void printRoomDetails() {
      super.printPatientDetails();
      System.out.println("Type of Room: " + typeRoom);
      System.out.println("Number of Days: " + noDay);
      System.out.println("Payment: " + calcPayment());
   }
}