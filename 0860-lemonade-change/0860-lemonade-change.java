class Solution {
    public boolean lemonadeChange(int[] bills){
       int five=0, tens=0;
       for(int bill:bills){
        if(bill==5){
            five++;
        }else if(bill ==10 ){
            if(five==0) return false;
              tens++;
              five--;
        }
  else if(bill==20){
                if(five>0 && tens>0)
                {
                    tens--;
                    five--;
                }
                else if(five>2){
                    five-=3;
                }
                else{
                return false;
                }
            }
        }
       
       
       return true;
}
    
}