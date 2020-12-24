package com.amazonaws.services.dynamodbv2.springboot.autoconfigure;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.socialsignin.spring.data.dynamodb.config.AbstractDynamoDBConfiguration;
import org.socialsignin.spring.data.dynamodb.core.DynamoDBOperations;
import org.socialsignin.spring.data.dynamodb.repository.config.DynamoDBRepositoryConfigExtension;
import org.socialsignin.spring.data.dynamodb.repository.support.DynamoDBRepositoryFactoryBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration(proxyBeanMethods = false)
@ConditionalOnProperty(prefix = "spring.data.dynamodb.repositories", name = "enabled", havingValue = "true",
        matchIfMissing = true)
@ConditionalOnClass({DynamoDBOperations.class, AbstractDynamoDBConfiguration.class})
@ConditionalOnMissingBean({ DynamoDBRepositoryFactoryBean.class, DynamoDBRepositoryConfigExtension.class })
@Import(DynamoDBRepositoriesRegistrar.class)
public class DynamoDBRepositoriesAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(AmazonDynamoDB.class)
    public AmazonDynamoDB amazonDynamoDB() {
        return AmazonDynamoDBClientBuilder.standard()
                .build();
    }

}
