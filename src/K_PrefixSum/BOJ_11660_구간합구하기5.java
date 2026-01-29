package K_PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2차원 구간 합 배열 D[X][Y] 정의
//  D[X][Y] = 원본 배열의 (0, 0)부터 (X, Y)까지의 사각형 영역 안에 있는 수의 합

// D[i][j]의 값을 채우는 구간 합 공식
//  D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + A[i][j]

/**
 * [백준] 구간 합 구하기 5
 * [Link] https://www.acmicpc.net/problem/11660
 * @level Sliver 1
 * @score 1360 ms / 129520 KB
 * @date 2025-03-12
 */

public class BOJ_11660_구간합구하기5 {

    // Q. 구간 합 구하기 5
    // N×N개의 수가 N×N 크기의 표에 채워져 있다. (x1, y1)부터 (x2, y2)까지 합을 구하는 프로그램을 작성하시오. (x, y)는 x행 y열을 의미한다.
    //
    //예를 들어, N = 4이고, 표가 아래와 같이 채워져 있는 경우를 살펴보자.
    //
    // 1  2	 3	4
    // 2  3	 4	5
    // 3  4	 5	6
    // 4  5	 6	7
    //여기서 (2, 2)부터 (3, 4)까지 합을 구하면 3+4+5+4+5+6 = 27이고, (4, 4)부터 (4, 4)까지 합을 구하면 7이다.
    //
    //표에 채워져 있는 수와 합을 구하는 연산이 주어졌을 때, 이를 처리하는 프로그램을 작성하시오.

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {


        // 📌 1트 메모리 초과
//        int N = nextInt(); // 2차원 배열의 크기
//        int M = nextInt(); // 구간 합 질의의 개수
//        int[][] arr = new int[N][N];
//
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                arr[i][j] = nextInt();
//                if (j > 0) {
//                    arr[i][j] += arr[i][j - 1];
//                }
//            }
//        }
//
//        for (int i = 0; i < M; i++) {
//            int sum = 0;
//            int x1 = nextInt() - 1;
//            int y1 = nextInt() - 1;
//            int x2 = nextInt() - 1;
//            int y2 = nextInt() - 1;
//
//            if (x1 == x2) { // 같은 행일 경우
//                if (y1 == 0) {
//                    sum = arr[x1][y2];
//                } else {
//                    sum = arr[x1][y2] - arr[x1][y1 - 1];
//                }
//            }  else {
//                for (int j = 0; j < x2 - x1 + 1; j++) {
//                    if (y1 == 0) {
//                        sum += arr[x1 + j][y2];
//                    } else {
//                        sum += arr[x1 + j][y2] - arr[x1 + j][y1 - 1];
//                    }
//                }
//            }
//
//            sb.append(sum).append("\n");
//        }
//
//        System.out.println(sb);

        // 📌 2트 1372ms
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] A = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] D = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                // 구간 합 구하기
                D[i][j] = D[i][j - 1] + D[i - 1][j] - D[i - 1][j - 1] + A[i][j];
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int result = D[x2][y2] - D[x1 - 1][y2] - D[x2][y1 - 1] + D[x1 - 1][y1 - 1];

            System.out.println(result);

            // 📌 3트
//        int N = nextInt();
//        int M = nextInt();
//
//        int[][] sums = new int[N + 1][N + 1];
//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= N; j++) {
//                sums[i][j] = nextInt() + sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1];
//            }
//        }
//
//        for (int i = 0; i < M; i++) {
//            int x1 = nextInt();
//            int y1 = nextInt();
//            int x2 = nextInt();
//            int y2 = nextInt();
//
//            sb.append(sums[x2][y2] - sums[x2][y1 - 1] - sums[x1 - 1][y2] + sums[x1 - 1][y1 - 1]).append("\n");
//        }
//
//
//        System.out.print(sb);

        }


//    static final int BUFFER_SIZE = 1 << 13;
//    static byte[] buffer = new byte[BUFFER_SIZE];
//    static int bufferLen, bufferIdx;
//
//    static int nextInt() throws IOException {
//        byte b;
//        int n = 0;
//        while ((b = read()) <= 32) ;
//        do {
//            n = (n << 3) + (n << 1) + (b & 15);
//        } while (isNumber(b = read()));
//
//        return n;
//    }
//
//    static boolean isNumber(byte b) {
//        return 47 < b && b < 58;
//    }
//
//    static byte read() throws IOException {
//        if (bufferLen == bufferIdx) {
//            bufferLen = System.in.read(buffer, 0, BUFFER_SIZE);
//            if (bufferLen == -1) {
//                buffer[0] = -1;
//            }
//        }
//        return buffer[bufferIdx++];
//
//    }
    }
}
