package com.crio.starter.data;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemeDto {
  private String id;
  private String name;
  private String url;
  private String caption;

  public MemeDto(MemeEntity memeEntity) {
    this.id = memeEntity.getId();
    this.name = memeEntity.getName();
    this.url = memeEntity.getUrl();
    this.caption = memeEntity.getCaption();
  }
}
