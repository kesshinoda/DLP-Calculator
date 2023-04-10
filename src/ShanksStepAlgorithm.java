import java.math.BigInteger;
import java.util.Scanner;

public class ShanksStepAlgorithm
{
    //This uses Shank's Baby Step Giant Step Algorithm
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("This program solves DLP: find x such that g^x = h (mod p).");
        System.out.println("Type g");
        System.out.println("Type h");
        BigInteger h = input.nextBigInteger();
        BigInteger g = input.nextBigInteger();
        System.out.println("Type p");
        BigInteger p = input.nextBigInteger();
        BigInteger x;
        BigInteger n = new BigInteger(String.valueOf(BigInteger.ONE.add((p.sqrt()))));
        BigInteger[] list1 = new BigInteger[n.intValue()+1];
        BigInteger[] list2 = new BigInteger[n.intValue()+1];

        for(int i = 0; i < list1.length; i++)
        {
            list1[i] = g.modPow(BigInteger.valueOf(i), p);
        }

        BigInteger y;
        for(int j = 0; j < list2.length; j++)
        {
            y = g.modPow(BigInteger.valueOf(-j).multiply(n), p);
            list2[j] = h.multiply(y).mod(p);
        }

        int icollision = 0;
        int jcollision = 0;
        outer: for(int i = 0; i < list1.length; i++)
        {
            for(int j = 0; j < list2.length; j++)
            {
                if (list1[i].equals(list2[j]))
                {
                    icollision = i;
                    jcollision = j;
                    break outer;
                }
            }
        }

        x = BigInteger.valueOf(icollision).add(BigInteger.valueOf(jcollision).multiply(n));

        System.out.println("g: " + g);
        System.out.println("h: " + h);
        System.out.println("p: " + p);
        System.out.println("When g, h, p are these values, x: " + x);
    }
}

