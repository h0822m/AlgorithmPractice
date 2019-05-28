public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length);
}
    
private TreeNode construct(int[] nums, int start, int end){
        if (start == end){
            return null;
        }

        int maxNumPos = findNumMaxPos(nums, start, end);
        TreeNode root = new TreeNode(nums[maxNumPos]);
        root.left = construct(nums, start, maxNumPos);
        root.right = construct(nums, maxNumPos + 1, end);

        return root;
}
    
private int findNumMaxPos(int[] nums, int start, int end){
        int maxNumPos = start;
        for (int i = start; i < end; i++){
            if (nums[i] > nums[maxNumPos]){
                maxNumPos = i;
            }
        }
        return maxNumPos;
}

