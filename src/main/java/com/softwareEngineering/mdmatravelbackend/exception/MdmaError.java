package com.softwareEngineering.mdmatravelbackend.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MdmaError {

    public static final String MDMA_ERROR_KEY = "error";
    public static final String MDMA_DESCRIPTION_KEY = "error_description";
    private static final String APPEND_DELIMITER = ":";

    @JsonProperty(MDMA_ERROR_KEY)
    private final String error;

    @JsonProperty(MDMA_DESCRIPTION_KEY)
    private final String description;

    private MdmaError(String error, String description) {
        this.error = error;
        this.description = description;
    }

    public static MdmaError defineError(String error, String description) {
        return new MdmaError(error, description);
    }

    public String toJsonString() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(this);
    }

}
