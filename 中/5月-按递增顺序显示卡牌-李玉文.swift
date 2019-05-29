
/**
 思路 1、排序
 2、按如下规律执行
 [2,3,5,7,11,13,17]
 [2,13,3,11,5,17,7]
 如上所示，有以下规则
 奇数位置从小到大排列
 偶数位置为 奇数排完之后，下一个顺序数（此处为11）的位置为 顺序数组中的index - 1（顺序数组索引为5，结果数组中索引为4）
 同理继续往下插入
 */
class Solution {
    func deckRevealedIncreasing(_ deck: [Int]) -> [Int] {
        var current = deck.sorted()
        var target = Array.init(repeating: -1, count: deck.count)
        var flag = false;
        
        var indexI = 0
        var indexJ = 0
        for _ in deck {
            flag = false;
            while (true) {
                if target[indexJ] == -1 && (indexI == 0 || flag == true)  {
                    target[indexJ] = current[indexI];
                    break;
                }
                else if target[indexJ] == -1 && flag == false  {
                    flag = true;
                }
                indexJ = indexJ + 1
                if indexJ == deck.count{
                    indexJ = 0;
                }
                
            }
            indexI = indexI + 1
        }
        
        return target
    }
}
