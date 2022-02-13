package it.matteoponzini.array.cesarcipher;

import it.matteoponzini.array.caesarcipher.CaesarCipher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CaesarCipherTest {


    @Test
    void encryptWith3Rotation() {
        CaesarCipher caesarCipher = new CaesarCipher(3);
        String word = "zanzara";
        String encryptWord = caesarCipher.encrypt(word);
        assertEquals(word, caesarCipher.decrypt(encryptWord));

        word = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG".toLowerCase();
        encryptWord = caesarCipher.encrypt(word);
        assertEquals(word, caesarCipher.decrypt(encryptWord));
    }

    @Test
    void encryptWith90Rotation() {
        CaesarCipher caesarCipher = new CaesarCipher(90);
        String word = "zanzara";
        String encryptWord = caesarCipher.encrypt(word);
        assertEquals(word, caesarCipher.decrypt(encryptWord));

        word = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG".toLowerCase();
        encryptWord = caesarCipher.encrypt(word);
        assertEquals(word, caesarCipher.decrypt(encryptWord));
    }

}
