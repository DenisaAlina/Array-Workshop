package se.lexicon;

/**
 * The NameRepository class provides methods to manage a list of names.
 * It offers functionalities such as adding, removing, finding, and updating names.
 */
public class NameRepository {

    private static String[] names = new String[0];


    /**
     * Retrieves the current size of the names array.
     *
     * @return The number of elements in the names array.
     */
    public static int getSize() {
        //todo: PART 1: implement getSize method
        return names.length;
    }


    /**
     * Sets the names array to the provided array of names & it should replace all existing names.
     *
     * param names The array of names to set.
     */
    public static void setNames(String[] newNames) {
        //todo: PART 1: implement setNames method
        names = newNames;
    }


    /**
     * Clears the names array by creating a new empty array.
     */
    public static void clear() {
        //todo: PART 1: implement clear method
        names = new String[0];
    }


    /**
     * Returns all names in a new array (Retrieves a copy of the names array).
     *
     * @return A new array containing all elements from the names array.
     */
    public static String[] findAll() {
        //todo: PART 1: implement findAll method
        return names.clone();
    }


    /**
     * Finds a name that matches the given fullName case-insensitively.
     *
     * @param fullName The full name to search for.
     * @return The matching name if found; otherwise, null.
     */
    public static String find(String fullName) {
        //todo: PART 2: implement find method
        for (String name : names) {
            if (name.equals(fullName)) {
                return name;
            }
        }
        return null;
    }


    /**
     * Adds a new fullName to the names array if it doesn't already exist.
     *
     * @param fullName The full name to add.
     * @return True if the fullName is added successfully; false if it already exists.
     */
    public static boolean add(String fullName) {
        //todo: PART 2: implement add method
        if (find(fullName) != null) {
            return false;
        }
        String[] newNames = new String[names.length + 1];
        System.arraycopy(names, 0, newNames, 0, names.length);
        newNames[names.length] = fullName;
        names = newNames;
        return true;
    }


    /**
     * Find all names that match the given firstName.
     *
     * @param firstName The first name to search for.
     * @return An array containing all matching names.
     */
    public static String[] findByFirstName(String firstName) {
        //todo: PART 3: findByFirstName method
        String[] result = new String[0];
        for (String name : names) {
            if (name.startsWith(firstName + " ")) {
                result = addToArray(result, name);
            }
        }
        return result;
    }


    /**
     * Find all names that match the given lastName.
     *
     * @param lastName The last name to search for.
     * @return An array containing all matching names.
     */
    public static String[] findByLastName(String lastName) {
        //todo: PART 3: implement findByLastName method
        String[] result = new String[0];
        for (String name : names) {
            if (name.endsWith(" " + lastName)) {
                result = addToArray(result, name);
            }
        }
        return result;
    }


    /**
     * Updates a name in the names array from the original name to the updated name.
     *
     * @param original    The original name to update.
     * @param updatedName The updated name to set.
     * @return True if the name is updated successfully; false if the updated name already exists or the original name is not found.
     */
    public static boolean update(String original, String updatedName) {
        //todo: PART 3: implement update method
        int index = indexOf(original);
        if (index != -1 && find(updatedName) == null) {
            names[index] = updatedName;
            return true;
        }
        return false;
    }


    /**
     * Removes a name from the names array, case-insensitively.
     *
     * @param fullName The full name to remove.
     * @return True if the name is removed successfully; false if the name is not found in the array.
     */
    public static boolean remove(String fullName) {
        //todo: PART 4: implement remove method
        int index = indexOf(fullName);
        if (index == -1) {
            return false;
        }
        String[] newNames = new String[names.length - 1];
        for (int i = 0, j = 0; i < names.length; i++) {
            if (i != index) {
                newNames[j++] = names[i];
            }
        }
        names = newNames;
        return true;
    }

    private static int indexOf(final String fullName) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(fullName)) {
                return i;
            }
        }
        return -1;
    }

    private static String[] addToArray(String[] array, String element) {
        String[] newArray = new String[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = element;
        return newArray;
    }


}