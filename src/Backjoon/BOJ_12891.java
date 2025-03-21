package Backjoon;

import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;


// 슬라이딩 윈도우

public class BOJ_12891 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] find = new int[4]; // A, C, G, T 개수를 저장할 배열
    static int[] current = new int[4]; // 현재 비밀번호의 A, C, G, T의 개수를 저장할 배열

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 임의로 만든 DNA 문자열의 길이
        int M = Integer.parseInt(st.nextToken()); // 비밀번호로 사용할 부분 문자열의 길이
        String str = br.readLine(); // 임의로 만든 DNA 문자열
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            find[i] = Integer.parseInt(st.nextToken());
        }

        // 1트 280ms
        int cnt = 0;

        for (int i = 0; i < M; i++) {
            addChar(str.charAt(i));
        }

        if(checkValid()) {
            cnt++;
        }

        for (int i = M; i < N; i++) {
            addChar(str.charAt(i));
            removeChar(str.charAt(i - M));
            if (checkValid()) {
                cnt++;
            }
        }


        System.out.println(cnt);

    }

    static void addChar (char c) {
        if (c == 'A') current[0]++;
        if (c == 'C') current[1]++;
        if (c == 'G') current[2]++;
        if (c == 'T') current[3]++;
    }

    static void removeChar (char c) {
        if (c == 'A') current[0]--;
        if (c == 'C') current[1]--;
        if (c == 'G') current[2]--;
        if (c == 'T') current[3]--;
    }

    static boolean checkValid () {
        for (int i = 0; i < 4; i++) {
            if (current[i] < find[i]) {
                return false;
            }
        }
        return true;
    }

}
