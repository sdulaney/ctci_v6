package Question 1_1;

public class Question {

    public static boolean isUniqueChars(String str) {
        int checker = 0;                                    // Hash table w/ designated binary values for a-z
        for (int i = 0; i < str.length(); i++) {
            int value = str.charAt(i) - 'a';                // Set val equal to the diference between the ASCII values of the character and 'a'. e.g. int val = 'z' - 'a' = 25. Then the designated binary value for 'z' is (1 << 25) or 00000010000000000000000000000000
            if((checker & (1 << val)) > 0) {                // Do bitwise AND with checker and designated binary value of character. If it returns 1, then we know we've found a dupe b/c two bits at the same position were set to true
                return false;
            }
            checker |= (1 << val);                          // Our hash table gets or'd with the designated binary value. The designated bit for the character in the hash table is updated because we have not seen this characer before.

        }
        return true;                                        // Returns true if the entire string is traversed and no dupe is found
    }
}
