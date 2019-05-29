public int[] deckRevealedIncreasing(int[] deck) {
	
		//先按递增顺序排序
        Arrays.sort(deck);
        LinkedList<Integer> list= new LinkedList<>();
        for(int i=deck.length-1;i>=0;i--){
                if(list.size()==0) {
                    list.add(deck[i]);
                    continue;
                }
				//移除链尾
                Integer last=list.pollLast();
				//放于链头
                list.addFirst(last);
                list.addFirst(deck[i]);

        }

        for(int i=0;i<deck.length;i++){
            deck[i]=list.get(i);
        }
        return deck;
}

用例：
输入：[17,13,11,2,3,5,7]
输出：[2,13,3,11,5,17,7]

输入：[15,6,9,2,18,37,23,12,20]
输出：[2,37,6,18,9,23,12,20,15]

输入：[5,6,19,23,18,12,10]
输出：[5,19,6,18,10,23,12]