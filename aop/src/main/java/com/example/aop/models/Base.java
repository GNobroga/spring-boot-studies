package com.example.aop.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class Base<K> {
    
    @Id
    private K id;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
      
    @CreationTimestamp
    private LocalDateTime createdAt;
}
