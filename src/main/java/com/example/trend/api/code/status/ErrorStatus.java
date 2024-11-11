package com.example.trend.api.code.status;



import com.example.trend.api.code.BaseErrorCode;
import com.example.trend.api.code.ErrorReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {


    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR,"COMMON1001","서버에러, 관리자에게 문의 바랍니다"),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON1002","잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON1003","인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON1004", "금지된 요청입니다."),

    // 멤버 관련 에러
    // 해당 에러코드는 추후 어노테이션으로 수정 할 예정입니다
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "MEMBER3001", "사용자가 없습니다."),
    MEMBER_USERNAME_DUPLICATE(HttpStatus.MULTI_STATUS,"MEMBER3002","중복된 사용자 username입니다"),

    // 기업 관련 에러
    COMPANY_USERNAME_DUPLICATE(HttpStatus.MULTI_STATUS,"MEMBER3002","중복된 기업 username입니다"),


    //토큰 관련 에러
    TOKEN_NOT_INCORRECT(HttpStatus.NOT_FOUND,"TOKEN4001","토큰을 찾을 수 없습니다"),
    TOKEN_EXPIRED(HttpStatus.NOT_FOUND,"TOKEN4002","토큰이 만료되었습니다"),
    TOKEN_NULL(HttpStatus.NOT_FOUND,"TOKEN4003","토큰이 만료되었습니다");




    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build();
    }
}
