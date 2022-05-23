package com.poit.hibiscus.dto.converter;

import com.poit.hibiscus.dto.TransactionsDto;
import com.poit.hibiscus.entity.Transactions;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountTransactionDtoToAccountTransactionConverter
        implements Converter<TransactionsDto.AccountTransactionDto, Transactions.AccountTransaction> {
    private final ModelMapper modelMapper;

    @Override
    public Transactions.AccountTransaction convert(TransactionsDto.AccountTransactionDto source) {
        return modelMapper.map(source, Transactions.AccountTransaction.class);
    }
}
