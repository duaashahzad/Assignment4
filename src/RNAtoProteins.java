import java.util.HashMap;

public class RNAtoProteins
{
        public static void main(String[] args) {
            String input1 = "AGCUGGGAAACGUAGGCCUA";
            String input2 = "UAAAGAGAAGCCAGC";

            System.out.println(translateRNA(input1));
            System.out.println(translateRNA(input2));
        }

        public static String translateRNA(String rnaSequence) {
        HashMap<String, Character> codonMap = new HashMap<>();

        // Define the codon-to-amino-acid mapping
        codonMap.put("UUU", 'F');
        codonMap.put("UUC", 'F');
        codonMap.put("UUA", 'L');
        codonMap.put("UUG", 'L');
        codonMap.put("UCU", 'S');
        codonMap.put("UCC", 'S');
        codonMap.put("UCA", 'S');
        codonMap.put("UCG", 'S');
        codonMap.put("UAU", 'Y');
        codonMap.put("UAC", 'Y');
        codonMap.put("UAA", '.'); // Stop codon
        codonMap.put("UAG", '.'); // Stop codon
        codonMap.put("UGU", 'C');
        codonMap.put("UGC", 'C');
        codonMap.put("UGA", '.'); // Stop codon
        codonMap.put("UGG", 'W');
        codonMap.put("CUU", 'L');
        codonMap.put("CUC", 'L');
        codonMap.put("CUA", 'L');
        codonMap.put("CUG", 'L');
        codonMap.put("CCU", 'P');
        codonMap.put("CCC", 'P');
        codonMap.put("CCA", 'P');
        codonMap.put("CCG", 'P');
        codonMap.put("CAU", 'H');
        codonMap.put("CAC", 'H');
        codonMap.put("CAA", 'Q');
        codonMap.put("CAG", 'Q');
        codonMap.put("CGU", 'R');
        codonMap.put("CGC", 'R');
        codonMap.put("CGA", 'R');
        codonMap.put("CGG", 'R');
        codonMap.put("AUU", 'I');
        codonMap.put("AUC", 'I');
        codonMap.put("AUA", 'I');
        codonMap.put("AUG", 'M');
        codonMap.put("ACU", 'T');
        codonMap.put("ACC", 'T');
        codonMap.put("ACA", 'T');
        codonMap.put("ACG", 'T');
        codonMap.put("AAU", 'N');
        codonMap.put("AAC", 'N');
        codonMap.put("AAA", 'K');
        codonMap.put("AAG", 'K');
        codonMap.put("AGU", 'S');
        codonMap.put("AGC", 'S');
        codonMap.put("AGA", 'R');
        codonMap.put("AGG", 'R');
        codonMap.put("GUU", 'V');
        codonMap.put("GUC", 'V');
        codonMap.put("GUA", 'V');
        codonMap.put("GUG", 'V');
        codonMap.put("GCU", 'A');
        codonMap.put("GCC", 'A');
        codonMap.put("GCA", 'A');
        codonMap.put("GCG", 'A');
        codonMap.put("GAU", 'D');
        codonMap.put("GAC", 'D');
        codonMap.put("GAA", 'E');
        codonMap.put("GAG", 'E');
        codonMap.put("GGU", 'G');
        codonMap.put("GGC", 'G');
        codonMap.put("GGA", 'G');
        codonMap.put("GGG", 'G');

        StringBuilder result = new StringBuilder();
        //HashMap<String, Character> codonMap = createCodonMap();

        for (int i = 0; i < rnaSequence.length(); i += 3) {
            String codon = rnaSequence.substring(i, Math.min(i + 3, rnaSequence.length()));

            if (codon.length() == 3) {
                char aminoAcid = codonMap.getOrDefault(codon, 'X'); // 'X' for unknown codons
                result.append(aminoAcid);
            } else {
                // If the length of the input is not a multiple of three, end the amino acid sequence with a (.)
                result.append('.');
            }
        }

        return result.toString();
    }


}
