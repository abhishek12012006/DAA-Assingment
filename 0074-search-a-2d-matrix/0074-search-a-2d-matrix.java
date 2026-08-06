class Solution {
    public boolean searchMatrix(int[][] matrix, int target){
        int m = matrix.length;
        int n = matrix[0].length;

        int sRow = 0;
        int eRow = m - 1;

        while(sRow <= eRow){
            int midRow = sRow + (eRow - sRow) / 2;

            if(target >= matrix[midRow][0] && target <= matrix[midRow][n-1]){
                int left = 0;
                int right = n - 1;

                while(left <= right){
                    int mid = left + (right - left) / 2;

                    if(matrix[midRow][mid] == target){
                        return true;
                    } else if (matrix[midRow][mid] < target){
                        left = mid + 1;
                    } else{
                        right = mid - 1;
                    }
                }
                return false;
            }

            else if(target > matrix[midRow][n-1]){
                sRow = midRow + 1;
            }

            else {
                eRow = midRow - 1;
            }
        }
        return false;
    }
}