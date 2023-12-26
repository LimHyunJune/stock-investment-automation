package com.example.model;

import java.util.List;

public interface CandidateDataFetcher {
    public List<String> getCandidates(String sector) throws InterruptedException;
}
