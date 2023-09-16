//{ Driver Code Starts
import java.util.*;
class PalindromicArray{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
			int n = sc.nextInt();
			int[] a = new int[n];
			for(int i = 0 ;i < n; i++)
				a[i]=sc.nextInt();
			GfG g = new GfG();
			System.out.println(g.palinArray(a , n));
		}
	}
}
// } Driver Code Ends


/*Complete the Function below*/
class GfG
{
    public static int reversed(int num){
        int revNum = 0;
        while(num > 0){
            int temp = num%10;
            revNum = revNum*10+temp;
            num = num/10;
        }
        return revNum;
    }
    
	public static int palinArray(int[] arr, int n)
    {
        //add code here.
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != reversed(arr[i])){
                return 0;
            }
        }
        return 1;
    }
}