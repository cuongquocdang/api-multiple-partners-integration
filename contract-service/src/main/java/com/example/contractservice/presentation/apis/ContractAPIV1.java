package com.example.contractservice.presentation.apis;

import com.example.contractservice.api.V1Contract;
import com.example.contractservice.application.requesthandlers.GetContractDetailsRequestHandler;
import com.example.contractservice.domain.enums.PartnerCode;
import com.example.contractservice.model.ContractDetailsResponseDTO;
import com.example.partner.core.data.ContractDetailsInput;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ContractAPIV1 implements V1Contract {

    private final GetContractDetailsRequestHandler getContractDetailsRequestHandler;

    @Override
    public ContractDetailsResponseDTO getContractDetails(String partnerCode, String contractId) {

        var contract = getContractDetailsRequestHandler.handle(PartnerCode.valueOf(partnerCode), ContractDetailsInput.builder()
                .contractId(contractId)
                .build());

        return new ContractDetailsResponseDTO()
                .contractId(contract.getContractId())
                .contractStatus(contract.getContractStatus())
                .partnerCode(partnerCode);
    }
}
