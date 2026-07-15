

class Solution {

    // Encode a list of strings into a single string
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            sb.append(s.length()).append("#").append(s);
        }

        return sb.toString();
    }

    // Decode the encoded string back into a list of strings
    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int j = i;

            // Find the '#' separator
            while (str.charAt(j) != '#') {
                j++;
            }

            // Get the length of the string
            int len = Integer.parseInt(str.substring(i, j));

            // Extract the original string
            String s = str.substring(j + 1, j + 1 + len);
            result.add(s);

            // Move to the next encoded string
            i = j + 1 + len;
        }

        return result;
    }
}