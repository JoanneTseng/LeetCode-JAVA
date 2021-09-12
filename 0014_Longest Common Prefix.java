// ---Question---
// Write a function to find the longest common prefix string amongst an array of strings.

// If there is no common prefix, return an empty string "".

 

// Example 1:

// Input: strs = ["flower","flow","flight"]
// Output: "fl"
// Example 2:

// Input: strs = ["dog","racecar","car"]
// Output: ""
// Explanation: There is no common prefix among the input strings.
 

// Constraints:

// 1 <= strs.length <= 200
// 0 <= strs[i].length <= 200
// strs[i] consists of only lower-case English letters.
  
  
// ---Answer---

class Solution {
    // 首先要確認有沒有排序
    // 從第一個字開始往下比對一次，如果相同繼續往下，如果不同則停下來並將結果輸出
    // 拿第一起來，跟後面幾個比對，如果不符合的時候，刪掉最後一個單字，再繼續做一樣的事情，如果都一樣變輸出，不一樣就輸出空字串
    
    // 傳入內容為字串的陣列
    public String longestCommonPrefix(String[] strs) {
        // 空的字串且陣列長度為0 回傳空字串
        if (strs == null || strs.length == 0 ) return "";
        
        //取得陣列第1個
        String pre = strs[0]; 
        
        //初始化 i // i:陣列中的第幾個
        int i = 1; 
        
        //總共有3個 i=1,2
        while(i < strs.length){ 
            
            System.out.println("i: " + i);
            
            // 第2個與第1個相不相同的比對,要剛好在 0 這個位置，也就是第一個單字開始就相符
            // 所以不論這個值是>0(表示出現在中間)或<0(根本沒出現)，都代表pre需要被調整。
            while(strs[i].indexOf(pre) != 0){
                System.out.println("index: " + strs[i].indexOf(pre)); 
                
                //pre字串刪掉最後一位
                pre = pre.substring(0, pre.length() - 1);
                System.out.println("pre: " + pre); 
            }
                                   
            i++;
        }
        return pre;
    }
}


// 「如果不能用indexOf的話你會怎麼做？」
// (可使用String.toCharArray()轉成陣列後再操作)

// 「如果這組陣列被預期長短差異很大呢？」
// (先掃過一遍陣列，拿最短的當pre)

