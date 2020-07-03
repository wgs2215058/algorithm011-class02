class TheSumOfTwoNumbers {
   public int[] twoSum(int[] nums, int target) {
    //    //1遍哈希
    //     Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    //     for (int i = 0;i<nums.length;i++) {
    //         if (map.containsKey(target-nums[i])) {
    //             return new int[]{map.get(target-nums[i]),i};
    //         }
    //         map.put(nums[i],i);
    //     }
    //     throw new IllegalArgumentException("No two sum solution");

        // //2遍哈希
        // Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        // for (int i=0; i<nums.length; i++) {
        //     map.put(nums[i],i);
        // }
        // for (int i=0; i<nums.length; i++) {
        //     int complement = target - nums[i];
        //     if (map.containsKey(complement) && map.get(complement) != i) {
        //         return new int[] { i, map.get(complement) };
        //     }
        // }
        // throw new IllegalArgumentException("No two sum solution");
        
    //3暴力法
        for (int i=0; i<nums.length; i++) {
            for (int j =i+1; j<nums.length;j++) {
                if(nums[j] == target-nums[i]){
                     return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    
}