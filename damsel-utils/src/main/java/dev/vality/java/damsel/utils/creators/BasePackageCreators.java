package dev.vality.java.damsel.utils.creators;

import dev.vality.damsel.base.Timer;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BasePackageCreators {

    public static Timer createTimerTimeout(Integer timeout) {
        return Timer.timeout(timeout);
    }

}
