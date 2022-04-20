package com.poit.hibiscus.service.impl;

import com.poit.hibiscus.repository.HoldingRepository;
import com.poit.hibiscus.service.HoldingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HoldingServiceImpl implements HoldingService {

    private final HoldingRepository holdingRepository;
}
