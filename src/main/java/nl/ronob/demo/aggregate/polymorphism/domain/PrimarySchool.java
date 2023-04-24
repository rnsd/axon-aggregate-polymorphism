package nl.ronob.demo.aggregate.polymorphism.domain;

import nl.ronob.demo.aggregate.polymorphism.api.command.CreatePrimarySchoolGroupCommand;
import nl.ronob.demo.aggregate.polymorphism.api.event.PrimarySchoolGroupCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateMember;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.HashMap;
import java.util.Map;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class PrimarySchool extends School {

    public PrimarySchool() {
    }

    @AggregateMember
    public Map<String, Group> groups = new HashMap<>();

    @CommandHandler
    public void handle(CreatePrimarySchoolGroupCommand command) {
        apply(new PrimarySchoolGroupCreatedEvent(command.getSchoolId(), command.getGroupId()));
    }

    @EventSourcingHandler
    public void handle(PrimarySchoolGroupCreatedEvent event) {
        this.groups.putIfAbsent(event.getSchoolId(), new Group(event.getGroupId()));
    }
}
