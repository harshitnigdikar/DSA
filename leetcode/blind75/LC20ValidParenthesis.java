package dsa.leetcode.blind75;

import java.util.Stack;

public class LC20ValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        int i = 0;
        while(s.length() > i){
            char x = s.charAt(i);
            i++;
            if(x == '(' || x == '{' || x == '['){
                st.push(x);
            }else{
                if(x == ')'){
                    if(!st.isEmpty() && st.peek() == '('){
                        st.pop();
                    }else{
                        return false;
                    }
                }else if(x == '}'){
                    if(!st.isEmpty() && st.peek() == '{'){
                        st.pop();
                    }else{
                        return false;
                    }
                }else if(x == ']'){
                    if(!st.isEmpty() && st.peek() == '['){
                        st.pop();
                    }else{
                        return false;
                    }
                }
            }
        }
        if(!st.isEmpty()){
            return false;
        }
        return true;
    }
}
