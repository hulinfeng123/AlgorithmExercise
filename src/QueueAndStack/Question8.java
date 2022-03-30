package QueueAndStack;

import java.util.*;

/**
 * @author Hu Linfeng
 * @version 1.0
 * @description 选出频率前k高的数值
 */
public class Question8 {

    /*
        注：优先级队列中PriorityQueue()，在查看源码后发现，这个类是一个有参构造类，且参数为比较器
        若比较器的值大于0则返回的优先队列是由大到小，反之由小到大
        优先级队列的本质仍然是堆，是不过是从尾部插入，头部取出
     */

    public static int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        // 根据map的value值正序排，相当于一个小顶堆
        PriorityQueue<Map.Entry<Integer, Integer>> queue =
                new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        for (Map.Entry<Integer, Integer> entry : entries) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            result[i] = queue.poll().getKey();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1,3,1,2,2,2},2)));
    }
}
