import java.util.*;
public class TwoSum
{

    public static int[] twoSum(int[] nums, int target) 
    {
        int index[] = new int[2];

        for(int i =0; i<nums.length-1; i++)
        {
            for(int j =i+1; j<nums.length; j++)
            {
                if(nums[i] + nums[j] == target)
                {
                    index[0] = i;
                    index[1] = j;
                    return index;
                }
            }

        }
        return null; 
    }




    public static void main (String args[])

    {
        //
        int num []= {3, 6, 10, 14};
        int target = 9;
        System.out.println(Arrays.toString( twoSum(num , target)))
        
    }

}

