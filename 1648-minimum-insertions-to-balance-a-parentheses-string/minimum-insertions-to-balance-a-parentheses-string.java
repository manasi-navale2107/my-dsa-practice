import java.util.Stack;

class Solution {
    public int minInsertions(String s) {

        Stack<Character> stack = new Stack<>();
        int insert = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(') {
                stack.push(ch);
            } 
            else { // ch == ')'

                // check if this is part of "))"
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i++; // skip next ')'
                } else {
                    // only one ')' so insert one more ')'
                    insert++;
                }

                if (!stack.isEmpty()) {
                    stack.pop(); // match with '('
                } else {
                    // no matching '(' so insert one
                    insert++;
                }
            }
        }

        // remaining '(' each need "))"
        insert += stack.size() * 2;

        return insert;
    }
}