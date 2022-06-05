package com.cw.clothesweather.configs

import com.cw.clothesweather.models.WeatherProcess
import org.apache.kafka.clients.producer.ProducerConfig
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory

@Configuration
class KafkaProducerConfig(
    @Value("\${spring.kafka.bootstrap-servers}")
    private val bootstrapServers: String
) {

    fun producerConfig(): Map<String, Any> {
        val props = HashMap<String, Any>()
        props[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = bootstrapServers
        props[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = "org.apache.kafka.common.serialization.StringSerializer"
        props[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] =
            "org.springframework.kafka.support.serializer.JsonSerializer"

        return props
    }

    @Bean
    fun producerFactory(): ProducerFactory<String, WeatherProcess> {
        return DefaultKafkaProducerFactory(producerConfig())
    }

    @Bean
    fun kafkaTemplate(): KafkaTemplate<String, WeatherProcess> {
        return KafkaTemplate(producerFactory())
    }
}