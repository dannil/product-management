package com.github.dannil.productmanagement.view;

public enum ViewType {

    NORMAL("normal"), FLAT("flat");

    private String type;

    private ViewType(String type) {
        this.type = type;
    }

    public static ViewType ofWithFallback(String type, ViewType fallback) {
        if (type == null || type.isBlank()) {
            return fallback;
        }
        try {
            return ViewType.valueOf(type);
        } catch (IllegalArgumentException e) {
            return fallback;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public String toString() {
        return type;
    }

}
