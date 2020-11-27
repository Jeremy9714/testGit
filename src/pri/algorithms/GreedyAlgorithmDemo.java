package pri.algorithms;

import java.util.HashMap;
import java.util.HashSet;

public class GreedyAlgorithmDemo {

	public static void main(String[] args) {
		// 存放所有的电台
		HashMap<String, HashSet<String>> broadcasts = new HashMap<String, HashSet<String>>();
		// 存放每个电台覆盖的地区
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
		broadcasts.put("K1", hashSet1);
		broadcasts.put("K2", hashSet2);
		broadcasts.put("K3", hashSet3);
		broadcasts.put("K4", hashSet4);
		broadcasts.put("K5", hashSet5);		
		HashSet<String> selects = GreedyAlgorithm(broadcasts);
		System.out.println(selects);
	}

	public static HashSet<String> GreedyAlgorithm(HashMap<String, HashSet<String>> broadcasts) {
		// 存放所有的地区
		HashSet<String> allAddress = new HashSet<String>();
		allAddress.add("北京");
		allAddress.add("上海");
		allAddress.add("广州");
		allAddress.add("深圳");
		allAddress.add("杭州");
		allAddress.add("成都");
		allAddress.add("天津");
		allAddress.add("大连");
		// 存放结果
		HashSet<String> selects = new HashSet<>();
		// 一轮遍历中,指向覆盖地区最多的电台的指针
		String maxKey;
		// 存储当前电台覆盖的地区
		HashSet<String> tempAddress = new HashSet<>();
		while (allAddress.size() != 0) {
			// 指针还原
			maxKey = null;
			for (String key : broadcasts.keySet()) {
				// 清空地区
				tempAddress.clear();
				// 当前电台覆盖的区域
				HashSet<String> areas = broadcasts.get(key);
				// 将当前电台覆盖的地区添加到集合中
				tempAddress.addAll(areas);
				// 得到该集合与全部地区集合的交集
				tempAddress.retainAll(allAddress);
				// 若该电台覆盖地区数不为零并且最大值指针为空或最大值指针指向的电台的覆盖地区数小于当前电台覆盖的地区数
				if (tempAddress.size() > 0 && (maxKey == null || broadcasts.get(maxKey).size() < tempAddress.size())) {
					// 更新指针
					maxKey = key;
				}
			}
			if (maxKey != null) {
				selects.add(maxKey);
				// 将覆盖的地区去除掉
				allAddress.removeAll(broadcasts.get(maxKey));

			}
		}
		return selects;
	}
}
