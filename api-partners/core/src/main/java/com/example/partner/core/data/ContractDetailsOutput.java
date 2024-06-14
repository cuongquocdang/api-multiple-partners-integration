package com.example.partner.core.data;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ContractDetailsOutput {

    private String contractId;
    private String contractStatus;
}
