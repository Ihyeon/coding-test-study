    import java.io.*;
    import java.util.*;


    public class Main {

        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        static StringTokenizer st;
        static StringBuilder sb = new StringBuilder();

        public static void main(String[] args) throws IOException {

            int M = Integer.parseInt(br.readLine());
            int N = Integer.parseInt(br.readLine());

            int primeSum = 0;
            int minPrime = 1;

            outerLoop:
            for (int i = M; i <= N ; i++) {
                for (int j = 2; j <= Math.sqrt(i); j++) {
                    if (i % j == 0) {
                        continue outerLoop;
                    }
                }
                if (minPrime == 1) minPrime = i;
                if (i != 1) primeSum += i;
            }

            if (minPrime == 1) {
                System.out.println(-1);
            } else {
                System.out.println(primeSum + "\n" + minPrime);
            }
        }

    }