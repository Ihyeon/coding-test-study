package Backjoon;

// 모노토닉 스택 (Monotonic Stack)
// 원소가 단조(monotonic)하게 정렬된 상태를 유지하는 스택
// 항상 오름차순이거나 항상 내림차순인 값만 담기도록 스택을 조작하는 방식


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_17298 {

    public static void main(String[] args) throws IOException {

        // 단조 감소 스택
        // 오큰수(NGE) 구하기, O(N), 912ms

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N]; // 주어진 수열을 담을 배열
        int[] answer = new int[N]; // 오큰수를 담을 배열

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                answer[stack.pop()] = arr[i];
            }
            stack.add(i);
        }

        while(!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        for (int i = 0; i < N; i++) {
            sb.append(answer[i]).append(" ");
        }
       
        System.out.println(sb);

    }

}
