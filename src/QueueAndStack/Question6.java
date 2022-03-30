package QueueAndStack;

import java.util.Deque;
import java.util.LinkedList;

import static java.lang.Character.getType;

/**
 * @author Hu Linfeng
 * @version 1.0
 * @description 逆波兰表达式
 */
public class Question6 {
    public static int calculate(String[] expression){
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < expression.length; i++){

            if(expression[i]=="+"){
                stack.push(stack.pop() + stack.pop());
            }else if(expression[i]=="-"){
                stack.push(-stack.pop() + stack.pop());
            }else if(expression[i]=="*"){
                stack.push(stack.pop() * stack.pop());
            }else if(expression[i]=="/"){
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                stack.push(temp2/temp1);
            }else{
                stack.push(Integer.parseInt(expression[i]));

            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(calculate(new String[]{"12","3","/","5","+","1","-"}));
        System.out.println(Integer.valueOf("42342").getClass());
        System.out.println((Integer.parseInt("553453")));

    }
}
