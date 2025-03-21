package Backjoon;

// 스택

import java.io.*;
import java.util.Stack;

public class BOJ_1874 {
    
    public static void main(String[] args) throws IOException {

        // 312ms

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine()); // 수열의 개수

        int[] arr = new int[n]; // 만들어야 하는 임의의 수열
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stak = new Stack<>();

        int idx = 0;
        int num = 1;

        while (idx < n) {
            if (!stak.isEmpty() && stak.peek() == arr[idx]) {
                stak.pop();
                idx++;
                sb.append("-").append("\n");
            } else if (num <= n) {
                stak.push(num++);
                sb.append("+").append("\n");
            } else {
                System.out.println("NO");
                return;
            }
        }

        System.out.println(sb);
    }
}
