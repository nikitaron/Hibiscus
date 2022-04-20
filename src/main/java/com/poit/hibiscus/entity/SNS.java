package com.poit.hibiscus.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "sns")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class SNS {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "succession")
    private String succession;

}
