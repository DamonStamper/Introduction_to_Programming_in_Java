public class LeapYear {
  public static void main(String[] args){
	int year = Integer.parseInt(args[0]);
	boolean isLeapYear;
	//If year is divisible by 4 without any remainder then it is a leap year
	sLeapYear = (year % 4 == 0);
	//Unless it is divisible by 100. Both must be true. setting 2nd value to true if 'year'/100 doesn't divide evenly.
	isLeapYear = isLeapYear && (year % 100 != 0 );
	//Except for when year is divisible by 400.
	isLeapYear = isLeapYear || (year % 400 == 0);
	system.out.println(isLeapYear);
  }
}