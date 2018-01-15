package com.lancefallon.springstarter.config.actuator.health;

import com.lancefallon.springstarter.config.jms.JmsTextMessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator implements HealthIndicator {

    @Autowired
    private JmsTextMessageServiceImpl jmsTextMessageServiceImpl;

    @Override
    public Health health() {
        jmsTextMessageServiceImpl.sendTextMessage("##JmsTextMessageServiceImpl::sendTextMessage => sending health update");
        return Health.up().build();
    }

}