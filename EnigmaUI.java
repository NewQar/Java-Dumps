import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class EnigmaUI extends JFrame {
    private JTextArea inputTextArea;
    private JTextArea outputTextArea;
    private JButton encryptButton;
    private JButton decryptButton;

    private EnigmaMachine enigmaMachine;

    public EnigmaUI() {
        setTitle("Enigma Machine");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
        enigmaMachine = createEnigmaMachine();

        encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputTextArea.getText();
                String encryptedMessage = enigmaMachine.encryptMessage(input);
                outputTextArea.setText(encryptedMessage);
            }
        });

        decryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputTextArea.getText();
                String decryptedMessage = enigmaMachine.decryptMessage(input);
                outputTextArea.setText(decryptedMessage);
            }
        });
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        inputTextArea = new JTextArea(5, 20);
        JScrollPane inputScrollPane = new JScrollPane(inputTextArea);
        mainPanel.add(inputScrollPane);

        encryptButton = new JButton("Encrypt");
        mainPanel.add(encryptButton);

        decryptButton = new JButton("Decrypt");
        mainPanel.add(decryptButton);

        outputTextArea = new JTextArea(5, 20);
        JScrollPane outputScrollPane = new JScrollPane(outputTextArea);
        mainPanel.add(outputScrollPane);

        add(mainPanel);
    }

    private EnigmaMachine createEnigmaMachine() {
        // Define rotors, reflector, and plugboard settings
        List<Rotor> rotors = new ArrayList<>();
        rotors.add(new Rotor("EKMFLGDQVZNTOWYHXUSPAIBRCJ", 0));
        rotors.add(new Rotor("AJDKSIRUXBLHWTMCQGZNPYFVOE", 0));
        rotors.add(new Rotor("BDFHJLCPRTXVZNYEIWGAKMUSQO", 0));

        String reflector = "YRUHQSLDPXNGOKMIEBFZCWVJAT";

        return new EnigmaMachine(rotors, reflector);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EnigmaUI().setVisible(true);
            }
        });
    }
}
