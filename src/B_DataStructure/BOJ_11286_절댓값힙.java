package B_DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 우선순위 큐: 정렬 기준 적용

/**
 * [백준] 절댓값 힙
 * [Link] https://www.acmicpc.net/problem/11286
 * @level Silver 1
 * @score 496 ms / 27032 KB
 * @date 2025-03-22
 */

public class BOJ_11286_절댓값힙 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 연산의 개수

        // 1트 280ms
        // 음수 우선순위 큐와 양수 우선순위 큐를 각각 선언

//        PriorityQueue<Integer> queueP = new PriorityQueue<>(); // 양수 큐
//        PriorityQueue<Integer> queueN = new PriorityQueue<>(); // 음수 큐

//        for (int i = 0; i < N; i++) {
//            int n = Integer.parseInt(br.readLine());
//            if ( n == 0 ) {
//                if (queueN.isEmpty() && queueP.isEmpty()) {
//                    sb.append(0).append("\n");
//                } else if (queueN.isEmpty()) {
//                    sb.append(queueP.poll()).append("\n");
//                } else if (queueP.isEmpty()) {
//                    sb.append(-1 * queueN.poll()).append("\n");
//                } else {
//                    int a = queueP.peek();
//                    int b = queueN.peek();
//                    if (a == b) {
//                        sb.append(-1 * queueN.poll()).append("\n");
//                    } else {
//                        sb.append(a > b ? -1 * queueN.poll() : queueP.poll()).append("\n");
//                    }
//                }
//            } else {
//                if (n > 0) {
//                    queueP.add(n);
//                } else {
//                    queueN.add(-1 * n);
//                }
//            }
//        }

        // 2트 460ms

        PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> {
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);
            if (first_abs == second_abs) return o1 > o2 ? 1 : -1; // 절댓값이 같으면 음수 우선 정렬
            else return first_abs - second_abs; // 절댓값을 기준으로 정렬
        }));

        for (int i = 0; i < N; i++) {
            int request = Integer.parseInt(br.readLine());
            if (request == 0) {
                if (pq.isEmpty()) System.out.println("0");
                else System.out.println(pq.poll());
            } else {
                pq.add(request);
            }
        }

        System.out.println(sb);


    }
}
