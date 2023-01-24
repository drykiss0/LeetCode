package com.computevo.leetcode.explore.google;

import java.util.HashSet;
import java.util.Set;

import static com.computevo.leetcode.helper.Utils.printInput;
import static com.computevo.leetcode.helper.Utils.printOutput;

/**
 * <a href="https://leetcode.com/explore/interview/card/google/67/sql-2/3044/">link</a>
 */
public class e929_UniqueEmailAddresses {

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            set.add(sanitize(email));
        }
        return set.size();
    }

    private String sanitize(String email) {
        boolean plusWasSeen = false;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        char ch;
        while(email.charAt(i) != '@') {
            ch = email.charAt(i);
            if (ch == '+') {
                plusWasSeen = true;
            } else if (ch != '.' && !plusWasSeen) {
                sb.append(ch);
            }
            i++;
        }
        return sb.append(email.substring(i)).toString();
    }

    public static void main(String[] args) {

        String[] emails1 = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        String[] emails2 = {"test.email+alex@leetcode.com", "test.email@leetcode.com"};


        printInput("emails", new Object[]{emails1, emails2});
        printOutput(
                "numUniqueEmails1", new e929_UniqueEmailAddresses().numUniqueEmails(emails1),
                "numUniqueEmails2", new e929_UniqueEmailAddresses().numUniqueEmails(emails2)
        );
    }
}
