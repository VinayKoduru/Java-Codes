import java.util.*;
class PrimeCalc
{
	int calc(int p)
	{
		int i,m=0;
		m=p/2;
		if(p==0 || p==1)
		{
			return 0;
		}
		else if(p>1)
		{
			for(i=2;i<=m;i++)
			{
				if(p%i==0)
				{
					return 0;
				}
			}
		}
		return 1;
	}
}
class PrimeNumber 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int prime = sc.nextInt();
		PrimeCalc pc = new PrimeCalc();
		int res = pc.calc(prime);
		if(res==0)
		{
			System.out.println("given number is not a prime number");
		}
		else if(res==1)
		{
			System.out.println("given number is a prime number");
		}
	}
}
