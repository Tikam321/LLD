package MachineCodingRound.InMemoryKeyValueStore;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ValueObject {
    private final ConcurrentHashMap<String, Object> valueObject;

    public ValueObject() {
        valueObject = new ConcurrentHashMap<>();
    }

    public void putAttributes(String key, Object value) {
        valueObject.put(key, value);
    }

    public Object getAttributes(String key) {
        return valueObject.get(key);
    }

    public ConcurrentHashMap<String, Object> getValueObject() {
        return valueObject;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(Map.Entry<String,Object> mp:valueObject.entrySet()) {
            builder.append(mp.getKey()).append(": ").append(mp.getValue().toString()).append(", ");
        }
        if (builder.length() > 0) {
            builder.setLength(builder.length() - 2); // remove trailing comma
        }
        return builder.toString();
    }

}
