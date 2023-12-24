# AES Decryption Java Application

## Overview

This Java application provides functionality for decrypting data using the AES/CBC/PKCS5Padding encryption algorithm. It includes a `DecryptScript` class with methods to convert hexadecimal strings to byte arrays, perform decryption, and a `main` method demonstrating how to use the decryption functionality.

## Prerequisites

- Java Development Kit (JDK) installed on your machine.

## Usage

1. Clone the repository to your local machine:

    ```bash
    https://github.com/praveen2410-pk/Cipher_Algorithm.git
    ```

2. Open the project in your preferred Java IDE.

3. Customize the `keyString`, `ivString`, and `encryptedParameter` in the `DecryptScript` class with your actual values.

4. Run the `main` method in the `DecryptScript` class to see the decrypted parameter.

## Examples

```java
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class EncryptScript {

    private static final String keyString = "79509819877EE4F2FF07C4B64012433E798D418C46A1DA7FCC17D38C"; ///key values
    private static final String ivString = "80599E7BB4483C6C501578AF0ACEE"; /IV values

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

        String decryptedParameter = decrypt(encryptedParameter, key, iv);

        System.out.println("Decrypted Parameter: " + decryptedParameter);
    }
}

