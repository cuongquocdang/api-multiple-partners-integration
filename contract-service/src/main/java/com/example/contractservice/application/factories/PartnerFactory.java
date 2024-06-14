package com.example.contractservice.application.factories;

import com.example.contractservice.domain.enums.PartnerCode;
import com.example.partner.core.ContractData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PartnerFactory {

    private final ContractData xPartnerContractData;
    private final ContractData yPartnerContractData;
    private final ContractData zPartnerContractData;

    public ContractData contractData(final PartnerCode partnerCode) {
        return switch (partnerCode) {
            case X_PARTNER -> xPartnerContractData;
            case Y_PARTNER -> yPartnerContractData;
            case Z_PARTNER -> zPartnerContractData;
        };
    }
}
