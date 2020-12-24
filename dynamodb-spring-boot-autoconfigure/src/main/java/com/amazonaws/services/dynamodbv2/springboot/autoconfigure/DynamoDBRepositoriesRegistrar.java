package com.amazonaws.services.dynamodbv2.springboot.autoconfigure;

import org.socialsignin.spring.data.dynamodb.repository.config.DynamoDBRepositoryConfigExtension;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.autoconfigure.data.AbstractRepositoryConfigurationSourceSupport;
import org.springframework.data.repository.config.RepositoryConfigurationExtension;

import java.lang.annotation.Annotation;

public class DynamoDBRepositoriesRegistrar extends AbstractRepositoryConfigurationSourceSupport {

    @Override
    protected Class<? extends Annotation> getAnnotation() {
        return EnableDynamoDBRepositories.class;
    }

    @Override
    protected Class<?> getConfiguration() {
        return EnableDynamoDBRepositoriesConfiguration.class;
    }

    @Override
    protected RepositoryConfigurationExtension getRepositoryConfigurationExtension() {
        return new DynamoDBRepositoryConfigExtension();
    }

    @EnableDynamoDBRepositories
    private static class EnableDynamoDBRepositoriesConfiguration {

    }
}
