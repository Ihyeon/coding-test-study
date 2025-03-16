import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
//    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

//        st = new StringTokenizer(br.readLine());

//        int T = Integer.parseInt(br.readLine());

//        String str = br.readLine().toUpperCase();

//        String N = st.nextToken();
//        int M = Integer.parseInt(st.nextToken());
//        int M = Integer.parseInt(st.nextToken());
//        int c = Integer.parseInt(st.nextToken());


//        int[][] A = new int[N][M];

//        long T = Long.parseLong(br.readLine());

//        long M = Long.parseLong(st.nextToken());

//        LocalDate today = LocalDate.now(ZoneId.of("Asia/Seoul")); // 2025-3-12
//        ZonedDateTime seoulTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul")); // 시간 포함
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");




                int N = Integer.parseInt(br.readLine());

                int k = 1; // 최소 이동 횟수
                int maxNumber = 1; // 군집 최대값 (초기값 1)

                while (maxNumber < N) {
                    maxNumber += 6 * k; // 다음 군집의 최대값
                    k++; // 군집 증가
                }

                System.out.println(k);

    }
}