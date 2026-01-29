package E_BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Brute Force (브루트포스, 완전 탐색)
 * - 가능한 모든 경우의 수를 전부 시도하여 정답을 찾는 가장 직관적인 알고리즘
 * - 구성: 중첩 반복문 또는 재귀를 통해 모든 조합을 탐색
 * - 시간 복잡도: 경우에 따라 다름 (O(n^2), O(n^3), ..., O(k^n))
 * - 공간 복잡도: 일반적으로 O(1) 또는 O(n)
 * - 특징:
 *   - 가장 단순하고 직관적이지만, 비효율적일 수 있음
 *   - 해가 반드시 존재하면 찾을 수 있음 (완전성 보장)
 * - 적용 예시: 소수 구하기, 두 수의 합, 특정 조건 만족하는 좌표 찾기 등
 */


/**
 * [백준] 수학은 비대면강의입니다
 * [Link] https://www.acmicpc.net/problem/19532
 * @level Bronze 2
 * @score 128 ms / 15996 KB
 * @date 2025-03-23
 */

public class BOJ_19532_수학은비대면강의입니다 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        for (int x = -999; x <= 999; x++) {
            for (int y = -999; y <= 999; y++) {
                if (a * x + b * y == c && d * x + e * y == f) {
                    System.out.println(x + " " + y);
                    return;
                }
            }
        }
        
    }

}


