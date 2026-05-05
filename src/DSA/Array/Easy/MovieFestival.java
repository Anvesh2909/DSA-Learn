package DSA.Array.Easy;

import java.io.*;
import java.util.*;

public class MovieFestival {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<int[]> movies = new ArrayList<>();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            movies.add(new int[]{a,b});
        }
        Collections.sort(movies, (a,b)->a[1]-b[1]);
        int count = 0;
        int prev = Integer.MIN_VALUE;
        for(int[] movie: movies){
            if(movie[0]>=prev){
                count++;
                prev = movie[1];
            }
        }
        System.out.println(count);
    }
}
