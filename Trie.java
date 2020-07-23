import java.util.HashMap;
import java.util.Map;

public class TrieNode {

	static class Trie {
		Map<Character, Trie> children;
		Boolean eow;

		public Trie() {
			children = new HashMap();
			eow = false;
		}
	}

	static Trie root = new Trie();

	static void insertTrie(String key) {

		Trie xTrie = root;

		char[] characters = key.toCharArray();

		for (char c : characters) {
			Trie node = xTrie.children.get(c);
			if (node == null) {
				node = new Trie();
				xTrie.children.put(c, node);
			}

			xTrie = node;
		}

		xTrie.eow = true;

	}

	static boolean prefix(String word) {

		Trie xTrie = root;

		char[] characters = word.toCharArray();

		for (char c : characters) {

			Trie node = xTrie.children.get(c);
			if (node == null)
				return false;

			xTrie = node;
		}

		return true;
	}

	static boolean whole(String word) {
		Trie xTrie = root;

		char[] characters = word.toCharArray();

		for (char c : characters) {

			Trie node = xTrie.children.get(c);
			if (node == null)
				return false;

			xTrie = node;
		}

		return xTrie.eow;
	}

	public static void main(String[] args) {

		String keys[] = { "the", "a", "there", "answer", "any", "by", "bye", "their" };

		for (String key : keys) {
			insertTrie(key);
		}

		System.out.println(prefix("and"));

	}

}
