package cfh.crypto;

public class JuliusCaesar extends CaesarCrypto{
	private int[] shift;
	private int idx;
	
	// Constructor
	public JuliusCaesar(int[] shift, int key) {
		super(key);
		this.shift= shift;
	}
	
	@Override
	public String encrypt(String phrase) {
		String rs = super.encrypt(phrase);
		char[] rc = rs.toCharArray();
		idx=0;
		
		for(int i=0; i<rc.length; i++) {
			rc[i]= shift(rc[i]);
		}
		return new String(rc);
	}

	@Override
	public String decrypt(String phrase) {
		String rs = super.decrypt(phrase);
		char[] rc = rs.toCharArray();
		idx=0;
		
		for(int i=0; i<rc.length; i++) {
			rc[i]= unshift(rc[i]);
		}
		return new String(rc);
	}
	
	private char shift(char c) {
		if(!Character.isAlphabetic(c)) return c;
		char base= Character.isLowerCase(c)?'a':'A';
		int j= (int)c-base + shift[idx];
		idx= ++idx % shift.length;
		j= j%26;
		return (char)(j+base);
	}
	
	private char unshift(char c) {
		if(!Character.isAlphabetic(c)) return c;
		char base= Character.isLowerCase(c)?'a':'A';
		int j= (int)c-base - shift[idx];
		idx= ++idx % shift.length;
		j= (j+26)%26;
		return (char)(j+base);
	}
	
}
