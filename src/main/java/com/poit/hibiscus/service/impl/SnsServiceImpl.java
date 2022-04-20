package com.poit.hibiscus.service.impl;

import com.poit.hibiscus.entity.SNS;
import com.poit.hibiscus.repository.SnsRepository;
import com.poit.hibiscus.service.SnsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SnsServiceImpl implements SnsService {

    private final SnsRepository snsRepository;

    @Override
    public void saveSns(SNS sns) {
        snsRepository.save(sns);
    }
}
