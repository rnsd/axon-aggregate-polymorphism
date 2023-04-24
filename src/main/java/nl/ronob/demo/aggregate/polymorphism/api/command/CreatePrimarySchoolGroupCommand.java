package nl.ronob.demo.aggregate.polymorphism.api.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Objects;

public class CreatePrimarySchoolGroupCommand {

    public CreatePrimarySchoolGroupCommand(String schoolId, String groupId) {
        this.schoolId = schoolId;
        this.groupId = groupId;
    }

    @TargetAggregateIdentifier
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
        CreatePrimarySchoolGroupCommand that = (CreatePrimarySchoolGroupCommand) o;
        return schoolId.equals(that.schoolId) && groupId.equals(that.groupId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schoolId, groupId);
    }
}
