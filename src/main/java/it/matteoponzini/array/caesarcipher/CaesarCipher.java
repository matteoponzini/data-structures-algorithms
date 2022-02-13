package it.matteoponzini.array.caesarcipher;

public record CaesarCipher(int rotation) {

    public String encrypt(String message) {
        return cipher(message, true);
    }

    public String decrypt(String message) {
        return cipher(message, false);
    }


    private String cipher(String message, boolean isEncrypt) {
        message = message.toLowerCase();
        char startLetter = (isEncrypt) ? 'a' : 'z';
        StringBuilder encrypt = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char character = ' ';
            if (message.charAt(i) != ' ') {
                int alphabetPosition = message.charAt(i) - startLetter;
                int cipherPosition = (isEncrypt) ? (alphabetPosition + rotation) % 26 : (alphabetPosition - rotation) % 26;
                character = (char) (startLetter + cipherPosition);
            }
            encrypt.append(character);
        }
        return encrypt.toString();
    }
}
