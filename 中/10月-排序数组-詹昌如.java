/*
给定一个整数数组 nums，将该数组升序排列。 

示例 1：

输入：[5,2,3,1]
输出：[1,2,3,5]
示例 2：

输入：[5,1,1,2,0,0]
输出：[0,0,1,1,2,5]
*/
/*
给数组排序，排序算法有很多种，需要选择其中一种解此题，选择快速快速法
思路：从数组中找一个元素作为基准
重新排序数列，比基准数小的放一起，比基准大的放一边，然后对两边数组再递归排序
*/

class quickSort(int[] arr, int low, int high) {
	if (arr.length <= 0) {
		return;
	}
	if (low >= high) {
		return;
	}
	int left = low;
	int right = high;
	int temp = arr[left];
	while(left < high) {
		while(left < right && arr[right] >= temp) {
			right--;
		}
		arr[left] = arr[]right;
		while(left < right && arr[left] <= temp) {
			left++;
		}
		arr[right] = arr[left];
	}
	arr[left] = temp;
	quickSort(arr, low, left - 1);
	quickSort(arr, left + 1, high);
}