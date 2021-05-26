package com.softwareEngineering.mdmatravelbackend.common;

import com.softwareEngineering.mdmatravelbackend.exception.MdmaError;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static com.softwareEngineering.mdmatravelbackend.exception.MdmaError.defineError;

@NoArgsConstructor(access = AccessLevel.NONE)
public class ErrorConsts {

    public static final MdmaError INTERNAL_SERVER_ERROR =
            defineError("internal_server_error", "Internal server error");
    public static final MdmaError ACCESS_DENIED_ERROR =
            defineError("access_denied", "Access is denied");
    public static final MdmaError INVALID_INPUT_DATA_ERROR =
            defineError("invalid_input_data", "Invalid input data");
    public static final MdmaError BAD_CREDENTIALS_ERROR =
            defineError("bad_credentials", "Invalid username or password");
}
