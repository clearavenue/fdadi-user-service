package com.clearavenue.fdadi.model;

import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * The Class AllPharmClasses.
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PharmClass {

    @Id
    @EqualsAndHashCode.Exclude
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String pharmClassName;

    public static class PharmClassBuilder {
        String pharmClassName;

        public PharmClassBuilder pharmClassName(final String text) {
            this.pharmClassName = text.toUpperCase(Locale.getDefault());
            return this;
        }
    }

}
