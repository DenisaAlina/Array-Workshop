package se.lexicon;


public class App {
    public static void main(String[] args) {

        System.out.println("Initial size: " + NameRepository.getSize());

        NameRepository.setNames(new String[]{"Erik Svensson", "Denisa Alina"});
        System.out.println("Size after setting names: " + NameRepository.getSize());

        System.out.println("Find 'Erik Svensson': " + NameRepository.find("Erik Svensson"));
        System.out.println("Find 'John Doe': " + NameRepository.find("John Doe"));

        System.out.println("Add 'John Doe': " + NameRepository.add("John Doe"));
        System.out.println("Size after adding 'John Doe': " + NameRepository.getSize());

        System.out.println("Find all names:");
        for (String name : NameRepository.findAll()) {
            System.out.println(name);
        }

        System.out.println("Find by first name 'Erik':");
        for (String name : NameRepository.findByFirstName("Erik")) {
            System.out.println(name);
        }

        System.out.println("Find by last name 'Alina':");
        for (String name : NameRepository.findByLastName("Alina")) {
            System.out.println(name);
        }

        System.out.println("Update 'John Doe' to 'John Smith': " + NameRepository.update("John Doe", "John Smith"));
        System.out.println("Find all names after update:");
        for (String name : NameRepository.findAll()) {
            System.out.println(name);
        }

        System.out.println("Remove 'Erik Svensson': " + NameRepository.remove("Erik Svensson"));
        System.out.println("Size after removing 'Erik Svensson': " + NameRepository.getSize());
        System.out.println("Find all names after removal:");
        for (String name : NameRepository.findAll()) {
            System.out.println(name);
        }

        NameRepository.clear();
        System.out.println("Size after clear: " + NameRepository.getSize());
    }
    }

