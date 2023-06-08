package de.iav.webclient_rnm.model;

public record Student(
        String id,
        String name,
        int age,
        boolean isActiveStudent
) {
}
