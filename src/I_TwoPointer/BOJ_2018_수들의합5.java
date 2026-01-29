package I_TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 투 포인터

// 투 포인터 이동 원칙
// sum > N: sum = sum - start_index; start_index++;
// sum < N: end_index++; sum = sum + end_index;
// sum == N: end_index++; sum = sum + end_index; count++;

/**
 * [백준] 수들의 합 5
 * [Link] https://www.acmicpc.net/problem/2018
 * @level Silver 5
 * @score 160 ms / 14292 KB
 * @date 2025-03-16
 */


public class BOJ_2018_수들의합5 {

    // 연속된 자연수의 합 구하기

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
       // 1트 172ms
//        int N = Integer.parseInt(br.readLine());
//        int answer = 1;
//
//        for (int i = 1; i < N; i++) {
//            int sum = 0;
//            int j = i;
//            while (sum < N) {
//                    sum += (j++);
//                if (sum == N) {
//                    answer++;
//                    break;
//                }
//            }
//        }
//        System.out.println(answer);

        // 2트 160ms
        int N = Integer.parseInt(br.readLine());
        int count = 1;
        int sum = 1;
        int start_idx = 1;
        int end_idx = 1;
        while (end_idx != N) {
            if (sum == N) {
                end_idx++;
                sum += end_idx;
                count++;
            } else if (sum > N) {
                sum -= start_idx;
                start_idx++;
            } else {
                end_idx++;
                sum += end_idx;
            }
        }
        System.out.println(count);
    }

}
