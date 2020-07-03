class AvalidAlphabeticWord {
    public boolean isAnagram(String s, String t) {
        //排序
        // if (s.length() != t.length()) {
        //     return false;
        // }
        // char[] s1 = s.toCharArray();
        // char[] t1 = t.toCharArray();
        // Arrays.sort(s1);
        // Arrays.sort(t1);
        // return Arrays.equals(s1,t1);

    
         //哈希表
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}