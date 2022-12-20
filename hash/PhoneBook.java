

package hash;

import java.util.*;

class PhoneBook {
    public static void main(String[] args) {
        String[] phone_book = { "119", "97674223", "1195524421" };
        // Arrays.sort(phone_book, (a, b) -> a.length() - b.length());
        // boolean result = true;
        // for (int i = 0; i < phone_book.length - 1; i++) {
        //     for (int k = i + 1; k < phone_book.length; k++) {
        //         if (phone_book[i].contains(phone_book[k])) {
        //             result = false;
        //         }
        //     }
        // }
        // result = true;
        boolean result = find(phone_book);
        
        return result;
    }

    public static boolean find(String[] phone_book){
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < phone_book.length; i++)
            map.put(phone_book[i], i);
        for (int i = 0; i < phone_book.length; i++) {
            for (int k = 0; k < phone_book[i].length() ; k++) {
                if (map.containsKey(phone_book[i].substring(0, k) ) ) {
                    return false;
                }
            }
        }
        return true;
    }
}