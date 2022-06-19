package JavaCode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Java715 {
    TreeMap<Integer, Integer> intervals;
    public Java715() {
        intervals = new TreeMap<Integer, Integer>();
    }

    public void addRange(int left, int right) {
        // 找到比 left 大的区间中左边界最小的 entry 如果没有返回 null
        Map.Entry<Integer, Integer> entry = intervals.higherEntry(left);
        // 如果 entry 不是第一个TreeMap 的第一个 entry 1.在这个区间之前有别的区间, 也就是左边还有扩展空间 2.不存在左边界比 left 大的区间, 也就是 null
        if (entry != intervals.firstEntry()) {
            // 如果entry == null 说明没有左边界比 left 大的 entry 存在, 所以这时候要拿 map 中左边界最大的一个 也就是最后一个 entry, 此时所有的 entry 的左边界
            // 都比 left 小
            // 如果 entry != null 说明有左边界比 left 大的 entry 存在, 这时候要找左边界小于 left的最大的 entry
            Map.Entry<Integer, Integer> start = entry != null ? intervals.lowerEntry(entry.getKey()) : intervals.lastEntry();
            // 只要 start 存在就一定会有左边界比 left 小的 entry 存在, 所以此时这个区间的右边界大于等于 right 就是包含关系直接跳过
            if (start != null && start.getValue() >= right) {
                return;
            }
            // 只要 start 存在就一定会有左边界比 left 小的 entry 存在, 此时这个区间的右边界大于等于 left,这两个区间要么无缝衔接, 要么有交集所以就是将这个区间的
            // 的左边界给 left, 这样就完成了区间的合并(因为这个左边界更小)
            if (start != null && start.getValue() >= left) {
                left = start.getKey();
                intervals.remove(start.getKey());
            }
        }
        // entry 是左边界比 left 大的条件里 左边界最小的, 如果左边界小于 right, 说明有交集, 这个时候比较entry 的右边界跟 right 谁在最右边然后合并
        // 然后不断的将左边界比 left 大 且 小于 right(也就是我们最后要添加的新区间的右边界合并)
        while (entry != null && entry.getKey() <= right) {
            right = Math.max(right, entry.getValue());
            intervals.remove(entry.getKey());
            entry = intervals.higherEntry(entry.getKey());
        }
        // 最后把新区间添加到 intervals, 就算 entry 最开始就是空说明没有左边界比 left 大的区间存在, 也就是说所有的 entry 的左边界都是小于 left
        // 左边界 left 右边界 right
        // 左边界 left right 右边界
        intervals.put(left, right);
    }

    public boolean queryRange(int left, int right) {
        Map.Entry<Integer, Integer> entry = intervals.higherEntry(left);
        if (entry == intervals.firstEntry()) {
            return false;
        }
        entry = entry != null ? intervals.lowerEntry(entry.getKey()) : intervals.lastEntry();
        return entry != null && right <= entry.getValue();
    }

    public void removeRange(int left, int right) {
        Map.Entry<Integer, Integer> entry = intervals.higherEntry(left);
        if (entry != intervals.firstEntry()) {
            Map.Entry<Integer, Integer> start = entry != null ? intervals.lowerEntry(entry.getKey()) : intervals.lastEntry();
            if (start != null && start.getValue() >= right) {
                int ri = start.getValue();
                if (start.getKey() == left) {
                    intervals.remove(start.getKey());
                } else {
                    intervals.put(start.getKey(), left);
                }
                if (right != ri) {
                    intervals.put(right, ri);
                }
                return;
            } else if (start != null && start.getValue() > left) {
                intervals.put(start.getKey(), left);
            }
        }
        while (entry != null && entry.getKey() < right) {
            if (entry.getValue() <= right) {
                intervals.remove(entry.getKey());
                entry = intervals.higherEntry(entry.getKey());
            } else {
                intervals.put(right, entry.getValue());
                intervals.remove(entry.getKey());
                break;
            }
        }
    }
}
