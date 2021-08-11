package com.chahan.models;

public enum Role {

    USER("user"),
    AUTHOR("author");

    private final String dbValue;

    Role(String dbValue) {
        this.dbValue = dbValue;
    }

    public String getDbValue() {
        return dbValue;
    }

    public static Role getRole(String role) {
        switch (role) {
            case "USER": {
                return USER;
            }
            case "AUTHOR": {
                return AUTHOR;
            }
            default:
                throw new RuntimeException();
        }
    }
}
