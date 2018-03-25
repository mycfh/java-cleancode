package cfh.crypto;

public abstract class CaesarCipher {
	private int key; // shift key

	// constructor
	public CaesarCipher(int key) {
		this.key = key;
	}
	
	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public abstract String encrypt(String phrase);

	public abstract String decrypt(String phrase);
}