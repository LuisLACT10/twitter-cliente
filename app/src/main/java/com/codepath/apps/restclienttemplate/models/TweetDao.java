package com.codepath.apps.restclienttemplate.models;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TweetDao {

    @Query("SELECT Tweet.body AS tweet_body, Tweet.createAt AS tweet_createdAt, Tweet.id AS tweet_id, User.* " +
            " FROM Tweet INNER JOIN User ON Tweet.userId = User.id ORDER BY Tweet.createAt DESC LIMIT 5")
    List<TweetWithUser> recentItems();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertModel(Tweet... tweets);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertModel(User... users);
}
