package K_PrefixSum;

// 구간 합 구하기
// 1. 합 배열 S 정의 - A[0]부터 A[i]까지의 합
//    S[i] = A[0] + A[1] + A[2] + ... + A[i - 1] + A[i]
// 2. 합 배열 S를 만드는 공식
//    S[i] = S[i - 1] + A[i]
// 3. 구간 합을 구하는 공식
//    S[j] - S[i-1] = i에서 j까지 구간 합

/**
 * [백준] 구간 합 구하기 4
 * [Link] https://www.acmicpc.net/problem/11659
 * @level Sliver 3
 * @score 232 ms / 25952 KB
 * @date 2025-03-12
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11659_구간합구하기4 {

    // 수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

//        int N = Integer.parseInt(st.nextToken()); // 수의 개수
//        int M = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수

        // 1트 592ms
//        int[] arr = new int[N];
//        int[] sumArr = new int[N];
//
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < N; i++) {
//            arr[i] = Integer.parseInt(st.nextToken());
//
//            // 구간 합 배열 구하기
//            if(i == 0) {
//                sumArr[i] = arr[i];
//            } else {
//                sumArr[i] += sumArr[i - 1] + arr[i];
//            }
//        }
//
//        for (int i = 0; i < M; i++) {
//
//            st = new StringTokenizer(br.readLine());
//            int k = Integer.parseInt(st.nextToken());
//            int j = Integer.parseInt(st.nextToken());
//
//            if (k == 1) {
//                sb.append(sumArr[j-1]).append("\n");
//            } else {
//                sb.append(sumArr[j-1] - sumArr[k - 2]).append("\n");
//            }
//
//        }

//        System.out.println(sb.toString());
//
//    }

//        // 2트 580ms
//        int[] S = new int[N + 1];
//        st = new StringTokenizer(br.readLine());
//        for(int i = 0; i < N; i++) {
//            S[i + 1] = S[i] + Integer.parseInt(st.nextToken());
//        }
//
//        for (int k = 0; k < M; k++) {
//            st = new StringTokenizer(br.readLine());
//            int i = Integer.parseInt(st.nextToken());
//            int j = Integer.parseInt(st.nextToken());
//
//            sb.append(S[j] - S[i - 1]).append("\n");
//        }
//
//        System.out.println(sb.toString());

        // 3트 600ms
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        String[] firstLine = br.readLine().split(" ");
//        int N = Integer.parseInt(firstLine[0]);
//        int M = Integer.parseInt(firstLine[1]);
//
//        int[] S = new int[N + 1];
//
//        String[] numLine = br.readLine().split(" ");
//        for (int i = 1; i <= N; i++) {
//            S[i] = S[i - 1] + Integer.parseInt(numLine[i - 1]);
//        }
//
//        for (int k = 0; k < M; k++) {
//            String[] query = br.readLine().split(" ");
//            int i = Integer.parseInt(query[0]);
//            int j = Integer.parseInt(query[1]);
//
//            bw.write((S[j] - S[i - 1]) + "\n");
//        }
//
//        bw.flush();
//        br.close();
//        bw.close();

        // 4트
        // 240ms
        int N = nextInt();
        int M = nextInt();

        int[] nums = new int[N];
        nums[0] = nextInt();
        for (int i = 1; i < N; i++) {
            nums[i] = nextInt() + nums[i - 1]; // 누적 합 배열
        }

        for (int i = 0; i < M; i++) {
            int fromIdx = nextInt() - 1; // 1-based → 0-based 변환
            int toIdx = nextInt() - 1;
            int sum = nums[toIdx];
            if (fromIdx > 0) {
                sum -= nums[fromIdx - 1];
            }

            sb.append(sum).append('\n');
        }

        System.out.println(sb);

    }

    static final int BUFFER_SIZE = 1 << 13; // 8192 바이트 (8KB) - 일반적으로 입출력 최적화에 가장 적절한 크기, 작은 데이터를 모아 한 번에 처리
    static byte[] buffer = new byte[BUFFER_SIZE];// 8KB 크기의 버퍼 배열 생성
    static int bufferLen, bufferIdx;

    // 초고속 바이트 입력 함수 (입력에서 하나씩 숫자를 읽어 int로 변환)
    static int nextInt() throws IOException {
        byte b;
        int n = 0;
        while ((b = read()) <= 32) ; // 공백(스페이스, 개행) 무시
        do {
            n = (n << 3) + (n << 1) + (b & 15); // (n * 10) + (b - '0') 계산, 정수를 빠르게 변환
        } while (isNumber(b = read()));

        return n;
    }

    // 숫자 판별 함수
    static boolean isNumber(byte b) {
        return 47 < b && b < 58; // '0'~'9' 범위의 ASCII 값 확인
    }

    // 초고속 바이트 입력 함수
    static byte read() throws IOException {
        if (bufferIdx == bufferLen) { // 버퍼가 비었으면 새로 읽기
            bufferLen = System.in.read(buffer, bufferIdx = 0, BUFFER_SIZE); // 최대 BUFFER_SIZE 바이트를 읽고, 실제로 읽은 바이트 수를 반환 (int), 매개변수가 없다면 문자의 ASCII 값 반환 (int)
            if (bufferLen == -1) { // 입력 스트림이 끝나면 -1을 반환함
                buffer[0] = -1;
            }
        }
        return buffer[bufferIdx++];

    }


}
