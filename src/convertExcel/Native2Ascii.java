package convertExcel;

public class Native2Ascii {
	/**
     * 네이티브 문자열을 아스키코드 문자열로 변환한다.
     * 
     * @param str
     *            네이티브 문자열
     * @return 아스키코드 문자열
     */
    public static String native2Ascii(String str) {
 
        StringBuffer sb = new StringBuffer(str.length());
        sb.setLength(0);
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            sb.append(native2Ascii(c));
        }
        return (new String(sb));
    }
 
    /**
     * 하나의 네이티브 문자를 아스키코드 문자열로 변환한다.
     * 
     * @param charater
     *            네이티브 문자
     * @return 아스키코드 문자열 StringBuffer
     */
    private static StringBuffer native2Ascii(char charater) {
 
        StringBuffer sb = new StringBuffer();
        if (charater > 255) {
            sb.append("\\u");
            int lowByte = (charater >>> 8);
            sb.append(int2HexString(lowByte));
            int highByte = (charater & 0xFF);
            sb.append(int2HexString(highByte));
        } else {
            sb.append(charater);
        }
        return sb;
    }
 
    /**
     * 정수를 16진수 문자열로 변환한다.
     * 
     * @param code
     *            정수
     * @return 16진수 문자열
     */
    private static String int2HexString(int code) {
 
        String hexString = Integer.toHexString(code);
        if (hexString.length() == 1)
            hexString = "0" + hexString;
        return hexString;
    }

}
