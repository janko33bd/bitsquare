package io.bitsquare.btc.blockchain;

import com.google.common.util.concurrent.*;
import io.bitsquare.btc.blockchain.providers.FeeProvider;
import io.bitsquare.common.Timer;
import org.bitcoinj.core.Coin;
import org.blackcoinj.pos.BlackcoinMagic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class GetFeeRequest {
    private static final Logger log = LoggerFactory.getLogger(GetFeeRequest.class);
    private Timer timer;
    public GetFeeRequest() {
    }

    public SettableFuture<Coin> request(String transactionId, FeeProvider provider) {
        final SettableFuture<Coin> resultFuture = SettableFuture.create();
        return request(transactionId, provider, resultFuture);
    }

    private SettableFuture<Coin> request(String transactionId, FeeProvider provider, SettableFuture<Coin> resultFuture) {
    	resultFuture.set(Coin.valueOf(BlackcoinMagic.minTxFee));

        return resultFuture;
    }

    private void stopTimer() {
        timer.stop();
        timer = null;
    }
}
