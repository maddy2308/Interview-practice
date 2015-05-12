package epic;

import java.util.*;

public class InfixToPostfix {

    static Map<String, Integer> precedenceMap = new HashMap<String, Integer>();

    static {
        precedenceMap.put("+", 1);
        precedenceMap.put("-", 1);
        precedenceMap.put("*", 2);
        precedenceMap.put("/", 2);
        precedenceMap.put("^", 3);
    }

    public static void main(String[] args) {
        convertToPostfix("3*5+4^5^6");
    }

    private static void convertToPostfix(String infix) {
        List<String> expresssion = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        for (char ch : infix.toCharArray()) {
            if ((ch >= '0') && (ch <= '9')) {
                sb.append(ch);
            } else {
                if (sb.length() > 0) {
                    expresssion.add(sb.toString());
                    sb = new StringBuilder();
                }
                expresssion.add(ch + "");
            }
        }
        if (sb.length() > 0) {
            expresssion.add(sb.toString());
        }
        convert(expresssion);
    }

    private static void convert(List<String> expression) {
        Stack<String> st = new Stack<String>();
        StringBuilder sb = new StringBuilder();
        for (String s : expression) {
            if (precedenceMap.containsKey(s)) {
                if (!st.isEmpty()) {
                    String peek = st.peek();
                    if (!(s.equals(peek) && s.equals("^"))) {
                        while (precedenceMap.get(s) <= precedenceMap.get(peek)) {
                            sb.append(st.pop() + " ");
                            if (!st.isEmpty())
                                peek = st.peek();
                            else break;
                        }
                    }
                }
                st.push(s);
            } else {
                sb.append(s + " ");
            }
        }
        while (!st.isEmpty()) {
            sb.append(st.pop() + " ");
        }
        System.out.println(sb.toString());
    }
}
