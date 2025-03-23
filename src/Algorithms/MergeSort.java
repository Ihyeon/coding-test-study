package Algorithms;

import java.util.Arrays;

/**
 * Merge Sort (병합 정렬)
 * - 주어진 배열을 오름차순으로 정렬
 * - 구성: 분할(Divide) → 정복(Conquer) → 병합(Merge) 의 3단계
 * - 시간 복잡도: O(n log n)
 * - 공간 복잡도: O(n) (추가 배열 사용)
 * - 특징:
 *   - 안정 정렬 (Stable Sort)
 *   - 입력 크기가 크거나, 안정성이 필요한 정렬에 적합
 * - 적용 예시: 대용량 정렬, 외부 정렬(디스크 기반), LinkedList 정렬 등
 */

public class MergeSort {

    // 배열을 분할하여 정렬하는 재귀 메서드
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }

        // 분할
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);

        // 정복
        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    // 두 개의 정렬된 배열(left, right)을 병합하여 하나로 합침
    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < left.length) {
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    public static void main(String[] args) {

        int[] arr = {38, 27, 43, 3, 9, 82, 10};

        MergeSort.mergeSort(arr);
        System.out.println("정렬된 배열:" + Arrays.toString(arr));

    }

}
