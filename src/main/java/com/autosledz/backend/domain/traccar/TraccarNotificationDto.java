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
public class TraccarNotificationDto {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("type")
    private String type;

    @JsonProperty("always")
    private boolean always;

    @JsonProperty("web")
    private boolean web;

    @JsonProperty("mail")
    private boolean mail;

    @JsonProperty("sms")
    private boolean sms;
}
