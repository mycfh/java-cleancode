package cfh.simple2.afm;

public class Afm {
	public static boolean check(String s) {
		boolean v=false;
		if(s.length() != 9) return v;
		char c[]= s.toCharArray();
		int sum=0;
		int p= 256;
		for(int i=0; i<c.length-1; i++) {
			if(!Character.isDigit(c[i])) return v;
			sum+= p*(Character.getNumericValue(c[i]));
			p /=2;
		}
		
		int u= sum%11;
		System.out.println(u);
		if(u==10) {
			if(c[8]=='0') v=true;
		}else {
			if(u==Character.getNumericValue(c[8])) v=true;
		}
		for(int i=0; i<9;i++) {
			System.out.format(" %c", c[i]);
		}
		return v;
	}
}
