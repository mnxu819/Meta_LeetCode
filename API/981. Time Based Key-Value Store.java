Design a time-based key-value data structure that can store multiple values for the same key at different time stamps 
and retrieve the key's value at a certain timestamp.
Input
["TimeMap", "set", "get", "get", "set", "get", "get"]
[[], ["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4], ["foo", 5]]
Output
[null, null, "bar", "bar", null, "bar2", "bar2"]

Explanation
TimeMap timeMap = new TimeMap();
timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
timeMap.get("foo", 1);         // return "bar"
timeMap.get("foo", 3);         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
timeMap.get("foo", 4);         // return "bar2"
timeMap.get("foo", 5);         // return "bar2"

public class Data {
    public int timestamp;
    public String value;
    public Data(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}
class TimeMap {
    private Map<String, List<Data>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());  
        } 
        map.get(key).add(new Data(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        return binarySearch(timestamp, map.get(key));
    }
    public String binarySearch(int timestamp, List<Data> list) {
        int l = 0;
        int r = list.size()-1;
        while (l+1 < r) {
            int mid = l + (r-l)/2;
        if (list.get(mid).timestamp == timestamp) {
            return list.get(mid).value;
        } else if (list.get(mid).timestamp < timestamp) {
            l = mid;
        } else 
            r = mid;
        }
        if (list.get(r).timestamp <= timestamp) {
            return list.get(r).value;
        } else if (list.get(l).timestamp <= timestamp) {
            return list.get(l).value;
        }
        return ""; 
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
