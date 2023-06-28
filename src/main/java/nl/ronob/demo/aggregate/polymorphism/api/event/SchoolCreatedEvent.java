package nl.ronob.demo.aggregate.polymorphism.api.event;

import java.util.Objects;

public class SchoolCreatedEvent {
    public SchoolCreatedEvent(String schoolId) {
        this.schoolId = schoolId;
    }

    String schoolId;

    public String getSchoolId() {
        return schoolId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolCreatedEvent that = (SchoolCreatedEvent) o;
        return schoolId.equals(that.schoolId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schoolId);
    }
}
