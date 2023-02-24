class Solution {
    public int reverse(int x) {
        boolean negative = false;
        if (x<0){
            negative = true;
            x = x*(-1);
        }
        int temp =0;
        while(x>0){
            int lastdigit = x%10;
            int reverse = temp*10+lastdigit;
            
            if ((reverse - lastdigit)/10 != temp){
                return 0;
            }
            temp = reverse;
            x= x/10;
        }
        
        if (negative == true){
           temp = temp*(-1);
           return temp;

        }
        return temp;
    }
}