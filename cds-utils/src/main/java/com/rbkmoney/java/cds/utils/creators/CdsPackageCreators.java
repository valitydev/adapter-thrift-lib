package com.rbkmoney.java.cds.utils.creators;

import com.rbkmoney.cds.base.BankCard;
import com.rbkmoney.cds.storage.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CdsPackageCreators {

    public static CardData createCardData(String pan) {
        return new CardData().setPan(pan);
    }

    public static SessionData createSessionData(AuthData authData) {
        return new SessionData(authData);
    }

    public static SessionData createSessionDataWithCvv(String cvv) {
        return new SessionData(createAuthDataWithCardSecurityCode(cvv));
    }

    public static SessionData createSessionDataWithCryptogramAndEci(String cryptogram, String eci) {
        return new SessionData(createAuthDataWithCryptogramAndEci(cryptogram, eci));
    }

    public static AuthData createAuthData(CardSecurityCode cardSecurityCode) {
        return AuthData.card_security_code(cardSecurityCode);
    }

    public static AuthData createAuthDataWithAuth3DS(Auth3DS auth3DS) {
        return AuthData.auth_3ds(auth3DS);
    }


    public static Auth3DS createAuth3DS(String cryptogram, String eci) {
        return new Auth3DS(cryptogram).setEci(eci);
    }

    public static AuthData createAuthDataWithCryptogramAndEci(String cryptogram, String eci) {
        return AuthData.auth_3ds(createAuth3DS(cryptogram, eci));
    }

    public static AuthData createAuthDataWithCardSecurityCode(String cvv) {
        return AuthData.card_security_code(new CardSecurityCode(cvv));
    }

    public static Auth3DS createAuth3DS(String cryptogram) {
        return createAuth3DS(cryptogram, null);
    }

    public static PutCardDataResult createPutCardDataResult(BankCard bankCard, String session) {
        return new PutCardDataResult(bankCard, session);
    }

}