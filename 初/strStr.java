/*
实现 strStr() 函数。

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回 -1。

示例 1:

输入: haystack = "hello", needle = "ll"
输出: 2
示例 2:

输入: haystack = "aaaaa", needle = "bba"
输出: -1
说明:

当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
*/

public class strStr {

	// 使用java indexof()方法
	public static int Solution(String haystack, String needle) {
		if(haystack != null && needle != null && haystack != "" && needle != "" && (haystack.length() >= needle.length())) {
			int i = haystack.indexOf(needle);
			return i;
		} else {
			return 0;
		}
	}
	
	public static void main(String[] args) {
		//String haystack = "aaaaa";
		//String needle = "bba";
		//Solution = -1
		String haystack = "hello";
		String needle = "ll";
		// Solution = 2

		int s = Solution(haystack, needle);
		System.out.println("Solution = " + s);
	}
}