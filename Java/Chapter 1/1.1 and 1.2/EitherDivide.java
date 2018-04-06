public class EitherDivide{
	public static void main(String[] args){
		int Value1 = Integer.parseInt(args[0]);
		int Value2 = Integer.parseInt(args[1]);
		
		if (Value1 % Value2 == 0){
			System.out.println("true");
		} else if (Value2 % Value1 == 0){
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}
}