package dev.vality.java.damsel.constant;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public enum PaymentResourceType {
    RECURRENT,
    PAYMENT
}
