import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class EncryptScript {

    private static final String keyString = "79509819877EE4F2FF07C4B6406E94379412433E798D418C46A1DA7FCC17D38C";
    private static final String ivString = "805928D9E7BB4483C6C501578AF0ACEE";

    public static void main(String[] args) {
        // Replace "YourParameterHere" with the actual parameter you want to encrypt
        String parameterToEncrypt = "MSISDN_POSTPAID";
        
        String encryptedParameter = encryptHeader(parameterToEncrypt);
        System.out.println("Encrypted Parameter: " + encryptedParameter);
    }

    private static String encryptHeader(String parameter) {
        try {
            byte[] key = hexStringToByteArray(keyString);
            byte[] iv = hexStringToByteArray(ivString);

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
            IvParameterSpec ivSpec = new IvParameterSpec(iv);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);

            byte[] encryptedBytes = cipher.doFinal(parameter.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static byte[] hexStringToByteArray(String hex) {
        int len = hex.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4)
                    + Character.digit(hex.charAt(i + 1), 16));
        }
        return data;
    }
}
