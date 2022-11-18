package com.axlabs.boilerplate;

import io.neow3j.protocol.Neow3j;
import io.neow3j.protocol.http.HttpService;

import java.io.IOException;

public class SubscribeToBlocks {

    public static void main(String[] args) throws IOException {

        // Initialize Neow3j to connect to a Neo N3 node.
        Neow3j neow3j = Neow3j.build(new HttpService("http://seed2t5.neo.org:20332"));

        // Subscribe to new blocks on the Neo N3 network.
        neow3j.subscribeToNewBlocksObservable(true)
                .subscribe((blockReqResult) -> {
                    System.out.println("#######################################");
                    System.out.println("# Neo N3 block:");
                    System.out.println("#######################################");
                    System.out.println("Block Index:     " + blockReqResult.getBlock().getIndex());
                    System.out.println("Block Hash:      " + blockReqResult.getBlock().getHash());
                    System.out.println("Prev Block Hash: " + blockReqResult.getBlock().getPrevBlockHash());
                    System.out.println("Next Consensus:  " + blockReqResult.getBlock().getNextConsensus());
                    System.out.println("Transactions:    " + blockReqResult.getBlock().getTransactions().size());
                });

        // Initialize Neow3j to connect to a Neo Legacy node.
        io.neow3j.legacy.protocol.Neow3j neow3jLegacy =
                io.neow3j.legacy.protocol.Neow3j.build(
                        new io.neow3j.legacy.protocol.http.HttpService("http://seed1.ngd.network:10332"));

        // Subscribe to new blocks on the Neo Legacy network.
        neow3jLegacy.catchUpToLatestAndSubscribeToNewBlocksObservable(io.neow3j.legacy.protocol.core.BlockParameterName.LATEST, true)
            .subscribe((blockReqResult) -> {
                System.out.println("#######################################");
                System.out.println("# Neo Legacy block:");
                System.out.println("#######################################");
                System.out.println("Block Index:    " + blockReqResult.getBlock().getIndex());
                System.out.println("Block Hash:     " + blockReqResult.getBlock().getHash());
                System.out.println("Confirmations:  " + blockReqResult.getBlock().getConfirmations());
                System.out.println("Transactions:   " + blockReqResult.getBlock().getTransactions().size());
            });
    }

}
