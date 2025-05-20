import java.util.HashMap;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
        int[] result = solution.twoSum(nums, 17);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+" ");
        }
    }


    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int result = target - nums[i];
            if(map.containsKey(result)){
                return new int[]{map.get(result),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
}
