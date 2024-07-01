import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class OneTimePadCipher extends JFrame {

    private static final char[] ALL_CHARS = {
        ' ', 
        '0', '1', '2', '3','4', '5', '6', '7', '8', '9',
        'A', 'B', 'C', 'D', 'E', 'F', 'G','H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q','R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
         '!', '"', '#', '$', '%', '&', '\'', '(', ')','*', '+', ',', '-', '.', '/',
         ':', ';', '<', '=','>', '?', '@',
         '[','\\', ']', '^', '_', '`',
         '{', '|', '}', '~'
    };

    private JTextArea inputTextArea;
    private JTextArea keyTextArea;
    private JTextArea outputTextArea;
    private JButton encryptButton;
    private JButton decryptButton;

    public OneTimePadCipher() {
        setTitle("One-Time Pad Cipher");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        inputTextArea = new JTextArea(4, 25);
        keyTextArea = new JTextArea(4, 25);
        outputTextArea = new JTextArea(4, 25);
        encryptButton = new JButton("Encrypt");
        decryptButton = new JButton("Decrypt");

        setLayout(new BorderLayout());

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(6, 1, 5, 5)); // Adjusted to include labels and spacing

        centerPanel.add(new JLabel("Input Text:"));
        centerPanel.add(new JScrollPane(inputTextArea));
        centerPanel.add(new JLabel("Key:"));
        centerPanel.add(new JScrollPane(keyTextArea));
        centerPanel.add(new JLabel("Output Text:"));
        centerPanel.add(new JScrollPane(outputTextArea));

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout());
        southPanel.add(encryptButton);
        southPanel.add(decryptButton);

        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);

        encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String plaintext = inputTextArea.getText();
                String key = generateKey(plaintext.length());
                keyTextArea.setText(key);
                String ciphertext = encrypt(plaintext, key);
                outputTextArea.setText(ciphertext);
            }
        });

        decryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ciphertext = inputTextArea.getText();
                String key = keyTextArea.getText();
                String plaintext = decrypt(ciphertext, key);
                outputTextArea.setText(plaintext.trim()); // Trim leading/trailing spaces or newlines (optional)
            }
        });
    }

    private String generateKey(int length) {
        Random random = new Random();
        StringBuilder key = new StringBuilder();
        for (int i = 0; i < length; i++) {
            key.append(ALL_CHARS[random.nextInt(ALL_CHARS.length)]);
        }
        return key.toString();
    }

    private String encrypt(String plaintext, String key) {
        StringBuilder ciphertext = new StringBuilder();
        for (int i = 0; i < plaintext.length(); i++) {
            char plainChar = plaintext.charAt(i);
            char keyChar = key.charAt(i);
            int plainIndex = indexOf(ALL_CHARS, plainChar);
            int keyIndex = indexOf(ALL_CHARS, keyChar);
            char cipherChar = ALL_CHARS[(plainIndex + keyIndex) % ALL_CHARS.length];
            ciphertext.append(cipherChar);
        }
        return ciphertext.toString();
    }

    private String decrypt(String ciphertext, String key) {
        StringBuilder plaintext = new StringBuilder();
        for (int i = 0; i < ciphertext.length(); i++) {
            char cipherChar = ciphertext.charAt(i);
            char keyChar = key.charAt(i);
            int cipherIndex = indexOf(ALL_CHARS, cipherChar);
            int keyIndex = indexOf(ALL_CHARS, keyChar);
            char plainChar = ALL_CHARS[(cipherIndex - keyIndex + ALL_CHARS.length) % ALL_CHARS.length];
            plaintext.append(plainChar);
        }
        return plaintext.toString().trim();
    }

    private int indexOf(char[] array, char ch) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ch) {
                return i;
            }
        }
        return -1;  // This should never happen if input is valid
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new OneTimePadCipher().setVisible(true);
            }
        });
    }
}