package Algorithms.dp;

/**
 * Dynamic Programming (동적 계획법) - Fibonacci 예제
 * - 문제: 피보나치 수열의 N번째 수를 구하라 (F(0) = 0, F(1) = 1)
 * - 재귀 방식은 중복 호출이 많아 비효율적이므로 DP를 사용
 * - 접근법: Bottom-up DP (반복문 기반)
 * - 핵심 개념:
 *   - dp[i] = i번째 피보나치 수
 *   - 점화식: dp[i] = dp[i - 1] + dp[i - 2]
 * - 시간 복잡도: O(N)
 * - 공간 복잡도: O(N)
 * - 적용 예시: 수열 문제, 경로 개수, 최소 비용 누적 등
 */

public class DP_Fibonacci {

    public static int fibonacci(int N) {
        if (N <= 1) return N;

        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[N];
    }

    public static void main(String[] args) {
        int N = 10;
        int result = fibonacci(N);
        System.out.printf("Fibonacci(%d) = %d\n", N, result);
    }
}
