package JavaCook;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_12{
    /**
     * @TimeComplexity O(1) because the value range is bounded (up to 3999) and array size is constant.
     * @SpaceComplexity O(1) auxiliary space, bounded by the maximum length of the result string.
     */
    public String intToRoman(int num) {
        int[] refer = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] roman = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        int idx = 0;
        StringBuilder sb = new StringBuilder();
        while(num != 0 && idx < refer.length){
            if(num >= refer[idx]){
                sb.append(roman[idx]);
                num = num - refer[idx];
            }else{
                idx++;
            }
        }

        return sb.toString();
    }

    /**
     * @TimeComplexity O(1) because the value range is bounded (up to 3999) and array size is constant.
     * @SpaceComplexity O(1) auxiliary space, bounded by the maximum length of the result string.
     */
    private static final int[] VALUES = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
    private static final String[] SYMBOLS = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    public String intToRoman_google_l4(int num) {
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        while(num != 0 && idx < VALUES.length){
            while(num >= VALUES[idx]){
                sb.append(SYMBOLS[idx]);
                num = num - VALUES[idx];
            }
            idx++;
        }

        return sb.toString();
    }
}