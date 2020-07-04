package ru.job4j.ex;

public class FindEl {
    private static void thr(String msg) throws ElementNotFoundException {
        throw new ElementNotFoundException(msg);
    }

    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int ret = -1;
        String message = "Element not found";
        for (int i = 0; i < value.length; i++) {
            if (value[i].length() < key.length()) {
                thr(message);
            }
            if (value[i].contains(key)) {
                ret = i;
                break;
            }
        }
        if (ret < 0) {
            thr(message);
        }
        return ret;
    }

    public static void main(String[] args) {
        String[] list = new String[]{"One", "Two", "Three", "Four"};
        String k = "abvgdeika"; //"wo"
        try {
            System.out.println(indexOf(list, k));
        } catch (ElementNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
