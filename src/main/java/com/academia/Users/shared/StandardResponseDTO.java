package com.academia.Users.shared;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StandardResponseDTO{
        private String status;
        private String message;

        public StandardResponseDTO() {}

        public StandardResponseDTO(String status, String message) {
            this.status = status;
            this.message = message;
        }

}
