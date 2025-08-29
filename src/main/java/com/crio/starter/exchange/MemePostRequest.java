package com.crio.starter.exchange;

import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemePostRequest {
    
  @NotBlank(message = "Name cannot be blank")
  private String name;
  
  @NotBlank(message = "Url cannot be blank")
  private String url;
  
  @NotBlank(message = "Caption cannot be blank")
  private String caption;
}
