package com.poit.hibiscus.service;

import com.poit.hibiscus.entity.Credit;
import com.poit.hibiscus.entity.User;

public interface CreditService {

    Credit saveNew(Credit credit, User user);
}
