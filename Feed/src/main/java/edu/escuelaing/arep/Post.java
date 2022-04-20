package edu.escuelaing.arep;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Class that represents a post.
 * @author Camilo Pichimata - Zuly Vargas
 */
public class Post {
    LocalDate datePublication;
    String content;
    AtomicReference<String> author;

    /**
     * Creates a post.
     * @param content
     * @param author
     */
    public Post(String content, AtomicReference<String> author) {
        this.content = content;
        this.author = author;
        this.datePublication = LocalDate.now();
    }

}
