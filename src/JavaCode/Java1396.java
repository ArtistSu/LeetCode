package JavaCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Java1396 {
    /**
     * @topic Design Underground System
     * @author ArtistS
     */
    Map<Integer, String> checkInRecord;
    Map<String, List<String>> travelRecord;

    public Java1396() {
        checkInRecord = new HashMap<>();
        travelRecord = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInRecord.put(id, stationName + " " + t);
    }

    public void checkOut(int id, String stationName, int t) {
        String checkInStationName;
        int checkInTime;
        String endTravel;
        String detalis;
        if(checkInRecord.containsKey(id)){
            String[] record = checkInRecord.get(id).split(" ");
            checkInStationName = record[0];
            checkInTime = Integer.parseInt(record[1]);
            endTravel = checkInStationName + " " + stationName;
            detalis = id + " " + (t - checkInTime);
            if(travelRecord.containsKey(endTravel)){
                travelRecord.get(endTravel).add(detalis);
            }else{
                List<String> newTravelRecord = new ArrayList<String>();
                newTravelRecord.add(detalis);
                travelRecord.put(endTravel, newTravelRecord);
            }
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        String travelName = startStation + " " + endStation;
        if(travelRecord.containsKey(travelName)){
            List<String> idAndTime = travelRecord.get(travelName);
            int numsPassenger = idAndTime.size();
            int totalTime = 0;
            for(String s : idAndTime){
                int time = Integer.parseInt(s.split(" ")[1]);
                totalTime = totalTime + time;
            }
            return totalTime / numsPassenger;
        }
        return 0;
    }

    public static void main(String[] args) {
        Java1396 undergroundSystem = new Java1396();
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);  // Customer 45 "Leyton" -> "Waterloo" in 15-3 = 12
        undergroundSystem.checkOut(27, "Waterloo", 20);  // Customer 27 "Leyton" -> "Waterloo" in 20-10 = 10
        undergroundSystem.checkOut(32, "Cambridge", 22); // Customer 32 "Paradise" -> "Cambridge" in 22-8 = 14
        undergroundSystem.getAverageTime("Paradise", "Cambridge"); // return 14.00000. One trip "Paradise" -> "Cambridge", (14) / 1 = 14
        undergroundSystem.getAverageTime("Leyton", "Waterloo");    // return 11.00000. Two trips "Leyton" -> "Waterloo", (10 + 12) / 2 = 11
        undergroundSystem.checkIn(10, "Leyton", 24);
        undergroundSystem.getAverageTime("Leyton", "Waterloo");    // return 11.00000
        undergroundSystem.checkOut(10, "Waterloo", 38);  // Customer 10 "Leyton" -> "Waterloo" in 38-24 = 14
        undergroundSystem.getAverageTime("Leyton", "Waterloo");    // return 12.00000. Three trips "Leyton" -> "Waterloo", (10 + 12 + 14) / 3 = 12
    }
}
