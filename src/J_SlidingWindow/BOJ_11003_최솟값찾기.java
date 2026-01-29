package J_SlidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// 슬라이딩 윈도우
// Deque(덱): 양쪽에서 삽입과 삭제가 모두 가능한 자료구조 (Queue + Stack)

/**
 * [백준] 최솟값 찾기
 * [Link] https://www.acmicpc.net/problem/11003
 * @level Gold 1
 * @score 1848 ms / 573152 KB
 * @date 2025-03-21
 */

public class BOJ_11003_최솟값찾기 {

    // 최솟값 찾기 1848ms

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 숫자의 개수
        int M = Integer.parseInt(st.nextToken()); // 슬라이딩 윈도우의 개수

        int[] arr = new int[N]; // 주어진 수의 배열

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {

            while (!deque.isEmpty() && deque.peekFirst() < i - M + 1) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && arr[deque.peekLast()] > arr[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            sb.append(arr[deque.peekFirst()]).append(" ");
        }

        System.out.println(sb);

    }
}
