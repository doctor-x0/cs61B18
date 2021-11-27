public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> Deque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            Deque.addFirst(word.charAt(i));
        }
        return Deque;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> Linkedword = wordToDeque(word);
        return isPalindrome_helper(Linkedword);
    }

    public boolean isPalindrome_helper(Deque<Character> word) {
        Character m, n;
        Boolean x = true;
        if (word.size() <= 1) {
            return x;
        } else {
            m = word.removeFirst();
            n = word.removeLast();
            if (m == n) {
                x = true;
                return isPalindrome_helper(word);
            }
            return false;
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> Linkedword = wordToDeque(word);
        return isPalindrome_helper(Linkedword, cc);
    }

    public boolean isPalindrome_helper(Deque<Character> word, CharacterComparator cc) {
        Character m, n;
        Boolean x = true;
        if (word.size() <= 1) {
            return x;
        } else {
            m = word.removeFirst();
            n = word.removeLast();
            if (cc.equalChars(m, n)) {
                return isPalindrome_helper(word, cc);
            }
            return false;
        }
    }
}
