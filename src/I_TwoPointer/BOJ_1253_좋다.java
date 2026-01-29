package I_TwoPointer;

// 💛 투 포인터 알고리즘

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [백준] 좋다
 * [Link] https://www.acmicpc.net/problem/1253
 * @level Gold 4
 * @score 164 ms / 14844 KB
 * @date 2025-03-17
 */

public class BOJ_1253_좋다 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        // 1트 156ms
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int answer = 0;
        for (int k = 0; k < N; k++) {
            long find = arr[k];
            int i = 0;
            int j = N - 1;
            while (i < j) {
                if (arr[i] + arr[j] == find) {
                    if (i != k && j != k) {
                        answer++;
                        break;
                    } else if (i == k) {
                        i++;
                    } else if (j == k) {
                        j--;
                    }
                } else if (arr[i] + arr[j] < find) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        System.out.println(answer);


    }

}

