package MachineCodingRound.InMemoryKeyValueStore;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
The Key-Value store should expose the following functions:
get(String key) => Should return the value (object with attributes and their values). Return null if key not present
search(String attributeKey, String attributeValue) => Returns a list of keys that have the given attribute key, value pair.
put(String key, List<Pair<String, String>> listOfAttributePairs) => Adds the key and the attributes to the key-value store.
If the key already exists then the value is replaced.
delete(String key) => Deletes the key, value pair from the store.
keys() => Return a list of all the keys
* */
public class KeyValueStorePair {
    private final ConcurrentHashMap<String, ValueObject> store;
    private final ConcurrentHashMap<String, Class<?>> attributeDataType;
    private final ReentrantReadWriteLock lock;

    public KeyValueStorePair() {
        store = new ConcurrentHashMap<>();
        lock = new ReentrantReadWriteLock();
        this.attributeDataType = new ConcurrentHashMap<>();
    }

    public String get(String key) {
        lock.readLock().lock();
        try {
            if (store.containsKey(key)) {
                return store.get(key).toString();
            }
        } finally {
            lock.readLock().unlock();
        }
        return null;
    }

    public List<String> search(String attributeKey, String attributeValue) {
        List<String> keys = new ArrayList<>();
        for(Map.Entry<String, ValueObject> mp: store.entrySet()) {
            Object value = mp.getValue().getValueObject().get(attributeKey);
            if (value != null && value.toString().equals(attributeValue)) {
                keys.add(mp.getKey());
            }
        }
        return keys;
    }

    public void put(String key, List<Pair<String, String>> attributePairs) {
        lock.writeLock().lock();
        try {
            ValueObject valueObject = new ValueObject();
            for(Pair<String, String> attribute:attributePairs) {
                String attributeKey = attribute.getKey();
                String attributeValue = attribute.getValue();
                Class<?> attributeType = attributeDataType.get(attributeKey);
                Object getParsedValue = getParsedValue(attributeType, attributeValue);

                if (attributeType == null) {
                    attributeDataType.put(attributeKey, getParsedValue.getClass());
                }
//                isAttributeMismatch(attributeKey, getParsedValue);
                valueObject.putAttributes(attributeKey,getParsedValue);
            }
            store.put(key, valueObject);
        } finally {
            lock.writeLock().unlock();
        }
    }

    private Object getParsedValue(Class<?> attributeType, String attributeValue) {
        try {
            if (attributeType == null) {
                return inferredValue(attributeValue);
            }
            if (attributeType == Integer.class) {
                return Integer.parseInt(attributeValue);
            } else if (attributeType == Double.class) {
                return Double.parseDouble(attributeValue);
            } else if (attributeType == Boolean.class) return Boolean.parseBoolean(attributeValue);

            return attributeValue;
        } catch (Exception e) {
            throw new IllegalArgumentException("Type mismatch for value " + attributeValue);
        }
    }

    private Object inferredValue(String attributeValue) {
        if (attributeValue.equalsIgnoreCase("true") || attributeValue.equalsIgnoreCase("false")) {
            return Boolean.parseBoolean(attributeValue);
        }
        try{
            return Integer.parseInt(attributeValue);
        } catch (NumberFormatException e) {}
        try{
            return Double.parseDouble(attributeValue);
        } catch (NumberFormatException e) {}
        return attributeValue;
    }

    public void delete(String key) {
        lock.writeLock().lock();
        try {
            store.remove(key);
        }
        finally {
            lock.writeLock().unlock();
        }
    }

    public List<String> keys() {
        lock.readLock().lock();
        try {
            return store.keySet().stream().toList();
        }
        finally {
            lock.readLock().unlock();
        }
    }

}
