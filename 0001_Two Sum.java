// ---Question---
// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

// You may assume that each input would have exactly one solution, and you may not use the same element twice.

// You can return the answer in any order.

 

// Example 1:

// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Output: Because nums[0] + nums[1] == 9, we return [0, 1].
// Example 2:

// Input: nums = [3,2,4], target = 6
// Output: [1,2]
// Example 3:

// Input: nums = [3,3], target = 6
// Output: [0,1]
 

// Constraints:

// 2 <= nums.length <= 104
// -109 <= nums[i] <= 109
// -109 <= target <= 109
  
  
// ---Answer---

//每個數只要查一次就知道結果，Hashmap 每個數只需要花 O(1) 作搜尋，複雜度就會降到 O(N)
//這裡做法很不一樣的是將陣列的index當作map的value，但是將陣列的value 當作map的 key
class Solution {
    //傳入參數前面是 nums 陣列，後面是目標的數值結果
    public int[] twoSum(int[] nums, int target) { 
        
        //定義一個暫存用，專門塞不對結果的 map
        //(num, index)  數值當作 KEY 來使用，因為要回傳 index 值
        Map<Integer, Integer> map = new HashMap<>(); 
                
        for (int i = 0; i < nums.length; i++){ 
            //用減法將目標結果一個一個跑 
            int gap = target - nums[i]; 
            
            //containsKey(Object key)
            System.out.println("containKey: " + map.containsKey(gap)); 
            
            //使用 map 函數中的containsKey function，找看看有沒有跟 Gap 一樣的 KEY 
            if(map.containsKey(gap)){ 
                
                //value get(Object key)
                System.out.println("get: " + map.get(gap));
                
                //這邊依然是輸出錯誤結果的 map
                System.out.println("map inside: " + map); 
                
                //新建立一個匿名的正整數數值陣列，如果有符合的，作為將結果回傳，使用 map 函數中的 get function，可以獲得 gap 的值，以及回傳他陣列第幾個數值  
                return new int[] { map.get(gap), i };  
                
            }
            
            // put(K key, V value) 
            //如果沒有遇到符合的，將結果放如前面定義好環傳用的 map 
            map.put( nums[i], i); 
            
            System.out.println("map: " + map);
        }
        
        throw new IllegalArgumentException("No Answer");
        
    }
}
