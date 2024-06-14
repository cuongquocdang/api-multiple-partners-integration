package com.example.ypartner;

import com.example.mavengenerator.ypartner.api.ContractApi;
import com.example.partner.core.ContractData;
import com.example.partner.core.data.ContractDetailsInput;
import com.example.partner.core.data.ContractDetailsOutput;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class YPartnerContractData implements ContractData {

    private final ContractApi contractApi;

    @Override
    public ContractDetailsOutput getContractDetails(final ContractDetailsInput input) {

        var contract = contractApi.getContractDetails(input.getContractId());

        return ContractDetailsOutput.builder()
                .contractId(contract.getContractCode())
                .contractStatus(contract.getStatus())
                .build();
    }
}
