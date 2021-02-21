package com.autosledz.backend.domain.traccar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class TraccarCommandDto {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("deviceId")
    private Long deviceId;

    @JsonProperty("description")
    private String description;

    @JsonProperty("type")
    private String type;
}
