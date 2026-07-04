package io.github.ratewio.phonebook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PhoneBookTest {
    PhoneBook phoneBook;

    @BeforeEach
    public void initialBook() {
        phoneBook = new PhoneBook();
    }

    @Test
    public void testAddDifferent() {
        long[] numbers = new long[]{
                12345678901L,
                10987654321L,
                10101010101L
        };
        String[] names = new String[]{
                "Julia",
                "Antony",
                "Josh"
        };

        for (int i = 0; i != numbers.length; ++i) {
            int expectedSize = phoneBook.size() + 1;
            int afterAddSize = phoneBook.add(names[i], numbers[i]);
            assertEquals(expectedSize, afterAddSize);
        }

    }

    @Test
    public void testAddSame() {
        long[] numbers = new long[]{
                12777666555L,
                10002000300L,
                19999999999L
        };
        String[] names = new String[]{
                "Jef",
                "Max",
                "Jonathan"
        };

        //adding names first
        for (int i = 0; i != numbers.length; ++i) {
            phoneBook.add(names[i], numbers[i]);
        }

        //test second time adding
        for (int i = 0; i != numbers.length; ++i) {
            int expectedSize = phoneBook.size(); //must be no changes
            int afterAddSize = phoneBook.add(names[i], numbers[i]);
            assertEquals(expectedSize, afterAddSize);
        }
    }

    @Test
    public void testFindByNumber() {
        long[] numbers = new long[]{
                12777666555L,
                10002000300L,
                19999999999L
        };
        String[] names = new String[]{
                "Jef",
                "Max",
                "Jonathan"
        };

        //adding names first
        for (int i = 0; i != numbers.length; ++i) {
            phoneBook.add(names[i], numbers[i]);
        }

        for (int i = 0; i != numbers.length; ++i) {
            assertEquals(names[i], phoneBook.findByNumber(numbers[i]));
        }
    }

    @Test
    public void testFindByName() {
        long[] numbers = new long[]{
                12777666555L,
                10002000300L,
                19999999999L
        };
        String[] names = new String[]{
                "Jef",
                "Max",
                "Jonathan"
        };

        //adding names first
        for (int i = 0; i != numbers.length; ++i) {
            phoneBook.add(names[i], numbers[i]);
        }

        for (int i = 0; i != numbers.length; ++i) {
            assertEquals(numbers[i], phoneBook.findByName(names[i]));
        }
    }

    @Test
    public void testPrintNames() {
        phoneBook.add("Georgy", 12131233242L);
        phoneBook.add("Ostin", 12313132134L);
        phoneBook.add("Anatoly", 7878787872L);

        String s = phoneBook.printAllNames();
        String[] names = s.split("\n");

        assertEquals("Anatoly", names[0]);
        assertEquals("Georgy", names[1]);
        assertEquals("Ostin", names[2]);
    }

}