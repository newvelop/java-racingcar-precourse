package enums;

public enum ErrorCode {
    CAR_NAME_LENGTH_OVER(1);

    private Integer code;

    ErrorCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
