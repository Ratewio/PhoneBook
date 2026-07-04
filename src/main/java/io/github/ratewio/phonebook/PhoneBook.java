package io.github.ratewio.phonebook;


import it.unimi.dsi.fastutil.longs.Long2ObjectArrayMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;


public class PhoneBook {
    private Long2ObjectArrayMap<String> numbersToNames;

    public PhoneBook() {
        numbersToNames = new Long2ObjectArrayMap<>();
    }

    public int add(String name, long phoneNumber) {
        if (!numbersToNames.containsValue(name)) {
            numbersToNames.put(phoneNumber, name);
        }
        return size();
    }

    public String findByNumber(long phoneNumber) {
        return numbersToNames.get(phoneNumber);
    }

    public long findByName(String name) {
        for (Long2ObjectMap.Entry<String> entry : numbersToNames.long2ObjectEntrySet()) {
            if (name.equals(entry.getValue())) {
                return entry.getLongKey();
            }
        }
        return -1L;
    }

    public String printAllNames() {
        StringBuilder sb = new StringBuilder();
        numbersToNames.values().stream().sorted().forEach(name -> sb.append(name).append('\n'));
        String out = sb.toString();
        System.out.printf(out);
        return out;
    }

    public int size() {
        return numbersToNames.size();
    }
}
