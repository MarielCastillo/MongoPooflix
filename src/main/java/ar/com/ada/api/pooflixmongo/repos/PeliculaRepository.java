package ar.com.ada.api.pooflixmongo.repos;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.pooflixmongo.entities.Pelicula;

@Repository
public interface PeliculaRepository extends MongoRepository<Pelicula, ObjectId> {
	Pelicula findByTitulo(String titulo);
}
