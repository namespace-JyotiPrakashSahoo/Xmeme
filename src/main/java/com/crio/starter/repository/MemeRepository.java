package com.crio.starter.repository;

import com.crio.starter.data.MemeEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemeRepository extends MongoRepository<MemeEntity, String> {
  Optional<MemeEntity> findByNameAndUrlAndCaption(String name, String url, String caption);

  List<MemeEntity> findTop100ByOrderByPostedAtDesc();
}