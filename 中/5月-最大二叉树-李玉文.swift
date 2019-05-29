
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public var val: Int
 *     public var left: TreeNode?
 *     public var right: TreeNode?
 *     public init(_ val: Int) {
 *         self.val = val
 *         self.left = nil
 *         self.right = nil
 *     }
 * }
 */
// 解题思路
// 1 找最大值 2 递归创建子节点
class Solution {
    func getMax(nums: [Int]) -> (Int,Int) {
        var max = -1
        var maxIndex = -1
        for (index, value) in nums.enumerated() {
            if value > max {
                max = value
                maxIndex = index
                continue
            }
        }
        return (max, maxIndex)
    }
    
    func constructMaximumBinaryTree(_ nums: [Int]) -> TreeNode? {
        if nums.count == 0 {
            return nil
        }
        let result = getMax(nums: nums)
        let max = result.0
        let maxIndex = result.1
        
        
        let leftArray = maxIndex > 0 ? Array(nums.prefix(maxIndex)) : []
        let rightArray = maxIndex + 1 < nums.count  ? Array(nums.suffix(from: maxIndex + 1)) : []
        
        let rootNode = TreeNode(max)
        rootNode.left = self.constructMaximumBinaryTree(leftArray)
        rootNode.right = self.constructMaximumBinaryTree(rightArray)
        return rootNode
    }
}
