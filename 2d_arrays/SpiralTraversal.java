public class SpiralTraversal {
    public static void main(String[] args) {

        int[][] arr = {
            {11, 12, 13, 14},
            {21, 22, 23, 24},
            {31, 32, 33, 34}, 
            {41, 42, 43, 44}, 
        };

        int k = arr.length * arr[0].length;

        int b = arr.length;
        int r = arr[0].length;
        int t= 0;
        int l = 0;

        // System.out.println("k: "+k);

        while(k != 0){

           
        //top to bottom
            for(int i = t; i<b; i++){
                 if(k == 0){
                return;
            }
            System.out.println(arr[i][l]);
            k--;
            if(i == b-1){
                l++;
            }
            }

        // System.out.println("l: "+l);

       
        //left to right
            for(int i = l; i<r; i++){
                 if(k == 0){
                return;
            }
            System.out.println(arr[b-1][i]);
            k--;
            if(i == r-1){
                b--;
            }
            }

        // System.out.println("l: "+l);

      
        // bottom to top
        for(int i = b-1; i>=t; i--){
             if(k == 0){
                return;
            }
            System.out.println(arr[i][r-1]);
            k--;
            if(i == t){
                r--;
            }
        }

        // System.out.println("r: "+r);
        // System.out.println("l: "+l);
        // System.out.println("t: "+t);

      

        //right to left
        for(int i = r-1; i>=l; i--){
             if(k == 0){
                return;
            }
           System.out.println(arr[t][i]);
            k--;
            if(i == l){
                t++;
            } 
        }

        // System.out.println("k: "+k);

        }
        // System.out.println("l: "+l);
        // System.out.println("b: "+b);
        
    }
}