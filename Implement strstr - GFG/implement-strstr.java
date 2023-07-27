//{ Driver Code Starts
import java.util.*;


class Implement_strstr
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String line = sc.nextLine();
			String a = line.split(" ")[0];
			String b = line.split(" ")[1];
			
			GfG g = new GfG();
			System.out.println(g.strstr(a,b));
			
			t--;
		}
	}
}
// } Driver Code Ends


class GfG
{
    //Function to locate the occurrence of the string x in the string s.
    int strstr(String s, String x)
    {
       // Your code here
       int n = s.length();
        int m = x.length();

        // Traverse through the main string 's' and check for 'x'
        for (int i = 0; i <= n - m; i++) {
            int j;
            // Check for 'x' starting from the current position i in 's'
            for (j = 0; j < m; j++) {
                if (s.charAt(i + j) != x.charAt(j))
                    break;
            }
            // If the loop ran completely without a break, it means 'x' is found
            if (j == m)
                return i;
        }

        // If 'x' is not found, return -1
        return -1;
       
    }
}
