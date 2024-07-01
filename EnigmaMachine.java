import java.util.ArrayList;
import java.util.List;

// Enigma machine class
public class EnigmaMachine {
    private List<Rotor> rotors;
    private String reflector;

    // Constructor
    public EnigmaMachine(List<Rotor> rotors, String reflector) {
        this.rotors = rotors;
        this.reflector = reflector;
    }

    // Method to encrypt a single character
    public char encrypt(char input) {
        for (int i = rotors.size() - 1; i >= 0; i--) {
            input = rotors.get(i).forward(input);
        }
        input = reflector.charAt(input - 'A');
        for (int i = 0; i < rotors.size(); i++) {
            input = rotors.get(i).backward(input);
        }
        advanceRotors(); // Advance rotor positions after encryption
        return input;
    }

    // Method to encrypt a message
    public String encryptMessage(String message) {
        StringBuilder encryptedMessage = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                c = Character.toUpperCase(c);
                c = encrypt(c);
                encryptedMessage.append(c);
            }
        }
        return encryptedMessage.toString();
    }

    // Method to decrypt a single character
    public char decrypt(char input) {
        for (int i = rotors.size() - 1; i >= 0; i--) {
            input = rotors.get(i).forward(input);
        }
        input = reflector.charAt(input - 'A');
        for (int i = 0; i < rotors.size(); i++) {
            input = rotors.get(i).backward(input);
        }
        advanceRotors(); // Advance rotor positions after decryption
        return input;
    }

    // Method to decrypt a message
    public String decryptMessage(String message) {
        StringBuilder decryptedMessage = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                c = Character.toUpperCase(c);
                c = decrypt(c);
                decryptedMessage.append(c);
            }
        }
        return decryptedMessage.toString();
    }

    // Method to advance rotor positions
    private void advanceRotors() {
        for (Rotor rotor : rotors) {
            rotor.rotate();
        }
    }
}

