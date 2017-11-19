package novelhealthcare;

public class Test {

	
	public static void main(String[] args) {
	
		
		String input =null;
		
		try{
			
			long value =Long.parseLong(input);
			System.out.println("value is "+value);
			
		}catch(NumberFormatException e){
			System.out.println("catch");
			e.printStackTrace();
		}
		
		
	}
	
	
}
