package app.mccall.thomas;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

import opennlp.tools.cmdline.parser.ParserTool;
import opennlp.tools.parser.Parse;
import opennlp.tools.parser.Parser;
import opennlp.tools.parser.ParserFactory;
import opennlp.tools.parser.ParserModel;

public class ThomasParser {

    private InputStream parserModelInputStream;
    private ParserModel parserModel;
    private Parser parser;
    private Parse[] parse;

    public ThomasParser(final String dataset) {

        try {
            parserModelInputStream = new FileInputStream(dataset);
            parserModel = new ParserModel(parserModelInputStream);
            parser = ParserFactory.create(parserModel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Optional<String> parse(final String message) {

        parse = ParserTool.parseLine(message, parser, 1);

        return Optional.of(parse.toString());
    }

}
