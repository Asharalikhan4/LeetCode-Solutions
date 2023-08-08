//{ Driver Code Starts
import java.util.Scanner;
import java.lang.Math;

class Convert_To_Five {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int N = sc.nextInt();
            System.out.println(new GfG().convertfive(N));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG {
    int convertfive(int num) {
        // Your code here
        int ans = 0;
        int p = 1;
        while(num > 0){
            int last = num%10;
            if(last == 0){
                last = 5;
            }
            num = num/10;
            ans += last*p;
            p = p*10;
        }
        return ans;
    }
}