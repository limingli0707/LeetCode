package WordLadder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {
	
	public static void main(String[] args) {
		HashSet<String> dict = new HashSet<String>();
		String[] strDict = {"hot","dot","dog","lot","log"};
		for (String s : strDict) {
			dict.add(s);
		}
		String start = "hit";
		String end = "cog";
		Solution solution = new Solution();
		System.out.println(solution.ladderLength(start, end, dict));
	}
	
	public int ladderLength(String start, String end, HashSet<String> dict) {
	
		//create graph
	   HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();
	   
	   graph.put(start, new ArrayList<String>());
	   graph.put(end, new ArrayList<String>());
	   for(String d : dict) {
		   graph.put(d, new ArrayList<String>());
	   }
	   for(String s : graph.keySet()) {
		   ArrayList<String> list = graph.get(s);
	       for(String t : graph.keySet()) {
	           if(getDiff(s,t) == 1) {
	               list.add(t);
	           }              
	       }
	   }
	   // use BFS to traverse the node in the graph, we begin with "start"
	   int step = 0;
	   HashSet<String> visited = new HashSet<String>();
	   ArrayList<String> firstLevel = new ArrayList<String>(graph.get(start));
	   
	   while (firstLevel.size() != 0) {
		   step++;
		   ArrayList<String> nextLevel = new ArrayList<String>();
		   for (String s : firstLevel) {
			   if (s.equals(end)) return step + 1;
			   visited.add(s);
			   nextLevel.addAll(graph.get(s));
		   }
		   firstLevel.clear();
		   for (String t : nextLevel) {
			   if (!visited.contains(t)) {
				   firstLevel.add(t);
			   }
		   }
		   nextLevel.clear();
	   }
	   return 0;
	}

	public int getDiff(String w1, String w2) {
	   int count = 0;        
	   for(int i = 0; i < w1.length(); i++) {
	       if(w1.charAt(i) != w2.charAt(i)) {
	           count++;
	       }
	   }
	   return count;
	}
}

/*
 * �����Ŀ�Ƽ���Leetcode 102 Binary Tree Level Order Traversal��http://blog.csdn.net/zxzxy1988/article/details/8597354����������

�����Ŀ�����뵽����DFS����Իbacktracking��Ҳ����ÿ�ζ��ҵ�һ�����ܵ�·�������Ƚ�����·������С�ľ�����Ŀ������������Ȼ��Ҫ�϶��ʱ�䣬��Ϊ���Ǳ��������еĿ����ԡ���ô����û�и��ӿ�ݵķ����أ�
������Ȼ�ģ��Ǿ���BFS��CareerCup���������Ŀ����ʱû��ע���ܽ����ô����ķ��������һ��Ҫ�ú��ܽ�һ�¡����ȣ���Ȼ��Ŀ��û��һ����ͼ���ĸ���������ǿ��Լ��빹��һ��ͼ������ͼ�е�ÿ�����㶼�����ǵ�Ԫ�أ���͵��������ϵ�������أ����һ������ͨ���ı�һ����ĸ���ܹ��������һ�����ʣ����ǳ�֮Ϊ1 edit distance ���루�ǲ���������leetcode��edit distance�ǵ���Ŀ�ˣ������ԣ�ͼ�е���������Ԫ�ض���edit distance ����Ϊ1��Ԫ�ء���ô������ֻ��Ҫ��BFS�����������������ǵ�target word����ô���ǵľ�����Ƕ��١�������������е�Ԫ�ض�û���ҵ�target word����ô���Ǿͷ���1��
����һ����Ҫע��ĵط����ǣ������������������ĳ��Ԫ�أ��һὫ����ֵ���ɾ�����Է��Ժ��ٴα��������Ԫ�ء������м��������
1.�Ժ���Ҳ�����������Ԫ�أ���ô����ɾ������Ȼû���κ����⡣
2.�����Ժ���������Ԫ�أ��ַ�Ϊ���������
(1)�ڱ������Ǿ��ܱ�������Ԫ�ء�Ҳ����˵�����ǵ������Ԫ��������·�����������Ƕ������·����
��һ������Ӧ�ñȽ�������⣺����hot->hog->dog->dig��hot->dot->dog->dig����ô�ڵ�һ�α�������hotΪ1��Ԫ��ʱ�������ҵ���hog��dot����hog����ʱ�������ҵ���dog�����ҽ�����ֵ���ɾ������ô�ڱ�������dotΪ1��Ԫ��ʱ������ʵ�������Ҳ���dog�ģ���Ϊ�Ѿ���ɾ���ˡ����ڱ�����˵����û��ʲôӰ��ģ���Ϊ��dog���붼��3����dig���붼��4�����Ǻ���������word ladder 2��ʱ�����û�п��������������Ƿǳ������ģ���Ϊ��ĿҪ��������·������������������Ժ������������
(2)�ڸ��²����ǲ��ܹ���������Ԫ�ء�����hot->dot->dog->dig��hot->hat->dat->dag->dog->dig�������һ�������ҵ���dog���ҽ���ɾ������ô�ڶ�������ʵ�������Ҳ������Ԫ�صġ��������ڱ�����˵��û���κ�Ӱ�졣����word ladder 2��˵����ΪҲ��Ҫ������·��������Ҳ�������κ�Ӱ�졣������������Ҫ�������㵽�յ������·������ô���Ǿ�ҪС����������ˡ�


���ԣ�����������Ҳ�ܹ��õ�����һ�����ۣ�������Ŀ��˵��һ��Ҫ������ÿһ��ΪʲôҪ����������Ϊÿ�ַ�ʽ�����ٶ��������Ŀ��������һЩ�Ż�������word ladder I ��word ladder II����������Ҫ֪��ΪʲôҪ���Ż�������Ҫ֪���Ż��Ĵ�����ʲô����ʲô��������ã�ʲô����²����á�
����һ����ǣ�ÿ��һ����Ŀ��Ҫ�ú��ܽ�һ�£�����ͨ�������Ŀ�ܹ�ѧ��ʲô���õ���Ŀ��Ӧ���ǻ�ѧ��һ������һ���Եķ���������û��ʱ��ȥ��CLRS�����Ǻú��ܽ�ÿһ����Ŀ��ѧ��ķ���Ҳ�����١�



������������Ҫע���ϸ�ڣ�
1. ditance����Ӧ�ó�ʼ��Ϊ1�������ʵû�ж���������������Ŀ��Ҫ�󣬱���hot->hog->dog��������3����������ÿ��distanceֻ���ڱ仯��ʱ��������ӣ�Ҳ����˵�������������ʵ���Ϸ�ӳ���ǣ����ǡ��仯���˶��ٲ㣩������Ӧ�ó�ʼ��Ϊ1
2.��γ�ʼ��һ��string������queue.front()���ص���Ԫ�ص����ã�������Ǳ��뿽���Ǹ�����������ʹ��string str(queToPop.front());����ʼ����Ȼ��Ԫ��pop��
3.C++�У�ʵ�����ṩ��swap������ģ�壬���ò�˵���Ǻܷ���ġ�
 * */
