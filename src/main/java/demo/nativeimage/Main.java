package demo.nativeimage;

import java.io.File;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.util.concurrent.Callable;
import java.lang.Exception;

public class Main {

    public static void main(String[] args) throws Exception {
        
        long begin = System.nanoTime();
        
        System.out.println("Starting to compute prime numbers :)");

        int n = 100_000_000;

        boolean[] isPrime = new boolean[n+1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
    
        for (int factor = 2; factor*factor <= n; factor++) {
            if (isPrime[factor]) {
                for (int j = factor; factor*j <= n; j++) {
                    isPrime[factor*j] = false;
                }
            }
        }
    
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) System.out.println(i);
        }

        long duration = System.nanoTime() - begin;
        System.out.printf("End of prime number computation in %f seconds.\n", duration / 1e9);
    }

}
