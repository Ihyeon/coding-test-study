package A_Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [백준] 숫자의 합
 * [Link] https://www.acmicpc.net/problem/11720
 * @level Bronze 4
 * @score 104 ms / 14188 KB
 * @date 2025-03-12
 */

public class BOJ_11720_숫자의합 {

    // N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.

    public static void main(String[] args) throws IOException {

        long startTime = System.currentTimeMillis();

        // BufferedReader: 한 줄 읽은 후 가공
        // 104ms

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        String str = br.readLine();

        for (int i = 0; i < N; i++) {
            answer += (str.charAt(i) - '0');
        }

        System.out.println(answer);


        long endTime = System.currentTimeMillis();
        System.out.println("실행 시간: " + (endTime - startTime) + " ms");

    }

}
