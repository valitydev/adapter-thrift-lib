package com.rbkmoney.java.damsel.utils.creators;

import com.rbkmoney.damsel.base.Timer;
import com.rbkmoney.damsel.domain.Failure;
import com.rbkmoney.damsel.domain.TransactionInfo;
import com.rbkmoney.damsel.msgpack.Value;
import com.rbkmoney.damsel.withdrawals.provider_adapter.FinishIntent;
import com.rbkmoney.damsel.withdrawals.provider_adapter.FinishStatus;
import com.rbkmoney.damsel.withdrawals.provider_adapter.Intent;
import com.rbkmoney.damsel.withdrawals.provider_adapter.ProcessResult;
import com.rbkmoney.damsel.withdrawals.provider_adapter.Success;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static com.rbkmoney.java.damsel.utils.creators.BasePackageCreators.createTimerTimeout;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WithdrawalsProviderAdapterPackageCreators {

    public static com.rbkmoney.damsel.withdrawals.provider_adapter.Intent createIntentWithSleepIntent(Integer timer) {
        return com.rbkmoney.damsel.withdrawals.provider_adapter.Intent.sleep(createSleepIntent(createTimerTimeout(timer)));
    }

    public static com.rbkmoney.damsel.withdrawals.provider_adapter.SleepIntent createSleepIntent(Timer timer) {
        return new com.rbkmoney.damsel.withdrawals.provider_adapter.SleepIntent(timer);
    }

    // ProxyResult
    public static ProcessResult createProcessResult(Intent intent, Value nextState, TransactionInfo transactionInfo) {
        return new ProcessResult(intent).setNextState(nextState).setTrx(transactionInfo);
    }

    public static ProcessResult createProcessResult(Intent intent) {
        return WithdrawalsProviderAdapterPackageCreators.createProcessResult(intent, null, null);
    }

    public static ProcessResult createProcessResult(Intent intent, Value nextStat) {
        return WithdrawalsProviderAdapterPackageCreators.createProcessResult(intent, nextStat, null);
    }

    public static ProcessResult createProcessResult(Intent intent, TransactionInfo transactionInfo) {
        return WithdrawalsProviderAdapterPackageCreators.createProcessResult(intent, null, transactionInfo);
    }

    // FinishIntent
    @Deprecated
    public static Intent createFinishIntentSuccess(TransactionInfo transactionInfo) {
        return Intent.finish(new FinishIntent(createFinishStatusSuccess(transactionInfo)));
    }

    @Deprecated
    public static FinishStatus createFinishStatusSuccess(TransactionInfo transactionInfo) {
        Success success = new com.rbkmoney.damsel.withdrawals.provider_adapter.Success();
        success.setTrxInfo(transactionInfo);
        return FinishStatus.success(success);
    }

    public static FinishStatus createFinishStatusSuccess() {
        return FinishStatus.success(new com.rbkmoney.damsel.withdrawals.provider_adapter.Success());
    }

    public static Intent createFinishIntentFailure(Failure failure) {
        return Intent.finish(new FinishIntent(createFinishStatusFailure(failure)));
    }

    public static ProcessResult createProcessResultFailure(Failure failure) {
        return createProcessResult(createFinishIntentFailure(failure));
    }

    public static ProcessResult createProcessResultFailure(Failure failure, TransactionInfo transactionInfo) {
        return createProcessResult(createFinishIntentFailure(failure), transactionInfo);
    }

    public static FinishStatus createFinishStatusFailure(Failure failure) {
        return FinishStatus.failure(failure);
    }

}
