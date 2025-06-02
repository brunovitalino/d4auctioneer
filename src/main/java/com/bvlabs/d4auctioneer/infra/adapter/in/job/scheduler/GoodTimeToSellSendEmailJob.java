package com.bvlabs.d4auctioneer.infra.adapter.in.job.scheduler;

import com.bvlabs.d4auctioneer.application.usecase.offer.GoodTimeToSellUseCase;
import com.bvlabs.d4auctioneer.infra.adapter.in.job.context.JobContext;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class GoodTimeToSellSendEmailJob {

    private final GoodTimeToSellUseCase sendEmailUseCase;
    private final JobContext JobContext;
    private final String d4TradeToken;

    public GoodTimeToSellSendEmailJob(
            GoodTimeToSellUseCase sendEmailUseCase,
            JobContext JobContext,
            @Value("${feign.dtrade.api.token}") String d4TradeToken
    ) {
        this.sendEmailUseCase = sendEmailUseCase;
        this.JobContext = JobContext;
        this.d4TradeToken = d4TradeToken;
    }

    @PostConstruct
    public void init() {
        execute();
    }

    @Scheduled(cron = "0 0 * * * *") // Executes each hour
    public void execute() {
        try {
            JobContext.setD4TradeToken(d4TradeToken);
            sendEmailUseCase.checkAndWarnGoodTimeToSell();
        } finally {
            JobContext.clear();
        }
    }

}
