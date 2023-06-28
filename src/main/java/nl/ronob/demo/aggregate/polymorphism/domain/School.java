package nl.ronob.demo.aggregate.polymorphism.domain;

import nl.ronob.demo.aggregate.polymorphism.api.command.CreateSchoolCommand;
import nl.ronob.demo.aggregate.polymorphism.api.event.SchoolCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class School {

    public School() {
    }

    @AggregateIdentifier
    private String schoolId;

    @CommandHandler
    public School(CreateSchoolCommand command) {
        apply(new SchoolCreatedEvent(command.getSchoolId()));
    }

    @EventSourcingHandler
    public void handle(SchoolCreatedEvent event) {
        this.schoolId = event.getSchoolId();
    }
}
