package com.crio.starter.repository;

import com.crio.starter.data.MemeEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemeRepository extends MongoRepository<MemeEntity, String> {
  // Find a meme by name, url, and caption to check for duplicates
  Optional<MemeEntity> findByNameAndUrlAndCaption(String name, String url, String caption);

  // Find the latest 100 memes, sorted by postedAt in descending order
  List<MemeEntity> findTop100ByOrderByPostedAtDesc();
}
