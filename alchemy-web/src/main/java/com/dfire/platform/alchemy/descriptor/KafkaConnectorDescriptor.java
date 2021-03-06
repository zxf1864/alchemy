package com.dfire.platform.alchemy.descriptor;

import com.dfire.platform.alchemy.common.Constants;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import org.apache.flink.api.common.serialization.DeserializationSchema;
import org.apache.flink.streaming.connectors.kafka.KafkaTableSource;
import org.apache.flink.streaming.connectors.kafka.KafkaTableSourceBase;
import org.apache.flink.streaming.connectors.kafka.config.StartupMode;
import org.apache.flink.streaming.connectors.kafka.internals.KafkaTopicPartition;
import org.apache.flink.table.api.TableSchema;
import org.apache.flink.table.sources.RowtimeAttributeDescriptor;
import org.apache.flink.types.Row;

/**
 * for kafka >= 1.0.0
 *
 * @author congbai
 */
public class KafkaConnectorDescriptor extends KafkaBaseConnectorDescriptor {

    @Override
    public String type() {
        return Constants.CONNECTOR_TYPE_VALUE_KAFKA;
    }

    @Override KafkaTableSourceBase newTableSource(TableSchema schema, Optional<String> proctimeAttribute,
        List<RowtimeAttributeDescriptor> rowtimeAttributeDescriptors, Optional<Map<String, String>> fieldMapping,
        String topic, Properties properties, DeserializationSchema<Row> deserializationSchema, StartupMode startupMode,
        Map<KafkaTopicPartition, Long> specificStartupOffsets) {
        return  new KafkaTableSource(
            schema,
            proctimeAttribute,
            rowtimeAttributeDescriptors,
            fieldMapping,
            topic,
            properties,
            deserializationSchema,
            startupMode,
            specificStartupOffsets
        );
    }
}
