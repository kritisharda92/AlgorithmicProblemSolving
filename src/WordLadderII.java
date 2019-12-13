import java.util.*;
class WordLadderII {
    Map<String, List<String>> map;

    private void dfs(List<List<String>> res, List<String> list, String endWord, String curr) {
        if(map.get(curr) == null) return;

        if(curr.equals(endWord)) {
            res.add(new ArrayList<>(list));
            return;
        }

        for(String s : map.get(curr)) {
            list.add(s);
            dfs(res, list, endWord, s);
            list.remove(list.size() - 1);
        }
    }

    private void bfs(Set<String> set, Set<String> startWords, Set<String> endWords, boolean reverse) {
        if (startWords.size() == 0) return;
        if (startWords.size() > endWords.size()) {
            bfs(set, endWords,startWords, !reverse);
            return;
        }

        boolean flag = false;
        Set<String> newSet = new HashSet<>();
        set.removeAll(startWords);

        for (String w : startWords) {
            char[] curr = w.toCharArray();
            for (int i = 0; i < curr.length; i++) {
                char oldchar = curr[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    curr[i] = c;
                    String word_after = new String(curr);
                    if (set.contains(word_after)) {
                        String key = reverse ? word_after : w;
                        String val = reverse ? w : word_after;
                        map.computeIfAbsent(key, k -> new ArrayList<>());
                        map.get(key).add(val);

                        if(endWords.contains(word_after)) flag = true;
                        else newSet.add(word_after);
                    }
                }
                curr[i] = oldchar;
            }
        }
        if(!flag) bfs(set, newSet, endWords, reverse);
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();

        Set<String> set = new HashSet<>();
        for(String s: wordList)
            set.add(s);

        if(!set.contains(endWord)) return ans;

        map = new HashMap<>();
        Set<String> startWords = new HashSet<>();
        Set<String> endWords = new HashSet<>();
        List<String> tempList = new ArrayList<>();

        startWords.add(beginWord);
        endWords.add(endWord);
        tempList.add(beginWord);

        bfs(set, startWords, endWords, false);
        dfs(ans, tempList, endWord, beginWord);

        return ans;
    }

    public static void main(String[] args) {
        WordLadderII obj = new WordLadderII();
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        System.out.println(obj.findLadders("hit","cog",wordList));
    }
}
