import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.util.Base64;
import java.util.Scanner;

public class DESEncryptionExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter plaintext: ");
        String plaintext = scanner.nextLine();

        System.out.println("Enter key (8 characters): ");
        String keyString = scanner.nextLine();

        try {
            byte[] keyBytes = keyString.getBytes();
            DESKeySpec desKeySpec = new DESKeySpec(keyBytes);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey key = keyFactory.generateSecret(desKeySpec);

            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);

            byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes());

            String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);

            System.out.println("Example A:");
            System.out.println("Plaintext: " + plaintext);
            System.out.println("Key: " + keyString);
            System.out.println("Encrypted text: " + encryptedText);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}