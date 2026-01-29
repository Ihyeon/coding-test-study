package D_Sort;

/**
 * Counting Sort (카운팅 정렬)
 * - 정수 데이터의 범위가 제한되어 있을 때 사용하는 매우 빠른 정렬 알고리즘
 * - 비교 기반 정렬이 아니며, O(n log n)보다 빠른 O(n) 정렬이 가능함
 * - 전제 조건: 입력 값은 정수이고, 값의 범위가 작고 양의 정수여야 함
 * - 시간 복잡도: O(n + k) (n: 데이터 개수, k: 값의 범위)
 * - 공간 복잡도: O(k)
 * - 특징:
 *   1. 정렬 대상의 크기를 직접 비교하지 않고 '빈도 수'를 기반으로 정렬함
 *   2. 안정 정렬로 구현 가능 (기본 구현은 비안정 정렬)
 *   3. 빠르지만 실수, 음수, 범위 큰 경우에는 부적합
 */

public class Ex_CountingSort {

    public static int[] sort(int[] input, int max) {
        int[] count = new int[max + 1]; // 0부터 max까지의 카운트 배열
        int[] output = new int[input.length];

        // 1. Count step - 각 숫자 등장 횟수
        // 세기
        for (int num : input) {
            count[num]++;
        }

        // 2. 누적합(Cumulative sum) - 정렬 후 위치 계산 (안정 정렬용)
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // 3. Output 배열 채우기 (안정 정렬)
        for (int i = input.length - 1; i >= 0; i--) {
            int num = input[i];
            output[--count[num]] = num;
        }

        return output;
    }

    public static void main(String[] args) {
        int[] input = {4, 2, 2, 8, 3, 3, 1};
        int max = 8; // 입력 데이터 중 최댓값

        int[] sorted = sort(input, max);

        System.out.println("정렬 결과:");
        for (int x : sorted) {
            System.out.print(x + " ");
        }
    }
}
