// ---Question---
// Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.

 

// Example 1:


// Input: l1 = [1,2,4], l2 = [1,3,4]
// Output: [1,1,2,3,4,4]
// Example 2:

// Input: l1 = [], l2 = []
// Output: []
// Example 3:

// Input: l1 = [], l2 = [0]
// Output: [0]
  
  
// ---Answer--- 
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
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 已經是兩個排序好的 linked lists
        // 每一個節點會存放資料和指向下一個node的連結之記憶體位址 (pointer)，
        // 最後一個節點的指標則為空值 (NIL)
        // 如果移動了一些節點的順序，留意他們的 next 是否被妥善處理，該被清空的請給定NIL
        // 若 l1 全空，答案就是 l2，後面都不需要繼續排了
        // 若 l1 小於 l2 ，那麼 l1 就要當頭
        // 接著 l1.next 跟 l2 比大小，小的就會是下一個節點
        // 依序往下比較，若都其中之一個都結束了，就將剩下的全部擺入，便完成了
        // 遞回的方式去寫的，連續的函式呼叫的效率，相對於在迴圈中執行來說會較差
        // worst case 是 O(N1+N2)，best case 是 O(min(N1, N2))
        
        
        if (l1 == null) {
            System.out.println("1"); 
            return l2;
        }
       
        
        if (l2 == null) {
              System.out.println("2"); 
            return l1;
        }
      
       
        
        if (l1.val < l2.val){
            System.out.println("3.1");
            l1.next = mergeTwoLists(l1.next, l2);
            System.out.println("3.2");            
            return l1;
            
        }else{
            System.out.println("4.1"); 
            l2.next = mergeTwoLists(l1, l2.next);
            System.out.println("4.2"); 
            return l2;
        }
                
        
    }
}

//input
// [1,3]
// [2,4]

// stdout 遞迴
// 3.1
// 4.1
// 3.1
// 1
// 3.2
// 4.2
// 3.2

// output
// [1,2,3,4]
