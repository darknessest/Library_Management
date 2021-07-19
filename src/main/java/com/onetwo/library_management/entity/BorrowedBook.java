package com.onetwo.library_management.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "borrowed_books")
public class BorrowedBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status")
    @Builder.Default
    private BorrowStatus status = BorrowStatus.TAKEN;

    @Column(name = "start_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @Column(name = "end_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private Book book;
}
