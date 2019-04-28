/*
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
*/

public class FindTwoNums {

	public static int[] fun(int[] arrs, int target) {
	int[] arr = new int[2];
	int firIndex = 0;
	int secIndex = 0;
	// 两层遍历找到i，j为下标的和为target
	for(int i = 0; i < arrs.length - 1; i++) {
		firIndex = i;// 标记i
		for(int j = i + 1; j < arrs.length; j++) {
			secIndex = j;// 标记j
			if(target == arrs[i] + arrs[j]) {
				arr[0] = firIndex;
				arr[1] = secIndex;
			}
		}
	}
	return arr;
}

	public static void main(String[] args) {
		int[] nums = {2,7,11,15};
		int target = 9;
		int[] result = fun(nums, target);
		System.out.println("["+result[0] + "," + result[1] + "]");
	}
}
