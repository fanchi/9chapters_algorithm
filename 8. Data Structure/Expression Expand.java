/*
Given an expression s includes numbers, letters and brackets. Number represents the number of repetitions inside the brackets(can be a string or another expression)．Please expand expression to be a string.

Have you met this question in a real interview? Yes
Example
s = abc3[a] return abcaaa
s = 3[abc] return abcabcabc
s = 4[ac]dy, return acacacacdy
s = 3[2[ad]3[pf]]xyz, return adadpfpfpfadadpfpfpfadadpfpfpfxyz

Challenge 
Can you do it without recursion?

Tags 
Stack Divide and Conquer Recursion Non Recursion Yahoo
Related Problems 
Hard Expression Tree Build 23 %
Hard Expression Evaluation 23 %
*/

////recusively
public class Solution {
    /*
     * @param s: an expression includes numbers, letters and brackets
     * @return: a string
     */
    public String expressionExpand(String s) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int numLeft = 0, numRight = 0;
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == '[') {
                numLeft ++;
                if (numLeft == 1) {
                    left.add(i);
                }
            }
            if (s.charAt(i) == ']') {
                numRight ++;
                if (numRight == numLeft) {
                    right.add(i);
                    numLeft = 0;
                    numRight = 0;
                }
            }
        }
        if (left.size() != right.size()) {
            return null;
        }
        int num = 0, ind = 0, i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                sb.append(c);
                i ++;
            }
            else if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
                i ++;
            }
            else if (c == '[') {
                String temp = expressionExpand(s.substring(left.get(ind) + 1, right.get(ind)));
                for (int j = 0; j < num; j ++) {
                    sb.append(temp);
                }
                num = 0;
                i = right.get(ind) + 1;
                ind ++;
            }
        }
        return sb.toString();
    }
}

//stack
public class Solution {
    /**
     * @param s  an expression includes numbers, letters and brackets
     * @return a string
     */
    public String expressionExpand(String s) {
        // Write your code here
        if(s == null){
            return null;
        }
        if(s.length() == 0){
            return "";
        }
        Stack<Integer> nums = new Stack<>();
        Stack<String> strs = new Stack<>();
        int tempNum = 0;
        StringBuilder tempSb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                tempNum = tempNum * 10 + ((int)s.charAt(i) - (int)'0');
                if(tempSb.length() != 0){
                    strs.push(tempSb.toString());
                    tempSb.setLength(0);
                }
            }
            else if(s.charAt(i) == '['){
                nums.push(tempNum);
                tempNum = 0;
                strs.push(String.valueOf(s.charAt(i)));
            }
            else if(Character.isLetter(s.charAt(i))){
                tempSb.append(s.charAt(i));
            }
            else if(s.charAt(i) == ']'){
                if(tempSb.length() != 0){
                    strs.push(tempSb.toString());
                    tempSb.setLength(0);
                }
                String tempStr = popStr(strs);
                //strs.pop(); //pop "["
                if(!nums.isEmpty()){
                    int times = nums.pop();
                    for(int j = 0; j < times; j++){
                        strs.push(tempStr);
                    }
                }
                else{
                    strs.push(tempStr);
                }
            }
            if(i == s.length() - 1 && s.charAt(i) != ']'){
                strs.push(tempSb.toString());
                tempSb.setLength(0);
            }
        }
        int times = 1;
        if(!nums.isEmpty()){
            times = nums.pop();
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < times; i ++){
            sb.append(popStr(strs));
        }
        return sb.toString();
    }
    
    private String popStr(Stack<String> strs){
        String temp;
        Stack<String> tempStack = new Stack<>();
        while(!strs.isEmpty() && !(temp = strs.pop()).equals("[")){ //"[" pops here
            tempStack.push(temp);
        }
        StringBuilder sb = new StringBuilder();
        while(!tempStack.isEmpty()){
            sb.append(tempStack.pop());
        }
        return sb.toString();
    }
}