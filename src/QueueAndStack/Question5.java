package QueueAndStack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Hu Linfeng
 * @version 1.0
 * @description 删除字符串中的相邻重复项
 */
public class Question5 {
    public static String deleteDuplicate(String str){
        //ArrayDeque<Character> array = new ArrayDeque();
        //Deque<Character> array = new LinkedList();
        Deque<Character> array = new ArrayDeque();
        //以上写法都可以，本质是要使用Deque代替作为堆栈使用，而ArrayDeque与LinkedList均是Deque接口的实现类
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(array.isEmpty()||c!= array.peek()) {
                array.push(c);
            }else{
                array.pop();
            }

        }
        String s = "";
        while(!array.isEmpty()) {
            s = array.pop()+s;
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(deleteDuplicate("aabccbecffca"));
    }
}
