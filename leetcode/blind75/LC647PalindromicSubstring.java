package dsa.leetcode.blind75;

public class LC647PalindromicSubstring {
    public int countSubstrings(String s) {
        if(s.length() == 1) return 1;

        int count = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                String subs = s.substring(i, j+1);
                if(isPalindrome(subs)){
                    count++;
                }
            }
        }
        return count;
    }
    public boolean isPalindrome(String s){
        if(s.length() == 1) return true;

        int fw = 0;
        int bw = s.length()-1;

        while(fw < bw){
            if(s.charAt(fw) != s.charAt(bw)){
                return false;
            }
            fw++;
            bw--;
        }
        return true;
    }
}
