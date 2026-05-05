package DSA.Array.Easy;

import java.io.*;
import java.util.*;
public class RoomAllocation {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<int[]> rooms = new ArrayList<>();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            rooms.add(new int[]{a,b,i});
        }
        int[] res = new int[n];
        int roomCount = 0;
        rooms.sort((a,b)->Integer.compare(a[0],b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        for(int[] room:rooms){
            if(!pq.isEmpty() && pq.peek()[0]<room[0]){
                int idx = room[2];
                int[] curr = pq.poll();
                res[idx] = curr[1];
                pq.offer(new int[]{room[1],curr[1]});
            }else{
                roomCount++;
                res[room[2]] = roomCount;
                pq.offer(new int[]{room[1],roomCount});
            }
        }
        System.out.println(roomCount);
        for(int i=0; i<n; i++) System.out.print(res[i]+" ");
    }
}
