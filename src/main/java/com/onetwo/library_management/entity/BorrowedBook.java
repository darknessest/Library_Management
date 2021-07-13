//package com.onetwo.library_management.entity;
//
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.Date;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@Entity
//@Table(name = "borrowed_books")
//public class BorrowedBook {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "start_date")
//    private Date startDate;
//
//    @Column(name = "end_date")
//    private Date endDate;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "user", referencedColumnName = "id")
//    private User user;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "book", referencedColumnName = "id")
//    private Book books;
//}
