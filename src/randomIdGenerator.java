public class randomIdGenerator {
    // create a 4 character random id mixed with numbers and letters using only uppercase and always with 2 letters and 2 numbers
    public static String generateId() {
        String id = "";
        for (int i = 0; i < 4; i++) {
            if (i % 2 == 0) {
                id += (char) (Math.random() * 26 + 65);
            } else {
                id += (int) (Math.random() * 10);
            }
        }
        return id;
    }
}
