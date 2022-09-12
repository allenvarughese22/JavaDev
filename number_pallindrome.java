// iterate through integer

class number_pallindrome
{
	public static boolean isPalindrome(int x) 
	{

		String s = String.valueOf(x);
		System.out.println( s.length());

		
		for (int i = 0; i<((s.length()-1)/2); i++)
		{
			if  (s.charAt(i) != s.charAt(s.length()-1-i))
			{
				return false;
			}
		}
		return true;
	}



	public static void main(String[] args) 
	{
		int a = 10;
		System.out.println(isPalindrome(a));
	}
}
