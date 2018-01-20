/*
Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

Have you met this question in a real interview? Yes
Example
Gieve s = lintcode,
dict = ["de", "ding", "co", "code", "lint"].

A solution is ["lint code", "lint co de"].

Tags 
Dynamic Programming Backtracking
Related Problems 
Medium Word Break III 33 %
Easy Split String 20 %
Medium Word Break 14 %
*/
//---------------------------do not fully understand, copied from solutoin------------
public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if(s == null || s.length() == 0)
            return result;
        boolean[][] isWord = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i ++){
            for(int j = i; j < s.length(); j++){
                if(wordDict.contains(s.substring(i, j + 1)))
                    isWord[i][j] = true;
            }
        }//for i
        
        boolean[] isPossible = new boolean[s.length() + 1];
        isPossible[s.length()] = true;
        for(int i = s.length() - 1; i >= 0; i--){
            for(int j = i; j < s.length(); j++){
                if(isWord[i][j] && isPossible[j + 1]){
                    isPossible[i] = true;
                    break;
                }
            }
        }
        
        dfs(result, path, s, 0, isWord, isPossible);
        return result;
    }//wordBreak
    private void dfs(List<String> result, List<Integer> path, String s, int pos, boolean[][] isWord, boolean[] isPossible){
        if(!isPossible[pos])
            return;
        if(pos == s.length()){
            StringBuilder sb = new StringBuilder();
            int last = 0;
            for(int i = 0; i < path.size(); i ++){
                sb.append(s.substring(last, path.get(i)));
                if(i != path.size() - 1)
                    sb.append(" ");
                last = path.get(i);
            }
            result.add(new String(sb.toString()));
            //System.out.println(path);
            return;
        }//if end
        
        for(int i = pos; i < s.length(); i ++){
            if(!isWord[pos][i]){
                continue;
            }
            path.add(i + 1); //why add i + 1, not i?
            dfs(result, path, s, i + 1, isWord, isPossible);
            path.remove(path.size() - 1);
        }
    }//dfs
    
}
//////////_________________my wrong solution_______________________
// public class Solution {
//     /**
//      * @param s a string
//      * @param wordDict a set of words
//      */
//     public List<String> wordBreak(String s, Set<String> wordDict) {
//         // Write your code here
//         List<String> result = new ArrayList<>();
//         List<String> curSubStr = new ArrayList<>();
//         dfs(result, curSubStr, s, s, wordDict);
//         return result;
//     }
//     private void dfs(List<String> result, List<String> curSubStr, String orgS, String s, Set<String> dict){
//         if(curSubStr.size() > 0){
//             System.out.println(curSubStr);
//             StringBuilder sb = new StringBuilder();
//             for(int i = 0; i < curSubStr.size() - 1; i++)
//             sb.append(curSubStr.get(i) + " ");
//             sb.append(curSubStr.get(curSubStr.size() - 1));
//             String temp = sb.toString().replaceAll(" ", "");
//             if(temp.equals(orgS)){
//                 result.add(new String(sb.toString()));
//                 return;
//             }
//         }
        
//         for(int pos = 0; pos < s.length() - 1; pos ++){
//             List<String> parted = partition(s, pos);
//             String str1 = parted.get(0);
//             String str2 = parted.get(1);
//             if(!allInSet(parted, dict))
//                 continue;
//             curSubStr.add(str1);
//             dfs(result, curSubStr, orgS, str2, dict);
//             curSubStr.clear();
//             curSubStr.add(str1);
//             curSubStr.add(str2);
//         }//for pos
//     }
//     private List<String> partition(String str, int pos){
//         // split into 0 - pos, and pos+1 - end
//         List<String> tempResult = new ArrayList<>();
//         tempResult.add(str.substring(0, pos + 1));
//         tempResult.add(str.substring(pos + 1));
//         return tempResult;
//     }
//     private boolean allInSet(List<String> subStr, Set<String> dict){
//         if(subStr.size() < 2)
//             return false;
//         for(String str: subStr){
//             if(!dict.contains(str))
//                 return false;
//         }
//         return true;
//     }
// }