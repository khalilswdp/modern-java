package learning.mjia.leetcode.grind75.addbinary;

import java.math.BigInteger;

public class AddBinaryJoke {
    public String addBinary(String a, String b) {
        BigInteger aBI = new BigInteger(a, 2);
        BigInteger bBI = new BigInteger(b, 2);

        return aBI.add(bBI).toString(2);
    }
}
