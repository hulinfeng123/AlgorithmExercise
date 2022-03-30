package QueueAndStack;

import java.util.Stack;

/**
 * @author Hu Linfeng
 * @version 1.0
 * @description 用栈的操作实现队列的操作push,pop,peek,empty
 */
public class Question2 {
    //pop()方法用于提取并返回顶端的元素
    //peek()方法用于返回顶端元素

    /*
        思路：仅用一个栈无法实现队列的先进先出，
        外加一个栈可实现顺序倒置
     */
    public static class StackToQueue{

        Stack<Integer> stackIn;
        Stack<Integer> stackOut;

        public StackToQueue(){
            stackIn = new Stack<>();
            stackOut = new Stack<>();
        }

        public void OutIsEmpty(){
            if(!stackOut.isEmpty())return;
            //如果出栈为不为空直接返回
            //如果出栈为空，把入栈的元素全部迭代到出栈
            while(!stackIn.isEmpty())stackOut.push(stackIn.pop());
        }

        public void push(int x){
            stackIn.push(x);
        }

        public void pop() {
            OutIsEmpty();
            System.out.println(stackOut.pop());
        }

        public void peek(){
            OutIsEmpty();
            System.out.println(stackOut.peek());
        }

        public boolean empty(){
            if(stackOut.isEmpty()&&stackIn.isEmpty())return true;
            else return false;
        }

        @Override
        public String toString() {
            return "StackToQueue{" +
                    "stackIn=" + stackIn +
                    ", stackOut=" + stackOut +
                    '}';
        }
    }

    public static void main(String[] args) {
        StackToQueue test = new StackToQueue();
        test.push(1);
        test.push(2);
        test.push(3);
        test.pop();
        test.peek();

    }
}
