* The key-value store will be in-memory and does not require access to the file system.
* The key will always be a string.
* The value would be an object/map. The object would have attributes and corresponding values.
* Example => "sde_bootcamp": { "title": "SDE-Bootcamp", "price": 30000.00, "enrolled": false, "estimated_time": 30 }
* Each attribute key would be a string and the attribute values could be string, integer, double or boolean.
* The key-value store should be thread-safe.
* The Key-Value store should expose the following functions:
* get(String key) => Should return the value (object with attributes and their values). Return null if key not present
* search(String attributeKey, String attributeValue) => Returns a list of keys that have the given attribute key, value pair.
* put(String key, List<Pair<String, String>> listOfAttributePairs) => Adds the key and the attributes to the key-value store. If the key already exists then the value is replaced.
* delete(String key) => Deletes the key, value pair from the store.
* keys() => Return a list of all the keys
* The value object should override the toString method to print the object as a comma-separated list of key-value pairs for the attributes.
* Example: attribute1: attribute_value_1, attribute2: attribute_value_2, attribute3: attribute_value_3
* The data type of an attribute should get fixed after its first occurrence. Example: Once we encounter an attribute age with an integer value then any entry with an age attribute having a non-integer value should result in an exception.
* Nothing should be printed inside any of these methods. All scanning and printing should happen in the Driver/Main class only. Exception Handling should also happen in the Driver/Main class.
