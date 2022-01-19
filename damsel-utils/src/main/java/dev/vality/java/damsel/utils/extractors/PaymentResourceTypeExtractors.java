package dev.vality.java.damsel.utils.extractors;

import dev.vality.damsel.proxy_provider.PaymentContext;
import dev.vality.damsel.proxy_provider.PaymentResource;
import dev.vality.java.damsel.constant.PaymentResourceType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PaymentResourceTypeExtractors {

    public static String extractPaymentResourceType(PaymentContext paymentContext) {
        if (paymentContext == null) {
            throw new IllegalArgumentException("PaymentContext cannot be empty");
        } else if (paymentContext.getSession() == null) {
            throw new IllegalArgumentException("Payment context session cannot be empty");
        }
        return extractPaymentResourceType(paymentContext.getPaymentInfo().getPayment().getPaymentResource());
    }

    private static String extractPaymentResourceType(PaymentResource paymentResource) {
        return (paymentResource.isSetRecurrentPaymentResource())
                ? PaymentResourceType.RECURRENT.name()
                : PaymentResourceType.PAYMENT.name();
    }

}
