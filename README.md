# kafka-message-processor

A generic framework which allows users to publish and consume messages using Kafka as a message queue. The framework abstracts away the details of subscribing to the queue and serializing/deserializing messages from the queue. Clients just need to implement MessageHandlers for different types of message objects and the framework takes care of concurrent message processing from Kafka.
