public class Patient {
   String patientName;
   int patientNumber;
   String patientAddress;

   public Patient(String name, int number, String address) {
      this.patientName = name;
      this.patientNumber = number;
      this.patientAddress = address;
   }

   // Mutators
   public void setPatientName(String name) {
      this.patientName = name;
   }
   public void setPatientNumber(int number) {
      this.patientNumber = number;
   }
   public void setPatientAddress(String address) {
      this.patientAddress = address;
   }

   // Retrievers
   public String getPatientName() {
      return patientName;
   }
   public int getPatientNumber() {
      return patientNumber;
   }
   public String getPatientAddress() {
      return patientAddress;
   }

   // Printer
   public void printPatientDetails() {
      System.out.println("Patient Name: " + patientName);
      System.out.println("Patient Number: " + patientNumber);
      System.out.println("Patient Address: " + patientAddress);
   }
   
}


