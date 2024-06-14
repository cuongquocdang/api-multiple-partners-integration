package com.example.contractservice.application.requesthandlers;

import com.example.contractservice.application.factories.PartnerFactory;
import com.example.contractservice.domain.enums.PartnerCode;
import com.example.partner.core.data.ContractDetailsInput;
import com.example.partner.core.data.ContractDetailsOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetContractDetailsRequestHandler {

    private final PartnerFactory partnerFactory;

    public ContractDetailsOutput handle(final PartnerCode partnerCode,
                                        final ContractDetailsInput input) {

        return partnerFactory.contractData(partnerCode)
                .getContractDetails(ContractDetailsInput.builder()
                        .contractId(input.getContractId())
                        .build());
    }
}
