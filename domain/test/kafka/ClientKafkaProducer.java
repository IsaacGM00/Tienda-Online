@Service
public class ClientKafkaProducer {

    private final KafkaTemplate<String, Client> kafkaTemplate;

    @Value("${kafka.topic.client}")
    private String topic;

    public ClientKafkaProducer(KafkaTemplate<String, Client> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendClientCreatedEvent(Client client) {
        kafkaTemplate.send(topic, client);
    }
}