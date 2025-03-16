package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 투 포인트 이동 원칙
// A[i] + A[j] > M: j--;
// A[i] + A[j] < M: i++;
// A[i] + A[j] == M: i++; j--; count++;

public class BOJ_1940 {

    public static void main(String[] args) throws IOException {

        // 1트 332ms O(n^2)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 재료의 개수
        int M = Integer.parseInt(br.readLine()); // 갑옷이 완성되는 번호의 합

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N]; // 재료들

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int count = 0;
//        for (int i = 0; i < N - 1; i++) {
//            for (int j = i + 1; j < N; j++) {
//                if (arr[i] + arr[j] == M) {
//                    answer++; break;
//                }
//            }
//        }
//        System.out.println(count);
        
        // 2트 168ms O(n log n)
        int i = 0;
        int j = N - 1;
        while (i < j) {
            if (arr[i] + arr[j] < M) {
                i++;
            } else if (arr[i] + arr[j] > M) {
                j--;
            } else {
                count++;
                i++;
                j--;
            }
        }
        System.out.println(count);

    }
}
