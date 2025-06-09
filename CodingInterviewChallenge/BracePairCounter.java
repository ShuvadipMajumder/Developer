public class BracePairCounter {

    /**
     * Counts the number of pairs of braces in a given string.
     * A pair is defined as an opening brace '{' followed by a closing brace '}'.
     *
     * @param input The input string containing braces.
     * @return The number of complete brace pairs found in the input string.
     */
    public static int countBracePairs(String input) {
        int openCount = 0;
        int pairCount = 0;
        for (char ch : input.toCharArray()){
            if (ch == '{') {
                openCount++;
            } else if (ch == '}') {
                if (openCount > 0) {
                    openCount--;
                    pairCount++;
                }
            }
        }
        return pairCount;       
        }

        public static void main (String[] args) {
        String input = "{a{b{c}}d}e{f}g{h{i}}";
        int result = countBracePairs(input);
        System.out.println("Number of brace pairs: " + result);
        }
    }


