package com.example.aop.models;

import com.example.aop.models.embedded.AddressEmbedded;
import com.example.aop.models.embedded.NameEmbedded;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_users")
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class User extends Base<Long> {

    @AttributeOverrides({
        @AttributeOverride(name = "lastName", column = @Column(name = "familyName"))
    })
    private NameEmbedded name;
    
    @AttributeOverrides({
        @AttributeOverride(name = "details", column = @Column(name = "complement"))
    })
    private AddressEmbedded address;

    @PrePersist()
    public void onPrePersist() {
        this.name.setName(this.getName().getName().toUpperCase());
    }
}
