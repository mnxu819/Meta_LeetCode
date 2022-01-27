Design a time-based key-value data structure that can store multiple values for the same key at different time stamps and retrieve the key's value at a certain timestamp.
All the timestamps timestamp of set are strictly increasing.
  
class Data {
    String val;
    int time;
    public Data(String val, int time) {
        this.val = val;
        this.time = time;
    }
}
class TimeMap {
    Map<String, List<Data>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<Data>());
        } 
        map.get(key).add(new Data(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        List<Data> dataList = map.get(key);
        int start = 0;
        int end = dataList.size()-1;
        while (start + 1 < end) {
            int mid = start + (end-start)/2;
            if (dataList.get(mid).time == timestamp) {
                return dataList.get(mid).val;
            } else if (dataList.get(mid).time < timestamp) {
                start = mid;
            } else 
                end = mid;
        }
        if (dataList.get(end).time <= timestamp) {
            return dataList.get(end).val;
        } else if (dataList.get(start).time <= timestamp) {
            return dataList.get(start).val;
        } else 
            return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
