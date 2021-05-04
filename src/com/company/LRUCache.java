package com.company;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {
    LinkedHashMap<Integer, Integer> lruMap;
    int cap = 0;

    public LRUCache(int capacity) {
        lruMap = new LinkedHashMap<>(capacity);
        cap = capacity;
    }

    public int get(int key) {
        if(lruMap.containsKey(key)) {
            getAndReplace(key);
            return lruMap.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if(lruMap.containsKey(key)) {
            putAndReplace(key, key, value);
        }
        else if(cap == lruMap.size()) {
            // I want the key at index 0
            Iterator<Map.Entry<Integer, Integer>> iterator = lruMap.entrySet().iterator();
            Map.Entry<Integer, Integer> entry = iterator.next();
            int keyToRemove = entry.getKey();
            putAndReplace(keyToRemove, key, value);
        }else {
            lruMap.put(key, value);
        }
    }

    private void getAndReplace(int key) {
        int tempVal = lruMap.get(key);
        lruMap.remove(key);
        lruMap.put(key, tempVal);
    }

    public void putAndReplace(int rem, int key, int val) {
        lruMap.remove(rem);
        lruMap.put(key, val);
    }

}