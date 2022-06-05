package com.cw.clothesweather.configs

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder

@Configuration
class KafkaTopicConfig(@Value("\${spring.kafka.topics.weather}") private val topic: String) {

    @Bean
    fun weatherProcessTopic(): NewTopic {
        return TopicBuilder.name(topic)
            .build()
    }

}