package com.example.contractservice.infrastructure.httpclients;

import com.example.mavengenerator.xpartner.api.ContractApi;
import com.example.mavengenerator.zpartner.api.ApplicationApi;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import org.zalando.logbook.Logbook;
import org.zalando.logbook.spring.LogbookClientHttpRequestInterceptor;

@Configuration
@RequiredArgsConstructor
public class HttpClientServiceConfig {

    private final Logbook logbook;

    @Bean("zApplicationApi")
    public ApplicationApi zApplicationApi(final RestClient.Builder restClientBuilder,
                                          @Value("${z-partner.base-url}") final String baseUrl) {

        var restClient = restClientBuilder
                .baseUrl(baseUrl)
                .requestInterceptor(new LogbookClientHttpRequestInterceptor(logbook))
                .build();

        var httpServiceProxyFactory =
                HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient))
                        .build();

        return httpServiceProxyFactory.createClient(ApplicationApi.class);
    }


    @Bean("xContractApi")
    public ContractApi xContractApi(final RestClient.Builder restClientBuilder,
                                    @Value("${z-partner.base-url}") final String baseUrl) {

        var restClient = restClientBuilder
                .baseUrl(baseUrl)
                .requestInterceptor(new LogbookClientHttpRequestInterceptor(logbook))
                .build();

        var httpServiceProxyFactory =
                HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient))
                        .build();

        return httpServiceProxyFactory.createClient(ContractApi.class);
    }

    @Bean("yContractApi")
    public com.example.mavengenerator.ypartner.api.ContractApi yContractApi(final RestClient.Builder restClientBuilder,
                                                                            @Value("${z-partner.base-url}") final String baseUrl) {

        var restClient = restClientBuilder
                .baseUrl(baseUrl)
                .requestInterceptor(new LogbookClientHttpRequestInterceptor(logbook))
                .build();

        var httpServiceProxyFactory =
                HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient))
                        .build();

        return httpServiceProxyFactory.createClient(com.example.mavengenerator.ypartner.api.ContractApi.class);
    }
}
