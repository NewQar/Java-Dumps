public class Rotor {
    private String mapping;
    private String reverseMapping;
    private int position;

    // Constructor
    public Rotor(String mapping, int position) {
        this.mapping = mapping;
        this.reverseMapping = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        this.position = position;
    }

    // Method to perform forward encryption
    public char forward(char input) {
        int inputIndex = (input - 'A' + position) % 26;
        char output = mapping.charAt(inputIndex);
        output = (char) ((output - 'A' - position + 26) % 26 + 'A');
        return output;
    }

    // Method to perform backward decryption
    public char backward(char input) {
        int inputIndex = (input - 'A' + position) % 26;
        char output = reverseMapping.charAt(inputIndex);
        output = (char) ((output - 'A' - position + 26) % 26 + 'A');
        return output;
    }

    // Method to rotate the rotor
    public void rotate() {
        position = (position + 1) % 26;
    }
}
