package app.mccall.thomas;

import java.util.Optional;

public class ThomasCore {

    private ThomasDB db;
    private ThomasParser parser;

    public ThomasCore(ThomasDB db, ThomasParser parser) {
        setDB(db);
        setParser(parser);
    }

    public void setDB(final ThomasDB db) {
        this.db = db;
    }

    public void setParser(final ThomasParser parser) {
        this.parser = parser;
    }

    public Optional<String> send(final String message) {
        return Optional.empty();
    }

}
