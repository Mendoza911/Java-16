package org.example;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String PlayerName) {
        super("Игрок с именем " + PlayerName + " не найден");
    }

}
