/*
A frog is crossing a river. The river is divided into x units and at each unit there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.

Given a list of stones' positions (in units) in sorted ascending order, determine if the frog is able to cross the river by landing on the last stone. Initially, the frog is on the first stone and assume the first jump must be 1 unit.

If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1 units. Note that the frog can only jump in the forward direction.

 Notice
The number of stones is ≥ 2 and is < 1100.
Each stone's position will be a non-negative integer < 2^31.
The first stone's position is always 0.
Have you met this question in a real interview? Yes
Example
Given stones = [0,1,3,5,6,8,12,17]

There are a total of 8 stones.
The first stone at the 0th unit, second stone at the 1st unit,
third stone at the 3rd unit, and so on...
The last stone at the 17th unit.

Return true. The frog can jump to the last stone by jumping 
1 unit to the 2nd stone, then 2 units to the 3rd stone, then 
2 units to the 4th stone, then 3 units to the 6th stone, 
4 units to the 7th stone, and 5 units to the 8th stone.

Given stones = `[0,1,2,3,4,8,9,11]`

Return false. There is no way to jump to the last stone as 
the gap between the 5th and 6th stone is too large.
Tags 
Dynamic Programming
Related Problems 
Medium Longest Increasing Subsequence 30 %
*/
// //______using hashmap
public class Solution {
    public boolean canCross(int[] stones){
        // stone No., steps
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i = 0; i < stones.length; i ++){
            // Note: in newHashSet, must give the actual type
            map.put(stones[i], new HashSet<Integer>());
        }
        map.get(stones[0]).add(0);
        // 循环到倒数第二个
        for(int i = 0; i < stones.length - 1; i ++){
            int curStone = stones[i];
            for(int step: map.get(curStone)){
                if(step - 1 > 0 && map.containsKey(curStone + step - 1)){
                    map.get(curStone + step - 1).add(step - 1);
                }
                // !! do not use else if !!!!!
                if(map.containsKey(curStone + step)){
                    map.get(curStone + step).add(step);
                }
                if(map.containsKey(curStone + step + 1)){
                    map.get(curStone + step + 1).add(step + 1);
                }
            }
        }
        return !map.get(stones[stones.length - 1]).isEmpty();
    }
}

//________不用用arraylist存储，没必要存储重复的step值，会造成内存超出
//用hashmap存放即可，只存唯一的step值
public class Solution {
    /**
     * @param stones a list of stones' positions in sorted ascending order
     * @return true if the frog is able to cross the river or false
     */
    class Trace{
        //boolean canJump;
        Set<Integer> steps;
        //public Trace(boolean canJump, ArrayList<Integer> steps){
            public Trace(Set<Integer> steps){
            //this.canJump = canJump;
            this.steps = steps;
        }
    }
    public boolean canCross(int[] stones) {
        // Write your code here
        Trace[] trace = new Trace[stones.length];
        Set<Integer> temp = new HashSet<>();
        temp.add(0);
        trace[0] = new Trace(temp);
        for(int i = 1; i < stones.length; i ++){
            Set<Integer> tempSet = new HashSet<>();
            for(int j = 0; j < i; j ++){
                //if(trace[j].canJump){
                    for(int step: trace[j].steps){
                        if(stones[i] - stones[j] == step - 1){
                            tempSet.add(step - 1);
                        }
                        else if(stones[i] - stones[j] == step){
                            tempSet.add(step);
                        }
                        else if(stones[i] - stones[j] == step + 1){
                            tempSet.add(step + 1);
                        }
                    }// for steps in trace[j]
                //}// if trace[j] == true
            }// for j
            trace[i] = new Trace(tempSet);
        }// for i
        return !(trace[trace.length - 1].steps.size() == 0);
    }
}