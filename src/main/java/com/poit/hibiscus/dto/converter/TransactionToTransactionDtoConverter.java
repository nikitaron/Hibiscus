package com.poit.hibiscus.dto.converter;

import com.poit.hibiscus.dto.TransactionDto;
import com.poit.hibiscus.entity.Transaction;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TransactionToTransactionDtoConverter implements Converter<Transaction, TransactionDto> {

    private final ModelMapper modelMapper;

    @Override
    public TransactionDto convert(Transaction source) {
        return modelMapper.map(source, TransactionDto.class);
    }
}
