package nl.ronob.demo.aggregate.polymorphism;

import nl.ronob.demo.aggregate.polymorphism.api.command.CreatePrimarySchoolGroupCommand;
import nl.ronob.demo.aggregate.polymorphism.api.command.CreateSchoolCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.UUID;

@SpringBootApplication
public class AggregatePolymorphismDemoApp {

    @Autowired
    private CommandGateway commandGateway;

    public static void main(String[] args) {
        SpringApplication.run(AggregatePolymorphismDemoApp.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void createSchool() {
        var schoolId = UUID.randomUUID().toString();
        commandGateway.sendAndWait(new CreateSchoolCommand(schoolId));
        commandGateway.sendAndWait(new CreatePrimarySchoolGroupCommand(schoolId, "foo"));
    }
}
