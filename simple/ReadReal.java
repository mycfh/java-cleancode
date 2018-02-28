package cfh.syntax.example1;

public class ReadReal {
	private enum State{
		START, AFTER_NUM_SIGN, INTEGER, FRACTION, EXP_SIGN,
		AFTER_EXP_SIGN, EXP_VALUE, ERROR
	}
	private State state;
	private String str;
	private double value, factor;
	private char ch;
	private boolean neg, expNeg, num=false;
	private int digValue, expValue;
	
	public ReadReal(){
		
	}
	
	public void parse(String s){
		this.str= s;
		state= State.START;
		factor= 1.0;
		neg= false; expNeg= false;
		
		for(int i=0; i<str.length();i++){
			ch= str.charAt(i);

			switch(state){
			case START:
				if(ch=='+'||ch=='-'){
					state= State.AFTER_NUM_SIGN;
					neg= (ch=='-');
				}else if(Character.isDigit(ch)){
					state= State.INTEGER;
					digValue= Character.getNumericValue(ch);
					value= digValue;
				}else{
					state= State.ERROR;
				}
				break;
			case AFTER_NUM_SIGN:
				if(Character.isDigit(ch)){
					state= State.INTEGER;
					digValue= Character.getNumericValue(ch);
					value= digValue;
				}else{
					state= State.ERROR;
				}
				break;
			case INTEGER:
				if(Character.isDigit(ch)){
					digValue= Character.getNumericValue(ch);
					value= value*10.0 + digValue;
				}else if(ch=='.'){
					state= State.FRACTION;
					
				}else if(ch=='E'||ch=='e'){
					state= State.EXP_SIGN;
				}else{
					state= State.ERROR;
				}
				break;
			case FRACTION:
				if(Character.isDigit(ch)){
					factor= factor * 0.1;
					digValue= Character.getNumericValue(ch);
					value= value + digValue*factor;
				}else if(ch=='E'||ch=='e'){
					state= State.EXP_SIGN;
					expValue= 0;
				}else{
					state= State.ERROR;
				}
				break;
			case EXP_SIGN:
				if(Character.isDigit(ch)){
					state= State.EXP_VALUE;
					digValue= Character.getNumericValue(ch);
					expValue= digValue;
				}else if(ch=='+'||ch=='-'){
					state= State.AFTER_EXP_SIGN;
					expNeg= (ch=='-');
				}else{
					state= State.ERROR;
				}
				break;
			case AFTER_EXP_SIGN:
				if(Character.isDigit(ch)){
					state= State.EXP_VALUE;
					digValue= Character.getNumericValue(ch);
					expValue= digValue;
				}else{
					state= State.ERROR;
				}
				break;
			case EXP_VALUE:
				if(Character.isDigit(ch)){
					digValue= Character.getNumericValue(ch);
					expValue= expValue*10 + digValue;
				}else{
					state= State.ERROR;
				}
				break;
			case ERROR:
				
				break;
			}//switch
		}//for
		
		if(state==State.INTEGER||state==State.FRACTION||state==State.EXP_VALUE){
			num= true;
		}else{
			num= false;
		}

		if(state==State.EXP_VALUE){
			factor= (expNeg)? 0.1 : 10.0;
			while(expValue>0){
				value = value * factor;
				expValue--;
			}
		}
		if(neg){value= -value;}
	}

	public double getValue() {
		return value;
	}

	public boolean isNum() {
		return num;
	}
//====================================================================
	public static void main(String[] args){
		ReadReal readReal= new ReadReal();
		readReal.parse("23.168e-2");
		if(readReal.isNum()){
			System.out.format("%15.6f", readReal.getValue());
		}else{
			System.out.println("It is Not Number");
		}
	}
}
