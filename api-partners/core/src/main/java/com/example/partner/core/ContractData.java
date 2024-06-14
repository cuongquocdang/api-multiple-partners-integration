package com.example.partner.core;

import com.example.partner.core.data.ContractDetailsInput;
import com.example.partner.core.data.ContractDetailsOutput;

public interface ContractData {

    ContractDetailsOutput getContractDetails(ContractDetailsInput input);
}
