import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class DecryptScript {

    public static void main(String[] args) {
        String keyString = "232522637373"; // Key
        String ivString = "805928D9E7BBeerrC501578AF0ACEE"; //IV

        byte[] key = hexStringToByteArray(keyString);
        byte[] iv = hexStringToByteArray(ivString);

        // Encrypted parameter
        String encryptedParameter = "wz3B3yCadqStnmt0GQGJ6w=="; // Replace with the actual encrypted value
       // String encryptedParameter = "gVDkzouDis1+fIf9cLPRhg==="; 

        // Decrypt the parameter
        String decryptedParameter = decrypt(encryptedParameter, key, iv);

        // Print the decrypted value
        System.out.println("Decrypted Parameter: " + decryptedParameter);
    }

    public static byte[] hexStringToByteArray(String hex) {
        int len = hex.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4)
                    + Character.digit(hex.charAt(i + 1), 16));
        }
        return data;
    }

    public static String decrypt(String encryptedText, byte[] key, byte[] iv) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
            IvParameterSpec ivSpec = new IvParameterSpec(iv);
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);

            byte[] encryptedBytes = Base64.getDecoder().decode(encryptedText);

            // Decrypt the bytes
            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

            // Convert the decrypted bytes to a string
            return new String(decryptedBytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace(); // Print the exception details
            return "Decryption failed: " + e.getMessage();
        }
    }
}
