package ru.netology;

import java.util.Arrays;

public class FilmManager {
    private final int limit;
    private String[] films = new String[0];

    public FilmManager() {
        this.limit = 5;
    }

    public FilmManager(int limit) {
        this.limit = limit;
    }

    // Добавление фильма
    public void add(String film) {
        String[] newFilms = Arrays.copyOf(films, films.length + 1);
        newFilms[newFilms.length - 1] = film;
        films = newFilms;
    }

    // Получение всех фильмов в порядке добавления
    public String[] findAll() {
        return Arrays.copyOf(films, films.length);
    }

    // Получение последних фильмов в обратном порядке
    public String[] findLast() {
        int resultLength = Math.min(films.length, limit);
        String[] result = new String[resultLength];

        for (int i = 0; i < resultLength; i++) {
            result[i] = films[films.length - 1 - i];
        }
        return result;
    }
}