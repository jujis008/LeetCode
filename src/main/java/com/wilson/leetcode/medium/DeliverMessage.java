package com.wilson.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目描述：
 * 给一个公司的人员信息，第i个人传递消息的时间花费为t[i]，下属名单为list[i]。
 * 当某人接到消息后他会马上传递给他的所有下属，0号人物是CEO。
 * 现在CEO发布了一个消息传递下去，问公司里面所有人都收到消息的时间是多少？
 *
 * 思路点拨：从CEO开始BFS，BFS的路径就是拓扑序列，维护到达每个点的最短时间。
 *
 * 考点分析：本题考察了广度优先搜索，细节上需要注意。
 *
 * BFS:
 * https://baike.baidu.com/item/%E5%AE%BD%E5%BA%A6%E4%BC%98%E5%85%88%E6%90%9C%E7%B4%A2/5224802?fromtitle=BFS&fromid=542084&fr=aladdin
 * Created by i324291 on 2018/4/19.
 */
public class DeliverMessage {
    public int resolve(int[] t, int[][] subordinates) {
        final int length = t.length;
        int[] visit = new int[length + 1];
        for (int i = 1, len = length + 1; i < len; i++) {
            visit[i] = -1;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int time = 0;
        while (!queue.isEmpty()) {
            int idx = queue.poll();
            for (int i = 0, len = subordinates[idx].length; i < len; i++) {
                int visitTime = subordinates[idx][i];
                if (visitTime != -1 && visit[visitTime] == -1) {
                    visit[visitTime] = t[idx] + visit[idx];
                    if (visit[visitTime] > time) {
                        time = visit[visitTime];
                    }
                    queue.offer(idx);
                }

            }
        }
        return time;
    }
}
