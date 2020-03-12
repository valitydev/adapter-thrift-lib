package com.rbkmoney.java.damsel.utils.verification;

import com.rbkmoney.damsel.p2p_adapter.CallbackResult;
import com.rbkmoney.damsel.p2p_adapter.ProcessResult;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class P2pAdapterVerification {

    public static boolean isSuccess(ProcessResult processResult) {
        return processResult.getIntent().getFinish().getStatus().isSetSuccess();
    }

    public static boolean isSuccess(CallbackResult callbackResult) {
        return callbackResult.getIntent().getFinish().getStatus().isSetSuccess();
    }

    public static boolean isSleep(CallbackResult callbackResult) {
        return callbackResult.getIntent().isSetSleep();
    }

    public static boolean isSleep(ProcessResult processResult) {
        return processResult.getIntent().isSetSleep();
    }

    public static boolean isFailure(CallbackResult callbackResult) {
        return callbackResult.getIntent().getFinish().getStatus().isSetFailure();
    }

    public static boolean isFailure(ProcessResult processResult) {
        return processResult.getIntent().getFinish().getStatus().isSetFailure();
    }

}
