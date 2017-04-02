public class SinCosRoughlyOne{
	public static void main(String[] args){
		int theta = Integer.parseInt(args[0]);
		
		double sin_squared = Math.pow(Math.sin(theta), 2);
		double tan_squared = Math.pow(Math.tan(theta), 2);
			
		double result = sin_squared + tan_squared;
		System.out.println("SIN = " + sin_squared);
		System.out.println("TAN = " + tan_squared);
		System.out.println("result = " + result);
	}
}