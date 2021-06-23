package convertExcel;

public class KeyValuePair {
	/**
     * 키
     */
    private String key;
 
    /**
     * 값
     */
    private String value;
 
    /**
     * 생성자
     * 
     * @param key
     * @param value
     */
    public KeyValuePair(String key, String value) {
 
        super();
        this.key = key;
        this.value = value;
    }
 
    /**
     * 키를 반환한다.
     * 
     * @return 키
     */
    public String getKey() {
 
        return key;
    }
 
    /**
     * 키를 설정한다.
     * 
     * @param key
     *            키
     */
    public void setKey(String key) {
 
        this.key = key;
    }
 
    /**
     * 값을 반환한다.
     * 
     * @return 값
     */
    public String getValue() {
 
        return value;
    }
 
    /**
     * 값을 설정한다.
     * 
     * @param value
     *            값
     */
    public void setValue(String value) {
 
        this.value = value;
    }

}
