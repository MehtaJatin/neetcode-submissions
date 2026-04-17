class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mp = new HashMap<>();

        for (int i=0;i<strs.length;i++) {
            char[] array = strs[i].toCharArray();
            Arrays.sort(array);
            String sorted = new String(array);
            mp.putIfAbsent(sorted, new ArrayList<>());
            mp.get(sorted).add(strs[i]);
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry: mp.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }
}