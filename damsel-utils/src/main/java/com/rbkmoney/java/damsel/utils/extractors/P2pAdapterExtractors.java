package com.rbkmoney.java.damsel.utils.extractors;

import com.rbkmoney.damsel.domain.BankCard;
import com.rbkmoney.damsel.p2p_adapter.Context;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class P2pAdapterExtractors {

    public static String extractOperationId(Context context) {
        return context.getOperation().getProcess().getId();
    }

    public static String extractSessionId(Context context) {
        return context.getSession().getId();
    }

    public static String extractSenderToken(Context context) {
        return extractBankCardSender(context).getToken();
    }

    public static String extractReceiverToken(Context context) {
        return extractBankCardReceiver(context).getToken();
    }

    public static BankCard extractBankCardSender(Context context) {
        return context.getOperation().getProcess().getSender().getDisposable().getPaymentTool().getBankCard();
    }

    public static BankCard extractBankCardReceiver(Context context) {
        return context.getOperation().getProcess().getReceiver().getDisposable().getPaymentTool().getBankCard();
    }

}
