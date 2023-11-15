package ru.skypro.homework.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false, length = 64)
    private String description;

    @Column(nullable = false)
    private String image; // Ссылка на изображение, в реальности это может быть URL до изображения

    @OneToMany(mappedBy = "ad", cascade = CascadeType.ALL)
    private List<Comment> comments;

}