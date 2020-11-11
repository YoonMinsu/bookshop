package com.sku.bookshop.web.dtos;

import com.sku.bookshop.common.Address;
import com.sku.bookshop.domain.member.Member;
import com.sku.bookshop.domain.member.Role;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@Getter
@Setter
public class MemberRequestDto {

    @NotBlank(message = "필수 항목입니다.")
    @Pattern(regexp = "^[a-zA-Z0-9]{8,19}$",
            message = "특수문자를 제외한 3~19자리 이내로 입력해주세요"
    )
    private String userid;

    @NotBlank(message = "필수 항목입니다.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}",
            message = "비밀번호는 숫자와 영어 그리고 특수문자를 포함한 8~20자리 이내로 입력해주세요"
    )
    private String password;

    @NotBlank(message = "필수 항목입니다")
    @Pattern(regexp = "^[가-힣]*$",
            message = "한글만 작성가능합니다."

    )
    private String name;

    @Email(message = "이메일 형식을 맟춰주세요")
    @NotBlank(message = "필수 항목입니다.")
    private String email;

    @NotBlank(message = "필수 항목입니다.")
    @Pattern(regexp = "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$",
            message = "전화번호 형식에 맟춰주세요"
    )
    private String phoneNumber;

    @NotBlank(message = "필수 항목입니다.")
    @Pattern(regexp = "^[0-9]{8,8}$",
    message = "형식에 형식에 맟춰주세요")
    private String birth;

    private String zipcode;

    private String roadAddress;

    private String jibunAddress;

    private String detailAddress;

    public Member toEntity() {
        return Member.builder()
                .userid(userid)
                .password(password)
                .name(name)
                .email(email)
                .phoneNumber(phoneNumber)
                .birth(birth)
                .address(Address.builder()
                        .zipCode(zipcode)
                        .roadAddress(roadAddress)
                        .jibunAddress(jibunAddress)
                        .detailAddress(detailAddress)
                        .build())
                .role(Role.MEMBER.getKey())
                .build();
    }

    public void setEncryptionPassword(String password) {
        this.password = password;
    }
}
