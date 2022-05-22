package com.poit.hibiscus.dto.converter;

import com.poit.hibiscus.dto.TransactionDto;
import com.poit.hibiscus.entity.Transaction;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner.Mode;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TransactionDtoToTransactionConverter implements Converter<TransactionDto, Transaction> {

    private final ModelMapper modelMapper;

    @Override
    public Transaction convert(TransactionDto source) {
        return modelMapper.map(source, Transaction.class);
    }
}
