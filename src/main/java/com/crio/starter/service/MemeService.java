package com.crio.starter.service;

import com.crio.starter.data.MemeDto;
import com.crio.starter.data.MemeEntity;
import com.crio.starter.exchange.MemePostRequest;
import com.crio.starter.repository.MemeRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class MemeService {

  @Autowired
  private MemeRepository memeRepository;

  /**
   * Creates a new meme and stores it in the database.
   * Checks for duplicate memes before saving.
   *
   * @param request The request containing the meme details.
   * @return The ID of the newly created meme.
   */
  public String createMeme(MemePostRequest request) {
    Optional<MemeEntity> existingMeme = memeRepository
        .findByNameAndUrlAndCaption(request.getName(), request.getUrl(), request.getCaption());

    if (existingMeme.isPresent()) {
      throw new ResponseStatusException(HttpStatus.CONFLICT,
          "Duplicate meme exists with same name, url, and caption.");
    }

    MemeEntity newMeme = new MemeEntity();
    newMeme.setName(request.getName());
    newMeme.setUrl(request.getUrl());
    newMeme.setCaption(request.getCaption());
    newMeme.setPostedAt(System.currentTimeMillis());
    
    MemeEntity savedMeme = memeRepository.save(newMeme);
    return savedMeme.getId();
  }

  /**
   * Fetches the latest 100 memes from the database.
   *
   * @return A list of MemeDto objects.
   */
  public List<MemeDto> getLatestMemes() {
    List<MemeEntity> latestMemes = memeRepository.findTop100ByOrderByPostedAtDesc();
    return latestMemes.stream()
        .map(MemeDto::new)
        .collect(Collectors.toList());
  }

  /**
   * Fetches a single meme by its unique ID.
   *
   * @param id The unique ID of the meme.
   * @return An Optional containing the MemeDto if found.
   */
  public Optional<MemeDto> getMemeById(String id) {
    return memeRepository.findById(id).map(MemeDto::new);
  }
}
