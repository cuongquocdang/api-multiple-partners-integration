package com.example.xpartner;

import com.example.mavengenerator.xpartner.api.ContractApi;
import com.example.partner.core.ContractData;
import com.example.partner.core.data.ContractDetailsInput;
import com.example.partner.core.data.ContractDetailsOutput;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class XPartnerContractData implements ContractData {

    private final ContractApi contractApi;

    @Override
    public ContractDetailsOutput getContractDetails(final ContractDetailsInput input) {

        var contract = contractApi.getContractDetails(input.getContractId());

        return ContractDetailsOutput.builder()
                .contractId(contract.getContractCode())
                .contractStatus(contract.getContractStatus())
                .build();
    }
}
