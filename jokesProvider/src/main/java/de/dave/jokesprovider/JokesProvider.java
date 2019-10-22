package de.dave.jokesprovider;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class JokesProvider {
    private static List<String> jokeList
            = Arrays.asList(
            "What do you get when you wake up on a workday and realize you ran out of coffee? - A depresso.",
            "My dog is an awesome fashion adviser. Every time I ask him what I look like in my clothes, he says",
            "Dentist: You need a crown. - Patient: Finally someone who understands me",
            "What do you call the soft tissue between a shark's teeth? A slow swimmer.",
            "Does your horse smoke? [No.] Well, then I think your stable is burning."
    );

    public static Joke getJoke(int index) {

        Joke joke = new Joke();
        joke.setJoke(jokeList.get(index));

        return joke;
    }

    public static Joke getRandomJoke() {
        int index = generateRandomInteger(0, jokeList.size());
        return getJoke(index);
    }

    private static int generateRandomInteger(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }
}
