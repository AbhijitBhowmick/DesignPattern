package org.example.twopointers.neetcode;

import java.util.function.Function;
import java.util.function.Predicate;

import static org.example.arraysandhashing.neetcode.ValidAnagram.isAnagram;

public class ValidPallindrome {
    public static boolean isPallinDrome(String s){
        Predicate<Character> isAlphaNumeric = Character ::isLetterOrDigit;;
        Function<Character,Character> toLowerCase =  Character::toLowerCase;

        int i = 0;
        int j = s.length()-1;

        while(i<j){
            while (i<j && !isAlphaNumeric.test(s.charAt(i))){
                i++;
            }
            while(i<j && !isAlphaNumeric.test(s.charAt(j))){
                j--;
            }
            while(!toLowerCase.apply(s.charAt(i)).equals(toLowerCase.apply(s.charAt(j)))){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "eye";
        System.out.println(isPallinDrome(s)); // true
    }

}
