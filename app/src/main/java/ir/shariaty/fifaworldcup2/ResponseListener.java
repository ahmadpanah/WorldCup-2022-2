package ir.shariaty.fifaworldcup2;

import ir.shariaty.fifaworldcup2.models.FixtureResponse;

public interface ResponseListener {
    void didFetch(FixtureResponse response , String status);
    void didError(String status);
}
