import java.util.*;

class Calculator
{
	public static void main(String args[])
	{
		double num1,num2,res;
		Scanner sc = new Scanner(System.in);
		System.out.println("First num:");
		num1 = sc.nextDouble();
		System.out.println("Second num:");
		num2 = sc.nextDouble();
		System.out.println("Choose +,-,*,/");
		char operator = sc.next().charAt(0);

		switch(operator)
		{
			case '+':
				res = num1 + num2;
				System.out.println(res);
				break;
			case '-':
				res = num1 - num2;
				System.out.println(res);
				break;
			case '/':
				res = num1 / num2;
				System.out.println(res);
				break;
			case '*':
				res = num1 * num2;
				System.out.println(res);
				break;
			default:
				System.out.println("Try Again using Correct Operator");
				break;
				
		}
		sc.close();
	}
}