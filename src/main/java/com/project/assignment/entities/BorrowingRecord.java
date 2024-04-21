package com.project.assignment.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class BorrowingRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable=false)
    private LocalDate borrowingDate;

    private LocalDate returnDate;

    @ManyToOne
    @JoinColumn(name = "PATRON_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_BorrowingRecord_Patron"))
    private Patron patron;

    @ManyToOne
    @JoinColumn(name = "BOOK_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_BorrowingRecord_Book"))
    private Book book;
}
