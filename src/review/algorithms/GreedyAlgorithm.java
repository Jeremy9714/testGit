package review.algorithms;

import java.util.HashMap;
import java.util.HashSet;

public class GreedyAlgorithm {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		HashMap<String,HashSet<String>> boardcasts = new HashMap<>();
		HashSet<String> hashSet1 = new HashSet<String>();
		hashSet1.add("北京");
		hashSet1.add("上海");
		hashSet1.add("天津");
		HashSet<String> hashSet2 = new HashSet<String>();
		hashSet2.add("广州");
		hashSet2.add("北京");
		hashSet2.add("深圳");
		HashSet<String> hashSet3 = new HashSet<String>();
		hashSet3.add("成都");
		hashSet3.add("上海");
		hashSet3.add("杭州");
		HashSet<String> hashSet4 = new HashSet<String>();
		hashSet4.add("上海");
		hashSet4.add("天津");
		HashSet<String> hashSet5 = new HashSet<String>();
		hashSet5.add("杭州");
		hashSet5.add("大连");
		boardcasts.put("K1", hashSet1);
		boardcasts.put("K2", hashSet2);
		boardcasts.put("K3", hashSet3);
		boardcasts.put("K4", hashSet4);
		boardcasts.put("K5", hashSet5);	
		HashSet<String> hashSet = new HashSet<>();
		hashSet.add("北京");
		hashSet.add("上海");
		hashSet.add("广州");
		hashSet.add("深圳");
		hashSet.add("杭州");
		hashSet.add("成都");
		hashSet.add("天津");
		hashSet.add("大连");
		HashSet<String> res = greedyAlgorithm(boardcasts,hashSet);
		System.out.println(res);
	}
	public static HashSet<String> greedyAlgorithm(HashMap<String,HashSet<String>> hashMap, HashSet<String> hashSet) {
		HashSet<String> res = new HashSet<>();
		HashSet<String> allAddress = hashSet;
		while(!hashSet.isEmpty()) {
			String maxKey=null;
			int maxSize=0;
			for(String key:hashMap.keySet()) {
				HashSet<String> temp = new HashSet<>();
				temp.addAll(hashMap.get(key));
				temp.retainAll(allAddress);
				//maxSize = temp.size();
				if(temp.size()>0&&(maxKey==null|temp.size()>maxSize)) {
					maxKey=key;
					maxSize = temp.size();
				}
			}
			if(maxKey!=null){
				res.add(maxKey);
				allAddress.removeAll(hashMap.get(maxKey));
			}
		}
		return res;
	}
}
