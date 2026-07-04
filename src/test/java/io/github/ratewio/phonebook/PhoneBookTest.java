package io.github.ratewio.phonebook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {
    PhoneBook book;

    @BeforeEach
    public void initialBook(){
        book = new PhoneBook();
    }


    @ParameterizedTest
    @CsvSource({
            "Julia, 12345678901",
            "Antony, 10987654321",
            "Josh, 101010101010"
    })
    public void testAddDifferent(String name, long phoneNumber) {
        assertEquals(1, book.add(name, phoneNumber));
    }

    @ParameterizedTest
    @CsvSource({
            "Jef, 12777666555",
            "Max, 10002000300",
            "Max, 10002000300",
            "Jef, 12777666555",
            "Jef, 12777666555",
            "Max, 10002000300",
            "Max, 10002000300",
            "Jef, 12777666555"
    })
    public void testAddSame(String name, long phoneNumber) {
        assertEquals(1, book.add(name, phoneNumber));
    }
}