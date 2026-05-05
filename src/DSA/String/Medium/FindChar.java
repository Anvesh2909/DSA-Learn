package DSA.String.Medium;

public class FindChar {
    public static String findChar(String s){
        StringBuilder sb = new StringBuilder(s);
        while (sb.length()>1){
            StringBuilder sb1 = new StringBuilder();
            for(int i=0; i<sb.length(); i+=2){
                sb.append(sb.charAt(i));
            }
            sb = sb1;
        }
        return sb.toString();
    }
}
