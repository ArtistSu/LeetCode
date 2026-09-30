package JavaCook;

import java.util.*;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms.isEmpty()) return true;
        if (rooms.get(0).isEmpty()) return false;

        Set<Integer> unlockRooms = new HashSet<>();
        Deque<Integer> keys = new ArrayDeque<>();
        unlockRooms.add(0);
        for (int key : rooms.get(0)) {
            keys.offer(key);
        }

        // Open rooms
        while (!keys.isEmpty()) {
            int currKey = keys.pollFirst();
            for (int key : rooms.get(currKey)) {
                // If already open the door, no need to open again otherwise will cause infinite loop
                if (!unlockRooms.contains(key)) {
                    keys.offer(key);
                }
            }
            unlockRooms.add(currKey);
        }

        return rooms.size() == unlockRooms.size();
    }

    public boolean canVisitAllRooms_google_l5(List<List<Integer>> rooms) {
        if (rooms == null || rooms.isEmpty()) return true;

        final int totalRooms = rooms.size();
        boolean[] visited = new boolean[totalRooms];
        Deque<Integer> readyUnlockRooms = new ArrayDeque<>();
        visited[0] = true;
        readyUnlockRooms.offer(0);
        int visitedCount = 1;

        while (!readyUnlockRooms.isEmpty()) {
            int currRoom = readyUnlockRooms.poll();

            for (int key : rooms.get(currRoom)) {
                if (key >= 0 && key <= totalRooms && !visited[key]) {
                    visited[key] = true;
                    visitedCount++;

                    if (totalRooms == visitedCount) return true;

                    readyUnlockRooms.offer(key);
                }
            }
        }
        return totalRooms == visitedCount;
    }

    /**
     * DFS
     */
    public boolean canVisitAllRooms_google_l5_2(List<List<Integer>> rooms) {
        if(rooms == null || rooms.isEmpty()) return true;

        final int totalRooms = rooms.size();
        boolean[] visited = new boolean[totalRooms];
        // You need to know why here we are using int[] rather than int
        int[] visitedCount = new int[]{0};

        dfs(rooms,0,visited,visitedCount);

        return visitedCount[0] == totalRooms;

    }

    private void dfs(List<List<Integer>> rooms,int room,boolean[] visited,int[] visitedCount){
        visited[room] = true;
        visitedCount[0]++;

        // Pruning Optimization -> you can return the val in advance
        if (visitedCount[0] == rooms.size()) {
            return;
        }

        for(int key : rooms.get(room)){
            if(key >=0 && key <= rooms.size() && !visited[key]){
                dfs(rooms,key,visited,visitedCount);

                if (visitedCount[0] == rooms.size()) {
                    return;
                }
            }
        }
    }
}