package Backjoon;

// 모듈러 연산의 성질
// (A + B) % C = ((A % C) + (B % C)) % C
// 모듈러 연산은 나머지를 보존하는 성질을 가지고 있다.
// 즉, 나머지 연산을 수행한 후 더하는 것이나, 더한 후 나머지를 구하는 것이 동일한 결과를 보장한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10986 {

    // 나머지 합 구하기
    // 수 N개 A1, A2, ..., AN이 주어진다. 이때, 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 구하는 프로그램을 작성하시오.
    // 즉, Ai + ... + Aj (i ≤ j) 의 합이 M으로 나누어 떨어지는 (i, j) 쌍의 개수를 구해야 한다.

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 주어질 수의 개수
        int M = Integer.parseInt(st.nextToken()); // 연속된 부분 구간의 합을 나눌 수
        long result = 0; // 나누어떨어지는 구간의 개수

        int sum = 0; // 누적 합
        int[] R = new int[M]; // 나머지가 등장한 개수를 저장하는 배열

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sum += Integer.parseInt(st.nextToken());

            int rem = sum % M;

            if (rem < 0) rem += M;

            if (rem == 0) result++;

            result += R[rem];

            R[rem]++;
        }

        System.out.println(result);
    }
}
