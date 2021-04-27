package com.clearavenue.fdadi.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * The Class UserProfile.
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserProfile {

    @Id
    @EqualsAndHashCode.Exclude
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** The user id. */
    @NotNull
    private String userId;

    /** The password. */
    @NotNull
    private String password;

    /** The medications. */
    @Builder.Default
    @EqualsAndHashCode.Exclude
    @OneToMany
    private List<Medication> medications = new ArrayList<>();

    @Override
    public String toString() {
        return String.format("%s[%s] (%d medications)", userId, id, medications.size());
    }
}
