// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.*;


public class Main {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);    //System.in is a standard input stream
        System.out.print("Enter number of rows- ");
        int row= sc.nextInt();
        System.out.print("Enter number of columns- ");
        int col= sc.nextInt();

        int [][]arr=new int[row][col];

        for(int i=0;i<row;i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = 0;
            }
        }


        for(int i=0;i<row;i++)
        {
            for (int j=0;j<col;j++)
            {
                System.out.print(arr[i][j] +" ");
            }
            System.out.println();
        }
        int [][]drones=new int [4][4];
        for(int i=0;i<4;i++)
        {
            System.out.print("Enter Coordinates x&y: ");
            for(int j=0;j<2;j++)
            {

                drones[i][j]=sc.nextInt();

            }
        }
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<2;j++)
            {
                System.out.print(drones[i][j]+" ");
            }
            System.out.println();
        }

        for(int i=0;i<4;i++) {
            for (int j = 0; j < 2; j++) {
                int a=drones[i][0];
                int b=drones[i][1];
                arr[a][b]=1;
            }
        }
        for(int i=0;i<row;i++)
        {
            for (int j=0;j<col;j++)
            {
                System.out.print(arr[i][j] +" ");
            }
            System.out.println();
        }




        System.out.print("Enter target values a & b: ");
        int xt=sc.nextInt();
        int yt=sc.nextInt();

//        int x1,y1,x2,y2,x3,y3,x4,y4;
//        int target_X,target_Y;
        for(int a=0;a<drones.length;a++)
        {
                int i=drones[a][0];
                int j=drones[a][1];
                int[] d=drones[i];
                List<int[]>finalpath=new ArrayList<>();
                pathFinder(arr,d,xt,yt,finalpath);
                System.out.println("From Drone" + (i+1) +"path to our target" + finalpath);

        }
    }

    private static boolean pathFinder(int[][]arr,int[] current,int xt,int yt,List<int[]>path){

        int i=current[0];
        int j=current[1];
        if(i<0 || i>=arr.length || j<0 || j>=arr[0].length || arr[i][j]==1 )
        {
            return false;
        }

        path.add(current);

        if(i==xt && j==yt)
        {
            return true;
        }

        arr[i][j]=1;

        if(pathFinder(arr,new int[]{i+1,j},xt,yt,path) || pathFinder(arr,new int[]{i,j+1},xt,yt,path)
            || pathFinder(arr,new int[]{i+1,j+1},xt,yt,path) || pathFinder(arr,new int[]{i-1,j},xt,yt,path) ||
                pathFinder(arr,new int[]{i,j-1},xt,yt,path) || pathFinder(arr,new int[]{i-1,j-1},xt,yt,path))
        {
            return true;

        }
        arr[i][j]=0;

        path.remove(path.size()-1);
        return false;



    }
}
