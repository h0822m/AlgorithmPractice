二叉搜索树中的插入操作

/*
给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 保证原始二叉搜索树中不存在新值。

注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。

例如, 

给定二叉搜索树:

    4
   / \
  2   7
 / \
1   3
和 插入的值: 5 你可以返回这个二叉搜索树:

     4
   /   \
  2     7
 / \   /
1   3 5
或者这个树也是有效的:

     5
   /   \
  2     7
 / \   
1   3
     \
      4

*/

/*
*分析：二叉搜索树：若它的左子树不空，则左子树上所有节点的值均小于它的根节点的值，若它的右子树不空，
*则右子树上所有节点的值均大于它的所有根节点的值，并且左右子树也为二叉搜索树
*
*思路：采用递归实现：
*1.当root < val,将val添加到root的右子树，并使root的右孩子为val节点的右子树
*2.当root > val,将val添加到root的左子树，并使root的左孩子为val节点的左子树
*3.递归结束条件：root为空，直接返回一个新的节点，值为val
*/

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

public class Solution {

  public TreeNode insertIntoBST(TreeNode root, int val) {
    
    if (root == null) {// root为空
      return new TreeNode(val);
    }

    if (root.val < val) {// root < val
      root.right = insertIntoBST(root.right, val);
    } else if (root.val > val) {// root > val
      root.left = insertIntoBST(root.left, val);
    }
  }
  return root;
}
