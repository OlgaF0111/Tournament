package org.example.Tournament;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String name) {
        super("Игрок" + name + "не найден");
    }
}
