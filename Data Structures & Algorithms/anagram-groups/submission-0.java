class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        // Your exact variable initialization, converted to working syntax
        List<List<String>> anagramList = new ArrayList<>(); 
        boolean[] visited = new boolean[strs.length]; // Elements aren't grouped twice
        
        for (int i = 0; i < strs.length; i++) {
            if (visited[i]) continue; // Skip if already grouped
            
            //Create the sublist for the possible anagrams
            List<String> currentSublist = new ArrayList<>();
            //Add the element at index i from anagramList
            currentSublist.add(strs[i]);
            //Since we added it, it is true that it has been visited
            visited[i] = true;

            for (int j = i + 1; j < strs.length; j++) {

                //If they are same length, then there is a possiblity the pair is an anagram; if not, it is impossible
                if (strs[i].length() == strs[j].length()) { 
                    int[] charCounts = new int[26];

                    //Keep track the number of letters from the alpahbet from both strings
                    for (int k = 0; k < strs[i].length(); k++) {
                        charCounts[strs[i].charAt(k) - 'a']++;
                        charCounts[strs[j].charAt(k) - 'a']--;
                    }
                    
                    boolean isAnagram = true;
                    //If the number of letters used from both strings are equal, then the sum of that letter in charCounts is 0)
                    for (int count : charCounts) {
                        if (count != 0) {
                            isAnagram = false;
                            break;
                        }
                    }
                    
                    if (isAnagram) {
                        currentSublist.add(strs[j]);
                        visited[j] = true; // Skip if already grouped
                    }
                }
            }
            anagramList.add(currentSublist);
        }
        return anagramList;
    }
}
