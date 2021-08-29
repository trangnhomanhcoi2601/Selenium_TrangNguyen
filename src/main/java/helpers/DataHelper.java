package helpers;

import java.util.Random;
import com.github.javafaker.Faker;


public class DataHelper {
    private static final Faker faker = new Faker();
    private static Random randomGenerator = new Random();

    public static String getRandomEmail() {
        int randomInt = randomGenerator.nextInt(1000);
        String randomEmail = "autouser" + String.valueOf(randomInt) + "@gmail.com";
        return randomEmail;
    }
        public static String getRandomPassword() {return faker.letterify("????????");}

        public static String getRandomNumber() {return faker.numerify("########");}

    }


