package io.github.ratewio.phonebook;


import it.unimi.dsi.fastutil.longs.Long2ObjectArrayMap;

public class PhoneBook {
    Long2ObjectArrayMap<String> phoneBook;

    public PhoneBook() {
        phoneBook = new Long2ObjectArrayMap<>();
    }

    public int add(String name, long phoneNumber) {
        if (!phoneBook.containsValue(name)) {
            phoneBook.put(phoneNumber, name);
        }
        return size();
    }

    public String findByNumber(long phoneNumber){
        return null;
    }


    public int size() {
        return phoneBook.size();
    }
}
