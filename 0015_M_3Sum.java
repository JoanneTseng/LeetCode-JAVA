// ---Question---
// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

// Notice that the solution set must not contain duplicate triplets.

 

// Example 1:

// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]
// Example 2:

// Input: nums = []
// Output: []
// Example 3:

// Input: nums = [0]
// Output: []
 

// Constraints:

// 0 <= nums.length <= 3000
// -105 <= nums[i] <= 105
  
  
// ---Answer--- 

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //先排個順序，要不然會成為暴力法 O(N3)
        //Two Pointer
        //一般排序的複雜度是O(NlogN)，但是這邊為第一個定錨指標O(N)+第二個掃描用的指標O(Ｎ的平方)＝O(N的平方)
       
        
        //用三個指標來做，分別為i/j/k
        //最終我們要將i= 0~len(nums)-3 跑完一次 i=-4
        //j=-1  k=2 然後j往右增大  k 往左減少
        //j+k 相加結果來決定要增大還是減小
        //而且再曾向右還是向左的同時，要排除重複的數值
        
        //為了將 nums 這個陣列裡面的值排序 [-4,-1,-1,0,1,2]
        System.out.println("nums: " + nums); 
        Arrays.sort(nums); 
        System.out.println("nums sort: " + nums); 
        
        //宣告為了回傳陣列結果
        List<List<Integer>> result = new LinkedList<>();
        
        //i = 0~3
        for(int i = 0; i < nums.length -2; i++){
            
            // 假設下一個 i 與 現在的 i 不相同的時候
            if (i == 0 || (i > 0 && nums[i] != nums[i -1])){
            
            // target 用來計算還剩下多少要跟 i 相加起來才會是 0
            int j = i + 1, k = nums.length - 1, target = 0 - nums[i];
            System.out.println("i1: " + i); 
            System.out.println("j1: " + j);  
            System.out.println("k1: " + k);  
            System.out.println("target: " + target);      
                
            while (j < k) {
                
                // 符合 target            
                if (nums[j] + nums[k] == target){
                    
                     //使用 Arrays.asList 可以將一串元素塞成 ArrayList
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    System.out.println("result: " + result);  
                    
                    //若往左或是往右的數值都一樣的話，代表其相加也符合target，所以也要再加入list
                    while (j < k && nums[j] == nums[j + 1]) 
                    {j++;
                    System.out.println("i2: " + i); 
                    System.out.println("j2: " + j);  
                    System.out.println("k2: " + k);
                    }
                    while (j < k && nums[k] == nums[k - 1]) 
                    {k--;
                    System.out.println("i3: " + i); 
                    System.out.println("j3: " + j);  
                    System.out.println("k3: " + k);
                    }                   
                    //無論如何 j 和 k 都要繼續跑看看
                    j++; k--; 
                    System.out.println("i4: " + i); 
                    System.out.println("j4: " + j);  
                    System.out.println("k4: " + k);                        
                    
                }
                // 如果相加發現比目標還要小的話，代表 j 要變大
                else if (nums[j] + nums[k] < target) {
                    ++j;
                    System.out.println("i5: " + i); 
                    System.out.println("j5: " + j);  
                    System.out.println("k5: " + k);
                }
                //比目標還要大的話，就是 k 要變小
                else {--k; 
                 System.out.println("k6: " + k);}
            }
          } 
        }
        return result;   
    }
     
}

//Notes
//i++表示先給值後，再自增
//++1表示先自增後，再給值

//Q: 如果可以改變input/output的變數形態的話，改動什麼？
//A: 改output，因為輸出應該固定會是3元組的組合(長度必然是3)，可以使用List<int[]>
