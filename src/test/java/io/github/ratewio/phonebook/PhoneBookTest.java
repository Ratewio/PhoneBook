package io.github.ratewio.phonebook;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PhoneBookTest {
    static PhoneBook book;

    @BeforeAll
    public static void initialBook() {
        book = new PhoneBook();
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
            int expectedSize = book.size() + 1;
            int afterAddSize = book.add(names[i], numbers[i]);
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
            book.add(names[i], numbers[i]);
        }

        //test second time adding
        for (int i = 0; i != numbers.length; ++i) {
            int expectedSize = book.size(); //must be no changes
            int afterAddSize = book.add(names[i], numbers[i]);
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

        for (int i = 0; i != numbers.length; ++i) {
            assertEquals(names[i], book.findByNumber(numbers[i]));
        }
    }
}