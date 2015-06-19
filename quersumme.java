@author Torsten Zimmer, Michale Kortstock und Jochen Hertle


@version 1.0

public class Quersumme
 
{
    public static void main(String[] args)
    {
	int n;		   
	int sum = 0;
	int div;
	int mod;

	n = Integer.parseInt(args[0]);

	if ((0 < n) && (n < 10000))
	{ 
		mod = n % 10;
		div = n / 10;
		sum = mod;
		
		System.out.printf("Die Quersumme ergibt sich aus: " + mod); 

		while(div != 0)
		{	    	
			mod = div % 10;
			div = div / 10;
			sum = sum + mod;
			System.out.printf(" " + mod);	   	
		}
		System.out.printf(" = " + sum);
			
	}
	else
		System.out.println("Kein g�ltiger Wert eingegeben.");	
    }
}