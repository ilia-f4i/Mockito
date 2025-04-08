package ru.netology;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FilmManagerTest {

    @Test
    void shouldShowAllFilmsInOrder() {
        FilmManager manager = new FilmManager();
        manager.add("Бладшот боевик");
        manager.add("Вперёд мультфильм");
        manager.add("Отель «Белград» комедия");
        manager.add("Джентльмены боевик");
        manager.add("Человек-невидимка ужасы");
        manager.add("Тролли. Мировой тур мультфильм");
        manager.add("Номер один комедия");

        String[] expected = {
                "Бладшот боевик",
                "Вперёд мультфильм",
                "Отель «Белград» комедия",
                "Джентльмены боевик",
                "Человек-невидимка ужасы",
                "Тролли. Мировой тур мультфильм",
                "Номер один комедия"
        };

        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    void shouldShowLast5FilmsByDefault() {
        FilmManager manager = new FilmManager();
        manager.add("Бладшот боевик");
        manager.add("Вперёд мультфильм");
        manager.add("Отель «Белград» комедия");
        manager.add("Джентльмены боевик");
        manager.add("Человек-невидимка ужасы");
        manager.add("Тролли. Мировой тур мультфильм");
        manager.add("Номер один комедия");

        String[] expected = {
                "Номер один комедия",
                "Тролли. Мировой тур мультфильм",
                "Человек-невидимка ужасы",
                "Джентльмены боевик",
                "Отель «Белград» комедия"
        };

        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    void shouldShowLast3FilmsWithCustomLimit() {
        FilmManager manager = new FilmManager(3);
        manager.add("Бладшот боевик");
        manager.add("Вперёд мультфильм");
        manager.add("Отель «Белград» комедия");
        manager.add("Джентльмены боевик");
        manager.add("Человек-невидимка ужасы");
        manager.add("Тролли. Мировой тур мультфильм");
        manager.add("Номер один комедия");

        String[] expected = {
                "Номер один комедия",
                "Тролли. Мировой тур мультфильм",
                "Человек-невидимка ужасы"
        };

        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    void shouldHandleLessFilmsThanLimit() {
        FilmManager manager = new FilmManager(10);
        manager.add("Бладшот боевик");
        manager.add("Вперёд мультфильм");
        manager.add("Отель «Белград» комедия");

        String[] expected = {
                "Отель «Белград» комедия",
                "Вперёд мультфильм",
                "Бладшот боевик"
        };

        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    void shouldHandleEmptyList() {
        FilmManager manager = new FilmManager();
        assertArrayEquals(new String[0], manager.findLast());
    }
}