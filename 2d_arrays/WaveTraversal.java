public class WaveTraversal {
    public static void main(String[] args) {

        int[][] arr = {
            {11, 12, 13, 14},
            {21, 22, 23, 24},
            {31, 32, 33, 34}, 
        };

        int k = 0;

        for(int i= 0; i< arr[0].length; i++){
            if(k == 0){ // we can also do if (i % 2 == 0)
                for(int j = 0; j<arr.length; j++){
                    System.out.println(arr[j][i]);
                    k = j;
                }
            } else { 
                for(int j = arr.length-1; j>=0; j--){
                    System.out.println(arr[j][i]);
                    k = j;
                }
            }
        }

       
    }
}