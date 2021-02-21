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
public class TraccarServerDto {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("mapUrl")
    private String mapUrl;

    @JsonProperty("zoom")
    private int zoom;

    @JsonProperty("version")
    private String version;

    @JsonProperty("cpuUsage")
    private float cpuUsage;

    @JsonProperty("diskUsage")
    private float diskUsage;
}
