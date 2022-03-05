import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ExtraCredit4 {
    //169.MajorityElement
    //Given an array nums of size n, return the majority element.
    //
    //The majority element is the element that appears more than ⌊n / 2⌋ times.
    //You may assume that the majority element always exists in the array.
    //

    public int majorityElement(int[] nums) {
        int threshold = nums.length / 2;
        Map<Integer, Integer> counts = hashNums(nums);


        Map.Entry<Integer, Integer> countsEntry = null;
        for(Map.Entry<Integer, Integer> entry: counts.entrySet()) {
            if(countsEntry == null || entry.getValue() > countsEntry.getValue()){
                countsEntry = entry;
            }
        }
        return countsEntry.getKey();

    }

    private Map<Integer, Integer> hashNums(int[] nums){
        Map<Integer, Integer> counter = new HashMap<Integer, Integer>();

        for(int element: nums){
            if(counter.containsKey(element)){
                counter.put(element, counter.get(element) + 1);
            } else{
                counter.put(element, 1);
            }
        }

        return counter;
    }


//    217. Contains Duplicate
//    Given an integer array nums, return true if any value appears at least twice in the array,
//    and return false if every element is distinct.


    public boolean containsDuplicate(int[] nums) {

        boolean hasDuplicate = false;

        Set<Integer> set = new HashSet<>(nums.length);
        for(int element: nums){
            if (set.contains(element)){
                hasDuplicate = true;
            } else {
                set.add(element);
            }
        }

        return hasDuplicate;

    }

//    242.Valid Anagram
//    Given two strings s and t, return true if t is an anagram of s, and false otherwise.
//
//    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
//    typically using all the original letters exactly once.

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()){
            return false;
        }

        int[] counter = new int[26];
        for(int i = 0; i < s.length(); i++){
            counter[s.charAt(i) - 'a']++;

        }

        for(int j = 0; j < t.length(); j++){
            counter[t.charAt(j) - 'a']--;
            if(counter[t.charAt(j) - 'a'] < 0){
                return false;
            }
        }

        return true;
    }

}
