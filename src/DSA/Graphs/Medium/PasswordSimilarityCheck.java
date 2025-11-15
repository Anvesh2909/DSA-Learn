package DSA.Graphs.Medium;

import java.util.*;

public class PasswordSimilarityCheck {

    public static boolean canFormSubsequence(String old, String newPass) {
        int i = 0, j = 0;
        int oldLen = old.length(), newLen = newPass.length();

        while (i < oldLen && j < newLen) {
            char oldChar = old.charAt(i);
            char newChar = newPass.charAt(j);

            // Next cyclic character: z -> a
            char nextChar = (char)('a' + (newChar - 'a' + 1) % 26);

            // Match if same OR old matches next cyclic of new
            if (oldChar == newChar || oldChar == nextChar) {
                i++; // Match found, move old pointer
            }
            j++; // Always move new pointer
        }

        return i == oldLen; // All chars of old matched
    }

    public static List<String> findPasswordSimilar(String[] oldPasswords, String[] newPasswords) {
        List<String> res = new ArrayList<>();

        for (int i = 0; i < oldPasswords.length; i++) {
            if (canFormSubsequence(oldPasswords[i], newPasswords[i])) {
                res.add("YES");
            } else {
                res.add("NO");
            }
        }

        return res;
    }

    public static void main(String[] args) {
        // Test Case 1
        String[] oldPasswords1 = {"abc", "def"};
        String[] newPasswords1 = {"bcd", "xyz"};
        System.out.println(findPasswordSimilar(oldPasswords1, newPasswords1));
        // Output: [YES, NO]

        // Test Case 2
        String[] oldPasswords2 = {"aaa"};
        String[] newPasswords2 = {"aaabbb"};
        System.out.println(findPasswordSimilar(oldPasswords2, newPasswords2));

        String[] oldPasswords3 = {"abc"};
        String[] newPasswords3 = {"bcd"};
        System.out.println(findPasswordSimilar(oldPasswords3, newPasswords3));
    }
}