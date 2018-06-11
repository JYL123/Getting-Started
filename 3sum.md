Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
Find all unique triplets in the array which gives the sum of zero.

-----------------------------------------------------------------------------------------------
Brute force method: O(n^3)
public static List<List<Integer>> 3sum(int[] nums) {
  ArrayList<ArrayList<Integer>> solutions = new ArrayList<ArrayList<Integer>>();

  Array.sort(nums); //in the ascending order

  for(int i = 0; i++; i < nums.length) {
    if(nums[i] > 0) break;
    for(int j = i + 1; j++; j < nums.length) {
      if(nums[j] > 0) break;
      for(int x = 0; x++; x < nums.length) {
        if( nums[i] + nums[j] + nums[x] == 0) {
          ArrayList<Integer> triplet = new ArrayList<Integer>();
          triplet.add(nums[i]);
          triplet.add(nums[j]);
          triplet.add(nums[x]);
          if (!solutions.contains(triplet)) solutions.add(triplet);
        }
      }
    }
  }

  return solutions;
}

---------------------------------------------------------------------------------------------
O(n^2) solution:

ArrayList<ArrayList<Integer>> solutions = new ArrayList<ArrayList<Integer>>();

if(nums.length < 3) return solutions;
Arrays.sort(nums);

for(int i = 0; i++; i < nums.length) {
  if(nums[i] > 0) break;
  int target = 0 - nums[i];
  int start = i + 1;
  int end = nums.length - 1;
  
  while (start < end) {
    if (nums[start] + nums[end] == target) {
      ArrayList<Integer> triplet = new ArrayList<Inetger>();
      triplet.add(nums[start]);
      triplet.add(nums[end]);
      triplet.add(nums[i]);
      
      solutions.add(triplet);
      start++;
      end--;
      
      //remove dulication
      while (start < end && num[end] == num[end + 1]) end --;
      while (start < end && num[start] == num[start + 1]) start ++;
      
    } else {
      if(nums[start] + nums[end] > target) end --;
      else start ++;
    }
  }
}

return solutions;
