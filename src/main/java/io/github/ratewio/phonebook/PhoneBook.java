package io.github.ratewio.phonebook;


import it.unimi.dsi.fastutil.longs.Long2ObjectArrayMap;

public class PhoneBook {
    Long2ObjectArrayMap<String> phoneBook;

    public PhoneBook() {
        phoneBook = new Long2ObjectArrayMap<>();
    }

    public int add(String name, long phoneNumber) {
        phoneBook.put(phoneNumber, name);
        if (!phoneBook.containsValue(name)) {

        }
        return size();
    }

    public int size() {
        return phoneBook.size();
    }
}
