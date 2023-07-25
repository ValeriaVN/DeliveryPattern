package ru.netology.deliverypattern.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
    public static String generateCity() {
        var cities = new String []{"Санкт-Петербург", "Новосибирск","Екатеринбург", "Нижний Новгород", "Казань",
                "Казань", "Самара", "Челябинск", "Омск", "Ростов-на-Дону", "Уфа", "Красноярск", "Пермь", "Волгоград",
                "Воронеж", "Саратов", "Краснодар", "Тольятти", "Тюмень", "Ижевск", "Барнаул", "Ульяновск", "Иркутск",
                "Владивосток", "Ярославль", "Хабаровск", "Махачкала", "Оренбург", "Томск", "Новокузнецк", "Кемерово",
                "Астрахань", "Рязань", "Набережные Челны", "Пенза"
        };
        return cities[new Random().nextInt(cities.length)];
    }

    public static String generateName() {
        var faker = new Faker(new Locale("ru"));
        return faker.name().lastName() + " " +faker.name().firstName();
    }

    public static String generatePhone() {
        var faker = new Faker(new Locale("ru"));
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(), generateName(), generatePhone());
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
