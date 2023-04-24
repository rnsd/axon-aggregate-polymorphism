package nl.ronob.demo.aggregate.polymorphism.api.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Objects;

public class CreateSchoolCommand {

    public CreateSchoolCommand(String schoolId) {
        this.schoolId = schoolId;
    }

    @TargetAggregateIdentifier
    String schoolId;

    public String getSchoolId() {
        return schoolId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateSchoolCommand that = (CreateSchoolCommand) o;
        return Objects.equals(schoolId, that.schoolId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schoolId);
    }
}
