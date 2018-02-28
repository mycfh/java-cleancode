package cfh.syntax.example1;

public class ReadRealSimple {
	private enum State{	START, NUM_SIGN, INTEGER, FRACTION, ERROR }
	private char ch;
	//private String str;
	
	private State state;
	private double value, factor;
	private boolean neg, num= false;

	
	public ReadRealSimple(){
		
	}
	
	public void parse(String str){
		//this.str= str;
		state= State.START;
		factor= 1.0;
		neg= false;
		
		for(int i=0; i<str.length();i++){
			ch= str.charAt(i);
			switch(state){
			case START:
				if(ch=='+'||ch=='-'){
					state= State.NUM_SIGN;
					neg= (ch=='-');
				}else if(Character.isDigit(ch)){
					state= State.INTEGER;
					value= Character.getNumericValue(ch);
				}else{
					state= State.ERROR;
				}
				break;
			case NUM_SIGN:
				if(Character.isDigit(ch)){
					state= State.INTEGER;
					value= Character.getNumericValue(ch);
				}else{
					state= State.ERROR;
				}
				break;
			case INTEGER:
				if(Character.isDigit(ch)){
					value= value*10.0 + Character.getNumericValue(ch);
				}else if(ch=='.'){
					state= State.FRACTION;
				}else{
					state= State.ERROR;
				}
				break;
			case FRACTION:
				if(Character.isDigit(ch)){
					factor= factor * 0.1;
					value= value + factor * Character.getNumericValue(ch);
				}else{
					state= State.ERROR;
				}
				break;
			case ERROR:
				break;
			}//switch
			if(state==State.ERROR) break;
		}//for
		
		num= (state==State.INTEGER||state==State.FRACTION)?true:false;
		if(neg){value= -value;}
	}

	public double getValue() { return value; }
	public boolean isNum() {return num;	}
//====================================================================
	public static void main(String[] args){
		ReadRealSimple rrs= new ReadRealSimple();
		rrs.parse("23.168");
		if(rrs.isNum()){
			System.out.println(rrs.getValue());
		}else{
			System.out.println("It is Not Number");
		}
	}
}
