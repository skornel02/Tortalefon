package me.skornel.tortalefon.callback;

public enum CallbackType {

    DUMMY("Testing"),
    FIX_ADDRESS("Fix ip address"),
    DYNAMIC_ADDRESS("Dynamic ip address (like a phone)");

    private String description;

    CallbackType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static CallbackType[] getValues(){
        return CallbackType.values();
    }
}
