package Backjoon;

import java.io.*;
import java.util.*;

// 💛 슬라이딩 윈도우
// Deque(덱): 양쪽에서 삽입과 삭제가 모두 가능한 자료구조 (Queue + Stack)

public class BOJ_11003 {

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
