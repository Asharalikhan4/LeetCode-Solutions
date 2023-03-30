class Solution {
    private boolean memoization(String s1, String s2, Map<String, Boolean> map) {
		if (s1.equals(s2)) {
			return true;
		}
		String key = s1 + " " + s2;
		if (map.containsKey(key)) {
			return map.get(key);
		}
		boolean flag = false;
		for (int i = 1; i <= s1.length() - 1; i++) {
			boolean noswap = memoization(s1.substring(0, i), s2.substring(0, i), map)
					&& memoization(s1.substring(i), s2.substring(i), map);

			boolean swap = memoization(s1.substring(0, i), s2.substring(s1.length() - i), map)
					&& memoization(s1.substring(i), s2.substring(0, s1.length() - i), map);

			if (swap || noswap) {
				flag = true;
				break;
			}
		}
		map.put(key, flag);
		return flag;
	}

	public boolean isScramble(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		Map<String, Boolean> map = new HashMap<>();
		return memoization(s1, s2, map);
	}
}