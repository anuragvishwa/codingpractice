class Solution {
    public boolean canConvert(String str1, String str2) {
       
        if (str1.equals(str2)) return true;
        Map<Character, Character> dp = new HashMap<>();
        for (int i = 0; i < str1.length(); ++i) {
            if (dp.getOrDefault(str1.charAt(i), str2.charAt(i)) != str2.charAt(i))
                return false;
            dp.put(str1.charAt(i), str2.charAt(i));
        }
        return new HashSet<Character>(dp.values()).size() < 26;
    
    }
}