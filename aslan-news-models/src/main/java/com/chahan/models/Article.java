package com.chahan.models;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Article {

    private Long id;
    private String title;
    private String text;
    private LocalDateTime date;
    private User author;

    public Article(String title, String text, LocalDateTime date) {
        this.title = title;
        this.text = text;
        this.date = date;
    }

    public Article(String title) {
        this.title = title;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
