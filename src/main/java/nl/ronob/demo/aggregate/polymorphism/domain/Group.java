package nl.ronob.demo.aggregate.polymorphism.domain;

import org.axonframework.modelling.command.EntityId;

import java.util.Objects;

public class Group {
    public Group(String schoolId) {
        this.schoolId = schoolId;
    }

    @EntityId
    private String schoolId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return schoolId.equals(group.schoolId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schoolId);
    }
}
