
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Playlists {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String[] input = rd.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        long[] arr = new long[n];
        input = rd.readLine().split(" ");
        for(int i=0; i<n; i++){
            arr[i] = Long.parseLong(input[i]);
        }
        Set<Long> set = new HashSet<>();
        int res = 0;
        int i = 0;
        int j = 0;
        while(i<n){
            while (set.contains(arr[i])){
                set.remove(arr[j]);
                j++;
            }
            set.add(arr[i]);
            res = Math.max(res,i-j+1);
            i++;
        }
        System.out.println(res);
    }
}
