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
public class DecryptScript {

    public static void main(String[] args) {
        String keyString = "your-actual-key"; // Replace with your actual key
        String ivString = "your-actual-iv";   // Replace with your actual IV

        byte[] key = hexStringToByteArray(keyString);
        byte[] iv = hexStringToByteArray(ivString);

        // Your actual encrypted parameter
        String encryptedParameter = "your-actual-encrypted-parameter";

        String decryptedParameter = decrypt(encryptedParameter, key, iv);

        System.out.println("Decrypted Parameter: " + decryptedParameter);
    }
}

License
This project is free and open-source with no specific license. It is considered to be in the public domain. Feel free to use, modify, and distribute it as needed for your purposes.



Feel free to adapt the README according to your preferences and requirements. If you have any more requests or questions, let me know!
