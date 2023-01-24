package com.computevo.leetcode.leetcode75.lvl1;

import static com.computevo.leetcode.helper.Utils.printInput;
import static com.computevo.leetcode.helper.Utils.printOutput;

/**
 * <a href="https://leetcode.com/problems/bulls-and-cows/?envType=study-plan&id=level-1">link</a>
 */
public class m299_BullsAndCows {

    /**
     * Official Solution
     */
    @SuppressWarnings("unused")
    public String getHint_Official(String secret, String guess) {
        int[] h = new int[10];

        int bulls = 0, cows = 0;
        int n = guess.length();
        for (int idx = 0; idx < n; ++idx) {
            char s = secret.charAt(idx);
            char g = guess.charAt(idx);
            if (s == g) {
                bulls++;
            } else {
                if (h[s - '0'] < 0)
                    cows++;
                if (h[g - '0'] > 0)
                    cows++;
                h[s - '0']++;
                h[g - '0']--;
            }
        }

        return bulls + "A" + cows + "B";
    }

    public String getHint(String secret, String guess) {

        int secNum;
        int guessNum;
        int bulls = 0;
        int cows = 0;
        int[] secretCounts = new int[10];
        int[] guessCounts = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            secNum = secret.charAt(i) - '0';
            guessNum = guess.charAt(i) - '0';
            if (secNum == guessNum) {
                bulls++;
            } else {
                secretCounts[secNum]++;
                guessCounts[guessNum]++;
            }
        }

        for (int i = 0; i < 10; i++) {
            cows += Math.min(secretCounts[i], guessCounts[i]);
        }

        return String.format("%dA%dB", bulls, cows);
    }

    public static void main(String[] args) {
        String secret1 = "1807";
        String guess1 = "7810";
        String secret2 = "1123";
        String guess2 = "0111";

        printInput("secret", "guess", new Object[][]{
                {secret1, guess1}, {secret2, guess2}
        });
        printOutput(
                "getHint(1)", new m299_BullsAndCows().getHint(secret1, guess1),
                "getHint(2)", new m299_BullsAndCows().getHint(secret2, guess2)
        );
    }
}
