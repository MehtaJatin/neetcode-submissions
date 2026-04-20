class Solution {
    class Pair {
        int first, second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) +1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.second, b.second)
        );

        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            pq.add(new Pair(entry.getKey(), entry.getValue()));
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] result = new int[k];
        int i = 0;
        while(!pq.isEmpty()) {
            result[i++] = pq.poll().first;
        }

        return result;
    }
}
