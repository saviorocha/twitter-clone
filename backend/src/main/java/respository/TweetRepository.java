package respository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long>{

}
