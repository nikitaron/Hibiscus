package com.poit.hibiscus.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountLoggerOperation extends AbstractLoggerFactoryAspect.AbstractLoggerOperation {
    @Override
    public void insert() {

    }
}
