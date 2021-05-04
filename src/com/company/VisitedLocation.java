package com.company;

import java.util.*;

/*
# Suppose that once per minute, a user is "snapped" to the nearest place.
# We want to detect visits from these snaps.
#
# Given a list of place IDs representing a history of snaps, return a list
# of IDs of places visited in the same order.
#
# Rules:
#  - use a 4 minute sliding window
#  - if 3 out of last 4 snaps are the same ID, a visit begins
#  - a visit ends when 3 out of 4 are NOT the current ID
# Examples:
#  [A A B A] => [A]
#  [A A A A A A A A B B A A A] => [A]
#  [A A B B A A] => []
#  [A A A B C B A A A] => [A A]
#  [A A A B C B B A B] => [A B]
#  [A A B A B B] => [A B]
#
#  def detect_visits(snaps):
*/
public class VisitedLocation {

    public static void main(String[] args) {
        System.out.println(detectVisits(Arrays.asList("A A B A".split(" "))));
        System.out.println(detectVisits(Arrays.asList("A A A A A A A A B A A A".split(" "))));
        System.out.println(detectVisits(Arrays.asList("A A B B A A".split(" "))));
        System.out.println(detectVisits(Arrays.asList("A A A B C B A A A".split(" "))));
        System.out.println(detectVisits(Arrays.asList("A A A B C B B A B".split(" "))));
        System.out.println(detectVisits(Arrays.asList("A A B A B B".split(" "))));
    }


    public static List<String> detectVisits(List<String> locations) {
        //Use a sliding window of 4 locations every time
        //If any location has occurred at least 3 times, mark that as visit begins
        //If the visit ends, add the visit to the result
        //If by the end of the locations array, if visit has not ended, add that visit to the result
        List<String> result = new ArrayList<>();
        int index = 0;
        int window = locations.size() < 4 ? locations.size()-1 : 3;
        Map<String, Integer> counter;
        String currentVisit = null;

        while (window < locations.size()) {
            counter = new HashMap<>();
            for(int i=index; i<=window; i++) {
             counter.put(locations.get(i), counter.getOrDefault(locations.get(i), 0) + 1);
            }

            String max_key = Collections.max(counter.entrySet(), Map.Entry.comparingByValue()).getKey();

            if(counter.get(max_key) >= 3) {
                if(currentVisit == null) {
                    currentVisit = max_key;
                }
                else if(!currentVisit.equals(max_key)) {
                    result.add(currentVisit);
                    currentVisit = max_key;
                }else if(currentVisit.equals(max_key)) {
                    //nothing to do here
                }
            }
            else if(counter.get(max_key) < 3) {
                if(currentVisit != null) {
                    result.add(currentVisit);
                }
                currentVisit = null;
            }
            index++;
            window++;
        }
        if(currentVisit != null) {
            result.add(currentVisit);
        }
        return result;
    }

}
