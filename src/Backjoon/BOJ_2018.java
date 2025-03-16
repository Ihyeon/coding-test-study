package Backjoon;

import java.io.*;

// 투 포인터

// 투 포인터 이동 원칙
// sum > N: sum = sum - start_index; start_index++;
// sum < N: end_index++; sum = sum + end_index;
// sum == N: end_index++; sum = sum + end_index; count++;

public class BOJ_2018 {

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
