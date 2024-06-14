package com.example.zpartner;

import com.example.mavengenerator.zpartner.api.ApplicationApi;
import com.example.partner.core.ContractData;
import com.example.partner.core.data.ContractDetailsInput;
import com.example.partner.core.data.ContractDetailsOutput;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ZPartnerContractData implements ContractData {

    private final ApplicationApi applicationApi;

    @Override
    public ContractDetailsOutput getContractDetails(final ContractDetailsInput input) {

        var application = applicationApi.getApplicationDetails(input.getContractId());

        return ContractDetailsOutput.builder()
                .contractId(application.getApplicationCode())
                .contractStatus(application.getApplicationStatus())
                .build();
    }
}
