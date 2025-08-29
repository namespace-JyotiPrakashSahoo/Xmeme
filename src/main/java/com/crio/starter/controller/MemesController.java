package com.crio.starter.controller;

import com.crio.starter.data.MemeDto;
import com.crio.starter.exchange.MemePostRequest;
import com.crio.starter.exchange.MemePostResponse;
import com.crio.starter.service.MemeService;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/memes")
public class MemesController {

  @Autowired
  private MemeService memeService;

  /**
   * Endpoint for posting a new meme.
   *
   * @param request The JSON body containing the meme details.
   * @return ResponseEntity with the ID of the new meme or a 409 conflict.
   */
  @PostMapping("/")
  public ResponseEntity<MemePostResponse> postMeme(@Valid @RequestBody MemePostRequest request) {
    String memeId = memeService.createMeme(request);
    return new ResponseEntity<>(new MemePostResponse(memeId), HttpStatus.CREATED);
  }

  /**
   * Endpoint to fetch the latest 100 memes.
   *
   * @return A list of MemeDto objects. Returns an empty array if no memes exist.
   */
  @GetMapping("/")
  public List<MemeDto> getLatestMemes() {
    return memeService.getLatestMemes();
  }

  /**
   * Endpoint to fetch a single meme by its ID.
   *
   * @param id The unique ID of the meme.
   * @return ResponseEntity with the MemeDto or a 404 Not Found error.
   */
  @GetMapping("/{id}")
  public ResponseEntity<MemeDto> getMemeById(@PathVariable String id) {
    Optional<MemeDto> meme = memeService.getMemeById(id);
    return meme.map(ResponseEntity::ok)
               .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }
}
