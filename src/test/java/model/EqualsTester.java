package model;

import homework.equalshashcode.*;

public class EqualsTester {
    public static String generateName() {
        String[] names = {"Ivan", "John", "Juan", "Joseph", "Alex", "Maxim", "Victor", "Benjamin", "Vladimir", "Peter",
                "Oleg", "Charles", "George", "David", "Franz", "Fritz", "Albert", "Roman", "Julio", "Tony"};
        String name = names[(int) ((Math.random() * (names.length)))];
        return name;
    }

    public static String generateLastName() {
        String[] lastNames = {"Ivanov", "Weiss", "Smith", "Petrov", "Bykov", "Meyer", "Bruno", "Katz", "Osipov", "Becker",
                "Bauer", "Colbert", "Armand", "Lambert", "Blanchet", "Rossi", "Colombo", "Stafford", "Fischer", "Serov"};
        String lastName = lastNames[(int) ((Math.random() * (lastNames.length)))];
        return lastName;
    }

    public static String generatePublicationTitle() {
        String[] publicationNames = {"Java for beginners", "Algorythms", "Applied Mathematics", "Learn C++ today", "Basic logic",
                "Computer Science", "Advanced Algebra", "Databases"};
        String publicationName = publicationNames[(int) ((Math.random() * (publicationNames.length)))] + " part " + (int) ((Math.random() * 10) + 1);
        return publicationName;
    }

    public static Author[] generateAuthorArray(int length) {
        Author[] authors = new Author[length];
        for (int i = 0; i < length; i++) {
            authors[i] = new Author((long) i + 1, 1, generateName(), generateLastName(), new String[15]);
        }
        return authors;
    }

    public static Publication[] generatePublicationsArray(int length, Author[] authors, int maxAuthorsPerPublication) {
        Publication[] publications = new Publication[length];
        for (int i = 0; i < length; i++) {

                switch (i % 3) {
                    case 0: {
                        publications[i] = new Book(i + 1, 1, generatePublicationTitle(), new Author[(int) ((Math.random()) * maxAuthorsPerPublication + 1)],(int) ((Math.random()) * 1000));
                        break;
                    }
                    case 1: {
                        publications[i] = new BlogPost(i + 1, 1, generatePublicationTitle(), new Author[(int) ((Math.random()) * maxAuthorsPerPublication + 1)],"www.programmingblog.net");
                        break;
                    }

                    case 2: {
                        publications[i] = new MagazineArticle(i + 1, 1, generatePublicationTitle(), new Author[(int) ((Math.random()) * maxAuthorsPerPublication + 1)],"Programming Magazine");
                        break;
                    }

                }

//            publications[i] = new Publication(i + 1, 1, generatePublicationTitle(), new Author[(int) ((Math.random()) * maxAuthorsPerPublication + 1)]);
        }
        for (int i = 0; i < length; i++) {
            Author[] authors1 = new Author[publications[i].getAuthors().length];
            boolean noEquals = true;
            do {
                noEquals = true;
                for (int j = 0; j < publications[i].getAuthors().length; j++) {
                    authors1[j] = authors[(int) (Math.random() * authors.length)];
                }
                for (int j = 0; j < publications[i].getAuthors().length; j++) {
                    for (int k = 0; k < publications[i].getAuthors().length; k++) {
                        if (j != k && authors1[j].equals(authors1[k])) {
                            noEquals = false;
                        }
                    }
                }
            } while (!noEquals);
            publications[i].setAuthors(authors1);
            for (int x = 0; x < authors1.length; x++) {
                authors1[x].updatePublicationNames(publications[i]);
            }
        }
        return publications;
    }

    public static void checkHashCodeAndEquals(Object[] objects) {
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i].toString());
        }
        for (int i = 0; i < objects.length; i++) {
            for (int j = 0; j < objects.length; j++) {
                System.out.println("object " + i + " equals object " + j + " ? - " + objects[i].equals(objects[j]));
                System.out.println("object " + i + " hashcode = " + objects[i].hashCode() + ", " + "object " + j + " hashcode = " + objects[j].hashCode());
            }
        }
    }

    public static void main(String[] args) {
        Author[] authors = generateAuthorArray(25);
        Publication[] publications = generatePublicationsArray(15, authors, 3);
        checkHashCodeAndEquals(publications);
        checkHashCodeAndEquals(authors);
    }
}
