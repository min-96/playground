package org.hdcd.domain;


import lombok.*;

import javax.persistence.Entity;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserItemId implements Serializable {

    private static final long serialVersionUUID=1L;

    private Long member;
    private Long item;

}
