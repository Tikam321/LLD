package MachineCodingRound.InMemoryKeyValueStore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryKeyValueStoreDemo {
    public static void main(String[] args) {
        KeyValueStorePair keyValueStorePair = new KeyValueStorePair();
        List<Pair<String, String>> list = new ArrayList<>();
        Pair<String,String> attribute = new Pair<>("key1", "123");
        Pair<String,String> attribute1 = new Pair<>("key2", "false");
        list.add(attribute);
        list.add(attribute1);
        keyValueStorePair.put("a",list);
        System.out.println(keyValueStorePair.get("a"));

        // for next key value pair
        Pair<String,String> attribute3 = new Pair<>("key1", "56756");

        keyValueStorePair.put("b", Collections.singletonList(attribute3));
        System.out.println(keyValueStorePair.keys());
        System.out.println(keyValueStorePair.get("b"));
        System.out.println(keyValueStorePair.search("key1", "123"));

    }
}
