package com.samuelradz.spring_data_jpa.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

// TODO: This annotation calls the BaseEntity (super class)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Entity
// @Table(name = "AUTHOR_TBL") // Change table name
public class Author extends BaseEntity {

    // TODO: Note that the id is in the BaseEntity class for reusability


    // @Id
    // DEFAULT: strategy = GenerationType.AUTO
    // @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            strategy = GenerationType.TABLE,
//            generator = "author_sequence"
//            generator = "author_id_gen"
    // )

    // Default is author_seq
    // @SequenceGenerator can customise the naming
//    @SequenceGenerator(
//            name = "author_sequence",
//            sequenceName = "author_sequence",
//            allocationSize = 1
//    )
//    @TableGenerator(
//            name = "author_id_gen", // author
//            table = "id_generator",
//            pkColumnName = "id_name", // author
//            valueColumnName = "id_value",
//            allocationSize = 1
//    )
    // private Integer id;

    @Column(
            name = "f_name",
            length = 35
    )
    private String firstName;

    private String lastName;

    // Control over tables / entities in the db
    @Column(
            unique = true,
            nullable = false
    )
    private String email;

    private int age;

    // Course is the owner of the relationship
        // mappedBy = "authors" is needed.
    @ManyToMany(mappedBy = "authors")
    private List<Course> courses;

}
