package com.holberton.domain.enumeration.jobrequeststatus;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public enum JobRequestStatus {
    ACCEPTED, WAITING, REJECTED
}
