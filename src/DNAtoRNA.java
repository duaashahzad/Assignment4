import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class DNAtoRNA
{
    public static String dNAToRNA(String dna) {
        Queue<Character> dnaQueue = new LinkedList<>();
        Stack<Character> rna = new Stack<>();

        for (int i = 0; i < dna.length(); i++) {
            dnaQueue.add(dna.charAt(i));
        }
            while (!dnaQueue.isEmpty()) {
                char currentNucleo = dnaQueue.poll();

                switch (currentNucleo) {
                    case 'A':
                        rna.push('A');
                        break;
                    case 'C':
                        rna.push('C');
                        break;
                    case 'G':
                        rna.push('G');
                        break;
                    case 'T':
                        rna.push('U');
                        break;
                }
            }

            String transcribedRNA = "";
            while (!rna.isEmpty()) {
                transcribedRNA = rna.pop() + transcribedRNA;
            }
            return transcribedRNA;
    }

    public static void main(String[] args) {
        // Sample Input
        String input1 = "AGCTGGGAAACGTAGGCCTA";
        String input2 = "TTTTTTTTTTGGCGCG";
        String input3 = "CTTTGGGACTAGTAACCCATTTCGGCT";

        // Transcribe and print the RNA sequences
        System.out.println(dNAToRNA(input1)); // Output: AGCUGGGAAACGUAGGCCUA
        System.out.println(dNAToRNA(input2)); // Output: UUUUUUUUUUGGCGCG
        System.out.println(dNAToRNA(input3)); // Output: CUUUGGGACUAGUAACCCAUUUCGGCU
    }
}



