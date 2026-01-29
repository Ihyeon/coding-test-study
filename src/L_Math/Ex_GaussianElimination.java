package L_Math;

/**
 * Gaussian Elimination (가우스 소거법)
 * - Ax = B 형태의 연립방정식을 풀 때 사용하는 기본적인 방법
 * - 구성: Partial Pivoting(부분 피벗팅) → 피벗 정규화 → 전진 소거 → 후진 대입의 4단계
 * - 시간 복잡도: O(n^3)
 * - 공간 복잡도: O(n^2)
 * - 적용 예시: 정방행렬 해 구하기, 행렬식 계산, 역행렬 구하기
 */

public class Ex_GaussianElimination {

    // 연립방정식을 푸는 메서드
    public static double[] solve(double[][] A, double[] B) {
        int N = B.length;

        // 전진 소거 (Forward Elimination)
        for (int i = 0; i < N; i++) {

            // 0. Partial Pivoting (부분 피벗팅) - 피벗이 0이거나 너무 작으면 아래 행과 교환
            // 수치적 안정성을 위해, 피벗 열에서 절댓값이 가장 큰 행을 선택
            int maxRow = i;
            for (int k = i + 1; k < N; k++) {
                if (Math.abs(A[k][i]) > Math.abs(A[maxRow][i])) {
                    maxRow = k;
                }
            }
            if (A[maxRow][i] == 0) throw new ArithmeticException("해가 유일하지 않음");

            // 행 교환
            double[] tempRow = A[i]; A[i] = A[maxRow]; A[maxRow] = tempRow;
            double tempB = B[i]; B[i] = B[maxRow]; B[maxRow] = tempB;

            // 1. 피벗 정규화 - 현재 행의 피벗을 1로 만들어줌
            double pivot = A[i][i];
            for (int j = i; j < N; j++) A[i][j] /= pivot;
            B[i] /= pivot;

            // 2. 아래 행 제거 - 피벗 열을 기준으로 아래 행을 소거 (0으로 만듦)
            for (int k = i + 1; k < N; k++) {
                double factor = A[k][i];
                for (int j = i; j < N; j++) {
                    A[k][j] -= factor * A[i][j];
                }
                B[k] -= factor * B[i];
            }
        }

        // 3. 후진 대입 (Back Substitution) - 위에서부터 해 구하기
        double[] X = new double[N];
        for (int i = N - 1; i >= 0; i--) {
            X[i] = B[i];
            for (int j = i + 1; j < N; j++) {
                X[i] -= A[i][j] * X[j];
            }
        }

        return X;
    }

    public static void main(String[] args) {
        // 예제: 2x + y = 5, 4x - 6y = -2
        double[][] A = {
                {2, 1},
                {4, -6}
        };
        double[] B = {5, -2};

        double[] result = solve(A, B);

        System.out.println("해:");
        for (double x : result) {
            System.out.printf("%.0f ", x);
        }
    }
}
