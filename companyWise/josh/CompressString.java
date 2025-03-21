public class CompressString {
    public static String decompress(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            int k = Character.getNumericValue(s.charAt(i));
            char c = s.charAt(i + 1);
            for (int z = 0; z < k; z++) {
                sb.append(c);
            }
            i += 2;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "aaaacccvvvfbbbgggggh";
        StringBuilder sb = new StringBuilder();
        char z = s.charAt(0);
        int freq = 1;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == z) {
                freq++;
            } else {
                sb.append(freq + "" + z);
                z = c;
                freq = 1;
            }
        }
        sb.append(freq + "" + z);
        System.out.println(sb.toString());
        System.out.println("Decompressed : " + decompress(sb.toString()));
    }
}
