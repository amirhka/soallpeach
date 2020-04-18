package ir.amirkakavand;

import java.io.*;

import static java.lang.Integer.parseInt;

public class PrimeChecker {

    public static void main(final String[] args) throws Exception {
        final String fileName = args[0];
        read(fileName);
    }

    public static void read(final String inputFile) throws IOException {
        try (FileInputStream inputStream = new FileInputStream(inputFile);
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out))) {
            final BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = in.readLine()) != null) {
                int isPrime = isPrime(parseInt(line));
                out.write(isPrime + "\n");
                
            }
        }
    }

    public static int isPrime(int input) {
        if (input <= 3) {
            return 1;

        } else if (input % 2 == 0 || input % 3 == 0) {
            return 0;


        } else {

            int sqrt = (int) Math.sqrt(input);
            for (int i = 5; i <= sqrt; i += 6)
                if (input % i == 0 || input % (i + 2) == 0)
                    return 0;
        }

        return 1;
    }
}