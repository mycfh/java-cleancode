package cfh.crypto;

public class CaesarCrypto extends CaesarCipher {
	
	//Constructor
	public CaesarCrypto(int key) {
		super(key);
	}
	
	@Override
	public String encrypt(String phrase) {
		char[] rs = phrase.toCharArray();
		
		for(int i=0; i<rs.length; i++) {
			rs[i]= shift(rs[i]);
		}
		return new String(rs);
	}

	@Override
	public String decrypt(String phrase) {
		char[] rs = phrase.toCharArray();

		for(int i=0; i<rs.length; i++) {
			rs[i]= unshift(rs[i]);
		}
		return new String(rs);
	}
	
	
	private char shift(char c) {
		if(!Character.isAlphabetic(c)) return c;
		char base= Character.isLowerCase(c)?'a':'A';
		int j= (int)c-base + super.getKey();
		j= j%26;
		return (char)(j+base);
	}
	
	private char unshift(char c) {
		if(!Character.isAlphabetic(c)) return c;
		char base= Character.isLowerCase(c)?'a':'A';
		int j= (int)c-base - super.getKey();
		j= (j+26)%26;
		return (char)(j+base);
	}
	
}