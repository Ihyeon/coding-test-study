import java.io.*;
import java.util.StringTokenizer;

public class Main {

        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        static StringTokenizer st;
        static StringBuilder sb = new StringBuilder();

        public static void main(String[] args) throws IOException {

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());

            int x, y;

            if (a == 0) {
                y = c / b;
                x = (f - e*y) / d;
                System.out.println(x + " " + y);
            } else if (b == 0) {
                x = c / a;
                y = (f - d*x) / e;
                System.out.println(x + " " + y);
            } else if (d == 0) {
                y = f / e;
                x = (c - b* y)/a;
                System.out.println(x + " " + y);
            } else if (e == 0) {
                x = f / d;
                y = (c - a*x) / b;
                System.out.println(x + " " + y);
            } else {
                y = ((c * d) - (a * f)) / ((b * d) - (a * e));
                x = (c - b*y) / a;

                System.out.println(x + " " + y);
            }




        }
    }