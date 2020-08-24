/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
import java.util.*;
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0){
            return null;
        }
       PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length,new ListComparator());
    
       ListNode dummy = new ListNode(0);
       ListNode tail = dummy;

       for(ListNode node : lists){
           if(node!=null){
               queue.add(node);
           }
       }

       while(!queue.isEmpty()){
           tail.next = queue.poll();
           tail = tail.next;

           if(tail.next!=null){
               queue.add(tail.next);
           }
       }

       return dummy.next;

    }

    class ListComparator implements Comparator<ListNode>{

        //Override compare method:
        public int compare(ListNode n1,ListNode n2){
            if(n1.val<n2.val){
                return -1;
            }
            else if(n1.val==n2.val){
                return 0;
            }
            else{
                return 1;
            }
        }

    }
}
// @lc code=end

