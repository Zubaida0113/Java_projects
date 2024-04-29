package password;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class PasswordUtil {

    public static final int MAX_PASSWORD_LENGTH = 10;

    public static final char[] UPPERS = new char[26];
    public static final char[] LOWERS = new char[26];

    public static final char[] SPECIALS = new char[32];
    public static final char[] DIGITS = new char[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

    static {
        // Static initializer block for populating arrays
        int Upper = 'A';
        int lower = 'a';
        int number = '0';
        for (int i = 0; i < 26; i++) {
            UPPERS[i] = (char) (Upper + i);
            LOWERS[i] = (char) (lower + i);
            if (i < 10) {
                DIGITS[i] = (char) (number + i);
            }
        }
        int v = 0;
        for (int i = 33; i < 127; i++) {
            char special = (char) 32;

            if (i >= 'a' && i <= 'z') {
                i = 'z' + 1;
            } else if (i >= 'A' && i <= 'Z') {
                i = 'Z' + 1;
            } else if (i >= '0' && i <= '9') {
                i = '9' + 1;
            }

            special = (char) i;
            SPECIALS[v] = special;
            v++;
        }
    }

    public String generatePassword() {
        List<char[]> activeSets = new ArrayList<char[]>(4);
        List<char[]> inactiveSets = new ArrayList<char[]>(4);

        activeSets.add(UPPERS);
        activeSets.add(LOWERS);
        activeSets.add(SPECIALS);
        activeSets.add(DIGITS);

        SecureRandom random = new SecureRandom();

        int passwordLength = 7 + random.nextInt(3);
        StringBuffer password = new StringBuffer(passwordLength + 1);

        for (int p = 0; p <= passwordLength; p++) {
            char[] Random_Set = null;
            if (activeSets.size() > 1) {
                int rSet = random.nextInt(activeSets.size());
                Random_Set = activeSets.get(rSet);
                inactiveSets.add(Random_Set);
                activeSets.remove(rSet);
            } else {
                Random_Set = activeSets.get(0);
                inactiveSets.add(Random_Set);
                activeSets.clear();
                activeSets.addAll(inactiveSets);
                inactiveSets.clear();
            }
            int Random_Char = random.nextInt(Random_Set.length);
            char random_char = Random_Set[Random_Char];
            password.append(random_char);
        }

        return password.toString();
    }
}