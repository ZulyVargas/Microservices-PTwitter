package edu.escuelaing.arep;

import java.util.ArrayList;

public class Feed {

    ArrayList<Post> posts;

    /**
     * Creates a new feed.
     */
    public Feed() {
        this.posts = new ArrayList<Post>();
    }

    /**
     * Add a new post.
     * @param post - new post to add.
     */
    public void addNewPost(Post post){
        posts.add(post);
    }

    /**
     * Return all the post.
     * @return posts.
     */
    public ArrayList<Post> getPosts(){
        return posts;
    }

}