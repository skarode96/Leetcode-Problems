package array.turbulent;

public class LargestTurbulentArray {

    public static int findLargestTurbulentArrayLength(int[] A) {
        int maxTurbulentLength = 0;
        if (A.length <= 2) {
            return maxTurbulentLength;
        }
        int turbulentLength = 0;
        for (int i = 1; i < A.length - 1; i++) {
            if(Integer.compare(A[i-1], A[i]) * Integer.compare(A[i], A[i+1]) == -1) {
                turbulentLength += 1;
                maxTurbulentLength = Integer.max(turbulentLength, maxTurbulentLength);
            } else {
                turbulentLength = 0;
            }
        }
        return maxTurbulentLength > 0 ? maxTurbulentLength + 2 : maxTurbulentLength ;
    }
}
