You are given a string sentence that consist of words separated by spaces. Each word consists of lowercase and uppercase letters only.
We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.) The rules of Goat Latin are as follows:
If a word begins with a vowel ('a', 'e', 'i', 'o', or 'u'), append "ma" to the end of the word.
For example, the word "apple" becomes "applema".
If a word begins with a consonant (i.e., not a vowel), remove the first letter and append it to the end, then add "ma".
For example, the word "goat" becomes "oatgma".
Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
For example, the first word gets "a" added to the end, the second word gets "aa" added to the end, and so on.
Return the final sentence representing the conversion from sentence to Goat Latin.

Example 1:
Input: sentence = "I speak Goat Latin"
Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
  
class Solution {
    public String toGoatLatin(String sentence) {
        Set<Character> set = new HashSet<>();
        for (char c : "aeiouAEIOU".toCharArray()) {
            set.add(c);
        }
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String tmp = "";
            if (set.contains(words[i].charAt(0))){
                tmp = words[i] + "ma";
            } else {
                tmp = words[i].substring(1)+words[i].substring(0,1)+ "ma";
            }
            for (int j = 0; j <= i; j++) {
                tmp = tmp + "a";
            }
            sb.append(tmp);
            if (i != words.length-1) sb.append(" ");
        }
        return sb.toString();
    }
}
