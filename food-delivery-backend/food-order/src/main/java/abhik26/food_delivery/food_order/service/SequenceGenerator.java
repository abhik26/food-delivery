package abhik26.food_delivery.food_order.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import abhik26.food_delivery.food_order.entity.Sequence;

@Service
public class SequenceGenerator {

    private MongoOperations mongoOperations;

    public SequenceGenerator(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public int generateNextOrderId() {
        Sequence counter = mongoOperations.findAndModify(
            query(where("_id").is("sequence")),
            new Update().inc("sequence", 1),
            options().returnNew(true).upsert(true),
            Sequence.class);

        return counter.getSequence();
    }
}
