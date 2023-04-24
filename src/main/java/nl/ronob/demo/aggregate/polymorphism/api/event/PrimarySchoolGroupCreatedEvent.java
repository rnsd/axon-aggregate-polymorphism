package nl.ronob.demo.aggregate.polymorphism.api.event;

import java.util.Objects;

public class PrimarySchoolGroupCreatedEvent {
    public PrimarySchoolGroupCreatedEvent(String schoolId, String groupId) {
        this.schoolId = schoolId;
        this.groupId = groupId;
    }

    String schoolId;
    String groupId;

    public String getSchoolId() {
        return schoolId;
    }

    public String getGroupId() {
        return groupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrimarySchoolGroupCreatedEvent that = (PrimarySchoolGroupCreatedEvent) o;
        return schoolId.equals(that.schoolId) && groupId.equals(that.groupId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schoolId, groupId);
    }
}
