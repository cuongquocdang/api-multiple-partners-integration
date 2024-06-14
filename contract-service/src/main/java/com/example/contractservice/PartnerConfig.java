package com.example.contractservice;

import com.example.mavengenerator.xpartner.api.ContractApi;
import com.example.mavengenerator.zpartner.api.ApplicationApi;
import com.example.partner.core.ContractData;
import com.example.xpartner.XPartnerContractData;
import com.example.ypartner.YPartnerContractData;
import com.example.zpartner.ZPartnerContractData;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PartnerConfig {

    @Bean("xPartnerContractData")
    public ContractData xPartnerContractData(@Qualifier("xContractApi") final ContractApi contractApi) {
        return new XPartnerContractData(contractApi);
    }

    @Bean("yPartnerContractData")
    public ContractData yPartnerContractData(@Qualifier("yContractApi") final com.example.mavengenerator.ypartner.api.ContractApi contractApi) {
        return new YPartnerContractData(contractApi);
    }

    @Bean("zPartnerContractData")
    public ContractData zPartnerContractData(@Qualifier("zApplicationApi") final ApplicationApi applicationApi) {
        return new ZPartnerContractData(applicationApi);
    }
}