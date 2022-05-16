package com.lti.homeloanapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="document_table")
public class Document {
    @Id
    @Column(name="doc_Id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Doc_GEN")
    @SequenceGenerator(name ="Doc_GEN", sequenceName = "doc_seq_id")
    private Long docId;

    @Column(name="doc_Name")
    private String  docName;

    @Column(name="doc_Path")
    private String docPath;

    @ManyToOne
    private Customer customer;

}
