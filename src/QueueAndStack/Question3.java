package QueueAndStack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Hu Linfeng
 * @version 1.0
 * @description 用队列实现栈的操作：push,pop,empty,top
 */
public class Question3 {

    /*
        思路：首先用两个队列实现的话与问题2不同，因为队列永远是先进先出
        所以为了做到先进后出，需要用以一个备份队列进行数据备份
     */
    public static class QueueToStack{
        Queue<Integer> queue1;
        Queue<Integer> queue2;

        public QueueToStack(){
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        public void push(int x) {
            queue2.offer(x); // 先放在辅助队列中
            while (!queue1.isEmpty()){
                queue2.offer(queue1.poll());
            }
            Queue<Integer> queueTemp;
            queueTemp = queue1;
            queue1 = queue2;
            queue2 = queueTemp; // 最后交换queue1和queue2，将元素都放到queue1中
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return queue1.poll(); // 因为queue1中的元素和栈中的保持一致，所以这个和下面两个的操作只看queue1即可
        }

        /** Get the top element. */
        public int top() {
            return queue1.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue1.isEmpty();
        }
    }

    public static void main(String[] args) {
        QueueToStack test = new QueueToStack();
        test.push(1);
        test.push(2);
        test.push(3);
        System.out.println(test.pop());
        System.out.println(test.top());


    }
}
