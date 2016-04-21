package io.bitsquare.btc.blockchain;

import com.google.common.util.concurrent.SettableFuture;
import com.google.inject.Inject;
import io.bitsquare.app.Log;
import org.bitcoinj.core.Coin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlockchainService {
    private static final Logger log = LoggerFactory.getLogger(BlockchainService.class);

    @Inject
    public BlockchainService() {
    }

    public SettableFuture<Coin> requestFee(String transactionId) {
        Log.traceCall(transactionId);
        final SettableFuture<Coin> resultFuture = SettableFuture.create();
        resultFuture.set(Coin.valueOf(10000));
        return resultFuture;
    }
}
