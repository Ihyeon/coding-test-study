package B_DataStructure;

// 큐

/**
 * [백준] 카드2
 * [Link] https://www.acmicpc.net/problem/2164
 * @level Silver 4
 * @score 164 ms / 45540 KB
 * @date 2025-03-22
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2164_카드2 {

    public static void main(String[] args) throws IOException {

        // 162ms

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while (queue.size() > 1) {
                queue.remove();
                queue.add(queue.poll());
        }

        System.out.println(queue.poll());

    }
}
