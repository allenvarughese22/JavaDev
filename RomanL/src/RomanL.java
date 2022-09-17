import java.util.HashMap;
import java.util.Map;

public class RomanL
{

	public static int romantoint(String s)
	{
		Map <Character, Integer> map = new HashMap();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		
		int r =0;
		
		for (int i = 0; i < s.length(); i++)
		{
			if (i>0 && map.get(s.charAt(i)) > map.get(s.charAt(i-1)))
			{
				r +=map.get(s.charAt(i))- 2* map.get(s.charAt(i-1));
			}
			else
			{
				r +=map.get(s.charAt(i));
				
			}
		}
		
		
		
		return r;
		
	}
	
	public static void main(String[] args)
	{
		String s ="IV";
		System.out.println(romantoint(s));
	}
	
	
}
