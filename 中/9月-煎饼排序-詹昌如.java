给定数组 A，我们可以对其进行煎饼翻转：我们选择一些正整数 k <= A.length，然后反转 A 的前 k 个元素的顺序。我们要执行零次或多次煎饼翻转（按顺序一次接一次地进行）以完成对数组 A 的排序。

返回能使 A 排序的煎饼翻转操作所对应的 k 值序列。任何将数组排序且翻转次数在 10 * A.length 范围内的有效答案都将被判断为正确。

 

/*示例 1：

输入：[3,2,4,1]
输出：[4,2,4,3]
解释：
我们执行 4 次煎饼翻转，k 值分别为 4，2，4，和 3。
初始状态 A = [3, 2, 4, 1]
第一次翻转后 (k=4): A = [1, 4, 2, 3]
第二次翻转后 (k=2): A = [4, 1, 2, 3]
第三次翻转后 (k=4): A = [3, 2, 1, 4]
第四次翻转后 (k=3): A = [1, 2, 3, 4]，此时已完成排序。 
示例 2：

输入：[1,2,3]
输出：[]
解释：
输入已经排序，因此不需要翻转任何内容。
请注意，其他可能的答案，如[3，3]，也将被接受。
*/

/*
*思路：先在给定数组中找到最大值的下标4，然后反转放在数组最前面，然后再按k=size反转一次，即把最大值放到
*放到数组最后，这样就可以确定一个数的位置，然后循环执行，
*按照示例：
*[3,2,4,1]最大值4，下标2 k=3,执行反转后[4,2,3,1] k=size=4 反转后[1,3,2,4] 
*然后找到最值3，下标1，k=2,反转[3,1,2,4],k=size=3 反转后[2,1,3,4]
*2已经放在最前面，k=size=2 反转[1,2,3,4] 
*输入：[3,2,4,1]
*输出：[3,4,2,3,2]
*/

class Solution {
	public List<Integer> pancakeSort(int[] A) {
		List<Integer> list = new ArrayList<Integer>();
		int size = A.length;
		int temp;

		for (int i = size; i > 1; i--) {
			temp = findMaxIndex(A, i);
			list.add(temp);
			list.add(i);
			// 确定最大值
			reverse(A, 1, temp);
			reverse(A, 1, i);
		}
		return list;
	}
	// 找最大值下标
	private int findMaxIndex(int[] A, int value) {
		for (int i = 0; i < A.length; i++) {
			if (A[i] == value) {
				return i + 1;
			}
		}
		return 0;
	}
	// 反转
	private void reverse(int[] arr, int s, int e) {
		s--;
		e--;
		while(s < e) {
			int temp = arr[e];
			arr[s] = arr[e];
			arr[e] = temp;
			s++;
			e--;
		}
	}
}