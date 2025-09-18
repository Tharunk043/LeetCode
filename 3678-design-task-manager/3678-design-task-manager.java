import java.util.*;

class TaskManager {
    // Max-heap: sort by priority DESC, then taskId DESC
    private PriorityQueue<int[]> pq;  // [priority, taskId, userId]
    private Map<Integer, int[]> taskMap; // taskId -> [userId, priority]

    public TaskManager(List<List<Integer>> tasks) {
        pq = new PriorityQueue<>((a, b) -> {
            if (b[0] != a[0]) return b[0] - a[0];  // higher priority first
            return b[1] - a[1];  // if tie, higher taskId first
        });
        taskMap = new HashMap<>();

        for (List<Integer> t : tasks) {
            add(t.get(0), t.get(1), t.get(2));
        }
    }

    public void add(int userId, int taskId, int priority) {
        pq.offer(new int[]{priority, taskId, userId});
        taskMap.put(taskId, new int[]{userId, priority}); // overwrite if re-added
    }

    public void edit(int taskId, int newPriority) {
        int userId = taskMap.get(taskId)[0];
        taskMap.put(taskId, new int[]{userId, newPriority});
        pq.offer(new int[]{newPriority, taskId, userId}); // push new version
    }

    public void rmv(int taskId) {
        taskMap.remove(taskId); // lazy removal
    }

    public int execTop() {
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int priority = top[0], taskId = top[1], userId = top[2];

            // validate both priority and userId
            if (taskMap.containsKey(taskId)) {
                int[] cur = taskMap.get(taskId);
                if (cur[0] == userId && cur[1] == priority) {
                    taskMap.remove(taskId); // execute & remove
                    return userId;
                }
            }
        }
        return -1; // no tasks
    }
}
