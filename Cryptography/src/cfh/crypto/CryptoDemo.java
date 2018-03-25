package cfh.crypto;

public class CryptoDemo {

	public static void main(String[] args) {
		{//Simple Cryptography
			int key = 3;
			CaesarCrypto cc = new CaesarCrypto(key);
			String original= "Internet of Things";
			String encrypted = cc.encrypt(original);
			String decrypted = cc.decrypt(encrypted);
			System.out.format("\n%s ==> %s ==> %s", original, encrypted, decrypted);
		}
		//==========================================================

		{//Double Cryptography
			int key = 2;
			int[] shift = { 2, 4, 5 };

			JuliusCaesar jc = new JuliusCaesar(shift, key);
			String original= "Hello World";
			String encrypted = jc.encrypt(original);
			String decrypted = jc.decrypt(encrypted);
			System.out.format("\n%s ==> %s ==> %s", original, encrypted, decrypted);
		}

	}

}
