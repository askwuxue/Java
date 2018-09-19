//class Solution {
//    public boolean isValid(String s) {
//        ArrayStack<Character> stack = new ArrayStack<>();
//        for (int i = 0; i < s.length() ; i++) {
//            char c = s.charAt(i);
//            if (c == '(' || c == '{' || c == '[') {
//                stack.push(c);
//            } else {
//                if (stack.isEmpty()) {
//                    return false;
//                }
//                char topChar = stack.pop();
//                if (c == ')' && topChar != '(') {
//                    return false;
//                }
//                if (c == '}' && topChar != '{') {
//                    return false;
//                }
//                if (c == ']' && topChar != '[') {
//                    return false;
//                }
//            }
//        }
//        return stack.isEmpty();
//    }
//}

//public class Main {
//    public static void main (String[] args) {
//        System.out.println(new Solution().isValid("()[]{}"));
//        System.out.println(new Solution().isValid("({)}"));
//    }
//}

public class Main {
    public static void main (String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();

        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);

    }
}