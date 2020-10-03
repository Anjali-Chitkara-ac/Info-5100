package Assignment3;

import java.util.ArrayList;
import java.util.List;

public class ReverseString {
    public String reverseString(String s){
        s = s.trim();
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(i==s.length()-1){
                //add the last element
                sb.append(s.charAt(i));
                ans.add(sb.toString());
            }
            if(s.charAt(i)!=' '){
                sb.append(s.charAt(i));
            }else {
                ans.add(sb.toString().trim());
                sb = new StringBuilder();
            }
        }

        StringBuilder result = new StringBuilder();
        for(int j=ans.size()-1;j>=0;j--){
            if(!ans.get(j).equals("")){
                //System.out.println("["+ans.get(j)+"]");
                result.append(ans.get(j));
                result.append(" ");
            }
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        ReverseString obj = new ReverseString();
        String ans = obj.reverseString("   the sky     is blue");
        System.out.println(ans);
    }
}
