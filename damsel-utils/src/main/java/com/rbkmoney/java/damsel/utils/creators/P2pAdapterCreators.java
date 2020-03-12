package com.rbkmoney.java.damsel.utils.creators;

import com.rbkmoney.damsel.base.Timer;
import com.rbkmoney.damsel.domain.Failure;
import com.rbkmoney.damsel.domain.TransactionInfo;
import com.rbkmoney.damsel.p2p_adapter.*;
import com.rbkmoney.damsel.user_interaction.BrowserGetRequest;
import com.rbkmoney.damsel.user_interaction.BrowserHTTPRequest;
import com.rbkmoney.damsel.user_interaction.BrowserPostRequest;
import com.rbkmoney.java.damsel.utils.extractors.P2pAdapterExtractors;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Map;

import static com.rbkmoney.java.damsel.utils.creators.BasePackageCreators.createTimerTimeout;
import static com.rbkmoney.java.damsel.utils.creators.DomainPackageCreators.createFailure;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class P2pAdapterCreators {

    public static final String SEPARATOR_POINT = ".";

    public static String createTransactionId(Context context) {
        String operationId = P2pAdapterExtractors.extractOperationId(context);
        String sessionId = P2pAdapterExtractors.extractSessionId(context);
        return sessionId + SEPARATOR_POINT + operationId;
    }

    public static Intent createFinishIntentSuccess() {
        FinishIntent finishIntent = new FinishIntent().setStatus(FinishStatus.success(new Success()));
        return Intent.finish(finishIntent);
    }

    public static CallbackResult createP2pCallbackResult(Intent intent, byte[] nextState, TransactionInfo trx) {
        return new CallbackResult().setIntent(intent).setNextState(nextState).setTrx(trx);
    }

    public static CallbackResult createP2pCallbackResultFailure(Failure failure) {
        return new CallbackResult().setIntent(createP2pFinishIntentFailure(failure));
    }

    public static com.rbkmoney.damsel.p2p_adapter.Intent createP2pFinishIntentFailure(Failure failure) {
        return com.rbkmoney.damsel.p2p_adapter.Intent.finish(new com.rbkmoney.damsel.p2p_adapter.FinishIntent(createP2pFinishStatusFailure(failure)));
    }

    public static com.rbkmoney.damsel.p2p_adapter.FinishStatus createP2pFinishStatusFailure(Failure failure) {
        return com.rbkmoney.damsel.p2p_adapter.FinishStatus.failure(failure);
    }

    public static ProcessResult createP2pResult(com.rbkmoney.damsel.p2p_adapter.Intent intent, byte[] nextState, TransactionInfo trx) {
        return new ProcessResult(intent).setNextState(nextState).setTrx(trx);
    }

    public static ProcessResult createP2pResult(com.rbkmoney.damsel.p2p_adapter.Intent intent, byte[] nextState) {
        return createP2pResult(intent, nextState, null);
    }

    public static ProcessResult createP2pResult(com.rbkmoney.damsel.p2p_adapter.Intent intent) {
        return createP2pResult(intent, null, null);
    }

    public static ProcessResult createP2pResultFailure(Failure failure) {
        return new ProcessResult(createFinishIntentFailure(failure));
    }

    public static com.rbkmoney.damsel.p2p_adapter.Intent createFinishIntentFailure(String code, String description) {
        return com.rbkmoney.damsel.p2p_adapter.Intent.finish(new com.rbkmoney.damsel.p2p_adapter.FinishIntent(createP2pFinishStatusFailure(createFailure(code, description))));
    }

    public static com.rbkmoney.damsel.p2p_adapter.Intent createFinishIntentFailure(Failure failure) {
        return com.rbkmoney.damsel.p2p_adapter.Intent.finish(new com.rbkmoney.damsel.p2p_adapter.FinishIntent(createP2pFinishStatusFailure(failure)));
    }

    public static com.rbkmoney.damsel.p2p_adapter.Intent createIntentWithSleepIntent(Integer timer) {
        return com.rbkmoney.damsel.p2p_adapter.Intent.sleep(createSleepIntent(createTimerTimeout(timer)));
    }

    public static com.rbkmoney.damsel.p2p_adapter.Intent createIntentWithSleepIntent(Integer timer, com.rbkmoney.damsel.p2p_adapter.UserInteraction userInteraction, String callbackTag) {
        return com.rbkmoney.damsel.p2p_adapter.Intent.sleep(createSleepIntent(timer, userInteraction, callbackTag));
    }

    public static com.rbkmoney.damsel.p2p_adapter.SleepIntent createSleepIntent(Timer timer) {
        return new com.rbkmoney.damsel.p2p_adapter.SleepIntent(timer);
    }

    public static com.rbkmoney.damsel.p2p_adapter.SleepIntent createSleepIntent(Integer timer, com.rbkmoney.damsel.p2p_adapter.UserInteraction userInteraction, String callbackTag) {
        return createSleepIntent(createTimerTimeout(timer)).setUserInteraction(userInteraction).setCallbackTag(callbackTag);
    }

    // User Interaction
    public static com.rbkmoney.damsel.p2p_adapter.UserInteraction createUserInteraction(String userInteractionID, UserInteractionIntent userInteractionIntent) {
        return new com.rbkmoney.damsel.p2p_adapter.UserInteraction().setId(userInteractionID).setIntent(userInteractionIntent);
    }

    public static com.rbkmoney.damsel.p2p_adapter.UserInteraction createGetUserInteraction(String userInteractionID, String url) {
        com.rbkmoney.damsel.user_interaction.UserInteraction userInteraction = new com.rbkmoney.damsel.user_interaction.UserInteraction();
        userInteraction.setRedirect(createBrowserGetRequest(url));
        return createUserInteractionCreate(userInteractionID, userInteraction);
    }

    public static com.rbkmoney.damsel.p2p_adapter.UserInteraction createPostUserInteraction(String userInteractionID, String url, Map<String, String> params) {
        com.rbkmoney.damsel.user_interaction.UserInteraction userInteraction = new com.rbkmoney.damsel.user_interaction.UserInteraction();
        userInteraction.setRedirect(createBrowserPostRequest(url, params));
        return createUserInteractionCreate(userInteractionID, userInteraction);
    }

    public static com.rbkmoney.damsel.p2p_adapter.UserInteraction createUserInteractionCreate(String userInteractionID, com.rbkmoney.damsel.user_interaction.UserInteraction userInteraction) {
        return createUserInteraction(userInteractionID, UserInteractionIntent.create(new UserInteractionCreate(userInteraction)));
    }

    public static com.rbkmoney.damsel.p2p_adapter.UserInteraction createUserInteractionFinish(String userInteractionID) {
        return createUserInteraction(userInteractionID, UserInteractionIntent.finish(new UserInteractionFinish()));
    }

    public static BrowserHTTPRequest createBrowserPostRequest(String url, Map<String, String> form) {
        return BrowserHTTPRequest.post_request(new BrowserPostRequest(url, form));
    }

    public static BrowserHTTPRequest createBrowserGetRequest(String url) {
        return BrowserHTTPRequest.get_request(new BrowserGetRequest(url));
    }

}
