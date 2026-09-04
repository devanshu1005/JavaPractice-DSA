public class MatrixMultiplication {
    public static void main(String[] args) {

        int[][] arr1 = {
            // {1, 2, 3},
            // {4, 5, 6}
            {10, 0, 0},
            {0, 1, 20}
        };

        int[][] arr2 = {
            // {7, 8},
            // {9, 10},
            // {11, 12}
            {10, 1, 1, 1},
            {20, 1, 1, 1},
            {3, 2, 0, 30}
        };

        int[][] arrAns = new int[arr1.length][arr2[0].length];

        // Display first matrix
        // System.out.println("Matrix 1:");

        // for(int i = 0; i < arr1.length; i++) {
        //     for(int j = 0; j < arr1[i].length; j++) {
        //         System.out.print(arr1[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        // Display second matrix
        // System.out.println("Matrix 2:");

        // for(int i = 0; i < arr2.length; i++) {
        //     for(int j = 0; j < arr2[i].length; j++) {
        //         System.out.print(arr2[i][j] + " ");
        //     }
        //     System.out.println();
        // }


        // check if division is possible or not

        if(arr1[0].length == arr2.length){

            for(int i = 0; i< arr1.length; i++){
                for(int j = 0; j< arr2[0].length; j++){
                    for(int k = 0; k< arr1[0].length; k++){
                        arrAns[i][j] = arrAns[i][j] + arr1[i][k] * arr2[k][j];
                    }
                }
            }

        for(int i = 0; i < arrAns.length; i++) {
            for(int j = 0; j < arrAns[i].length; j++) {
                System.out.print(arrAns[i][j] + " ");
            }
            System.out.println();
        }
           
        } else {
            System.out.println("Multiplication of matrix is not possible");
        }

       
    }
}