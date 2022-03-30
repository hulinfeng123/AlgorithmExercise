package QueueAndStack;

import java.util.Stack;

/**
 * @author Hu Linfeng
 * @version 1.0
 * @description 括号匹配问题，使用栈的特殊结构
 */
public class Question4 {
    /*
        思想：总共分为三种情况，1：左右括号不匹配 2：左括号多了 3：右括号多了
        现在Java中一般不再使用Stack，取而代之使用双端队列Deque取代，双端队列中的pop()和peek()和push(e)方法一一对应Stack中的

        Dequeue既可以用作堆栈也可以用作队列的数据结构
        用作堆栈使用方法：push,pop,peek
        用作队列使用方法：offer,poll,peek

        可参考csdn：https://blog.csdn.net/xiongmao_dada/article/details/50019165
     */

    public static boolean matchString(String s){
        Stack<Character> str = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(')str.push(')');
            else if(s.charAt(i) == '[')str.push(']');
            else if(s.charAt(i) == '{')str.push('}');
            else if(str.isEmpty()||str.peek()!=s.charAt(i))return false;
            else str.pop();
        }
        if(!str.isEmpty())
        return false;
        else
             return true;
    }

    public static void main(String[] args) {
        Boolean judge = matchString("((({{{[}}})))");
        System.out.println(judge);
    }
}

