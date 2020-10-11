package ar.com.ada.api.pooflixmongo.repos;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.pooflixmongo.entities.Actor;

@Repository
public interface ActorRepository extends MongoRepository<Actor, ObjectId> {
    Actor findByNombre(String nombre);
}
