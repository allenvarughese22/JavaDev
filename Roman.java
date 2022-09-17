class Roman 
{
	public static int romanToInt(String s) 
	{
		int r =0;
		// if (s.charAt(i) = 'M' && i>0) 
		// {
		// 	if (s.charAt(i-1)  ='C')
		// 	{
		// 		r += 400
		// 		i++;

		// 	}

		// 	else 
		// 	{
		// 		r += 500
		// 		i++;
		// 	} 
		for (int i=0;i<s.length() ;i++ ) 
		{



			if(s.charAt(i) == 'M')
			{
				r += 1000;
				continue;
			}

			else if(s.charAt(i) == 'C')
			{
				if (i<(s.length() -1) & s.charAt(i+1) == 'M')
				{
					r += 900;
					i++;
					continue;
				}
				else
				{
					r += 100;

				}

			}
			
		}

		return r;


	}


	public static void main(String[] args) 
	{
		String s = "CC";
		
		System.out.println(romanToInt(s));
		
	}
}



