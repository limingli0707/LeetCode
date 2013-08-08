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
 * 这道题目推荐和Leetcode 102 Binary Tree Level Order Traversal（http://blog.csdn.net/zxzxy1988/article/details/8597354）连起来看

这道题目首先想到的是DFS，或曰backtracking，也就是每次都找到一个可能的路径，最后比较所有路径中最小的就是题目所求。这样做显然需要较多的时间，因为我们遍历了所有的可能性。那么，有没有更加快捷的方案呢？
答案是显然的，那就是BFS。CareerCup上有这道题目，当时没有注意总结成这么抽象的方法，这次一定要好好总结一下。首先，虽然题目中没有一个“图”的概念，但是我们可以假想构建一个图，其中图中的每个顶点都是我们的元素，点和点是如何联系起来的呢？如果一个单词通过改变一次字母，能够变成另外一个单词，我们称之为1 edit distance 距离（是不是想起了leetcode中edit distance那道题目了？）所以，图中的所有相邻元素都是edit distance 距离为1的元素。那么，我们只需要做BFS，哪里最先遇到我们的target word，那么我们的距离就是多少。如果遍历完所有的元素都没有找到target word，那么我们就返回1。
另外一个需要注意的地方就是，如果我们曾经遍历过某个元素，我会将其从字典中删除，以防以后再次遍历到这个元素。这里有几种情况：
1.以后再也遍历不到这个元素，那么我们删除它当然没有任何问题。
2.我们以后会遍历到该元素，又分为两种情况：
(1)在本层我们就能遍历到该元素。也就是说，我们到达这个元素有两条路径，而且它们都是最短路径。
举一个例子应该比较容易理解：比如hot->hog->dog->dig和hot->dot->dog->dig，那么在第一次遍历距离hot为1的元素时，我们找到了hog和dot。对hog遍历时，我们找到了dog，并且将其从字典中删除。那么在遍历距离dot为1的元素时，我们实际上是找不到dog的，因为已经被删除了。对于本题来说，是没有什么影响的，因为到dog距离都是3，到dig距离都是4。但是后面我们做word ladder 2的时候，如果没有考虑这个情况，将是非常致命的，因为题目要求输出最短路径的所有情况，我们稍后讨论相关问题
(2)在更下层我们才能够遍历到该元素。比如hot->dot->dog->dig和hot->hat->dat->dag->dog->dig，如果第一次我们找到了dog并且将其删除，那么第二次我们实际上是找不到这个元素的。这样对于本题来说，没有任何影响。对于word ladder 2来说，因为也是要输出最短路径，所以也不会有任何影响。但是倘若我们要输出从起点到终点的所有路径，那么我们就要小心这种情况了。


所以，从这里我们也能够得到这样一个结论：对于题目来说，一定要深刻理解每一步为什么要这样做。因为每种方式或多或少都会根据题目的特性做一些优化（比如word ladder I 和word ladder II），不仅仅要知道为什么要做优化，而且要知道优化的代价是什么，在什么情况下适用，什么情况下不适用。
另外一点就是，每做一道题目都要好好总结一下，看看通过这道题目能够学会什么。好的题目，应该是会学会一个更加一般性的方法。现在没有时间去看CLRS，但是好好总结每一道题目，学会的方法也不会少。



几个程序中需要注意的细节：
1. ditance变量应该初始化为1。这个其实没有定数，不过根据题目的要求，比如hot->hog->dog，距离是3，由于我们每次distance只有在变化的时候才能增加（也就是说，我们这个变量实际上反映的是，我们“变化”了多少层），所以应该初始化为1
2.如何初始化一个string。由于queue.front()返回的是元素的引用，因此我们必须拷贝那个变量，所以使用string str(queToPop.front());来初始化，然后将元素pop。
3.C++中，实际上提供了swap函数的模板，不得不说还是很方便的。
 * */
