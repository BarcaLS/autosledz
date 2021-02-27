package com.autosledz.backend.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServerDto {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("mapUrl")
    private String mapUrl;

    @JsonProperty("zoom")
    private int zoom;

    @JsonProperty("version")
    private String version;

    @JsonProperty("cpuUsage")
    private Float cpuUsage;

    @JsonProperty("diskUsage")
    private Float diskUsage;
}
