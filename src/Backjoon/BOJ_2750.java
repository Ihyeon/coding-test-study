package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_2750 {

    // N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

    public static void main(String[] args) throws IOException {

        long startTime = System.currentTimeMillis();

        // 1. Scanner + 버블 정렬
        // 292ms
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int[] arr = new int[N];
//
//        for (int i = 0; i < N; i++) {
//            int n = sc.nextInt();
//            arr[i] = n;
//        }
//
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = 0; j < arr.length - 1 - i; j++) {
//                if (arr[j] > arr[j + 1]) {
//                    int temp;
//                    temp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = temp;
//                }
//            }
//        }
//
//        for(int i : arr) {
//            System.out.println(i);
//        }
        
        // 2. BufferedReader, StringTokenizer + PriorityQueue
        // 192ms

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//
//        int n = Integer.parseInt(br.readLine());
//
//        for (int i = 1; i <= n ; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            pq.add(Integer.parseInt(st.nextToken()));
//        }
//
//        while (!pq.isEmpty()) {
//            System.out.println(pq.poll());
//        }


        // 3. BufferedReader + Arrays.sort() + StringBuilder
        // 112ms

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for(int i : arr) {
            sb.append(i).append("\n");
        }
        System.out.print(sb.toString());


        long endTime = System.currentTimeMillis();
        System.out.println("실행 시간: " + (endTime - startTime) + " ms");

    }
}
