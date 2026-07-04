package io.github.ratewio.phonebook;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PhoneBookTest {
    PhoneBook book;

    @BeforeEach
    public void initialBook() {
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

        //adding names first
        for (int i = 0; i != numbers.length; ++i) {
            book.add(names[i], numbers[i]);
        }

        for (int i = 0; i != numbers.length; ++i) {
            assertEquals(names[i], book.findByNumber(numbers[i]));
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
            book.add(names[i], numbers[i]);
        }

        for (int i = 0; i != numbers.length; ++i) {
            assertEquals(numbers[i], book.findByName(names[i]));
        }
    }

    @Test
    public void testPrintNames() {
        book.add("Georgy", 12131233242L);
        book.add("Ostin", 12313132134L);
        book.add("Anatoly", 7878787872L);

        String s = book.printAllNames();
        String[] names = s.split("\n");

        assertEquals("Anatoly", names[0]);
        assertEquals("Ostin", names[1]);
        assertEquals("Georgy", names[2]);
    }

}