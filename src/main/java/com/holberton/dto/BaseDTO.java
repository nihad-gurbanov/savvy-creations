package com.holberton.dto;

import com.holberton.domain.BaseEntity;
import lombok.EqualsAndHashCode;

import java.util.Optional;

@EqualsAndHashCode
public abstract class BaseDTO<E extends BaseEntity> {
    public abstract E toEntity(Optional<E> existingEntity);
}
