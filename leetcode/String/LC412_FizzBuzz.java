package leetcode.String;

import java.util.ArrayList;
import java.util.List;

public class LC412_FizzBuzz {
    class Solution {
        public List<String> fizzBuzz(int n) {
            List<String> ans = new ArrayList();

            for(int i=1; i<=n; i++){
                boolean fz = (i%3==0);
                boolean bz = (i%5==0);

                String temp = "";

                if(fz){
                    temp+="Fizz";
                }
                if(bz){
                    temp+="Buzz";
                }
                if(temp.equals("")){
                    temp+=Integer.toString(i);
                }
                ans.add(temp);
            }
            return ans;

        }
    }
}
