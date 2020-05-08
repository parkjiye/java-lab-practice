import java.io.*;
import java.util.Scanner;
//OutofRangeException
//AddZeroException
//SubtractZeroException
class AddZeroException extends Exception{
	
}

class SubtractZeroException extends Exception{
	
}

class OutOfRangeException extends Exception{
	
}
class Calculator{
	String num1;
	String operator;
	String num2;
	int result;
	
	void addcheckingzero(String num1,String num2) throws AddZeroException, OutOfRangeException{
		if(!num1.equals("0")&&!num2.equals("0")) {
			if((Integer.parseInt(num1)>=0)&&(Integer.parseInt(num2)>=0)&&(1000>=Integer.parseInt(num2))&&(1000>=Integer.parseInt(num1))) {
				this.result = Integer.parseInt(num1) + Integer.parseInt(num2);
				if(this.result>1000) {
					throw new OutOfRangeException();
				}
			}
			else {
				throw new OutOfRangeException();
			}
			
		}
		else {
			throw new AddZeroException();
		}
	}
	
	void subcheckingzero(String num1, String num2) throws SubtractZeroException,OutOfRangeException{
		if(!num1.equals("0")&&!num2.equals("0")) {
			if((Integer.parseInt(num1)>=0)&&(Integer.parseInt(num2)>=0)&&(1000>=Integer.parseInt(num2))&&(1000>=Integer.parseInt(num1))) {
				this.result = Integer.parseInt(num1) - Integer.parseInt(num2);
				
			}
			else {
				throw new OutOfRangeException();
			}
			
		}
		else {
			throw new SubtractZeroException();
		}
	}
	int getresult() {
		return result;
	}
}
public class SimpleCalculator {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Calculator me=new Calculator();
		
		String sen=sc.nextLine();
		int idx;
		if(sen.indexOf("+")==-1) {
			idx=sen.indexOf("-");
		}
		else {
			idx=sen.indexOf("+");
		}
		
		
		
		me.num1=sen.substring(0,idx);
		me.operator=sen.substring(idx,idx+1);
		me.num2=sen.substring(idx+1);
		
		try {
			if(me.operator.equals("+")) {
				me.addcheckingzero(me.num1, me.num2);
				System.out.println(me.getresult());
			}
			else {
				me.subcheckingzero(me.num1, me.num2);
				System.out.println(me.getresult());
			}
		}
		catch(AddZeroException e) {
			System.out.println("AddZeroException");
		
		}
		catch(SubtractZeroException e) {
			System.out.println("SubtractZeroExcpetion");

		}
		catch(OutOfRangeException e) {
			System.out.println("OutOfRangeException");

		}


	}

}
