public class MinimumWindowSubsequence {
    public String minWindow(String s, String t) {
        int si = 0, ti = 0;
        String rt = s + "123";
        while (si < s.length()) {
            if (s.charAt(si) == t.charAt(ti)) {
                if (ti == t.length() - 1) {
                    int end = si;                    
                    while (ti >= 0) {
                        while (s.charAt(si) != t.charAt(ti)) {
                            si--;
                        }
                        ti--;
                        si--;
                    }
                    
                    si++;
                    if (rt.length() > end - si + 1) {
                        rt = s.substring(si, end + 1);
                    }
                }
                ti++;
            }
            
            si++;
        }
        
        return rt.equals(s + "123") ? "" : rt;
    }
}
