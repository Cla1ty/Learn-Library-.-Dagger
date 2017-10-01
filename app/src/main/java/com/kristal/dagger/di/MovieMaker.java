package com.kristal.dagger.di;

import javax.inject.Inject;

/**
 * Created by Kristal on 9/30/17.
 */

public class MovieMaker {
    public Movie movie;

    @Inject MovieMaker(Movie movie){
        this.movie = movie;
    }
}
